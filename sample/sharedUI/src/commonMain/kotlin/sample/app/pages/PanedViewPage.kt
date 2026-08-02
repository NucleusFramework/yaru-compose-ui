package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.widgets.YaruPaneSide
import dev.nucleusframework.yarucompose.widgets.YaruPanedView
import dev.nucleusframework.yarucompose.widgets.YaruResizablePaneDelegate
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/paned_view_page.dart`. */
@Composable
fun PanedViewPage() {
    GalleryPage(description = "A resizable pane docked to one side of a page.") {
        ExampleCard(
            title = "One pane",
            description = "Drag the divider to resize; `paneSide` picks the edge.",
            sourceCode = GallerySources.PanedViewExample,
        ) { PanedViewExample() }
        ExampleCard(
            title = "Nested panes",
            description = "Four YaruPanedViews, one per side.",
            sourceCode = GallerySources.PanedViewNestedExample,
        ) { PanedViewNestedExample() }
    }
}

@GalleryExample("YaruPanedView", "Single")
@Composable
private fun PanedViewExample() {
    Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
        YaruPanedView(
            layoutDelegate = YaruResizablePaneDelegate(
                initialPaneSize = 200.dp,
                minPaneSize = 25.dp,
                minPageSize = 50.dp,
                paneSide = YaruPaneSide.Start,
            ),
            pane = { PanedViewPane("pane") },
            page = { PanedViewPane("page") },
        )
    }
}

@GalleryExample("YaruPanedView", "Nested")
@Composable
private fun PanedViewNestedExample() {
    Box(modifier = Modifier.fillMaxWidth().height(320.dp)) {
        YaruPanedView(
            layoutDelegate = YaruResizablePaneDelegate(
                initialPaneSize = 100.dp,
                minPaneSize = 25.dp,
                minPageSize = 50.dp,
                paneSide = YaruPaneSide.Start,
            ),
            pane = { PanedViewPane("start") },
            page = {
                YaruPanedView(
                    layoutDelegate = YaruResizablePaneDelegate(
                        initialPaneSize = 80.dp,
                        minPaneSize = 25.dp,
                        minPageSize = 50.dp,
                        paneSide = YaruPaneSide.Top,
                    ),
                    pane = { PanedViewPane("top") },
                    page = {
                        YaruPanedView(
                            layoutDelegate = YaruResizablePaneDelegate(
                                initialPaneSize = 100.dp,
                                minPaneSize = 25.dp,
                                minPageSize = 25.dp,
                                paneSide = YaruPaneSide.End,
                            ),
                            pane = { PanedViewPane("end") },
                            page = { PanedViewPane("YaruPanedView Inception") },
                        )
                    },
                )
            },
        )
    }
}

@Composable
private fun PanedViewPane(label: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalYaruColorScheme.current.onSurface.copy(alpha = 0.025f)),
        contentAlignment = Alignment.Center,
    ) {
        YaruText(label)
    }
}
