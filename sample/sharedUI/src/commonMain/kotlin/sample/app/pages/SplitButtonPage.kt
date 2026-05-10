package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruSlider
import dev.nucleusframework.yarucompose.widgets.YaruSplitButton
import dev.nucleusframework.yarucompose.widgets.YaruSplitButtonItem
import dev.nucleusframework.yarucompose.widgets.YaruSplitButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruText

private val ContentWidth = 500.dp

/**
 * Mirrors `yaru.dart/example/lib/pages/split_button_page.dart`. Exercises:
 *  - all three variants (regular/elevated, filled, outlined)
 *  - a slider-controlled `menuWidth`
 *  - the three "no-op" combinations: items=null, onPressed=null, both null
 *  - alignment rows: leading, space-between, centered
 */
@Composable
fun SplitButtonPage() {
    var width by remember { mutableFloatStateOf(200f) }
    val items = remember {
        (0 until 10).map { index ->
            val name = if (index % 2 == 0) "Super long action name" else "action"
            YaruSplitButtonItem(label = "$name ${index + 1}", onClick = {})
        }
    }
    val menuWidthDp = width.dp

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(YaruConstants.PagePadding),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Row(
                modifier = Modifier.width(ContentWidth),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                YaruText("Menu width: ${width.toInt()}")
                YaruSlider(
                    value = width,
                    onValueChange = { width = it },
                    valueRange = 100f..500f,
                    modifier = Modifier.weight(1f),
                )
            }
        }

        item { YaruText("Yaru Tiles") }
        item {
            // Dart `YaruBorderContainer(width: contentWidth, margin: EdgeInsets.all(kYaruPagePadding))`
            // — margin around the container, no inner padding on the container itself.
            YaruBorderContainer(
                modifier = Modifier
                    .padding(YaruConstants.PagePadding)
                    .width(ContentWidth),
            ) {
                Column {
                    val tiles = listOf(
                        Tile("YaruSplitButton()", "Regular version") {
                            YaruSplitButton(
                                onPressed = {},
                                items = items,
                                menuWidth = menuWidthDp,
                                variant = YaruSplitButtonVariant.Elevated,
                            ) { YaruText("Main Action") }
                        },
                        Tile("YaruSplitButton", ".filled()") {
                            YaruSplitButton(
                                onPressed = {},
                                items = items,
                                menuWidth = menuWidthDp,
                                variant = YaruSplitButtonVariant.Filled,
                            ) { YaruText("Main Action") }
                        },
                        Tile("YaruSplitButton", "outlined()") {
                            YaruSplitButton(
                                onPressed = {},
                                items = items,
                                menuWidth = menuWidthDp,
                                variant = YaruSplitButtonVariant.Outlined,
                            ) { YaruText("Main Action") }
                        },
                        Tile("YaruSplitButton", "items: null, onOptionPressed: null") {
                            YaruSplitButton(
                                onPressed = {},
                                menuWidth = menuWidthDp,
                            ) { YaruText("Main Action") }
                        },
                        Tile("YaruSplitButton", "onPressed: null") {
                            YaruSplitButton(
                                onPressed = null,
                                items = items,
                                menuWidth = menuWidthDp,
                            ) { YaruText("Main Action") }
                        },
                        Tile("YaruSplitButton", "items: null, onOptionPressed: null, onPressed: null") {
                            YaruSplitButton(
                                onPressed = null,
                                menuWidth = menuWidthDp,
                            ) { YaruText("Main Action") }
                        },
                    )
                    // Dart wraps each tile in `Padding(EdgeInsets.all(5.0))` (split_button_page.dart:186-189).
                    tiles.forEachIndexed { idx, tile ->
                        Box(modifier = Modifier.padding(5.dp)) {
                            YaruListTile(
                                title = { YaruText(tile.title) },
                                subtitle = { YaruText(tile.subtitle) },
                                trailing = { tile.trailing() },
                            )
                        }
                        if (idx != tiles.lastIndex) YaruHorizontalDivider()
                    }
                }
            }
        }

        item { YaruText("Normal rows") }
        item {
            // `YaruBorderContainer(width: contentWidth, margin: EdgeInsets.all(kYaruPagePadding))`
            // (split_button_page.dart:199-201).
            YaruBorderContainer(
                modifier = Modifier
                    .padding(YaruConstants.PagePadding)
                    .width(ContentWidth),
            ) {
                Column {
                    Row(
                        modifier = Modifier.padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        YaruText("Normal alignment")
                        Spacer(Modifier.width(16.dp))
                        YaruSplitButton(
                            onPressed = {},
                            items = items.take(3),
                            variant = YaruSplitButtonVariant.Outlined,
                        ) { YaruText("Main Action") }
                    }
                    YaruHorizontalDivider()
                    Row(
                        modifier = Modifier.padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        YaruText("Normal alignment with width")
                        Spacer(Modifier.width(16.dp))
                        YaruSplitButton(
                            onPressed = {},
                            items = items.take(3),
                            menuWidth = menuWidthDp,
                            variant = YaruSplitButtonVariant.Outlined,
                        ) { YaruText("Main Action") }
                    }
                    YaruHorizontalDivider()
                    Row(
                        modifier = Modifier.padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        YaruText("Space between alignment")
                        Spacer(Modifier.width(16.dp))
                        YaruSplitButton(
                            onPressed = {},
                            items = items.take(3),
                            variant = YaruSplitButtonVariant.Outlined,
                        ) { YaruText("Main Action") }
                        YaruText("Trailing")
                    }
                    YaruHorizontalDivider()
                    Row(
                        modifier = Modifier.padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        YaruText("Center alignment")
                        Spacer(Modifier.width(16.dp))
                        YaruSplitButton(
                            onPressed = {},
                            items = items.take(3),
                            variant = YaruSplitButtonVariant.Outlined,
                        ) { YaruText("Main Action") }
                    }
                }
            }
        }
    }
}

private class Tile(
    val title: String,
    val subtitle: String,
    val trailing: @Composable () -> Unit,
)
