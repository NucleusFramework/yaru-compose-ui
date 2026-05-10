package sample.app.pages

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot

@Composable
fun IconButtonPage() {
    var selected by remember { mutableStateOf(false) }
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
            item {
                Row {
                    YaruIconButton(onPressed = { /* Action */ }) {
                        YaruIcon(YaruIcons.ubuntu_logo)
                    }
                    Spacer(Modifier.width(10.dp))
                    YaruIconButton(
                        onPressed = { selected = !selected },
                        isSelected = selected,
                        tooltip = "View",
                    ) {
                        YaruIcon(YaruIcons.eye)
                    }
                }
            }
        }
    }
}
