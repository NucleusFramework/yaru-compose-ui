package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruDialogSurface
import dev.nucleusframework.yarucompose.widgets.YaruDialogTitleBar
import dev.nucleusframework.yarucompose.widgets.YaruSearchButton
import dev.nucleusframework.yarucompose.widgets.YaruSearchField
import dev.nucleusframework.yarucompose.widgets.YaruSearchTitleField
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/search_field_page.dart`. */
@Composable
fun SearchFieldPage() {
    GalleryPage(description = "A rounded search entry, standalone or folded into a title bar.") {
        SectionHeader("Standalone")
        ExampleCard(
            title = "YaruSearchField",
            sourceCode = GallerySources.SearchFieldExample,
        ) { SearchFieldExample() }

        SectionHeader("In a title bar")
        ExampleCard(
            title = "YaruSearchTitleField",
            description = "The search button and the field share the centre slot.",
            sourceCode = GallerySources.SearchTitleFieldExample,
        ) { SearchTitleFieldExample() }
        ExampleCard(
            title = "YaruSearchButton",
            description = "A leading toggle that swaps the title for a field.",
            sourceCode = GallerySources.SearchButtonExample,
        ) { SearchButtonExample() }
    }
}

@GalleryExample("YaruSearchField", "Standalone")
@Composable
private fun SearchFieldExample() {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        YaruSearchField(
            value = text,
            onValueChange = { text = it },
            onClear = { text = "" },
        )
        YaruText(text.ifEmpty { "Type something…" })
    }
}

@GalleryExample("YaruSearchField", "Title field")
@Composable
private fun SearchTitleFieldExample() {
    var searchActive by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("The text you submitted") }
    YaruDialogSurface(maxWidth = null) {
        YaruDialogTitleBar(
            centerTitle = true,
            titleSpacing = 0.dp,
            isClosable = true,
            onClose = {},
            title = {
                YaruSearchTitleField(
                    searchActive = searchActive,
                    onSearchActive = { searchActive = !searchActive },
                    text = text,
                    onValueChange = { text = it },
                    onSubmitted = { text = it },
                    onClear = { text = "" },
                    title = { YaruText("Any Widget Here") },
                )
            },
        )
        Box(
            modifier = Modifier.fillMaxWidth().height(120.dp),
            contentAlignment = Alignment.Center,
        ) {
            YaruText(text)
        }
    }
}

@GalleryExample("YaruSearchField", "Search button")
@Composable
private fun SearchButtonExample() {
    var searchActive by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("Or the things you changed") }
    YaruDialogSurface(maxWidth = null) {
        YaruDialogTitleBar(
            centerTitle = true,
            titleSpacing = 0.dp,
            isClosable = true,
            onClose = {},
            leading = {
                YaruSearchButton(
                    onPressed = { searchActive = !searchActive },
                    isSelected = searchActive,
                )
            },
            title = {
                if (searchActive) {
                    YaruSearchField(
                        value = text,
                        onValueChange = { text = it },
                        onClear = { text = "" },
                    )
                } else {
                    YaruText("Title")
                }
            },
        )
        Box(
            modifier = Modifier.fillMaxWidth().height(120.dp),
            contentAlignment = Alignment.Center,
        ) {
            YaruText(text)
        }
    }
}
