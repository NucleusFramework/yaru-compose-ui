package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar
import dev.nucleusframework.yarucompose.widgets.YaruTitleBar

/**
 * Mirrors `yaru.dart/example/lib/pages/tab_bar_page.dart`.
 *
 * Dart layout:
 *  - The page background is `theme.colorScheme.outline` (`ColoredBox`).
 *  - A centered `SimpleDialog` whose `title` is a `YaruDialogTitleBar` with:
 *      • leading: a centered `YaruOptionButton` with a plus icon
 *      • title: `SizedBox(width: 500, child: YaruTabBar(... 3 tabs))`
 *  - The dialog body is a 600x400 `TabBarView` rendering the matching icon
 *    plain (Dart does not specify a size, so the icons render at their
 *    default `kDefaultFontSize` ≈ 24).
 *
 * No commonMain `SimpleDialog`, so we use `YaruBorderContainer` as the shell.
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
        // `clipContent = true`: the inner `YaruTitleBar` fills its bounds with a
        // solid surface color whose square corners would otherwise show past the
        // rounded border (Dart's `SimpleDialog` clips via `Material(clip: antiAlias)`).
        YaruBorderContainer(clipContent = true) {
            Column {
                // `YaruDialogTitleBar` (Dart) defaults `isClosable = true` and
                // `onClose = Navigator.maybePop` — see yaru_title_bar.dart:671.
                // We mirror by enabling the close button with a no-op handler.
                YaruTitleBar(
                    centerTitle = true,
                    isClosable = true,
                    onClose = {},
                    leading = {
                        // `Center(child: YaruOptionButton(onPressed: () {}, child: Icon(plus)))`
                        // (tab_bar_page.dart:38-43).
                        Box(contentAlignment = Alignment.Center) {
                            YaruOptionButton(onPressed = {}) {
                                YaruIcon(YaruIcons.plus)
                            }
                        }
                    },
                    title = {
                        // `SizedBox(width: 500, child: YaruTabBar(...))` (tab_bar_page.dart:44-59).
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
                // `SizedBox(width: 600, height: 400, child: TabBarView(children: [Icon, Icon, Icon]))`
                // (tab_bar_page.dart:63-74).
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
