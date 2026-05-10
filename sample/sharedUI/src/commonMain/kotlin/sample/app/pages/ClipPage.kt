package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import dev.nucleusframework.yarucompose.widgets.YaruText
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruDiagonalClip
import dev.nucleusframework.yarucompose.foundation.YaruDiagonalClipBox
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot

@Composable
fun ClipPage() {
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
            items(YaruDiagonalClip.entries.toList()) { position ->
                YaruListTile(
                    leading = {
                        Box(modifier = Modifier.size(40.dp).background(Color.Red)) {
                            YaruDiagonalClipBox(position = position) {
                                Box(modifier = Modifier.fillMaxSize().background(Color.Green))
                            }
                        }
                    },
                    title = { YaruText(position.toString()) },
                )
            }
        }
    }
}
