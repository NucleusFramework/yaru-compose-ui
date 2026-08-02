package dev.nucleusframework.yarucompose.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.foundation.YaruEntrySegment
import dev.nucleusframework.yarucompose.foundation.YaruEnumSegment
import dev.nucleusframework.yarucompose.foundation.YaruNumericSegment
import dev.nucleusframework.yarucompose.foundation.YaruNumericSegmentCallback
import dev.nucleusframework.yarucompose.foundation.YaruSegmentedEntryController
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

// region Constants — mirrors top-level consts in `yaru_date_time_entry.dart`.
private const val MaxMonthValue = 12
private const val MaxDayValue = 31
private const val Max24HourValue = 23
private const val Max12HourValue = 12
private const val MaxMinuteValue = 59
private const val TimePlaceholder = "-"
private const val TimeDelimiter = ":"
// Dart resolves the date separator from the framework's `dateSeparator`;
// the en-locale default (and the most common form for the GTK/Yaru desktop)
// is `/`. We hardcode `/` here for parity with the Dart sample on macOS /
// Linux defaults — until KMP gains an equivalent localization hook.
private const val DateDelimiter = "/"
private const val YearPlaceholder = "y"
private const val MonthPlaceholder = "m"
private const val DayPlaceholder = "d"
// Dart falls back to `MaterialLocalizations.invalidDateFormatLabel` /
// `dateOutOfRangeLabel`; these are the en-locale strings, hardcoded for the
// same reason as `DateDelimiter` above.
private const val InvalidFormatLabel = "Invalid format."
private const val OutOfRangeLabel = "Out of range."
// endregion

/** Mirrors `SelectableDateTimePredicate` from `yaru_date_time_entry.dart`. */
typealias SelectableDateTimePredicate = (LocalDateTime) -> Boolean

/** Mirrors `SelectableTimeOfDayPredicate` from `yaru_date_time_entry.dart`. */
typealias SelectableTimeOfDayPredicate = (LocalTime) -> Boolean

/** AM/PM marker, mirrors `DayPeriod` from the Flutter framework. */
enum class YaruDayPeriod { AM, PM }

private val YaruDayPeriod.isAm: Boolean get() = this == YaruDayPeriod.AM
private val YaruDayPeriod.isPm: Boolean get() = this == YaruDayPeriod.PM
private val YaruDayPeriod.invert: YaruDayPeriod
    get() = if (this == YaruDayPeriod.PM) YaruDayPeriod.AM else YaruDayPeriod.PM

private fun YaruDayPeriod.to24Hour(hour: Int): Int = when {
    isPm && hour != 12 -> hour + 12
    isPm -> 12
    !isPm && hour != 12 -> hour
    else -> 0
}

private fun Int.to12HourOfPeriod(): Int = when {
    this == 0 -> 12
    this > 12 -> this - 12
    else -> this
}

private val Int.firstNumber: Int
    // Defensive: skip a leading '-' so negative magnitudes don't crash digitToInt().
    get() = toString().firstOrNull { it.isDigit() }?.digitToInt() ?: 0

private enum class DateTimeEntryType { Date, Time, DateTime }

private val DateTimeEntryType.hasDate: Boolean
    get() = this == DateTimeEntryType.Date || this == DateTimeEntryType.DateTime

private val DateTimeEntryType.hasTime: Boolean
    get() = this == DateTimeEntryType.Time || this == DateTimeEntryType.DateTime

// region Controllers — mirror `IYaruDateTimeEntryController`,
// `YaruDateTimeEntryController`, and `YaruTimeEntryController` from
// `yaru_date_time_entry.dart`.

/** Common interface shared by date/time entry controllers. */
@Stable
interface IYaruDateTimeEntryController {
    var dateTime: LocalDateTime?
    fun addListener(listener: () -> Unit)
    fun removeListener(listener: () -> Unit)
}

/** Backing helper for controller listener bookkeeping. */
abstract class YaruDateTimeEntryControllerBase internal constructor() : IYaruDateTimeEntryController {
    private val listeners = mutableListOf<() -> Unit>()
    final override fun addListener(listener: () -> Unit) { listeners += listener }
    final override fun removeListener(listener: () -> Unit) { listeners -= listener }
    protected fun notifyListeners() {
        listeners.toList().forEach { it.invoke() }
    }
}

/** Controller for [YaruDateTimeEntry]. Mirrors `YaruDateTimeEntryController`. */
@Stable
class YaruDateTimeEntryController(
    dateTime: LocalDateTime? = null,
) : YaruDateTimeEntryControllerBase() {
    private var _dateTime by mutableStateOf(dateTime)
    override var dateTime: LocalDateTime?
        get() = _dateTime
        set(value) {
            if (_dateTime == value) return
            _dateTime = value
            notifyListeners()
        }

    companion object {
        // Mirrors `YaruDateTimeEntryController.now()` from `yaru_date_time_entry.dart`:
        // pre-fills with the current local datetime so the field renders today's
        // date / time on first composition. Uses `kotlinx.datetime.Clock.System`
        // converted to the system default time zone for parity with Dart's
        // `DateTime.now()`.
        fun now(): YaruDateTimeEntryController =
            YaruDateTimeEntryController(
                dateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
            )
    }
}

/** Controller for [YaruTimeEntry]. Mirrors `YaruTimeEntryController`. */
@Stable
class YaruTimeEntryController(
    timeOfDay: LocalTime? = null,
) : YaruDateTimeEntryControllerBase() {
    private var _time by mutableStateOf(timeOfDay)

    var timeOfDay: LocalTime?
        get() = _time
        set(value) {
            if (_time == value) return
            _time = value
            notifyListeners()
        }

    override var dateTime: LocalDateTime?
        get() = _time?.let { LocalDateTime(0, 1, 1, it.hour, it.minute) }
        set(value) {
            timeOfDay = value?.let { LocalTime(it.hour, it.minute) }
        }

    companion object {
        // Mirrors `YaruTimeEntryController.now()` from `yaru_date_time_entry.dart`:
        // pre-fills with the current local time of day.
        fun now(): YaruTimeEntryController {
            val nowDt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            return YaruTimeEntryController(timeOfDay = LocalTime(nowDt.hour, nowDt.minute))
        }
    }
}
// endregion

/**
 * Segmented entry that accepts and validates a datetime entered by the user.
 *
 * Mirrors `YaruDateTimeEntry` from
 * `yaru.dart/lib/src/widgets/yaru_date_time_entry.dart`. When [includeTime] is
 * true the entry adds `HH`, `mm`, and (when [force24HourFormat] is false) an
 * AM/PM segment.
 */
@Composable
fun YaruDateTimeEntry(
    firstDateTime: LocalDateTime,
    lastDateTime: LocalDateTime,
    modifier: Modifier = Modifier,
    controller: YaruDateTimeEntryController? = null,
    includeTime: Boolean = true,
    initialDateTime: LocalDateTime? = null,
    // Mirrors `bool? force24HourFormat` from yaru.dart: when null, falls back to
    // the (un-localized) default below. We don't have access to the Flutter
    // localizations on KMP, so the resolver below treats `null` as 12-hour like
    // en_US for parity with the Dart sample on macOS / Linux defaults.
    force24HourFormat: Boolean = false,
    onChanged: ((LocalDateTime?) -> Unit)? = null,
    // Mirror `selectableDateTimePredicate`, `errorFormatText`,
    // `errorInvalidText`, and `acceptEmpty` from yaru.dart. The Dart widget
    // surfaces validation through the enclosing `Form`; without one on KMP the
    // entry validates live and shows the error text under the field.
    selectableDateTimePredicate: SelectableDateTimePredicate? = null,
    errorFormatText: String? = null,
    errorInvalidText: String? = null,
    acceptEmpty: Boolean = true,
    autofocus: Boolean = false,
    showClearButton: Boolean = true,
) {
    require(firstDateTime <= lastDateTime) { "firstDateTime must be <= lastDateTime" }
    require(initialDateTime == null || controller == null) {
        "Provide either `initialDateTime` or `controller`, not both"
    }

    DateTimeEntryImpl(
        type = if (includeTime) DateTimeEntryType.DateTime else DateTimeEntryType.Date,
        controller = controller,
        initialDateTime = initialDateTime,
        firstDateTime = firstDateTime,
        lastDateTime = lastDateTime,
        force24HourFormat = force24HourFormat,
        onChanged = onChanged,
        selectableDateTimePredicate = selectableDateTimePredicate,
        errorFormatText = errorFormatText,
        errorInvalidText = errorInvalidText,
        acceptEmpty = acceptEmpty,
        modifier = modifier,
        autofocus = autofocus,
        showClearButton = showClearButton,
    )
}

/**
 * Time-only counterpart of [YaruDateTimeEntry].
 *
 * Mirrors `YaruTimeEntry` from
 * `yaru.dart/lib/src/widgets/yaru_date_time_entry.dart`. Internally adapts to a
 * datetime-shaped entry using a sentinel date.
 */
@Composable
fun YaruTimeEntry(
    modifier: Modifier = Modifier,
    controller: YaruTimeEntryController? = null,
    initialTimeOfDay: LocalTime? = null,
    firstTime: LocalTime? = null,
    lastTime: LocalTime? = null,
    // Mirrors `bool? force24HourFormat` from yaru.dart `YaruTimeEntry`. See
    // [YaruDateTimeEntry] for why null defaults to 12-hour.
    force24HourFormat: Boolean = false,
    onChanged: ((LocalTime?) -> Unit)? = null,
    // See [YaruDateTimeEntry] — mirrors `selectableTimeOfDayPredicate` and the
    // error/acceptEmpty trio, adapted to [LocalTime] like the Dart
    // `_predicateCallbackAdapter`.
    selectableTimeOfDayPredicate: SelectableTimeOfDayPredicate? = null,
    errorFormatText: String? = null,
    errorInvalidText: String? = null,
    acceptEmpty: Boolean = true,
    autofocus: Boolean = false,
    showClearButton: Boolean = true,
) {
    require(initialTimeOfDay == null || controller == null) {
        "Provide either `initialTimeOfDay` or `controller`, not both"
    }
    val first = (firstTime ?: LocalTime(0, 0)).toSentinelDateTime()
    val last = (lastTime ?: LocalTime(23, 59)).toSentinelDateTime()
    DateTimeEntryImpl(
        type = DateTimeEntryType.Time,
        controller = controller,
        initialDateTime = initialTimeOfDay?.toSentinelDateTime(),
        firstDateTime = first,
        lastDateTime = last,
        force24HourFormat = force24HourFormat,
        onChanged = onChanged?.let { cb ->
            { dt -> cb(dt?.let { LocalTime(it.hour, it.minute) }) }
        },
        selectableDateTimePredicate = selectableTimeOfDayPredicate?.let { predicate ->
            { dt -> predicate(LocalTime(dt.hour, dt.minute)) }
        },
        errorFormatText = errorFormatText,
        errorInvalidText = errorInvalidText,
        acceptEmpty = acceptEmpty,
        modifier = modifier,
        autofocus = autofocus,
        showClearButton = showClearButton,
    )
}

private fun LocalTime.toSentinelDateTime(): LocalDateTime =
    LocalDateTime(0, 1, 1, hour, minute)

/**
 * Holds all segment + controller state for a single date / time / dateTime
 * entry. Mirrors `YaruDateTimeEntryState` from yaru.dart line-by-line: the
 * heavy lifting (segment construction, callbacks, parsing, and clearing) lives
 * here, while the surrounding [DateTimeEntryImpl] just plumbs a [YaruSegmentedEntry].
 */
private class DateTimeEntryHolder(
    val type: DateTimeEntryType,
    val owningController: IYaruDateTimeEntryController?,
    val initialDateTime: LocalDateTime?,
    val firstDateTime: LocalDateTime,
    val lastDateTime: LocalDateTime,
    val force24HourFormat: Boolean,
    // `onChanged` is intentionally a `var` so it can be refreshed on every
    // recomposition — the holder is `remember`-ed across `onChanged` lambda
    // identities (see `DateTimeEntryImpl`), and capturing the initial lambda
    // would otherwise leak stale state into segment / controller callbacks.
    var onChanged: ((LocalDateTime?) -> Unit)?,
    // Validation inputs — `var` for the same refresh-on-recomposition reason.
    var selectableDateTimePredicate: SelectableDateTimePredicate?,
    var errorFormatText: String?,
    var errorInvalidText: String?,
    var acceptEmpty: Boolean,
) : RememberObserver {

    /** True while a segment update is being driven by the controller — avoids feedback loops. */
    private var cancelOnChanged: Boolean = false

    private val ownsController: Boolean = owningController == null
    val dateTimeController: IYaruDateTimeEntryController =
        owningController ?: YaruDateTimeEntryController(initialDateTime)

    val use24HourFormat: Boolean = force24HourFormat

    // region Segments — names and order match the Dart state class.
    val daySegment: YaruNumericSegment
    val monthSegment: YaruNumericSegment
    val yearSegment: YaruNumericSegment
    val hourSegment: YaruNumericSegment
    val minuteSegment: YaruNumericSegment
    val periodSegment: YaruEnumSegment<YaruDayPeriod>

    val segments: List<YaruEntrySegment>
    val delimiters: List<String?>
    val segmentedController: YaruSegmentedEntryController
    // endregion

    private val controllerListener: () -> Unit = ::onControllerChanged

    init {
        val initial = dateTimeController.dateTime

        // `daySegment` — mirrors the Dart `_updateSegmentsAndDelimiters`.
        daySegment = YaruNumericSegment.fixed(
            length = 2,
            initialValue = initial?.day,
            placeholderLetter = DayPlaceholder,
            onValueChange = dateTimeSegmentOnValueChange(MaxDayValue),
            onInputCallback = dateTimeSegmentOnInputPlaceholder(MaxDayValue),
        )

        monthSegment = YaruNumericSegment.fixed(
            length = 2,
            initialValue = initial?.month?.number,
            placeholderLetter = MonthPlaceholder,
            onValueChange = dateTimeSegmentOnValueChange(MaxMonthValue),
            onInputCallback = dateTimeSegmentOnInputPlaceholder(MaxMonthValue),
        )

        // Year-segment length is derived from the bounds. A negative
        // `firstDateTime.year` produces a longer string (the leading minus is
        // counted) than a positive `lastDateTime.year`, which would violate
        // `YaruNumericSegment`'s `maxLength >= minLength` invariant and crash
        // at construction. Clamp to keep `minLength <= maxLength`.
        val firstYearLen = firstDateTime.year.toString().length
        val lastYearLen = lastDateTime.year.toString().length
        yearSegment = YaruNumericSegment(
            minLength = minOf(firstYearLen, lastYearLen),
            maxLength = maxOf(firstYearLen, lastYearLen),
            initialValue = initial?.year,
            placeholderLetter = YearPlaceholder,
            onValueChange = { _, value, _ -> if (value != null && value < 0) 0 else value },
        )

        periodSegment = YaruEnumSegment(
            initialValue = if (initial != null) {
                if (initial.hour >= 12) YaruDayPeriod.PM else YaruDayPeriod.AM
            } else {
                YaruDayPeriod.AM
            },
            values = YaruDayPeriod.entries.toList(),
        )

        val maxHour = if (use24HourFormat) Max24HourValue else Max12HourValue
        hourSegment = YaruNumericSegment.fixed(
            length = 2,
            initialValue = if (initial != null) {
                if (use24HourFormat) initial.hour else initial.hour.to12HourOfPeriod()
            } else {
                null
            },
            placeholderLetter = TimePlaceholder,
            onValueChange = dateTimeSegmentOnValueChange(maxHour),
            onInputCallback = dateTimeSegmentOnInputPlaceholder(maxHour),
            onUpArrowKeyCallback = ::onHourUpArrowKey,
            onDownArrowKeyCallback = ::onHourDownArrowKey,
        )

        minuteSegment = YaruNumericSegment.fixed(
            length = 2,
            initialValue = initial?.minute,
            placeholderLetter = TimePlaceholder,
            onValueChange = dateTimeSegmentOnValueChange(MaxMinuteValue),
            onInputCallback = dateTimeSegmentOnInputPlaceholder(MaxMinuteValue),
        )

        // Build segments and delimiters mirroring Dart `_updateSegmentsAndDelimiters`.
        // Dart uses the framework's `formatCompactDate` to derive the
        // segment order; without that on KMP we ship the European DD/MM/YYYY
        // ordering which matches the Yaru/GTK desktop sample defaults.
        val s = mutableListOf<YaruEntrySegment>()
        val d = mutableListOf<String?>()
        if (type.hasDate) {
            s += daySegment
            s += monthSegment
            s += yearSegment
            d += DateDelimiter
            d += DateDelimiter
        }
        if (type.hasTime) {
            s += hourSegment
            s += minuteSegment
            if (type.hasDate) {
                d += " "
            }
            d += TimeDelimiter
            if (!use24HourFormat) {
                s += periodSegment
                d += " "
            }
        }
        segments = s
        delimiters = d

        segmentedController = YaruSegmentedEntryController(length = segments.size)

        // Listen to the external controller so external `dateTime = ...` writes
        // reflect into the segment values, and rebroadcast onChanged.
        dateTimeController.addListener(controllerListener)
    }

    // region Callbacks — translate Dart method-by-method.

    /** `_dateTimeSegmentOnValueChange(maxValue)` from yaru.dart. */
    private fun dateTimeSegmentOnValueChange(maxValue: Int): YaruNumericSegmentCallback =
        { _, value, _ ->
            when {
                value == null -> null
                dateTimeController.dateTime == null && value < 0 -> 0
                else -> {
                    val effectiveMax = if (dateTimeController.dateTime == null) {
                        maxValue
                    } else {
                        maxValue + 1
                    }
                    if (value > effectiveMax) effectiveMax else value
                }
            }
        }

    /**
     * Mirrors `_dateTimeSegmentOnInput(maxValue)` from yaru.dart. The capture
     * of `segmentedController` is safe: this callback is invoked only on user
     * input, by which time `init { ... }` has assigned the controller field.
     */
    private fun dateTimeSegmentOnInputPlaceholder(maxValue: Int): YaruNumericSegmentCallback =
        { input, value, oldValue ->
            applyOnInput(maxValue, input, value, oldValue)
        }

    private fun applyOnInput(
        maxValue: Int,
        input: String?,
        value: Int?,
        oldValue: Int?,
    ): Int? {
        if (dateTimeController.dateTime == null && value != null && value < 0) {
            return 0
        }

        if (value != null) {
            // Auto-advance hint mirrors yaru.dart line 431:
            // `if (input?.length == 1 && value > maxValue.firstNumber && value < 10)`
            // — only fires on the very first digit, so 22 stays in the segment
            // when the user already typed `2` and types another `2`.
            if (input?.length == 1 && value > maxValue.firstNumber && value < 10) {
                segmentedController.maybeSelectNextSegment()
            }

            if (value > maxValue) {
                return maxValue
            }

            if (dateTimeController.dateTime == null && value < 0) {
                return 0
            }

            if (dateTimeController.dateTime != null && value == 0) {
                return oldValue
            }
        }

        return value
    }

    /** `onHourUpArrowKey` from yaru.dart. */
    private fun onHourUpArrowKey(input: String?, value: Int?, oldValue: Int?): Int? {
        if (use24HourFormat) return value
        return when (oldValue) {
            11 -> {
                if (periodSegment.value.isPm && daySegment.value != null) {
                    daySegment.value = daySegment.value!! + 1
                }
                periodSegment.value = periodSegment.value.invert
                12
            }
            12 -> 1
            else -> value
        }
    }

    /** `onHourDownArrowKey` from yaru.dart. */
    private fun onHourDownArrowKey(input: String?, value: Int?, oldValue: Int?): Int? {
        if (use24HourFormat) return value
        return when (oldValue) {
            12 -> {
                if (periodSegment.value.isAm && daySegment.value != null) {
                    daySegment.value = daySegment.value!! - 1
                }
                periodSegment.value = periodSegment.value.invert
                11
            }
            1 -> 12
            else -> value
        }
    }

    // endregion

    // region Controller <-> segments synchronisation.

    private fun onControllerChanged() {
        cancelOnChanged = true
        val dt = dateTimeController.dateTime
        if (dt != null) {
            daySegment.value = dt.day
            monthSegment.value = dt.month.number
            yearSegment.value = dt.year
            hourSegment.value = if (use24HourFormat) dt.hour else dt.hour.to12HourOfPeriod()
            minuteSegment.value = dt.minute
            periodSegment.value = if (dt.hour >= 12) YaruDayPeriod.PM else YaruDayPeriod.AM
        }
        cancelOnChanged = false
        emitOnChanged()
    }

    private val segmentListener: () -> Unit = {
        if (!cancelOnChanged) {
            val parsed = tryParseSegments()
            // Only update the controller if it actually changed, so we don't
            // re-enter through the controller listener.
            if (dateTimeController.dateTime != parsed) {
                dateTimeController.dateTime = parsed
            } else {
                onChanged?.invoke(parsed)
            }
        }
    }

    fun attachSegmentListeners() {
        segments.forEach { it.addListener(segmentListener) }
    }

    fun detachSegmentListeners() {
        segments.forEach { it.removeListener(segmentListener) }
    }

    private fun emitOnChanged() {
        onChanged?.invoke(tryParseSegments())
    }

    fun clear() {
        cancelOnChanged = true
        daySegment.value = null
        monthSegment.value = null
        yearSegment.value = null
        hourSegment.value = null
        minuteSegment.value = null
        cancelOnChanged = false
        // Assigning `null` notifies `onControllerChanged`, which is the only
        // call site that emits `onChanged(null)` for the cleared state. We
        // intentionally do NOT call `emitOnChanged()` here ourselves to avoid
        // double-firing `onChanged(null)` for a single user clear action.
        dateTimeController.dateTime = null
    }
    // endregion

    /**
     * Mirrors `_tryParseSegments` from yaru.dart line 633-669: builds a
     * [LocalDateTime] from segment values without applying the
     * [firstDateTime] / [lastDateTime] bounds — bounds enforcement belongs to
     * `_validateDateTime`, not the parse step. We only return null when a
     * required segment is empty or when the kotlinx-datetime constructor
     * rejects the combination (e.g. month 13).
     */
    private fun tryParseSegments(): LocalDateTime? {
        val year = yearSegment.value
        val month = monthSegment.value
        val day = daySegment.value
        val hour = hourSegment.value
        val minute = minuteSegment.value

        if (type.hasDate && (year == null || month == null || day == null)) return null
        if (type.hasTime && (hour == null || minute == null)) return null

        val resolvedYear = if (type.hasDate) year!! else 0
        val resolvedMonth = if (type.hasDate) month!! else 1
        val resolvedDay = if (type.hasDate) day!! else 1
        val resolvedHour = if (type.hasTime) {
            if (use24HourFormat) hour!! else periodSegment.value.to24Hour(hour!!)
        } else {
            0
        }
        val resolvedMinute = if (type.hasTime) minute!! else 0

        return runCatching {
            LocalDateTime(resolvedYear, resolvedMonth, resolvedDay, resolvedHour, resolvedMinute)
        }.getOrNull()
    }

    /** Mirrors `_isValidAcceptableDate` from yaru.dart line 625-631. */
    private fun isValidAcceptableDate(date: LocalDateTime?): Boolean =
        date != null &&
            date >= firstDateTime &&
            date <= lastDateTime &&
            selectableDateTimePredicate?.invoke(date) != false

    /**
     * Mirrors `_validateDateTime` from yaru.dart line 671-691, minus the
     * `Form` plumbing: returns the error text to render under the field, or
     * null when the current input is acceptable. Reading the segment values
     * here makes the result observable when called from composition.
     */
    fun validateDateTime(): String? {
        val dateTime = tryParseSegments()
        return when {
            dateTime == null -> {
                val allEmpty = daySegment.value == null &&
                    monthSegment.value == null &&
                    yearSegment.value == null &&
                    hourSegment.value == null &&
                    minuteSegment.value == null
                if (allEmpty && acceptEmpty) null else errorFormatText ?: InvalidFormatLabel
            }
            !isValidAcceptableDate(dateTime) -> errorInvalidText ?: OutOfRangeLabel
            else -> null
        }
    }

    // RememberObserver lifecycle: tear down when the holder leaves composition.
    override fun onAbandoned() = dispose()
    override fun onForgotten() = dispose()
    override fun onRemembered() = Unit

    private fun dispose() {
        dateTimeController.removeListener(controllerListener)
        detachSegmentListeners()
    }
}

@Composable
private fun DateTimeEntryImpl(
    type: DateTimeEntryType,
    controller: IYaruDateTimeEntryController?,
    initialDateTime: LocalDateTime?,
    firstDateTime: LocalDateTime,
    lastDateTime: LocalDateTime,
    force24HourFormat: Boolean,
    onChanged: ((LocalDateTime?) -> Unit)?,
    selectableDateTimePredicate: SelectableDateTimePredicate?,
    errorFormatText: String?,
    errorInvalidText: String?,
    acceptEmpty: Boolean,
    modifier: Modifier,
    autofocus: Boolean,
    showClearButton: Boolean,
) {
    val holder = remember(type, controller, force24HourFormat, firstDateTime, lastDateTime) {
        DateTimeEntryHolder(
            type = type,
            owningController = controller,
            initialDateTime = initialDateTime,
            firstDateTime = firstDateTime,
            lastDateTime = lastDateTime,
            force24HourFormat = force24HourFormat,
            onChanged = onChanged,
            selectableDateTimePredicate = selectableDateTimePredicate,
            errorFormatText = errorFormatText,
            errorInvalidText = errorInvalidText,
            acceptEmpty = acceptEmpty,
        )
    }

    // Refresh the captured `onChanged` lambda on every recomposition so
    // segment/controller listeners always invoke the latest caller closure.
    holder.onChanged = onChanged
    holder.selectableDateTimePredicate = selectableDateTimePredicate
    holder.errorFormatText = errorFormatText
    holder.errorInvalidText = errorInvalidText
    holder.acceptEmpty = acceptEmpty

    DisposableEffect(holder) {
        holder.attachSegmentListeners()
        onDispose { holder.detachSegmentListeners() }
    }

    // Mirrors `_clearInputButton` from `yaru_date_time_entry.dart` line 700:
    // a default `YaruIconButton` with `YaruIcons.edit_clear` — no explicit
    // size override, so the icon uses `kYaruIconSize = 20.dp`.
    val trailing: @Composable (() -> Unit)? = if (showClearButton) {
        { YaruIconButton(
            onPressed = { holder.clear() },
            icon = { YaruIcon(glyph = YaruIcons.edit_clear) },
        ) }
    } else null

    YaruSegmentedEntry(
        segments = holder.segments,
        delimiters = holder.delimiters,
        controller = holder.segmentedController,
        modifier = modifier,
        // The Dart widget wires `_validateDateTime` as the `TextFormField`
        // validator and relies on the enclosing `Form` to trigger it; here the
        // segment values are snapshot state, so reading them makes validation
        // live.
        errorText = holder.validateDateTime(),
        autofocus = autofocus,
        trailing = trailing,
    )
}
