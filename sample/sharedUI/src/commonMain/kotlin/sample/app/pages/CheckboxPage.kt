package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruCheckButton
import dev.nucleusframework.yarucompose.widgets.YaruCheckbox
import dev.nucleusframework.yarucompose.widgets.YaruCheckboxListTile
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/checkbox_page.dart`. */
@Composable
fun CheckboxPage() {
    GalleryPage(description = "A binary — or tristate — toggle for a single setting.") {
        SectionHeader("Bare control")
        ExampleCard(
            title = "YaruCheckbox",
            description = "Unchecked, mixed and checked.",
            sourceCode = GallerySources.CheckboxExample,
        ) { CheckboxExample() }
        ExampleCard(
            title = "Tristate",
            description = "`tristate` adds the mixed state to the tap cycle.",
            sourceCode = GallerySources.CheckboxTristateExample,
        ) { CheckboxTristateExample() }
        ExampleCard(
            title = "Disabled",
            sourceCode = GallerySources.CheckboxDisabledExample,
        ) { CheckboxDisabledExample() }

        SectionHeader("Labelled")
        ExampleCard(
            title = "YaruCheckButton",
            sourceCode = GallerySources.CheckButtonExample,
        ) { CheckButtonExample() }
        ExampleCard(
            title = "YaruCheckboxListTile",
            sourceCode = GallerySources.CheckboxListTileExample,
        ) { CheckboxListTileExample() }
    }
}

@GalleryExample("YaruCheckbox", "Basic")
@Composable
private fun CheckboxExample() {
    var checked by remember { mutableStateOf<Boolean?>(false) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruCheckbox(value = checked, onChanged = { checked = it })
        YaruCheckbox(value = null, onChanged = {}, tristate = true)
        YaruCheckbox(value = true, onChanged = {})
    }
}

@GalleryExample("YaruCheckbox", "Tristate")
@Composable
private fun CheckboxTristateExample() {
    var value by remember { mutableStateOf<Boolean?>(null) }
    YaruCheckbox(value = value, onChanged = { value = it }, tristate = true)
}

@GalleryExample("YaruCheckbox", "Disabled")
@Composable
private fun CheckboxDisabledExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruCheckbox(value = false, onChanged = null)
        YaruCheckbox(value = null, onChanged = null, tristate = true)
        YaruCheckbox(value = true, onChanged = null)
    }
}

@GalleryExample("YaruCheckbox", "Check button")
@Composable
private fun CheckButtonExample() {
    var value by remember { mutableStateOf<Boolean?>(false) }
    YaruCheckButton(
        value = value,
        onChanged = { value = it },
        title = { YaruText("Enable notifications") },
        tristate = true,
    )
}

@GalleryExample("YaruCheckbox", "Checkbox list tile")
@Composable
private fun CheckboxListTileExample() {
    var value by remember { mutableStateOf<Boolean?>(true) }
    Column(modifier = Modifier.fillMaxWidth()) {
        YaruCheckboxListTile(
            value = value,
            onChanged = { value = it },
            title = { YaruText("YaruCheckboxListTile") },
            subtitle = { YaruText("With a subtitle") },
            tristate = true,
        )
    }
}
