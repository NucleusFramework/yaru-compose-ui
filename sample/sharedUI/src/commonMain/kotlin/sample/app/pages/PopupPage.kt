package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruPopupMenuButton
import dev.nucleusframework.yarucompose.widgets.YaruPopupMenuEntry
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

// Lowercase to match `enum MyEnum { option1, option2, option3, option4 }` (popup_page.dart:144).
@Suppress("EnumEntryName")
private enum class MyEnum { option1, option2, option3, option4 }

/** Mirrors `yaru.dart/example/lib/pages/popup_page.dart`. */
@Composable
fun PopupPage() {
    GalleryPage(description = "A button that opens a menu of entries, optionally checkable.") {
        ExampleCard(
            title = "Single select",
            sourceCode = GallerySources.PopupSingleSelectExample,
        ) { PopupSingleSelectExample() }
        ExampleCard(
            title = "Multi select",
            description = "`closeOnTap = false` keeps the menu open while ticking entries.",
            sourceCode = GallerySources.PopupMultiSelectExample,
        ) { PopupMultiSelectExample() }
        ExampleCard(
            title = "Custom label and style",
            description = "`showArrow = false` hides the chevron; `variant` restyles the button.",
            sourceCode = GallerySources.PopupCustomExample,
        ) { PopupCustomExample() }
    }
}

@GalleryExample("YaruPopupMenuButton", "Single select")
@Composable
private fun PopupSingleSelectExample() {
    var current by remember { mutableStateOf(MyEnum.option1) }
    YaruPopupMenuButton(
        items = MyEnum.entries.map { entry ->
            YaruPopupMenuEntry(value = entry, label = { YaruText(entry.name) })
        },
        onSelected = { current = it },
        label = { YaruText(current.name) },
    )
}

@GalleryExample("YaruPopupMenuButton", "Multi select")
@Composable
private fun PopupMultiSelectExample() {
    val selection: SnapshotStateList<MyEnum> = remember {
        listOf(MyEnum.option1, MyEnum.option3).toMutableStateList()
    }
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        // Closes after each pick.
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(
                    value = entry,
                    label = { YaruText(entry.name) },
                    checked = selection.contains(entry),
                )
            },
            onSelected = { value ->
                if (selection.contains(value)) selection.remove(value) else selection.add(value)
            },
            label = { YaruText("Multi select") },
        )
        // Stays open — the entries report through `onChanged`.
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(
                    value = entry,
                    label = { YaruText(entry.name) },
                    checked = selection.contains(entry),
                    closeOnTap = false,
                    onChanged = { checked ->
                        if (checked) selection.add(entry) else selection.remove(entry)
                    },
                )
            },
            onSelected = {},
            label = { YaruText("Multi select, stays open") },
        )
    }
}

@GalleryExample("YaruPopupMenuButton", "Custom")
@Composable
private fun PopupCustomExample() {
    var current by remember { mutableStateOf(MyEnum.option1) }
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(value = entry, label = { YaruText(entry.name) })
            },
            onSelected = { current = it },
            showArrow = false,
            label = { YaruIcon(YaruIcons.view_more) },
        )
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(value = entry, label = { YaruText(entry.name) })
            },
            onSelected = { current = it },
            label = { YaruText(current.name) },
            variant = YaruButtonVariant.Filled,
        )
    }
}
