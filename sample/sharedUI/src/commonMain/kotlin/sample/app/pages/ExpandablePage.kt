package sample.app.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import dev.nucleusframework.yarucompose.widgets.YaruExpandable
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

// Mirrors `_lorem` from `yaru.dart/example/lib/pages/expandable_page.dart`:
// three concatenated copies so the collapsed state has enough text to show the
// maxLines ellipsis and the size animation.
private val ExpandablePageLorem: String =
    (SampleLorem + " " + SampleLorem + " " + SampleLorem)

/** Mirrors `yaru.dart/example/lib/pages/expandable_page.dart`. */
@Composable
fun ExpandablePage() {
    GalleryPage(description = "A header that reveals its child, with an animated chevron.") {
        ExampleCard(
            title = "Collapsed by default",
            sourceCode = GallerySources.ExpandableExample,
        ) { ExpandableExample() }
        ExampleCard(
            title = "With a collapsed preview",
            description = "`collapsedContent` replaces the child while folded.",
            sourceCode = GallerySources.ExpandablePreviewExample,
        ) { ExpandablePreviewExample() }
    }
}

@GalleryExample("YaruExpandable", "Basic")
@Composable
private fun ExpandableExample() {
    YaruExpandable(
        usePadding = true,
        header = { YaruText("Lorem ipsum dolor sit amet", fontWeight = FontWeight.Bold) },
    ) {
        YaruText(ExpandablePageLorem)
    }
}

@GalleryExample("YaruExpandable", "Collapsed preview")
@Composable
private fun ExpandablePreviewExample() {
    YaruExpandable(
        isExpanded = true,
        usePadding = true,
        header = { YaruText("Lorem ipsum dolor sit amet", fontWeight = FontWeight.Bold) },
        collapsedContent = {
            YaruText(ExpandablePageLorem, maxLines = 5, overflow = TextOverflow.Ellipsis)
        },
    ) {
        YaruText(ExpandablePageLorem)
    }
}
