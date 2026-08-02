package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.widgets.YaruExpansionPanel
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/expansion_panel_page.dart`. */
@Composable
fun ExpansionPanelPage() {
    GalleryPage(description = "A vertical list of headers, each revealing its own child.") {
        ExampleCard(
            title = "YaruExpansionPanel",
            description = "Even-numbered panels start expanded.",
            sourceCode = GallerySources.ExpansionPanelExample,
        ) { ExpansionPanelExample() }
    }
}

@GalleryExample("YaruExpansionPanel", "Basic")
@Composable
private fun ExpansionPanelExample() {
    val typography = LocalYaruTypography.current
    val headers = remember<List<@Composable () -> Unit>>(typography) {
        (0 until 5).map { i -> { YaruText("Header $i", style = typography.bodyLarge) } }
    }
    val contents = remember<List<@Composable () -> Unit>> {
        (0 until 5).map { i -> { Box(Modifier.padding(40.dp)) { YaruText("Child $i") } } }
    }
    YaruExpansionPanel(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        headers = headers,
        contents = contents,
        isInitiallyExpanded = List(5) { it % 2 == 0 },
        expandIconBuilder = { YaruIcon(YaruIcons.pan_end) },
    )
}
