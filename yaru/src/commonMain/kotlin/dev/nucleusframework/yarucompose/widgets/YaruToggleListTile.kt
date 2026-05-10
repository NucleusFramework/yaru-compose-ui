package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState

/**
 * Generic list-tile wrapper used by [YaruCheckboxListTile], [YaruRadioListTile],
 * and [YaruSwitchListTile]. Foundation-only — delegates to [YaruListTile].
 *
 * Mirrors the abstract `YaruToggleListTile` from
 * `yaru.dart/lib/src/widgets/yaru_toggle_list_tile.dart`. The Dart class is
 * abstract; the Compose port is concrete because Compose composables are
 * already plain functions parameterized by content lambdas.
 */
@Composable
fun YaruToggleListTile(
    control: @Composable () -> Unit,
    title: @Composable () -> Unit,
    onToggled: (() -> Unit)?,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    secondary: @Composable (() -> Unit)? = null,
    controlAffinity: YaruListTileControlAffinity = YaruListTileControlAffinity.Leading,
    interactionSource: MutableInteractionSource? = null,
    role: Role = Role.Button,
    // Defensive: forward toggle / selected state to the inner [YaruListTile] so screen readers announce checked / on / selected alongside the role.
    toggleableState: ToggleableState? = null,
    selected: Boolean? = null,
) {
    val enabled = onToggled != null
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    YaruListTile(
        modifier = modifier,
        title = title,
        subtitle = subtitle,
        leading = when (controlAffinity) {
            YaruListTileControlAffinity.Leading -> control
            YaruListTileControlAffinity.Trailing -> secondary
        },
        trailing = when (controlAffinity) {
            YaruListTileControlAffinity.Leading -> secondary
            YaruListTileControlAffinity.Trailing -> control
        },
        onTap = if (enabled) onToggled else null,
        enabled = enabled,
        interactionSource = interactionSource,
        role = role,
        toggleableState = toggleableState,
        selected = selected,
        // Defensive: callers (YaruCheckboxListTile, etc.) own the focus ring around their own wrapper; disable the inner tile's ring to avoid two concentric halos painting on the same focused row.
        hasFocusBorder = false,
    )
}
