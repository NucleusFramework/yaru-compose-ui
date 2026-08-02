package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruSection
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/section_page.dart`. */
@Composable
fun SectionPage() {
    GalleryPage(description = "A bordered group of rows, optionally under a headline.") {
        ExampleCard(
            title = "With a headline",
            description = "The headline slot takes arbitrary content, not just a label.",
            sourceCode = GallerySources.SectionHeadlineExample,
        ) { SectionHeadlineExample() }
        ExampleCard(
            title = "Without a headline",
            sourceCode = GallerySources.SectionPlainExample,
        ) { SectionPlainExample() }
    }
}

@GalleryExample("YaruSection", "Headline")
@Composable
private fun SectionHeadlineExample() {
    YaruSection(
        modifier = Modifier.fillMaxWidth(),
        headline = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                YaruText("Headline")
                YaruCircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 3.dp,
                )
            }
        },
    ) {
        YaruListTile(
            title = { YaruText("Title") },
            subtitle = { YaruText("Subtitle") },
            leading = { YaruIcon(YaruIcons.music_note) },
            trailing = { YaruIcon(YaruIcons.information) },
        )
    }
}

@GalleryExample("YaruSection", "Plain")
@Composable
private fun SectionPlainExample() {
    YaruSection(modifier = Modifier.fillMaxWidth()) {
        Column {
            repeat(4) {
                YaruListTile(
                    title = { YaruText("Title") },
                    subtitle = { YaruText("Subtitle") },
                    leading = { YaruIcon(YaruIcons.music_note) },
                    trailing = { YaruIcon(YaruIcons.information) },
                )
            }
        }
    }
}
