package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBackButton
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTitleBar
import dev.nucleusframework.yarucompose.widgets.master_detail.YaruDetailPage
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/**
 * Mirrors `yaru.dart/example/lib/pages/navigation_page.dart`. commonMain has no
 * built-in navigator, so the Dart push/pop chain is driven by a depth counter.
 */
@Composable
fun NavigationPage() {
    GalleryPage(description = "A detail page with a back button in its own title bar.") {
        ExampleCard(
            title = "YaruDetailPage + YaruBackButton",
            description = "Push through three levels and walk back out.",
            sourceCode = GallerySources.NavigationExample,
        ) { NavigationExample() }
    }
}

@GalleryExample("YaruNavigationPage", "Back stack")
@Composable
private fun NavigationExample() {
    var depth by remember { mutableIntStateOf(0) }
    Box(modifier = Modifier.fillMaxWidth().height(240.dp)) {
        if (depth == 0) {
            NavigationBody { YaruOutlinedButton(onClick = { depth = 1 }) { YaruText("next page") } }
        } else {
            YaruDetailPage(
                appBar = {
                    YaruTitleBar(
                        leading = { YaruBackButton(onPressed = { depth-- }) },
                        title = { YaruText("Page ${depth + 1}") },
                    )
                },
            ) {
                NavigationBody {
                    if (depth < 2) {
                        YaruOutlinedButton(onClick = { depth++ }) { YaruText("next page") }
                    } else {
                        YaruText("this is the last page")
                    }
                }
            }
        }
    }
}

@Composable
private fun NavigationBody(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize().padding(YaruConstants.PagePadding),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}
