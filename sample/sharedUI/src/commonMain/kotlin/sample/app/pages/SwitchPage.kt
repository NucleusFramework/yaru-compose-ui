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
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import dev.nucleusframework.yarucompose.widgets.YaruSwitch
import dev.nucleusframework.yarucompose.widgets.YaruSwitchButton
import dev.nucleusframework.yarucompose.widgets.YaruSwitchListTile
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/**
 * Mirrors `yaru.dart/example/lib/pages/switch_page.dart`, split into
 * copy-pasteable examples.
 */
@Composable
fun SwitchPage() {
    GalleryPage(description = "A toggle between two mutually exclusive states, on and off.") {
        SectionHeader("YaruSwitch")
        ExampleCard(
            title = "States",
            description = "Interactive, off, and read-only (a null callback disables the switch).",
            sourceCode = GallerySources.SwitchStatesExample,
        ) { SwitchStatesExample() }

        SectionHeader("Labelled switches")
        ExampleCard(
            title = "YaruSwitchButton",
            sourceCode = GallerySources.SwitchButtonExample,
        ) { SwitchButtonExample() }
        ExampleCard(
            title = "YaruSwitchListTile",
            sourceCode = GallerySources.SwitchListTileExample,
        ) { SwitchListTileExample() }
        ExampleCard(
            title = "Custom control",
            description = "`control` replaces the trailing slot entirely.",
            sourceCode = GallerySources.SwitchListTileControlExample,
        ) { SwitchListTileControlExample() }
    }
}

@GalleryExample("YaruSwitch", "States")
@Composable
private fun SwitchStatesExample() {
    var checked by remember { mutableStateOf(true) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruSwitch(checked = checked, onCheckedChange = { checked = it })
        YaruSwitch(checked = false, onCheckedChange = {})
        // A null callback renders the switch read-only.
        YaruSwitch(checked = checked, onCheckedChange = null)
    }
}

@GalleryExample("YaruSwitch", "Switch button")
@Composable
private fun SwitchButtonExample() {
    var value by remember { mutableStateOf(true) }
    YaruSwitchButton(
        value = value,
        onChanged = { value = it },
        title = { YaruText("YaruSwitchButton") },
    )
}

@GalleryExample("YaruSwitch", "List tile")
@Composable
private fun SwitchListTileExample() {
    var value by remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxWidth()) {
        YaruSwitchListTile(
            value = value,
            onChanged = { value = it },
            title = { YaruText("YaruSwitchListTile") },
            subtitle = { YaruText("With a subtitle") },
        )
    }
}

@GalleryExample("YaruSwitch", "Custom control")
@Composable
private fun SwitchListTileControlExample() {
    var value by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth()) {
        YaruSwitchListTile(
            value = value,
            onChanged = { value = it },
            title = { YaruText("YaruSwitchListTile") },
            subtitle = { YaruText("Custom control") },
            control = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    YaruIconButton(onPressed = {}) { YaruIcon(YaruIcons.information) }
                    YaruSwitch(checked = value, onCheckedChange = { value = it })
                    YaruIconButton(onPressed = {}) { YaruIcon(YaruIcons.go_next) }
                }
            },
        )
    }
}
