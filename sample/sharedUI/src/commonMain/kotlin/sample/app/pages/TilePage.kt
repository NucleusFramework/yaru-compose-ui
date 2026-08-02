@file:Suppress("DEPRECATION") // Showcase page intentionally demonstrates the deprecated YaruTile.

package sample.app.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTile
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/tile_page.dart`. */
@Composable
fun TilePage() {
    GalleryPage(description = "A row of leading icon, title/subtitle and trailing slot.") {
        ExampleCard(
            title = "YaruTile",
            description = "Deprecated in favour of YaruListTile — kept for reference.",
            sourceCode = GallerySources.TileExample,
        ) { TileExample() }
    }
}

@GalleryExample("YaruTile", "Basic")
@Composable
private fun TileExample() {
    Column(modifier = Modifier.fillMaxWidth()) {
        repeat(3) {
            YaruTile(
                title = { YaruText("Title") },
                subtitle = { YaruText("Subtitle") },
                leading = { YaruIcon(YaruIcons.music_note) },
                trailing = { YaruIcon(YaruIcons.information) },
            )
        }
    }
}
