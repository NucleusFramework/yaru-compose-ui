package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/icon_button_page.dart`. */
@Composable
fun IconButtonPage() {
    GalleryPage(description = "A borderless button with a circular state layer around an icon.") {
        SectionHeader("YaruIconButton")
        ExampleCard(
            title = "Plain",
            sourceCode = GallerySources.IconButtonPlainExample,
        ) { IconButtonPlainExample() }
        ExampleCard(
            title = "Selectable",
            description = "`isSelected` paints the state layer permanently.",
            sourceCode = GallerySources.IconButtonSelectableExample,
        ) { IconButtonSelectableExample() }
        ExampleCard(
            title = "Disabled",
            description = "A null `onPressed` disables the button.",
            sourceCode = GallerySources.IconButtonDisabledExample,
        ) { IconButtonDisabledExample() }
    }
}

@GalleryExample("YaruIconButton", "Plain")
@Composable
private fun IconButtonPlainExample() {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        YaruIconButton(onPressed = {}) { YaruIcon(YaruIcons.ubuntu_logo) }
        YaruIconButton(onPressed = {}) { YaruIcon(YaruIcons.star) }
        YaruIconButton(onPressed = {}) { YaruIcon(YaruIcons.trash) }
    }
}

@GalleryExample("YaruIconButton", "Selectable")
@Composable
private fun IconButtonSelectableExample() {
    var selected by remember { mutableStateOf(false) }
    YaruIconButton(
        onPressed = { selected = !selected },
        isSelected = selected,
        tooltip = "View",
    ) {
        YaruIcon(if (selected) YaruIcons.eye_filled else YaruIcons.eye)
    }
}

@GalleryExample("YaruIconButton", "Disabled")
@Composable
private fun IconButtonDisabledExample() {
    YaruIconButton(onPressed = null) { YaruIcon(YaruIcons.eye) }
}
