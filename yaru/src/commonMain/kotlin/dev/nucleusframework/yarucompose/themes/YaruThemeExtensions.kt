package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

/**
 * Yaru-specific helpers — Foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/themes/extensions.dart`. The original Dart
 * extensions on `ColorScheme` have been removed; equivalents on
 * [YaruColorScheme] live in `YaruColorScheme.kt`.
 */

/**
 * Returns a flat list with [separator] inserted between each element of the receiver.
 *
 * Mirrors `WidgetIterableExtension.separatedBy` in Dart.
 */
internal fun <T> Iterable<T>.separatedBy(separator: T): List<T> = buildList {
    val iterator = this@separatedBy.iterator()
    if (!iterator.hasNext()) return@buildList
    add(iterator.next())
    while (iterator.hasNext()) {
        add(separator)
        add(iterator.next())
    }
}

/**
 * @Composable variant — useful when [separator] is itself a composable lambda.
 * Provided as a convenience so users can write
 * `items.separatedByContent { Divider() }` from a composable scope.
 */
@Composable
internal fun <T> List<T>.separatedByContent(
    separator: @Composable () -> Unit,
    item: @Composable (T) -> Unit,
) {
    forEachIndexed { index, value ->
        if (index > 0) separator()
        item(value)
    }
}

/**
 * Returns black or white depending on the perceived luminance of [color].
 *
 * Mirrors Flutter's `ThemeData.estimateBrightnessForColor` which is invoked by
 * `contrastColor` in `yaru.dart/lib/src/themes/common_themes.dart:504-507`.
 * The threshold is the WCAG-style `(L + 0.05)^2 > 0.15`, NOT a flat `L > 0.5`.
 */
internal fun contrastColor(color: Color): Color {
    val raw = color.luminance()
    // Defensive: luminance() can return NaN/Infinity for malformed colors
    // (e.g. wide-gamut channels outside [0,1]). Fall back to mid-luminance
    // so the WCAG comparison stays well-defined.
    val l = if (raw.isFinite()) raw.coerceIn(0f, 1f) else 0.5f
    val v = (l + 0.05f) * (l + 0.05f)
    return if (v > 0.15f) Color.Black else Color.White
}
