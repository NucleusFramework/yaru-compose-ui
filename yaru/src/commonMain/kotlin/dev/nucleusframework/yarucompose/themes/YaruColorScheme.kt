package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Self-contained color scheme owned by this library. Field names follow the
 * conventional role naming (surface / onSurface / primary / …) so mapping to
 * or from another design system stays mechanical.
 *
 * The values come from `_createYaruTheme` in
 * `yaru.dart/lib/src/themes/common_themes.dart`.
 */
@Immutable
data class YaruColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val inversePrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val surface: Color,
    val surfaceTint: Color,
    val surfaceVariant: Color,
    val onSurface: Color,
    val onSurfaceVariant: Color,
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val outline: Color,
    val outlineVariant: Color,
    val scrim: Color,
    val error: Color,
    val onError: Color,
    val isDark: Boolean,
)

/** True when the resolved scheme is dark — derived from the constructor flag. */
val YaruColorScheme.isLight: Boolean get() = !isDark

/** True when the primary is pure black or pure white (Yaru high-contrast mode). */
val YaruColorScheme.isHighContrast: Boolean
    get() = primary == Color.Black || primary == Color.White

/** Yaru success color (palette-driven, varies with brightness). */
val YaruColorScheme.success: Color get() = YaruColors.from(isDark).success

/** Yaru warning color. */
val YaruColorScheme.warning: Color get() = YaruColors.from(isDark).warning

/** Yaru link color. */
val YaruColorScheme.link: Color get() = YaruColors.from(isDark).link

/** Yaru link color over the inverse surface. */
val YaruColorScheme.inverseLink: Color get() = YaruColors.from(!isDark).link

/** Composition local exposing the active [YaruColorScheme] to descendant widgets. */
val LocalYaruColorScheme = staticCompositionLocalOf<YaruColorScheme> {
    yaruLightScheme(primaryColor = YaruColors.Orange)
}

/** Build a Yaru light scheme seeded from [primaryColor]. */
fun yaruLightScheme(
    primaryColor: Color = YaruColors.Orange,
    lightBaseColor: Color = Color.White,
    darkBaseColor: Color = YaruColors.Jet,
    errorColor: Color? = null,
): YaruColorScheme {
    val secondary = primaryColor.scale(lightness = 0.2f).cap(saturation = 0.9f)
    val secondaryContainer = primaryColor.scale(lightness = 0.85f).cap(saturation = 0.5f)
    val tertiary = primaryColor.scale(lightness = 0.5f).cap(saturation = 0.8f)
    val tertiaryContainer = primaryColor.scale(lightness = 0.75f).cap(saturation = 0.75f)
    return YaruColorScheme(
        primary = primaryColor,
        onPrimary = contrastColor(primaryColor),
        primaryContainer = lightBaseColor,
        onPrimaryContainer = darkBaseColor,
        inversePrimary = darkBaseColor,
        secondary = secondary,
        onSecondary = contrastColor(secondary),
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = contrastColor(secondaryContainer),
        tertiary = tertiary,
        onTertiary = contrastColor(tertiary),
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = contrastColor(tertiaryContainer),
        surface = lightBaseColor,
        surfaceTint = lightBaseColor,
        surfaceVariant = lightBaseColor.scale(lightness = -0.05f),
        onSurface = darkBaseColor.scale(lightness = 0.1f),
        onSurfaceVariant = darkBaseColor.scale(lightness = 0.2f),
        inverseSurface = darkBaseColor,
        inverseOnSurface = lightBaseColor,
        outline = if (primaryColor == Color.White) Color.Black else lightBaseColor.scale(lightness = -0.2f),
        outlineVariant = Color.Black,
        scrim = Color.Black,
        error = errorColor ?: YaruColors.Light.error,
        onError = lightBaseColor,
        isDark = false,
    )
}

/** Build a Yaru dark scheme seeded from [primaryColor]. */
fun yaruDarkScheme(
    primaryColor: Color = YaruColors.Orange,
    lightBaseColor: Color = YaruColors.Porcelain,
    darkBaseColor: Color = YaruColors.Jet,
    errorColor: Color? = null,
): YaruColorScheme {
    val secondary = primaryColor.scale(lightness = -0.3f, saturation = -0.15f)
    val secondaryContainer = primaryColor
        .scale(lightness = -0.6f, saturation = -0.75f)
        .capDown(lightness = 0.175f)
    val tertiary = primaryColor.scale(lightness = -0.5f, saturation = -0.25f)
    val tertiaryContainer = primaryColor
        .scale(lightness = -0.5f, saturation = -0.65f)
        .capDown(lightness = 0.2f)
    return YaruColorScheme(
        primary = primaryColor,
        onPrimary = contrastColor(primaryColor),
        primaryContainer = darkBaseColor.scale(lightness = 0.1f),
        onPrimaryContainer = lightBaseColor,
        inversePrimary = lightBaseColor,
        secondary = secondary,
        onSecondary = contrastColor(primaryColor.scale(lightness = -0.25f)),
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = contrastColor(secondaryContainer),
        tertiary = tertiary,
        onTertiary = lightBaseColor,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = lightBaseColor,
        surface = darkBaseColor,
        surfaceTint = darkBaseColor,
        surfaceVariant = darkBaseColor.scale(lightness = 0.05f),
        onSurface = lightBaseColor,
        onSurfaceVariant = lightBaseColor.scale(lightness = -0.1f, saturation = 0.1f),
        inverseSurface = lightBaseColor,
        inverseOnSurface = darkBaseColor,
        outline = if (primaryColor == Color.Black) Color.White else darkBaseColor.scale(lightness = 0.14f),
        outlineVariant = Color.White,
        scrim = Color.Black,
        error = errorColor ?: YaruColors.Dark.error,
        onError = Color.White,
        isDark = true,
    )
}
