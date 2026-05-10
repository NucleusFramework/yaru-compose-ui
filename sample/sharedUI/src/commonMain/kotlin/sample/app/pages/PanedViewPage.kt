package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruPaneSide
import dev.nucleusframework.yarucompose.widgets.YaruPanedView
import dev.nucleusframework.yarucompose.widgets.YaruResizablePaneDelegate
import dev.nucleusframework.yarucompose.widgets.YaruText

@Composable
fun PanedViewPage() {
    Column(modifier = Modifier.fillMaxSize()) {
        YaruHorizontalDivider()
        Box(modifier = Modifier.weight(1f)) {
            YaruPanedView(
                layoutDelegate = YaruResizablePaneDelegate(
                    initialPaneSize = 200.dp,
                    minPaneSize = 25.dp,
                    minPageSize = 50.dp,
                    paneSide = YaruPaneSide.Start,
                ),
                pane = { Pane() },
                page = {
                    YaruPanedView(
                        layoutDelegate = YaruResizablePaneDelegate(
                            initialPaneSize = 200.dp,
                            minPaneSize = 25.dp,
                            minPageSize = 50.dp,
                            paneSide = YaruPaneSide.Top,
                        ),
                        pane = { Pane() },
                        page = {
                            YaruPanedView(
                                layoutDelegate = YaruResizablePaneDelegate(
                                    initialPaneSize = 200.dp,
                                    minPaneSize = 25.dp,
                                    minPageSize = 25.dp,
                                    paneSide = YaruPaneSide.End,
                                ),
                                pane = { Pane() },
                                page = {
                                    YaruPanedView(
                                        layoutDelegate = YaruResizablePaneDelegate(
                                            initialPaneSize = 200.dp,
                                            minPaneSize = 25.dp,
                                            minPageSize = 25.dp,
                                            paneSide = YaruPaneSide.Bottom,
                                        ),
                                        pane = { Pane() },
                                        page = {
                                            Box(
                                                modifier = Modifier.fillMaxSize(),
                                                contentAlignment = Alignment.Center,
                                            ) {
                                                YaruText("YaruPanedView Inception")
                                            }
                                        },
                                    )
                                },
                            )
                        },
                    )
                },
            )
        }
    }
}

@Composable
private fun Pane() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalYaruColorScheme.current.onSurface.copy(alpha = 0.025f)),
        contentAlignment = Alignment.Center,
    ) {
        YaruText("pane")
    }
}
