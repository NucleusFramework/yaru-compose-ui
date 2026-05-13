package dev.nucleusframework.yarucompose.material3.themepage.controls

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.material3.themepage.WrapSpacing
import dev.nucleusframework.yarucompose.widgets.YaruInfoBox
import dev.nucleusframework.yarucompose.widgets.YaruInfoType

/**
 * Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/toggleables.dart`.
 *
 * Flutter renders a single outer `Wrap` with 5 mixed children (an inner
 * `Wrap` for ToggleButtons, an info box, then `Row`s of Checkboxes/Radios
 * and a `Wrap` of Switches). Mirrored here with the outer `FlowRow`.
 */
@Composable
fun Toggleables(modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            // `const Text('ToggleButtons:')` — sits inline with the row, so
            // align center-vertically with the segmented buttons that follow.
            Box(
                modifier = Modifier.height(40.dp),
                contentAlignment = Alignment.CenterStart,
            ) { Text("ToggleButtons:") }
            ToggleSet(enabled = true)
            ToggleSet(enabled = false)
            // Flutter `Divider(height: 2 * kWrapSpacing)` ⇒ a horizontal rule
            // that reserves 2*20=40dp of total height (the line itself is
            // centered inside that band).
            HorizontalDivider(modifier = Modifier.padding(vertical = WrapSpacing.dp))
        }
        Box(modifier = Modifier.padding(bottom = 10.dp)) {
            YaruInfoBox(
                type = YaruInfoType.Information,
                subtitle = {
                    Text(
                        "The following material Checks/Radios are only fallbacks, due to insufficient styling capabilities. Please use YaruCheckBox and YaruRadio instead.",
                    )
                },
            )
        }
        Row {
            Checkbox(checked = true, onCheckedChange = {})
            Checkbox(checked = false, onCheckedChange = {})
            Checkbox(checked = true, onCheckedChange = null, enabled = false)
            Checkbox(checked = false, onCheckedChange = null, enabled = false)
        }
        Row {
            RadioButton(selected = true, onClick = {})
            RadioButton(selected = false, onClick = {})
            RadioButton(selected = true, onClick = null, enabled = false)
            RadioButton(selected = false, onClick = null, enabled = false)
        }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Switch(checked = true, onCheckedChange = {})
            Switch(checked = false, onCheckedChange = {})
            Switch(checked = true, onCheckedChange = null, enabled = false)
            Switch(checked = false, onCheckedChange = null, enabled = false)
        }
    }
}

@Composable
private fun ToggleSet(enabled: Boolean) {
    SingleChoiceSegmentedButtonRow {
        listOf("Off", "Off", "Off").forEachIndexed { index, label ->
            SegmentedButton(
                selected = index == 0,
                onClick = {},
                enabled = enabled,
                shape = SegmentedButtonDefaults.itemShape(index = index, count = 3),
            ) { Text(label) }
        }
    }
}
