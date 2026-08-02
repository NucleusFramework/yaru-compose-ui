package sample.app.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruListTileSquare
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTileList
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/list_tile_page.dart`. */
@Composable
fun ListTilePage() {
    GalleryPage(description = "A tappable row with optional subtitle, leading and trailing slots.") {
        SectionHeader("YaruListTile")
        ExampleCard(
            title = "Slots",
            sourceCode = GallerySources.ListTileSlotsExample,
        ) { ListTileSlotsExample() }

        SectionHeader("YaruTileList")
        ExampleCard(
            title = "Grouped square tiles",
            description = "`YaruTileList` rounds the outer corners and divides the rows.",
            sourceCode = GallerySources.TileListExample,
        ) { TileListExample() }
        ExampleCard(
            title = "Disabled rows",
            sourceCode = GallerySources.TileListDisabledExample,
        ) { TileListDisabledExample() }
    }
}

@GalleryExample("YaruListTile", "Slots")
@Composable
private fun ListTileSlotsExample() {
    Column(modifier = Modifier.fillMaxWidth()) {
        YaruListTile(titleText = "Title only", onTap = {})
        YaruListTile(titleText = "Title", subtitleText = "With a subtitle", onTap = {})
        YaruListTile(
            titleText = "Title",
            subtitleText = "With a leading icon",
            leading = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
            onTap = {},
        )
        YaruListTile(
            titleText = "Title",
            subtitleText = "With a trailing icon",
            trailing = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
            onTap = {},
        )
    }
}

@GalleryExample("YaruListTile", "Tile list")
@Composable
private fun TileListExample() {
    YaruTileList(
        children = listOf(
            { YaruListTileSquare(title = { YaruText("Title only") }, onTap = {}) },
            {
                YaruListTileSquare(
                    title = { YaruText("Title") },
                    subtitle = { YaruText("With a subtitle") },
                    onTap = {},
                )
            },
            {
                YaruListTileSquare(
                    title = { YaruText("Title") },
                    leading = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
                    onTap = {},
                )
            },
            {
                YaruListTileSquare(
                    title = { YaruText("Title") },
                    trailing = { YaruIcon(YaruIcons.ubuntu_logo_simple) },
                    onTap = {},
                )
            },
        ),
    )
}

@GalleryExample("YaruListTile", "Disabled")
@Composable
private fun TileListDisabledExample() {
    YaruTileList(
        children = listOf(
            { YaruListTileSquare(title = { YaruText("Title only") }, enabled = false, onTap = null) },
            {
                YaruListTileSquare(
                    title = { YaruText("Title") },
                    subtitle = { YaruText("With a subtitle") },
                    enabled = false,
                    onTap = null,
                )
            },
        ),
    )
}
