package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme

/**
 * Desktop-style radio button: a [YaruRadio] with a clickable label and optional
 * subtitle. Mirrors `yaru.dart/lib/src/widgets/yaru_radio_button.dart`.
 *
 * Delegates to [YaruToggleButton] for the row layout, mirroring the Dart
 * implementation, and embeds a [YaruRadio] with `hasFocusBorder = false` so
 * the surrounding [YaruFocusBorder] (when [hasFocusBorder] is true) is the
 * single source of focus styling — matching `yaru_radio_button.dart`.
 */
@Composable
fun <T> YaruRadioButton(
    value: T,
    groupValue: T?,
    onChanged: ((T?) -> Unit)?,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    toggleable: Boolean = false,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_radio_button.dart:95. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val onToggled: (() -> Unit)? = if (onChanged == null) null else {
        {
            if (toggleable && value == groupValue) onChanged(null) else onChanged(value)
        }
    }

    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    val button: @Composable () -> Unit = {
        // Defensive: do NOT forward `modifier` here — the caller-supplied modifier is applied to the outermost node (YaruFocusBorder or the fallback Box) below so callers like `.padding(8.dp)` / `.weight(1f)` size the whole button, not its inner toggle row.
        YaruToggleButton(
            leading = {
                // Strip the inner `onChanged` so the row is the single tap
                // handler (the previous `onChanged = onChanged` made both the
                // row clickable AND the inner radio selectable, double-firing).
                // Share the row `interactionSource` so the halo still animates
                // on row hover — mirroring Dart's shared `WidgetStatesController`
                // (`yaru_radio_button.dart`).
                YaruRadio(
                    value = value,
                    groupValue = groupValue,
                    onChanged = null,
                    enabled = onChanged != null,
                    toggleable = toggleable,
                    hasFocusBorder = false,
                    interactionSource = interactionSource,
                )
            },
            title = title,
            subtitle = subtitle,
            onToggled = onToggled,
            contentPadding = contentPadding,
            interactionSource = interactionSource,
            role = Role.RadioButton,
            // Defensive: announce selected / unselected so screen readers describe the radio's state alongside its role.
            selected = value == groupValue,
        )
    }

    if (showFocusBorder) {
        YaruFocusBorder(modifier = modifier, focused = focused && onChanged != null) { button() }
    } else {
        androidx.compose.foundation.layout.Box(modifier = modifier) { button() }
    }
}
