package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruContextMenu
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuCheckboxItem
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuIcon
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuItem
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuLabel
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuSeparator
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuShortcut
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTextField
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/**
 * Compose-side addition — yaru.dart has no context-menu widget, GTK apps get
 * theirs from the toolkit.
 */
@Composable
fun ContextMenuPage() {
    GalleryPage(description = "A menu opened by right-clicking (or long-pressing) a target.") {
        ExampleCard(
            title = "Basic",
            description = "Right-click the area to open the menu.",
            sourceCode = GallerySources.ContextMenuBasicExample,
        ) { ContextMenuBasicExample() }
        ExampleCard(
            title = "Icons, checkboxes and shortcuts",
            description = "`leading` takes a glyph, `trailing` an accelerator hint.",
            sourceCode = GallerySources.ContextMenuRichExample,
        ) { ContextMenuRichExample() }
        ExampleCard(
            title = "Text fields",
            description = "`YaruTheme` restyles the built-in cut / copy / paste menu — no wiring needed.",
            sourceCode = GallerySources.ContextMenuTextFieldExample,
        ) { ContextMenuTextFieldExample() }
    }
}

@GalleryExample("YaruContextMenu", "Basic")
@Composable
private fun ContextMenuBasicExample() {
    var lastAction by remember { mutableStateOf("Right-click the area below") }
    YaruText(lastAction)
    YaruContextMenu(
        modifier = Modifier.fillMaxWidth(),
        trigger = {
            YaruBorderContainer(modifier = Modifier.fillMaxWidth().height(120.dp)) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    YaruText("Right-click me")
                }
            }
        },
    ) {
        YaruContextMenuItem(onSelect = { lastAction = "Opened" }) { YaruText("Open") }
        YaruContextMenuItem(onSelect = { lastAction = "Renamed" }) { YaruText("Rename") }
        YaruContextMenuSeparator()
        YaruContextMenuItem(onSelect = { lastAction = "Deleted" }) { YaruText("Move to Bin") }
        YaruContextMenuItem(onSelect = {}, enabled = false) { YaruText("Restore") }
    }
}

@GalleryExample("YaruContextMenu", "Rich")
@Composable
private fun ContextMenuRichExample() {
    var showHidden by remember { mutableStateOf(false) }
    YaruContextMenu(
        modifier = Modifier.fillMaxWidth(),
        trigger = {
            YaruBorderContainer(modifier = Modifier.fillMaxWidth().height(120.dp)) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    YaruText(if (showHidden) "Hidden files shown" else "Hidden files hidden")
                }
            }
        },
    ) {
        YaruContextMenuLabel("Edit")
        YaruContextMenuItem(
            onSelect = {},
            leading = { YaruContextMenuIcon { YaruIcon(YaruIcons.copy) } },
            trailing = { YaruContextMenuShortcut("C", control = true) },
        ) { YaruText("Copy") }
        YaruContextMenuItem(
            onSelect = {},
            leading = { YaruContextMenuIcon { YaruIcon(YaruIcons.paste) } },
            trailing = { YaruContextMenuShortcut("V", control = true) },
        ) { YaruText("Paste") }
        YaruContextMenuSeparator()
        YaruContextMenuLabel("View")
        YaruContextMenuCheckboxItem(
            checked = showHidden,
            onCheckedChange = { showHidden = it },
        ) { YaruText("Show hidden files") }
    }
}

@GalleryExample("YaruContextMenu", "Text field")
@Composable
private fun ContextMenuTextFieldExample() {
    var value by remember { mutableStateOf("Right-click inside this field") }
    YaruTextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier.fillMaxWidth(),
    )
}
