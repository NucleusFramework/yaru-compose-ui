package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruLinearProgressIndicator
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/progress_indicator_page.dart`. */
@Composable
fun ProgressIndicatorPage() {
    GalleryPage(description = "Determinate and indeterminate activity feedback.") {
        ExampleCard(
            title = "Circular",
            description = "Omitting `progress` gives the indeterminate spinner.",
            sourceCode = GallerySources.CircularProgressExample,
        ) { CircularProgressExample() }
        ExampleCard(
            title = "Linear",
            sourceCode = GallerySources.LinearProgressExample,
        ) { LinearProgressExample() }
    }
}

@GalleryExample("YaruProgressIndicator", "Circular")
@Composable
private fun CircularProgressExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruCircularProgressIndicator()
        YaruCircularProgressIndicator(progress = 0.75f)
    }
}

@GalleryExample("YaruProgressIndicator", "Linear")
@Composable
private fun LinearProgressExample() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        YaruLinearProgressIndicator()
        YaruLinearProgressIndicator(progress = 0.75f)
    }
}
