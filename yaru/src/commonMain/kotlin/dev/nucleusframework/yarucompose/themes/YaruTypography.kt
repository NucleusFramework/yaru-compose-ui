package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Yaru typography scale — the same 15-style ladder Material3 ships, but
 * decoupled from `androidx.compose.material3.Typography` so the library can
 * drop Material3 entirely.
 *
 * Sizes / weights match `createTextTheme(textColor)` from
 * `yaru.dart/lib/src/themes/text_theme.dart`.
 */
@Immutable
data class YaruTypography(
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val displaySmall: TextStyle,
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

/** Build a [YaruTypography] using the Ubuntu font family + a foreground color. */
fun yaruTypography(
    textColor: Color,
    fontFamily: FontFamily = FontFamily.Default,
): YaruTypography {
    fun ubuntu(size: Float, weight: FontWeight): TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = size.sp,
        fontWeight = weight,
        color = textColor,
        letterSpacing = 0.sp,
    )
    return YaruTypography(
        displayLarge = ubuntu(96f, FontWeight.W300),
        displayMedium = ubuntu(60f, FontWeight.W300),
        displaySmall = ubuntu(48f, FontWeight.Normal),
        headlineLarge = ubuntu(40f, FontWeight.Normal),
        headlineMedium = ubuntu(34f, FontWeight.Normal),
        headlineSmall = ubuntu(24f, FontWeight.Normal),
        titleLarge = ubuntu(20f, FontWeight.W500),
        titleMedium = ubuntu(16f, FontWeight.Normal),
        titleSmall = ubuntu(14.66f, FontWeight.W500),
        bodyLarge = ubuntu(16f, FontWeight.Normal),
        bodyMedium = ubuntu(14.66f, FontWeight.Normal),
        bodySmall = ubuntu(12f, FontWeight.Normal),
        labelLarge = ubuntu(14.66f, FontWeight.Normal),
        labelMedium = ubuntu(12f, FontWeight.Normal),
        labelSmall = ubuntu(10f, FontWeight.Normal),
    )
}

/** Composition local exposing the active [YaruTypography] to descendant widgets. */
val LocalYaruTypography = staticCompositionLocalOf<YaruTypography> {
    yaruTypography(textColor = Color.Black)
}

/** Default text style used by [YaruText] when no style is supplied. */
val LocalYaruTextStyle = staticCompositionLocalOf<TextStyle> {
    TextStyle.Default
}

/** Composition local for the active foreground color (replaces `m3.LocalContentColor`). */
val LocalYaruContentColor = staticCompositionLocalOf<Color> { Color.Black }
