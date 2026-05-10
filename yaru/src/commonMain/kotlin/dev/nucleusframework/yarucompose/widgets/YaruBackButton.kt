package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons

/** The button shape variants for [YaruBackButton]. */
enum class YaruBackButtonStyle { Rounded, Square }

/**
 * Yaru-styled back button — foundation-only, no Material3 dependency.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_back_button.dart`:
 *  - [YaruBackButtonStyle.Rounded]: shape = `CircleBorder`, wrapped in a
 *    [Box] with [Alignment.Center] so the circular surface is centred.
 *  - [YaruBackButtonStyle.Square] (default): shape = sharp rectangle
 *    (`BeveledRectangleBorder` with zero radius in Dart, [RectangleShape]
 *    here).
 *
 * Accessibility / tooltip:
 *  - Dart sources the tooltip from `MaterialLocalizations.backButtonTooltip`
 *    ("Back" in en_US). Compose multiplatform commonMain has no equivalent
 *    locale-aware string, so [tooltip] defaults to the English literal.
 *    Callers should override with a localized value when available.
 *  - [tooltip] is forwarded to [YaruIconButton], which currently treats it as
 *    a no-op (see kdoc on [YaruIconButton]) — wired through for API parity.
 *  - [semanticLabel] mirrors the Dart accessibility hint on the icon glyph.
 *
 * Navigation:
 *  - Dart falls back to `Navigator.maybePop(context)` when `onPressed` is
 *    null. Compose multiplatform has no shared Navigator, so [onPressed] is
 *    required — callers wire it to whichever navigation primitive they use.
 */
@Composable
fun YaruBackButton(
    onPressed: () -> Unit,
    modifier: Modifier = Modifier,
    style: YaruBackButtonStyle = YaruBackButtonStyle.Square,
    tooltip: String? = "Back",
    semanticLabel: String? = null,
    icon: @Composable () -> Unit = { YaruIcon(YaruIcons.go_previous) },
) {
    val shape = if (style == YaruBackButtonStyle.Rounded) CircleShape else RectangleShape
    val button: @Composable (Modifier) -> Unit = { innerModifier ->
        YaruIconButton(
            onPressed = onPressed,
            modifier = innerModifier,
            shape = shape,
            tooltip = tooltip,
            // Defensive: forward `semanticLabel` (was previously suppressed) so the back glyph carries an accessible name for screen readers; treat empty strings as "absent" so the elvis falls through to a usable label or null instead of producing `contentDescription = ""`.
            // Defensive: also reject whitespace-only candidates — they would silence the screen reader announcement and still block the tooltip fallback.
            semanticLabel = semanticLabel?.takeIf { it.isNotBlank() } ?: tooltip?.takeIf { it.isNotBlank() },
            icon = icon,
        )
    }
    if (style == YaruBackButtonStyle.Rounded) {
        // Defensive: apply `modifier` on the outer centering Box (mirrors Dart `Center(child: button)` — `Center` expands to its parent, then centers the button); previously the modifier hit the inner button so any caller-supplied size or fillMaxSize was wasted and the alignment never took effect.
        Box(modifier = modifier, contentAlignment = Alignment.Center) { button(Modifier) }
    } else {
        button(modifier)
    }
}
