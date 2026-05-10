package dev.nucleusframework.yarucompose.icons

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruIconFont
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * Renders a glyph from the Yaru icon font.
 *
 * Mirrors the typical `Icon(YaruIcons.something)` usage in `yaru.dart`. The font
 * family is resolved from [LocalYaruIconFont] (provided by `YaruTheme`), so
 * call sites only need to pass the [glyph]. Pass an explicit [fontFamily] to
 * render a glyph from a different icon font.
 *
 * The default [size] is [YaruConstants.IconSize] (20 dp) — matching
 * `kYaruIconSize` in `yaru.dart/lib/constants.dart`. The default [tint] is
 * [LocalYaruContentColor], matching Flutter's `IconTheme` color resolution.
 *
 * The font size is computed so that the glyph renders at the requested dp
 * size regardless of the user's text-scale setting (matching Flutter's `Icon`,
 * which sizes glyphs in logical pixels — unaffected by `MediaQuery.textScaler`).
 *
 * Pass [semanticLabel] to expose an accessibility description, mirroring
 * `Icon.semanticLabel` in Flutter (`widgets/icon.dart`).
 */
@Composable
fun YaruIcon(
    glyph: Char,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = LocalYaruIconFont.current,
    size: Dp = YaruConstants.IconSize,
    tint: Color = LocalYaruContentColor.current,
    semanticLabel: String? = null,
) {
    // BasicText renders `fontSize` in Sp at `value * density * fontScale` px.
    // Dividing the requested dp value by `fontScale` cancels the user's text
    // scale, so the glyph always lands at the requested logical size.
    // Guard against pathological inputs: a non-positive `fontScale` would
    // yield Infinity/NaN, and a negative/NaN/Infinite `size` would crash
    // text layout (`fontSize` must be a finite non-negative value). Coerce
    // both to safe values. Note: `Float.isFinite()` is false for NaN and
    // Infinity, and any comparison with NaN returns false — so the
    // `takeIf` filter rejects NaN as well as non-positive values.
    val fontScale = LocalDensity.current.fontScale.takeIf { it.isFinite() && it > 0f } ?: 1f
    val safeSizeValue = size.value.takeIf { it.isFinite() }?.coerceAtLeast(0f) ?: 0f
    val fontSize = (safeSizeValue / fontScale).sp
    // Defensive: a caller-supplied `tint` with non-finite channels (e.g.
    // `Color.Unspecified` from a misuse, NaN alpha from a stale animation)
    // would crash Skia text layout. `Color.Unspecified` is a legal sentinel
    // for `TextStyle.color` (BasicText skips painting), so preserve it; only
    // sanitise tints that have specified-but-broken channels.
    val safeTint = sanitiseIconTint(tint)
    // Defensive: treat an empty `semanticLabel` as "no label" — assigning `contentDescription = ""` with `Role.Image` would have screen readers announce "image" with no name attached.
    // Defensive: also reject whitespace-only labels — they are useless to screen readers (announced as silence) yet still install the semantics node.
    val semanticsModifier = if (!semanticLabel.isNullOrBlank()) {
        Modifier.semantics {
            contentDescription = semanticLabel
            role = Role.Image
        }
    } else {
        Modifier
    }
    BasicText(
        text = glyph.toString(),
        modifier = modifier.then(semanticsModifier),
        style = TextStyle(
            fontFamily = fontFamily,
            color = safeTint,
            fontSize = fontSize,
            // Force zero letter-spacing — the icon font ships with intrinsic
            // metrics, and any inherited tracking would add extra padding
            // around the glyph (mirrors Flutter `Icon` which renders via
            // `RichText` with no letter spacing applied).
            letterSpacing = 0.sp,
        ),
    )
}

/**
 * Coerce a caller-supplied [tint] into a safe value for `TextStyle.color`.
 *
 * `Color.Unspecified` is preserved — it is the canonical sentinel meaning
 * "inherit / unset", and BasicText handles it gracefully.
 *
 * Any other color with NaN R/G/B channels (caller-fabricated, broken
 * interpolation) collapses to `Color.Transparent` so the glyph silently
 * vanishes instead of crashing Skia text layout. Non-finite alpha on a
 * specified color is replaced by `1f`; finite alpha is clamped to `[0, 1]`.
 */
private fun sanitiseIconTint(tint: Color): Color {
    if (tint == Color.Unspecified) return tint
    val r = tint.red
    val g = tint.green
    val b = tint.blue
    if (!r.isFinite() || !g.isFinite() || !b.isFinite()) return Color.Transparent
    val a = tint.alpha
    return if (a.isFinite()) tint.copy(alpha = a.coerceIn(0f, 1f)) else tint.copy(alpha = 1f)
}
