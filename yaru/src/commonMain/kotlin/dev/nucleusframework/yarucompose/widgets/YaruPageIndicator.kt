package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography

// `_kDefaultDotSize` — `Size.square(12.0)` from yaru_page_indicator.dart
// line 128 (`itemSizeBuilder` default).
private val DefaultDotSize: Dp = 12.dp

// `_kDefaultDotSpacing` — `48.0` from yaru_page_indicator_layout_delegate.dart
// line 29 (`YaruPageIndicatorSteppedDelegate.baseItemSpacing` default).
private val SteppedDelegateDefaultSpacing: Dp = 48.dp

// `YaruPageIndicatorFixedDelegate.itemSpacing` default — `24.0` in
// yaru_page_indicator_layout_delegate.dart line 64.
private val FixedDelegateDefaultSpacing: Dp = 24.dp

// `YaruPageIndicatorBoundedDelegate.maxItemSpacing` / `minItemSpacing`
// defaults — 48 / 16 from yaru_page_indicator_layout_delegate.dart lines 95–96.
private val BoundedDelegateMaxSpacing: Dp = 48.dp
private val BoundedDelegateMinSpacing: Dp = 16.dp

// `_kAnimationDuration` — 200ms used by the `yaruDefaultIndicatorAnimation`
// helper. yaru.dart itself defaults to `Duration.zero` (no animation), but
// 200ms is a sensible opt-in for callers that want smooth transitions.
private const val DEFAULT_ANIMATION_DURATION_MILLIS: Int = 200

/**
 * Layout delegate interface controlling a [YaruPageIndicator]'s items spacing.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_page_indicator_layout_delegate.dart`.
 * Returning `null` means there is not enough space and the indicator should
 * fall back to its text-based representation.
 */
fun interface YaruPageIndicatorLayoutDelegate {
    fun calculateItemsSpacing(
        allItemsWidth: Dp,
        length: Int,
        availableWidth: Dp,
    ): Dp?
}

/**
 * Stepped layout delegate: tries [baseItemSpacing], then half, then a quarter,
 * before giving up. Default spacing is 48dp (`_kDefaultDotSpacing`).
 */
class YaruPageIndicatorSteppedDelegate(
    private val baseItemSpacing: Dp = SteppedDelegateDefaultSpacing,
) : YaruPageIndicatorLayoutDelegate {
    override fun calculateItemsSpacing(
        allItemsWidth: Dp,
        length: Int,
        availableWidth: Dp,
    ): Dp? {
        val layouts = listOf(
            baseItemSpacing to availableWidth / 2f,
            baseItemSpacing / 2f to availableWidth / 3f * 2f,
            baseItemSpacing / 4f to availableWidth / 6f * 5f,
        )
        for ((spacing, maxWidth) in layouts) {
            if (allItemsWidth + spacing * (length - 1) < maxWidth) return spacing
        }
        return null
    }
}

/** Fixed-spacing layout delegate. Default spacing is 24dp. */
class YaruPageIndicatorFixedDelegate(
    private val itemSpacing: Dp = FixedDelegateDefaultSpacing,
) : YaruPageIndicatorLayoutDelegate {
    override fun calculateItemsSpacing(
        allItemsWidth: Dp,
        length: Int,
        availableWidth: Dp,
    ): Dp? = if (allItemsWidth + itemSpacing * (length - 1) < availableWidth) itemSpacing else null
}

/** Bounded layout delegate, evenly distributing between [minItemSpacing] and [maxItemSpacing]. */
class YaruPageIndicatorBoundedDelegate(
    private val maxItemSpacing: Dp = BoundedDelegateMaxSpacing,
    private val minItemSpacing: Dp = BoundedDelegateMinSpacing,
) : YaruPageIndicatorLayoutDelegate {
    override fun calculateItemsSpacing(
        allItemsWidth: Dp,
        length: Int,
        availableWidth: Dp,
    ): Dp? {
        if (length <= 1) return maxItemSpacing
        return when {
            allItemsWidth + maxItemSpacing * (length - 1) < availableWidth -> maxItemSpacing
            allItemsWidth + minItemSpacing * (length - 1) > availableWidth -> null
            else -> (availableWidth - allItemsWidth) / (length - 1)
        }
    }
}

/**
 * A responsive page indicator: dots when there is enough space, falls back
 * to a `current/total` text label when the available width is too small.
 *
 * Mirrors the simple `YaruPageIndicator()` constructor from
 * `yaru.dart/lib/src/widgets/yaru_page_indicator.dart`.
 */
@Composable
fun YaruPageIndicator(
    length: Int,
    page: Int,
    modifier: Modifier = Modifier,
    onTap: ((Int) -> Unit)? = null,
    dotSize: Dp? = null,
    dotSpacing: Dp? = null,
    textStyle: TextStyle? = null,
    textBuilder: (@Composable (page: Int, length: Int) -> Unit)? = null,
    animationSpec: AnimationSpec<Dp>? = null,
) {
    // Defensive: a negative or non-finite `dotSize` would propagate to
    // `Modifier.size()` and crash. Fall back to the default in that case.
    val resolvedSize = dotSize?.takeIf { it.value.isFinite() && it.value >= 0f }
        ?: DefaultDotSize
    YaruPageIndicatorBuilder(
        length = length,
        page = page,
        modifier = modifier,
        onTap = onTap,
        itemSizeBuilder = { _, _, _ -> DpSize(resolvedSize, resolvedSize) },
        itemBuilder = { index, selected, _ ->
            YaruPageIndicatorItem(
                selected = index == selected,
                animationSpec = animationSpec,
            )
        },
        textStyle = textStyle,
        textBuilder = textBuilder,
        layoutDelegate = dotSpacing?.let { YaruPageIndicatorSteppedDelegate(it) }
            ?: YaruPageIndicatorSteppedDelegate(),
        animationSpec = animationSpec,
    )
}

/**
 * Builder variant of [YaruPageIndicator] — mirrors `YaruPageIndicator.builder`
 * from yaru.dart, exposing per-item sizing and content.
 */
@Composable
fun YaruPageIndicatorBuilder(
    length: Int,
    page: Int,
    modifier: Modifier = Modifier,
    onTap: ((Int) -> Unit)? = null,
    itemSizeBuilder: (index: Int, selectedIndex: Int, length: Int) -> DpSize = { _, _, _ ->
        DpSize(DefaultDotSize, DefaultDotSize)
    },
    itemBuilder: @Composable (index: Int, selectedIndex: Int, length: Int) -> Unit = { i, s, _ ->
        YaruPageIndicatorItem(selected = i == s)
    },
    textStyle: TextStyle? = null,
    textBuilder: (@Composable (page: Int, length: Int) -> Unit)? = null,
    layoutDelegate: YaruPageIndicatorLayoutDelegate = YaruPageIndicatorSteppedDelegate(),
    animationSpec: AnimationSpec<Dp>? = null,
) {
    require(length >= 0) { "length must be non-negative, was $length" }
    if (length == 0) return
    // Defensive: when `length` shrinks below the current `page` (e.g. caller drops pages mid-frame), clamp instead of throwing — the previous `require(page in 0 until length)` crashed the composition during legitimate transitions.
    val safePage = page.coerceIn(0, length - 1)

    // Defensive: coerce caller-supplied dimensions to non-negative finite values
    // so a misbehaving `itemSizeBuilder` cannot crash `Modifier.size()`.
    val sizes = (0 until length).map {
        val raw = itemSizeBuilder(it, safePage, length)
        val w = if (raw.width.value.isFinite() && raw.width.value >= 0f) raw.width else 0.dp
        val h = if (raw.height.value.isFinite() && raw.height.value >= 0f) raw.height else 0.dp
        DpSize(w, h)
    }
    val maxItemWidth = sizes.maxOf { it.width }

    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val available = this.maxWidth
        val spacing = layoutDelegate.calculateItemsSpacing(
            allItemsWidth = maxItemWidth * length,
            length = length,
            availableWidth = available,
        )

        if (spacing == null) {
            val style = textStyle ?: LocalYaruTypography.current.bodySmall
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                if (textBuilder != null) {
                    textBuilder(safePage + 1, length)
                } else {
                    YaruText(
                        text = "${safePage + 1}/$length",
                        style = style,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                for (index in 0 until length) {
                    val size = sizes[index]
                    // Mirrors `_buildSizedContainer` (yaru_page_indicator.dart
                    // line 205-221): a SizedBox forces the dot's bounds while
                    // the inner `itemBuilder` (a `YaruPageIndicatorItem` with
                    // no explicit size) fills it. `propagateMinConstraints` is
                    // the Compose equivalent of the Dart SizedBox passing its
                    // dimensions down to a sizeless `Container`.
                    Box(
                        modifier = Modifier
                            // Defensive: caller-controlled delegate may yield a non-finite or negative Dp; per-edge `padding` throws on those.
                            .let { if (index != 0) it.padding(start = spacing.sanitise()) else it }
                            .animatedSize(
                                width = size.width,
                                height = size.height,
                                animationSpec = animationSpec,
                            ),
                        contentAlignment = Alignment.Center,
                        propagateMinConstraints = true,
                    ) {
                        // shared MutableInteractionSource — drives focus border, hover overlay, ripple
                        val itemInteraction = remember(index) { MutableInteractionSource() }
                        Box(
                            modifier = if (onTap != null) {
                                Modifier
                                    // Mirrors Dart `MouseRegion(cursor: mouseCursor)`
                                    // in yaru_page_indicator.dart:191-192 — default
                                    // resolves to `SystemMouseCursors.click` via
                                    // `WidgetStateMouseCursor.clickable`.
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable(
                                        interactionSource = itemInteraction,
                                        indication = androidx.compose.foundation.LocalIndication.current,
                                        onClick = { onTap(index) },
                                    )
                            } else Modifier,
                            contentAlignment = Alignment.Center,
                            propagateMinConstraints = true,
                        ) {
                            itemBuilder(index, safePage, length)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Default item used in [YaruPageIndicator]: a circular dot — primary when
 * selected, `onSurface @ 0.6` otherwise. With [borderRadius] non-null it
 * becomes a rounded rectangle (allowing pill-style indicators).
 *
 * Mirrors `YaruPageIndicatorItem` from
 * `yaru.dart/lib/src/widgets/yaru_page_indicator.dart`.
 */
@Composable
fun YaruPageIndicatorItem(
    selected: Boolean,
    modifier: Modifier = Modifier,
    size: DpSize? = null,
    borderRadius: Dp? = null,
    animationSpec: AnimationSpec<Dp>? = null,
    onTap: (() -> Unit)? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val color = if (selected) scheme.primary else scheme.onSurface.copy(alpha = 0.6f)
    // Defensive: `RoundedCornerShape` requires a non-negative radius. Clamp a
    // bad caller value to 0 instead of crashing.
    val shape: Shape = if (borderRadius == null) {
        CircleShape
    } else {
        val safe = if (borderRadius.value.isFinite() && borderRadius.value >= 0f) {
            borderRadius
        } else {
            0.dp
        }
        RoundedCornerShape(safe)
    }
    val sized = if (size != null) {
        // Defensive: clamp non-finite / negative dims so `Modifier.size()` cannot crash.
        val w = if (size.width.value.isFinite() && size.width.value >= 0f) size.width else 0.dp
        val h = if (size.height.value.isFinite() && size.height.value >= 0f) size.height else 0.dp
        modifier.animatedSize(w, h, animationSpec)
    } else {
        modifier
    }
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = sized
            .background(color = color, shape = shape)
            .let {
                if (onTap != null) {
                    it
                        // Mirrors Dart `MouseRegion(cursor: mouseCursor)` in
                        // yaru_page_indicator.dart:191-192 (default
                        // `WidgetStateMouseCursor.clickable` →
                        // `SystemMouseCursors.click`).
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = androidx.compose.foundation.LocalIndication.current,
                            onClick = onTap,
                        )
                } else it
            },
    )
}

/**
 * Default size animation spec used as an opt-in helper for callers.
 *
 * yaru_page_indicator.dart actually defaults to `Duration.zero` (no animation,
 * line 210) with `Curves.linear` (line 211). 200ms is a sensible default for
 * Compose callers wanting smooth dot-size transitions.
 */
fun yaruDefaultIndicatorAnimation(): AnimationSpec<Dp> =
    tween(DEFAULT_ANIMATION_DURATION_MILLIS, easing = LinearEasing)

@Composable
private fun Modifier.animatedSize(
    width: Dp,
    height: Dp,
    animationSpec: AnimationSpec<Dp>?,
): Modifier {
    // Defensive: `Modifier.size` throws `IllegalArgumentException` on negative
    // or non-finite `Dp`. A custom `AnimationSpec` could overshoot below zero;
    // clamp the animated reads before they reach the layout modifier.
    val safeWidth = if (width.value.isFinite() && width.value >= 0f) width else 0.dp
    val safeHeight = if (height.value.isFinite() && height.value >= 0f) height else 0.dp
    if (animationSpec == null) return this.size(safeWidth, safeHeight)
    val w by animateDpAsState(targetValue = safeWidth, animationSpec = animationSpec)
    val h by animateDpAsState(targetValue = safeHeight, animationSpec = animationSpec)
    val safeW = if (w.value.isFinite() && w.value >= 0f) w else 0.dp
    val safeH = if (h.value.isFinite() && h.value >= 0f) h else 0.dp
    return this.size(safeW, safeH)
}
