package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.widgets.YaruBannerTile
import dev.nucleusframework.yarucompose.widgets.YaruDialog
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruWatermark
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

private val BannerHeight = 200.dp

/** Mirrors `yaru.dart/example/lib/pages/banner_page.dart`. */
@Composable
fun BannerPage() {
    GalleryPage(description = "A large, tappable tile used to advertise an item.") {
        ExampleCard(
            title = "YaruBannerTile",
            description = "`surfaceTintColor` washes the whole tile.",
            sourceCode = GallerySources.BannerTileExample,
        ) { BannerTileExample() }
        ExampleCard(
            title = "Hover reveal",
            description = "`onHover` swaps the icon for a longer description.",
            sourceCode = GallerySources.BannerHoverExample,
        ) { BannerHoverExample() }
        ExampleCard(
            title = "Behind a YaruWatermark",
            sourceCode = GallerySources.BannerWatermarkExample,
        ) { BannerWatermarkExample() }
    }
}

@GalleryExample("YaruBanner", "Tile")
@Composable
private fun BannerTileExample() {
    Row(
        modifier = Modifier.fillMaxWidth().height(BannerHeight),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        listOf(Color(0xFFE91E63), null).forEach { tint ->
            Box(modifier = Modifier.weight(1f)) {
                YaruBannerTile(
                    modifier = Modifier.fillMaxSize(),
                    title = { YaruText("YaruBanner") },
                    subtitle = { YaruText("Description") },
                    icon = {
                        YaruIcon(
                            glyph = YaruIcons.sun,
                            size = 80.dp,
                            tint = LocalYaruColorScheme.current.primary,
                        )
                    },
                    onTap = {},
                    surfaceTintColor = tint,
                )
            }
        }
    }
}

@GalleryExample("YaruBanner", "Hover reveal")
@Composable
private fun BannerHoverExample() {
    var hovered by remember { mutableStateOf(false) }
    var dialogOpen by remember { mutableStateOf(false) }
    val scheme = LocalYaruColorScheme.current

    val description: @Composable () -> Unit = if (hovered) {
        { Box(modifier = Modifier.size(width = 200.dp, height = 100.dp)) { YaruText(SampleLorem) } }
    } else {
        { YaruText("Description", maxLines = 1, overflow = TextOverflow.Ellipsis) }
    }

    YaruBannerTile(
        modifier = Modifier.fillMaxWidth().height(BannerHeight),
        title = { YaruText("YaruBanner") },
        icon = if (hovered) null else ({ YaruIcon(YaruIcons.sun, size = 80.dp, tint = scheme.primary) }),
        subtitle = {
            Column {
                description()
                if (!hovered) YaruText("Third line")
            }
        },
        onTap = { dialogOpen = true },
        onHover = { hovered = it },
    )

    if (dialogOpen) {
        YaruDialog(
            onDismissRequest = { dialogOpen = false },
            title = { YaruText("YaruBanner") },
            contentPadding = PaddingValues(10.dp),
        ) {
            Box(modifier = Modifier.padding(8.dp)) { description() }
        }
    }
}

@GalleryExample("YaruBanner", "Watermark")
@Composable
private fun BannerWatermarkExample() {
    Box(modifier = Modifier.fillMaxWidth().height(BannerHeight)) {
        YaruWatermark(
            modifier = Modifier.fillMaxSize(),
            watermark = { YaruIcon(YaruIcons.cloud, size = 100.dp) },
        ) {
            YaruBannerTile(
                modifier = Modifier.fillMaxSize(),
                title = { YaruText("YaruBanner") },
                subtitle = { YaruText("Description") },
                onTap = {},
            )
        }
    }
}
