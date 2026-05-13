package sample.app.pages

import androidx.compose.runtime.Composable
import dev.nucleusframework.yarucompose.material3.themepage.MaterialThemeHomePage

/**
 * Mirrors the "Material Components, using Yaru Material Themes" entry from
 * `yaru.dart/example/lib/example_page_items.dart:355-361`. The actual showcase
 * (Scaffold + Drawer + NavigationRail/Bar + 5 sub-views) lives in
 * [`:yaru-material3`][MaterialThemeHomePage], so the sample only wires it in.
 */
@Composable
fun ThemePage() {
    MaterialThemeHomePage()
}
