package dev.nucleusframework.yarucompose.iconsextended

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * Renders a full-colour icon from the bundled Yaru icon theme.
 *
 * Unlike [dev.nucleusframework.yarucompose.icons.YaruIcon] (a monochrome glyph
 * from the Yaru icon font), these are true-colour vector icons converted
 * from the `ubuntu/yaru` icon theme's own SVG sources — the same icons the
 * upstream `yaru.dart` demo fetches as PNGs over the network. Here they are
 * plain Kotlin [ImageVector]s, one per file (see the `vector` sub-package),
 * so no network access is required at runtime, and icons you never
 * reference are eliminated from the final binary by ordinary dead-code
 * elimination (R8/D8, Kotlin/JS and Kotlin/Native DCE) — same as any other
 * unused function.
 *
 * Pass an entry from [YaruFullColorIcons], e.g.
 * `YaruFullColorIcon(YaruFullColorIcons.document_new)`.
 */
@Composable
fun YaruFullColorIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    size: Dp = YaruConstants.IconSize,
    contentDescription: String? = null,
) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier.size(size),
    )
}
