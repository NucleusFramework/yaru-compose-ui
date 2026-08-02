package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruDateTimeEntry
import dev.nucleusframework.yarucompose.widgets.YaruDateTimeEntryController
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTimeEntry
import dev.nucleusframework.yarucompose.widgets.YaruTimeEntryController
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

private val EntryWidth = 275.dp

/** Mirrors `yaru.dart/example/lib/pages/date_time_entry_page.dart`. */
@Composable
fun DateTimeEntryPage() {
    GalleryPage(description = "Segmented fields for typing a date, a time, or both.") {
        ExampleCard(
            title = "Date only",
            description = "`includeTime = false` drops the hour/minute segments.",
            sourceCode = GallerySources.DateEntryExample,
        ) { DateEntryExample() }
        ExampleCard(
            title = "Time only",
            sourceCode = GallerySources.TimeEntryExample,
        ) { TimeEntryExample() }
        ExampleCard(
            title = "Date and time",
            sourceCode = GallerySources.DateTimeEntryExample,
        ) { DateTimeEntryExample() }
    }
}

@GalleryExample("YaruDateTimeEntry", "Date")
@Composable
private fun DateEntryExample() {
    val controller = remember { YaruDateTimeEntryController.now() }
    var value by remember { mutableStateOf<LocalDateTime?>(controller.dateTime) }
    DisposableEffect(controller) {
        val listener: () -> Unit = { value = controller.dateTime }
        controller.addListener(listener)
        onDispose { controller.removeListener(listener) }
    }
    Column(modifier = Modifier.width(EntryWidth), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        YaruDateTimeEntry(
            controller = controller,
            includeTime = false,
            firstDateTime = LocalDateTime(1900, 1, 1, 0, 0),
            lastDateTime = LocalDateTime(2050, 1, 1, 0, 0),
        )
        YaruText(value?.toString() ?: "null")
    }
}

@GalleryExample("YaruDateTimeEntry", "Time")
@Composable
private fun TimeEntryExample() {
    val controller = remember { YaruTimeEntryController.now() }
    var value by remember { mutableStateOf<LocalTime?>(controller.timeOfDay) }
    DisposableEffect(controller) {
        val listener: () -> Unit = { value = controller.timeOfDay }
        controller.addListener(listener)
        onDispose { controller.removeListener(listener) }
    }
    Column(modifier = Modifier.width(EntryWidth), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        YaruTimeEntry(controller = controller)
        YaruText(value?.toString() ?: "null")
    }
}

@GalleryExample("YaruDateTimeEntry", "Date and time")
@Composable
private fun DateTimeEntryExample() {
    val controller = remember { YaruDateTimeEntryController.now() }
    var value by remember { mutableStateOf<LocalDateTime?>(controller.dateTime) }
    DisposableEffect(controller) {
        val listener: () -> Unit = { value = controller.dateTime }
        controller.addListener(listener)
        onDispose { controller.removeListener(listener) }
    }
    Column(modifier = Modifier.width(EntryWidth), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        YaruDateTimeEntry(
            controller = controller,
            includeTime = true,
            firstDateTime = LocalDateTime(1900, 1, 1, 0, 0),
            lastDateTime = LocalDateTime(2050, 1, 1, 0, 0),
        )
        YaruText(value?.toString() ?: "null")
    }
}
