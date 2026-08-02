package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruInfoType
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTranslucentContainer
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/border_container_page.dart`. */
@Composable
fun BorderContainerPage() {
    GalleryPage(description = "Rounded surfaces used to group content.") {
        ExampleCard(
            title = "YaruBorderContainer",
            sourceCode = GallerySources.BorderContainerExample,
        ) { BorderContainerExample() }
        ExampleCard(
            title = "YaruTranslucentContainer",
            description = "Tinted with a semi-transparent wash, one per YaruInfoType.",
            sourceCode = GallerySources.TranslucentContainerExample,
        ) { TranslucentContainerExample() }
    }
}

@GalleryExample("YaruBorderContainer", "Basic")
@Composable
private fun BorderContainerExample() {
    YaruBorderContainer(
        modifier = Modifier.fillMaxWidth(),
        padding = PaddingValues(8.dp),
    ) {
        YaruText(SampleLorem.take(120))
    }
}

@GalleryExample("YaruBorderContainer", "Translucent")
@Composable
private fun TranslucentContainerExample() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        YaruInfoType.entries.forEach { info ->
            YaruTranslucentContainer(
                color = info.color(),
                modifier = Modifier.fillMaxWidth(),
                padding = PaddingValues(8.dp),
            ) {
                YaruText(info.name)
            }
        }
    }
}
