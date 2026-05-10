package sample.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruCarousel
import dev.nucleusframework.yarucompose.widgets.YaruCarouselOptions
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSection
import dev.nucleusframework.yarucompose.widgets.YaruText
import org.jetbrains.compose.resources.painterResource
import yarucompose.sample.sharedui.generated.resources.Res
import yarucompose.sample.sharedui.generated.resources.ubuntuhero

@Composable
fun CarouselPage() {
    var length by remember { mutableIntStateOf(3) }

    val scrollState = rememberLazyListState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
        ) {
            item {
                YaruSection(
                    modifier = Modifier.width(700.dp),
                    headline = { YaruText("Auto scroll: off") },
                ) {
                    YaruCarousel(
                        pageCount = length,
                        height = 400.dp,
                        navigationControls = true,
                    ) { CarouselSlide() }
                }
            }
            item { Spacer(Modifier.height(20.dp)) }
            item {
                YaruSection(
                    modifier = Modifier.width(700.dp),
                    headline = { YaruText("Auto scroll: on") },
                ) {
                    YaruCarousel(
                        pageCount = length,
                        height = 400.dp,
                        options = YaruCarouselOptions(autoScroll = true),
                    ) { CarouselSlide() }
                }
            }
            // Dart only puts a `SizedBox(height: 20)` between section1 and section2.
            // No spacer or extra padding before the OverflowBar — the ListView's
            // `kYaruPagePadding` already supplies the gutter.
            item {
                Row {
                    YaruOptionButton(onPressed = { length++ }) {
                        YaruIcon(YaruIcons.plus)
                    }
                    Spacer(Modifier.width(10.dp))
                    YaruOptionButton(onPressed = { if (length >= 2) length-- }) {
                        YaruIcon(YaruIcons.minus)
                    }
                }
            }
        }
    }
}

@Composable
private fun CarouselSlide() {
    val scheme = LocalYaruColorScheme.current
    val shape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape)
            .border(1.dp, scheme.onSurface.copy(alpha = 0.1f), shape),
    ) {
        // Mirrors `DecorationImage(image: AssetImage('assets/ubuntuhero.jpg'))`
        // with `BoxFit.contain` from the Dart sample.
        Image(
            painter = painterResource(Res.drawable.ubuntuhero),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
        )
    }
}
