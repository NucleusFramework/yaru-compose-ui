package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import dev.nucleusframework.yarucompose.widgets.YaruDialogSurface
import dev.nucleusframework.yarucompose.widgets.YaruDialogTitleBar
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/tab_bar_page.dart`. */
@Composable
fun TabBarPage() {
    GalleryPage(description = "A pill-indicator tab bar sized to the space it is given.") {
        ExampleCard(
            title = "Labels and icons",
            sourceCode = GallerySources.TabBarExample,
        ) { TabBarExample() }
        ExampleCard(
            title = "Inside a dialog title bar",
            description = "The Dart sample docks the bar in a YaruDialogTitleBar.",
            sourceCode = GallerySources.TabBarInTitleBarExample,
        ) { TabBarInTitleBarExample() }
    }
}

@GalleryExample("YaruTabBar", "Basic")
@Composable
private fun TabBarExample() {
    var selected by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
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
        Box(
            modifier = Modifier.fillMaxWidth().height(80.dp),
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

@GalleryExample("YaruTabBar", "In a title bar")
@Composable
private fun TabBarInTitleBarExample() {
    var selected by remember { mutableIntStateOf(0) }
    YaruDialogSurface(maxWidth = null) {
        YaruDialogTitleBar(
            isClosable = true,
            onClose = {},
            leading = {
                Box(contentAlignment = Alignment.Center) {
                    YaruOptionButton(onPressed = {}) { YaruIcon(YaruIcons.plus) }
                }
            },
            title = {
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
        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp),
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
