package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme

/**
 * Desktop-style switch button: a [YaruSwitch] with a clickable label and
 * optional subtitle. Mirrors `yaru.dart/lib/src/widgets/yaru_switch_button.dart`.
 *
 * Delegates to [YaruToggleButton], the shared toggle-button layout used by
 * [YaruCheckButton], [YaruRadioButton], and this widget.
 */
@Composable
fun YaruSwitchButton(
    value: Boolean,
    onChanged: ((Boolean) -> Unit)?,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    // `YaruToggleButton.contentPadding` defaults to `EdgeInsets.zero` in
    // `yaru_toggle_button.dart` (line 72) — keep Dart parity, not Compose default.
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onOffShapes: Boolean? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_switch_button.dart:89. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    val button: @Composable () -> Unit = {
        // Defensive: do NOT forward `modifier` here — the caller-supplied modifier is applied to the outermost node (YaruFocusBorder or the fallback Box) below so callers like `.padding(8.dp)` / `.weight(1f)` size the whole button, not its inner toggle row.
        YaruToggleButton(
            title = title,
            subtitle = subtitle,
            contentPadding = contentPadding,
            onToggled = if (onChanged != null) ({ onChanged(!value) }) else null,
            interactionSource = interactionSource,
            role = Role.Switch,
            // Defensive: announce on/off state so screen readers describe the switch's current value, not just its role.
            toggleableState = if (value) ToggleableState.On else ToggleableState.Off,
            leading = {
                // Strip the inner `onCheckedChange` so the row is the single
                // tap handler (the previous `onCheckedChange = onChanged` made
                // both the row clickable AND the inner switch toggleable,
                // double-firing). Share the row `interactionSource` so the
                // halo still animates on row hover — mirroring Dart's shared
                // `WidgetStatesController` (`yaru_switch_button.dart`).
                YaruSwitch(
                    checked = value,
                    onCheckedChange = null,
                    enabled = onChanged != null,
                    onOffShapes = onOffShapes,
                    hasFocusBorder = false,
                    interactionSource = interactionSource,
                )
            },
        )
    }

    if (showFocusBorder) {
        YaruFocusBorder(modifier = modifier, focused = focused && onChanged != null) { button() }
    } else {
        androidx.compose.foundation.layout.Box(modifier = modifier) { button() }
    }
}
