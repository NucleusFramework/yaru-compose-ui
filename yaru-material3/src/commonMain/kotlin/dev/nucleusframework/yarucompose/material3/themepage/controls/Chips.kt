package dev.nucleusframework.yarucompose.material3.themepage.controls

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.material3.themepage.WrapSpacing

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/chips.dart`. */
@Composable
fun Chips(modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
        verticalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
    ) {
        // `Chip(label: Text('Chip'))` — Material 3 has no plain `Chip`; closest
        // is `AssistChip`.
        AssistChip(onClick = {}, label = { Text("Chip") })
        // `Chip(..., onDeleted: () {})` ⇒ `InputChip` with trailing close icon.
        InputChip(
            selected = false,
            onClick = {},
            label = { Text("Deletable Chip") },
            trailingIcon = { YaruIcon(YaruIcons.window_close) },
        )
        FilterChip(selected = false, onClick = {}, label = { Text("Disabled Chip") }, enabled = false)
        FilterChip(selected = true, onClick = {}, label = { Text("Selected ChoiceChip") })
        FilterChip(selected = false, onClick = {}, label = { Text("ChoiceChip") })
        FilterChip(selected = true, onClick = {}, label = { Text("Selected, disabled ChoiceChip") }, enabled = false)
    }
}
