package dev.nucleusframework.yarucompose.foundation

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Action returned by a [YaruEntrySegment] event handler to instruct the
 * containing entry on what to do next.
 *
 * Mirrors `YaruSegmentEventReturnAction` from
 * `yaru.dart/lib/src/foundation/yaru_entry_segment.dart`.
 */
enum class YaruSegmentEventReturnAction {
    SelectPreviousSegment,
    SelectNextSegment,
    Handled,
    Ignored,
}

/**
 * Formats raw segment input into the rendered segment text.
 *
 * The result must be at least [minLength] characters long and at most [maxLength]
 * (when not null). A null `segmentInput` is rendered as a placeholder.
 */
typealias YaruSegmentInputFormatter = (
    segmentInput: String?,
    minLength: Int,
    maxLength: Int?,
) -> String

/**
 * A single selectable / editable segment of a [dev.nucleusframework.yarucompose.widgets.YaruSegmentedEntry].
 *
 * Mirrors `YaruEntrySegment` from
 * `yaru.dart/lib/src/foundation/yaru_entry_segment.dart`. Listeners observe
 * changes to [text] and [input].
 */
@Stable
interface YaruEntrySegment {
    val input: String?
    val text: String
    val length: Int

    fun addListener(listener: () -> Unit)
    fun removeListener(listener: () -> Unit)

    fun onSelect(selected: Boolean)
    fun onInput(input: String): YaruSegmentEventReturnAction
    fun onUpArrowKey(): YaruSegmentEventReturnAction
    fun onDownArrowKey(): YaruSegmentEventReturnAction
    fun onBackspaceKey(): YaruSegmentEventReturnAction
}

/** Common listener bookkeeping. */
abstract class YaruEntrySegmentBase : YaruEntrySegment {
    private val listeners = mutableListOf<() -> Unit>()

    override fun addListener(listener: () -> Unit) {
        listeners += listener
    }

    override fun removeListener(listener: () -> Unit) {
        listeners -= listener
    }

    protected fun notifyListeners() {
        listeners.toList().forEach { it.invoke() }
    }
}

/**
 * Free-form text segment.
 *
 * Mirrors `YaruStringSegment` from
 * `yaru.dart/lib/src/foundation/yaru_entry_segment.dart`.
 */
class YaruStringSegment(
    val minLength: Int = 1,
    val maxLength: Int?,
    initialInput: String? = null,
    val inputFormatter: YaruSegmentInputFormatter,
) : YaruEntrySegmentBase() {

    init {
        require(minLength > 0) { "minLength must be > 0, was $minLength" }
        require(maxLength == null || maxLength >= minLength) {
            "maxLength ($maxLength) must be null or >= minLength ($minLength)"
        }
    }

    companion object {
        /** Creates a [YaruStringSegment] with a fixed length. */
        fun fixed(
            length: Int,
            initialInput: String? = null,
            inputFormatter: YaruSegmentInputFormatter,
        ): YaruStringSegment {
            require(length > 0) { "length must be > 0, was $length" }
            return YaruStringSegment(
                minLength = length,
                maxLength = length,
                initialInput = initialInput,
                inputFormatter = inputFormatter,
            )
        }
    }

    private var _input by mutableStateOf(initialInput)
    private var selected = false
    private var squashOnNextInput = false

    override val input: String? get() = _input

    override val text: String
        get() {
            // Defensive: a misbehaving custom formatter must not crash rendering.
            // Pad short results with a space and truncate long ones to stay within bounds.
            val raw = inputFormatter(_input, minLength, maxLength)
            val padded = if (raw.length < minLength) raw.padEnd(minLength, ' ') else raw
            return if (maxLength != null && padded.length > maxLength) padded.take(maxLength) else padded
        }

    override val length: Int get() = text.length

    override fun onSelect(selected: Boolean) {
        if (!this.selected && selected) squashOnNextInput = true
        this.selected = selected
    }

    override fun onInput(input: String): YaruSegmentEventReturnAction {
        var action = YaruSegmentEventReturnAction.Handled
        val previousInput = _input

        if (squashOnNextInput) {
            _input = null
            squashOnNextInput = false
        }

        _input = (_input ?: "") + input

        val current = _input!!
        if (maxLength != null && current.length >= maxLength) {
            _input = current.take(maxLength)
            action = YaruSegmentEventReturnAction.SelectNextSegment
        }

        if (_input != previousInput) notifyListeners()
        return action
    }

    override fun onBackspaceKey(): YaruSegmentEventReturnAction {
        if (_input != null) {
            _input = null
            notifyListeners()
            return YaruSegmentEventReturnAction.Handled
        }
        return YaruSegmentEventReturnAction.SelectPreviousSegment
    }

    override fun onUpArrowKey(): YaruSegmentEventReturnAction =
        YaruSegmentEventReturnAction.Ignored

    override fun onDownArrowKey(): YaruSegmentEventReturnAction =
        YaruSegmentEventReturnAction.Ignored
}

/** Callback for value transforms on a [YaruNumericSegment]. */
typealias YaruNumericSegmentCallback = (input: String?, value: Int?, oldValue: Int?) -> Int?

/**
 * Numeric segment with placeholder rendering and arrow-key spinning.
 *
 * Mirrors `YaruNumericSegment` from
 * `yaru.dart/lib/src/foundation/yaru_entry_segment.dart`.
 */
class YaruNumericSegment(
    val minLength: Int,
    val maxLength: Int?,
    initialValue: Int? = null,
    val placeholderLetter: String,
    val onValueChange: YaruNumericSegmentCallback? = null,
    val onInputCallback: YaruNumericSegmentCallback? = null,
    val onUpArrowKeyCallback: YaruNumericSegmentCallback? = null,
    val onDownArrowKeyCallback: YaruNumericSegmentCallback? = null,
) : YaruEntrySegmentBase() {

    init {
        require(minLength > 0) { "minLength must be > 0, was $minLength" }
        require(maxLength == null || maxLength >= minLength) {
            "maxLength ($maxLength) must be null or >= minLength ($minLength)"
        }
    }

    companion object {
        /** Creates a [YaruNumericSegment] with a fixed length. */
        fun fixed(
            length: Int,
            initialValue: Int? = null,
            placeholderLetter: String,
            onValueChange: YaruNumericSegmentCallback? = null,
            onInputCallback: YaruNumericSegmentCallback? = null,
            onUpArrowKeyCallback: YaruNumericSegmentCallback? = null,
            onDownArrowKeyCallback: YaruNumericSegmentCallback? = null,
        ): YaruNumericSegment {
            require(length > 0) { "length must be > 0, was $length" }
            return YaruNumericSegment(
                minLength = length,
                maxLength = length,
                initialValue = initialValue,
                placeholderLetter = placeholderLetter,
                onValueChange = onValueChange,
                onInputCallback = onInputCallback,
                onUpArrowKeyCallback = onUpArrowKeyCallback,
                onDownArrowKeyCallback = onDownArrowKeyCallback,
            )
        }
    }

    private var _value by mutableStateOf(initialValue)
    private var _input by mutableStateOf<String?>(null)
    private var selected = false
    private var squashOnNextInput = false

    var value: Int?
        get() = _value
        set(newValue) {
            val oldValue = _value
            val candidate = onValueChange?.invoke(_input, newValue, oldValue) ?: newValue
            // Mirror Dart's `_value!.length > maxLength!` where the `_IntX.length`
            // extension is `toString().length` — i.e. counts the leading minus
            // sign for negative numbers (yaru_entry_segment.dart line 164).
            _value = if (maxLength != null && candidate != null && candidate.toString().length > maxLength) {
                oldValue
            } else {
                candidate
            }
            if (_value != oldValue) notifyListeners()
        }

    override val input: String? get() = _input

    /** Mirrors the public `input` setter of `YaruNumericSegment` in Dart. */
    fun setRawInput(value: String?) {
        _input = value
    }

    override val text: String get() = formatValue()
    override val length: Int get() = text.length

    private fun formatValue(): String {
        val v = _value
        if (v != null) {
            // `Int.MIN_VALUE.absoluteValue` overflows back to `Int.MIN_VALUE`; use Long to be safe
            // so the magnitude string never carries a stray minus sign.
            val stringValue = v.toLong().let { if (it < 0L) -it else it }.toString()
            val remain = (minLength - stringValue.length).coerceAtLeast(0)
            return if (v < 0) {
                "-${"0".repeat((remain - 2).coerceAtLeast(0))}$stringValue"
            } else {
                "0".repeat(remain) + stringValue
            }
        }
        return placeholderLetter.repeat(minLength)
    }

    override fun onSelect(selected: Boolean) {
        if (!this.selected && selected) squashOnNextInput = true
        this.selected = selected
    }

    override fun onInput(input: String): YaruSegmentEventReturnAction {
        var action = YaruSegmentEventReturnAction.Handled
        val oldValue = _value
        var candidateValue: Int? = null

        if (squashOnNextInput) {
            _value = null
            _input = null
            squashOnNextInput = false
        }

        var candidateInput = (_input ?: "") + input
        val intCandidate = candidateInput.toIntOrNull()

        if (intCandidate != null) {
            if (maxLength != null && candidateInput.length >= maxLength) {
                candidateInput = candidateInput.take(maxLength)
                action = YaruSegmentEventReturnAction.SelectNextSegment
            }
            // `take(maxLength)` may strip the trailing digit of a "-N" string, leaving a
            // bare "-" which is not parseable. Fall back to `toIntOrNull()` and skip the
            // value update in that edge case rather than throwing NumberFormatException.
            val truncatedValue = candidateInput.toIntOrNull()
            if (truncatedValue != null) {
                _input = candidateInput
                candidateValue = truncatedValue
            }
        }

        value = onInputCallback?.invoke(_input, candidateValue, oldValue) ?: candidateValue

        if (action == YaruSegmentEventReturnAction.SelectNextSegment) {
            _input = null
        }

        return action
    }

    override fun onBackspaceKey(): YaruSegmentEventReturnAction {
        if (_value != null) {
            _input = null
            value = null
            return YaruSegmentEventReturnAction.Handled
        }
        return YaruSegmentEventReturnAction.SelectPreviousSegment
    }

    override fun onUpArrowKey(): YaruSegmentEventReturnAction =
        onArrowKey(modifier = 1, default = 1, callback = onUpArrowKeyCallback)

    override fun onDownArrowKey(): YaruSegmentEventReturnAction =
        onArrowKey(modifier = -1, default = 0, callback = onDownArrowKeyCallback)

    private fun onArrowKey(
        modifier: Int,
        default: Int,
        callback: YaruNumericSegmentCallback?,
    ): YaruSegmentEventReturnAction {
        val oldValue = _value
        // Saturating add: prevent silent wrap-around at Int.MAX_VALUE / Int.MIN_VALUE.
        val candidate = if (_value != null) {
            val current = _value!!
            when {
                modifier > 0 && current > Int.MAX_VALUE - modifier -> Int.MAX_VALUE
                modifier < 0 && current < Int.MIN_VALUE - modifier -> Int.MIN_VALUE
                else -> current + modifier
            }
        } else default

        _input = null
        value = callback?.invoke(_input, candidate, oldValue) ?: candidate
        return YaruSegmentEventReturnAction.Handled
    }

}

/**
 * Enum-valued segment whose value cycles through [values] via arrow keys, and
 * is reachable via a starts-with prefix match on character input.
 *
 * Mirrors `YaruEnumSegment` from
 * `yaru.dart/lib/src/foundation/yaru_entry_segment.dart`.
 */
class YaruEnumSegment<T : Enum<T>>(
    initialValue: T? = null,
    val values: List<T>,
) : YaruEntrySegmentBase() {

    init {
        require(values.isNotEmpty()) { "YaruEnumSegment requires a non-empty values list" }
        // Defensive: an out-of-list `initialValue` would yield `valueIndex == -1` and corrupt arrow-key cycling.
        require(initialValue == null || initialValue in values) {
            "initialValue ($initialValue) must be one of $values"
        }
    }

    private var _value by mutableStateOf(initialValue ?: values.first())

    var value: T
        get() = _value
        set(newValue) {
            if (_value == newValue) return
            // Defensive: reject values not in `values` to keep `valueIndex` valid.
            require(newValue in values) { "value ($newValue) must be one of $values" }
            _value = newValue
            notifyListeners()
        }

    private val valueIndex: Int get() = values.indexOf(_value)

    override val input: String? get() = null
    override val text: String get() = _value.name
    override val length: Int get() = text.length

    override fun onInput(input: String): YaruSegmentEventReturnAction {
        // Dart's `firstWhere(... orElse: () => value)` keeps the current value
        // when no match exists; case-sensitive prefix match per `e.name.startsWith(input)`
        // (yaru_entry_segment.dart line 332). Listeners are notified unconditionally.
        _value = values.firstOrNull { it.name.startsWith(input) } ?: _value
        notifyListeners()
        return YaruSegmentEventReturnAction.Handled
    }

    override fun onUpArrowKey(): YaruSegmentEventReturnAction {
        // Dart writes `value` directly and then calls `notifyListeners()` — bypassing
        // any change-detection (yaru_entry_segment.dart line 341-348). Mirror that.
        _value = if (valueIndex + 1 < values.size) values[valueIndex + 1] else values.first()
        notifyListeners()
        return YaruSegmentEventReturnAction.Handled
    }

    override fun onDownArrowKey(): YaruSegmentEventReturnAction {
        _value = if (valueIndex - 1 >= 0) values[valueIndex - 1] else values.last()
        notifyListeners()
        return YaruSegmentEventReturnAction.Handled
    }

    override fun onBackspaceKey(): YaruSegmentEventReturnAction =
        YaruSegmentEventReturnAction.SelectPreviousSegment

    override fun onSelect(selected: Boolean) = Unit
}

/**
 * Selection controller for a [dev.nucleusframework.yarucompose.widgets.YaruSegmentedEntry].
 *
 * Mirrors `YaruSegmentedEntryController` from
 * `yaru.dart/lib/src/foundation/yaru_entry_segment.dart`.
 */
@Stable
class YaruSegmentedEntryController(
    val length: Int,
    initialIndex: Int = 0,
) {
    init {
        require(length >= 0) { "length must be non-negative, was $length" }
        require(length == 0 || (initialIndex in 0 until length)) {
            "initialIndex ($initialIndex) must be in [0, $length)"
        }
    }

    private val listeners = mutableListOf<() -> Unit>()
    private var _index by mutableIntStateOf(initialIndex)

    var index: Int
        get() = _index
        set(value) {
            // Defensive: a length-0 controller is constructible (per the init), so silently no-op writes instead of crashing — mirrors `YaruPageController.index`.
            if (length == 0) return
            require(value in 0 until length) {
                "index ($value) must be in [0, $length)"
            }
            if (value == _index) return
            _index = value
            listeners.toList().forEach { it.invoke() }
        }

    fun addListener(listener: () -> Unit) {
        listeners += listener
    }

    fun removeListener(listener: () -> Unit) {
        listeners -= listener
    }

    /** Selects the previous segment if possible. Returns true on success. */
    fun maybeSelectPreviousSegment(): Boolean {
        if (_index - 1 >= 0) {
            index = _index - 1
            return true
        }
        return false
    }

    /** Selects the next segment if possible. Returns true on success. */
    fun maybeSelectNextSegment(): Boolean {
        if (_index + 1 < length) {
            index = _index + 1
            return true
        }
        return false
    }

    fun selectFirstSegment() {
        if (length == 0) return
        index = 0
    }

    fun selectLastSegment() {
        if (length == 0) return
        index = length - 1
    }
}
