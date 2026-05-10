package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nucleusframework.yarucompose.widgets.YaruChoiceChipBar
import dev.nucleusframework.yarucompose.widgets.YaruChoiceChipBarStyle
import dev.nucleusframework.yarucompose.widgets.YaruText

/**
 * Mirrors `yaru.dart/example/lib/pages/choice_chip_bar_page.dart`.
 *
 * Dart layout:
 *  - `Center` → `Padding(8.0)` → `Column` with two children:
 *      • `YaruChoiceChipBar` (selectedFirst/showCheckMarks/clearOnSelect = false,
 *        shrinkWrap = true, style = stack, 15 "Choice $i" labels).
 *      • `Expanded(ListView(padding: EdgeInsets.symmetric(h:50, v:20),
 *        children: selected labels with TextStyle(fontSize: 30)))`.
 */
@Composable
fun ChoiceChipBarPage() {
    val labels = remember { (0 until 15).map { "Choice $it" } }
    val isSelected: SnapshotStateList<Boolean> =
        remember { List(labels.size) { false }.toMutableStateList() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            YaruChoiceChipBar(
                isSelected = isSelected,
                onSelected = { index -> isSelected[index] = !isSelected[index] },
                label = { index -> YaruText(labels[index]) },
                selectedFirst = false,
                showCheckMarks = false,
                clearOnSelect = false,
                style = YaruChoiceChipBarStyle.Stack,
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 50.dp, vertical = 20.dp),
            ) {
                items(labels.indices.toList()) { index ->
                    if (isSelected[index]) {
                        // Dart: `TextStyle(fontSize: 30)` (choice_chip_bar_page.dart:50).
                        YaruText(labels[index], style = TextStyle(fontSize = 30.sp))
                    }
                }
            }
        }
    }
}
