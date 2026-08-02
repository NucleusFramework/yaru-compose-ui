package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size as GeomSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight

/**
 * Yaru-flavored switch — Canvas-painted, foundation-only.
 *
 * Mirrors `_YaruSwitchPainter` from `yaru.dart/lib/src/widgets/yaru_switch.dart`.
 * Geometry constants (`_kSwitchSize = 48 × 26`, `_kSwitchThumbSizeFactor = 0.76`,
 * `_kSwitchActivableAreaPadding = 2 × 5`) are preserved 1-for-1 via [YaruConstants].
 */
@Composable
fun YaruSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedColor: Color? = null,
    thumbColor: Color? = null,
    onOffShapes: Boolean? = null,
    hasFocusBorder: Boolean? = null,
    interactionSource: MutableInteractionSource? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val themeData = LocalYaruTheme.current
    val interactive = enabled && onCheckedChange != null

    // Position animation — Curves.easeInQuad / easeOutQuad / 150 ms
    // (`_kTogglableAnimationDuration`) from yaru_togglable.dart.
    val target = if (checked) 1f else 0f
    val t by animateFloatAsState(
        targetValue = target,
        animationSpec = tween(
            durationMillis = 150,
            easing = if (checked) YaruEasing.EaseInQuad else YaruEasing.EaseOutQuad,
        ),
    )

    // Wrappers (SwitchButton, SwitchListTile) can drive the halo from the row
    // hover state by passing in their shared `MutableInteractionSource`.
    val ownInteractionSource = remember { MutableInteractionSource() }
    val effectiveInteractionSource = interactionSource ?: ownInteractionSource
    val hovered by effectiveInteractionSource.collectIsHoveredAsState()
    val pressed by effectiveInteractionSource.collectIsPressedAsState()
    val focused by rememberKeyboardFocusedState(effectiveInteractionSource)

    // Indicator (hover/focus halo) animation — Curves.fastOutSlowIn / 200 ms
    // (`_kIndicatorAnimationDuration`) from yaru_togglable.dart.
    val indicatorTarget = if (interactive && (hovered || focused)) 1f else 0f
    val indicatorT by animateFloatAsState(
        targetValue = indicatorTarget,
        animationSpec = tween(durationMillis = 200, easing = YaruEasing.FastOutSlowIn),
    )

    // Press squash animation — Curves.easeIn / easeOut / 100 ms
    // (`_kTogglableSizeAnimationDuration`) from yaru_togglable.dart.
    val pressTarget = if (interactive && pressed) 1f else 0f
    val pressT by animateFloatAsState(
        targetValue = pressTarget,
        animationSpec = tween(
            durationMillis = 100,
            easing = if (pressed) YaruEasing.EaseIn else YaruEasing.EaseOut,
        ),
    )

    val resolvedShowOnOffShapes = onOffShapes ?: themeData?.statusShapes ?: false
    val showFocusBorder = hasFocusBorder ?: (themeData?.focusBorders == true)

    val colors = remember(scheme, selectedColor, thumbColor, interactive) {
        SwitchColors.from(scheme, selectedColor, thumbColor, interactive)
    }

    val toggleModifier = if (onCheckedChange != null) {
        // Mirrors Dart `Switch.mouseCursor` default
        // (`WidgetStateMouseCursor.clickable` → `SystemMouseCursors.click`
        // when interactive, `basic` otherwise) — yaru_togglable.dart:253-256
        // and yaru_switch.dart:261-263.
        Modifier
            .let { if (interactive) it.pointerHoverIcon(PointerIcon.Hand) else it }
            .toggleable(
                value = checked,
                enabled = enabled,
                interactionSource = effectiveInteractionSource,
                indication = null,
                role = Role.Switch,
                onValueChange = { onCheckedChange(!checked) },
            )
    } else {
        Modifier
    }

    val core: @Composable () -> Unit = {
        // Dart wraps the entire `Padding + SizedBox` in
        // `FocusableActionDetector + GestureDetector` (yaru_togglable.dart
        // lines 246-266 + 330-340), so the tap/hover area is the OUTER
        // 52x36 (48x26 switch + 2 horizontal / 5 vertical padding), not the
        // inner 48x26. Apply the toggleable modifier on the outer Box.
        Box(
            modifier = Modifier
                .then(toggleModifier)
                .padding(SwitchActivableAreaPadding)
                .size(width = YaruConstants.SwitchWidth, height = YaruConstants.SwitchHeight),
        ) {
            Canvas(
                modifier = Modifier.size(
                    width = YaruConstants.SwitchWidth,
                    height = YaruConstants.SwitchHeight,
                ),
            ) {
                val canvasSize = GeomSize(size.width, size.height)
                // Guard against zero-sized canvases (e.g. parent imposes
                // `Constraints(0, 0)`): dividing by zero below would produce
                // NaN/Infinity scales and crash `scale(...)` / skia.
                if (canvasSize.width <= 0f || canvasSize.height <= 0f) return@Canvas
                // Defensive: clamp animation reads to [0, 1] before they feed
                // `scale()`, `Color.copy(alpha = ...)` and thumb-center math.
                // Tween endpoints are well-defined, but a misconfigured spec
                // (or NaN reaching us via a custom AnimationSpec) would
                // otherwise crash Skia / `Color.copy` (alpha must be in [0,1]).
                // NaN bypasses `coerceIn` (NaN comparisons all return false),
                // so reject non-finite values explicitly via `isFinite()`.
                val safeT = t.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f
                val safePressT = pressT.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f
                val safeIndicatorT =
                    indicatorT.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f
                // Active resize: shrink by `_kTogglableActiveResizeFactor = 2` px on press.
                val activeScaleX = 1f - (size.width - 2f) / size.width
                val activeScaleY = 1f - (size.height - 2f) / size.height
                val activeScale = maxOf(activeScaleX, activeScaleY)
                val scaleFactor = 1f - activeScale * safePressT
                scale(scale = scaleFactor) {
                    paintSwitch(
                        size = canvasSize,
                        t = safeT,
                        interactive = interactive,
                        focused = focused,
                        indicatorT = safeIndicatorT,
                        showOnOffShapes = resolvedShowOnOffShapes,
                        colors = colors,
                    )
                }
            }
        }
    }

    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier,
            focused = focused && interactive,
            borderPadding = YaruFocusBorderPadding.Zero,
        ) { core() }
    } else {
        Box(modifier = modifier) { core() }
    }
}

/** Activable padding ported from `_kSwitchActivableAreaPadding`. */
private val SwitchActivableAreaPadding = PaddingValues(horizontal = 2.dp, vertical = 5.dp)

/** Indicator radius ported from `_kIndicatorRadius = 20.0` in `yaru_togglable.dart`. */
private val IndicatorRadius = 20.dp

/**
 * Resolved color set for [YaruSwitch], mirroring the assignments performed in
 * `_YaruSwitchState.build` and `YaruTogglableState.fillPainterDefaults`.
 */
private data class SwitchColors(
    val uncheckedTrack: Color,
    val checkedTrack: Color,
    val uncheckedBorder: Color,
    val checkedBorder: Color,
    val uncheckedThumb: Color,
    val checkedThumb: Color,
    val uncheckedThumbBorder: Color,
    val checkedThumbBorder: Color,
    val uncheckedShape: Color,
    val checkedShape: Color,
    val disabledUncheckedTrack: Color,
    val disabledCheckedTrack: Color,
    val disabledUncheckedBorder: Color,
    val disabledCheckedBorder: Color,
    val disabledUncheckedThumb: Color,
    val disabledCheckedThumb: Color,
    val disabledUncheckedShape: Color,
    val disabledCheckedShape: Color,
    val hoverIndicator: Color,
    val focusIndicator: Color,
) {
    companion object {
        fun from(
            scheme: YaruColorScheme,
            selectedColor: Color?,
            thumbColor: Color?,
            interactive: Boolean,
        ): SwitchColors {
            // `yaru_switch.dart` line 174:
            //   `final defaultBorderColor = colorScheme.isHighContrast &&
            //    widget.interactive ? colorScheme.outlineVariant : Colors.transparent;`
            // Note the `&& widget.interactive` gate — disabled high-contrast
            // switches do NOT receive the outlineVariant border.
            val defaultBorder = if (scheme.isHighContrast && interactive) {
                scheme.outlineVariant
            } else {
                Color.Transparent
            }

            // Defensive: sanitise caller-supplied colors before they reach
            // drawRoundRect / drawCircle / drawRect or further `.copy(alpha = ...)`
            // operations — Color.Unspecified or non-finite channels would crash skia.
            val safeSelected = sanitiseColor(selectedColor ?: scheme.primary)
            val safeThumb = sanitiseColor(thumbColor ?: scheme.onPrimary)

            val uncheckedTrack = scheme.onSurface.copy(alpha = 0.25f)
            val uncheckedBorder = defaultBorder
            val uncheckedThumb = Color.White
            val checkedTrack = safeSelected
            val checkedBorder = defaultBorder
            val checkedThumb = safeThumb
            // In light themes, the thumb stroke matches the track border;
            // in dark themes, it matches the thumb fill.
            val uncheckedThumbBorder = if (scheme.isLight) uncheckedBorder else uncheckedThumb
            val checkedThumbBorder = if (scheme.isLight) checkedBorder else checkedThumb

            val checkedShape = checkedThumb
            val uncheckedShape = if (scheme.isLight) scheme.outlineVariant else uncheckedThumb

            // Disabled colors — `fillPainterDefaults` defines these.
            val disabledUncheckedTrack = scheme.onSurface.copy(alpha = 0.1f)
            val disabledUncheckedBorder = defaultBorder
            val disabledUncheckedThumb = scheme.onSurface.copy(alpha = 0.4f)
            val disabledCheckedTrack = scheme.onSurface.copy(alpha = 0.2f)
            val disabledCheckedBorder = defaultBorder
            val disabledCheckedThumb = disabledUncheckedThumb
            val disabledCheckedShape = disabledCheckedThumb
            val disabledUncheckedShape = if (scheme.isLight) {
                scheme.outlineVariant.copy(alpha = 0.4f)
            } else {
                disabledUncheckedThumb
            }

            val hoverIndicator = scheme.onSurface.copy(alpha = 0.05f)
            val focusIndicator = scheme.onSurface.copy(alpha = 0.1f)

            return SwitchColors(
                uncheckedTrack = uncheckedTrack,
                checkedTrack = checkedTrack,
                uncheckedBorder = uncheckedBorder,
                checkedBorder = checkedBorder,
                uncheckedThumb = uncheckedThumb,
                checkedThumb = checkedThumb,
                uncheckedThumbBorder = uncheckedThumbBorder,
                checkedThumbBorder = checkedThumbBorder,
                uncheckedShape = uncheckedShape,
                checkedShape = checkedShape,
                disabledUncheckedTrack = disabledUncheckedTrack,
                disabledCheckedTrack = disabledCheckedTrack,
                disabledUncheckedBorder = disabledUncheckedBorder,
                disabledCheckedBorder = disabledCheckedBorder,
                disabledUncheckedThumb = disabledUncheckedThumb,
                disabledCheckedThumb = disabledCheckedThumb,
                disabledUncheckedShape = disabledUncheckedShape,
                disabledCheckedShape = disabledCheckedShape,
                hoverIndicator = hoverIndicator,
                focusIndicator = focusIndicator,
            )
        }
    }
}

private fun DrawScope.paintSwitch(
    size: GeomSize,
    t: Float,
    interactive: Boolean,
    focused: Boolean,
    indicatorT: Float,
    showOnOffShapes: Boolean,
    colors: SwitchColors,
) {
    drawTrack(size, t, interactive, colors)
    drawThumb(size, t, interactive, focused, indicatorT, colors)
    if (showOnOffShapes) {
        drawOnOffShapes(size, t, interactive, colors)
    }
}

private fun DrawScope.drawTrack(
    size: GeomSize,
    t: Float,
    interactive: Boolean,
    colors: SwitchColors,
) {
    val cornerRadius = size.height
    val trackColor = if (interactive) {
        lerp(colors.uncheckedTrack, colors.checkedTrack, t)
    } else {
        lerp(colors.disabledUncheckedTrack, colors.disabledCheckedTrack, t)
    }
    drawRoundRect(
        color = trackColor,
        topLeft = Offset(0f, 0f),
        size = size,
        cornerRadius = CornerRadius(cornerRadius, cornerRadius),
    )

    // Track outline — `Rect.fromLTWH(0.5, 0.5, w - 1, h - 1)` with 1 px stroke.
    val borderColor = if (interactive) {
        lerp(colors.uncheckedBorder, colors.checkedBorder, t)
    } else {
        lerp(colors.disabledUncheckedBorder, colors.disabledCheckedBorder, t)
    }
    if (borderColor.alpha != 0f) {
        // Defensive: convert the 1 / 0.5 logical-pixel constants through `toPx()` — DrawScope works in physical px, so raw `1f` would render as half-thickness on a 2x screen.
        val onePx = 1.dp.toPx()
        val halfPx = 0.5.dp.toPx()
        // Defensive: clamp non-negative in case the canvas is squeezed below 1px.
        val outlineW = (size.width - onePx).coerceAtLeast(0f)
        val outlineH = (size.height - onePx).coerceAtLeast(0f)
        drawRoundRect(
            color = borderColor,
            topLeft = Offset(halfPx, halfPx),
            size = GeomSize(outlineW, outlineH),
            cornerRadius = CornerRadius(cornerRadius, cornerRadius),
            style = Stroke(width = onePx),
        )
    }
}

private fun DrawScope.drawThumb(
    size: GeomSize,
    t: Float,
    interactive: Boolean,
    focused: Boolean,
    indicatorT: Float,
    colors: SwitchColors,
) {
    val margin = (size.height - size.height * YaruConstants.SwitchThumbSizeFactor) / 2f
    // Defensive: clamp inner dimensions non-negative in case the canvas is
    // squeezed below the margin — keeps `radius`, `startX`, `endX` finite and
    // avoids reversed thumb travel (`endX < startX`) when `innerW < 2 * radius`.
    val innerW = (size.width - margin * 2f).coerceAtLeast(0f)
    val innerH = (size.height - margin * 2f).coerceAtLeast(0f)
    val radius = innerH / 2f
    val startX = radius + margin
    val endX = (innerW + margin - radius).coerceAtLeast(startX)
    // Defensive: DrawScope does not auto-mirror x for RTL — flip the thumb travel so the unchecked thumb sits at the visual start (right edge) under Arabic/Hebrew, matching the Dart `Switch`.
    val isRtl = layoutDirection == LayoutDirection.Rtl
    val effectiveT = if (isRtl) 1f - t else t
    val centerX = startX + (endX - startX) * effectiveT
    val centerY = radius + margin
    val center = Offset(centerX, centerY)

    // Hover / focus indicator — drawn under the thumb so it visually wraps it.
    if (interactive && indicatorT > 0f) {
        val indicatorBase = if (focused) colors.focusIndicator else colors.hoverIndicator
        val indicatorRadiusPx: Float = IndicatorRadius.toPx()
        drawCircle(
            color = indicatorBase.copy(alpha = indicatorBase.alpha * indicatorT),
            radius = indicatorRadiusPx,
            center = center,
        )
    }

    val thumbFill = if (interactive) {
        lerp(colors.uncheckedThumb, colors.checkedThumb, t)
    } else {
        lerp(colors.disabledUncheckedThumb, colors.disabledCheckedThumb, t)
    }
    // `radius = innerH / 2f`; `innerH` is already coerceAtLeast(0f) above, so
    // `radius` is non-negative by construction.
    drawCircle(color = thumbFill, radius = radius, center = center)

    // Thumb stroke — `radius - 0.5`, 1 px hairline. Disabled = transparent.
    if (interactive) {
        val thumbStroke = lerp(colors.uncheckedThumbBorder, colors.checkedThumb, t)
        if (thumbStroke.alpha != 0f) {
            // Defensive: 1 / 0.5 are logical-pixel constants from Dart — convert via `toPx()` so the hairline keeps its intended thickness on >1.0x screens.
            val onePx = 1.dp.toPx()
            val halfPx = 0.5.dp.toPx()
            drawCircle(
                color = thumbStroke,
                radius = (radius - halfPx).coerceAtLeast(0f),
                center = center,
                style = Stroke(width = onePx),
            )
        }
    }
}

private fun DrawScope.drawOnOffShapes(
    size: GeomSize,
    t: Float,
    interactive: Boolean,
    colors: SwitchColors,
) {
    val margin = (size.height - size.height * YaruConstants.SwitchThumbSizeFactor) / 2f
    val innerH = size.height - margin * 2f
    val shapeColor = if (interactive) {
        lerp(colors.uncheckedShape, colors.checkedShape, t)
    } else {
        lerp(colors.disabledUncheckedShape, colors.disabledCheckedShape, t)
    }
    // Defensive: DrawScope does not auto-mirror x for RTL — swap the on/off shape positions so the on-bar sits opposite the (also-mirrored) thumb under Arabic/Hebrew.
    val isRtl = layoutDirection == LayoutDirection.Rtl

    // Defensive: `2` is a logical-pixel constant from Dart — convert via `toPx()` so the on-bar width and off-ring stroke keep their intended thickness on >1.0x screens.
    val twoPx = 2.dp.toPx()
    // Defensive: animated `t` may settle slightly under 1f due to easing/interpolation drift; treat the upper bound as inclusive so the "on" bar is shown at the end of the animation instead of falling back to the "off" ring.
    if (t >= 1f) {
        // "on" tally bar — 2 px wide, height = size.height / 2.5.
        val barWidth = twoPx
        val barHeight = size.height / 2.5f
        val barCenterX = if (isRtl) {
            innerH + (size.width - innerH) / 2f
        } else {
            (size.width - innerH) / 2f
        }
        val barCenterY = size.height / 2f
        drawRect(
            color = shapeColor,
            topLeft = Offset(barCenterX - barWidth / 2f, barCenterY - barHeight / 2f),
            size = GeomSize(barWidth, barHeight),
        )
    } else {
        // "off" ring — radius = size.height / 7, 2 px stroke (Dart line 440-450).
        val ringRadius = size.height / 7f
        val ringCenterX = if (isRtl) {
            (size.width - innerH) / 2f
        } else {
            innerH + (size.width - innerH) / 2f
        }
        val ringCenterY = size.height / 2f
        drawCircle(
            color = shapeColor,
            radius = ringRadius,
            center = Offset(ringCenterX, ringCenterY),
            style = Stroke(width = twoPx),
        )
    }
}
