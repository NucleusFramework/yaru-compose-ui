package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruColors
import dev.nucleusframework.yarucompose.widgets.YaruInfoBadge
import dev.nucleusframework.yarucompose.widgets.YaruInfoBox
import dev.nucleusframework.yarucompose.widgets.YaruInfoType
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/info_page.dart`. */
@Composable
fun InfoPage() {
    GalleryPage(description = "Inline status messages, as a full box or a compact badge.") {
        ExampleCard(
            title = "YaruInfoBox",
            description = "One box per YaruInfoType.",
            sourceCode = GallerySources.InfoBoxExample,
        ) { InfoBoxExample() }
        ExampleCard(
            title = "YaruInfoBadge",
            sourceCode = GallerySources.InfoBadgeExample,
        ) { InfoBadgeExample() }
        ExampleCard(
            title = "Custom colour and slots",
            description = "`color`, `icon` and `trailing` override the type defaults.",
            sourceCode = GallerySources.InfoBoxCustomExample,
        ) { InfoBoxCustomExample() }
    }
}

@GalleryExample("YaruInfo", "Info box")
@Composable
private fun InfoBoxExample() {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        YaruInfoType.entries.forEach { info ->
            YaruInfoBox(
                type = info,
                title = { YaruText(info.name) },
                subtitle = { YaruText(SampleLorem.take(80)) },
            )
        }
    }
}

@GalleryExample("YaruInfo", "Info badge")
@Composable
private fun InfoBadgeExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YaruInfoType.entries.forEach { info ->
            YaruInfoBadge(type = info, title = { YaruText(info.name) })
        }
    }
}

@GalleryExample("YaruInfo", "Custom")
@Composable
private fun InfoBoxCustomExample() {
    YaruInfoBox(
        type = YaruInfoType.Information,
        title = { YaruText("Custom icons and colors are possible") },
        subtitle = { YaruText(SampleLorem.take(80)) },
        color = YaruColors.Magenta,
        icon = { YaruIcon(YaruIcons.light_bulb_on, size = 24.dp) },
        trailing = { YaruIcon(YaruIcons.copy, tint = YaruColors.Magenta) },
    )
}
