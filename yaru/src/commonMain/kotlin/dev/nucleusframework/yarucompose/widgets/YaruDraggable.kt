package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout

/**
 * A draggable element designed to live inside a `Box` (the Compose equivalent
 * of Flutter's `Stack` + `Positioned`).
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_draggable.dart`. The composable
 * positions [content] at the current drag offset, exposes drag state and hover
 * state to the builder, and lets the consumer override every position update
 * via [onDragUpdate] for collision detection.
 */
@Composable
fun YaruDraggable(
    initialPosition: Offset,
    modifier: Modifier = Modifier,
    onDragStart: (() -> Unit)? = null,
    onDragUpdate: ((current: Offset, candidate: Offset) -> Offset)? = null,
    onDragEnd: (() -> Unit)? = null,
    cursor: PointerIcon? = null,
    dragCursor: PointerIcon? = null,
    content: @Composable (position: Offset, isDragging: Boolean, isHovering: Boolean) -> Unit,
) {
    var position by remember { mutableStateOf(initialPosition.sanitized()) }
    var isDragging by remember { mutableStateOf(false) }
    var isHovering by remember { mutableStateOf(false) }
    // Mirrors Dart `_initialPosition` (captured on pan start) and `_moveOffset`
    // (accumulated unclamped delta, reset between gestures). Together they
    // produce the candidate position so that `onDragUpdate` clamping does NOT
    // feed back into the accumulator — matching `yaru_draggable.dart`.
    var dragStartPosition by remember { mutableStateOf(Offset.Zero) }
    var moveOffset by remember { mutableStateOf(Offset.Zero) }

    // `pointerInput` keyed on `Unit` captures these lambda references once for
    // the lifetime of the modifier, so we route caller callbacks through
    // `rememberUpdatedState` to avoid them going stale across recomposition
    // (e.g. when the parent passes a fresh closure over updated state).
    val currentOnDragStart by rememberUpdatedState(onDragStart)
    val currentOnDragUpdate by rememberUpdatedState(onDragUpdate)
    val currentOnDragEnd by rememberUpdatedState(onDragEnd)

    val dragModifier = Modifier
        .pointerInput(Unit) {
            detectDragGestures(
                onDragStart = {
                    isDragging = true
                    dragStartPosition = position.sanitized()
                    moveOffset = Offset.Zero
                    currentOnDragStart?.invoke()
                },
                onDrag = { _, drag ->
                    // Guard against NaN/Infinity from pointer events corrupting
                    // the accumulator irreversibly for the rest of the gesture.
                    val safeDrag = drag.sanitized()
                    val accumulated = (moveOffset + safeDrag).sanitized()
                    // Sum of two finite floats can still overflow to +/-Infinity
                    // for sustained extreme drags; re-sanitise post-add so the
                    // accumulator can never latch into a non-finite state.
                    moveOffset = accumulated
                    val candidate = Offset(
                        x = dragStartPosition.x + accumulated.x,
                        y = dragStartPosition.y + accumulated.y,
                    ).sanitized()
                    val next = currentOnDragUpdate?.invoke(position, candidate) ?: candidate
                    // Sanitize callback return value too — a misbehaving collision
                    // resolver returning NaN/Infinity would otherwise poison state.
                    position = next.sanitized()
                },
                onDragEnd = {
                    isDragging = false
                    moveOffset = Offset.Zero
                    currentOnDragEnd?.invoke()
                },
                onDragCancel = {
                    isDragging = false
                    moveOffset = Offset.Zero
                    // On cancel, restore the position captured at gesture start
                    // so a cancelled drag has no visible effect.
                    position = dragStartPosition
                    currentOnDragEnd?.invoke()
                },
            )
        }
        .pointerInput(Unit) {
            // Track hover transitions to mirror Flutter's MouseRegion onEnter/onExit.
            awaitPointerEventScope {
                while (true) {
                    val event = awaitPointerEvent()
                    when (event.type) {
                        PointerEventType.Enter -> isHovering = true
                        PointerEventType.Exit -> isHovering = false
                    }
                }
            }
        }
        .let { m ->
            val activeCursor = if (isDragging && dragCursor != null) dragCursor else cursor
            if (activeCursor != null) m.pointerHoverIcon(activeCursor) else m
        }
        .layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            layout(placeable.width, placeable.height) {
                placeable.place(position.x.toInt(), position.y.toInt())
            }
        }

    Box(modifier = modifier.then(dragModifier)) {
        content(position, isDragging, isHovering)
    }
}

/**
 * Replaces non-finite components (NaN, +/-Infinity) with `0f` so that
 * pointer-event noise or upstream miscalculations cannot corrupt drag state
 * for the rest of the gesture.
 */
private fun Offset.sanitized(): Offset {
    val safeX = if (x.isFinite()) x else 0f
    val safeY = if (y.isFinite()) y else 0f
    return if (safeX == x && safeY == y) this else Offset(safeX, safeY)
}
