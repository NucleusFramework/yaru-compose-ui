package sample.app.pages

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruListTileSquare
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTileList

@Composable
fun ListTilePage() {
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
                YaruListTile(titleText = "YaruListTile", onTap = {})
            }
            item {
                YaruListTile(
                    titleText = "YaruListTile",
                    subtitleText = "YaruListTile subtitle",
                    onTap = {},
                )
            }
            item {
                YaruListTile(
                    titleText = "YaruListTile",
                    subtitleText = "YaruListTile subtitle",
                    leading = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
                    onTap = {},
                )
            }
            item {
                YaruListTile(
                    titleText = "YaruListTile",
                    subtitleText = "YaruListTile subtitle",
                    trailing = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
                    onTap = {},
                )
            }
            item {
                val tiles = mutableListOf<@Composable () -> Unit>()
                for (canTap in listOf(true, false)) {
                    tiles += {
                        YaruListTileSquare(
                            title = { YaruText("YaruListTile") },
                            enabled = canTap,
                            onTap = if (canTap) ({}) else null,
                        )
                    }
                    tiles += {
                        YaruListTileSquare(
                            title = { YaruText("YaruListTile") },
                            subtitle = { YaruText("YaruListTile subtitle") },
                            enabled = canTap,
                            onTap = if (canTap) ({}) else null,
                        )
                    }
                    tiles += {
                        YaruListTileSquare(
                            title = { YaruText("YaruListTile") },
                            subtitle = { YaruText("YaruListTile subtitle") },
                            leading = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
                            enabled = canTap,
                            onTap = if (canTap) ({}) else null,
                        )
                    }
                    tiles += {
                        YaruListTileSquare(
                            title = { YaruText("YaruListTile") },
                            subtitle = { YaruText("YaruListTile subtitle") },
                            trailing = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
                            enabled = canTap,
                            onTap = if (canTap) ({}) else null,
                        )
                    }
                }
                YaruTileList(children = tiles)
            }
        }
    }
}
