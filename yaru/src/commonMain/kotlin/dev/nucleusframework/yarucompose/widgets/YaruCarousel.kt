package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.launch

// `_kAnimationDuration` — `Duration(milliseconds: 500)` from
// yaru_carousel.dart `YaruCarouselController.scrollAnimationDuration` (line 250).
private val CarouselAnimationDuration: Duration = 500.milliseconds

// `_kAnimationCurve` — `Curves.easeInOutCubic` from yaru_carousel.dart line 251.
private val CarouselAnimationEasing get() = YaruEasing.EaseInOutCubic

// `_kViewportFraction` — `viewportFraction = 0.8` from
// yaru_carousel.dart line 249, controls the side-peek of neighbouring pages.
private const val CAROUSEL_VIEWPORT_FRACTION: Float = 0.8f

// `_kAutoScrollDuration` — `Duration(seconds: 3)` from
// yaru_carousel.dart `YaruCarouselController.autoScrollDuration` (line 253).
private val CarouselAutoScrollDuration: Duration = 3.seconds

// Floor for the auto-scroll delay. A non-positive duration would let
// `delay` return immediately and re-trigger the page-keyed LaunchedEffect
// in a tight loop. 16 ms ≈ one display frame at 60 Hz, which is the
// shortest interval that still produces a visible animation step.
private const val MIN_AUTO_SCROLL_DELAY_MS: Long = 16L

// `_kInactivePageScale` — `AnimatedScale(scale: 0.9)` for non-active pages
// in yaru_carousel.dart line 157.
private const val CAROUSEL_INACTIVE_PAGE_SCALE: Float = 0.9f

// Default carousel `height` / `width` — yaru_carousel.dart lines 21–22.
internal val CarouselDefaultHeight: Dp = 500.dp
internal val CarouselDefaultWidth: Dp = 500.dp

// Default `placeIndicatorMarginTop` — yaru_carousel.dart line 25.
private val CarouselPlaceIndicatorMarginTop: Dp = 12.dp

// `Size.square(12.0)` — `_kDefaultDotSize` in yaru_page_indicator.dart line 128,
// reused as the carousel's place-indicator dot size.
private val CarouselIndicatorDotSize: Dp = 12.dp

// Carousel navigation button size: rendered as a circular `OutlinedButton`
// (CircleBorder) in yaru_carousel.dart. Yaru does not override the size, so
// Flutter's stock `OutlinedButton.minimumSize` (Size(64,36)) defines the
// touch target. We render a 40dp circle (a common icon-button sizing) since
// Compose has no CircleBorder-shaped OutlinedButton.
private val CarouselNavButtonSize: Dp = 40.dp

// Margin between the navigation button and the carousel edge, matches the
// horizontal padding used by the Compose icon-button overlay.
private val CarouselNavButtonInset: Dp = 8.dp

/**
 * Configuration for [YaruCarousel] — mirrors `YaruCarouselController` from
 * `yaru.dart/lib/src/widgets/yaru_carousel.dart`. The actual paging state is
 * a [PagerState] returned by [rememberYaruCarouselState].
 */
@Immutable
data class YaruCarouselOptions(
    val initialPage: Int = 0,
    val viewportFraction: Float = CAROUSEL_VIEWPORT_FRACTION,
    val scrollAnimationDuration: Duration = CarouselAnimationDuration,
    val scrollAnimationCurve: AnimationSpec<Float> =
        tween(
            CarouselAnimationDuration.inWholeMilliseconds.toInt(),
            easing = CarouselAnimationEasing,
        ),
    val autoScroll: Boolean = false,
    val autoScrollDuration: Duration = CarouselAutoScrollDuration,
)

/** Convenience [PagerState] factory that remembers [pageCount] and [options]. */
@Composable
fun rememberYaruCarouselState(
    pageCount: Int,
    options: YaruCarouselOptions = YaruCarouselOptions(),
): PagerState {
    // `PagerState` requires a non-negative page count; a caller passing a
    // negative value (e.g. derived from a list index that hasn't loaded yet)
    // would otherwise crash inside Compose Foundation.
    val safePageCount = pageCount.coerceAtLeast(0)
    return rememberPagerState(
        initialPage = options.initialPage.coerceIn(0, (safePageCount - 1).coerceAtLeast(0)),
        pageCount = { safePageCount },
    )
}

/**
 * Display a list of pages in a horizontally swipeable carousel with optional
 * navigation buttons and a dot page indicator.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_carousel.dart`.
 */
@Composable
fun YaruCarousel(
    pageCount: Int,
    modifier: Modifier = Modifier,
    height: Dp = CarouselDefaultHeight,
    width: Dp = CarouselDefaultWidth,
    state: PagerState = rememberYaruCarouselState(pageCount),
    options: YaruCarouselOptions = YaruCarouselOptions(),
    placeIndicator: Boolean = true,
    placeIndicatorMarginTop: Dp = CarouselPlaceIndicatorMarginTop,
    navigationControls: Boolean = false,
    previousIcon: (@Composable () -> Unit)? = null,
    nextIcon: (@Composable () -> Unit)? = null,
    // Mirrors Dart `previousIconSemanticLabel` / `nextIconSemanticLabel`
    // (yaru_carousel.dart:29-30). Wraps the nav button with a semantics
    // contentDescription so screen readers announce the button.
    previousIconSemanticLabel: String? = null,
    nextIconSemanticLabel: String? = null,
    // Mirrors Dart `navigationHasFocusBorder` (yaru_carousel.dart:31). When
    // `null`, falls back to the inherited `LocalYaruTheme.focusBorders`
    // (default true).
    navigationHasFocusBorder: Boolean? = null,
    page: @Composable (index: Int) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    // Defensively clamp `pageCount` so a caller passing a negative value (e.g.
    // a stale list index before data loads) cannot underflow `(pageCount - 1)`
    // arithmetic or feed a negative `length` into the page indicator.
    val safePageCount = pageCount.coerceAtLeast(0)

    // Coerce the reported page into the current bounds — when [pageCount]
    // shrinks dynamically (Dart's `didUpdateWidget` clamp at line 106-108),
    // [PagerState.currentPage] can briefly exceed `pageCount-1`. Without this
    // clamp the indicator's `require(page in 0 until length)` would crash.
    val safePage = state.currentPage.coerceIn(0, (safePageCount - 1).coerceAtLeast(0))

    // `rememberUpdatedState` so a caller swapping the `scrollAnimationCurve`
    // (e.g. via a fresh `YaruCarouselOptions(...)` per recomposition) is
    // picked up by long-lived gesture coroutines (e.g. the per-page
    // `pointerInput(index)` block) and the auto-scroll `LaunchedEffect`,
    // neither of which re-keys on `options` identity.
    val currentScrollAnimationCurve by rememberUpdatedState(options.scrollAnimationCurve)

    if (options.autoScroll && safePageCount > 1) {
        // Re-key on `safePage` so any user-initiated page change resets the
        // auto-scroll timer — mirrors `cancelTimer()`/`startTimer()` calls in
        // `YaruCarouselController.animateToPage` / `jumpToPage` (yaru.dart
        // lines 292-312).
        // Floor the delay at a small positive value: `Duration.ZERO` (or any
        // non-positive duration) would let `delay` return immediately, and
        // since this LaunchedEffect re-keys on `safePage` after each
        // `animateScrollToPage`, the result is a tight relaunch loop that
        // pegs a CPU core and starves the frame clock.
        val autoScrollMs = options.autoScrollDuration.inWholeMilliseconds
            .coerceAtLeast(MIN_AUTO_SCROLL_DELAY_MS)
        // Defensive: include `autoScrollMs` in keys so a caller-driven `autoScrollDuration` change restarts the timer with the new delay instead of keeping the stale captured value until the next page change.
        LaunchedEffect(state, options.autoScroll, safePageCount, safePage, autoScrollMs) {
            kotlinx.coroutines.delay(autoScrollMs)
            // Use `safePage` (already clamped to [0, pageCount-1]) so a stale
            // out-of-range `currentPage` cannot produce a negative modulo.
            val next = (safePage + 1) % safePageCount
            state.animateScrollToPage(next, animationSpec = currentScrollAnimationCurve)
        }
    }

    // Mirrors `SizedBox(height: widget.height, child: Column[...])` from
    // yaru_carousel.dart line 121-143: the indicator sits INSIDE the
    // carousel's total height, with the pager taking the remaining space
    // (`Expanded(child: carousel)` in Dart line 200). The Compose equivalent
    // is a fixed-height Column where the pager uses `weight(1f)`.
    // Coerce dimensions to a finite non-negative range — `Modifier.width/height`
    // require `value >= 0.dp`, and a non-finite Dp (NaN / ±Infinity) blows up
    // `roundToPx()` → `Float.roundToInt()`. NaN passes through `< 0f` because
    // NaN comparisons all return false, so guard with `isFinite()` explicitly.
    val safeWidth = if (width.value.isFinite() && width.value >= 0f) width else CarouselDefaultWidth
    val safeHeight = if (height.value.isFinite() && height.value >= 0f) height else CarouselDefaultHeight
    Column(
        modifier = modifier.width(safeWidth).height(safeHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth().weight(1f)) {
            // Side padding implements `viewportFraction` (Dart PageController);
            // 0.8 → 10% padding on each side so neighbours peek around the active page.
            // `viewportFraction` is sanitized into (0f, 1f] — values <= 0,
            // > 1, NaN or Infinity would produce a side padding >= half the
            // viewport width, making `HorizontalPager` crash with "Horizontal
            // padding cannot exceed viewport width". `viewportFraction = 1f`
            // (no peek) keeps padding at zero, matching Flutter's default
            // PageController.
            val rawFraction = options.viewportFraction
            val safeViewportFraction = when {
                !rawFraction.isFinite() -> CAROUSEL_VIEWPORT_FRACTION
                rawFraction <= 0f -> CAROUSEL_VIEWPORT_FRACTION
                rawFraction > 1f -> 1f
                else -> rawFraction
            }
            val rawSidePadding = this.maxWidth * ((1f - safeViewportFraction) / 2f)
            // Belt-and-braces: if rawSidePadding ever lands at or beyond half
            // the viewport (e.g. due to fractional rounding), clamp it.
            val sidePadding = rawSidePadding.coerceAtLeast(0.dp)
            HorizontalPager(
                state = state,
                pageSize = PageSize.Fill,
                contentPadding = PaddingValues(horizontal = sidePadding),
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = !options.autoScroll,
            ) { index ->
                // Defensive: compare against `safePage` (clamped) so a transient out-of-range `state.currentPage` after a `pageCount` shrink does not leave every page rendered as inactive (all scaled down).
                val active = safePage == index
                // Curves.easeInOutCubic / 500 ms — `scrollAnimationCurve` /
                // `scrollAnimationDuration` from yaru_carousel.dart's
                // `YaruCarouselController` (drives `AnimatedScale`, line 156).
                val scale by animateFloatAsState(
                    targetValue = if (active) 1f else CAROUSEL_INACTIVE_PAGE_SCALE,
                    animationSpec = tween(
                        CarouselAnimationDuration.inWholeMilliseconds.toInt(),
                        easing = CarouselAnimationEasing,
                    ),
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(scale)
                        // Tap to navigate when this page is a neighbour.
                        .let {
                            if (!active) {
                                it
                                    // Mirrors Dart `GestureDetector` peek-page tap
                                    // wrapped in an `InkWell` whose default
                                    // `WidgetStateMouseCursor.clickable` resolves
                                    // to `SystemMouseCursors.click` (yaru_carousel.dart
                                    // peek pages are tappable when not active).
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .pointerInput(index) {
                                        detectTapGestures(onTap = {
                                            coroutineScope.launch {
                                                state.animateScrollToPage(
                                                    index,
                                                    animationSpec = currentScrollAnimationCurve,
                                                )
                                            }
                                        })
                                    }
                                    // Defensive: detectTapGestures alone is invisible to TalkBack/VoiceOver — wire matching click semantics so the peek-page tap is exposed as an accessibility action.
                                    .semantics {
                                        role = Role.Button
                                        onClick(label = null) {
                                            coroutineScope.launch {
                                                state.animateScrollToPage(
                                                    index,
                                                    animationSpec = currentScrollAnimationCurve,
                                                )
                                            }
                                            true
                                        }
                                    }
                            } else it
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    page(index)
                }
            }

            if (navigationControls) {
                val showFocusBorder = navigationHasFocusBorder
                    ?: (LocalYaruTheme.current?.focusBorders == true)
                // Defensive: directional `go_previous` / `go_next` glyphs do not auto-mirror — flip the default arrows under RTL so each points toward the visually-correct page-travel direction.
                val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
                val arrowScaleX = if (isRtl) -1f else 1f
                CarouselNavButton(
                    alignment = Alignment.CenterStart,
                    enabled = safePage > 0,
                    animationSpec = options.scrollAnimationCurve,
                    hasFocusBorder = showFocusBorder,
                    semanticLabel = previousIconSemanticLabel,
                    onClick = {
                        coroutineScope.launch {
                            state.animateScrollToPage(
                                safePage - 1,
                                animationSpec = options.scrollAnimationCurve,
                            )
                        }
                    },
                    icon = previousIcon ?: {
                        Box(modifier = Modifier.scale(scaleX = arrowScaleX, scaleY = 1f)) {
                            YaruIcon(YaruIcons.go_previous)
                        }
                    },
                )
                CarouselNavButton(
                    alignment = Alignment.CenterEnd,
                    enabled = safePage < safePageCount - 1,
                    animationSpec = options.scrollAnimationCurve,
                    hasFocusBorder = showFocusBorder,
                    semanticLabel = nextIconSemanticLabel,
                    onClick = {
                        coroutineScope.launch {
                            state.animateScrollToPage(
                                safePage + 1,
                                animationSpec = options.scrollAnimationCurve,
                            )
                        }
                    },
                    icon = nextIcon ?: {
                        Box(modifier = Modifier.scale(scaleX = arrowScaleX, scaleY = 1f)) {
                            YaruIcon(YaruIcons.go_next)
                        }
                    },
                )
            }
        }

        if (placeIndicator && safePageCount > 1) {
            // Guard against a caller passing a negative or non-finite margin —
            // `Spacer` would otherwise crash inside `Modifier.height`. NaN
            // bypasses `< 0f`, so check `isFinite()` first.
            val safeMarginTop = if (
                placeIndicatorMarginTop.value.isFinite() && placeIndicatorMarginTop.value >= 0f
            ) {
                placeIndicatorMarginTop
            } else {
                0.dp
            }
            Spacer(Modifier.height(safeMarginTop))
            // Coerce duration into a non-negative `Int` — `Duration` can hold
            // values that overflow `Int` when converted from `Long` ms, and
            // `tween` requires `durationMillis >= 0`.
            val safeDurationMs = options.scrollAnimationDuration
                .inWholeMilliseconds
                .coerceIn(0L, Int.MAX_VALUE.toLong())
                .toInt()
            val animDp = tween<Dp>(
                durationMillis = safeDurationMs,
                easing = YaruEasing.EaseInOutCubic,
            )
            // The indicator must stretch to the carousel's full width so the
            // SteppedDelegate has the available space it needs to lay the dots
            // out. Without an explicit fillMaxWidth on the row enclosing the
            // builder, parent Columns that wrap content (e.g. those without a
            // fixed-width modifier) would shrink the indicator to its dots'
            // intrinsic width, defeating the centered Row inside the builder.
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                YaruPageIndicatorBuilder(
                    length = safePageCount,
                    page = safePage,
                    onTap = { target ->
                        coroutineScope.launch {
                            state.animateScrollToPage(target, animationSpec = options.scrollAnimationCurve)
                        }
                    },
                    itemSizeBuilder = { _, _, _ ->
                        DpSize(CarouselIndicatorDotSize, CarouselIndicatorDotSize)
                    },
                    itemBuilder = { index, selected, _ ->
                        YaruPageIndicatorItem(
                            selected = index == selected,
                            animationSpec = animDp,
                        )
                    },
                    animationSpec = animDp,
                )
            }
        }
    }
}

/**
 * Circular outlined navigation button used at the carousel's left/right edges.
 * Mirrors `OutlinedButton(shape: CircleBorder, backgroundColor: surface)` from
 * `yaru.dart/lib/src/widgets/yaru_carousel.dart`.
 */
@Composable
private fun BoxScope.CarouselNavButton(
    alignment: Alignment,
    enabled: Boolean,
    animationSpec: AnimationSpec<Float>,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    hasFocusBorder: Boolean = true,
    semanticLabel: String? = null,
) {
    val opacity by animateFloatAsState(if (enabled) 1f else 0f, animationSpec = animationSpec)
    // Defensive: caller-supplied `animationSpec` (e.g. a spring) can overshoot or yield a non-finite tick; `Modifier.alpha` requires `[0f, 1f]`.
    val safeOpacity = if (opacity.isFinite()) opacity.coerceIn(0f, 1f) else 0f
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .alpha(safeOpacity),
        contentAlignment = alignment,
    ) {
        val scheme = LocalYaruColorScheme.current
        val button: @Composable () -> Unit = {
            Box(
                modifier = Modifier
                    .size(CarouselNavButtonSize)
                    // Defensive: skip the semantics node for an empty `semanticLabel` so screen readers do not announce an unnamed image-button.
                    // Defensive: also skip for whitespace-only labels — they would be announced as silence and still install a redundant semantics node.
                    .let { m ->
                        if (!semanticLabel.isNullOrBlank()) {
                            m.semantics { contentDescription = semanticLabel }
                        } else {
                            m
                        }
                    }
                    .clip(CircleShape)
                    // `OutlinedButton.styleFrom(backgroundColor: surface)` —
                    // yaru_carousel.dart line 211.
                    .background(scheme.surface, CircleShape)
                    // Mirrors `_createOutlinedButtonTheme` (common_themes.dart
                    // L171-175): the `OutlinedButton` side resolves to
                    // `outlineVariant` in high-contrast and `outline` otherwise.
                    .border(
                        1.dp,
                        if (scheme.isHighContrast) scheme.outlineVariant else scheme.outline,
                        CircleShape,
                    )
                    .let {
                        if (enabled) {
                            it
                                // Mirrors Flutter's `OutlinedButton.mouseCursor`
                                // default (`WidgetStateMouseCursor.clickable` →
                                // `SystemMouseCursors.click`) used by the
                                // carousel nav button in yaru_carousel.dart.
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = androidx.compose.foundation.LocalIndication.current,
                                    // Defensive: nav button has no text label; explicit Role.Button so TalkBack/VoiceOver announces it as a button rather than an opaque clickable region.
                                    role = Role.Button,
                                    onClick = onClick,
                                )
                        } else it
                    },
                contentAlignment = Alignment.Center,
            ) {
                Box(modifier = Modifier.size(YaruConstants.IconSize)) { icon() }
            }
        }
        Box(modifier = Modifier.padding(horizontal = CarouselNavButtonInset)) {
            if (enabled && hasFocusBorder) {
                YaruFocusBorder(focused = focused, borderShape = CircleShape) { button() }
            } else {
                button()
            }
        }
    }
}
