package dev.nucleusframework.yarucompose.material3.themepage.controls

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.material3.themepage.WrapSpacing

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/fabs.dart`. */
@Composable
fun Fabs(onPressed: () -> Unit, modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
        verticalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
    ) {
        FloatingActionButton(onClick = onPressed) { YaruIcon(YaruIcons.plus) }
        ExtendedFloatingActionButton(onClick = onPressed) { Text("Yay! +1 ❤️ for Yaru") }
        SmallFloatingActionButton(onClick = onPressed) { YaruIcon(YaruIcons.plus) }
        LargeFloatingActionButton(onClick = onPressed) { YaruIcon(YaruIcons.plus) }
    }
}
