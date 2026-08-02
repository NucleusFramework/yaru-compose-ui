package dev.nucleusframework.yarucompose.widgets.navi_rail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.YaruIndication

/** Style of a [YaruNavigationRailItem]. */
enum class YaruNavigationRailStyle {
    /** Icon only — default 60.dp wide. */
    Compact,

    /** Icon over label — default 100.dp wide. */
    Labelled,

    /** Icon next to label — default 250.dp wide. */
    LabelledExtended,
}

/**
 * A single tile in a [YaruNavigationRail].
 *
 * Mirrors `yaru.dart/lib/src/widgets/navi_rail/yaru_navigation_rail_item.dart`.
 *
 * Geometry contract (Dart):
 *  - Default widths: compact=60, labelled=100, labelledExtended=250.
 *  - Icon padding inside its hit area: vertical=2, horizontal=10.
 *  - Non-extended selected indicator: pill (`circular(100)`) wrapping only the icon.
 *  - Extended selected indicator: rounded rect (`kYaruButtonRadius`) wrapping icon + label,
 *    with vertical=labelledExtended ? 5 : 2, horizontal=2 inner padding.
 *  - InkWell padding around the whole tile:
 *      vertical = (labelledExtended && !extendedIndicator) ? 10 : 5
 *      horizontal = (labelledExtended && !extendedIndicator) ? 8 : 5
 *  - Label fontSize: labelledExtended ? 13 : 12, weight=500, ellipsis, max 1 line.
 *  - Width animates over 200 ms; selected color animates over 250 ms.
 */
@Composable
fun YaruNavigationRailItem(
    icon: @Composable () -> Unit,
    selected: Boolean,
    onTap: () -> Unit,
    style: YaruNavigationRailStyle,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    extendedSelectedIndicator: Boolean = false,
    width: Dp? = null,
    borderRadius: Shape? = null,
) {
    require(style == YaruNavigationRailStyle.Compact || label != null) {
        "label is required for non-compact styles"
    }

    val scheme = LocalYaruColorScheme.current
    val labelledExtended = style == YaruNavigationRailStyle.LabelledExtended
    val extendedIndicator = extendedSelectedIndicator && style != YaruNavigationRailStyle.Compact

    val defaultWidth = when (style) {
        YaruNavigationRailStyle.Compact -> 60.dp
        YaruNavigationRailStyle.Labelled -> 100.dp
        YaruNavigationRailStyle.LabelledExtended -> 250.dp
    }
    // Defensive: a negative or non-finite width from a caller would propagate
    // through `animateDpAsState` and crash `Modifier.width()`. Coerce to the
    // style default in that case.
    val targetWidth = width?.takeIf { it.value.isFinite() && it.value >= 0f } ?: defaultWidth
    // Curves.linear / 200 ms (`_kSizeAnimationDuration`, default
    // `AnimatedSize.curve`) from yaru_navigation_rail_item.dart.
    val animatedWidth by animateDpAsState(
        targetValue = targetWidth,
        animationSpec = tween(durationMillis = 200, easing = LinearEasing),
    )

    // Curves.linear / 250 ms (`_kSelectedIconAnimationDuration`, default
    // `AnimatedContainer.curve`) from yaru_navigation_rail_item.dart.
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) {
            scheme.onSurface.copy(alpha = 0.1f)
        } else {
            Color.Transparent
        },
        animationSpec = tween(durationMillis = 250, easing = LinearEasing),
    )

    // Dart `_buildLabel` (yaru_navigation_rail_item.dart:256-270) does NOT set
    // a color on the label — it relies on the ambient DefaultTextStyle. We
    // therefore inherit from `LocalYaruTextStyle` and only override fontSize /
    // weight / textAlign below, never the color.
    val extendedShape = borderRadius ?: RoundedCornerShape(YaruConstants.ButtonRadius)
    // Pill indicator for the icon-only case (Dart uses `BorderRadius.circular(100)`).
    val iconShape = borderRadius ?: RoundedCornerShape(100.dp)

    val tilePadding = if (labelledExtended && !extendedIndicator) {
        PaddingValues(horizontal = 8.dp, vertical = 10.dp)
    } else {
        PaddingValues(horizontal = 5.dp, vertical = 5.dp)
    }

    // shared MutableInteractionSource — drives hover overlay / ripple via
    // LocalIndication. No accent focus ring is drawn: Dart
    // `yaru_navigation_rail_item.dart` has no `YaruFocusBorder` (verified by
    // `grep -nE "YaruFocusBorder|focusBorders" navi_rail/*.dart`); focus is
    // expressed via the standard InkWell highlight only.
    val interactionSource = remember { MutableInteractionSource() }
    // Defensive: pin the hover/focus indication to a neutral `onSurface` overlay so a leaked `LocalIndication` from an ancestor cannot tint the rail item with the accent color — Dart's InkWell uses the default neutral `hoverColor` (Colors.black @ 0.04), never the primary.
    val railIndication = remember(scheme.onSurface) { YaruIndication(scheme.onSurface) }

    val outerModifier = Modifier
        .width(animatedWidth)
        // Mirrors Dart `InkWell.mouseCursor` default
        // (`WidgetStateMouseCursor.clickable` → `SystemMouseCursors.click`)
        // — yaru_navigation_rail_item.dart wraps the tile in an `InkWell`.
        .pointerHoverIcon(PointerIcon.Hand)
        .clickable(
            interactionSource = interactionSource,
            indication = railIndication,
            role = Role.Button,
            onClick = onTap,
        )
        // Defensive: announce which navigation destination is currently selected so screen readers describe the active item alongside its role.
        .semantics { this.selected = selected }
        .padding(tilePadding)

    val iconContent: @Composable () -> Unit = {
        // Inner icon padding from Dart `_buildIcon`.
        val iconInner = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
        if (extendedIndicator) {
            // No icon-only indicator; the indicator is on the parent container.
            Box(modifier = iconInner) { icon() }
        } else {
            Box(
                modifier = Modifier
                    .clip(iconShape)
                    .background(backgroundColor)
                    .then(iconInner),
                contentAlignment = Alignment.Center,
            ) { icon() }
        }
    }

    val labelContent: @Composable () -> Unit = label@{
        if (label == null) return@label
        // Dart `_buildLabel` only overrides fontSize / fontWeight / textAlign
        // (line 259-266) — color is inherited from the surrounding text style.
        val labelStyle = LocalYaruTextStyle.current.copy(
            fontSize = if (labelledExtended) 13.sp else 12.sp,
            fontWeight = FontWeight.W500,
            textAlign = if (labelledExtended) TextAlign.Start else TextAlign.Center,
        )
        CompositionLocalProvider(LocalYaruTextStyle provides labelStyle) {
            // Note: foundation `BasicText` honors maxLines/overflow when used by `YaruText`.
            label()
        }
    }

    // Apply the surrounding indicator (extended case) around icon + label.
    val containerModifier = if (extendedIndicator) {
        outerModifier
            .clip(extendedShape)
            .background(backgroundColor)
            .padding(
                horizontal = 2.dp,
                vertical = if (labelledExtended) 5.dp else 2.dp,
            )
    } else {
        outerModifier
    }

    Box(modifier = modifier) {
        when (style) {
            YaruNavigationRailStyle.Compact -> Box(
                modifier = containerModifier,
                contentAlignment = Alignment.Center,
            ) {
                iconContent()
            }
            YaruNavigationRailStyle.Labelled -> Column(
                modifier = containerModifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                iconContent()
                Spacer(Modifier.height(5.dp))
                labelContent()
            }
            YaruNavigationRailStyle.LabelledExtended -> Row(
                modifier = containerModifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                iconContent()
                Spacer(Modifier.width(10.dp))
                Box(modifier = Modifier.weight(1f)) { labelContent() }
            }
        }
    }
}
