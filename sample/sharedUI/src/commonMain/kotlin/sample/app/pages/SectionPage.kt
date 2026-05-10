package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruSection
import dev.nucleusframework.yarucompose.widgets.YaruText

private val MinSectionWidth = 400.dp

@Composable
fun SectionPage() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(YaruConstants.PagePadding),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item { DummySection() }
        item {
            YaruSection(modifier = Modifier.width(MinSectionWidth)) {
                Column {
                    repeat(10) {
                        YaruListTile(
                            title = { YaruText("Title") },
                            subtitle = { YaruText("Subtitle") },
                            leading = { YaruIcon(YaruIcons.music_note) },
                            trailing = { YaruIcon(YaruIcons.information) },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DummySection() {
    YaruSection(
        modifier = Modifier.width(MinSectionWidth),
        headline = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                YaruText("Headline")
                // `YaruCircularProgressIndicator(strokeWidth: 3)` (section_page.dart:54).
                YaruCircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 3.dp,
                )
            }
        },
    ) {
        YaruListTile(
            title = { YaruText("Title") },
            subtitle = { YaruText("Subtitle") },
            // `Icon(YaruIcons.music_note)` (section_page.dart:30, 62).
            leading = { YaruIcon(YaruIcons.music_note) },
            trailing = { YaruIcon(YaruIcons.information) },
        )
    }
}
