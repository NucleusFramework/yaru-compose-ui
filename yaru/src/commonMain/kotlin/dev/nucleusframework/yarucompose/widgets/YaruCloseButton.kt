package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants

/** Mirrors `_kCloseButtonSize = 32.0` from `yaru_close_button.dart`. */
private val CloseButtonSize = 32.dp

/**
 * Small icon button used to close a window or dismiss a dialog. Foundation-
 * only, no Material3 dependency.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_close_button.dart`: the Dart
 * implementation passes `iconSize: _kCloseButtonSize = 32` to [YaruIconButton],
 * which sets the button's `fixedSize` (hit target) to 32x32. The glyph itself
 * has no explicit `size` and inherits `IconButtonTheme.iconSize = kYaruIconSize`
 * (= 20) from `common_themes.dart:152` — i.e. the button surface is 32 dp
 * square, the glyph inside is 20 dp.
 *
 * Accessibility / tooltip:
 *  - The Dart widget does not pass a `tooltip` to its [YaruIconButton], but
 *    accepts a `semanticLabel` for the icon glyph. The Compose port mirrors
 *    that surface and additionally exposes [tooltip] for callers that want a
 *    hover hint — forwarded to [YaruIconButton] (no-op until tooltip support
 *    lands; preserved for API parity).
 *
 * Navigation:
 *  - Dart falls back to `Navigator.maybePop` when `onPressed` is null.
 *    Compose multiplatform has no shared Navigator, so [onPressed] is
 *    required.
 */
@Composable
fun YaruCloseButton(
    onPressed: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alignment: Alignment = Alignment.Center,
    tooltip: String? = null,
    semanticLabel: String? = null,
    icon: @Composable () -> Unit = {
        // Glyph inherits `IconButtonTheme.iconSize = kYaruIconSize` (20) in
        // Dart — see `yaru_close_button.dart:32` (no explicit `size`).
        YaruIcon(glyph = YaruIcons.window_close, size = YaruConstants.IconSize)
    },
) {
    Box(modifier = modifier, contentAlignment = alignment) {
        YaruIconButton(
            onPressed = if (enabled) onPressed else null,
            iconSize = CloseButtonSize,
            tooltip = tooltip,
            // Defensive: forward `semanticLabel` (was previously suppressed) so the close glyph carries an accessible name; treat empty strings as "absent" so the elvis falls through to a usable label or null instead of producing `contentDescription = ""`.
            // Defensive: also reject whitespace-only candidates — they would silence the screen reader announcement and still block the tooltip fallback.
            semanticLabel = semanticLabel?.takeIf { it.isNotBlank() } ?: tooltip?.takeIf { it.isNotBlank() },
            icon = icon,
        )
    }
}
