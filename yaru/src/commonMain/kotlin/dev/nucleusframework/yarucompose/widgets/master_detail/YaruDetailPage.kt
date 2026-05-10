package dev.nucleusframework.yarucompose.widgets.master_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme

/**
 * Recommended layout for `YaruMasterDetailPage.pageBuilder`.
 *
 * Mirrors `yaru.dart/lib/src/widgets/master_detail/yaru_detail_page.dart`.
 * The Dart version wraps `appBar` in a Hero so it persists across page
 * transitions; Compose Multiplatform does not ship a stable Hero primitive in
 * commonMain, so this port simply lays out [appBar] above [body].
 */
@Composable
fun YaruDetailPage(
    modifier: Modifier = Modifier,
    appBar: @Composable (() -> Unit)? = null,
    floatingActionButton: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    backgroundColor: Color = LocalYaruColorScheme.current.surface,
    body: @Composable () -> Unit,
) {
    // Defensive: `Modifier.background` rejects colors with non-finite channels
    // (e.g. `Color.Unspecified` / NaN alpha from a stale animation).
    val safeBackgroundColor = sanitiseColor(backgroundColor)
    Box(modifier = modifier.fillMaxSize().background(safeBackgroundColor)) {
        Column(modifier = Modifier.fillMaxSize()) {
            if (appBar != null) {
                Box(modifier = Modifier.fillMaxWidth()) { appBar() }
            }
            Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                body()
            }
            if (bottomBar != null) {
                Box(modifier = Modifier.fillMaxWidth()) { bottomBar() }
            }
        }
        if (floatingActionButton != null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd,
            ) {
                floatingActionButton()
            }
        }
    }
}
