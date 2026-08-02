package sample.app.pages

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.themes.YaruVariant
import dev.nucleusframework.yarucompose.widgets.YaruColorDisk
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/color_disk_page.dart`. */
@Composable
fun ColorDiskPage() {
    GalleryPage(description = "A round colour swatch, typically used to pick an accent.") {
        ExampleCard(
            title = "Accent picker",
            description = "One disk per Yaru accent; the selected one gets a ring.",
            sourceCode = GallerySources.ColorDiskExample,
        ) { ColorDiskExample() }
    }
}

@GalleryExample("YaruColorDisk", "Accent picker")
@Composable
private fun ColorDiskExample() {
    var selected by remember { mutableStateOf(YaruVariant.Orange) }
    Row(
        modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruVariant.Accents.forEach { variant ->
            YaruColorDisk(
                color = variant.color,
                selected = selected == variant,
                onPressed = { selected = variant },
            )
        }
    }
}
