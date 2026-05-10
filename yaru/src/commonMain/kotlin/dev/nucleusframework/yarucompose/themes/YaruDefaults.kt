package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Yaru-flavoured defaults shared by widgets and theme. Values are extracted
 * 1-for-1 from `yaru.dart/lib/src/themes/common_themes.dart`.
 */
object YaruDefaults {

    /** All Yaru surfaces are flat — matches `kYaruAppBarElevation = 0` and `Card` `elevation: 0`. */
    val Elevation: Dp = 0.dp

    /** Yaru never paints shadows on flat surfaces. */
    val ShadowColor: Color = Color.Transparent

    /**
     * Standard button content padding from `_createCommonButtonStyle`
     * (`EdgeInsets.all(16)`).
     */
    val ButtonContentPadding: PaddingValues = PaddingValues(16.dp)

    /** Common button shape — `RoundedRectangleBorder(borderRadius: 8)`. */
    val ButtonShape: Shape = RoundedCornerShape(YaruConstants.ButtonRadius)

    /** Window-shaped surface (dialogs, drawers). */
    val WindowShape: Shape = RoundedCornerShape(YaruConstants.WindowRadius)

    /** Container shape (cards, sections, banners). */
    val ContainerShape: Shape = RoundedCornerShape(YaruConstants.ContainerRadius)

    /** Tooltip enter delay matching Yaru's `_tooltipThemeData` (500 ms). */
    const val TooltipDelayMillis: Long = 500L
}

/**
 * Resolve the Yaru divider color for the active theme — non-composable
 * variant operating on a [YaruColorScheme]. Used internally by [YaruTheme].
 *
 * Mirrors `_createYaruTheme`: divider color is
 * `outline.scale(lightness = if light 0.1 else -0.06)` for non-high-contrast
 * themes and `outlineVariant` for high-contrast.
 */
internal fun yaruDividerColorOf(scheme: YaruColorScheme): Color =
    if (scheme.isHighContrast) {
        scheme.outlineVariant
    } else {
        scheme.outline.scale(lightness = if (scheme.isLight) 0.1f else -0.06f)
    }

/**
 * Composable variant — reads the active [YaruColorScheme] from
 * [LocalYaruColorScheme] and returns the resolved divider color.
 */
@Composable
internal fun yaruDividerColor(): Color {
    val scheme = LocalYaruColorScheme.current
    return remember(scheme) { yaruDividerColorOf(scheme) }
}

/** Composition-local exposing the Yaru divider color so callers can wrap or override it. */
internal val LocalYaruDividerColor = staticCompositionLocalOf<Color?> { null }
