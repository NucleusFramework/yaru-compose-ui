package dev.nucleusframework.yarucompose.material3.themepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons

private val ContainerIcons = listOf(
    YaruIcons.address_book,
    YaruIcons.application_bag,
    YaruIcons.beaker,
    YaruIcons.calendar_important,
)

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/containers/containers_view.dart`. */
@Composable
fun ContainersView(modifier: Modifier = Modifier) {
    var elevation by remember { mutableFloatStateOf(2f) }
    var inDialog by remember { mutableStateOf(true) }
    val selected = remember { List(ContainerIcons.size) { false }.toMutableStateList() }

    val children: @Composable () -> Unit = {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = elevation.dp),
        ) {
            Box(
                modifier = Modifier.size(width = 200.dp, height = 150.dp),
                contentAlignment = Alignment.Center,
            ) { Text("Card") }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                ((elevation * 100).toInt() / 100.0).let { rounded ->
                    val whole = rounded.toInt()
                    val frac = ((rounded - whole) * 100).toInt().toString().padStart(2, '0')
                    "$whole.$frac"
                },
                modifier = Modifier.padding(start = 10.dp),
            )
            Slider(
                value = elevation,
                onValueChange = { elevation = it },
                valueRange = 0f..10f,
                modifier = Modifier.width(200.dp),
            )
        }
        Box(modifier = Modifier.padding(12.dp)) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        RoundedCornerShape(10.dp),
                    )
                    .padding(horizontal = 70.dp, vertical = 50.dp),
            ) { Text("Just a border") }
        }
        ContainerIcons.forEachIndexed { i, icon ->
            // Flutter `ListTile(selected: _selected[i], onTap: ...)` — selected
            // state toggles on each tap and highlights the row.
            val isSelected = selected[i]
            ListItem(
                headlineContent = { Text("ListTile title $i") },
                supportingContent = if (i % 2 == 0) null else { -> Text("Subtitle") },
                leadingContent = { YaruIcon(icon) },
                trailingContent = { Text("Trailing") },
                colors = if (isSelected) {
                    ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                        headlineColor = MaterialTheme.colorScheme.primary,
                        leadingIconColor = MaterialTheme.colorScheme.primary,
                        supportingColor = MaterialTheme.colorScheme.primary,
                        trailingIconColor = MaterialTheme.colorScheme.primary,
                    )
                } else {
                    ListItemDefaults.colors()
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { selected[i] = !selected[i] },
            )
        }
    }

    LazyColumn(
        modifier = modifier.width(400.dp),
        contentPadding = PaddingValues(0.dp),
    ) {
        item { Box(modifier = Modifier.height(WrapSpacing.dp)) {} }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Switch(checked = inDialog, onCheckedChange = { inDialog = it })
                Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Box(modifier = Modifier.height(40.dp)) { VerticalDivider() }
                }
                Text("Show in dialog")
            }
        }
        item { HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp)) }
        if (inDialog) {
            // Flutter renders `SimpleDialog` INLINE here (not via `showDialog`),
            // so it's not modal — it's a Material-styled card. Reproduce with
            // a `Surface` using the AlertDialog defaults. `SimpleDialog` wraps
            // its `children` in a `ListBody` which stacks them with no gap
            // (only its `contentPadding` of 20 wraps the whole stack).
            item {
                Surface(
                    shape = AlertDialogDefaults.shape,
                    color = AlertDialogDefaults.containerColor,
                    tonalElevation = AlertDialogDefaults.TonalElevation,
                ) {
                    Column(modifier = Modifier.padding(WrapSpacing.dp)) {
                        children()
                    }
                }
            }
        } else {
            // `...children` spreads them directly into the outer ListView, no
            // injected gap — replicate by inlining without `spacedBy`.
            item { Column { children() } }
        }
    }
}
