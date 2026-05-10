package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruPopupMenuButton
import dev.nucleusframework.yarucompose.widgets.YaruPopupMenuEntry
import dev.nucleusframework.yarucompose.widgets.YaruText

// Lowercase to match `enum MyEnum { option1, option2, option3, option4 }` (popup_page.dart:144).
@Suppress("EnumEntryName")
private enum class MyEnum { option1, option2, option3, option4 }

/**
 * Mirrors `yaru.dart/example/lib/pages/popup_page.dart`. Demonstrates:
 *  - single-select with `initialValue`
 *  - multi-select that closes after each pick
 *  - multi-select that stays open (`closeOnTap = false`)
 *  - "with custom icon" — `showArrow = false`, label is an icon
 *  - "with custom style" — outlined variant overridden to `Filled`
 */
@Composable
fun PopupPage() {
    var current by remember { mutableStateOf(MyEnum.option1) }
    // Dart shares a single `enumSet` across all three checked-popup variants
    // (popup_page.dart:13). Toggling in one affects the others.
    val enumSet: SnapshotStateList<MyEnum> = remember {
        listOf(MyEnum.option1, MyEnum.option3).toMutableStateList()
    }

    FlowRow(
        modifier = Modifier.fillMaxSize().padding(YaruConstants.PagePadding),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Single-select with initial value (default outlined chip).
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(value = entry, label = { YaruText(entry.name) })
            },
            onSelected = { current = it },
            label = { YaruText(current.name) },
        )

        // Multi-select — closes after each pick (matches YaruCheckedPopupMenuItem).
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(
                    value = entry,
                    label = { YaruText(entry.name) },
                    checked = enumSet.contains(entry),
                )
            },
            onSelected = { value ->
                if (enumSet.contains(value)) enumSet.remove(value) else enumSet.add(value)
            },
            label = { YaruText("Multi Select") },
        )

        // Multi-select that stays open (matches YaruMultiSelectPopupMenuItem).
        YaruPopupMenuButton(
            items = MyEnum.entries.map { entry ->
                YaruPopupMenuEntry(
                    value = entry,
                    label = { YaruText(entry.name) },
                    checked = enumSet.contains(entry),
                    closeOnTap = false,
                    onChanged = { checked ->
                        if (checked) enumSet.add(entry) else enumSet.remove(entry)
                    },
                )
            },
            onSelected = { /* tap is reported via onChanged for this style */ },
            label = { YaruText("Multi Select Without close") },
        )

        // "With custom icon" — chevron hidden, label replaced with an icon.
        YaruBorderContainer(padding = PaddingValues(8.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                YaruText("With custom icon")
                YaruPopupMenuButton(
                    items = MyEnum.entries.map { entry ->
                        YaruPopupMenuEntry(
                            value = entry,
                            label = { YaruText(entry.name) },
                            checked = enumSet.contains(entry),
                        )
                    },
                    onSelected = { value ->
                        if (enumSet.contains(value)) enumSet.remove(value) else enumSet.add(value)
                    },
                    showArrow = false,
                    label = { YaruIcon(YaruIcons.view_more) },
                )
            }
        }

        // "With custom style" — variant override (the closest foundation
        // equivalent to passing a `ButtonStyle` in Dart).
        YaruBorderContainer(padding = PaddingValues(8.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                YaruText("With custom style")
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

    }
}
