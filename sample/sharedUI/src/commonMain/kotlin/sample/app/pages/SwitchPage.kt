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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSwitch
import dev.nucleusframework.yarucompose.widgets.YaruSwitchButton
import dev.nucleusframework.yarucompose.widgets.YaruSwitchListTile
import dev.nucleusframework.yarucompose.widgets.YaruText

@Composable
fun SwitchPage() {
    val switchValues: SnapshotStateList<Boolean> =
        remember { listOf(false, true, false).toMutableStateList() }
    val buttonValues: SnapshotStateList<Boolean> =
        remember { listOf(false, true, false).toMutableStateList() }
    val listTileValues: SnapshotStateList<Boolean> =
        remember { listOf(false, true, false).toMutableStateList() }

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
            items(count = switchValues.size) { index ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    YaruSwitch(
                        checked = switchValues[index],
                        onCheckedChange = { switchValues[index] = it },
                    )
                    Spacer(Modifier.width(10.dp))
                    YaruSwitch(checked = switchValues[index], onCheckedChange = null)
                    // `SizedBox(width: 10)` trailing the second switch (switch_page.dart:33).
                    Spacer(Modifier.width(10.dp))
                }
                Spacer(Modifier.height(10.dp))
            }
            item { YaruHorizontalDivider() }
            items(count = buttonValues.size) { index ->
                YaruSwitchButton(
                    value = buttonValues[index],
                    onChanged = { buttonValues[index] = it },
                    title = { YaruText("YaruSwitchButton") },
                )
                Spacer(Modifier.height(10.dp))
            }
            item { YaruHorizontalDivider() }
            items(count = listTileValues.size) { index ->
                YaruSwitchListTile(
                    value = listTileValues[index],
                    onChanged = { listTileValues[index] = it },
                    title = { YaruText("YaruSwitchListTile") },
                )
                // Mirrors the "Custom control" demo from yaru.dart's switch_page.dart:
                // the trailing slot stays a YaruSwitch, but `control` swaps in a row
                // of icon buttons + the switch so we can demonstrate the override.
                YaruSwitchListTile(
                    value = listTileValues[index],
                    onChanged = { listTileValues[index] = it },
                    title = { YaruText("YaruSwitchListTile") },
                    subtitle = { YaruText("Custom control") },
                    control = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            YaruIconButton(onPressed = {}) {
                                YaruIcon(YaruIcons.information)
                            }
                            YaruSwitch(
                                checked = listTileValues[index],
                                onCheckedChange = { listTileValues[index] = it },
                            )
                            YaruIconButton(onPressed = {}) {
                                YaruIcon(YaruIcons.go_next)
                            }
                        }
                    },
                )
            }
        }
    }
}
