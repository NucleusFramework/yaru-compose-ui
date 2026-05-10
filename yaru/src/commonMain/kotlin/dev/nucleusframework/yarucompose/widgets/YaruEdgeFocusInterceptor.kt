package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

/**
 * Detects focus entering [content] from a previous or next focusable node and
 * fires a callback before re-dispatching the focus past the sentinel.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_edge_focus_interceptor.dart`:
 *  - When focus arrives at the leading sentinel from the previous focusable
 *    node, [onFocusFromPreviousNode] is invoked and focus advances forward
 *    (Dart line 67: `_previousFocusNode.nextFocus()`), so the first child of
 *    [content] becomes focused.
 *  - When focus arrives at the trailing sentinel from the next focusable node,
 *    [onFocusFromNextNode] is invoked and focus moves backward (Dart line 69:
 *    `_nextFocusNode.previousFocus()`), so the last child of [content]
 *    becomes focused.
 *
 * Sentinels follow Dart's `canRequestFocus: !_outerFocusNode.hasFocus`
 * (lines 60-61): while focus is anywhere inside [content] the sentinels
 * become non-focusable, preventing the focus traversal from ping-ponging
 * back and forth between the two sentinels.
 */
@Composable
fun YaruEdgeFocusInterceptor(
    onFocusFromPreviousNode: () -> Unit,
    onFocusFromNextNode: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val focusManager = LocalFocusManager.current
    // Mirrors Dart's `_outerFocusNode.hasFocus` — true when any descendant of
    // [content] currently holds focus. Used to disable both sentinels so they
    // cannot re-fire while the user is tabbing through [content].
    var contentHasFocus by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.onFocusChanged { state ->
            // `hasFocus` is true when any descendant focus target is focused.
            contentHasFocus = state.hasFocus
        },
    ) {
        FocusSentinel(
            canRequestFocus = !contentHasFocus,
            onFocused = {
                onFocusFromPreviousNode()
                // Dart `_previousFocusNode.nextFocus()` -> advance forward into [content].
                // If [content] has no focusable children, `moveFocus` returns
                // false; clear focus to avoid bouncing onto the trailing
                // sentinel (which would re-fire `onFocusFromNextNode`).
                if (!focusManager.moveFocus(FocusDirection.Next)) {
                    focusManager.clearFocus()
                }
            },
        )
        content()
        FocusSentinel(
            canRequestFocus = !contentHasFocus,
            onFocused = {
                onFocusFromNextNode()
                // Dart `_nextFocusNode.previousFocus()` -> step back into [content].
                // Same no-focusable-children safeguard as the leading sentinel.
                if (!focusManager.moveFocus(FocusDirection.Previous)) {
                    focusManager.clearFocus()
                }
            },
        )
    }
}

@Composable
private fun FocusSentinel(canRequestFocus: Boolean, onFocused: () -> Unit) {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .size(0.dp)
            .onFocusChanged { state ->
                if (state.isFocused) onFocused()
            }
            .focusable(enabled = canRequestFocus),
    )
}
