package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruExpansionPanel
import dev.nucleusframework.yarucompose.widgets.YaruText

@Composable
fun ExpansionPanelPage() {
    val initial = remember { (0 until 10).map { it % 2 == 0 } }
    val typography = LocalYaruTypography.current
    val headers = remember<List<@Composable () -> Unit>>(typography) {
        (0 until 10).map { i ->
            { YaruText("Header $i", style = typography.bodyLarge) }
        }
    }
    val contents = remember<List<@Composable () -> Unit>> {
        (0 until 10).map { i ->
            { Box(modifier = Modifier.padding(40.dp)) { YaruText("Child $i") } }
        }
    }
    Box(modifier = Modifier.padding(YaruConstants.PagePadding)) {
        YaruExpansionPanel(
            modifier = Modifier.width(500.dp).height(500.dp),
            headers = headers,
            contents = contents,
            isInitiallyExpanded = initial,
            // Mirrors yaru.dart's `expandIconBuilder` in the example: plain
            // `Icon(YaruIcons.pan_end)` with NO explicit size — Flutter's
            // IconButtonTheme `iconSize: kYaruIconSize` (= 20.dp) takes over.
            expandIconBuilder = { _ -> YaruIcon(YaruIcons.pan_end) },
        )
    }
}
