package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruVariant
import dev.nucleusframework.yarucompose.widgets.YaruColorOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/option_button_page.dart`. */
@Composable
fun OptionButtonPage() {
    GalleryPage(description = "A square, outlined button holding a single icon or colour.") {
        ExampleCard(
            title = "YaruOptionButton",
            sourceCode = GallerySources.OptionButtonExample,
        ) { OptionButtonExample() }
        ExampleCard(
            title = "YaruColorOptionButton",
            sourceCode = GallerySources.ColorOptionButtonExample,
        ) { ColorOptionButtonExample() }
    }
}

@GalleryExample("YaruOptionButton", "Icons")
@Composable
private fun OptionButtonExample() {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        YaruOptionButton(onPressed = {}) { YaruIcon(YaruIcons.search) }
        YaruOptionButton(onPressed = {}) { YaruIcon(YaruIcons.music_note) }
        YaruOptionButton(onPressed = {}) { YaruIcon(YaruIcons.address_book) }
        YaruOptionButton(onPressed = null) { YaruIcon(YaruIcons.search) }
    }
}

@GalleryExample("YaruOptionButton", "Colours")
@Composable
private fun ColorOptionButtonExample() {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        YaruColorOptionButton(color = LocalYaruColorScheme.current.primary, onPressed = {})
        YaruVariant.Accents.take(4).forEach { variant ->
            YaruColorOptionButton(color = variant.color, onPressed = {})
        }
    }
}
