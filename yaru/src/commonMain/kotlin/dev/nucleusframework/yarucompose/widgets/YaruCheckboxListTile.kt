package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme

/** Where the toggle control sits inside a Yaru list tile. */
enum class YaruListTileControlAffinity { Leading, Trailing }

/**
 * A [YaruListTile] with a [YaruCheckbox]. Tapping the row toggles the value.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_checkbox_list_tile.dart`. Delegates
 * the layout to [YaruToggleListTile] so that secondary slots and tap behaviour
 * stay in sync with [YaruRadioListTile] / [YaruSwitchListTile].
 */
@Composable
fun YaruCheckboxListTile(
    value: Boolean?,
    onChanged: ((Boolean?) -> Unit)?,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    secondary: @Composable (() -> Unit)? = null,
    controlAffinity: YaruListTileControlAffinity = YaruListTileControlAffinity.Leading,
    tristate: Boolean = false,
    selectedColor: Color? = null,
    checkmarkColor: Color? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_checkbox_list_tile.dart:132. When `null`, fall back to the
    // inherited `LocalYaruTheme.focusBorders` (default true).
    hasFocusBorder: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    require(tristate || value != null) {
        "value must be non-null when tristate is false"
    }
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

    val tile: @Composable () -> Unit = {
        YaruToggleListTile(
            title = title,
            subtitle = subtitle,
            secondary = secondary,
            controlAffinity = controlAffinity,
            onToggled = if (onChanged != null) toggle else null,
            interactionSource = interactionSource,
            role = Role.Checkbox,
            // Defensive: announce checked / unchecked / indeterminate so screen readers describe the checkbox state alongside its role (tristate uses null → ToggleableState.Indeterminate).
            toggleableState = when (value) {
                true -> ToggleableState.On
                false -> ToggleableState.Off
                null -> ToggleableState.Indeterminate
            },
            control = {
                // Strip the inner toggleable — the whole tile already toggles.
                // Share the row's `interactionSource` so the inner checkbox's
                // halo animates on row hover, matching Dart where the
                // [YaruCheckbox] inside a [YaruCheckboxListTile] keeps its own
                // `onChanged` (and so its `WidgetStatesController` reacts to
                // the InkWell's hover state — `yaru_checkbox_list_tile.dart`).
                YaruCheckbox(
                    value = value,
                    onChanged = null,
                    tristate = tristate,
                    enabled = onChanged != null,
                    selectedColor = selectedColor,
                    checkmarkColor = checkmarkColor,
                    hasFocusBorder = false,
                    interactionSource = interactionSource,
                )
            },
        )
    }

    // Defensive: merge descendant semantics so screen readers announce "title, checked, checkbox" as a single node — mirrors Dart's `MergeSemantics` wrapper in yaru_checkbox_list_tile.dart:129.
    val mergedModifier = modifier.semantics(mergeDescendants = true) {}
    if (showFocusBorder) {
        YaruFocusBorder(modifier = mergedModifier, focused = focused && onChanged != null) { tile() }
    } else {
        androidx.compose.foundation.layout.Box(modifier = mergedModifier) { tile() }
    }
}
