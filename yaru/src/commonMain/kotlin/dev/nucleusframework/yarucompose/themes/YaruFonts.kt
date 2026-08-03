package dev.nucleusframework.yarucompose.themes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import dev.nucleusframework.yarucompose.generated.resources.Res
import dev.nucleusframework.yarucompose.generated.resources.ubuntu_bold
import dev.nucleusframework.yarucompose.generated.resources.ubuntu_light
import dev.nucleusframework.yarucompose.generated.resources.ubuntu_medium
import dev.nucleusframework.yarucompose.generated.resources.ubuntu_regular
import dev.nucleusframework.yarucompose.generated.resources.yaru_icons

/**
 * Builds the Ubuntu [FontFamily] from the bundled TTF assets.
 *
 * Mirrors the `fontFamily: 'Ubuntu'` declaration in
 * `yaru.dart/lib/src/themes/text_theme.dart`.
 */
@Composable
internal fun rememberUbuntuFontFamily(): FontFamily {
    // Defensive: `Font(...)` is @Composable so it can't be invoked inside `remember { }`. Resolve the four faces at composable scope, then memoise the FontFamily aggregation so recompositions reuse the same instance and the font-resolver cache stays warm.
    val light = Font(Res.font.ubuntu_light, weight = FontWeight.Light)
    val regular = Font(Res.font.ubuntu_regular, weight = FontWeight.Normal)
    val medium = Font(Res.font.ubuntu_medium, weight = FontWeight.Medium)
    val bold = Font(Res.font.ubuntu_bold, weight = FontWeight.Bold)
    return remember(light, regular, medium, bold) {
        FontFamily(light, regular, medium, bold)
    }
}

/**
 * Builds the YaruIcons [FontFamily] from the bundled OTF, used to render
 * the 845 glyphs declared in [dev.nucleusframework.yarucompose.icons.YaruIcons].
 */
@Composable
internal fun rememberYaruIconFontFamily(): FontFamily {
    // Defensive: same pattern as Ubuntu family — Font(...) is @Composable, so resolve the face first then memoise the FontFamily wrapper.
    val face = Font(Res.font.yaru_icons, weight = FontWeight.Normal)
    return remember(face) { FontFamily(face) }
}

/**
 * Composition-local providing the font family used by [YaruIcon] when no
 * `fontFamily` parameter is passed at the call site.
 */
val LocalYaruIconFont = staticCompositionLocalOf<FontFamily> { FontFamily.Default }
