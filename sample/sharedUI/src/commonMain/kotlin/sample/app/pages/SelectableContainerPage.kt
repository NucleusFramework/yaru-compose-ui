package sample.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSelectableContainer
import dev.nucleusframework.yarucompose.widgets.YaruText
import org.jetbrains.compose.resources.painterResource
import yarucompose.sample.sharedui.generated.resources.Res
import yarucompose.sample.sharedui.generated.resources.ubuntuhero

@Composable
fun SelectableContainerPage() {
    var imageSelected by remember { mutableStateOf(false) }
    var ovalSelected by remember { mutableStateOf(false) }
    var textSelected by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(YaruConstants.PagePadding),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            // Dart `SliverGridDelegateWithMaxCrossAxisExtent(maxCrossAxisExtent: 300, childAspectRatio: 16/12, crossAxisSpacing: 10, mainAxisSpacing: 10)`. We need each cell to enforce a 16:12 aspect ratio — `LazyVerticalGrid` doesn't expose `childAspectRatio`, and without one the image's `fillMaxSize()` resolves to height = 0 (LazyVerticalGrid items get unbounded height), so the images vanished. Use a BoxWithConstraints + manual two-column Row to honor both the aspect ratio and the max-extent column rule.
            BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                val columnCount = ((maxWidth.value + 10f) / (300f + 10f)).toInt().coerceAtLeast(1)
                val cellWidthDp = (maxWidth.value - (columnCount - 1) * 10f) / columnCount
                val cellWidth = cellWidthDp.dp
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    YaruSelectableContainer(
                        selected = !imageSelected,
                        onTap = { imageSelected = !imageSelected },
                        modifier = Modifier.size(width = cellWidth, height = (cellWidthDp * 12f / 16f).dp),
                    ) {
                        UbuntuHeroImage()
                    }
                    YaruSelectableContainer(
                        selected = imageSelected,
                        onTap = { imageSelected = !imageSelected },
                        modifier = Modifier.size(width = cellWidth, height = (cellWidthDp * 12f / 16f).dp),
                    ) {
                        UbuntuHeroImage()
                    }
                }
            }
            YaruSelectableContainer(
                selected = textSelected,
                onTap = { textSelected = !textSelected },
            ) {
                // Mirrors `Padding(EdgeInsets.all(18.0))` AROUND the child in the
                // Dart sample — keeps the container's default 6dp padding + 18dp
                // inside.
                Box(modifier = Modifier.padding(18.dp)) {
                    YaruText("This is just text but can be selected!")
                }
            }
            YaruSelectableContainer(
                selected = ovalSelected,
                onTap = { ovalSelected = !ovalSelected },
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
    }
}

/** Mirrors `Image.asset('assets/ubuntuhero.jpg', fit: BoxFit.fill)` from the
 *  Dart sample. */
@Composable
private fun UbuntuHeroImage() {
    Image(
        painter = painterResource(Res.drawable.ubuntuhero),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )
}
