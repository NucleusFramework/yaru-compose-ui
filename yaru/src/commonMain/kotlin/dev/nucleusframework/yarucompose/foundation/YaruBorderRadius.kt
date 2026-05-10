package dev.nucleusframework.yarucompose.foundation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * Border-radius helpers mirroring `yaru.dart/lib/src/foundation/yaru_border_radius.dart`.
 *
 * Compose does not expose `BorderRadius.only` with elliptical corners on the public API
 * the same way Flutter does; we use [RoundedCornerShape] with per-corner sizes which
 * covers the use cases in Yaru widgets.
 */

/** Compute an inner border radius from a given padding. */
internal fun RoundedCornerShape.inner(
    padding: PaddingValues,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr,
): RoundedCornerShape {
    val left = padding.calculateLeftPadding(layoutDirection)
    val top = padding.calculateTopPadding()
    val right = padding.calculateRightPadding(layoutDirection)
    val bottom = padding.calculateBottomPadding()
    return RoundedCornerShape(
        topStart = topStart.shrink(left, top),
        topEnd = topEnd.shrink(right, top),
        bottomEnd = bottomEnd.shrink(right, bottom),
        bottomStart = bottomStart.shrink(left, bottom),
    )
}

/** Compute an outer border radius from a given margin. */
internal fun RoundedCornerShape.outer(
    margin: PaddingValues,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr,
): RoundedCornerShape {
    val left = margin.calculateLeftPadding(layoutDirection)
    val top = margin.calculateTopPadding()
    val right = margin.calculateRightPadding(layoutDirection)
    val bottom = margin.calculateBottomPadding()
    return RoundedCornerShape(
        topStart = topStart.grow(left, top),
        topEnd = topEnd.grow(right, top),
        bottomEnd = bottomEnd.grow(right, bottom),
        bottomStart = bottomStart.grow(left, bottom),
    )
}

private fun CornerSize.shrink(horizontal: Dp, vertical: Dp): CornerSize =
    YaruCornerSize.shrink(this, horizontal, vertical)

private fun CornerSize.grow(horizontal: Dp, vertical: Dp): CornerSize =
    YaruCornerSize.grow(this, horizontal, vertical)

private object YaruCornerSize {
    /**
     * The Compose [CornerSize] is opaque (it can be Dp/percent/px). We approximate
     * shrink/grow by taking the average of the two axes — which matches what Yaru does
     * when corners are circular (x == y), the common case in this library.
     */
    fun shrink(size: CornerSize, horizontal: Dp, vertical: Dp): CornerSize {
        val avg = (horizontal.value + vertical.value) / 4f
        return DpCornerSize(size, deltaDp = -avg.dp)
    }

    fun grow(size: CornerSize, horizontal: Dp, vertical: Dp): CornerSize {
        val avg = (horizontal.value + vertical.value) / 4f
        return DpCornerSize(size, deltaDp = avg.dp)
    }
}

/** Wraps an existing [CornerSize] and offsets it in Dp at compute time. */
private class DpCornerSize(
    private val base: CornerSize,
    private val deltaDp: Dp,
) : CornerSize {
    override fun toPx(
        shapeSize: androidx.compose.ui.geometry.Size,
        density: androidx.compose.ui.unit.Density,
    ): Float {
        val basePx = base.toPx(shapeSize, density)
        // Guard against `Dp.Unspecified` (= `Float.NaN`) and ±Infinity in the
        // padding/margin inputs. NaN/Infinity propagates through arithmetic and
        // `coerceAtLeast` (NaN comparisons all return false), which would feed
        // `RoundedCornerShape.createOutline` a non-finite radius and crash the
        // path math downstream.
        val rawDelta = with(density) { deltaDp.toPx() }
        val deltaPx = if (rawDelta.isFinite()) rawDelta else 0f
        val safeBase = if (basePx.isFinite()) basePx else 0f
        return (safeBase + deltaPx).coerceAtLeast(0f)
    }
}
