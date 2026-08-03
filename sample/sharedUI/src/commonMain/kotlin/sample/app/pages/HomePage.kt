package sample.app.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruFilledButton
import dev.nucleusframework.yarucompose.widgets.YaruInfoBadge
import dev.nucleusframework.yarucompose.widgets.YaruInfoType
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.NucleusAtom

private const val RepositoryUrl = "https://github.com/NucleusFramework/yaru-compose-ui"
private const val AuthorUrl = "https://github.com/NucleusFramework"

/** Below this width the feature cards stack instead of sitting side by side. */
private val FeatureRowBreakpoint = 720.dp

/**
 * Landing page of the sample, mirroring the `HomePage` of the
 * compose-macos-26-ui sample: logo, title block, badges, call-to-action
 * buttons, feature cards and the author credit.
 */
@Composable
fun HomePage(
    widgetCount: Int,
    onExploreWidgets: () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    val uriHandler = LocalUriHandler.current
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp),
        ) {
            NucleusAtom(atomSize = 180.dp)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                YaruText(
                    text = "Yaru Compose UI",
                    style = typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                )
                YaruText(
                    text = "Ubuntu's Yaru design system for Compose Multiplatform",
                    style = typography.titleMedium,
                    color = scheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                )
                BadgeRow(
                    YaruInfoType.Success to "Desktop",
                    YaruInfoType.Success to "Android",
                    YaruInfoType.Success to "iOS",
                    YaruInfoType.Success to "Web",
                )
                BadgeRow(
                    YaruInfoType.Information to "Kotlin Multiplatform",
                    YaruInfoType.Important to "Compose",
                    YaruInfoType.Information to "MIT",
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                YaruFilledButton(onClick = onExploreWidgets) { YaruText("Explore widgets") }
                YaruOutlinedButton(onClick = { uriHandler.openUri(RepositoryUrl) }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        YaruIcon(YaruIcons.external_link, size = 16.dp)
                        YaruText("GitHub")
                    }
                }
            }

            FeatureCards(widgetCount = widgetCount)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                YaruText(
                    text = "Built by",
                    style = typography.bodyMedium,
                    color = scheme.onSurfaceVariant,
                )
                YaruText(
                    text = "Nucleus Framework",
                    style = typography.bodyMedium,
                    color = scheme.primary,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { uriHandler.openUri(AuthorUrl) },
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/** Wraps onto a second line rather than clipping in a narrow detail pane. */
@Composable
private fun BadgeRow(vararg badges: Pair<YaruInfoType, String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        badges.forEach { (type, label) ->
            YaruInfoBadge(type = type, title = { YaruText(label) })
        }
    }
}

@Composable
private fun FeatureCards(widgetCount: Int) {
    val cards = listOf(
        Triple(
            YaruIcons.app_grid,
            "$widgetCount widgets",
            "Buttons, tiles, dialogs, navigation shells and more, ported one to one from yaru.dart.",
        ),
        Triple(
            YaruIcons.color_select,
            "Yaru theming",
            "Accent variants, light and dark, high contrast and RTL — all driven by the desktop settings.",
        ),
        Triple(
            YaruIcons.globe,
            "Multiplatform",
            "Android, iOS, desktop JVM and the web (JS + Wasm) from a single codebase.",
        ),
    )
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        if (maxWidth >= FeatureRowBreakpoint) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                cards.forEach { (glyph, title, description) ->
                    FeatureCard(
                        glyph = glyph,
                        title = title,
                        description = description,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                cards.forEach { (glyph, title, description) ->
                    FeatureCard(glyph = glyph, title = title, description = description)
                }
            }
        }
    }
}

@Composable
private fun FeatureCard(
    glyph: Char,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    YaruBorderContainer(modifier = modifier, padding = PaddingValues(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            YaruIcon(glyph, size = 24.dp, tint = scheme.primary)
            YaruText(
                text = title,
                style = typography.titleMedium,
                fontWeight = FontWeight.Medium,
            )
            YaruText(
                text = description,
                style = typography.bodyMedium,
                color = scheme.onSurfaceVariant,
            )
        }
    }
}
