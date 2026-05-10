package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.toggleableState
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import kotlin.math.max

/**
 * Desktop-style toggle button: a leading control + a clickable label / subtitle.
 * Foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_toggle_button.dart` (and its
 * `_YaruToggleButtonLayout` companion). [YaruCheckButton], [YaruRadioButton],
 * and [YaruSwitchButton] are concrete users of this abstraction.
 *
 * Uses a custom [Layout] (not `Row` + `Column`) so the leading control is
 * centered against the TITLE alone, mirroring `_YaruRenderToggleButton`
 * (`yaru_toggle_button_layout.dart` lines 191-258). A plain
 * `Row(verticalAlignment = CenterVertically)` would re-center the leading
 * across the whole title+subtitle stack and visibly drop it when a subtitle
 * is present.
 */
@Composable
fun YaruToggleButton(
    leading: @Composable () -> Unit,
    title: @Composable () -> Unit,
    onToggled: (() -> Unit)?,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalSpacing: Dp = 8.dp,
    verticalSpacing: Dp = 4.dp,
    interactionSource: MutableInteractionSource? = null,
    role: Role? = null,
    // Defensive: state announcement for screen readers — set when the button represents a toggle (`toggleableState`) or one-of-many selection (`selected`). Without these, TalkBack/VoiceOver announce only the role, never the current state.
    toggleableState: ToggleableState? = null,
    selected: Boolean? = null,
) {
    val enabled = onToggled != null
    val typography = LocalYaruTypography.current
    val scheme = LocalYaruColorScheme.current
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val ownInteraction = remember { MutableInteractionSource() }
    val src = interactionSource ?: ownInteraction

    // Defensive: `Modifier.padding(PaddingValues)` throws on negative edges,
    // and a non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`. NaN
    // bypasses `coerceAtLeast` (NaN comparisons all return false), so reject
    // non-finite values via `isFinite()`. Mirrors YaruListTile pattern.
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
    // Defensive: NaN / negative spacing would feed `roundToPx()` inside the
    // custom Layout block below and corrupt placement arithmetic.
    val safeHorizontalSpacing = horizontalSpacing.sanitise()
    val safeVerticalSpacing = verticalSpacing.sanitise()

    // Dart's `YaruToggleButton.build` (yaru_toggle_button.dart line 61) wraps
    // the row in a `GestureDetector + MouseRegion`, NOT an InkWell — there is
    // NO row-level hover overlay. The only hover effect comes from the inner
    // togglable's halo, which animates because the inner widget shares the
    // row's `WidgetStatesController`. We mirror that by passing
    // `indication = null` and sharing `src` with the inner togglable (see
    // [YaruCheckButton] / [YaruRadioButton] / [YaruSwitchButton]).
    val rowModifier = modifier
        // Defensive: merge descendant semantics so screen readers announce "title, on, switch" as a single node — mirrors Dart's `MergeSemantics` wrapper in yaru_toggle_button.dart:97.
        .semantics(mergeDescendants = true) {}
        .let {
            if (onToggled != null) {
                it
                    // Mirrors Dart `MouseRegion(cursor: mouseCursor)` wrapping
                    // the row in yaru_toggle_button.dart:66-67. When the
                    // togglable is interactive, the resolved cursor is
                    // `SystemMouseCursors.click` via
                    // `WidgetStateMouseCursor.clickable` (yaru_togglable.dart:253-256).
                    .pointerHoverIcon(PointerIcon.Hand)
                    .clickable(
                        interactionSource = src,
                        indication = null,
                        role = role,
                        onClick = onToggled,
                    )
                    // Defensive: merge state into the clickable's semantics node so screen readers announce on/off / selected state alongside the role.
                    .let { m ->
                        if (toggleableState != null || selected != null) {
                            m.semantics {
                                if (toggleableState != null) this.toggleableState = toggleableState
                                if (selected != null) this.selected = selected
                            }
                        } else m
                    }
            } else it
        }
        .padding(safeContentPadding)

    val titleSlot: @Composable () -> Unit = {
        CompositionLocalProvider(
            LocalYaruTextStyle provides typography.labelLarge.copy(
                color = if (enabled) scheme.onSurface
                else scheme.onSurface.copy(alpha = 0.38f),
            ),
        ) { title() }
    }
    val subtitleSlot: (@Composable () -> Unit)? = subtitle?.let {
        {
            CompositionLocalProvider(
                LocalYaruTextStyle provides typography.labelMedium.copy(
                    color = if (enabled) scheme.onSurfaceVariant
                    else scheme.onSurface.copy(alpha = 0.38f),
                ),
            ) { it() }
        }
    }

    Layout(
        modifier = rowModifier,
        content = {
            leading()
            titleSlot()
            subtitleSlot?.invoke()
        },
    ) { measurables, constraints ->
        // Defensive: clamp spacing non-negative — a negative Dp would push
        // title placement to negative X / collapse the layout width below 0.
        val horizontalSpacingPx = safeHorizontalSpacing.roundToPx().coerceAtLeast(0)
        val verticalSpacingPx = safeVerticalSpacing.roundToPx().coerceAtLeast(0)

        // Defensive: a caller-supplied `leading` / `title` lambda may emit zero
        // Layout nodes (e.g. an empty composable wrapping a conditional), so
        // `measurables[0]` / `[1]` would throw IndexOutOfBoundsException. Use
        // `getOrNull` and skip measuring missing slots.
        val leadingMeasurable = measurables.getOrNull(0)
        val titleMeasurable = measurables.getOrNull(1)
        val subtitleMeasurable = measurables.getOrNull(2)

        // Loosen min constraints so leading and text take their intrinsic size
        // (mirroring `BoxConstraints.loosen()` in Dart layout line 192).
        val loosened = constraints.copy(minWidth = 0, minHeight = 0)
        val leadingPlaceable = leadingMeasurable?.measure(loosened)
        val leadingWidth = leadingPlaceable?.width ?: 0
        val leadingHeight = leadingPlaceable?.height ?: 0

        val textMaxWidth = if (loosened.hasBoundedWidth) {
            (loosened.maxWidth - leadingWidth - horizontalSpacingPx)
                .coerceAtLeast(0)
        } else {
            Constraints.Infinity
        }
        val textConstraints = Constraints(
            minWidth = 0,
            maxWidth = textMaxWidth,
            minHeight = 0,
            maxHeight = loosened.maxHeight,
        )
        val titlePlaceable = titleMeasurable?.measure(textConstraints)
        val titleWidth = titlePlaceable?.width ?: 0
        val titleHeight = titlePlaceable?.height ?: 0
        val subtitlePlaceable = subtitleMeasurable?.measure(textConstraints)

        // Mirrors `_YaruRenderToggleButton.performLayout` (lines 215-217):
        // `leadingY = max(0, (titleSize.height - leadingSize.height) / 2)`
        // — leading centered against the TITLE only, not the whole column.
        val leadingY = max(0, (titleHeight - leadingHeight) / 2)
        val titleY = max(0, (leadingHeight - titleHeight) / 2)
        val subtitleY = if (subtitlePlaceable != null) {
            titleY + titleHeight + verticalSpacingPx
        } else 0

        val contentWidth = leadingWidth + horizontalSpacingPx +
            max(titleWidth, subtitlePlaceable?.width ?: 0)
        val contentHeight = max(
            leadingHeight,
            if (subtitlePlaceable != null) {
                subtitleY + subtitlePlaceable.height
            } else {
                titleY + titleHeight
            },
        )
        // Defensive: when parent constraints are unbounded (`Constraints.Infinity` = Int.MAX_VALUE), `coerceIn(minWidth, Infinity)` would feed Int.MAX_VALUE to `layout()` if `contentWidth` somehow overflowed; coerce against minWidth only when unbounded.
        val width = if (constraints.hasBoundedWidth) contentWidth.coerceIn(constraints.minWidth, constraints.maxWidth) else contentWidth.coerceAtLeast(constraints.minWidth)
        val height = if (constraints.hasBoundedHeight) contentHeight.coerceIn(constraints.minHeight, constraints.maxHeight) else contentHeight.coerceAtLeast(constraints.minHeight)

        layout(width, height) {
            // `placeRelative` already mirrors x in RTL — express positions in
            // LTR (start = 0) coordinates and let the placement scope flip
            // them when `layoutDirection == Rtl`.
            leadingPlaceable?.placeRelative(0, leadingY)
            val titleX = leadingWidth + horizontalSpacingPx
            titlePlaceable?.placeRelative(titleX, titleY)
            subtitlePlaceable?.placeRelative(titleX, subtitleY)
        }
    }
}

