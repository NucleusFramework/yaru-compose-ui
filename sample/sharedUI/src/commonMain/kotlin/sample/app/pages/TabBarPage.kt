package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.widgets.YaruDialogSurface
import dev.nucleusframework.yarucompose.widgets.YaruDialogTitleBar
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar

/**
 * Mirrors `yaru.dart/example/lib/pages/tab_bar_page.dart`.
 *
 * Dart layout:
 *  - Page background: `theme.colorScheme.outline`.
 *  - Centered `SimpleDialog` (`titlePadding: EdgeInsets.zero`) with:
 *      • title: `YaruDialogTitleBar` containing the option button + 500 dp tab bar
 *      • children: `SizedBox(width: 600, height: 400, child: TabBarView)`
 *
 * Material `SimpleDialog` defaults applied here:
 *  - `contentPadding`: `EdgeInsets.fromLTRB(0, 12, 0, 16)` around the children.
 *  - Surface chrome (`_createDialogTheme`, common_themes.dart:318-330):
 *    14 dp window radius, `_createMenuBg` background, dark/HC border,
 *    Material `_DialogDefaultsM3.elevation = 6`. All provided by [YaruDialogSurface].
 *  - The dialog has no max width by default in Flutter, so we pass
 *    `maxWidth = null` to let the 600 dp body size the dialog.
 */
@Composable
fun TabBarPage() {
    var selected by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalYaruColorScheme.current.outline),
        contentAlignment = Alignment.Center,
    ) {
        YaruDialogSurface(maxWidth = null) {
            Column {
                // tab_bar_page.dart:37-61: `YaruDialogTitleBar` with `titlePadding: EdgeInsets.zero`
                // — the title bar fills the top edge-to-edge.
                YaruDialogTitleBar(
                    isClosable = true,
                    onClose = {},
                    leading = {
                        // `Center(child: YaruOptionButton(child: Icon(plus)))` (lines 38-43).
                        Box(contentAlignment = Alignment.Center) {
                            YaruOptionButton(onPressed = {}) {
                                YaruIcon(YaruIcons.plus)
                            }
                        }
                    },
                    title = {
                        // `SizedBox(width: 500, child: YaruTabBar(...))` (lines 44-59).
                        Box(modifier = Modifier.width(500.dp)) {
                            YaruTabBar(
                                selectedTabIndex = selected,
                                onTabSelected = { selected = it },
                                tabs = listOf(
                                    { YaruTab(label = "Gaming", icon = { YaruIcon(YaruIcons.game_controller) }) },
                                    { YaruTab(label = "Keyboard", icon = { YaruIcon(YaruIcons.keyboard) }) },
                                    { YaruTab(label = "Contacts", icon = { YaruIcon(YaruIcons.address_book) }) },
                                ),
                            )
                        }
                    },
                )
                // `SizedBox(width: 600, height: 400, child: TabBarView(...))` (lines 63-74),
                // wrapped in `SimpleDialog`'s default `contentPadding` of
                // `EdgeInsets.fromLTRB(0, 12, 0, 16)` (material/dialog.dart).
                Box(
                    modifier = Modifier.padding(top = 12.dp, bottom = 16.dp),
                ) {
                    Box(
                        modifier = Modifier.size(width = 600.dp, height = 400.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        when (selected) {
                            0 -> YaruIcon(YaruIcons.game_controller)
                            1 -> YaruIcon(YaruIcons.keyboard)
                            else -> YaruIcon(YaruIcons.address_book)
                        }
                    }
                }
            }
        }
    }
}
