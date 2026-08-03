package dev.nucleusframework.yarucompose.foundation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * Per-edge size adjustment applied to Yaru buttons, mirroring Flutter's
 * `VisualDensity`.
 *
 * `ThemeData` defaults `visualDensity` to
 * `VisualDensity.defaultDensityForPlatform(platform)` — `compact`
 * (`horizontal: -2, vertical: -2`) on Linux / macOS / Windows and `standard`
 * (`0, 0`) on Android / iOS. `VisualDensity.baseSizeAdjustment` multiplies
 * those by `_interval = 4.0`, so desktop yields `-8` logical pixels per edge.
 *
 * `ButtonStyleButton.build` (`button_style_button.dart`) applies it twice:
 *  - `padding = resolvedPadding.add(EdgeInsets.symmetric(...densityAdjustment)).clamp(zero, infinity)`
 *  - `effectiveConstraints = visualDensity.effectiveConstraints(minimumSize/maximumSize constraints)`
 *
 * That is why Yaru's `_createCommonButtonStyle` — `padding: EdgeInsets.all(16)`
 * with `minimumSize: Size(kYaruButtonHeight, kYaruButtonHeight)` — renders as a
 * 34 dp-tall button on the Ubuntu desktop rather than a ~50 dp one: the 16 dp
 * padding collapses to 8 dp.
 */
internal expect val YaruBaseSizeAdjustment: Dp

/**
 * Adds [delta] to every edge and floors the result at zero — the Compose
 * counterpart of `resolvedPadding.add(...).clamp(EdgeInsets.zero,
 * EdgeInsetsGeometry.infinity)` in `ButtonStyleButton.build`.
 *
 * The floor is applied per edge here rather than by a follow-up
 * [coerceNonNegative]: `PaddingValues(...)` itself rejects negative edges, so
 * a padding smaller than the density adjustment (e.g. the compact insets a
 * `YaruPopupMenuButton` passes) would throw before any later clamp could run.
 */
internal fun PaddingValues.offsetBy(
    delta: Dp,
    layoutDirection: LayoutDirection,
): PaddingValues {
    fun Dp.shift(): Dp = (this.sanitise() + delta).coerceAtLeast(0.dp)
    return PaddingValues(
        start = calculateStartPadding(layoutDirection).shift(),
        top = calculateTopPadding().shift(),
        end = calculateEndPadding(layoutDirection).shift(),
        bottom = calculateBottomPadding().shift(),
    )
}
