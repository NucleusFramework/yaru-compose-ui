package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.widgets.YaruAutocomplete

/**
 * Mirrors `yaru.dart/example/lib/pages/autocomplete_page.dart`.
 *
 * The Dart sample is a single centered `YaruAutocomplete<String>` of width 200
 * with a fixed list of five options. We render the same demo verbatim — the
 * Dart `onSelected` shows a snackbar via `ScaffoldMessenger`, which has no
 * commonMain equivalent, so the callback is a no-op here.
 */
@Composable
fun AutocompletePage() {
    // `const options = ['foo', 'bar', 'baz', 'qux', 'quux']` (autocomplete_page.dart:14).
    val options = remember { listOf("foo", "bar", "baz", "qux", "quux") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        // `SizedBox(width: 200, child: YaruAutocomplete<String>(...))` (autocomplete_page.dart:10-21).
        YaruAutocomplete(
            modifier = Modifier.width(200.dp),
            optionsBuilder = { query ->
                options.filter { it.contains(query.lowercase()) }
            },
            onSelected = { /* Dart shows a SnackBar; no commonMain equivalent. */ },
        )
    }
}
