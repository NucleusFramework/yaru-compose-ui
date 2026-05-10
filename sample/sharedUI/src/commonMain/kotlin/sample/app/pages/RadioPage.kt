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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruRadio
import dev.nucleusframework.yarucompose.widgets.YaruRadioButton
import dev.nucleusframework.yarucompose.widgets.YaruRadioListTile
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText

@Composable
fun RadioPage() {
    var radioValue by remember { mutableStateOf<Int?>(1) }
    var buttonValue by remember { mutableStateOf<Int?>(1) }
    var listTileValue by remember { mutableStateOf<Int?>(1) }

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
            // Bare YaruRadio — interactive (toggleable) on the left, disabled on
            // the right. Mirrors the loop in `radio_page.dart`.
            items(count = 3) { index ->
                Row {
                    YaruRadio(
                        value = index,
                        groupValue = radioValue,
                        onChanged = { radioValue = it },
                        toggleable = true,
                    )
                    Spacer(Modifier.width(10.dp))
                    YaruRadio<Int>(
                        value = index,
                        groupValue = radioValue,
                        onChanged = null,
                        toggleable = true,
                    )
                }
                Spacer(Modifier.height(10.dp))
            }
            item { YaruHorizontalDivider() }
            items(count = 3) { index ->
                YaruRadioButton(
                    value = index,
                    groupValue = buttonValue,
                    onChanged = { buttonValue = it },
                    title = { YaruText("YaruRadioButton") },
                    toggleable = true,
                )
                Spacer(Modifier.height(10.dp))
            }
            item { YaruHorizontalDivider() }
            items(count = 3) { index ->
                YaruRadioListTile(
                    value = index,
                    groupValue = listTileValue,
                    onChanged = { listTileValue = it },
                    title = { YaruText("YaruRadioListTile") },
                    toggleable = true,
                )
            }
        }
    }
}
