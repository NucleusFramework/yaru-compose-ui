package sample.app.pages

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruAutocomplete
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/**
 * Mirrors `yaru.dart/example/lib/pages/autocomplete_page.dart`. The Dart
 * `onSelected` shows a snackbar via `ScaffoldMessenger`, which has no
 * commonMain equivalent, so the callback is a no-op here.
 */
@Composable
fun AutocompletePage() {
    GalleryPage(description = "A text field that suggests matching options as you type.") {
        ExampleCard(
            title = "YaruAutocomplete",
            description = "Type “b” to filter the option list down to bar and baz.",
            sourceCode = GallerySources.AutocompleteExample,
        ) { AutocompleteExample() }
    }
}

@GalleryExample("YaruAutocomplete", "Basic")
@Composable
private fun AutocompleteExample() {
    val options = remember { listOf("foo", "bar", "baz", "qux", "quux") }
    YaruAutocomplete(
        modifier = Modifier.width(200.dp),
        optionsBuilder = { query -> options.filter { it.contains(query.lowercase()) } },
        onSelected = {},
    )
}
