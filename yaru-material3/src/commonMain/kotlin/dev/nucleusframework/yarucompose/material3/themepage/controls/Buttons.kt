package dev.nucleusframework.yarucompose.material3.themepage.controls

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.material3.themepage.WrapSpacing

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/buttons.dart`. */
@Composable
fun Buttons(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(false) }
    val icon: @Composable () -> Unit = { YaruIcon(YaruIcons.notification_filled) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
    ) {
        ButtonRow(
            { TextButton(onClick = {}) { Text("Text") } },
            { TextButton(onClick = {}, enabled = false) { Text("Text") } },
        )
        ButtonRow(
            { OutlinedButton(onClick = {}) { Text("Outlined") } },
            { OutlinedButton(onClick = {}, enabled = false) { Text("Outlined") } },
        )
        ButtonRow(
            { Button(onClick = {}) { Text("Filled") } },
            { Button(onClick = {}, enabled = false) { Text("Filled") } },
        )
        ButtonRow(
            { ElevatedButton(onClick = {}) { Text("Elevated") } },
            { ElevatedButton(onClick = {}, enabled = false) { Text("Elevated") } },
        )
        ButtonRow(
            {
                ElevatedButton(onClick = {}, contentPadding = ButtonDefaults.ButtonWithIconContentPadding) {
                    icon(); Spacer(Modifier.size(ButtonDefaults.IconSpacing)); Text("Elevated")
                }
            },
            {
                ElevatedButton(onClick = {}, enabled = false, contentPadding = ButtonDefaults.ButtonWithIconContentPadding) {
                    icon(); Spacer(Modifier.size(ButtonDefaults.IconSpacing)); Text("Elevated")
                }
            },
        )
        ButtonRow(
            { FilledIconButton(onClick = {}) { icon() } },
            { FilledIconButton(onClick = {}, enabled = false) { icon() } },
        )
        ButtonRow(
            { OutlinedIconButton(onClick = {}) { icon() } },
            { OutlinedIconButton(onClick = {}, enabled = false) { icon() } },
        )
        ButtonRow(
            { FilledTonalIconButton(onClick = {}) { icon() } },
            { FilledTonalIconButton(onClick = {}, enabled = false) { icon() } },
        )
        ButtonRow(
            { IconToggleButton(checked = selected, onCheckedChange = { selected = it }) { icon() } },
            { IconButton(onClick = {}, enabled = false) { icon() } },
        )
    }
}

@Composable
private fun ButtonRow(active: @Composable () -> Unit, disabled: @Composable () -> Unit) {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(WrapSpacing.dp)) {
        active(); disabled()
    }
}
