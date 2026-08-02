package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.progressBarRangeInfo
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.setProgress
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isLight
import kotlinx.coroutines.launch

/**
 * Yaru-flavoured slider — foundation-only.
 *
 * Mirrors `_createSliderTheme` from `yaru.dart/lib/src/themes/common_themes.dart`
 * (lines 492-502):
 *  - `thumbColor: Colors.white`
 *  - `thumbShape: RoundSliderThumbShape(elevation: 3.0)` (Flutter default
 *    radius = 10 → 20dp diameter, with a 3dp drop shadow)
 *  - `overlayShape: RoundSliderOverlayShape(overlayRadius: 13)` — a 26dp
 *    circle painted behind the thumb when hovered/pressed
 *  - `overlayColor: primary @ alpha (light: 0.4, dark: 0.7)`
 *  - `inactiveTrackColor: onSurface @ 0.3`
 *  - `activeTrackColor`: inherits the Flutter default = `primary`
 *  - `trackHeight`: not overridden → Flutter default = 4dp
 */
@Composable
fun YaruSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
) {
    val scheme = LocalYaruColorScheme.current
    // Flutter default `trackHeight` (sliders/slider.dart `_defaultTrackHeight`).
    val trackHeight = 4.dp
    // Flutter's `RoundSliderThumbShape.enabledThumbRadius = 10` → 20dp diameter.
    val thumbSize = 20.dp
    // `RoundSliderOverlayShape(overlayRadius: 13)` from common_themes.dart L495.
    val overlaySize = 26.dp
    // `RoundSliderThumbShape(elevation: 3.0)` from common_themes.dart L499.
    val thumbElevation = 3.dp

    var widthPx by remember { mutableFloatStateOf(0f) }
    // Defensively normalise the range: if the caller passes an inverted or
    // degenerate range (`endInclusive < start`), `coerceIn(start, end)` would
    // throw `IllegalArgumentException`. Snap `end` up to `start` so the slider
    // collapses to a single point instead of crashing. Non-finite bounds
    // (NaN / +-Infinity) bypass `coerceAtLeast` (NaN comparisons return false)
    // and would propagate NaN through `fraction` into `fillMaxWidth(fraction)`,
    // which crashes with `require(fraction in 0f..1f)`. Substitute finite
    // fallbacks so the slider stays well-defined for malformed callers.
    val rangeStart = if (valueRange.start.isFinite()) valueRange.start else 0f
    val rangeEnd = run {
        val rawEnd = valueRange.endInclusive
        val safeEnd = if (rawEnd.isFinite()) rawEnd else rangeStart
        safeEnd.coerceAtLeast(rangeStart)
    }
    val rangeSpan = (rangeEnd - rangeStart).coerceAtLeast(1e-3f)
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()
    val coroutineScope = rememberCoroutineScope()
    // Mirrors Flutter's `_RenderSlider._textDirection`: in RTL the visual
    // origin is on the right edge of the track, so a tap/drag at `offset.x`
    // must be reflected before being mapped to a value. yaru.dart defers to
    // the Dart `Slider`, which is text-direction-aware out of the box.
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

    // Wrap caller-provided / per-composition values so the gesture coroutines
    // launched by `pointerInput(enabled)` (which only re-key on `enabled`) do
    // not capture stale closures for `onValueChange`, the value range, or the
    // text-direction. Without this, a parent that flips `valueRange` or
    // `LayoutDirection` between recompositions while a drag is in flight
    // would keep computing values from the old range.
    val currentOnValueChange by rememberUpdatedState(onValueChange)
    val currentRangeStart by rememberUpdatedState(rangeStart)
    val currentRangeEnd by rememberUpdatedState(rangeEnd)
    val currentRangeSpan by rememberUpdatedState(rangeSpan)
    val currentIsRtl by rememberUpdatedState(isRtl)

    fun positionToValue(x: Float): Float {
        if (widthPx <= 0f) return currentRangeStart
        // Guard against NaN/Infinity from synthetic pointer events: `coerceIn`
        // is a no-op for NaN, so an unsanitised input would propagate NaN out
        // through `onValueChange` into caller state and crash on next use.
        if (!x.isFinite()) return currentRangeStart
        val effectiveX = if (currentIsRtl) widthPx - x else x
        val t = (effectiveX / widthPx).coerceIn(0f, 1f)
        return currentRangeStart + t * currentRangeSpan
    }

    // Sanitise the externally-supplied `value` once. NaN / ±Infinity would
    // otherwise propagate into `fraction` and trigger `fillMaxWidth`'s
    // `require(fraction in 0f..1f)` crash, and `coerceIn` returns NaN for NaN
    // input on the JVM.
    val safeValue = when {
        value.isNaN() -> rangeStart
        value == Float.POSITIVE_INFINITY -> rangeEnd
        value == Float.NEGATIVE_INFINITY -> rangeStart
        else -> value.coerceIn(rangeStart, rangeEnd)
    }

    // Keyboard step sizes mirror the Flutter `Slider`'s `_AdjustSliderIntent`
    // semantics (sliders/slider.dart): a continuous slider with no `divisions`
    // uses 1/20 of the range (= 0.05 for 0..1) per arrow press, and the
    // `Slider.adjustmentUnit` constants used by `_actionMap` map Page Up/Down
    // to a "large" step. We use 1/10 of the range here — same as Compose
    // Foundation's built-in `Slider` keyboard handling.
    val arrowStep = rangeSpan / 20f
    val pageStep = rangeSpan / 10f

    fun nudge(delta: Float) {
        if (!enabled) return
        val next = (safeValue + delta).coerceIn(rangeStart, rangeEnd)
        if (next != safeValue) onValueChange(next)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            // Reserve enough vertical room for the 26dp hover overlay.
            .height(overlaySize)
            // Defensive: pointerInput-driven sliders are otherwise invisible to TalkBack/VoiceOver — expose the value/range info and a `setProgress` action so screen readers can read out and adjust the slider (commonMain Compose has no `Role.Slider`; `setProgress` + `progressBarRangeInfo` are the canonical Slider semantics).
            .semantics {
                progressBarRangeInfo = ProgressBarRangeInfo(
                    current = safeValue,
                    range = rangeStart..rangeEnd,
                )
                if (enabled) {
                    setProgress { target ->
                        val clamped = target.coerceIn(rangeStart, rangeEnd)
                        if (clamped != safeValue) onValueChange(clamped)
                        true
                    }
                } else {
                    disabled()
                }
            }
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)
                // Defensive: a placeable size at or near `Constraints.Infinity` (Int.MAX_VALUE) would yield `widthPx ≈ 2.1e9`, poisoning `positionToValue` and `widthPx * fraction` placement; reject non-finite via `.toFloat()` overflow guard.
                val rawWidth = placeable.width.toFloat()
                widthPx = if (rawWidth.isFinite() && rawWidth >= 0f && placeable.width != Int.MAX_VALUE) rawWidth else 0f
                layout(placeable.width, placeable.height) { placeable.place(0, 0) }
            }
            // Keyboard support — parity with Compose Foundation's built-in
            // `Slider` and the Flutter `Slider`. Arrow keys adjust by a
            // small step, Page Up/Down by a large step, Home/End jump to the
            // bounds. RTL flips the horizontal arrows so the visual direction
            // of motion stays consistent (Flutter's `Slider` does the same via
            // `Directionality`).
            .onKeyEvent { event ->
                if (!enabled) return@onKeyEvent false
                // Accept both KeyDown and KeyRepeat (Compose folds repeats into
                // KeyDown on most backends, but be explicit for desktop/web).
                if (event.type == KeyEventType.KeyUp) return@onKeyEvent false
                val leftDelta = if (isRtl) +arrowStep else -arrowStep
                val rightDelta = if (isRtl) -arrowStep else +arrowStep
                when (event.key) {
                    Key.DirectionLeft -> { nudge(leftDelta); true }
                    Key.DirectionRight -> { nudge(rightDelta); true }
                    Key.DirectionDown -> { nudge(-arrowStep); true }
                    Key.DirectionUp -> { nudge(+arrowStep); true }
                    Key.PageDown -> { nudge(-pageStep); true }
                    Key.PageUp -> { nudge(+pageStep); true }
                    Key.MoveHome -> {
                        if (safeValue != rangeStart) onValueChange(rangeStart)
                        true
                    }
                    Key.MoveEnd -> {
                        if (safeValue != rangeEnd) onValueChange(rangeEnd)
                        true
                    }
                    else -> false
                }
            }
            .focusable(enabled = enabled, interactionSource = interactionSource)
            .hoverable(interactionSource, enabled = enabled)
            .pointerInput(enabled) {
                if (!enabled) return@pointerInput
                detectTapGestures(
                    onPress = { offset ->
                        // Defensive: sanitise tap offset so a synthetic NaN press position cannot poison the PressInteraction (consumed by ripples).
                        val safeOffset = androidx.compose.ui.geometry.Offset(
                            x = if (offset.x.isFinite()) offset.x else 0f,
                            y = if (offset.y.isFinite()) offset.y else 0f,
                        )
                        val press = PressInteraction.Press(safeOffset)
                        interactionSource.emit(press)
                        // Defensive: try/finally guarantees we emit Release/Cancel even when the pointerInput coroutine is cancelled mid-await (e.g. on `enabled` re-key) so the interaction state cannot stay latched.
                        try {
                            val released = tryAwaitRelease()
                            interactionSource.emit(
                                if (released) PressInteraction.Release(press)
                                else PressInteraction.Cancel(press),
                            )
                        } catch (t: Throwable) {
                            interactionSource.emit(PressInteraction.Cancel(press))
                            throw t
                        }
                    },
                    onTap = { offset ->
                        // Defensive: positionToValue already finite-checks `x`, but guard `offset.x` explicitly so an Offset.Unspecified (NaN) tap cannot reach the value pipeline.
                        if (!offset.x.isFinite()) return@detectTapGestures
                        currentOnValueChange(
                            positionToValue(offset.x).coerceIn(currentRangeStart, currentRangeEnd),
                        )
                    },
                )
            }
            .pointerInput(enabled) {
                if (!enabled) return@pointerInput
                var pressInteraction: PressInteraction.Press? = null
                try {
                    detectDragGestures(
                        onDragStart = { offset ->
                            // Defensive: sanitise drag-start offset so a NaN/Infinity coordinate cannot leak into PressInteraction consumers (ripples) for the lifetime of the gesture.
                            val safeOffset = androidx.compose.ui.geometry.Offset(
                                x = if (offset.x.isFinite()) offset.x else 0f,
                                y = if (offset.y.isFinite()) offset.y else 0f,
                            )
                            val press = PressInteraction.Press(safeOffset)
                            pressInteraction = press
                            coroutineScope.launch { interactionSource.emit(press) }
                        },
                        onDragEnd = {
                            pressInteraction?.let { p ->
                                coroutineScope.launch { interactionSource.emit(PressInteraction.Release(p)) }
                            }
                            pressInteraction = null
                        },
                        onDragCancel = {
                            pressInteraction?.let { p ->
                                coroutineScope.launch { interactionSource.emit(PressInteraction.Cancel(p)) }
                            }
                            pressInteraction = null
                        },
                    ) { change, _ ->
                        currentOnValueChange(
                            positionToValue(change.position.x).coerceIn(currentRangeStart, currentRangeEnd),
                        )
                    }
                } finally {
                    // Defensive: if the pointerInput coroutine is cancelled mid-drag (e.g. `enabled` flips to false during a drag), neither onDragEnd nor onDragCancel fires — release any latched press here so MutableInteractionSource cannot stay stuck in a pressed state.
                    pressInteraction?.let { p ->
                        coroutineScope.launch { interactionSource.emit(PressInteraction.Cancel(p)) }
                    }
                    pressInteraction = null
                }
            },
    ) {
        // Inactive track — `onSurface @ 0.3` from common_themes.dart L500.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(trackHeight)
                .align(Alignment.CenterStart)
                .background(
                    color = scheme.onSurface.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(50),
                ),
        )

        // Active track — Flutter default `activeTrackColor: primary`.
        val fraction = ((safeValue - rangeStart) / rangeSpan).coerceIn(0f, 1f)
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = fraction)
                .height(trackHeight)
                .align(Alignment.CenterStart)
                .background(
                    color = scheme.primary,
                    shape = RoundedCornerShape(50),
                ),
        )

        // Press-only overlay — 26dp circle behind the thumb with
        // `primary @ alpha (light: 0.4, dark: 0.7)` from common_themes.dart L497.
        // Defensive: gate the accent halo on `pressed` only (not `hovered`). The Dart `Slider`'s `RoundSliderOverlayShape` paints via `activationAnimation`, which only ramps up during active drag/press in practice — Flutter's Yaru sample shows no halo on plain hover. Including `hovered` here over-painted the accent halo around the thumb whenever the cursor was just resting on it.
        if (pressed && enabled) {
            val overlayAlpha = if (scheme.isLight) 0.4f else 0.7f
            Box(
                modifier = Modifier
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        val maxX = (widthPx - placeable.width).coerceAtLeast(0f)
                        // Defensive: center the overlay on the thumb. `placeable.width / 2f` already covers the size difference between thumb and overlay; the previous `(thumbSize - overlaySize) / 2` term was a leftward bias that pulled the halo 3dp off-thumb.
                        val x = (widthPx * fraction - placeable.width / 2f).coerceIn(0f, maxX)
                        layout(placeable.width, placeable.height) {
                            // `placeRelative` mirrors the x coordinate against
                            // the parent layout direction — in RTL, the thumb
                            // (and its overlay) end up on the right edge for
                            // `value == start`, matching the Dart `Slider`.
                            placeable.placeRelative(x.toInt(), 0)
                        }
                    }
                    .size(overlaySize)
                    .align(Alignment.CenterStart)
                    .background(
                        color = scheme.primary.copy(alpha = overlayAlpha),
                        shape = CircleShape,
                    ),
            )
        }

        // Thumb — 20dp white circle with a 3dp drop shadow.
        Box(
            modifier = Modifier
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    val maxX = (widthPx - placeable.width).coerceAtLeast(0f)
                    val x = (widthPx * fraction - placeable.width / 2f).coerceIn(0f, maxX)
                    layout(placeable.width, placeable.height) {
                        placeable.placeRelative(x.toInt(), 0)
                    }
                }
                .size(thumbSize)
                .align(Alignment.CenterStart)
                // `RoundSliderThumbShape(elevation: 3.0)` — drop shadow before
                // the white fill so the shadow renders below the circle.
                //
                // Cross-platform note (CMP 1.10): `Modifier.shadow` is backed by
                // Skia's drop-shadow on JVM/Android and renders crisp; on iOS
                // and the Wasm/Web targets it relies on the same Skia backend
                // so the result is consistent. There is no overlap with any
                // ambient shadow color (Yaru's slider thumb stays plain), so
                // the elevation translates 1:1 to a black @ ~0.25 ambient
                // shadow at 3 dp blur — visually equivalent to Flutter's
                // `RoundSliderThumbShape(elevation: 3.0)`.
                .shadow(elevation = thumbElevation, shape = CircleShape)
                .background(
                    color = if (enabled) Color.White else scheme.onSurface.copy(alpha = 0.38f),
                    shape = CircleShape,
                ),
        )
    }
}
