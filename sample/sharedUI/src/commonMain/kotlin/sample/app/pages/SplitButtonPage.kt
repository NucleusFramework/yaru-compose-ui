package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruSlider
import dev.nucleusframework.yarucompose.widgets.YaruSplitButton
import dev.nucleusframework.yarucompose.widgets.YaruSplitButtonItem
import dev.nucleusframework.yarucompose.widgets.YaruSplitButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.SectionHeader
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/split_button_page.dart`. */
@Composable
fun SplitButtonPage() {
    GalleryPage(description = "A primary action paired with a dropdown of secondary ones.") {
        SectionHeader("Variants")
        ExampleCard(
            title = "Elevated, filled and outlined",
            sourceCode = GallerySources.SplitButtonVariantsExample,
        ) { SplitButtonVariantsExample() }

        SectionHeader("Degraded states")
        ExampleCard(
            title = "Missing items or action",
            description = "Dropping `items` hides the menu half; a null `onPressed` disables the button.",
            sourceCode = GallerySources.SplitButtonDegradedExample,
        ) { SplitButtonDegradedExample() }

        SectionHeader("Menu width")
        ExampleCard(
            title = "Explicit menuWidth",
            sourceCode = GallerySources.SplitButtonMenuWidthExample,
        ) { SplitButtonMenuWidthExample() }
    }
}

@Composable
private fun rememberSplitButtonItems(): List<YaruSplitButtonItem> = remember {
    (0 until 6).map { index ->
        val name = if (index % 2 == 0) "Super long action name" else "action"
        YaruSplitButtonItem(label = "$name ${index + 1}", onClick = {})
    }
}

@GalleryExample("YaruSplitButton", "Variants")
@Composable
private fun SplitButtonVariantsExample() {
    val items = rememberSplitButtonItems()
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruSplitButtonVariant.entries.forEach { variant ->
            YaruSplitButton(
                onPressed = {},
                items = items,
                variant = variant,
            ) { YaruText(variant.name) }
        }
    }
}

@GalleryExample("YaruSplitButton", "Degraded")
@Composable
private fun SplitButtonDegradedExample() {
    val items = rememberSplitButtonItems()
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // No items — the dropdown half is inert.
        YaruSplitButton(onPressed = {}) { YaruText("No items") }
        // No main action — only the menu remains usable.
        YaruSplitButton(onPressed = null, items = items) { YaruText("No action") }
        YaruSplitButton(onPressed = null) { YaruText("Neither") }
    }
}

@GalleryExample("YaruSplitButton", "Menu width")
@Composable
private fun SplitButtonMenuWidthExample() {
    val items = rememberSplitButtonItems()
    var width by remember { mutableFloatStateOf(200f) }
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        YaruText("Menu width: ${width.toInt()}")
        YaruSlider(value = width, onValueChange = { width = it }, valueRange = 100f..500f)
        YaruSplitButton(
            onPressed = {},
            items = items,
            menuWidth = width.dp,
            variant = YaruSplitButtonVariant.Outlined,
        ) { YaruText("Main Action") }
    }
}
