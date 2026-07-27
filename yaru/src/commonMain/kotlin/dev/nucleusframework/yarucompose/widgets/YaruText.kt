package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextMaxLines
import dev.nucleusframework.yarucompose.themes.LocalYaruTextOverflow
import dev.nucleusframework.yarucompose.themes.LocalYaruTextSoftWrap
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle

/**
 * Text rendering primitive used across all Yaru widgets — fully foundation,
 * no `androidx.compose.material*` dependency. Reads the active text style
 * from [LocalYaruTextStyle] and falls back to [LocalYaruContentColor] when
 * the resolved style has no color.
 *
 * Compose-only — yaru.dart has no direct counterpart since Flutter's
 * `Text` already inherits its style from `DefaultTextStyle`. This widget
 * fills the same role for Compose Multiplatform without pulling in
 * `androidx.compose.material*`.
 */
@Composable
fun YaruText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = LocalYaruTextOverflow.current,
    softWrap: Boolean = LocalYaruTextSoftWrap.current,
    maxLines: Int = LocalYaruTextMaxLines.current,
    minLines: Int = 1,
    style: TextStyle = LocalYaruTextStyle.current,
) {
    val fallback = LocalYaruContentColor.current
    val resolvedColor = color.takeOrElse { style.color.takeOrElse { fallback } }
    // Mirrors Dart `_UbuntuTextStyle`, which always sets `letterSpacing: 0`
    // regardless of the inherited TextStyle. We force 0.sp here unless the
    // caller passes an explicit override — guarantees identical glyph
    // tracking on every platform (Android/JVM/iOS/Web), and shields against
    // a parent providing a Material TextStyle with a non-zero default
    // (e.g. M3 bodyMedium ships with letterSpacing = 0.25.sp). Also sanitise
    // a caller-supplied override — a NaN / ±Infinity TextUnit (stale animation,
    // bad arithmetic) would crash skia paragraph layout.
    val resolvedLetterSpacing =
        if (letterSpacing == TextUnit.Unspecified) 0.sp else letterSpacing.coerceFinite()
    // Guard against negative TextUnit values — Compose throws on negative
    // fontSize / lineHeight at paragraph layout. Unspecified is fine and must
    // be preserved (it means "inherit from style"). Also sanitize the values
    // inherited from the caller-provided [style], since a misconfigured parent
    // could ship a negative fontSize/lineHeight.
    val safeFontSize =
        if (fontSize == TextUnit.Unspecified) {
            style.fontSize.coerceNonNegative()
        } else {
            fontSize.coerceNonNegative()
        }
    val safeLineHeight =
        if (lineHeight == TextUnit.Unspecified) {
            style.lineHeight.coerceNonNegative()
        } else {
            lineHeight.coerceNonNegative()
        }
    val merged = style.copy(
        color = resolvedColor,
        fontSize = safeFontSize,
        fontStyle = fontStyle ?: style.fontStyle,
        fontWeight = fontWeight ?: style.fontWeight,
        fontFamily = fontFamily ?: style.fontFamily,
        letterSpacing = resolvedLetterSpacing,
        textDecoration = textDecoration ?: style.textDecoration,
        textAlign = textAlign ?: style.textAlign,
        lineHeight = safeLineHeight,
    )
    // BasicText requires `maxLines >= 1` and `minLines in 1..maxLines` — coerce
    // to avoid `IllegalArgumentException` from misconfigured callers.
    val safeMaxLines = maxLines.coerceAtLeast(1)
    val safeMinLines = minLines.coerceIn(1, safeMaxLines)
    BasicText(
        text = text,
        modifier = modifier,
        style = merged,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = safeMaxLines,
        minLines = safeMinLines,
    )
}

/** Annotated-string overload, useful for inline color/weight changes. */
@Composable
fun YaruText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = LocalYaruTextOverflow.current,
    softWrap: Boolean = LocalYaruTextSoftWrap.current,
    maxLines: Int = LocalYaruTextMaxLines.current,
    minLines: Int = 1,
    style: TextStyle = LocalYaruTextStyle.current,
) {
    val fallback = LocalYaruContentColor.current
    val resolvedColor = color.takeOrElse { style.color.takeOrElse { fallback } }
    // Force `letterSpacing = 0.sp` on top of the parent style — mirrors Dart
    // `_UbuntuTextStyle` (always 0). See the String overload above for the
    // full rationale. Also sanitize fontSize/lineHeight inherited from the
    // caller-provided [style] to avoid Compose throwing on negative values.
    val safeFontSize = style.fontSize.coerceNonNegative()
    val safeLineHeight = style.lineHeight.coerceNonNegative()
    val safeMaxLines = maxLines.coerceAtLeast(1)
    val safeMinLines = minLines.coerceIn(1, safeMaxLines)
    BasicText(
        text = text,
        modifier = modifier,
        style = style.copy(
            color = resolvedColor,
            fontSize = safeFontSize,
            lineHeight = safeLineHeight,
            letterSpacing = 0.sp,
        ),
        overflow = overflow,
        softWrap = softWrap,
        maxLines = safeMaxLines,
        minLines = safeMinLines,
    )
}

/**
 * Provide a default text style for a subtree — equivalent to wrapping a
 * Material3 `LocalTextStyle` provider but tied to our [LocalYaruTextStyle].
 */
@Composable
fun YaruProvideTextStyle(
    style: TextStyle,
    content: @Composable () -> Unit,
) {
    val current = LocalYaruTextStyle.current
    CompositionLocalProvider(
        LocalYaruTextStyle provides current.merge(style),
        content = content,
    )
}

private fun Color.takeOrElse(block: () -> Color): Color =
    if (isSpecified) this else block()

private val Color.isSpecified: Boolean
    get() = this != Color.Unspecified

/**
 * Clamp a specified [TextUnit] to be ≥ 0 and finite. Leaves
 * [TextUnit.Unspecified] untouched (its raw value is sentinel, not a number).
 * Both `.sp` and `.em` units expose [TextUnit.value] in the same units they
 * were created with, so comparing against `0f` is unit-safe. Also collapses
 * NaN / infinite values to `0.sp` — Compose paragraph layout asserts on these.
 */
private fun TextUnit.coerceNonNegative(): TextUnit {
    if (this == TextUnit.Unspecified) return this
    val v = value
    return if (v.isNaN() || v.isInfinite() || v < 0f) 0.sp else this
}

/**
 * Collapse NaN / ±Infinity [TextUnit] values to `0.sp`, preserving sign for
 * finite values (negative letter-spacing is a legitimate typographic effect).
 * Leaves [TextUnit.Unspecified] untouched (its raw value is sentinel, not a
 * number — comparing it as a Float would surface noise).
 */
private fun TextUnit.coerceFinite(): TextUnit {
    if (this == TextUnit.Unspecified) return this
    val v = value
    return if (v.isNaN() || v.isInfinite()) 0.sp else this
}
