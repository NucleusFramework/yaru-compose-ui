package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Composable

/**
 * Whether the OS is currently in dark mode, as the platform reports it.
 *
 * Mirrors Dart `MediaQuery.platformBrightness`, which is what
 * `ThemeMode.system` resolves against. Compose's own
 * `isSystemInDarkTheme()` is authoritative on Android, iOS and the web, but
 * on the desktop it cannot see the OS setting — the JVM implementation asks
 * Nucleus, which reads it natively and recomposes when the user flips it.
 */
@Composable
expect fun yaruSystemInDarkMode(): Boolean

/**
 * The desktop's accent color mapped onto the closest [YaruVariant], or `null`
 * when the platform exposes none.
 *
 * GNOME lets the user pick an accent and Yaru ships a variant per accent, so
 * an app that follows the system theme should follow this too — the Dart
 * widgets read it from GTK settings (see
 * [dev.nucleusframework.yarucompose.settings.YaruSettings]).
 */
@Composable
expect fun yaruSystemAccentVariant(): YaruVariant?
