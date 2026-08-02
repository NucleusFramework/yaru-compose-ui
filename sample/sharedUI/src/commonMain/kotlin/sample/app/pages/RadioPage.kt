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
import dev.nucleusframework.yarucompose.widgets.YaruRadio
import dev.nucleusframework.yarucompose.widgets.YaruRadioButton
import dev.nucleusframework.yarucompose.widgets.YaruRadioListTile
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/radio_page.dart`. */
@Composable
fun RadioPage() {
    GalleryPage(description = "A single choice within a group, addressed by `groupValue`.") {
        SectionHeader("Bare control")
        ExampleCard(
            title = "YaruRadio",
            description = "`toggleable` lets the selected radio clear itself.",
            sourceCode = GallerySources.RadioExample,
        ) { RadioExample() }
        ExampleCard(
            title = "Disabled",
            sourceCode = GallerySources.RadioDisabledExample,
        ) { RadioDisabledExample() }

        SectionHeader("Labelled")
        ExampleCard(
            title = "YaruRadioButton",
            sourceCode = GallerySources.RadioButtonExample,
        ) { RadioButtonExample() }
        ExampleCard(
            title = "YaruRadioListTile",
            sourceCode = GallerySources.RadioListTileExample,
        ) { RadioListTileExample() }
    }
}

@GalleryExample("YaruRadio", "Basic")
@Composable
private fun RadioExample() {
    var selected by remember { mutableStateOf<Int?>(1) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(3) { index ->
            YaruRadio(
                value = index,
                groupValue = selected,
                onChanged = { selected = it },
                toggleable = true,
            )
        }
    }
}

@GalleryExample("YaruRadio", "Disabled")
@Composable
private fun RadioDisabledExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(3) { index ->
            YaruRadio<Int>(value = index, groupValue = 1, onChanged = null)
        }
    }
}

@GalleryExample("YaruRadio", "Radio button")
@Composable
private fun RadioButtonExample() {
    var selected by remember { mutableStateOf<Int?>(1) }
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        repeat(3) { index ->
            YaruRadioButton(
                value = index,
                groupValue = selected,
                onChanged = { selected = it },
                title = { YaruText("Option $index") },
                toggleable = true,
            )
        }
    }
}

@GalleryExample("YaruRadio", "Radio list tile")
@Composable
private fun RadioListTileExample() {
    var selected by remember { mutableStateOf<Int?>(1) }
    Column(modifier = Modifier.fillMaxWidth()) {
        repeat(3) { index ->
            YaruRadioListTile(
                value = index,
                groupValue = selected,
                onChanged = { selected = it },
                title = { YaruText("Option $index") },
                toggleable = true,
            )
        }
    }
}
