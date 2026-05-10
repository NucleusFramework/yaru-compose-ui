package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.scale

/**
 * Yaru-flavoured text field — foundation-only `BasicTextField` wrapper with a
 * filled or outlined decoration matching `_createInputDecorationTheme` from
 * `yaru.dart/lib/src/themes/common_themes.dart`.
 *
 *  - radius: `kYaruButtonRadius` (8 dp)
 *  - border width unfocused: 1 px / focused: `kYaruFocusBorderWidth` (2 dp)
 *  - content padding: `EdgeInsets.only(left: 12, right: 12, bottom: 9, top: 10)`
 *  - filled variant background: `surface.scale(lightness = if light -0.05 else -0.1)`
 */
@Composable
fun YaruTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    filled: Boolean = true,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    val focused by interactionSource.collectIsFocusedAsState()
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    val isLight = !scheme.isDark
    val fillColor = scheme.surface.scale(lightness = if (isLight) -0.05f else -0.1f)
    // Mirrors `_createInputDecorationTheme` border resolution from
    // `yaru.dart/lib/src/themes/common_themes.dart`:
    //   - default: `outline` (non-HC) / `outlineVariant` (HC) at width 1
    //   - focused: `primary` at `kYaruFocusBorderWidth = 2`
    //   - error: `error` at width 1, focusedErrorBorder = `error` at width 2
    //   - disabled: default border with 0.6 alpha
    val baseBorder = if (scheme.isHighContrast) scheme.outlineVariant else scheme.outline
    val borderColor = when {
        !enabled -> baseBorder.copy(alpha = 0.6f)
        isError -> scheme.error
        focused -> scheme.primary
        else -> baseBorder
    }
    val borderWidth = if (focused) YaruConstants.FocusBorderWidth else 1.dp
    // Defensive: dim the text/cursor color when disabled — Material's InputDecoration disabled foreground is `onSurface @ 0.38` (yaru.dart inherits this default).
    val resolvedTextColor = if (enabled) scheme.onSurface else scheme.onSurface.copy(alpha = 0.38f)
    val textStyle = typography.bodyMedium.copy(color = resolvedTextColor)
    // Defensive: also dim the placeholder so a disabled empty field reads as inactive instead of showing a full-strength hint.
    val placeholderColor = if (enabled) scheme.onSurface.copy(alpha = 0.6f) else scheme.onSurface.copy(alpha = 0.38f)

    Row(
        modifier = modifier
            .background(
                color = if (filled) fillColor else Color.Transparent,
                shape = shape,
            )
            .border(width = borderWidth, color = borderColor, shape = shape)
            .defaultMinSize(minHeight = YaruConstants.ButtonHeight)
            .padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leading != null) {
            leading()
            Spacer(Modifier.width(8.dp))
        }
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                singleLine = singleLine,
                textStyle = textStyle,
                cursorBrush = SolidColor(resolvedTextColor),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
            )
            if (value.isEmpty() && placeholder != null) {
                CompositionLocalProvider(
                    dev.nucleusframework.yarucompose.themes.LocalYaruContentColor provides placeholderColor,
                ) {
                    placeholder()
                }
            }
        }
        if (trailing != null) {
            Spacer(Modifier.width(8.dp))
            trailing()
        }
    }
}

/** [TextFieldValue]-based overload — useful when the caller manages selection. */
@Composable
fun YaruTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    filled: Boolean = true,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    val focused by interactionSource.collectIsFocusedAsState()
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    val isLight = !scheme.isDark
    val fillColor = scheme.surface.scale(lightness = if (isLight) -0.05f else -0.1f)
    // Mirrors `_createInputDecorationTheme` border resolution — see the String
    // overload above for details.
    val baseBorder = if (scheme.isHighContrast) scheme.outlineVariant else scheme.outline
    val borderColor = when {
        !enabled -> baseBorder.copy(alpha = 0.6f)
        isError -> scheme.error
        focused -> scheme.primary
        else -> baseBorder
    }
    val borderWidth = if (focused) YaruConstants.FocusBorderWidth else 1.dp
    // Defensive: dim the text/cursor color when disabled — Material's InputDecoration disabled foreground is `onSurface @ 0.38` (yaru.dart inherits this default).
    val resolvedTextColor = if (enabled) scheme.onSurface else scheme.onSurface.copy(alpha = 0.38f)
    val textStyle: TextStyle = typography.bodyMedium.copy(color = resolvedTextColor)
    // Defensive: also dim the placeholder so a disabled empty field reads as inactive instead of showing a full-strength hint.
    val placeholderColor = if (enabled) scheme.onSurface.copy(alpha = 0.6f) else scheme.onSurface.copy(alpha = 0.38f)

    Row(
        modifier = modifier
            .background(
                color = if (filled) fillColor else Color.Transparent,
                shape = shape,
            )
            .border(width = borderWidth, color = borderColor, shape = shape)
            .defaultMinSize(minHeight = YaruConstants.ButtonHeight)
            .padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leading != null) {
            leading()
            Spacer(Modifier.width(8.dp))
        }
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                singleLine = singleLine,
                textStyle = textStyle,
                cursorBrush = SolidColor(resolvedTextColor),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
            )
            if (value.text.isEmpty() && placeholder != null) {
                CompositionLocalProvider(
                    dev.nucleusframework.yarucompose.themes.LocalYaruContentColor provides placeholderColor,
                ) {
                    placeholder()
                }
            }
        }
        if (trailing != null) {
            Spacer(Modifier.width(8.dp))
            trailing()
        }
    }
}

/** Convenience: `YaruTextField(filled = false)`. */
@Composable
fun YaruOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) = YaruTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier,
    enabled = enabled,
    readOnly = readOnly,
    placeholder = placeholder,
    leading = leading,
    trailing = trailing,
    isError = isError,
    filled = false,
    singleLine = singleLine,
    visualTransformation = visualTransformation,
    keyboardOptions = keyboardOptions,
    keyboardActions = keyboardActions,
)

