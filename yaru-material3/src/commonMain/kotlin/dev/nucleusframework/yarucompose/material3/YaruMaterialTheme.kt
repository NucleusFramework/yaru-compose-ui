package dev.nucleusframework.yarucompose.material3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruTypography

/**
 * Bridges the active [YaruColorScheme] / [YaruTypography] (provided by
 * `YaruTheme`) onto a [MaterialTheme] so descendant `androidx.compose.material3`
 * widgets pick up Yaru styling.
 *
 * Mirrors the role of `createYaruTheme` in
 * `yaru.dart/lib/src/themes/common_themes.dart`. Place INSIDE a `YaruTheme { ... }`
 * block, and wrap ONLY the sub-tree that needs Material widgets — never the
 * whole app.
 */
@Composable
fun YaruMaterialTheme(content: @Composable () -> Unit) {
    val yaruScheme = LocalYaruColorScheme.current
    val yaruTypography = LocalYaruTypography.current

    val materialScheme = remember(yaruScheme) { yaruScheme.toMaterial3() }
    val materialTypography = remember(yaruTypography) { yaruTypography.toMaterial3() }

    MaterialTheme(
        colorScheme = materialScheme,
        typography = materialTypography,
    ) {
        // `MaterialTheme` does NOT seed `LocalContentColor` — only Material3's
        // `Surface` does (via `contentColorFor`). Without wrapping every page
        // in a Surface, Material3 `Text` falls back to the local's default
        // `Color.Black`, producing unreadable text on the dark scheme. Seed
        // it from the mapped `onSurface` so widgets that don't sit inside a
        // Surface inherit the correct foreground.
        CompositionLocalProvider(LocalContentColor provides materialScheme.onSurface) {
            content()
        }
    }
}

/** Mechanical 1-to-1 mapping; field names match the Material spec. */
fun YaruColorScheme.toMaterial3(): ColorScheme = ColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    background = surface,
    onBackground = onSurface,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    error = error,
    onError = onError,
    errorContainer = error,
    onErrorContainer = onError,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
    surfaceBright = surface,
    surfaceDim = surfaceVariant,
    surfaceContainer = surface,
    surfaceContainerHigh = surfaceVariant,
    surfaceContainerHighest = surfaceVariant,
    surfaceContainerLow = surface,
    surfaceContainerLowest = surface,
    primaryFixed = primaryContainer,
    primaryFixedDim = primaryContainer,
    onPrimaryFixed = onPrimaryContainer,
    onPrimaryFixedVariant = onPrimaryContainer,
    secondaryFixed = secondaryContainer,
    secondaryFixedDim = secondaryContainer,
    onSecondaryFixed = onSecondaryContainer,
    onSecondaryFixedVariant = onSecondaryContainer,
    tertiaryFixed = tertiaryContainer,
    tertiaryFixedDim = tertiaryContainer,
    onTertiaryFixed = onTertiaryContainer,
    onTertiaryFixedVariant = onTertiaryContainer,
)

fun YaruTypography.toMaterial3(): Typography = Typography(
    displayLarge = displayLarge,
    displayMedium = displayMedium,
    displaySmall = displaySmall,
    headlineLarge = headlineLarge,
    headlineMedium = headlineMedium,
    headlineSmall = headlineSmall,
    titleLarge = titleLarge,
    titleMedium = titleMedium,
    titleSmall = titleSmall,
    bodyLarge = bodyLarge,
    bodyMedium = bodyMedium,
    bodySmall = bodySmall,
    labelLarge = labelLarge,
    labelMedium = labelMedium,
    labelSmall = labelSmall,
)
