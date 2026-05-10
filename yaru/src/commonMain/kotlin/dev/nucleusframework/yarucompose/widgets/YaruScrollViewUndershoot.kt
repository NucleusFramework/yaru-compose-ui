package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isLight

// `_kUndershotSize` from yaru_scroll_view_undershoot.dart:4.
private val UndershootSize: Dp = 3.dp
// `_kAnimationDuration` from yaru_scroll_view_undershoot.dart:3.
private const val UndershootAnimationMillis: Int = 150

/** Scroll axis used by [YaruScrollViewUndershoot]. */
enum class YaruScrollAxis { Vertical, Horizontal }

/**
 * Overlays a soft "undershoot" gradient at the start and/or end of a scroll
 * view when its scroll offset isn't pinned to either extreme.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_scroll_view_undershoot.dart`.
 *
 * Pass a [scrollableState] (e.g. a [androidx.compose.foundation.lazy.LazyListState]
 * or any [ScrollableState] that exposes `canScrollForward` / `canScrollBackward`)
 * to drive visibility.
 */
@Composable
fun YaruScrollViewUndershoot(
    scrollableState: ScrollableState,
    modifier: Modifier = Modifier,
    axis: YaruScrollAxis = YaruScrollAxis.Vertical,
    showStart: Boolean = true,
    showEnd: Boolean = true,
    content: @Composable () -> Unit,
) {
    val isLight = LocalYaruColorScheme.current.isLight
    val gradientColor = Color.Black.copy(alpha = if (isLight) 0.1f else 0.3f)

    // Key on `scrollableState` so the derived states re-subscribe when the caller
    // swaps the underlying state instance (e.g. switching between LazyListStates);
    // a keyless `remember` would keep observing the original reference forever.
    val canScrollBackward by remember(scrollableState) {
        derivedStateOf { scrollableState.canScrollBackward }
    }
    val canScrollForward by remember(scrollableState) {
        derivedStateOf { scrollableState.canScrollForward }
    }

    Box(modifier = modifier) {
        content()
        if (showStart) Undershoot(axis, isStart = true, visible = canScrollBackward, color = gradientColor)
        if (showEnd) Undershoot(axis, isStart = false, visible = canScrollForward, color = gradientColor)
    }
}

@Composable
private fun BoxScope.Undershoot(
    axis: YaruScrollAxis,
    isStart: Boolean,
    visible: Boolean,
    color: Color,
) {
    val alignment = when (axis) {
        YaruScrollAxis.Vertical -> if (isStart) Alignment.TopCenter else Alignment.BottomCenter
        YaruScrollAxis.Horizontal -> if (isStart) Alignment.CenterStart else Alignment.CenterEnd
    }
    // Gradient direction mirrors the Dart `LinearGradient(begin: alignment,
    // end: -alignment, colors: [black, transparent])`. For a top/leading band
    // the dark stop sits at the edge, fading to transparent toward the
    // viewport; the trailing band is reversed.
    val brush = when (axis) {
        YaruScrollAxis.Vertical ->
            if (isStart) Brush.verticalGradient(listOf(color, Color.Transparent))
            else Brush.verticalGradient(listOf(Color.Transparent, color))
        YaruScrollAxis.Horizontal ->
            if (isStart) Brush.horizontalGradient(listOf(color, Color.Transparent))
            else Brush.horizontalGradient(listOf(Color.Transparent, color))
    }
    // Linear 150ms fade matches Dart's `AnimatedOpacity` defaults
    // (`Curves.linear`, `_kAnimationDuration`).
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(UndershootAnimationMillis, easing = LinearEasing)),
        exit = fadeOut(animationSpec = tween(UndershootAnimationMillis, easing = LinearEasing)),
        modifier = Modifier.align(alignment),
    ) {
        Box(
            modifier = if (axis == YaruScrollAxis.Vertical) {
                Modifier.fillMaxWidth().height(UndershootSize).background(brush)
            } else {
                Modifier.fillMaxHeight().width(UndershootSize).background(brush)
            },
        )
    }
}
