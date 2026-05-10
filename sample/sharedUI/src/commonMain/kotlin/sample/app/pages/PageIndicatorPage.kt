package sample.app.pages

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruPageIndicatorBuilder
import dev.nucleusframework.yarucompose.widgets.YaruPageIndicatorItem
import dev.nucleusframework.yarucompose.widgets.YaruPageIndicatorSteppedDelegate
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSlider

@Composable
fun PageIndicatorPage() {
    var page by remember { mutableIntStateOf(0) }
    var length by remember { mutableIntStateOf(5) }
    var dotSize by remember { mutableFloatStateOf(12f) }
    var dotSpacing by remember { mutableFloatStateOf(48f) }

    val animation = tween<androidx.compose.ui.unit.Dp>(durationMillis = 250)

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
            // Variant 1: selected dot grows.
            item {
                YaruPageIndicatorBuilder(
                    length = length,
                    page = page,
                    onTap = { page = it },
                    itemSizeBuilder = { _, _, _ -> DpSize((dotSize + 8).dp, (dotSize + 8).dp) },
                    layoutDelegate = YaruPageIndicatorSteppedDelegate(dotSpacing.dp),
                    itemBuilder = { index, selectedIndex, _ ->
                        YaruPageIndicatorItem(
                            selected = index == selectedIndex,
                            size = DpSize(
                                if (index == selectedIndex) (dotSize + 8).dp else dotSize.dp,
                                if (index == selectedIndex) (dotSize + 8).dp else dotSize.dp,
                            ),
                            animationSpec = animation,
                        )
                    },
                )
            }
            item { Spacer(Modifier.height(15.dp)) }
            // Variant 2: progress-bar — every dot up to selected is filled.
            item {
                YaruPageIndicatorBuilder(
                    length = length,
                    page = page,
                    onTap = { page = it },
                    itemSizeBuilder = { _, _, _ -> DpSize((dotSize + 8).dp, (dotSize + 8).dp) },
                    layoutDelegate = YaruPageIndicatorSteppedDelegate(dotSpacing.dp),
                    itemBuilder = { index, selectedIndex, _ ->
                        YaruPageIndicatorItem(
                            selected = index <= selectedIndex,
                            size = DpSize(
                                if (index <= selectedIndex) (dotSize + 8).dp else dotSize.dp,
                                if (index <= selectedIndex) (dotSize + 8).dp else dotSize.dp,
                            ),
                            animationSpec = animation,
                        )
                    },
                )
            }
            item { Spacer(Modifier.height(20.dp)) }
            // Variant 3: pill-shaped active dot.
            item {
                YaruPageIndicatorBuilder(
                    length = length,
                    page = page,
                    onTap = { page = it },
                    itemSizeBuilder = { index, selectedIndex, _ ->
                        if (index == selectedIndex) DpSize((dotSize * 3).dp, dotSize.dp)
                        else DpSize(dotSize.dp, dotSize.dp)
                    },
                    layoutDelegate = YaruPageIndicatorSteppedDelegate(dotSpacing.dp),
                    animationSpec = animation,
                    itemBuilder = { index, selectedIndex, _ ->
                        YaruPageIndicatorItem(
                            selected = index == selectedIndex,
                            size = if (index == selectedIndex) {
                                DpSize((dotSize * 3).dp, dotSize.dp)
                            } else {
                                DpSize(dotSize.dp, dotSize.dp)
                            },
                            animationSpec = animation,
                            borderRadius = 24.dp,
                        )
                    },
                )
            }
            item { Spacer(Modifier.height(15.dp)) }
            item {
                Row {
                    YaruOptionButton(onPressed = { length++ }) {
                        YaruIcon(YaruIcons.plus)
                    }
                    Spacer(Modifier.width(10.dp))
                    YaruOptionButton(onPressed = {
                        if (length > 1) length--
                        if (page > length - 1) page = length - 1
                    }) {
                        YaruIcon(YaruIcons.minus)
                    }
                }
            }
            item {
                YaruSlider(
                    value = dotSize,
                    onValueChange = { dotSize = it },
                    valueRange = 6f..24f,
                )
            }
            item {
                YaruSlider(
                    value = dotSpacing,
                    onValueChange = { dotSpacing = it },
                    valueRange = 12f..96f,
                )
            }
        }
    }
}
