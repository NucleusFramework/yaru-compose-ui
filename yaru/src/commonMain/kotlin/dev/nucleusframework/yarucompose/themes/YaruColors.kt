package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * Available Yaru colors.
 *
 * Mirrors `yaru.dart/lib/src/themes/colors.dart`.
 */
@Immutable
data class YaruColors(
    val error: Color,
    val warning: Color,
    val success: Color,
    val link: Color,
) {
    companion object {
        fun from(isDark: Boolean): YaruColors = if (isDark) Dark else Light

        val Light: YaruColors = YaruColors(
            error = Color(0xFFB52A4A),
            success = Color(0xFF0E8420),
            warning = Color(0xFFF99B11),
            link = Color(0xFF0073E5),
        )

        val Dark: YaruColors = YaruColors(
            error = Color(0xFFE86581),
            success = Color(0xFF0E8420),
            warning = Color(0xFFF99B11),
            link = Color(0xFF0094FF),
        )

        // Brand & palette constants
        val Orange: Color = Color(0xFFE95420)
        val WarmGrey: Color = Color(0xFFAEA79F)
        val CoolGrey: Color = Color(0xFF333333)
        val TextGrey: Color = Color(0xFF111111)

        val Porcelain: Color = Color(0xFFFAFAFA)
        val Inkstone: Color = Color(0xFF3B3B3B)
        val Jet: Color = Color(0xFF202020)
        val TitleBarLight: Color = Color(0xFFEBEBEB)
        val TitleBarDark: Color = Color(0xFF303030)

        val Olive: Color = Color(0xFF4B8501)
        val Bark: Color = Color(0xFF787859)
        val Sage: Color = Color(0xFF657B69)
        // Slightly darkened from the upstream 0xFFB39169 for contrast reasons.
        val WartyBrown: Color = Color(0xFF92714A)
        val PrussianGreen: Color = Color(0xFF308280)
        val Viridian: Color = Color(0xFF03875B)
        val Purple: Color = Color(0xFF7764D8)
        val Red: Color = Color(0xFFDA3450)
        val Blue: Color = Color(0xFF0073E5)
        val Magenta: Color = Color(0xFFB34CB3)

        val KubuntuBlue: Color = Color(0xFF0079C1)
        val LubuntuBlue: Color = Color(0xFF0068C8)
        val UbuntuBudgieBlue: Color = Color(0xFF2196F3)
        val UbuntuButterflyPink: Color = Color(0xFFFF135B)
        val UbuntuCinnamonBrown: Color = Color(0xFFDD682A)
        val UbuntuMateGreen: Color = Color(0xFF73AF59)
        val UbuntuStudioBlue: Color = Color(0xFF009BF9)
        val UbuntuUnityPurple: Color = Color(0xFF9005D5)
        val XubuntuBlue: Color = Color(0xFF0044AA)

        // Adwaita accent colors (libadwaita 24.10+).
        val AdwaitaBlue: Color = Color(0xFF3584E4)
        val AdwaitaTeal: Color = Color(0xFF2190A4)
        val AdwaitaGreen: Color = Color(0xFF3A944A)
        val AdwaitaYellow: Color = Color(0xFFC88800)
        val AdwaitaOrange: Color = Color(0xFFED5B00)
        val AdwaitaRed: Color = Color(0xFFE62D42)
        val AdwaitaPink: Color = Color(0xFFD56199)
        val AdwaitaPurple: Color = Color(0xFF9141AC)
        val AdwaitaSlate: Color = Color(0xFF6F8396)
    }
}

/** HSL representation used by [scale], [adjust], [copyHsl]. */
private data class Hsl(val h: Float, val s: Float, val l: Float, val a: Float)

private fun Color.toHsl(): Hsl {
    // `coerceIn` is a no-op for NaN (NaN comparisons all return false), so a
    // NaN channel — possible for `Color.Unspecified` and other sentinels —
    // would propagate through the math. Sanitise to 0 first.
    fun Float.sanitise(): Float = if (isFinite()) this.coerceIn(0f, 1f) else 0f
    val r = red.sanitise()
    val g = green.sanitise()
    val b = blue.sanitise()
    val cMax = max(r, max(g, b))
    val cMin = min(r, min(g, b))
    val delta = cMax - cMin
    val l = (cMax + cMin) / 2f
    // Guard against NaN when l == 0 or l == 1 (denominator collapses to zero).
    val denom = 1f - kotlin.math.abs(2f * l - 1f)
    val s = if (delta == 0f || denom == 0f) 0f else delta / denom
    val h = when {
        delta == 0f -> 0f
        cMax == r -> 60f * (((g - b) / delta) % 6f)
        cMax == g -> 60f * (((b - r) / delta) + 2f)
        else -> 60f * (((r - g) / delta) + 4f)
    }.let { if (it < 0f) it + 360f else it }
    val a = if (alpha.isFinite()) alpha.coerceIn(0f, 1f) else 1f
    return Hsl(h, s, l, a)
}

private fun Hsl.toColor(): Color {
    val c = (1f - kotlin.math.abs(2f * l - 1f)) * s
    // Defensive: wrap hue into [0, 360) so h == 360f doesn't fall into the magenta sextant.
    val hWrapped = ((h % 360f) + 360f) % 360f
    val x = c * (1f - kotlin.math.abs((hWrapped / 60f) % 2f - 1f))
    val m = l - c / 2f
    val (r1, g1, b1) = when {
        hWrapped < 60f -> Triple(c, x, 0f)
        hWrapped < 120f -> Triple(x, c, 0f)
        hWrapped < 180f -> Triple(0f, c, x)
        hWrapped < 240f -> Triple(0f, x, c)
        hWrapped < 300f -> Triple(x, 0f, c)
        else -> Triple(c, 0f, x)
    }
    return Color(
        red = (r1 + m).coerceIn(0f, 1f),
        green = (g1 + m).coerceIn(0f, 1f),
        blue = (b1 + m).coerceIn(0f, 1f),
        alpha = a.coerceIn(0f, 1f),
    )
}

/**
 * Pure dark colors have a saturation of 1.0 in HSL, which yields red when lightened.
 * Reset saturation to 0.0 in that case so the result desaturates as expected.
 */
private fun Color.patchedHsl(): Hsl {
    val hsl = toHsl()
    return if (hsl.l == 0f) hsl.copy(s = 0f) else hsl
}

/** Scale color attributes relatively to current ones. Values clamped to [-1.0, 1.0]. */
fun Color.scale(
    alpha: Float = 0f,
    hue: Float = 0f,
    saturation: Float = 0f,
    lightness: Float = 0f,
): Color {
    require(alpha in -1f..1f) { "alpha must be in [-1, 1]" }
    require(hue in -1f..1f) { "hue must be in [-1, 1]" }
    require(saturation in -1f..1f) { "saturation must be in [-1, 1]" }
    require(lightness in -1f..1f) { "lightness must be in [-1, 1]" }

    fun scale(value: Float, amount: Float, upperLimit: Float = 1f): Float {
        val result = when {
            amount > 0f -> value + (upperLimit - value) * amount
            amount < 0f -> value + value * amount
            else -> value
        }
        return result.coerceIn(0f, upperLimit)
    }

    val hsl = patchedHsl()
    return Hsl(
        h = scale(hsl.h, hue, 360f),
        s = scale(hsl.s, saturation),
        l = scale(hsl.l, lightness),
        a = scale(hsl.a, alpha),
    ).toColor()
}

/**
 * Adjust color attributes by the given values.
 * [alpha], [saturation], [lightness] in [-1, 1]. [hue] in [-360, 360].
 */
fun Color.adjust(
    alpha: Float = 0f,
    hue: Float = 0f,
    saturation: Float = 0f,
    lightness: Float = 0f,
): Color {
    require(alpha in -1f..1f) { "alpha ($alpha) must be in [-1, 1]" }
    require(hue in -360f..360f) { "hue ($hue) must be in [-360, 360]" }
    require(saturation in -1f..1f) { "saturation ($saturation) must be in [-1, 1]" }
    require(lightness in -1f..1f) { "lightness ($lightness) must be in [-1, 1]" }

    fun adjust(value: Float, amount: Float, upperLimit: Float = 1f): Float =
        (value + amount).coerceIn(0f, upperLimit)

    val hsl = patchedHsl()
    return Hsl(
        h = adjust(hsl.h, hue, 360f),
        s = adjust(hsl.s, saturation),
        l = adjust(hsl.l, lightness),
        a = adjust(hsl.a, alpha),
    ).toColor()
}

/** Return a copy of this color with attributes replaced by given values. */
fun Color.copyHsl(
    alpha: Float? = null,
    hue: Float? = null,
    saturation: Float? = null,
    lightness: Float? = null,
): Color {
    require(alpha == null || alpha in 0f..1f) { "alpha ($alpha) must be null or in [0, 1]" }
    require(hue == null || hue in 0f..360f) { "hue ($hue) must be null or in [0, 360]" }
    require(saturation == null || saturation in 0f..1f) {
        "saturation ($saturation) must be null or in [0, 1]"
    }
    require(lightness == null || lightness in 0f..1f) {
        "lightness ($lightness) must be null or in [0, 1]"
    }

    val hsl = patchedHsl()
    return Hsl(
        h = hue ?: hsl.h,
        s = saturation ?: hsl.s,
        l = lightness ?: hsl.l,
        a = alpha ?: hsl.a,
    ).toColor()
}

/** Cap (upper-bound) color attributes by the given values. */
fun Color.cap(
    alpha: Float = 1f,
    saturation: Float = 1f,
    lightness: Float = 1f,
): Color {
    require(alpha in 0f..1f) { "alpha ($alpha) must be in [0, 1]" }
    require(saturation in 0f..1f) { "saturation ($saturation) must be in [0, 1]" }
    require(lightness in 0f..1f) { "lightness ($lightness) must be in [0, 1]" }

    val hsl = patchedHsl()
    return Hsl(
        h = hsl.h,
        s = if (hsl.s <= saturation) hsl.s else saturation,
        l = if (hsl.l <= lightness) hsl.l else lightness,
        a = if (hsl.a <= alpha) hsl.a else alpha,
    ).toColor()
}

/** Cap (lower-bound) color attributes by the given values. */
fun Color.capDown(
    alpha: Float = 0f,
    saturation: Float = 0f,
    lightness: Float = 0f,
): Color {
    require(alpha in 0f..1f) { "alpha ($alpha) must be in [0, 1]" }
    require(saturation in 0f..1f) { "saturation ($saturation) must be in [0, 1]" }
    require(lightness in 0f..1f) { "lightness ($lightness) must be in [0, 1]" }

    val hsl = patchedHsl()
    return Hsl(
        h = hsl.h,
        s = if (hsl.s >= saturation) hsl.s else saturation,
        l = if (hsl.l >= lightness) hsl.l else lightness,
        a = if (hsl.a >= alpha) hsl.a else alpha,
    ).toColor()
}

/** Returns a hex representation (`#AARRGGBB`) of the color. */
fun Color.toHex(): String {
    // `Color.Unspecified` and other sentinel values can expose NaN channels;
    // `Float.roundToInt()` on NaN throws `IllegalArgumentException`. Coerce
    // non-finite channels to 0 before rounding so this stays crash-safe.
    fun Float.byteHex(): String {
        val safe = if (isFinite()) this else 0f
        return (safe * 255f).roundToInt().coerceIn(0, 255).toString(16).padStart(2, '0')
    }
    return "#${alpha.byteHex()}${red.byteHex()}${green.byteHex()}${blue.byteHex()}"
}
