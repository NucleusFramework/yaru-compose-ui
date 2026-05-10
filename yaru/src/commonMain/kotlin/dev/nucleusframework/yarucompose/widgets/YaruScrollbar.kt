package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isLight
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

// All values mirror Flutter's defaults (material/scrollbar.dart, widgets/scrollbar.dart)
// composed with Yaru's `ScrollbarThemeData` overrides
// (yaru.dart/lib/src/themes/common_themes.dart:783-793).
//
// Yaru theme:
//   mainAxisMargin: 2.0, crossAxisMargin: 2.0,
//   thickness: { hovered/dragged/focused/pressed: 8, any: 4 }
// Material defaults left untouched: radius 8, minThumbLength 48, fade 300/600 ms,
// hover-color animation 200 ms.
private val MainAxisMargin = 2.dp
private val CrossAxisMargin = 2.dp
private val ThicknessIdle = 4.dp
private val ThicknessHover = 8.dp
private val ThumbRadius = 8.dp
private val MinThumbLength = 48.dp
// `_kMinInteractiveSize` (widgets/scrollbar.dart): the radius added around the
// thumb so a faded scrollbar can be brought back into view by mouse proximity.
private val MinInteractiveRadius = 12.dp
// `_kScrollbarFadeDuration` and `_kScrollbarTimeToFade`.
private const val FadeDurationMs = 300
private const val TimeToFadeMs = 600L
// `_MaterialScrollbarState._hoverAnimationController.duration`.
private const val HoverDurationMs = 200

/**
 * Yaru scrollbar — pixel-for-pixel port of Flutter's `Scrollbar` composed with
 * Yaru's `ScrollbarThemeData` (`yaru.dart/lib/src/themes/common_themes.dart:783-793`).
 *
 * Behavior reproduced from `material/scrollbar.dart` + `widgets/scrollbar.dart`:
 *  - Hidden by default; fades in (300 ms) on any scroll activity.
 *  - 600 ms after the scroll stops, fades out (300 ms). Hover or drag pin it visible.
 *  - Thumb thickness snaps 4 → 8 dp on hover/drag (no easing — Flutter resolves
 *    the `WidgetState` thickness map without an animator).
 *  - Thumb color lerps idle → hover over 200 ms; drag color is applied instantly.
 *  - Drag is 1:1 in scroll-pixel space:
 *    `delta_scroll = delta_pointer * scrollableExtent / (trackExtent - thumbExtent)`
 *    matching `_RenderScrollbar.getTrackToScroll`.
 */
@Composable
fun YaruScrollbar(
    state: ScrollableState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val onSurface = scheme.onSurface
    val isLight = scheme.isLight
    // _MaterialScrollbarState._thumbColor (material/scrollbar.dart:230-249).
    val idleColor = onSurface.copy(alpha = if (isLight) 0.1f else 0.3f)
    val hoverColor = onSurface.copy(alpha = if (isLight) 0.5f else 0.65f)
    val dragColor = onSurface.copy(alpha = if (isLight) 0.6f else 0.75f)

    val density = LocalDensity.current
    val scope = rememberCoroutineScope()

    var hoverActive by remember { mutableStateOf(false) }
    var dragActive by remember { mutableStateOf(false) }
    val opacity = remember { Animatable(0f) }
    val hoverAnim = remember { Animatable(0f) }
    var fadeoutJob by remember { mutableStateOf<Job?>(null) }
    var trackSize by remember { mutableStateOf(IntSize.Zero) }

    Box(modifier = modifier) {
        content()

        val indicator = state.scrollIndicatorState
        val viewport = indicator?.viewportSize ?: 0
        val totalSize = indicator?.contentSize ?: 0
        val isScrollable = indicator != null &&
            viewport in 1..<totalSize &&
            totalSize != Int.MAX_VALUE

        // Re-trigger fade-in whenever the scroll offset advances — mirrors
        // `_handleScrollNotification` (widgets/scrollbar.dart:1936-1971) which
        // forwards the fade controller on every ScrollUpdateNotification.
        LaunchedEffect(state, isScrollable) {
            if (!isScrollable) return@LaunchedEffect
            snapshotFlow { state.scrollIndicatorState?.scrollOffset ?: 0 }
                .distinctUntilChanged()
                .collect {
                    fadeoutJob?.cancel()
                    fadeoutJob = null
                    if (opacity.value < 1f) {
                        opacity.animateTo(1f, tween(FadeDurationMs))
                    }
                }
        }

        // Schedule fade-out 600 ms after activity ends — `_maybeStartFadeoutTimer`
        // (widgets/scrollbar.dart:1607-1615). Hover or drag pin the scrollbar.
        val isScrolling = state.isScrollInProgress
        LaunchedEffect(isScrolling, hoverActive, dragActive, isScrollable) {
            if (!isScrollable) {
                fadeoutJob?.cancel()
                opacity.snapTo(0f)
                return@LaunchedEffect
            }
            if (isScrolling || hoverActive || dragActive) {
                fadeoutJob?.cancel()
                fadeoutJob = null
                if (opacity.value < 1f) {
                    opacity.animateTo(1f, tween(FadeDurationMs))
                }
            } else {
                fadeoutJob?.cancel()
                fadeoutJob = scope.launch {
                    delay(TimeToFadeMs)
                    opacity.animateTo(0f, tween(FadeDurationMs))
                }
            }
        }

        // 200 ms idle ↔ hover color ramp (_hoverAnimationController, material/scrollbar.dart:317-320).
        LaunchedEffect(hoverActive || dragActive) {
            hoverAnim.animateTo(
                if (hoverActive || dragActive) 1f else 0f,
                tween(HoverDurationMs),
            )
        }

        if (indicator == null) return@Box

        // Width of the invisible hover strip: thumb + crossAxisMargin + a
        // `_kMinInteractiveSize / 2` proximity halo. Matches the `paddedRect`
        // built in `_ScrollbarPainter.hitTestInteractive`
        // (widgets/scrollbar.dart:744-770).
        val hoverStripWidth = ThicknessHover + CrossAxisMargin + MinInteractiveRadius
        val hoverInteraction = remember { MutableInteractionSource() }
        val hovered by hoverInteraction.collectIsHoveredAsState()
        LaunchedEffect(hovered, isScrollable) { hoverActive = hovered && isScrollable }

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .width(hoverStripWidth)
                .onSizeChanged { trackSize = it }
                .hoverable(hoverInteraction, enabled = isScrollable),
        ) {
            if (!isScrollable || trackSize.height <= 0) return@Box

            val mainMarginPx = with(density) { MainAxisMargin.toPx() }
            val crossMarginPx = with(density) { CrossAxisMargin.toPx() }
            val minLengthPx = with(density) { MinThumbLength.toPx() }
            val radiusPx = with(density) { ThumbRadius.toPx() }
            val thicknessDp = if (hoverActive || dragActive) ThicknessHover else ThicknessIdle

            val trackHeight = trackSize.height.toFloat()
            // `_traversableTrackExtent` (widgets/scrollbar.dart): track minus 2× mainAxisMargin.
            val traversable = (trackHeight - 2f * mainMarginPx).coerceAtLeast(0f)
            val viewportF = viewport.toFloat()
            val totalF = totalSize.toFloat()
            // Thumb extent: viewport / contentSize ratio of the traversable track,
            // clamped to `minThumbLength`. Mirrors `_ScrollbarPainter._thumbExtent`.
            val rawThumbExtent = traversable * (viewportF / totalF)
            val thumbExtent = rawThumbExtent.coerceIn(
                minimumValue = minLengthPx.coerceAtMost(traversable),
                maximumValue = traversable,
            )
            val thumbMovable = (traversable - thumbExtent).coerceAtLeast(0f)
            val maxScroll = (totalF - viewportF).coerceAtLeast(1f)
            val thumbOffsetWithinTrack = (indicator.scrollOffset.toFloat() / maxScroll * thumbMovable)
                .coerceIn(0f, thumbMovable)
            val thumbTopPx = mainMarginPx + thumbOffsetWithinTrack

            // `Color.lerp(idleColor, hoverColor, _hoverAnimationController.value)`
            // (material/scrollbar.dart:262-266); drag overrides without animation.
            val color = if (dragActive) {
                dragColor
            } else {
                lerp(idleColor, hoverColor, hoverAnim.value)
            }

            val thumbHeightDp = with(density) { thumbExtent.toDp() }
            val thumbTopDp = with(density) { thumbTopPx.toDp() }
            val crossMarginDp = with(density) { crossMarginPx.toDp() }
            val radiusDp = with(density) { radiusPx.toDp() }

            // 1:1 drag conversion: `getTrackToScroll`
            // (widgets/scrollbar.dart:678-683) returns `scrollableExtent * dx / movable`.
            val ratioState = rememberUpdatedState(
                if (thumbMovable > 0f) maxScroll / thumbMovable else 0f,
            )
            val draggable = remember {
                DraggableState { delta ->
                    val ratio = ratioState.value
                    if (ratio > 0f) {
                        scope.launch { state.scrollBy(delta * ratio) }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(y = thumbTopDp)
                    .padding(end = crossMarginDp)
                    .size(width = thicknessDp, height = thumbHeightDp)
                    .alpha(opacity.value)
                    .background(color, RoundedCornerShape(radiusDp))
                    .draggable(
                        state = draggable,
                        orientation = Orientation.Vertical,
                        onDragStarted = { dragActive = true },
                        onDragStopped = { dragActive = false },
                    ),
            )
        }
    }
}
