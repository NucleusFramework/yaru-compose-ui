package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.inner
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants

// Mirrors `_kAnimationDuration` (250 ms) in yaru_selectable_container.dart.
private const val SelectionAnimationMs: Int = 250

/**
 * A container that highlights its background fill when [selected] is true.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_selectable_container.dart`. The
 * default selection color is `primary @ 0.8` and animates over 250ms. When
 * the surrounding [LocalYaruTheme] enables focus borders, a primary
 * [YaruFocusBorder] is drawn around the container.
 */
@Composable
fun YaruSelectableContainer(
    selected: Boolean,
    onTap: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    radius: Dp = YaruConstants.ContainerRadius,
    // Defensive clamp: `RoundedCornerShape` with a negative corner size
    // produces an invalid path that crashes the rasterizer at draw time. For
    // finite inputs route through the canonical `Dp.sanitise()` foundation
    // helper; non-finite inputs (e.g. `Dp.Unspecified`) fall back to the
    // theme container radius rather than `0.dp` to preserve the visual default.
    shape: Shape = RoundedCornerShape(
        if (radius.value.isFinite()) radius.sanitise() else YaruConstants.ContainerRadius,
    ),
    contentPadding: PaddingValues = PaddingValues(6.dp),
    selectionColor: Color? = null,
    hasFocusBorder: Boolean? = null,
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val themeData = LocalYaruTheme.current
    // Defensive clamp: a caller-supplied `Color.Unspecified` or non-finite
    // alpha would crash `animateColorAsState` / `background()`. Route through
    // the canonical foundation helper.
    val effectiveSelectionColor = sanitiseColor(
        selectionColor ?: scheme.primary.copy(alpha = 0.8f),
    )
    // Curves.linear / 250 ms (`_kAnimationDuration`, default
    // `AnimatedContainer.curve`) from yaru_selectable_container.dart.
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) effectiveSelectionColor else Color.Transparent,
        animationSpec = tween(durationMillis = SelectionAnimationMs, easing = LinearEasing),
    )
    val showFocusBorder = hasFocusBorder ?: (themeData?.focusBorders == true)

    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    // Inner clip mirrors Dart's `ClipRRect(borderRadius.inner(padding))`.
    // The Dart code SHRINKS the corner radius by the resolved padding so the
    // child's rounded corners stay concentric with the outer shape. For the
    // common `RoundedCornerShape` case we compute the shrunk shape via
    // [RoundedCornerShape.inner]; otherwise we fall back to the same shape.
    val layoutDirection = LocalLayoutDirection.current
    // Defensive clamp via the canonical foundation helper:
    // `Modifier.padding` throws on negative `Dp`, and a non-finite Dp
    // (NaN / ±Infinity) blows up `roundToPx()`.
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
    val innerShape: Shape = if (shape is RoundedCornerShape) {
        shape.inner(safeContentPadding, layoutDirection)
    } else {
        shape
    }

    val container = @Composable {
        // Defensive: do NOT prepend `modifier` here — the outermost layout node is the YaruFocusBorder (or the fallback Box) below; applying caller modifiers there guarantees `.weight(1f)` / `.padding(...)` size the entire container, focus ring included.
        Box(
            modifier = Modifier
                .clip(shape)
                .background(color = backgroundColor)
                .let {
                    if (onTap != null) {
                        it
                            // Mirrors Dart `InkWell.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click`) — see
                            // `yaru_selectable_container.dart:60`.
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = androidx.compose.foundation.LocalIndication.current,
                                role = Role.Button,
                                onClick = onTap,
                            )
                            // Defensive: announce selected state so screen readers describe selection alongside the button role.
                            .semantics { this.selected = selected }
                    } else it
                }
                .padding(safeContentPadding),
        ) {
            Box(modifier = Modifier.clip(innerShape)) {
                content()
            }
        }
    }

    // Dart wraps with `YaruFocusBorder.primary` regardless of whether `onTap`
    // is provided (yaru_selectable_container.dart:82–84). When `onTap` is null
    // the container can never gain keyboard focus anyway, so the ring stays
    // invisible — but mirroring the unconditional wrap keeps layout/sizing
    // identical between selectable and non-selectable instances.
    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier,
            focused = focused,
            borderShape = shape,
        ) {
            container()
        }
    } else {
        // Defensive: route caller `modifier` onto the outermost layout node so caller-supplied sizing / weighting / test tags reach the entire container, not the inner clip+background Box.
        Box(modifier = modifier) { container() }
    }
}
