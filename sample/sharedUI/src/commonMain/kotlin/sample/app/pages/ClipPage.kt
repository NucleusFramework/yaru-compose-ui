package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruDiagonalClip
import dev.nucleusframework.yarucompose.foundation.YaruDiagonalClipBox
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/clip_page.dart`. */
@Composable
fun ClipPage() {
    GalleryPage(description = "Clips its child to a half-square cut along one diagonal.") {
        ExampleCard(
            title = "YaruDiagonalClipBox",
            description = "Green is the clipped child; red is the uncut box behind it.",
            sourceCode = GallerySources.DiagonalClipExample,
        ) { DiagonalClipExample() }
    }
}

@GalleryExample("YaruClip", "Diagonal positions")
@Composable
private fun DiagonalClipExample() {
    Column(modifier = Modifier.fillMaxWidth()) {
        YaruDiagonalClip.entries.forEach { position ->
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
