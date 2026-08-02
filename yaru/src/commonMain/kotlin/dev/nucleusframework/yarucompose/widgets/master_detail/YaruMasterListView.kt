package dev.nucleusframework.yarucompose.widgets.master_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruScrollbar

/**
 * The vertical list of master tiles inside `YaruMasterDetailPage`.
 *
 * Mirrors `yaru.dart/lib/src/widgets/master_detail/yaru_master_list_view.dart`,
 * which wraps the underlying scroll view in `YaruScrollViewUndershoot` so the
 * top/bottom edges fade subtly when the list is scrollable past the viewport.
 *
 * Geometry (from `YaruMasterDetailThemeData.fallback` in
 * `yaru_master_detail_theme.dart:29-30`):
 *  - `listPadding: EdgeInsets.symmetric(vertical: 8)`
 *  - `tileSpacing: 2`
 *
 * The default [state] is `rememberLazyListState()`, kept stable across
 * recompositions so changing the selected index does not jump the scroll
 * offset — matches Dart's instance `ScrollController` in `_YaruMasterListViewState`.
 *
 * API note — `availableWidth`: the Dart `YaruMasterTileBuilder`
 * (`yaru_master_detail_page.dart:13-19`) receives the pane width so callers can
 * adapt the tile layout. We deliberately omit it here: Compose tiles can read
 * the laid-out width directly via `Modifier.fillMaxWidth()` /
 * `BoxWithConstraints` at the call site, which keeps `tileBuilder` signatures
 * across [YaruMasterDetailPage], [YaruPortraitLayout] and [YaruLandscapeLayout]
 * compact. If a tile needs the value explicitly, wrap it in `BoxWithConstraints`.
 */
@Composable
fun YaruMasterListView(
    length: Int,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    startUndershoot: Boolean = true,
    endUndershoot: Boolean = true,
    tile: @Composable (index: Int) -> Unit,
) {
    YaruScrollViewUndershoot(
        scrollableState = state,
        modifier = modifier,
        showStart = startUndershoot,
        showEnd = endUndershoot,
    ) {
        // Mirrors Flutter's default `ScrollBehavior` adding a `Scrollbar`
        // around scrollables on desktop/web — Yaru's
        // `ScrollbarThemeData` (common_themes.dart:783-793) supplies the
        // 4dp/8dp thickness map that `YaruScrollbar` reproduces here.
        YaruScrollbar(state = state) {
            LazyColumn(
                state = state,
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                // Defensive: `LazyListScope.items(count)` throws when count < 0.
                items(count = length.coerceAtLeast(0)) { index -> tile(index) }
            }
        }
    }
}
