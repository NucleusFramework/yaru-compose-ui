package dev.nucleusframework.yarucompose.material3.themepage.controls

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/controls/controls_view.dart`. */
@Composable
fun ControlsView(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    val tabs = listOf("Buttons", "Fabs", "Toggleables", "Chips", "Progress")
    var selected by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    Column(modifier = modifier) {
        PrimaryTabRow(selectedTabIndex = selected) {
            tabs.forEachIndexed { index, label ->
                Tab(
                    selected = index == selected,
                    onClick = { selected = index },
                    text = { Text(label) },
                )
            }
        }
        val padded = Modifier.padding(20.dp)
        when (selected) {
            0 -> Buttons(padded)
            1 -> Fabs(
                onPressed = {
                    scope.launch {
                        snackbarHostState.showSnackbar(message = "Yay! ❤️ for Yaru", actionLabel = "Ok")
                    }
                },
                modifier = padded,
            )
            2 -> Toggleables(padded)
            3 -> Chips(padded)
            4 -> Progress(padded)
        }
    }
}
