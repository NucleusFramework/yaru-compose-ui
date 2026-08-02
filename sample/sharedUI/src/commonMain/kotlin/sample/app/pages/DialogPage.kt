package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.widgets.YaruBannerTile
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruDialog
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruSwitchButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/dialog_page.dart`. */
@Composable
fun DialogPage() {
    GalleryPage(description = "A modal surface topped by a YaruDialogTitleBar.") {
        ExampleCard(
            title = "YaruDialog",
            description = "Toggle `isClosable` to swap the close button for an explicit action.",
            sourceCode = GallerySources.DialogExample,
        ) { DialogExample() }
    }
}

@GalleryExample("YaruDialogTitleBar", "Closable")
@Composable
private fun DialogExample() {
    var isClosable by remember { mutableStateOf(true) }
    var open by remember { mutableStateOf(false) }
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        YaruSwitchButton(
            value = isClosable,
            onChanged = { isClosable = it },
            title = { YaruText("isClosable") },
        )
        YaruOutlinedButton(onClick = { open = true }) { YaruText("Open dialog") }
    }

    if (open) {
        YaruDialog(
            onDismissRequest = { if (isClosable) open = false },
            isClosable = isClosable,
            onClose = { open = false },
            titleLeading = {
                Box(modifier = Modifier.size(25.dp), contentAlignment = Alignment.Center) {
                    YaruCircularProgressIndicator(strokeWidth = 3.dp)
                }
            },
            title = { YaruText("The Title") },
            actions = if (isClosable) {
                null
            } else {
                {
                    YaruOutlinedButton(onClick = { open = false }) {
                        YaruText("Evil Force-Close", color = scheme.error)
                    }
                }
            },
        ) {
            YaruBannerTile(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                title = { YaruText(if (isClosable) "You can close me" else "You cannot close me") },
                subtitle = { YaruText(if (isClosable) "Please" else "No way") },
                icon = { YaruText(if (isClosable) "🪟" else "💅", style = typography.headlineSmall) },
                surfaceTintColor = Color(0xFFE91E63),
            )
        }
    }
}
