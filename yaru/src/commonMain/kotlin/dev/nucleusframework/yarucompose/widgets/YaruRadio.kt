package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size as GeomSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast

/**
 * Yaru-flavored radio button — Canvas-painted, foundation-only.
 *
 * Mirrors `_YaruRadioPainter` from `yaru.dart/lib/src/widgets/yaru_radio.dart`,
 * including the `_kDotSizeFactor = 0.4` and `_kUncheckedBorderWidth = 2`
 * geometry constants, the active-press scale, and the hover / focus halo.
 */
@Composable
fun <T> YaruRadio(
    value: T,
    groupValue: T?,
    onChanged: ((T?) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    toggleable: Boolean = false,
    selectedColor: Color? = null,
    checkmarkColor: Color? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_radio.dart:262. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
    interactionSource: MutableInteractionSource? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val selected = value == groupValue
    val interactive = enabled && onChanged != null
    // Wrappers (RadioButton, RadioListTile) can drive the halo from the row
    // hover state by passing in their shared `MutableInteractionSource`.
    val ownInteractionSource = remember { MutableInteractionSource() }
    val effectiveInteractionSource = interactionSource ?: ownInteractionSource
    val hovered by effectiveInteractionSource.collectIsHoveredAsState()
    val focused by rememberKeyboardFocusedState(effectiveInteractionSource)
    val pressed by effectiveInteractionSource.collectIsPressedAsState()

    // Position animation — Curves.easeInQuad / easeOutQuad / Durations 150 ms
    // (`_kTogglableAnimationDuration`) from yaru_togglable.dart.
    val position = remember { Animatable(if (selected) 1f else 0f) }
    LaunchedEffect(selected) {
        position.animateTo(
            targetValue = if (selected) 1f else 0f,
            animationSpec = tween(
                durationMillis = 150,
                easing = if (selected) YaruEasing.EaseInQuad else YaruEasing.EaseOutQuad,
            ),
        )
    }

    // Indicator (hover/focus halo) — Curves.fastOutSlowIn / 200 ms
    // (`_kIndicatorAnimationDuration`) from yaru_togglable.dart.
    val indicator = remember { Animatable(0f) }
    val indicatorActive = interactive && (hovered || focused)
    LaunchedEffect(indicatorActive) {
        indicator.animateTo(
            targetValue = if (indicatorActive) 1f else 0f,
            animationSpec = tween(durationMillis = 200, easing = YaruEasing.FastOutSlowIn),
        )
    }

    // Active (pressed) size animation — Curves.easeIn / easeOut / 100 ms
    // (`_kTogglableSizeAnimationDuration`) from yaru_togglable.dart.
    val sizePosition = remember { Animatable(0f) }
    val activePressed = interactive && pressed
    LaunchedEffect(activePressed) {
        sizePosition.animateTo(
            targetValue = if (activePressed) 1f else 0f,
            animationSpec = tween(
                durationMillis = 100,
                easing = if (activePressed) YaruEasing.EaseIn else YaruEasing.EaseOut,
            ),
        )
    }

    // Defensive: sanitise caller-supplied colors before they reach drawOval/lerp —
    // Color.Unspecified or non-finite channels would crash skia.
    val checkedColor = sanitiseColor(selectedColor ?: scheme.primary)
    val resolvedCheckmark = sanitiseColor(checkmarkColor ?: scheme.onPrimary)

    // Mirrors `fillPainterDefaults` from `yaru_togglable.dart`.
    val isHighContrast = scheme.isHighContrast
    val uncheckedBorderColor = when {
        isHighContrast -> scheme.outlineVariant
        scheme.isDark -> Color(0xFF757575)
        else -> Color(0xFF909090)
    }
    val uncheckedColor = scheme.surface
    // `fillPainterDefaults` in `yaru_togglable.dart` line 281 sets
    // `checkedBorderColor = Colors.transparent` unconditionally — not
    // high-contrast aware. Match Dart parity.
    val checkedBorderColor = Color.Transparent
    val disabledUncheckedColor = scheme.onSurface.copy(alpha = 0.1f)
    val disabledUncheckedBorderColor =
        if (isHighContrast) scheme.outlineVariant else disabledUncheckedColor
    val disabledCheckedColor = scheme.onSurface.copy(alpha = 0.2f)
    val disabledCheckedBorderColor =
        if (isHighContrast) scheme.outlineVariant else Color.Transparent
    val disabledCheckmarkColor = scheme.onSurface.copy(alpha = 0.5f)
    val hoverIndicatorColor = scheme.onSurface.copy(alpha = 0.05f)
    val focusIndicatorColor = scheme.onSurface.copy(alpha = 0.1f)

    val onClick: (() -> Unit)? = if (onChanged == null) null else {
        {
            // Defensive: mirror Dart `handleTap` (yaru_radio.dart:187-191) — fire onChanged only when groupValue != value, or with null when toggleable & already selected; non-toggleable already-selected taps are idempotent.
            when {
                toggleable && selected -> onChanged(null)
                !selected -> onChanged(value)
            }
        }
    }

    val radio: @Composable (Modifier) -> Unit = { outerModifier ->
        // Dart wraps the entire `Padding + SizedBox` in
        // `FocusableActionDetector + GestureDetector` (yaru_togglable.dart
        // lines 246-266 + 330-340), so the tap/hover area is the OUTER
        // 32x32 (20 togglable + 6 padding on each side), not the inner 20x20.
        // Apply the selectable modifier on the outer Box accordingly.
        Box(
            modifier = outerModifier
                .let {
                    if (onClick != null) {
                        it
                            // Mirrors Dart `Radio.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click` when interactive,
                            // `basic` otherwise) — yaru_togglable.dart:253-256
                            // and yaru_radio.dart:254-258.
                            .let { m -> if (interactive) m.pointerHoverIcon(PointerIcon.Hand) else m }
                            .selectable(
                                selected = selected,
                                enabled = enabled,
                                interactionSource = effectiveInteractionSource,
                                indication = null,
                                role = Role.RadioButton,
                                onClick = onClick,
                            )
                    } else {
                        it
                    }
                }
                .padding(YaruConstants.RadioActivableAreaPadding)
                .size(YaruConstants.RadioTogglableSize),
        ) {
            Canvas(modifier = Modifier.size(YaruConstants.RadioTogglableSize)) {
                val canvasSize = GeomSize(size.width, size.height)
                // Guard against zero-sized canvases (e.g. parent imposes
                // `Constraints(0, 0)`): dividing by zero below would produce
                // NaN/Infinity scales and crash `withTransform` / skia.
                if (canvasSize.width <= 0f || canvasSize.height <= 0f) return@Canvas

                // Active-press scale — `_kTogglableActiveResizeFactor = 2`,
                // applied around the canvas centre. Mirrors
                // `YaruTogglablePainter.paint`. The Dart implementation wraps
                // the entire `paintTogglable` body (which calls
                // `drawStateIndicator` first) inside the scale, so the halo
                // also shrinks during press — keep that parity here.
                val activeScaleX = 1f - (canvasSize.width - ActiveResizeFactor) / canvasSize.width
                val activeScaleY = 1f - (canvasSize.height - ActiveResizeFactor) / canvasSize.height
                val activeScale = if (activeScaleX > activeScaleY) activeScaleX else activeScaleY
                // Defensive: clamp Animatable reads to [0, 1] before downstream
                // path / dot math — keeps a misconfigured spec from producing
                // negative sizes or NaN scales. NaN bypasses `coerceIn` (NaN
                // comparisons all return false), so reject non-finite values
                // explicitly via `isFinite()`.
                val safeSizePos =
                    sizePosition.value.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f
                val safeIndicator =
                    indicator.value.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f
                val safePosition =
                    position.value.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f
                val scale = 1f - activeScale * safeSizePos

                val cx = canvasSize.width / 2f
                val cy = canvasSize.height / 2f
                withTransform(scale, cx, cy) {
                    // Hover / focus halo — drawn behind the radio at 20dp.
                    if (interactive && safeIndicator > 0f) {
                        val color = if (focused) focusIndicatorColor else hoverIndicatorColor
                        drawCircle(
                            color = lerp(Color.Transparent, color, safeIndicator),
                            radius = IndicatorRadius.toPx(),
                            center = Offset(cx, cy),
                        )
                    }

                    paintRadio(
                        size = canvasSize,
                        t = safePosition,
                        interactive = interactive,
                        uncheckedColor = uncheckedColor,
                        uncheckedBorderColor = uncheckedBorderColor,
                        checkedColor = checkedColor,
                        checkedBorderColor = checkedBorderColor,
                        checkmarkColor = resolvedCheckmark,
                        disabledUncheckedColor = disabledUncheckedColor,
                        disabledUncheckedBorderColor = disabledUncheckedBorderColor,
                        disabledCheckedColor = disabledCheckedColor,
                        disabledCheckedBorderColor = disabledCheckedBorderColor,
                        disabledCheckmarkColor = disabledCheckmarkColor,
                    )
                }
            }
        }
    }

    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier,
            variant = YaruFocusBorderVariant.Primary,
            borderShape = CircleShape,
            // Defensive: gate the focus halo on `interactive` so a non-interactive radio sharing an interactionSource with a focused wrapper (RadioListTile, custom row) does not paint a stray focus ring around itself.
            focused = focused && interactive,
        ) { radio(Modifier) }
    } else {
        radio(modifier)
    }
}

private inline fun androidx.compose.ui.graphics.drawscope.DrawScope.withTransform(
    scale: Float,
    pivotX: Float,
    pivotY: Float,
    block: androidx.compose.ui.graphics.drawscope.DrawScope.() -> Unit,
) {
    if (scale == 1f) {
        block()
        return
    }
    drawContext.canvas.save()
    try {
        drawContext.canvas.translate(pivotX, pivotY)
        drawContext.canvas.scale(scale, scale)
        drawContext.canvas.translate(-pivotX, -pivotY)
        block()
    } finally {
        // Restore even if `block` throws — leaving an unbalanced `save` would
        // corrupt the parent draw scope's canvas state for subsequent frames.
        drawContext.canvas.restore()
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.paintRadio(
    size: GeomSize,
    t: Float,
    interactive: Boolean,
    uncheckedColor: Color,
    uncheckedBorderColor: Color,
    checkedColor: Color,
    checkedBorderColor: Color,
    checkmarkColor: Color,
    disabledUncheckedColor: Color,
    disabledUncheckedBorderColor: Color,
    disabledCheckedColor: Color,
    disabledCheckedBorderColor: Color,
    disabledCheckmarkColor: Color,
) {
    val border = UncheckedBorderWidth.toPx()
    val fill = if (interactive) {
        lerp(uncheckedColor, checkedColor, t)
    } else {
        lerp(disabledUncheckedColor, disabledCheckedColor, t)
    }
    drawOval(color = fill, topLeft = Offset(0f, 0f), size = size)

    val stroke = if (interactive) {
        lerp(uncheckedBorderColor, checkedBorderColor, t)
    } else {
        lerp(disabledUncheckedBorderColor, disabledCheckedBorderColor, t)
    }
    // Defensive: clamp inner stroke rect non-negative if the canvas is below
    // the border thickness.
    val strokeW = (size.width - border).coerceAtLeast(0f)
    val strokeH = (size.height - border).coerceAtLeast(0f)
    drawOval(
        color = stroke,
        topLeft = Offset(border / 2f, border / 2f),
        size = GeomSize(strokeW, strokeH),
        style = Stroke(width = border),
    )

    // Defensive: clamp dot size non-negative — `t` is upstream-clamped but the
    // canvas may be zero-sized in pathological constraints.
    val dotW = (size.width * DotSizeFactor * t).coerceAtLeast(0f)
    val dotH = (size.height * DotSizeFactor * t).coerceAtLeast(0f)
    drawOval(
        color = if (interactive) checkmarkColor else disabledCheckmarkColor,
        topLeft = Offset((size.width - dotW) / 2f, (size.height - dotH) / 2f),
        size = GeomSize(dotW, dotH),
    )
}

private val UncheckedBorderWidth = 2.dp
private val IndicatorRadius = 20.dp
private const val DotSizeFactor = 0.4f
private const val ActiveResizeFactor = 2f
