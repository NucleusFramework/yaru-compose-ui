package dev.nucleusframework.yarucompose.material3.themepage.controls

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.material3.themepage.WrapPadding
import dev.nucleusframework.yarucompose.material3.themepage.WrapSpacing
import dev.nucleusframework.yarucompose.widgets.YaruInfoBox
import dev.nucleusframework.yarucompose.widgets.YaruInfoType

/**
 * Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/progres.dart`.
 *
 * Flutter `Column` defaults to `CrossAxisAlignment.center`; Compose defaults
 * to `Alignment.Start`. The original centers the slider, divider, info box,
 * and the inner indicator wrap, so we set `horizontalAlignment = CenterHorizontally`.
 */
@Composable
fun Progress(modifier: Modifier = Modifier) {
    var level by remember { mutableFloatStateOf(1f) }
    val width = 300.dp

    Column(
        modifier = modifier.padding(WrapPadding.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Slider(
            value = level,
            onValueChange = { level = it },
            valueRange = 0f..1f,
            modifier = Modifier.width(width),
        )
        // Flutter `Divider(height: 2 * kWrapSpacing)` — the rule sits inside
        // a 40dp band; padding vertical 20dp gives the same total height.
        HorizontalDivider(modifier = Modifier.padding(vertical = WrapSpacing.dp))
        YaruInfoBox(
            type = YaruInfoType.Information,
            subtitle = {
                Text(
                    "The following material progress indicators are only fallbacks, due to insufficient styling capabilities. Please use YaruLinearProgressIndicator and YaruCircularProgressIndicator instead!",
                )
            },
        )
        Spacer(Modifier.height(20.dp))
        // Flutter `Wrap(direction: Axis.vertical, crossAxisAlignment: center,
        // verticalDirection: down)`: items flow top-to-bottom and overflow
        // into the next column when vertical space runs out. `FlowColumn` is
        // the Compose equivalent; the alignments below mirror the Flutter
        // `crossAxisAlignment: center` (children centered horizontally
        // within each column).
        FlowColumn(
            verticalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
            horizontalArrangement = Arrangement.spacedBy(WrapSpacing.dp),
        ) {
            LinearProgressIndicator(progress = { level }, modifier = Modifier.width(width))
            CircularProgressIndicator(progress = { level })
            LinearProgressIndicator(modifier = Modifier.width(width))
            CircularProgressIndicator()
        }
    }
}
