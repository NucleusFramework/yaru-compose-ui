package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

/** Compose reports the platform brightness reliably on this target. */
@Composable
actual fun yaruSystemInDarkMode(): Boolean = isSystemInDarkTheme()

/** No system accent is exposed on this target. */
@Composable
actual fun yaruSystemAccentVariant(): YaruVariant? = null
