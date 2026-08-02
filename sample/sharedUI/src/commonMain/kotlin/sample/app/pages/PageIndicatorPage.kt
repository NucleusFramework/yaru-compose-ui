package sample.app.pages

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruPageIndicatorBuilder
import dev.nucleusframework.yarucompose.widgets.YaruPageIndicatorItem
import dev.nucleusframework.yarucompose.widgets.YaruPageIndicatorSteppedDelegate
import dev.nucleusframework.yarucompose.widgets.YaruSlider
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/page_indicator_page.dart`. */
@Composable
fun PageIndicatorPage() {
    GalleryPage(description = "A row of dots tracking the current page, fully builder-driven.") {
        ExampleCard(
            title = "Growing dot",
            description = "The selected dot animates to a larger size.",
            sourceCode = GallerySources.PageIndicatorGrowingExample,
        ) { PageIndicatorGrowingExample() }
        ExampleCard(
            title = "Progress",
            description = "Every dot up to the selected one stays filled.",
            sourceCode = GallerySources.PageIndicatorProgressExample,
        ) { PageIndicatorProgressExample() }
        ExampleCard(
            title = "Pill",
            description = "`itemSizeBuilder` stretches the selected dot into a pill.",
            sourceCode = GallerySources.PageIndicatorPillExample,
        ) { PageIndicatorPillExample() }
        ExampleCard(
            title = "Tunable",
            description = "Length, dot size and spacing wired to live controls.",
            sourceCode = GallerySources.PageIndicatorTunableExample,
        ) { PageIndicatorTunableExample() }
    }
}

@GalleryExample("YaruPageIndicator", "Growing dot")
@Composable
private fun PageIndicatorGrowingExample() {
    var page by remember { mutableIntStateOf(0) }
    val animation = tween<Dp>(durationMillis = 250)
    YaruPageIndicatorBuilder(
        length = 5,
        page = page,
        onTap = { page = it },
        itemSizeBuilder = { _, _, _ -> DpSize(20.dp, 20.dp) },
        layoutDelegate = YaruPageIndicatorSteppedDelegate(48.dp),
        itemBuilder = { index, selectedIndex, _ ->
            val size = if (index == selectedIndex) 20.dp else 12.dp
            YaruPageIndicatorItem(
                selected = index == selectedIndex,
                size = DpSize(size, size),
                animationSpec = animation,
            )
        },
    )
}

@GalleryExample("YaruPageIndicator", "Progress")
@Composable
private fun PageIndicatorProgressExample() {
    var page by remember { mutableIntStateOf(2) }
    val animation = tween<Dp>(durationMillis = 250)
    YaruPageIndicatorBuilder(
        length = 5,
        page = page,
        onTap = { page = it },
        itemSizeBuilder = { _, _, _ -> DpSize(20.dp, 20.dp) },
        layoutDelegate = YaruPageIndicatorSteppedDelegate(48.dp),
        itemBuilder = { index, selectedIndex, _ ->
            val size = if (index <= selectedIndex) 20.dp else 12.dp
            YaruPageIndicatorItem(
                selected = index <= selectedIndex,
                size = DpSize(size, size),
                animationSpec = animation,
            )
        },
    )
}

@GalleryExample("YaruPageIndicator", "Pill")
@Composable
private fun PageIndicatorPillExample() {
    var page by remember { mutableIntStateOf(0) }
    val animation = tween<Dp>(durationMillis = 250)
    YaruPageIndicatorBuilder(
        length = 5,
        page = page,
        onTap = { page = it },
        itemSizeBuilder = { index, selectedIndex, _ ->
            if (index == selectedIndex) DpSize(36.dp, 12.dp) else DpSize(12.dp, 12.dp)
        },
        layoutDelegate = YaruPageIndicatorSteppedDelegate(48.dp),
        animationSpec = animation,
        itemBuilder = { index, selectedIndex, _ ->
            YaruPageIndicatorItem(
                selected = index == selectedIndex,
                size = if (index == selectedIndex) DpSize(36.dp, 12.dp) else DpSize(12.dp, 12.dp),
                animationSpec = animation,
                borderRadius = 24.dp,
            )
        },
    )
}

@GalleryExample("YaruPageIndicator", "Tunable")
@Composable
private fun PageIndicatorTunableExample() {
    var page by remember { mutableIntStateOf(0) }
    var length by remember { mutableIntStateOf(5) }
    var dotSize by remember { mutableFloatStateOf(12f) }
    var dotSpacing by remember { mutableFloatStateOf(48f) }
    val animation = tween<Dp>(durationMillis = 250)

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        YaruPageIndicatorBuilder(
            length = length,
            page = page,
            onTap = { page = it },
            itemSizeBuilder = { _, _, _ -> DpSize((dotSize + 8).dp, (dotSize + 8).dp) },
            layoutDelegate = YaruPageIndicatorSteppedDelegate(dotSpacing.dp),
            itemBuilder = { index, selectedIndex, _ ->
                val size = if (index == selectedIndex) (dotSize + 8).dp else dotSize.dp
                YaruPageIndicatorItem(
                    selected = index == selectedIndex,
                    size = DpSize(size, size),
                    animationSpec = animation,
                )
            },
        )
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            YaruOptionButton(onPressed = { length++ }) { YaruIcon(YaruIcons.plus) }
            YaruOptionButton(
                onPressed = {
                    if (length > 1) length--
                    if (page > length - 1) page = length - 1
                },
            ) { YaruIcon(YaruIcons.minus) }
            YaruText("$length pages")
        }
        YaruSlider(value = dotSize, onValueChange = { dotSize = it }, valueRange = 6f..24f)
        YaruSlider(value = dotSpacing, onValueChange = { dotSpacing = it }, valueRange = 12f..96f)
    }
}
