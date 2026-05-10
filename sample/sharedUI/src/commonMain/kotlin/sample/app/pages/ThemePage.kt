package sample.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColors
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.YaruVariant
import dev.nucleusframework.yarucompose.widgets.YaruButton
import dev.nucleusframework.yarucompose.widgets.YaruButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruCheckbox
import dev.nucleusframework.yarucompose.widgets.YaruElevatedButton
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedTextField
import dev.nucleusframework.yarucompose.widgets.YaruRadio
import dev.nucleusframework.yarucompose.widgets.YaruSlider
import dev.nucleusframework.yarucompose.widgets.YaruSwitch
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTextButton
import dev.nucleusframework.yarucompose.widgets.YaruTonalButton
import dev.nucleusframework.yarucompose.widgets.YaruVerticalDivider

private data class Section(
    val title: String,
    val icon: Char,
    val selectedIcon: Char,
    val content: @Composable () -> Unit,
)

@Composable
fun ThemePage() {
    var selected by remember { mutableIntStateOf(0) }
    // Mirrors `_items` in `theme_page/src/home/home_page.dart:25-51` — selected icons
    // swap to filled variants. The Dart `font` slot uses a `Badge` wrapping the icon.
    val sections = remember {
        listOf(
            Section("Fonts", YaruIcons.font, YaruIcons.font) { FontsView() },
            Section("Controls", YaruIcons.radiobox_checked, YaruIcons.radiobox_checked_filled) { ControlsView() },
            Section("TextFields", YaruIcons.text_editor, YaruIcons.text_editor_filled) { TextFieldsView() },
            Section("Palette", YaruIcons.colors, YaruIcons.colors_filled) { ColorsView() },
            Section("Containers", YaruIcons.window, YaruIcons.window_filled) { ContainersView() },
        )
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        // Dart uses `constraints.maxWidth > 800` in `home_page.dart:83` — keep strict
        // greater-than so the breakpoint matches the reference implementation.
        if (maxWidth > 800.dp) {
            Row(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.width(80.dp).padding(top = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    sections.forEachIndexed { index, section ->
                        YaruTextButton(onClick = { selected = index }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                YaruIcon(if (selected == index) section.selectedIcon else section.icon)
                                YaruText(
                                    section.title,
                                    fontWeight = if (selected == index) FontWeight.Bold else FontWeight.Normal,
                                )
                            }
                        }
                    }
                }
                YaruVerticalDivider()
                Box(modifier = Modifier.weight(1f).fillMaxSize().padding(YaruConstants.PagePadding)) {
                    sections[selected].content()
                }
            }
        } else {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f).fillMaxSize().padding(YaruConstants.PagePadding)) {
                    sections[selected].content()
                }
                YaruHorizontalDivider()
                BottomNavigationBar(
                    sections = sections,
                    selectedIndex = selected,
                    onSelected = { selected = it },
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationBar(
    sections: List<Section>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(scheme.surface)
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        sections.forEachIndexed { index, section ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onSelected(index) }
                    .padding(8.dp),
            ) {
                YaruIcon(
                    if (index == selectedIndex) section.selectedIcon else section.icon,
                    tint = if (index == selectedIndex) scheme.primary else scheme.onSurface,
                )
                YaruText(
                    section.title,
                    style = LocalYaruTypography.current.labelSmall,
                    color = if (index == selectedIndex) scheme.primary else scheme.onSurface,
                )
            }
        }
    }
}

@Composable
private fun FontsView() {
    // Mirrors `theme_page/src/fonts/fonts_view.dart:11-31` — 15 textTheme entries.
    val typography = LocalYaruTypography.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item { YaruText("displayLarge", style = typography.displayLarge) }
        item { YaruText("displayMedium", style = typography.displayMedium) }
        item { YaruText("displaySmall", style = typography.displaySmall) }
        item { YaruText("headlineLarge", style = typography.headlineLarge) }
        item { YaruText("headlineMedium", style = typography.headlineMedium) }
        item { YaruText("headlineSmall", style = typography.headlineSmall) }
        item { YaruText("titleLarge", style = typography.titleLarge) }
        item { YaruText("titleMedium", style = typography.titleMedium) }
        item { YaruText("titleSmall", style = typography.titleSmall) }
        item { YaruText("bodyLarge", style = typography.bodyLarge) }
        item { YaruText("bodyMedium", style = typography.bodyMedium) }
        item { YaruText("bodySmall", style = typography.bodySmall) }
        item { YaruText("labelLarge", style = typography.labelLarge) }
        item { YaruText("labelMedium", style = typography.labelMedium) }
        item { YaruText("labelSmall", style = typography.labelSmall) }
    }
}

@Composable
private fun ControlsView() {
    var checked by remember { mutableStateOf(true) }
    var radio by remember { mutableIntStateOf(0) }
    var slider by remember { mutableFloatStateOf(0.5f) }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            YaruSwitch(checked = checked, onCheckedChange = { checked = it })
            Spacer(Modifier.width(8.dp))
            YaruCheckbox(value = checked, onChanged = { checked = it ?: false })
            Spacer(Modifier.width(8.dp))
            YaruRadio(value = 0, groupValue = radio, onChanged = { radio = it ?: 0 })
            YaruRadio(value = 1, groupValue = radio, onChanged = { radio = it ?: 1 })
        }
        YaruSlider(value = slider, onValueChange = { slider = it })
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            YaruButton(onClick = {}, variant = YaruButtonVariant.Filled) { YaruText("Filled") }
            YaruTonalButton(onClick = {}) { YaruText("Tonal") }
            YaruElevatedButton(onClick = {}) { YaruText("Elevated") }
            YaruOutlinedButton(onClick = {}) { YaruText("Outlined") }
            YaruTextButton(onClick = {}) { YaruText("Text") }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            YaruButton(onClick = {}, variant = YaruButtonVariant.Filled, enabled = false) { YaruText("Filled") }
            YaruTonalButton(onClick = {}, enabled = false) { YaruText("Tonal") }
            YaruElevatedButton(onClick = {}, enabled = false) { YaruText("Elevated") }
            YaruOutlinedButton(onClick = {}, enabled = false) { YaruText("Outlined") }
            YaruTextButton(onClick = {}, enabled = false) { YaruText("Text") }
        }
    }
}

@Composable
private fun TextFieldsView() {
    var text by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        YaruOutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { YaruText("Outlined") },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun ColorsView() {
    val colors = remember { YaruVariant.entries.toList() }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 80.dp),
        contentPadding = PaddingValues(0.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(colors) { variant ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(variant.color),
                )
                YaruText(variant.name, style = LocalYaruTypography.current.labelSmall)
            }
        }
    }
}

@Composable
private fun ContainersView() {
    val scheme = LocalYaruColorScheme.current
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(scheme.primary)) {}
        Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(scheme.secondary)) {}
        Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(scheme.tertiary)) {}
        Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(YaruColors.Orange)) {}
    }
}