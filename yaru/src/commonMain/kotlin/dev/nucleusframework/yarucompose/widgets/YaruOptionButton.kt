package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.YaruConstants

/** Variant of [YaruOptionButton]. */
enum class YaruOptionButtonType { Normal, Color }

/**
 * Square outlined option button — typically used inside title bars.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_option_button.dart`. Foundation-only
 * thanks to [YaruButton]; size is fixed to `kYaruTitleBarItemHeight × kYaruTitleBarItemHeight`.
 *
 * When [hasFocusBorder] is `null`, falls back to the inherited
 * `LocalYaruTheme.focusBorders` (default `true`), matching the Dart
 * `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`.
 */
@Composable
fun YaruOptionButton(
    onPressed: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    // Dart `_styleFrom(padding: EdgeInsets.zero)` for `YaruOptionButtonType.normal`.
    contentPadding: PaddingValues = PaddingValues(0.dp),
    hasFocusBorder: Boolean? = null,
    content: @Composable () -> Unit,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val button: @Composable (Modifier) -> Unit = { m ->
        YaruButton(
            onClick = onPressed ?: {},
            // `fixedSize: Size.square(kYaruTitleBarItemHeight)` (= 34dp) from Dart.
            modifier = m.size(YaruConstants.TitleBarItemHeight),
            enabled = enabled && onPressed != null,
            variant = YaruButtonVariant.Outlined,
            contentPadding = contentPadding,
            content = content,
        )
    }
    if (showFocusBorder) {
        // Dart wraps the button in `YaruFocusBorder.primary(child: button)`.
        YaruFocusBorder(modifier = modifier) { button(Modifier) }
    } else {
        button(modifier)
    }
}

/** Color-swatch variant. */
@Composable
fun YaruColorOptionButton(
    color: Color,
    onPressed: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    hasFocusBorder: Boolean? = null,
) {
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    // Defensive: `Modifier.background` rejects colors with non-finite channels
    // (e.g. `Color.Unspecified`, NaN alpha from a stale animation).
    val safeColor = sanitiseColor(color)
    val button: @Composable (Modifier) -> Unit = { m ->
        YaruButton(
            onClick = onPressed ?: {},
            modifier = m.size(YaruConstants.TitleBarItemHeight),
            enabled = enabled && onPressed != null,
            variant = YaruButtonVariant.Outlined,
            // `EdgeInsets.all(10)` from `YaruOptionButton.color` in Dart.
            contentPadding = PaddingValues(10.dp),
        ) {
            // Disk fills `SizedBox.expand` inside the 34dp fixed-size button minus
            // 10dp padding on each side: 34 - 2*10 = 14dp diameter.
            Box(
                modifier = Modifier
                    .size(YaruConstants.TitleBarItemHeight - 20.dp)
                    .background(color = safeColor, shape = CircleShape),
            )
        }
    }
    if (showFocusBorder) {
        YaruFocusBorder(modifier = modifier) { button(Modifier) }
    } else {
        button(modifier)
    }
}
