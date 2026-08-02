package sample.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.widgets.YaruCarousel
import dev.nucleusframework.yarucompose.widgets.YaruCarouselOptions
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import org.jetbrains.compose.resources.painterResource
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources
import yarucompose.sample.sharedui.generated.resources.Res
import yarucompose.sample.sharedui.generated.resources.ubuntuhero

/** Mirrors `yaru.dart/example/lib/pages/carousel_page.dart`. */
@Composable
fun CarouselPage() {
    GalleryPage(description = "A paged view of slides with optional navigation arrows.") {
        ExampleCard(
            title = "Manual navigation",
            description = "`navigationControls` adds the previous / next arrows.",
            sourceCode = GallerySources.CarouselExample,
        ) { CarouselExample() }
        ExampleCard(
            title = "Auto scroll",
            sourceCode = GallerySources.CarouselAutoScrollExample,
        ) { CarouselAutoScrollExample() }
    }
}

@GalleryExample("YaruCarousel", "Manual")
@Composable
private fun CarouselExample() {
    var pageCount by remember { mutableIntStateOf(3) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        YaruCarousel(
            pageCount = pageCount,
            height = 300.dp,
            navigationControls = true,
        ) { CarouselSlide() }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            YaruOptionButton(onPressed = { pageCount++ }) { YaruIcon(YaruIcons.plus) }
            YaruOptionButton(onPressed = { if (pageCount >= 2) pageCount-- }) { YaruIcon(YaruIcons.minus) }
            YaruText("$pageCount pages")
        }
    }
}

@GalleryExample("YaruCarousel", "Auto scroll")
@Composable
private fun CarouselAutoScrollExample() {
    YaruCarousel(
        pageCount = 3,
        height = 300.dp,
        options = YaruCarouselOptions(autoScroll = true),
    ) { CarouselSlide() }
}

@Composable
private fun CarouselSlide() {
    val shape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape)
            .border(1.dp, LocalYaruColorScheme.current.onSurface.copy(alpha = 0.1f), shape),
    ) {
        Image(
            painter = painterResource(Res.drawable.ubuntuhero),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
        )
    }
}
