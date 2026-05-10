package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruDateTimeEntry
import dev.nucleusframework.yarucompose.widgets.YaruDateTimeEntryController
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTimeEntry
import dev.nucleusframework.yarucompose.widgets.YaruTimeEntryController
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

// Mirrors `yaru.dart/example/lib/pages/date_time_entry_page.dart`: three
// entries (date-only, time-only, date+time) inside a 275-wide column with
// `withSpacing(25)` between each entry.
@Composable
fun DateTimeEntryPage() {
    // Mirrors `date_time_entry_page.dart`, which constructs each controller
    // with `.now()` so the entries pre-fill with the current local datetime
    // on first composition.
    val dateController = remember { YaruDateTimeEntryController.now() }
    val timeController = remember { YaruTimeEntryController.now() }
    val dateTimeController = remember { YaruDateTimeEntryController.now() }

    var dateValue by remember { mutableStateOf<LocalDateTime?>(null) }
    var timeValue by remember { mutableStateOf<LocalTime?>(null) }
    var dateTimeValue by remember { mutableStateOf<LocalDateTime?>(null) }

    DisposableEffect(dateController) {
        val l: () -> Unit = { dateValue = dateController.dateTime }
        dateController.addListener(l)
        onDispose { dateController.removeListener(l) }
    }
    DisposableEffect(timeController) {
        val l: () -> Unit = { timeValue = timeController.timeOfDay }
        timeController.addListener(l)
        onDispose { timeController.removeListener(l) }
    }
    DisposableEffect(dateTimeController) {
        val l: () -> Unit = { dateTimeValue = dateTimeController.dateTime }
        dateTimeController.addListener(l)
        onDispose { dateTimeController.removeListener(l) }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.width(275.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
        ) {
            // Date-only entry — mirrors `YaruDateTimeEntry(includeTime: false, ...)`
            // from `date_time_entry_page.dart` line 28.
            YaruDateTimeEntry(
                controller = dateController,
                includeTime = false,
                firstDateTime = LocalDateTime(1900, 1, 1, 0, 0),
                lastDateTime = LocalDateTime(2050, 1, 1, 0, 0),
            )
            YaruText(dateValue?.toString() ?: "null")

            // Time-only entry — mirrors `YaruTimeEntry(...)` from line 40 of
            // `date_time_entry_page.dart`.
            YaruTimeEntry(controller = timeController)
            YaruText(timeValue?.toString() ?: "null")

            // Date + time entry — `YaruDateTimeEntry(includeTime: true, ...)`
            // from line 49.
            YaruDateTimeEntry(
                controller = dateTimeController,
                includeTime = true,
                firstDateTime = LocalDateTime(1900, 1, 1, 0, 0),
                lastDateTime = LocalDateTime(2050, 1, 1, 0, 0),
            )
            YaruText(dateTimeValue?.toString() ?: "null")
        }
    }

    // Re-emit current values once on first composition so the labels reflect
    // any controller-provided initial state.
    LaunchedEffect(Unit) {
        dateValue = dateController.dateTime
        timeValue = timeController.timeOfDay
        dateTimeValue = dateTimeController.dateTime
    }
}
