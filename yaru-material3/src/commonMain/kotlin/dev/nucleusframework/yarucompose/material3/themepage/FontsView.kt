package dev.nucleusframework.yarucompose.material3.themepage

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/fonts/fonts_view.dart`. */
@Composable
fun FontsView(modifier: Modifier = Modifier) {
    val t = MaterialTheme.typography
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(WrapSpacing.dp),
    ) {
        item { Text("displayLarge", style = t.displayLarge) }
        item { Text("displayMedium", style = t.displayMedium) }
        item { Text("displaySmall", style = t.displaySmall) }
        item { Text("headlineLarge", style = t.headlineLarge) }
        item { Text("headlineMedium", style = t.headlineMedium) }
        item { Text("headlineSmall", style = t.headlineSmall) }
        item { Text("titleLarge", style = t.titleLarge) }
        item { Text("titleMedium", style = t.titleMedium) }
        item { Text("titleSmall", style = t.titleSmall) }
        item { Text("bodyLarge", style = t.bodyLarge) }
        item { Text("bodyMedium", style = t.bodyMedium) }
        item { Text("bodySmall", style = t.bodySmall) }
        item { Text("labelLarge", style = t.labelLarge) }
        item { Text("labelMedium", style = t.labelMedium) }
        item { Text("labelSmall", style = t.labelSmall) }
    }
}
