package dev.nucleusframework.yarucompose.widgets.master_detail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.widgets.YaruFocusBorder
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.rememberKeyboardFocusedState

/**
 * The recommended tile for `YaruMasterDetailPage.tileBuilder` — foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/master_detail/yaru_master_tile.dart`.
 */
@Composable
fun YaruMasterTile(
    title: @Composable () -> Unit,
    selected: Boolean,
    onTap: () -> Unit,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    subtitle: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp),
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_master_tile.dart:98. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val layoutDirection = LocalLayoutDirection.current
    // Defensive: `Modifier.padding(PaddingValues)` throws on any negative edge.
    val safePadding = contentPadding.coerceNonNegative(layoutDirection)
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    // Mirrors `_createListTileTheme.selectedTileColor`:
    //   onSurface @ 0.04 (light) / 0.035 (dark).
    val selectedFill = scheme.onSurface.copy(alpha = if (scheme.isLight) 0.04f else 0.035f)
    // Curves.linear / 250 ms (`Durations.medium1`, default `AnimatedContainer.curve`)
    // from yaru_master_tile.dart.
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) selectedFill else Color.Transparent,
        animationSpec = tween(durationMillis = 250, easing = LinearEasing),
    )
    // Mirrors `yaru_master_tile.dart:65-67` —
    //   `foregroundColor = isSelected ? listTileTheme.selectedColor : listTileTheme.textColor`.
    // `_createListTileTheme` only sets `selectedColor = onSurface` (non-HC, common_themes.dart:801-803);
    // `textColor` is NOT set, so unselected tiles inherit the ambient text color (full-opacity onSurface).
    // The Dart `iconColor: onSurface @ 0.8` (line 804) only applies to icons, not title/subtitle text.
    val foregroundColor = if (selected) scheme.onSurface else scheme.onSurface
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    // Outer Box owns the clip + background + clickable so YaruListTile renders
    // inside the rounded selected fill. We pass `onTap = null` to YaruListTile to
    // avoid stacking two `clickable` indications on top of each other.
    val tile: @Composable () -> Unit = {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .clip(shape)
                .background(backgroundColor)
                // Mirrors Dart `InkWell.mouseCursor` default
                // (`WidgetStateMouseCursor.clickable` → `SystemMouseCursors.click`)
                // used by the inner `YaruListTile`.
                .pointerHoverIcon(PointerIcon.Hand)
                .clickable(
                    interactionSource = interactionSource,
                    indication = androidx.compose.foundation.LocalIndication.current,
                    role = Role.Button,
                    onClick = onTap,
                )
                // Defensive: announce selected state so screen readers describe which master tile is currently active alongside its button role.
                .semantics { this.selected = selected },
        ) {
            YaruListTile(
                leading = leading,
                title = {
                    CompositionLocalProvider(
                        LocalYaruTextStyle provides LocalYaruTextStyle.current.copy(color = foregroundColor),
                    ) {
                        title()
                    }
                },
                subtitle = subtitle?.let {
                    {
                        CompositionLocalProvider(
                            LocalYaruTextStyle provides LocalYaruTextStyle.current.copy(color = foregroundColor),
                        ) {
                            it()
                        }
                    }
                },
                trailing = trailing,
                onTap = null,
                // YaruMasterTile owns its own focus ring around the rounded
                // selected fill — disable the inner YaruListTile ring so we
                // don't stack two accent rings on top of each other.
                hasFocusBorder = false,
            )
        }
    }

    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier.padding(safePadding),
            borderShape = shape,
            // Mirror Dart `yaru_master_tile.dart:100` —
            //   `YaruFocusBorder(borderStrokeAlign: BorderSide.strokeAlignInside, ...)`.
            // strokeAlignInside == -1 → stroke painted entirely INSIDE the tile bounds
            // so the focus ring hugs the rounded selected fill rather than sitting in
            // a halo around it (the default 3 = outside is wrong for master tiles).
            borderStrokeAlign = -1f,
            focused = focused,
        ) { tile() }
    } else {
        androidx.compose.foundation.layout.Box(modifier = modifier.padding(safePadding)) { tile() }
    }
}

