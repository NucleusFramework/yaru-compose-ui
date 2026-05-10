package dev.nucleusframework.yarucompose.foundation

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Tracks the active and previous page index in a multi-page widget.
 *
 * Mirrors `yaru.dart/lib/src/foundation/yaru_page_controller.dart`.
 */
@Stable
class YaruPageController(
    val length: Int,
    val initialIndex: Int = -1,
) {
    init {
        require(length >= 0) { "length must be non-negative, was $length" }
        // Mirrors Dart's `assert(value < length || length == 0)` from
        // yaru_page_controller.dart L18, applied at construction so an
        // out-of-range `initialIndex` can't slip past the setter check.
        require(initialIndex == -1 || length == 0 || initialIndex < length) {
            "initialIndex ($initialIndex) must be -1 or in [0, $length)"
        }
    }

    private val listeners = mutableListOf<() -> Unit>()
    private var _index by mutableStateOf(initialIndex)
    private var _previousIndex by mutableStateOf(initialIndex)

    var index: Int
        get() = _index
        set(value) {
            // Defensive: align with `init`, allow -1 as the unselected sentinel and otherwise require [0, length).
            require(value == -1 || length == 0 || value in 0 until length) {
                "index ($value) must be -1 or in [0, $length)"
            }
            _previousIndex = _index
            _index = value
            listeners.toList().forEach { it.invoke() }
        }

    val previousIndex: Int get() = _previousIndex

    fun addListener(listener: () -> Unit) {
        listeners += listener
    }

    fun removeListener(listener: () -> Unit) {
        listeners -= listener
    }
}
