package sample.app.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruColors
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruButton
import dev.nucleusframework.yarucompose.widgets.YaruButtonVariant
import dev.nucleusframework.yarucompose.widgets.YaruIconButton
import dev.nucleusframework.yarucompose.widgets.YaruInfoBadge
import dev.nucleusframework.yarucompose.widgets.YaruInfoBox
import dev.nucleusframework.yarucompose.widgets.YaruInfoType
import dev.nucleusframework.yarucompose.widgets.YaruSlider
import dev.nucleusframework.yarucompose.widgets.YaruText

@Composable
fun InfoPage() {
    var take by remember { mutableIntStateOf(80) }
    var idea by remember { mutableStateOf(false) }
    val infoTypes = remember { YaruInfoType.entries.toList() }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(YaruConstants.PagePadding),
        ) {
            YaruIconButton(
                onPressed = { idea = !idea },
                isSelected = idea,
                tooltip = "Custom icons and colors are possible",
            ) {
                YaruIcon(
                    if (idea) YaruIcons.light_bulb_on else YaruIcons.light_bulb_off,
                    size = 30.dp,
                )
            }
            Spacer(Modifier.width(5.dp))
            YaruSlider(
                value = take.toFloat(),
                onValueChange = { take = it.toInt() },
                valueRange = 1f..SampleLorem.length.toFloat(),
                modifier = Modifier.weight(1f),
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
        ) {
            items(infoTypes) { info ->
                val ideaOnInformation = info == YaruInfoType.Information && idea
                val customColor = if (ideaOnInformation) YaruColors.Magenta else null
                YaruInfoBox(
                    type = info,
                    title = { YaruText(info.name.capitalize()) },
                    subtitle = { YaruText(SampleLorem.take(take)) },
                    color = customColor,
                    icon = if (ideaOnInformation) {
                        { YaruIcon(YaruIcons.light_bulb_on, size = 24.dp) }
                    } else {
                        null
                    },
                    trailing = if (ideaOnInformation) {
                        { CopyButton(text = SampleLorem) }
                    } else {
                        null
                    },
                )
                Row(modifier = Modifier.padding(vertical = YaruConstants.PagePadding)) {
                    YaruInfoBadge(
                        type = info,
                        title = { YaruText(info.name.capitalize()) },
                    )
                }
            }
        }
    }
}

/** Capitalizes first char and lower-cases the rest, mirroring the Dart sample's
 *  `_StringExtension.capitalize()`. */
private fun String.capitalize(): String =
    if (isEmpty()) this else this[0].uppercase() + substring(1).lowercase()

/** Square outlined copy button — mirror of `_CopyButton` in
 *  `yaru.dart/example/lib/pages/info_page.dart`. Clipboard write is a no-op
 *  here: commonMain has no clipboard API and the sample doesn't pull in a
 *  platform abstraction. The [text] parameter is kept so the call site
 *  matches the Dart signature 1:1. */
@Composable
private fun CopyButton(text: String) {
    YaruButton(
        onClick = {
            // Equivalent of Dart's `Clipboard.setData(ClipboardData(text: text))`
            // followed by a "Copied" SnackBar. Intentionally unimplemented.
            @Suppress("UNUSED_VARIABLE") val toCopy = text
        },
        modifier = Modifier.size(YaruConstants.TitleBarItemHeight),
        variant = YaruButtonVariant.Outlined,
        contentPadding = PaddingValues(0.dp),
        border = BorderStroke(1.dp, YaruColors.Magenta.copy(alpha = 0.5f)),
    ) {
        YaruIcon(YaruIcons.copy, tint = YaruColors.Magenta)
    }
}
