package sample.app.pages

import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import dev.nucleusframework.yarucompose.iconsextended.YaruFullColorIcon
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruDialog
import dev.nucleusframework.yarucompose.widgets.YaruSearchField
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.CodeBlock

/**
 * Full-colour icon catalog from `yaru.dart/example/lib/pages/full_color_icons_page.dart`.
 *
 * Unlike Flutter's `Image.network(...)` original (and this page's own former
 * Coil/Ktor-backed implementation), every icon here is bundled by
 * `:yaru-icons-extended` and rendered via [YaruFullColorIcon] — no network
 * access, no loading/error states to model.
 */
@Composable
fun FullColorIconsPage() {
    val categories = remember { yaruFullColorIconsCatalog.groupBy { it.category } }
    val categoryKeys = remember { categories.keys.toList() }
    var selectedTab by remember { mutableIntStateOf(1.coerceAtMost(categoryKeys.lastIndex)) }
    var query by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<FullColorIconCatalogEntry?>(null) }
    val currentCategory = categoryKeys[selectedTab]

    Column(modifier = Modifier.fillMaxSize()) {
        // full_color_icons_page.dart L37-L45: `EdgeInsets.symmetric(horizontal: kYaruPagePadding)`
        // — no vertical padding on the tab bar.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = YaruConstants.PagePadding),
        ) {
            YaruTabBar(
                selectedTabIndex = selectedTab,
                onTabSelected = { selectedTab = it },
                tabs = categoryKeys.map { category -> { YaruTab(label = category) } },
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = YaruConstants.PagePadding),
        ) {
            YaruSearchField(
                value = query,
                onValueChange = { query = it },
                placeholder = "Search icons",
                autoFocus = false,
                onClear = { query = "" },
            )
        }
        val current = categories.getValue(currentCategory)
        val filtered = remember(current, query) {
            if (query.isBlank()) current
            else current.filter { it.name.contains(query, ignoreCase = true) }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(filtered, key = { it.name }) { entry ->
                FullColorIconCell(
                    entry = entry,
                    onClick = { selected = entry },
                )
            }
        }
    }

    selected?.let { entry ->
        YaruDialog(
            onDismissRequest = { selected = null },
            title = { YaruText(entry.name) },
            contentPadding = PaddingValues(16.dp),
        ) {
            val identifier = entry.name.replace(Regex("[^a-zA-Z0-9]"), "_")
            CodeBlock(code = "YaruFullColorIcon(YaruFullColorIcons.$identifier)")
        }
    }
}

@Composable
private fun FullColorIconCell(entry: FullColorIconCatalogEntry, onClick: () -> Unit) {
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(modifier = Modifier.size(35.dp), contentAlignment = Alignment.Center) {
            YaruFullColorIcon(
                icon = entry.icon,
                contentDescription = entry.name,
                size = 35.dp,
            )
        }
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
