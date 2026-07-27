package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import dev.nucleusframework.darkmodedetector.isSystemInDarkMode
import dev.nucleusframework.systemcolor.systemAccentColor

/**
 * Desktop dark mode as the OS reports it, read natively by Nucleus — GNOME's
 * `color-scheme`, the Windows registry, `NSApplication.effectiveAppearance` —
 * and recomposing when the user flips the setting. Compose's own
 * `isSystemInDarkTheme()` cannot see it on the desktop.
 */
@Composable
actual fun yaruSystemInDarkMode(): Boolean = isSystemInDarkMode()

/**
 * The desktop accent color, mapped onto the closest Yaru variant. `null` when
 * the platform exposes no accent, in which case the app keeps its own.
 */
@Composable
actual fun yaruSystemAccentVariant(): YaruVariant? {
    val accent = systemAccentColor() ?: return null
    return remember(accent) { accent.closestYaruVariant() }
}

/**
 * Nearest variant by squared distance in sRGB. Good enough to pick between
 * Yaru's dozen well-separated accents, and stable: a given accent always
 * resolves to the same variant.
 */
private fun Color.closestYaruVariant(): YaruVariant =
    YaruVariant.entries.minBy { variant ->
        val target = variant.color
        val dr = red - target.red
        val dg = green - target.green
        val db = blue - target.blue
        dr * dr + dg * dg + db * db
    }
