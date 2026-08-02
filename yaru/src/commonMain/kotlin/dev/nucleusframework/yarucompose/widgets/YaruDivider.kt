package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruDividerColor
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale

/**
 * Hairline divider using Yaru's exact color (matches `dividerTheme.color` from
 * `yaru.dart/lib/src/themes/common_themes.dart`). Foundation-only.
 */
@Composable
fun YaruHorizontalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = rememberYaruDividerColor(),
) {
    // Defensive clamp: `Modifier.height` with a negative or non-finite Dp
    // (e.g. NaN from interpolation, +Infinity from a runaway caller) throws
    // `IllegalArgumentException` at measure time.
    val safeThickness = sanitiseThickness(thickness)
    val safeColor = sanitiseColor(color)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(safeThickness)
            .background(safeColor),
    )
}

/** Vertical counterpart of [YaruHorizontalDivider]. */
@Composable
fun YaruVerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = rememberYaruDividerColor(),
) {
    // Defensive clamp: `Modifier.width` with a negative or non-finite Dp
    // (e.g. NaN from interpolation, +Infinity from a runaway caller) throws
    // `IllegalArgumentException` at measure time.
    val safeThickness = sanitiseThickness(thickness)
    val safeColor = sanitiseColor(color)
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(safeThickness)
            .background(safeColor),
    )
}

/**
 * Coerce a caller-supplied `Dp` thickness into the [0, 1024] dp window.
 * Routes through the canonical [sanitise] foundation helper for the
 * non-finite / negative guard, then clamps the upper bound — Skia paths
 * become unreliable for arbitrarily wide hairlines.
 */
private fun sanitiseThickness(thickness: Dp): Dp =
    thickness.sanitise().coerceAtMost(1024.dp)

/** Resolve the Yaru divider color reading the active [LocalYaruColorScheme]. */
@Composable
internal fun rememberYaruDividerColor(): Color {
    LocalYaruDividerColor.current?.let { return it }
    val scheme = LocalYaruColorScheme.current
    return if (scheme.isHighContrast) {
        scheme.outlineVariant
    } else {
        scheme.outline.scale(lightness = if (scheme.isLight) 0.1f else -0.06f)
    }
}
