package sample.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruSelectableContainer
import dev.nucleusframework.yarucompose.widgets.YaruText
import org.jetbrains.compose.resources.painterResource
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources
import yarucompose.sample.sharedui.generated.resources.Res
import yarucompose.sample.sharedui.generated.resources.ubuntuhero

/** Mirrors `yaru.dart/example/lib/pages/selectable_container_page.dart`. */
@Composable
fun SelectableContainerPage() {
    GalleryPage(description = "Wraps any child with a selection ring.") {
        ExampleCard(
            title = "Images",
            description = "Exactly one of the two stays selected.",
            sourceCode = GallerySources.SelectableContainerImageExample,
        ) { SelectableContainerImageExample() }
        ExampleCard(
            title = "Text",
            sourceCode = GallerySources.SelectableContainerTextExample,
        ) { SelectableContainerTextExample() }
        ExampleCard(
            title = "Custom shape",
            description = "`shape` follows the child — here a pill around a circle.",
            sourceCode = GallerySources.SelectableContainerShapeExample,
        ) { SelectableContainerShapeExample() }
    }
}

@GalleryExample("YaruSelectableContainer", "Images")
@Composable
private fun SelectableContainerImageExample() {
    var secondSelected by remember { mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        listOf(false, true).forEach { isSecond ->
            YaruSelectableContainer(
                selected = secondSelected == isSecond,
                onTap = { secondSelected = isSecond },
                modifier = Modifier.size(width = 240.dp, height = 180.dp),
            ) {
                Image(
                    painter = painterResource(Res.drawable.ubuntuhero),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }
        }
    }
}

@GalleryExample("YaruSelectableContainer", "Text")
@Composable
private fun SelectableContainerTextExample() {
    var selected by remember { mutableStateOf(false) }
    YaruSelectableContainer(
        selected = selected,
        onTap = { selected = !selected },
    ) {
        Box(modifier = Modifier.padding(18.dp)) {
            YaruText("This is just text but can be selected!")
        }
    }
}

@GalleryExample("YaruSelectableContainer", "Custom shape")
@Composable
private fun SelectableContainerShapeExample() {
    var selected by remember { mutableStateOf(false) }
    YaruSelectableContainer(
        selected = selected,
        onTap = { selected = !selected },
        shape = RoundedCornerShape(100.dp),
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFC107)),
            contentAlignment = Alignment.Center,
        ) {
            YaruIcon(YaruIcons.heart)
        }
    }
}
