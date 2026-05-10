package sample.app.pages

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruCheckButton
import dev.nucleusframework.yarucompose.widgets.YaruCheckbox
import dev.nucleusframework.yarucompose.widgets.YaruCheckboxListTile
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText

/**
 * Mirrors `yaru.dart/example/lib/pages/checkbox_page.dart`. Each section cycles
 * through `[false, null, true]` and pairs an interactive checkbox with a
 * disabled one (tristate everywhere).
 */
@Composable
fun CheckboxPage() {
    val checkboxValues: SnapshotStateList<Boolean?> =
        remember { listOf<Boolean?>(false, null, true).toMutableStateList() }
    val buttonValues: SnapshotStateList<Boolean?> =
        remember { listOf<Boolean?>(false, null, true).toMutableStateList() }
    val listTileValues: SnapshotStateList<Boolean?> =
        remember { listOf<Boolean?>(false, null, true).toMutableStateList() }

    val scrollState = rememberLazyListState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
        ) {
            // Bare checkbox: interactive + disabled, both tristate.
            items(count = checkboxValues.size) { index ->
                Row {
                    YaruCheckbox(
                        value = checkboxValues[index],
                        onChanged = { checkboxValues[index] = it },
                        tristate = true,
                    )
                    Spacer(Modifier.width(10.dp))
                    YaruCheckbox(
                        value = checkboxValues[index],
                        onChanged = null,
                        tristate = true,
                    )
                }
                Spacer(Modifier.height(10.dp))
            }
            item { YaruHorizontalDivider() }

            // YaruCheckButton — desktop-style label.
            items(count = buttonValues.size) { index ->
                YaruCheckButton(
                    value = buttonValues[index],
                    onChanged = { buttonValues[index] = it },
                    title = { YaruText("YaruCheckButton") },
                    tristate = true,
                )
                Spacer(Modifier.height(10.dp))
            }
            item { YaruHorizontalDivider() }

            // YaruCheckboxListTile — tappable row with the checkbox as leading.
            items(count = listTileValues.size) { index ->
                YaruCheckboxListTile(
                    value = listTileValues[index],
                    onChanged = { listTileValues[index] = it },
                    title = { YaruText("YaruCheckboxListTile") },
                    tristate = true,
                )
            }
        }
    }
}
