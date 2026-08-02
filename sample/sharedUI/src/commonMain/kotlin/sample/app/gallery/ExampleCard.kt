package sample.app.gallery

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruHorizontalDivider
import dev.nucleusframework.yarucompose.widgets.YaruTab
import dev.nucleusframework.yarucompose.widgets.YaruTabBar
import dev.nucleusframework.yarucompose.widgets.YaruText

private const val PreviewTab = 0

private val TabBarWidth = 200.dp
private val CardPadding = 16.dp
private val PreviewMinHeight = 80.dp

/**
 * A single gallery entry: a live preview and the exact source that produced it,
 * behind a Preview / Code tab bar.
 *
 * [sourceCode] is meant to be fed from `GallerySources.<exampleName>` so the two
 * can never drift apart.
 */
@Composable
fun ExampleCard(
    title: String,
    sourceCode: String,
    description: String? = null,
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    var selectedTab by remember { mutableIntStateOf(PreviewTab) }

    YaruBorderContainer(
        modifier = Modifier.fillMaxWidth(),
        color = scheme.surface,
        clipContent = true,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = CardPadding, end = 5.dp, top = 5.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1f, fill = false),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                ) {
                    YaruText(
                        text = title,
                        style = typography.titleSmall,
                        fontWeight = FontWeight.Medium,
                    )
                    if (description != null) {
                        YaruText(
                            text = description,
                            style = typography.bodySmall,
                            color = scheme.onSurfaceVariant,
                        )
                    }
                }
                Box(modifier = Modifier.width(TabBarWidth)) {
                    YaruTabBar(
                        selectedTabIndex = selectedTab,
                        onTabSelected = { selectedTab = it },
                        tabs = listOf(
                            { YaruTab(label = "Preview") },
                            { YaruTab(label = "Code") },
                        ),
                    )
                }
            }

            YaruHorizontalDivider()

            AnimatedContent(
                targetState = selectedTab,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
            ) { tab ->
                if (tab == PreviewTab) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = PreviewMinHeight)
                            .padding(CardPadding),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        content()
                    }
                } else {
                    Box(modifier = Modifier.padding(CardPadding)) {
                        CodeBlock(code = sourceCode)
                    }
                }
            }
        }
    }
}
