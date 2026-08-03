package sample.app.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.widgets.YaruSection
import dev.nucleusframework.yarucompose.widgets.YaruText
import org.jetbrains.compose.resources.ExperimentalResourceApi
import sample.app.gallery.GalleryPage
import yarucompose.sample.sharedui.generated.resources.Res

private const val YaruIconsCopyingUrl = "https://github.com/ubuntu/yaru/blob/master/COPYING"
private const val UbuntuFontLicenceUrl = "https://ubuntu.com/legal/font-licence"

/**
 * Mirrors the `LicensePage` of the compose-macos-26-ui sample: the project
 * license verbatim, followed by the notices of the bundled Yaru assets.
 */
@Composable
fun LicensePage() {
    val licenseText by produceState<String?>(null) { value = readLicense() }

    GalleryPage(description = "YaruCompose is available under the MIT License.") {
        YaruSection(
            headline = { YaruText("MIT License") },
            contentPadding = PaddingValues(16.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                licenseText?.paragraphs()?.forEach { paragraph ->
                    YaruText(
                        text = paragraph,
                        style = LocalYaruTypography.current.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
        YaruSection(
            headline = { YaruText("Third-party assets") },
            contentPadding = PaddingValues(16.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                NoticeParagraph(
                    text = "The Yaru icon font and the full-colour icon artwork come from " +
                        "ubuntu/yaru, dual-licensed under the GNU GPL v3 or CC-BY-SA 4.0.",
                    linkLabel = YaruIconsCopyingUrl,
                )
                NoticeParagraph(
                    text = "The Ubuntu font family is licensed under the Ubuntu Font Licence 1.0.",
                    linkLabel = UbuntuFontLicenceUrl,
                )
            }
        }
    }
}

@Composable
private fun NoticeParagraph(text: String, linkLabel: String) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    val uriHandler = LocalUriHandler.current
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        YaruText(text = text, style = typography.bodyMedium, modifier = Modifier.fillMaxWidth())
        YaruText(
            text = linkLabel,
            style = typography.bodySmall,
            color = scheme.primary,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { uriHandler.openUri(linkLabel) },
        )
    }
}

/** Body of the root `LICENSE`; the section headline supplies its title. */
@OptIn(ExperimentalResourceApi::class)
private suspend fun readLicense(): String = Res.readBytes("files/license.txt").decodeToString()

/**
 * The license file is hard-wrapped at 80 columns; join each block back into a
 * single paragraph so it reflows with the detail pane.
 */
private fun String.paragraphs(): List<String> =
    trim().split(Regex("\\n\\s*\\n")).map { block ->
        block.lines().joinToString(" ") { it.trim() }.trim()
    }
