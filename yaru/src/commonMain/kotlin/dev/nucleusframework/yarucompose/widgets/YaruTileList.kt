package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * A bordered, vertical list of widgets separated by [HorizontalDivider]s.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_tile_list.dart`. Use with
 * [YaruListTileSquare] children to share the outer border radius.
 */
@Composable
fun YaruTileList(
    children: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier,
) {
    YaruBorderContainer(modifier = modifier, clipContent = true) {
        Column {
            children.forEachIndexed { index, child ->
                if (index > 0) YaruHorizontalDivider()
                child()
            }
        }
    }
}
