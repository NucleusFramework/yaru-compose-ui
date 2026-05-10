package sample.app.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruInfoType
import dev.nucleusframework.yarucompose.widgets.YaruSlider
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTranslucentContainer

@Composable
fun BorderContainerPage() {
    var take by remember { mutableIntStateOf(80) }
    val infoTypes = remember { YaruInfoType.entries.toList() }
    val typography = LocalYaruTypography.current

    Column(modifier = Modifier.fillMaxSize()) {
        YaruSlider(
            value = take.toFloat(),
            onValueChange = { take = it.toInt() },
            valueRange = 1f..SampleLorem.length.toFloat(),
            modifier = Modifier.padding(YaruConstants.PagePadding),
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
        ) {
            items(infoTypes) { info ->
                // Mirrors `ListView.separated` — itemBuilder yields the
                // YaruBorderContainer; separatorBuilder yields the
                // YaruTranslucentContainer wrapped in `EdgeInsets.symmetric(vertical: kYaruPagePadding)`.
                YaruBorderContainer(padding = PaddingValues(8.dp)) {
                    YaruText(SampleLorem.take(take), style = typography.bodyMedium)
                }
                YaruTranslucentContainer(
                    color = info.color(),
                    modifier = Modifier.padding(vertical = YaruConstants.PagePadding),
                    padding = PaddingValues(8.dp),
                ) {
                    YaruText(SampleLorem.take(take), style = typography.bodyMedium)
                }
            }
        }
    }
}
