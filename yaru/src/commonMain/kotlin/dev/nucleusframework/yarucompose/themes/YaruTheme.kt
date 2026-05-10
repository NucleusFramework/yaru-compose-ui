package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.LocalIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

/**
 * Top-level Yaru theme — Foundation-only entry point.
 *
 * Mirrors `yaru.dart/lib/src/themes/yaru.dart`. Provides every Yaru
 * `CompositionLocal` (color scheme, typography, content color, icon font,
 * divider color, indication) so descendant Yaru widgets can read them
 * without any `androidx.compose.material*` dependency.
 */
@Composable
fun YaruTheme(
    isDark: Boolean = false,
    highContrast: Boolean = false,
    variant: YaruVariant = YaruVariant.Orange,
    content: @Composable () -> Unit,
) {
    val yaruScheme = remember(isDark, highContrast, variant) {
        resolveYaruScheme(isDark = isDark, highContrast = highContrast, variant = variant)
    }
    val ubuntuFamily = rememberUbuntuFontFamily()
    val iconFamily = rememberYaruIconFontFamily()
    val typography = remember(yaruScheme.onSurface, ubuntuFamily) {
        yaruTypography(textColor = yaruScheme.onSurface, fontFamily = ubuntuFamily)
    }
    val indication = remember(yaruScheme.onSurfaceVariant) {
        YaruIndication(yaruScheme.onSurfaceVariant)
    }
    val dividerColor = remember(yaruScheme) { yaruDividerColorOf(yaruScheme) }

    CompositionLocalProvider(
        LocalIndication provides indication,
        LocalYaruIconFont provides iconFamily,
        LocalYaruDividerColor provides dividerColor,
        LocalYaruColorScheme provides yaruScheme,
        LocalYaruTypography provides typography,
        LocalYaruContentColor provides yaruScheme.onSurface,
        // Default body text style — equivalent of Material's `DefaultTextStyle`
        // applied via `Theme(textTheme:)`. Without this, every `YaruText` that
        // doesn't pass an explicit style would fall back to `TextStyle.Default`
        // and render in the platform font instead of Ubuntu.
        LocalYaruTextStyle provides typography.bodyMedium,
        content = content,
    )
}

private fun resolveYaruScheme(
    isDark: Boolean,
    highContrast: Boolean,
    variant: YaruVariant,
): YaruColorScheme = when {
    highContrast && isDark -> yaruDarkScheme(primaryColor = androidx.compose.ui.graphics.Color.White)
    highContrast -> yaruLightScheme(primaryColor = androidx.compose.ui.graphics.Color.Black)
    isDark -> yaruDarkScheme(primaryColor = variant.color)
    else -> yaruLightScheme(primaryColor = variant.color)
}

/** Default Yaru light theme (Ubuntu Orange). */
@Composable
fun YaruLightTheme(content: @Composable () -> Unit) =
    YaruTheme(isDark = false, content = content)

/** Default Yaru dark theme (Ubuntu Orange). */
@Composable
fun YaruDarkTheme(content: @Composable () -> Unit) =
    YaruTheme(isDark = true, content = content)

/** Yaru high-contrast light theme (black accent). */
@Composable
fun YaruHighContrastLightTheme(content: @Composable () -> Unit) =
    YaruTheme(isDark = false, highContrast = true, content = content)

/** Yaru high-contrast dark theme (white accent). */
@Composable
fun YaruHighContrastDarkTheme(content: @Composable () -> Unit) =
    YaruTheme(isDark = true, highContrast = true, content = content)
