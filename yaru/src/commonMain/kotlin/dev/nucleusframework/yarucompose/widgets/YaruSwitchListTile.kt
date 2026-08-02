package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme

/**
 * A [YaruListTile] with a [YaruSwitch]. Tapping the row toggles the value.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_switch_list_tile.dart`. Foundation-
 * only — the row is a plain [YaruListTile].
 *
 * @param control optional override for the toggle slot — pass any composable
 * (typically a [YaruSwitch] surrounded by extra controls) and the row will
 * still toggle [value] on tap.
 * @param secondary content placed opposite [control] (`controlAffinity`).
 */
@Composable
fun YaruSwitchListTile(
    value: Boolean,
    onChanged: ((Boolean) -> Unit)?,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    secondary: @Composable (() -> Unit)? = null,
    control: (@Composable () -> Unit)? = null,
    controlAffinity: YaruListTileControlAffinity = YaruListTileControlAffinity.Trailing,
    onOffShapes: Boolean? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_switch_list_tile.dart:120. When `null`, fall back to the
    // inherited `LocalYaruTheme.focusBorders` (default true).
    hasFocusBorder: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val enabled = onChanged != null
    val toggle: () -> Unit = { if (onChanged != null) onChanged(!value) }
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    val resolvedControl: @Composable () -> Unit = control ?: {
        // Strip the inner `onCheckedChange` — the row is the single tap
        // handler. Share the row's `interactionSource` so the inner switch
        // halo animates on row hover (mirrors Dart's shared
        // `WidgetStatesController` in `yaru_switch_list_tile.dart`).
        YaruSwitch(
            checked = value,
            onCheckedChange = null,
            enabled = enabled,
            onOffShapes = onOffShapes,
            hasFocusBorder = false,
            interactionSource = interactionSource,
        )
    }
    val tile: @Composable () -> Unit = {
        YaruListTile(
            title = title,
            subtitle = subtitle,
            leading = when (controlAffinity) {
                YaruListTileControlAffinity.Leading -> resolvedControl
                YaruListTileControlAffinity.Trailing -> secondary
            },
            trailing = when (controlAffinity) {
                YaruListTileControlAffinity.Leading -> secondary
                YaruListTileControlAffinity.Trailing -> resolvedControl
            },
            onTap = if (enabled) toggle else null,
            enabled = enabled,
            interactionSource = interactionSource,
            role = Role.Switch,
            // Defensive: announce on/off so screen readers describe the switch's current state, not just its role.
            toggleableState = if (value) ToggleableState.On else ToggleableState.Off,
            // Defensive: this wrapper owns the focus ring (drawn once around `tile()` below); disable the inner tile's ring so we never paint two concentric halos when the row is keyboard-focused.
            hasFocusBorder = false,
        )
    }

    // Defensive: merge descendant semantics so screen readers announce "title, on, switch" as a single node — mirrors Dart's `MergeSemantics` wrapper in yaru_switch_list_tile.dart:117.
    val mergedModifier = modifier.semantics(mergeDescendants = true) {}
    if (showFocusBorder) {
        YaruFocusBorder(modifier = mergedModifier, focused = focused && enabled) { tile() }
    } else {
        androidx.compose.foundation.layout.Box(modifier = mergedModifier) { tile() }
    }
}
