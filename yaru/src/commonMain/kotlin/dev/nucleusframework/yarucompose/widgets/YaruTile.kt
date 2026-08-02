package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography

/** Visual style of a [YaruTile]. */
@Deprecated("Use YaruListTile instead", ReplaceWith("YaruListTile"))
enum class YaruTileStyle { Normal, Banner }

/**
 * A compact list-tile-like row with leading, title, subtitle, and trailing
 * slots. Foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_tile.dart` (the deprecated
 * `YaruTile`). For new code prefer [YaruListTile].
 */
@Deprecated("Use YaruListTile instead", ReplaceWith("YaruListTile"))
@Suppress("DEPRECATION") // YaruTileStyle is deprecated in lockstep with YaruTile.
@Composable
fun YaruTile(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    subtitle: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    style: YaruTileStyle = YaruTileStyle.Normal,
) {
    val typography = LocalYaruTypography.current
    val scheme = LocalYaruColorScheme.current
    // Defensive clamp: `Modifier.padding` throws on negative `Dp`, and a
    // non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject non-finite
    // values via `isFinite()`. Mirrors the pattern in YaruWatermark / YaruListTile.
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
    // Defensive: bake the dim color directly into the title/subtitle styles when disabled — `CompositionLocalProvider(LocalYaruTextStyle provides titleStyle)` replaces (not merges) the outer style, so the disabled wrapper below cannot reach the inner solid color.
    val disabledColor = scheme.onSurface.copy(alpha = 0.38f)
    val titleStyle = if (enabled) typography.bodyLarge else typography.bodyLarge.copy(color = disabledColor)
    // Match Dart: banner uses bodyMedium font metrics with bodySmall's color
    // when enabled; dimmed when disabled (mirrors the disabled outer wrapper).
    val subtitleStyle = when (style) {
        YaruTileStyle.Normal -> if (enabled) typography.bodySmall else typography.bodySmall.copy(color = disabledColor)
        YaruTileStyle.Banner -> typography.bodyMedium.copy(
            color = if (enabled) typography.bodySmall.color else disabledColor,
        )
    }
    val rowContent: @Composable () -> Unit = {
        Row(
            modifier = modifier.padding(safeContentPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leading != null) {
                leading()
                Spacer(Modifier.width(8.dp))
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    if (style == YaruTileStyle.Banner) 0.dp else 4.dp,
                ),
            ) {
                CompositionLocalProvider(LocalYaruTextStyle provides titleStyle) {
                    title()
                }
                if (subtitle != null) {
                    CompositionLocalProvider(LocalYaruTextStyle provides subtitleStyle) {
                        subtitle()
                    }
                }
            }
            if (trailing != null) {
                Spacer(Modifier.width(8.dp))
                trailing()
            }
        }
    }
    if (enabled) {
        rowContent()
    } else {
        CompositionLocalProvider(
            LocalYaruTextStyle provides LocalYaruTextStyle.current.copy(
                color = scheme.onSurface.copy(alpha = 0.38f),
            ),
        ) {
            rowContent()
        }
    }
}

