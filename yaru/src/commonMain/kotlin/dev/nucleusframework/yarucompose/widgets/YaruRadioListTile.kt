package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * A [YaruListTile] paired with a [YaruRadio]. Tapping the row selects [value].
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_radio_list_tile.dart`. Foundation-
 * only — uses `YaruListTile` instead of Material3 `ListItem`. The inner
 * radio is rendered with `hasFocusBorder = false` so the surrounding
 * [YaruFocusBorder] (when [hasFocusBorder] is true) is the single source
 * of focus styling — matching the Dart implementation.
 */
@Composable
fun <T> YaruRadioListTile(
    value: T,
    groupValue: T?,
    onChanged: ((T?) -> Unit)?,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    secondary: @Composable (() -> Unit)? = null,
    controlAffinity: YaruListTileControlAffinity = YaruListTileControlAffinity.Leading,
    toggleable: Boolean = false,
    contentPadding: PaddingValues? = null,
    shape: Shape = RoundedCornerShape(YaruConstants.ButtonRadius),
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_radio_list_tile.dart:132. When `null`, fall back to the
    // inherited `LocalYaruTheme.focusBorders` (default true).
    hasFocusBorder: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val enabled = onChanged != null
    val onClick: () -> Unit = {
        if (onChanged != null) {
            if (toggleable && value == groupValue) onChanged(null) else onChanged(value)
        }
    }
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    val radio: @Composable () -> Unit = {
        // Strip the inner `onChanged` — the row is the single tap handler.
        // Share the row's `interactionSource` so the inner radio halo animates
        // on row hover (mirrors Dart's shared `WidgetStatesController` in
        // `yaru_radio_list_tile.dart`).
        YaruRadio(
            value = value,
            groupValue = groupValue,
            onChanged = null,
            enabled = enabled,
            toggleable = toggleable,
            hasFocusBorder = false,
            interactionSource = interactionSource,
        )
    }
    val tile: @Composable () -> Unit = {
        YaruListTile(
            title = title,
            subtitle = subtitle,
            leading = when (controlAffinity) {
                YaruListTileControlAffinity.Leading -> radio
                YaruListTileControlAffinity.Trailing -> secondary
            },
            trailing = when (controlAffinity) {
                YaruListTileControlAffinity.Leading -> secondary
                YaruListTileControlAffinity.Trailing -> radio
            },
            onTap = if (enabled) onClick else null,
            enabled = enabled,
            contentPadding = contentPadding,
            shape = shape,
            interactionSource = interactionSource,
            role = Role.RadioButton,
            // Defensive: announce selected / unselected so screen readers describe the radio's state alongside its role.
            selected = value == groupValue,
            // Defensive: this wrapper owns the focus ring (drawn once around `tile()` below); disable the inner tile's ring so we never paint two concentric halos when the row is keyboard-focused.
            hasFocusBorder = false,
        )
    }

    // Defensive: merge descendant semantics so screen readers announce "title, selected, radio button" as a single node — mirrors Dart's `MergeSemantics` wrapper in yaru_radio_list_tile.dart:129.
    val mergedModifier = modifier.semantics(mergeDescendants = true) {}
    if (showFocusBorder) {
        YaruFocusBorder(modifier = mergedModifier, borderShape = shape, focused = focused && enabled) {
            tile()
        }
    } else {
        androidx.compose.foundation.layout.Box(modifier = mergedModifier) { tile() }
    }
}
