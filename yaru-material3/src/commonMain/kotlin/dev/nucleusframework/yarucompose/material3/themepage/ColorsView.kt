package dev.nucleusframework.yarucompose.material3.themepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruColors
import dev.nucleusframework.yarucompose.themes.link
import dev.nucleusframework.yarucompose.themes.success
import dev.nucleusframework.yarucompose.themes.warning

/** Mirrors `yaru.dart/example/lib/pages/theme_page/src/colors/colors_view.dart`. */
@Composable
fun ColorsView(modifier: Modifier = Modifier) {
    val scheme = LocalYaruColorScheme.current
    val sections = listOf(
        "Theme Accent Colors" to accentColors(scheme),
        "Theme Base Colors" to baseColors(scheme),
        "Theme Special Colors" to specialColors(scheme),
        "Primary Color Yaru Variations" to yaruPrimaryColors(scheme),
        "Ubuntu Flavor Colors" to ubuntuFlavourColors(scheme),
        "Extension Colors" to extensionColors(scheme),
    )

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(15.dp),
    ) {
        sections.forEach { (headline, colors) ->
            item {
                Text(
                    headline,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 20.dp, start = 5.dp),
                )
            }
            item {
                val rows = (colors.size + 2) / 3
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 300.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.fillMaxWidth().height(60.dp * rows),
                ) {
                    items(colors.size) { index ->
                        val (name, pair) = colors.entries.elementAt(index)
                        ColorSwatch(name, pair.first, pair.second)
                    }
                }
            }
            item { HorizontalDivider(modifier = Modifier.padding(top = 30.dp, bottom = 20.dp)) }
        }
    }
}

private fun androidx.compose.foundation.lazy.grid.LazyGridScope.items(
    count: Int,
    itemContent: @Composable (Int) -> Unit,
) {
    items(count = count) { itemContent(it) }
}

@Composable
private fun ColorSwatch(name: String, background: Color, foreground: Color?) {
    val resolvedFg = foreground ?: localContrastColor(background)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(background),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(name, style = TextStyle(color = resolvedFg, fontSize = 11.sp))
            Text(background.toHexString(), style = TextStyle(color = resolvedFg, fontSize = 8.sp))
        }
    }
}

private fun localContrastColor(background: Color): Color =
    if (background.luminance() > 0.5f) Color.Black else Color.White

private fun Color.toHexString(): String {
    val a = (alpha * 255).toInt().toString(16).padStart(2, '0')
    val r = (red * 255).toInt().toString(16).padStart(2, '0')
    val g = (green * 255).toInt().toString(16).padStart(2, '0')
    val b = (blue * 255).toInt().toString(16).padStart(2, '0')
    return "#$a$r$g$b".uppercase()
}

private fun accentColors(s: YaruColorScheme): Map<String, Pair<Color, Color?>> = linkedMapOf(
    "primary" to (s.primary to s.onPrimary),
    "onPrimary" to (s.onPrimary to null),
    "inversePrimary" to (s.inversePrimary to null),
    "primaryContainer" to (s.primaryContainer to s.onPrimaryContainer),
    "onPrimaryContainer" to (s.onPrimaryContainer to null),
    "secondary" to (s.secondary to s.onSecondary),
    "onSecondary" to (s.onSecondary to null),
    "secondaryContainer" to (s.secondaryContainer to s.onSecondaryContainer),
    "onSecondaryContainer" to (s.onSecondaryContainer to null),
    "tertiary" to (s.tertiary to s.onTertiary),
    "onTertiary" to (s.onTertiary to null),
    "tertiaryContainer" to (s.tertiaryContainer to s.onTertiaryContainer),
    "onTertiaryContainer" to (s.onTertiaryContainer to null),
)

private fun baseColors(s: YaruColorScheme): Map<String, Pair<Color, Color?>> = linkedMapOf(
    "background" to (s.surface to s.onSurface),
    "onBackground" to (s.onSurface to null),
    "surface" to (s.surface to s.onSurface),
    "onSurface" to (s.onSurface to null),
    "surfaceTint" to (s.surfaceTint to null),
    "surfaceVariant" to (s.surfaceVariant to s.onSurfaceVariant),
    "onSurfaceVariant" to (s.onSurfaceVariant to null),
    "inverseSurface" to (s.inverseSurface to s.inverseOnSurface),
    "onInverseSurface" to (s.inverseOnSurface to null),
)

private fun specialColors(s: YaruColorScheme): Map<String, Pair<Color, Color?>> = linkedMapOf(
    "error" to (s.error to s.onError),
    "onError" to (s.onError to null),
    "scrim" to (s.scrim to null),
)

private fun yaruPrimaryColors(s: YaruColorScheme): Map<String, Pair<Color, Color?>> = linkedMapOf(
    "orange" to (YaruColors.Orange to s.onPrimary),
    "olive" to (YaruColors.Olive to s.onPrimary),
    "viridian" to (YaruColors.Viridian to s.onPrimary),
    "purple" to (YaruColors.Purple to s.onPrimary),
    "red" to (YaruColors.Red to s.onPrimary),
    "blue" to (YaruColors.Blue to s.onPrimary),
    "magenta" to (YaruColors.Magenta to s.onPrimary),
    "sage" to (YaruColors.Sage to s.onPrimary),
    "prussianGreen" to (YaruColors.PrussianGreen to s.onPrimary),
    "bark" to (YaruColors.Bark to s.onPrimary),
)

private fun ubuntuFlavourColors(s: YaruColorScheme): Map<String, Pair<Color, Color?>> = linkedMapOf(
    "kubuntuBlue" to (YaruColors.KubuntuBlue to s.onPrimary),
    "lubuntuBlue" to (YaruColors.LubuntuBlue to s.onPrimary),
    "ubuntuBudgieBlue" to (YaruColors.UbuntuBudgieBlue to s.onPrimary),
    "ubuntuButterflyPink" to (YaruColors.UbuntuButterflyPink to s.onPrimary),
    "ubuntuCinnamonBrown" to (YaruColors.UbuntuCinnamonBrown to s.onPrimary),
    "ubuntuMateGreen" to (YaruColors.UbuntuMateGreen to s.onPrimary),
    "ubuntuStudioBlue" to (YaruColors.UbuntuStudioBlue to s.onPrimary),
    "ubuntuUnityPurple" to (YaruColors.UbuntuUnityPurple to s.onPrimary),
    "xubuntuBlue" to (YaruColors.XubuntuBlue to s.onPrimary),
)

private fun extensionColors(s: YaruColorScheme): Map<String, Pair<Color, Color?>> = linkedMapOf(
    "success" to (s.success to localContrastColor(s.success)),
    "warning" to (s.warning to localContrastColor(s.warning)),
    "link" to (s.link to localContrastColor(s.link)),
)
