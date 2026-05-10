package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme

/**
 * Desktop-style check button — foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_check_button.dart`. The whole row is
 * tappable: clicking title or subtitle toggles the [YaruCheckbox]. Title and
 * subtitle use the toggle-button typography (`labelLarge` / `labelMedium`),
 * matching `_wrapTextStyle` in `yaru_toggle_button.dart`.
 */
@Composable
fun YaruCheckButton(
    value: Boolean?,
    onChanged: ((Boolean?) -> Unit)?,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    // `YaruToggleButton.contentPadding` defaults to `EdgeInsets.zero` in
    // `yaru_toggle_button.dart` (line 72) — keep Dart parity, not Compose default.
    contentPadding: PaddingValues = PaddingValues(0.dp),
    tristate: Boolean = false,
    selectedColor: Color? = null,
    checkmarkColor: Color? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_check_button.dart:89. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
) {
    val enabled = onChanged != null
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val toggle: () -> Unit = {
        if (onChanged != null) {
            onChanged(
                when (value) {
                    false -> true
                    true -> if (tristate) null else false
                    null -> false
                },
            )
        }
    }
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    val button: @Composable () -> Unit = {
        // Defensive: do NOT forward `modifier` here — the caller-supplied modifier is applied to the outermost node (YaruFocusBorder or the fallback Box) below so callers like `.padding(8.dp)` / `.weight(1f)` size the whole button, not its inner toggle row.
        YaruToggleButton(
            title = title,
            subtitle = subtitle,
            contentPadding = contentPadding,
            onToggled = if (enabled) toggle else null,
            interactionSource = interactionSource,
            role = Role.Checkbox,
            // Defensive: announce checked / unchecked / indeterminate so screen readers describe the checkbox state alongside its role (tristate uses null → ToggleableState.Indeterminate).
            toggleableState = when (value) {
                true -> ToggleableState.On
                false -> ToggleableState.Off
                null -> ToggleableState.Indeterminate
            },
            leading = {
                // The whole row already handles taps — disable the inner toggleable
                // by stripping `onChanged`, but share the row's `interactionSource`
                // so the inner halo animates on row hover, mirroring Dart where
                // the inner [YaruCheckbox] and the outer [YaruToggleButton] share
                // a single `WidgetStatesController` (`yaru_check_button.dart`).
                YaruCheckbox(
                    value = value,
                    onChanged = null,
                    tristate = tristate,
                    enabled = enabled,
                    selectedColor = selectedColor,
                    checkmarkColor = checkmarkColor,
                    hasFocusBorder = false,
                    interactionSource = interactionSource,
                )
            },
        )
    }

    if (showFocusBorder) {
        YaruFocusBorder(modifier = modifier, focused = focused && enabled) { button() }
    } else {
        androidx.compose.foundation.layout.Box(modifier = modifier) { button() }
    }
}
