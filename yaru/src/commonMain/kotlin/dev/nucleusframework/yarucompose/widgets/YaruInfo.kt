package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColors
import dev.nucleusframework.yarucompose.themes.YaruConstants

/** Severity / sentiment of a [YaruInfoBadge] / [YaruInfoBox]. */
enum class YaruInfoType {
    Information,
    Success,
    Important,
    Warning,
    Danger;

    /** Return the canonical color for [this] type, resolved against the active theme. */
    @Composable
    fun color(): Color {
        val isDark = LocalYaruColorScheme.current.isDark
        val palette = YaruColors.from(isDark)
        return when (this) {
            Information -> palette.link
            Success -> palette.success
            Important -> YaruColors.Purple
            Warning -> palette.warning
            Danger -> palette.error
        }
    }

    /** Yaru-glyph mirroring `YaruInfoType.iconData` from yaru.dart. */
    val icon: Char
        get() = when (this) {
            Information -> YaruIcons.information
            Success -> YaruIcons.ok
            Important -> YaruIcons.important
            Warning -> YaruIcons.warning
            Danger -> YaruIcons.error
        }
}

/**
 * A small pill containing a [title] tinted by the [type].
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_info.dart` `YaruInfoBadge`.
 */
@Composable
fun YaruInfoBadge(
    type: YaruInfoType,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    color: Color? = null,
    style: TextStyle? = null,
    shape: Shape = RoundedCornerShape(20.dp),
    contentPadding: PaddingValues = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
) {
    // Sanitise caller-supplied / theme-resolved color once: `YaruTranslucentContainer`
    // is self-defending, but normalising here keeps `YaruInfoBadge` consistent
    // with `YaruInfoBox` and guards any future propagation paths (e.g. content
    // tinting) from a `Color.Unspecified` / NaN-channel input.
    val baseColor = sanitiseColor(color ?: type.color())
    val typography = LocalYaruTypography.current
    YaruTranslucentContainer(
        color = baseColor,
        modifier = modifier,
        shape = shape,
        padding = contentPadding,
    ) {
        CompositionLocalProvider(
            LocalYaruTextStyle provides (style ?: typography.bodySmall),
        ) {
            title()
        }
    }
}

/**
 * Larger informational tile (icon + title + body).
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_info.dart` `YaruInfoBox`.
 */
@Composable
fun YaruInfoBox(
    type: YaruInfoType,
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    subtitle: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    color: Color? = null,
    titleTextStyle: TextStyle? = null,
    subtitleTextStyle: TextStyle? = null,
    shape: Shape = RoundedCornerShape(YaruConstants.ContainerRadius),
    content: (@Composable () -> Unit)? = null,
) {
    // Dart line 101-104: `assert((subtitle != null) ^ (child != null), 'Either a subtitle or a child must be provided')`
    // — exactly one of the two must be supplied.
    require((subtitle != null) xor (content != null)) {
        "Either a subtitle or a content must be provided"
    }
    // Sanitise once here: `baseColor` is forwarded to `YaruTranslucentContainer`
    // (already self-defending) AND propagated through `LocalYaruContentColor` /
    // `YaruIcon.tint`. Without this guard a caller-supplied `Color.Unspecified`
    // (or an animated NaN channel) would leak into the icon tint and crash
    // `Modifier.background` / glyph painting downstream.
    val baseColor = sanitiseColor(color ?: type.color())
    val typography = LocalYaruTypography.current
    YaruTranslucentContainer(
        color = baseColor,
        modifier = modifier,
        shape = shape,
        padding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Column(verticalArrangement = Arrangement.Top) {
                // Mirror Dart's `IconTheme(size: 24, color: baseColor)` wrapping:
                // user-supplied icons inherit `baseColor` via `LocalYaruContentColor`.
                CompositionLocalProvider(LocalYaruContentColor provides baseColor) {
                    if (icon != null) {
                        icon()
                    } else {
                        YaruIcon(glyph = type.icon, size = 24.dp, tint = baseColor)
                    }
                }
            }
            Spacer(Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                if (title != null) {
                    CompositionLocalProvider(
                        LocalYaruTextStyle provides (
                            titleTextStyle ?: typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                            ),
                    ) {
                        title()
                    }
                }
                when {
                    content != null -> content()
                    subtitle != null -> CompositionLocalProvider(
                        LocalYaruTextStyle provides (
                            subtitleTextStyle ?: typography.bodyMedium
                            ),
                    ) {
                        subtitle()
                    }
                }
            }
            if (trailing != null) {
                Spacer(Modifier.width(8.dp))
                trailing()
            }
        }
    }
}
