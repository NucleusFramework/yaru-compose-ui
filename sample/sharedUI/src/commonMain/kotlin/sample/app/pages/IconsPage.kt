package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruSearchField
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTextButton
import dev.nucleusframework.yarucompose.widgets.YaruTitleBar
import sample.app.gallery.CodeBlock

/**
 * Showcase of every glyph in `YaruIcons` and `YaruFreedesktopIcons`.
 *
 * Mirrors `yaru.dart/example/lib/pages/icons_page/icons_page.dart` minus the
 * Animated and Widget tabs (the Compose port currently exposes only the
 * static font glyphs, so we surface them across two tabs: the raw `YaruIcons`
 * catalog and the Freedesktop binding).
 */
@Composable
fun IconsPage() {
    var tabIndex by remember { mutableIntStateOf(0) }
    var query by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<IconCatalogEntry?>(null) }

    val source = remember(tabIndex) {
        when (tabIndex) {
            0 -> yaruIconsCatalog
            else -> yaruFreedesktopIconsCatalog
        }
    }
    val filtered = remember(source, query) {
        if (query.isBlank()) source
        else source.filter { it.name.contains(query, ignoreCase = true) }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = YaruConstants.PagePadding,
                    end = YaruConstants.PagePadding,
                    top = 10.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.width(700.dp)) {
                YaruTabBar(
                    selectedTabIndex = tabIndex,
                    onTabSelected = { tabIndex = it },
                    tabs = listOf(
                        { YaruTab(label = "YaruIcons (${yaruIconsCatalog.size})") },
                        { YaruTab(label = "Freedesktop (${yaruFreedesktopIconsCatalog.size})") },
                    ),
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(modifier = Modifier.width(280.dp)) {
                YaruSearchField(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = "Search icons",
                    autoFocus = false,
                    onClear = { query = "" },
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 96.dp),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(filtered, key = { it.usage }) { entry ->
                IconCard(entry = entry, onClick = { selected = entry })
            }
        }
    }

    selected?.let { entry ->
        IconDetailDialog(entry = entry, onDismiss = { selected = null })
    }
}

@Composable
private fun IconCard(entry: IconCatalogEntry, onClick: () -> Unit) {
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        YaruIcon(glyph = entry.char, size = 32.dp)
        Spacer(Modifier.height(6.dp))
        YaruText(
            text = entry.name,
            style = LocalYaruTypography.current.labelSmall,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

/** Mirrors `_iconDialogSizes` in `icons_page/common/icon_dialog.dart`. */
private val IconDialogSizes = listOf(16, 24, 32, 48, 64, 128)

@Composable
private fun IconDetailDialog(entry: IconCatalogEntry, onDismiss: () -> Unit) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
    ) {
        Box(
            modifier = Modifier
                .width(560.dp)
                .background(scheme.surface, RoundedCornerShape(YaruConstants.WindowRadius)),
        ) {
            Column {
                YaruTitleBar(
                    title = { YaruText(entry.name) },
                    actions = {
                        YaruTextButton(onClick = onDismiss) { YaruText("Close") }
                    },
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Size grid — mirrors the Dart `Wrap` with sizes 16/24/32/48/64/128.
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        IconDialogSizes.forEach { size ->
                            val pad = ((IconDialogSizes.last() - size) / 10) + 8
                            Column(
                                modifier = Modifier.padding(horizontal = pad.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(size.dp)
                                        .background(
                                            scheme.onSurface.copy(alpha = 0.05f),
                                            RoundedCornerShape((size / 10).dp),
                                        ),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    YaruIcon(glyph = entry.char, size = size.dp)
                                }
                                Spacer(Modifier.height(6.dp))
                                YaruText(text = "${size}px", style = typography.bodySmall)
                            }
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    // Mirrors `IconUsage(label: true)`, but as a copyable snippet
                    // so the catalog doubles as a code source like the other pages.
                    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                        CodeBlock(code = "YaruIcon(${entry.usage})")
                    }
                }
            }
        }
    }
}
