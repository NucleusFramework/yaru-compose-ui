package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruChoiceChipBar
import dev.nucleusframework.yarucompose.widgets.YaruChoiceChipBarStyle
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/choice_chip_bar_page.dart`. */
@Composable
fun ChoiceChipBarPage() {
    GalleryPage(description = "A horizontal bar of selectable chips with overflow handling.") {
        ExampleCard(
            title = "Stack style",
            description = "Overflowing chips stay in place and the bar scrolls page by page.",
            sourceCode = GallerySources.ChoiceChipBarStackExample,
        ) { ChoiceChipBarStackExample() }
        ExampleCard(
            title = "Selected first, with check marks",
            sourceCode = GallerySources.ChoiceChipBarSelectedFirstExample,
        ) { ChoiceChipBarSelectedFirstExample() }
    }
}

@GalleryExample("YaruChoiceChipBar", "Stack")
@Composable
private fun ChoiceChipBarStackExample() {
    val labels = remember { (0 until 15).map { "Choice $it" } }
    val isSelected: SnapshotStateList<Boolean> =
        remember { List(labels.size) { false }.toMutableStateList() }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        YaruChoiceChipBar(
            isSelected = isSelected,
            onSelected = { index -> isSelected[index] = !isSelected[index] },
            label = { index -> YaruText(labels[index]) },
            selectedFirst = false,
            showCheckMarks = false,
            clearOnSelect = false,
            style = YaruChoiceChipBarStyle.Stack,
        )
        YaruText(
            labels.filterIndexed { index, _ -> isSelected[index] }
                .joinToString().ifEmpty { "Nothing selected" },
        )
    }
}

@GalleryExample("YaruChoiceChipBar", "Selected first")
@Composable
private fun ChoiceChipBarSelectedFirstExample() {
    val labels = remember { (0 until 10).map { "Choice $it" } }
    val isSelected: SnapshotStateList<Boolean> =
        remember { List(labels.size) { it == 0 }.toMutableStateList() }
    YaruChoiceChipBar(
        isSelected = isSelected,
        onSelected = { index -> isSelected[index] = !isSelected[index] },
        label = { index -> YaruText(labels[index]) },
        selectedFirst = true,
        showCheckMarks = true,
    )
}
