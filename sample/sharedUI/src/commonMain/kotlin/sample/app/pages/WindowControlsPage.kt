package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruSwitchButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruWindowControl
import dev.nucleusframework.yarucompose.widgets.YaruWindowControlPlatform
import dev.nucleusframework.yarucompose.widgets.YaruWindowControlType
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/window_controls_page.dart`. */
@Composable
fun WindowControlsPage() {
    GalleryPage(description = "Minimise / maximise / close buttons drawn per platform convention.") {
        ExampleCard(
            title = "Platforms",
            description = "One row per YaruWindowControlPlatform.",
            sourceCode = GallerySources.WindowControlPlatformsExample,
        ) { WindowControlPlatformsExample() }
        ExampleCard(
            title = "Disabled",
            description = "A null `onTap` renders the control inert.",
            sourceCode = GallerySources.WindowControlDisabledExample,
        ) { WindowControlDisabledExample() }
    }
}

@GalleryExample("YaruWindowControl", "Platforms")
@Composable
private fun WindowControlPlatformsExample() {
    var maximized by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        YaruWindowControlPlatform.entries.forEach { platform ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                YaruText(platform.name, modifier = Modifier.fillMaxWidth(0.2f))
                YaruWindowControl(
                    type = YaruWindowControlType.Minimize,
                    platform = platform,
                    onTap = {},
                )
                YaruWindowControl(
                    type = if (maximized) YaruWindowControlType.Restore else YaruWindowControlType.Maximize,
                    platform = platform,
                    onTap = { maximized = !maximized },
                )
                YaruWindowControl(
                    type = YaruWindowControlType.Close,
                    platform = platform,
                    onTap = {},
                )
            }
        }
        YaruSwitchButton(
            value = maximized,
            onChanged = { maximized = it },
            title = { YaruText("Maximized") },
        )
    }
}

@GalleryExample("YaruWindowControl", "Disabled")
@Composable
private fun WindowControlDisabledExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruWindowControlType.entries.forEach { type ->
            YaruWindowControl(
                type = type,
                platform = YaruWindowControlPlatform.Yaru,
                onTap = null,
            )
        }
    }
}
