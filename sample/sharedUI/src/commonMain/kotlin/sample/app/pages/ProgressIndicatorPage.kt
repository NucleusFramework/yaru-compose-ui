package sample.app.pages

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruLinearProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot

/**
 * Mirrors `yaru.dart/example/lib/pages/progress_indicator_page.dart`.
 *
 * Dart renders four items: indeterminate circular, circular at 0.75,
 * indeterminate linear, linear at 0.75 — each wrapped with `top: 25` padding
 * inside a `ListView`.
 *
 * Each indicator gets its own `Box` parent — this guarantees the lazy item
 * has bounded height even when the indicator's intrinsic measurement is
 * zero (e.g. the indeterminate circular at `Animatable = 0` on first frame).
 * Without the wrapper, items above measured at 0dp and the page rendered as
 * an empty viewport.
 */
@Composable
fun ProgressIndicatorPage() {
    val scrollState = rememberLazyListState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
        ) {
            // `YaruCircularProgressIndicator()` (progress_indicator_page.dart:17).
            item {
                YaruCircularProgressIndicator(modifier = Modifier.padding(top = 25.dp))
            }
            // `YaruCircularProgressIndicator(value: .75)` (progress_indicator_page.dart:21).
            item {
                YaruCircularProgressIndicator(
                    progress = 0.75f,
                    modifier = Modifier.padding(top = 25.dp),
                )
            }
            // `YaruLinearProgressIndicator()` (progress_indicator_page.dart:25).
            item {
                YaruLinearProgressIndicator(modifier = Modifier.padding(top = 25.dp))
            }
            // `YaruLinearProgressIndicator(value: .75)` (progress_indicator_page.dart:29).
            item {
                YaruLinearProgressIndicator(
                    progress = 0.75f,
                    modifier = Modifier.padding(top = 25.dp),
                )
            }
        }
    }
}
