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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.material3.themepage.WrapPadding
import dev.nucleusframework.yarucompose.material3.themepage.WrapSpacing
import dev.nucleusframework.yarucompose.widgets.YaruInfoBox
import dev.nucleusframework.yarucompose.widgets.YaruInfoType

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/progres.dart`. */
@Composable
fun Progress(modifier: Modifier = Modifier) {
    var level by remember { mutableFloatStateOf(1f) }
    val width = 300.dp

    Column(modifier = modifier.padding(WrapPadding.dp)) {
        Slider(
            value = level,
            onValueChange = { level = it },
            valueRange = 0f..1f,
            modifier = Modifier.width(width),
        )
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
