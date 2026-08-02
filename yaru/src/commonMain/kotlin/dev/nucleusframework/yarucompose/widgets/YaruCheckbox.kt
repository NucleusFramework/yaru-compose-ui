package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size as GeomSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight

/**
 * Yaru-flavored checkbox, painted on a [Canvas] — foundation-only.
 *
 * Mirrors `_YaruCheckboxPainter.paintTogglable` and the animation machinery of
 * `YaruTogglableState` from `yaru.dart/lib/src/widgets/yaru_checkbox.dart` and
 * `yaru_togglable.dart`. Geometry constants (`_kCheckboxTogglableSize`,
 * `_kCheckboxBorderRadius`, `_kCheckboxDashStroke`, `_kDashSizeFactor`,
 * `_kUncheckedBorderWidth`, `_kCheckboxActivableAreaPadding`) and stroke
 * positions (0.1818 / 0.4545 / 0.4091 / 0.6818 / 0.8128 / 0.2781) are
 * preserved 1-to-1.
 */
@Composable
fun YaruCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedColor: Color? = null,
    checkmarkColor: Color? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_checkbox.dart:269. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
    interactionSource: MutableInteractionSource? = null,
) {
    YaruCheckbox(
        value = checked,
        onChanged = if (onCheckedChange == null) null else { v -> onCheckedChange(v ?: false) },
        modifier = modifier,
        enabled = enabled,
        tristate = false,
        selectedColor = selectedColor,
        checkmarkColor = checkmarkColor,
        hasFocusBorder = hasFocusBorder,
        interactionSource = interactionSource,
    )
}

/** Tristate variant — accepts a nullable [value] (`null` ⇒ indeterminate). */
@Composable
fun YaruCheckbox(
    value: Boolean?,
    onChanged: ((Boolean?) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tristate: Boolean = true,
    selectedColor: Color? = null,
    checkmarkColor: Color? = null,
    hasFocusBorder: Boolean? = null,
    interactionSource: MutableInteractionSource? = null,
) {
    require(tristate || value != null) {
        "value must be non-null when tristate is false"
    }
    val scheme = LocalYaruColorScheme.current
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    // Defensive: when a wrapper (YaruCheckButton / YaruCheckboxListTile) passes its own `interactionSource` it strips `onChanged` to dedupe taps but still wants the painter in the interactive (primary-colored) state — derive `interactive` from `enabled` alone in that case so the inner checkbox does not render as disabled gray.
    val interactive = enabled && (onChanged != null || interactionSource != null)

    val state = when (value) {
        true -> ToggleableState.On
        false -> ToggleableState.Off
        null -> ToggleableState.Indeterminate
    }

    // Track `oldChecked` so we can drive the bidirectional null↔true crossfade,
    // matching `_YaruCheckboxPainter.paintTogglable`.
    var oldChecked by remember { mutableStateOf<Boolean?>(value) }

    // `position` ∈ [0, 1] — 0 unchecked, 1 checked / indeterminate.
    // Curves.easeInQuad / easeOutQuad / 150 ms (`_kTogglableAnimationDuration`)
    // from yaru_togglable.dart.
    val initialPosition = if (state == ToggleableState.Off) 0f else 1f
    val positionAnim = remember { Animatable(initialPosition) }

    LaunchedEffect(value) {
        val previous = oldChecked
        if (previous == value) return@LaunchedEffect
        // Match the Dart logic in `didUpdateWidget` of `YaruTogglableState`.
        // `oldChecked` is held at the previous value for the duration of the
        // tween (the `oldChecked = value` assignment happens after `animateTo`
        // returns), so the painter can read the correct previous state for
        // the null↔true crossfade.
        if (tristate) {
            if (value == null || value == true) {
                positionAnim.snapTo(0f)
                positionAnim.animateTo(
                    1f,
                    animationSpec = tween(durationMillis = 150, easing = YaruEasing.EaseInQuad),
                )
            } else {
                positionAnim.animateTo(
                    0f,
                    animationSpec = tween(durationMillis = 150, easing = YaruEasing.EaseOutQuad),
                )
            }
        } else {
            if (value == true) {
                positionAnim.animateTo(
                    1f,
                    animationSpec = tween(durationMillis = 150, easing = YaruEasing.EaseInQuad),
                )
            } else {
                positionAnim.animateTo(
                    0f,
                    animationSpec = tween(durationMillis = 150, easing = YaruEasing.EaseOutQuad),
                )
            }
        }
        oldChecked = value
    }

    // Hover / focus / press interaction tracking — mirrors the
    // `WidgetStatesController` listeners in `YaruTogglableState`.
    // Accepts an external interactionSource so wrappers (CheckButton,
    // CheckListTile, etc.) can drive the halo from the row hover state —
    // exactly like Dart shares a single `WidgetStatesController` across the
    // toggle button row and the inner checkbox.
    val ownInteractionSource = remember { MutableInteractionSource() }
    val effectiveInteractionSource = interactionSource ?: ownInteractionSource
    val hovered by effectiveInteractionSource.collectIsHoveredAsState()
    val focused by rememberKeyboardFocusedState(effectiveInteractionSource)
    val pressed by effectiveInteractionSource.collectIsPressedAsState()

    // Indicator halo — Curves.fastOutSlowIn / 200 ms
    // (`_kIndicatorAnimationDuration`) from yaru_togglable.dart.
    val indicatorTarget = if (interactive && (hovered || focused)) 1f else 0f
    val indicatorPosition by animateFloatAsState(
        targetValue = indicatorTarget,
        animationSpec = tween(durationMillis = 200, easing = YaruEasing.FastOutSlowIn),
    )

    // Press squash — Curves.easeIn / easeOut / 100 ms
    // (`_kTogglableSizeAnimationDuration`) from yaru_togglable.dart.
    val sizeTarget = if (interactive && pressed) 1f else 0f
    val sizePosition by animateFloatAsState(
        targetValue = sizeTarget,
        animationSpec = tween(
            durationMillis = 100,
            easing = if (sizeTarget == 1f) YaruEasing.EaseIn else YaruEasing.EaseOut,
        ),
    )

    // Default colors — mirror `fillPainterDefaults` in `yaru_togglable.dart`.
    val uncheckedColor = scheme.surface
    val uncheckedBorderColor = if (scheme.isHighContrast) {
        scheme.outlineVariant
    } else if (scheme.isLight) {
        Color(0xFF909090)
    } else {
        Color(0xFF757575)
    }
    // Defensive: sanitise caller-supplied colors before they reach drawRoundRect /
    // drawPath / drawLine — Color.Unspecified or non-finite channels would crash skia.
    val resolvedCheckedColor = sanitiseColor(selectedColor ?: scheme.primary)
    val resolvedCheckedBorderColor = Color.Transparent
    val resolvedCheckmarkColor = sanitiseColor(checkmarkColor ?: scheme.onPrimary)

    val disabledUncheckedColor = scheme.onSurface.copy(alpha = 0.1f)
    val disabledUncheckedBorderColor = if (scheme.isHighContrast) {
        scheme.outlineVariant
    } else {
        disabledUncheckedColor
    }
    val disabledCheckedColor = scheme.onSurface.copy(alpha = 0.2f)
    val disabledCheckedBorderColor = if (scheme.isHighContrast) {
        scheme.outlineVariant
    } else {
        Color.Transparent
    }
    val disabledCheckmarkColor = scheme.onSurface.copy(alpha = 0.5f)

    val hoverIndicatorColor = scheme.onSurface.copy(alpha = 0.05f)
    val focusIndicatorColor = scheme.onSurface.copy(alpha = 0.1f)

    val toggle: (() -> Unit)? = if (onChanged == null) null else {
        {
            // Match `handleTap` in `_YaruCheckboxState`.
            onChanged(
                when (value) {
                    false -> true
                    true -> if (tristate) null else false
                    null -> false
                },
            )
        }
    }

    val checkboxNode: @Composable () -> Unit = {
        // Dart wraps the entire `Padding + SizedBox` in
        // `FocusableActionDetector + GestureDetector` (yaru_togglable.dart
        // lines 246-266 + 330-340), so the tap/hover area is the OUTER
        // 32x32 (20 togglable + 6 padding on each side), not the inner 20x20.
        // Apply the toggleable modifier on the outer Box accordingly.
        Box(
            modifier = Modifier
                .let {
                    if (toggle != null) {
                        it
                            // Mirrors Dart `Checkbox.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click` when interactive,
                            // `basic` otherwise) — see yaru_togglable.dart:253-256
                            // and yaru_checkbox.dart:261-263.
                            .let { m -> if (interactive) m.pointerHoverIcon(PointerIcon.Hand) else m }
                            .triStateToggleable(
                                state = state,
                                enabled = interactive,
                                interactionSource = effectiveInteractionSource,
                                indication = null,
                                // Defensive: foundation `triStateToggleable` does NOT auto-attach `Role.Checkbox` (higher-level checkbox widgets do); without this screen readers announce a generic clickable region instead of "checkbox, checked/unchecked/indeterminate".
                                role = Role.Checkbox,
                                onClick = toggle,
                            )
                    } else {
                        it
                    }
                }
                .padding(YaruConstants.CheckboxActivableAreaPadding)
                .size(YaruConstants.CheckboxTogglableSize),
        ) {
            Canvas(modifier = Modifier.size(YaruConstants.CheckboxTogglableSize)) {
                val size = GeomSize(this.size.width, this.size.height)
                // Defensive: animation values are tween-driven and should remain
                // in [0, 1], but clamp before use so any spec change can never
                // produce negative path math or NaN downstream. NaN bypasses
                // `coerceIn` (NaN comparisons all return false), so reject
                // non-finite values explicitly via `isFinite()`.
                paintCheckbox(
                    size = size,
                    checked = value,
                    oldChecked = oldChecked,
                    position = positionAnim.value.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f,
                    sizePosition = sizePosition.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f,
                    indicatorPosition = indicatorPosition.takeIf { it.isFinite() }?.coerceIn(0f, 1f) ?: 0f,
                    interactive = interactive,
                    focused = focused,
                    uncheckedColor = uncheckedColor,
                    uncheckedBorderColor = uncheckedBorderColor,
                    checkedColor = resolvedCheckedColor,
                    checkedBorderColor = resolvedCheckedBorderColor,
                    checkmarkColor = resolvedCheckmarkColor,
                    disabledUncheckedColor = disabledUncheckedColor,
                    disabledUncheckedBorderColor = disabledUncheckedBorderColor,
                    disabledCheckedColor = disabledCheckedColor,
                    disabledCheckedBorderColor = disabledCheckedBorderColor,
                    disabledCheckmarkColor = disabledCheckmarkColor,
                    hoverIndicatorColor = hoverIndicatorColor,
                    focusIndicatorColor = focusIndicatorColor,
                )
            }
        }
    }

    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier,
            focused = focused && interactive,
            content = checkboxNode,
        )
    } else {
        Box(modifier = modifier) { checkboxNode() }
    }
}

// ---------------------------------------------------------------------------
// Painter — pure functions, no class state. Mirrors `_YaruCheckboxPainter`.
// ---------------------------------------------------------------------------

private fun DrawScope.paintCheckbox(
    size: GeomSize,
    checked: Boolean?,
    oldChecked: Boolean?,
    position: Float,
    sizePosition: Float,
    indicatorPosition: Float,
    interactive: Boolean,
    focused: Boolean,
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
    hoverIndicatorColor: Color,
    focusIndicatorColor: Color,
) {
    // Press-shrink: scale around the centre. Matches `_TogglablePainter.paint`.
    // Guard against zero-sized canvases (e.g. parent imposes `Constraints(0, 0)`):
    // dividing by `size.width`/`size.height == 0` would yield NaN/Infinity, which
    // would then crash `scale(...)` and skia path validation.
    if (size.width <= 0f || size.height <= 0f) return
    val activeScaleX = 1f - (size.width - TogglableActiveResizeFactor) / size.width
    val activeScaleY = 1f - (size.height - TogglableActiveResizeFactor) / size.height
    val activeScale = if (activeScaleX > activeScaleY) activeScaleX else activeScaleY
    val scale = 1f - activeScale * sizePosition
    val centerX = size.width / 2f
    val centerY = size.height / 2f

    scale(scaleX = scale, scaleY = scale, pivot = Offset(centerX, centerY)) {
        // 1) Hover/focus halo behind the box.
        drawStateIndicator(
            size = size,
            interactive = interactive,
            focused = focused,
            indicatorPosition = indicatorPosition,
            hoverIndicatorColor = hoverIndicatorColor,
            focusIndicatorColor = focusIndicatorColor,
        )

        // 2) Box fill + border. The "false ⇄ X" transitions animate t in [0,1];
        //    the "null ⇄ true" transitions keep the box fully checked (t = 1).
        val tBox = if (oldChecked == false || checked == false) position else 1f
        drawCheckboxBox(
            size = size,
            t = tBox,
            interactive = interactive,
            uncheckedColor = uncheckedColor,
            uncheckedBorderColor = uncheckedBorderColor,
            checkedColor = checkedColor,
            checkedBorderColor = checkedBorderColor,
            disabledUncheckedColor = disabledUncheckedColor,
            disabledUncheckedBorderColor = disabledUncheckedBorderColor,
            disabledCheckedColor = disabledCheckedColor,
            disabledCheckedBorderColor = disabledCheckedBorderColor,
        )

        // 3) Glyph (check or dash) with the exact two-phase logic of
        //    `_YaruCheckboxPainter.paintTogglable`:
        //    - false→X / X→false: draw the destination glyph at progress t.
        //    - null↔true: shrink old at t≤0.5, expand new at t>0.5.
        val checkmark = if (interactive) checkmarkColor else disabledCheckmarkColor
        if (oldChecked == false || checked == false) {
            if (oldChecked == true || checked == true) {
                drawCheckMark(size, position, checkmark)
            } else if (oldChecked == null || checked == null) {
                drawDash(size, position, checkmark)
            }
        } else {
            if (position <= 0.5f) {
                val tShrink = 1f - position * 2f
                if (oldChecked == true) {
                    drawCheckMark(size, tShrink, checkmark)
                } else {
                    drawDash(size, tShrink, checkmark)
                }
            } else {
                val tExpand = (position - 0.5f) * 2f
                if (checked == true) {
                    drawCheckMark(size, tExpand, checkmark)
                } else {
                    drawDash(size, tExpand, checkmark)
                }
            }
        }
    }
}

private fun DrawScope.drawStateIndicator(
    size: GeomSize,
    interactive: Boolean,
    focused: Boolean,
    indicatorPosition: Float,
    hoverIndicatorColor: Color,
    focusIndicatorColor: Color,
) {
    if (!interactive || indicatorPosition <= 0f) return
    val indicatorColor = if (focused) focusIndicatorColor else hoverIndicatorColor
    drawCircle(
        color = lerp(Color.Transparent, indicatorColor, indicatorPosition),
        radius = IndicatorRadius.toPx(),
        center = Offset(size.width / 2f, size.height / 2f),
    )
}

private fun DrawScope.drawCheckboxBox(
    size: GeomSize,
    t: Float,
    interactive: Boolean,
    uncheckedColor: Color,
    uncheckedBorderColor: Color,
    checkedColor: Color,
    checkedBorderColor: Color,
    disabledUncheckedColor: Color,
    disabledUncheckedBorderColor: Color,
    disabledCheckedColor: Color,
    disabledCheckedBorderColor: Color,
) {
    val radius = YaruConstants.CheckRadius.toPx()
    val border = UncheckedBorderWidth.toPx()
    val fillColor = if (interactive) {
        lerp(uncheckedColor, checkedColor, t)
    } else {
        lerp(disabledUncheckedColor, disabledCheckedColor, t)
    }
    val strokeColor = if (interactive) {
        lerp(uncheckedBorderColor, checkedBorderColor, t)
    } else {
        lerp(disabledUncheckedBorderColor, disabledCheckedBorderColor, t)
    }
    drawRoundRect(
        color = fillColor,
        topLeft = Offset(0f, 0f),
        size = size,
        cornerRadius = CornerRadius(radius, radius),
    )
    // Defensive: clamp inner stroke rect non-negative in case the canvas is
    // squeezed below the border thickness.
    val innerW = (size.width - border).coerceAtLeast(0f)
    val innerH = (size.height - border).coerceAtLeast(0f)
    drawRoundRect(
        color = strokeColor,
        topLeft = Offset(border / 2f, border / 2f),
        size = GeomSize(innerW, innerH),
        cornerRadius = CornerRadius(radius, radius),
        style = Stroke(width = border),
    )
}

private fun DrawScope.drawCheckMark(size: GeomSize, t: Float, color: Color) {
    val start = Offset(size.width * 0.1818f, size.height * 0.4545f)
    val mid = Offset(size.width * 0.4091f, size.height * 0.6818f)
    val end = Offset(size.width * 0.8128f, size.height * 0.2781f)
    val path = Path()
    if (t < 0.5f) {
        val strokeT = t * 2f
        val drawMid = Offset(
            start.x + (mid.x - start.x) * strokeT,
            start.y + (mid.y - start.y) * strokeT,
        )
        path.moveTo(start.x, start.y)
        path.lineTo(drawMid.x, drawMid.y)
        path.lineTo(start.x, start.y)
    } else {
        val strokeT = (t - 0.5f) * 2f
        val drawEnd = Offset(
            mid.x + (end.x - mid.x) * strokeT,
            mid.y + (end.y - mid.y) * strokeT,
        )
        path.moveTo(start.x, start.y)
        path.lineTo(mid.x, mid.y)
        path.lineTo(drawEnd.x, drawEnd.y)
    }
    drawPath(
        path = path,
        color = color,
        style = Stroke(width = CheckboxDashStroke.toPx(), cap = StrokeCap.Butt),
    )
}

private fun DrawScope.drawDash(size: GeomSize, t: Float, color: Color) {
    val dashMarginFactor = (1f - DashSizeFactor) / 2f
    val start = Offset(size.width * dashMarginFactor, size.height * 0.5f)
    val mid = Offset(size.width * 0.5f, size.height * 0.5f)
    val end = Offset(size.width * (1f - dashMarginFactor), size.height * 0.5f)
    val drawStart = Offset(
        start.x + (mid.x - start.x) * (1f - t),
        start.y + (mid.y - start.y) * (1f - t),
    )
    val drawEnd = Offset(
        mid.x + (end.x - mid.x) * t,
        mid.y + (end.y - mid.y) * t,
    )
    drawLine(
        color = color,
        start = drawStart,
        end = drawEnd,
        strokeWidth = CheckboxDashStroke.toPx(),
        cap = StrokeCap.Butt,
    )
}

// `_kUncheckedBorderWidth` from `yaru_checkbox.dart`.
private val UncheckedBorderWidth = 2.dp
// `_kCheckboxDashStroke` from `yaru_checkbox.dart`.
private val CheckboxDashStroke = 2.dp
// `_kDashSizeFactor` from `yaru_checkbox.dart`.
private const val DashSizeFactor = 0.52f
// `_kIndicatorRadius` from `yaru_togglable.dart`.
private val IndicatorRadius = 20.dp
// `_kTogglableActiveResizeFactor` from `yaru_togglable.dart`.
private const val TogglableActiveResizeFactor = 2f
