package sample.app.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText

private val ExampleSpacing = 20.dp

/**
 * Scroll host shared by every widget page: an optional intro line followed by
 * the page's [SectionHeader]s and [ExampleCard]s.
 */
@Composable
fun GalleryPage(
    description: String? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val scrollState = rememberScrollState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(YaruConstants.PagePadding),
            verticalArrangement = Arrangement.spacedBy(ExampleSpacing),
        ) {
            if (description != null) {
                YaruText(
                    text = description,
                    style = LocalYaruTypography.current.bodyMedium,
                    color = LocalYaruColorScheme.current.onSurfaceVariant,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            content()
        }
    }
}

/** Groups a run of [ExampleCard]s under a heading. */
@Composable
fun SectionHeader(title: String) {
    YaruText(
        text = title,
        style = LocalYaruTypography.current.titleMedium,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(top = 4.dp),
    )
}
