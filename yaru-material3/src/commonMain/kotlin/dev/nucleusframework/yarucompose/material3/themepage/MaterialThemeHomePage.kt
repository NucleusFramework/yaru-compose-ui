package dev.nucleusframework.yarucompose.material3.themepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.material3.YaruMaterialTheme
import dev.nucleusframework.yarucompose.material3.themepage.controls.ControlsView

/**
 * Compose equivalent of `MaterialThemeHomePage` in
 * `yaru.dart/example/lib/pages/theme_page/src/home/home_page.dart`. Wraps the
 * sub-tree in [YaruMaterialTheme] so descendant `material3` widgets pick up
 * Yaru tokens.
 *
 * The Dart original also nests a `Scaffold + AppBar + Drawer`. We deliberately
 * omit those here because in the Compose sample this page already lives inside
 * a `YaruDetailPage` (its own title bar + master-detail chrome) — stacking a
 * second Material `Scaffold` produces double chrome and a clipped drawer.
 */
@Composable
fun MaterialThemeHomePage() {
    YaruMaterialTheme { Content() }
}

private data class ThemeSection(
    val title: String,
    val icon: Char,
    val selectedIcon: Char,
    val showBadge: Boolean = false,
)

private val Sections = listOf(
    ThemeSection("Fonts", YaruIcons.font, YaruIcons.font, showBadge = true),
    ThemeSection("Controls", YaruIcons.radiobox_checked, YaruIcons.radiobox_checked_filled),
    ThemeSection("TextFields", YaruIcons.text_editor, YaruIcons.text_editor_filled),
    ThemeSection("Palette", YaruIcons.colors, YaruIcons.colors_filled),
    ThemeSection("Containers", YaruIcons.window, YaruIcons.window_filled),
)

@Composable
private fun Content() {
    var selected by remember { mutableIntStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        if (maxWidth > 800.dp) {
            Row(modifier = Modifier.fillMaxSize()) {
                NavigationRail {
                    Sections.forEachIndexed { index, section ->
                        NavigationRailItem(
                            selected = index == selected,
                            onClick = { selected = index },
                            icon = { SectionIcon(section, selected = index == selected) },
                            label = { Text(section.title) },
                        )
                    }
                }
                VerticalDivider(thickness = Dp.Hairline)
                Box(modifier = Modifier.weight(1f).fillMaxSize()) {
                    ViewSwitcher(selected, snackbarHostState)
                    SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier.align(Alignment.BottomCenter),
                    )
                }
            }
        } else {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f).fillMaxSize()) {
                    ViewSwitcher(selected, snackbarHostState)
                    SnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier.align(Alignment.BottomCenter),
                    )
                }
                HorizontalDivider(thickness = Dp.Hairline)
                NavigationBar {
                    Sections.forEachIndexed { index, section ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = { selected = index },
                            icon = { SectionIcon(section, selected = index == selected) },
                            label = { Text(section.title) },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ViewSwitcher(selected: Int, snackbarHostState: SnackbarHostState) {
    // No center-alignment: the Dart `Center(child: ...)` collapses to the
    // child's intrinsic height (Column has none), which is fine in Flutter's
    // box model but pins the content to the middle of the pane in Compose.
    // Sub-views fill the available space and place their own children at top.
    val mod = Modifier.fillMaxSize()
    when (selected) {
        0 -> FontsView(mod)
        1 -> ControlsView(snackbarHostState, mod)
        2 -> TextFieldsView(mod)
        3 -> ColorsView(mod)
        4 -> ContainersView(mod)
    }
}

@Composable
private fun SectionIcon(section: ThemeSection, selected: Boolean) {
    val glyph = if (selected) section.selectedIcon else section.icon
    if (section.showBadge) {
        BadgedBox(badge = { Badge { Text("123") } }) { YaruIcon(glyph) }
    } else {
        YaruIcon(glyph)
    }
}

