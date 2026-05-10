package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography

/**
 * A bordered section with an optional headline, mirroring
 * `yaru.dart/lib/src/widgets/yaru_section.dart`.
 *
 * The headline merges `textTheme.titleLarge` on top of the inherited text
 * style — matching `DefaultTextStyle.merge` semantics in Dart.
 */
@Composable
fun YaruSection(
    modifier: Modifier = Modifier,
    headline: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    headlinePadding: PaddingValues = PaddingValues(8.dp),
    margin: PaddingValues = PaddingValues(0.dp),
    content: @Composable () -> Unit,
) {
    // Defensive clamps: `Modifier.padding` throws on negative `Dp`, and a
    // non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject
    // non-finite values via `isFinite()`. Mirrors YaruWatermark / YaruListTile.
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
    val safeHeadlinePadding = headlinePadding.coerceNonNegative(layoutDirection)
    val safeMargin = margin.coerceNonNegative(layoutDirection)
    // Dart's `margin` is applied outside the border, matching `Container.margin`.
    YaruBorderContainer(modifier = modifier.padding(safeMargin), padding = safeContentPadding) {
        // mainAxisSize.min + crossAxisAlignment.start in Dart — Compose
        // Column is already wrap-content vertically by default and starts
        // children at the leading edge.
        Column(horizontalAlignment = Alignment.Start) {
            if (headline != null) {
                YaruProvideTextStyle(LocalYaruTypography.current.titleLarge) {
                    Box(modifier = Modifier.padding(safeHeadlinePadding)) {
                        headline()
                    }
                }
            }
            content()
        }
    }
}

