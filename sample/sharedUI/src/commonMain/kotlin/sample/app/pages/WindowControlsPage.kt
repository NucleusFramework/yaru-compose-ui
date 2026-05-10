package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSwitchButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruWindowControl
import dev.nucleusframework.yarucompose.widgets.YaruWindowControlPlatform
import dev.nucleusframework.yarucompose.widgets.YaruWindowControlType

@Composable
fun WindowControlsPage() {
    var maximized by remember { mutableStateOf(false) }

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
            YaruWindowControlPlatform.entries.forEach { platform ->
                item {
                    YaruText(
                        "${platform.name}:",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                item { Spacer(Modifier.height(10.dp)) }
                listOf(true, false).forEach { interactive ->
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            YaruWindowControl(
                                type = YaruWindowControlType.Minimize,
                                platform = platform,
                                onTap = if (interactive) ({}) else null,
                            )
                            if (platform == YaruWindowControlPlatform.Yaru) {
                                Spacer(Modifier.width(10.dp))
                            }
                            YaruWindowControl(
                                type = if (maximized) YaruWindowControlType.Restore
                                else YaruWindowControlType.Maximize,
                                platform = platform,
                                onTap = if (interactive) ({ maximized = !maximized }) else null,
                            )
                            if (platform == YaruWindowControlPlatform.Yaru) {
                                Spacer(Modifier.width(10.dp))
                            }
                            YaruWindowControl(
                                type = YaruWindowControlType.Close,
                                platform = platform,
                                onTap = if (interactive) ({}) else null,
                            )
                        }
                    }
                    item { Spacer(Modifier.height(10.dp)) }
                }
                item { Spacer(Modifier.height(25.dp)) }
            }
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    YaruSwitchButton(
                        value = maximized,
                        onChanged = { maximized = it },
                        title = { YaruText("Maximized") },
                    )
                }
            }
        }
    }
}
