package dev.nucleusframework.yarucompose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * Coerce a caller-supplied [Color] to a Skia-safe value.
 *
 * Two failure modes covered:
 *  - `Color.Unspecified` (and any caller-fabricated color with NaN RGB
 *    channels) — `.copy(alpha = ...)` on `Unspecified` keeps the NaN R/G/B,
 *    which then crashes `Modifier.background` / `drawArc`. Fall back to a
 *    fully transparent black so the widget visually disappears instead of
 *    crashing the composition.
 *  - finite RGB but NaN/±Infinity alpha (stale animation, upstream bug) —
 *    coerce alpha into `[0, 1]`.
 */
internal fun sanitiseColor(color: Color): Color {
    if (color == Color.Unspecified) return Color.Transparent
    val r = color.red
    val g = color.green
    val b = color.blue
    if (!r.isFinite() || !g.isFinite() || !b.isFinite()) return Color.Transparent
    val a = color.alpha
    // Defensive: non-finite alpha collapses to 0f (transparent) to match the disappear-don't-crash policy.
    return if (a.isFinite()) color.copy(alpha = a.coerceIn(0f, 1f)) else color.copy(alpha = 0f)
}

/**
 * Coerce a caller-supplied [Dp] to a finite non-negative value. Compose
 * modifiers (`width`, `height`, `padding`, `border`, ...) throw
 * `IllegalArgumentException` for negative inputs and propagate NaN / ±Infinity
 * into `roundToPx()` downstream, which crashes the layout pass. NaN bypasses
 * `coerceAtLeast` (NaN comparisons all return false), so reject non-finite
 * values explicitly via `isFinite()` first.
 */
internal fun Dp.sanitise(): Dp = if (value.isFinite()) coerceAtLeast(0.dp) else 0.dp

/**
 * Coerce a caller-supplied [Float] to a finite non-negative value. Mirrors
 * [Dp.sanitise] for raw float inputs (typically pixel-space derivations such
 * as stroke widths). Non-finite values collapse to `0f` instead of leaking
 * NaN / ±Infinity into draw / measure calls.
 */
internal fun Float.sanitise(): Float = if (isFinite()) coerceAtLeast(0f) else 0f

/**
 * Returns a copy of these [PaddingValues] where every edge is clamped to a
 * finite non-negative `Dp`. `Modifier.padding(PaddingValues)` throws
 * `IllegalArgumentException` for any negative edge, and a non-finite Dp
 * (NaN / ±Infinity) blows up `roundToPx()` downstream.
 */
internal fun PaddingValues.coerceNonNegative(layoutDirection: LayoutDirection): PaddingValues {
    return PaddingValues(
        start = calculateStartPadding(layoutDirection).sanitise(),
        top = calculateTopPadding().sanitise(),
        end = calculateEndPadding(layoutDirection).sanitise(),
        bottom = calculateBottomPadding().sanitise(),
    )
}

/**
 * Returns a copy of this [BorderStroke] with `width` clamped to a finite
 * non-negative `Dp`. `Modifier.border` throws `IllegalArgumentException` for
 * negative or non-finite stroke widths.
 */
internal fun BorderStroke.sanitiseStrokeWidth(): BorderStroke {
    val w = width.value
    if (w.isFinite() && w >= 0f) return this
    val safe = if (w.isFinite()) w.coerceAtLeast(0f).dp else 0.dp
    return BorderStroke(safe, brush)
}
