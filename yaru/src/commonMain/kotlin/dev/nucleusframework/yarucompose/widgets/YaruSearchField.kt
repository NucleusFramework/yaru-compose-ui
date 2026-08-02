package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.scale

/** Visual style of [YaruSearchField]. */
enum class YaruSearchFieldStyle { Filled, Outlined, FilledOutlined }

/**
 * A pill-shaped search text field — foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_search_field.dart`. Pressing
 * `Escape` clears the field. Renders its own filled / outlined decoration so
 * the pill radius (defaults to [height], i.e. fully rounded ends) is honored
 * regardless of [YaruTextField]'s 8 dp button radius.
 *
 * @param clearIconSemanticLabel API parity stub — preserved for source
 *   compatibility with `YaruSearchField` in yaru.dart but not yet wired into
 *   the foundation-only [YaruIconButton]. Will be honored once accessibility
 *   semantics land in the KMP port.
 */
@Composable
fun YaruSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onSubmitted: ((String) -> Unit)? = null,
    onClear: (() -> Unit)? = null,
    placeholder: String? = null,
    height: Dp = YaruConstants.TitleBarItemHeight,
    radius: Dp = height,
    contentPadding: PaddingValues = PaddingValues(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
    style: YaruSearchFieldStyle = YaruSearchFieldStyle.Filled,
    autoFocus: Boolean = true,
    fillColor: Color? = null,
    borderColor: Color? = null,
    leading: @Composable (() -> Unit)? = null,
    clearIcon: @Composable (() -> Unit)? = null,
    clearIconSemanticLabel: String? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    val isLight = !scheme.isDark
    // Mirrors Dart `theme.dividerColor` from common_themes.dart line 691:
    //   colorScheme.outline.scale(lightness: light ? 0.1 : -0.06)
    // Defensive: non-finite channels (e.g. `Color.Unspecified`) reach
    // `Modifier.background` / `Modifier.border` and crash Skia.
    val resolvedFill = sanitiseColor(
        fillColor ?: scheme.outline.scale(lightness = if (isLight) 0.1f else -0.06f),
    )
    val resolvedBorder = sanitiseColor(
        borderColor ?: scheme.outline.scale(lightness = if (isLight) -0.1f else 0.1f),
    )
    // Clamp caller-supplied dimensions via the canonical `Dp.sanitise()`
    // foundation helper — `RoundedCornerShape` and `Modifier.height` throw on
    // negatives, and a non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`
    // downstream.
    val safeHeight = height.sanitise()
    val safeRadius = radius.sanitise()
    val shape = RoundedCornerShape(safeRadius)
    // Defensive clamp: `Modifier.padding` throws on negative `Dp`. Mirrors
    // YaruWatermark/YaruTile/YaruDialog.
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)

    val focusRequester = remember { FocusRequester() }
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by interactionSource.collectIsFocusedAsState()

    // Single clear path — used by both Escape and the trailing icon so the two
    // can never drift. Mirrors `_clear()` in `yaru_search_field.dart` line 213:
    // `widget.onClear?.call(); _controller.clear();`.
    val clear: () -> Unit = {
        onClear?.invoke()
        onValueChange("")
        // Defensive: tapping the clear `YaruIconButton` shifts focus away from the text input (collapsing the IME); restore it so the user can keep typing.
        runCatching { focusRequester.requestFocus() }
    }

    // Mirrors `KeyboardListener` in `yaru_search_field.dart` line 156:
    // pressing Escape clears the field. Gate on KeyDown to avoid double-firing
    // on the matching KeyUp event.
    val keyHandler = Modifier.onKeyEvent { event ->
        if (event.type == KeyEventType.KeyDown && event.key == Key.Escape) {
            clear()
            true
        } else {
            false
        }
    }

    // Border width follows the same focus convention as `YaruTextField` /
    // `YaruSegmentedEntry`: 1 dp idle, `FocusBorderWidth` (2 dp) when focused.
    // Filled style keeps a borderless idle but still gains the focus ring.
    val baseBorderWidth = when (style) {
        YaruSearchFieldStyle.Filled -> 0.dp
        YaruSearchFieldStyle.Outlined,
        YaruSearchFieldStyle.FilledOutlined -> 1.dp
    }
    val borderWidth = if (focused) YaruConstants.FocusBorderWidth else baseBorderWidth
    val activeBorderColor = if (focused) scheme.primary else resolvedBorder
    val backgroundColor = when (style) {
        YaruSearchFieldStyle.Outlined -> Color.Transparent
        YaruSearchFieldStyle.Filled,
        YaruSearchFieldStyle.FilledOutlined -> resolvedFill
    }
    val textStyle = typography.bodyMedium.copy(color = scheme.onSurface)
    val placeholderColor = scheme.onSurface.copy(alpha = 0.6f)

    Box(
        modifier = modifier
            .height(safeHeight)
            .background(color = backgroundColor, shape = shape)
            .let { m ->
                if (borderWidth > 0.dp) m.border(borderWidth, activeBorderColor, shape) else m
            }
            .then(keyHandler),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            modifier = Modifier.padding(safeContentPadding),
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
                    singleLine = true,
                    textStyle = textStyle,
                    cursorBrush = SolidColor(scheme.onSurface),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { onSubmitted?.invoke(value) }),
                    interactionSource = interactionSource,
                    // Defensive: anchor the FocusRequester on the BasicTextField itself — autoFocus and post-clear refocus must target the input, not the surrounding decoration Box.
                    modifier = Modifier.focusRequester(focusRequester),
                )
                // Defensive: treat an empty placeholder as "absent" — otherwise we would spin up a Crossfade whose only payload is a no-text `YaruText`, allocating animation state for nothing.
                // Defensive: also reject whitespace-only placeholders — they render as invisible hints (a blank gap) while still costing a Crossfade.
                if (!placeholder.isNullOrBlank()) {
                    // Crossfade hint visibility on value/empty transitions so the
                    // placeholder fades rather than hard-cutting when the user
                    // starts (or finishes clearing) input.
                    Crossfade(
                        targetState = value.isEmpty(),
                        animationSpec = tween(durationMillis = 150),
                    ) { showHint ->
                        if (showHint) {
                            CompositionLocalProvider(LocalYaruContentColor provides placeholderColor) {
                                YaruText(placeholder)
                            }
                        }
                    }
                }
            }
            if (onClear != null && value.isNotEmpty()) {
                Spacer(Modifier.width(4.dp))
                // Mirrors `IconButton` in `yaru_search_field.dart` lines 192-206
                // — neither the button nor the glyph specifies a size, so both
                // inherit `IconButtonTheme.iconSize = kYaruIconSize` (20) from
                // `common_themes.dart:152`. Optional caller-provided
                // [clearIcon] overrides the default `edit_clear` glyph. Reuses
                // the shared [clear] lambda to stay in lockstep with the
                // Escape key handler.
                // Defensive: collapse an empty `clearIconSemanticLabel` to null so the inner button/icon do not get `contentDescription = ""`, which screen readers announce as an unnamed control.
                // Defensive: also collapse whitespace-only labels — they would be announced as silence by screen readers, defeating the accessibility hook.
                val resolvedClearLabel = clearIconSemanticLabel?.takeIf { it.isNotBlank() }
                YaruIconButton(
                    onPressed = clear,
                    iconSize = YaruConstants.IconSize,
                    // Defensive: forward `clearIconSemanticLabel` (was previously suppressed) so screen readers announce the clear action; only applies when the caller relies on the default glyph.
                    semanticLabel = resolvedClearLabel,
                    icon = clearIcon ?: {
                        YaruIcon(
                            glyph = YaruIcons.edit_clear,
                            size = YaruConstants.IconSize,
                            semanticLabel = resolvedClearLabel,
                        )
                    },
                )
            }
        }
    }

    if (autoFocus) {
        // Defensive: guard against IllegalStateException when the FocusRequester node has not yet attached (mirrors YaruSegmentedEntry pattern).
        LaunchedEffect(focusRequester) {
            runCatching { focusRequester.requestFocus() }
        }
    }
}

/**
 * A pre-styled search button using [YaruIconButton] — mirrors
 * `YaruSearchButton` from yaru.dart and is typically paired with
 * [YaruSearchField] in a title bar.
 *
 * @param semanticLabel API parity stub — preserved for source compatibility
 *   with `YaruSearchButton` in yaru.dart but not yet wired into the
 *   foundation-only [YaruIconButton]. Will be honored once accessibility
 *   semantics land in the KMP port.
 * @param selectedSemanticLabel API parity stub — preserved for source
 *   compatibility with `YaruSearchButton` in yaru.dart but not yet wired into
 *   the foundation-only [YaruIconButton]. Will be honored once accessibility
 *   semantics land in the KMP port.
 */
@Composable
fun YaruSearchButton(
    onPressed: (() -> Unit)?,
    modifier: Modifier = Modifier,
    isSelected: Boolean? = null,
    size: Dp = YaruConstants.TitleBarItemHeight,
    radius: Dp = size,
    style: YaruSearchFieldStyle = YaruSearchFieldStyle.Filled,
    borderColor: Color? = null,
    semanticLabel: String? = null,
    // Suppress: YaruIconButton has no selected-variant semantic slot; preserved for source compatibility with yaru.dart `YaruSearchButton.selectedSemanticLabel` until a selected-state semantics path is added.
    @Suppress("UNUSED_PARAMETER") selectedSemanticLabel: String? = null,
    icon: (@Composable () -> Unit)? = null,
    selectedIcon: (@Composable () -> Unit)? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val isLight = !scheme.isDark
    // Mirrors Dart `YaruSearchButton` lines 386-399:
    //   border drawn only when style != filled, color = borderColor
    //     ?? colorScheme.outline.scale(lightness: light ? -0.1 : 0.1)
    val resolvedBorder = sanitiseColor(
        borderColor ?: scheme.outline.scale(lightness = if (isLight) -0.1f else 0.1f),
    )
    // Clamp caller-supplied dimensions via the canonical `Dp.sanitise()`
    // foundation helper — `RoundedCornerShape` / `Modifier.size` throw on
    // negatives, and a non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`.
    val safeSize = size.sanitise()
    val safeRadius = radius.sanitise()
    val shape = RoundedCornerShape(safeRadius)
    val showBorder = style != YaruSearchFieldStyle.Filled
    Box(
        modifier = modifier
            .size(safeSize)
            .let { m -> if (showBorder) m.border(1.dp, resolvedBorder, shape) else m },
        contentAlignment = Alignment.Center,
    ) {
        // Dart `YaruSearchButton` (yaru_search_field.dart:385-422) does NOT
        // override `YaruIconButton.iconSize`, so the inner button square
        // defaults to `kYaruIconSize = 20`. Only the *glyph* is shrunk to
        // `kYaruIconSize - 4 = 16` (line 409, 417).
        // Mirrors Dart `YaruSearchButton.icon` / `selectedIcon` (yaru_search_field.dart:411-418): callers may replace the default search glyph (e.g. for a "filter" or "advanced" search button).
        // CRITICAL: Dart explicitly passes `color: theme.colorScheme.onSurface`
        // on both `Icon`s (lines 410 and 418), bypassing the YaruIconButton
        // selected-foreground (`primary`) so the magnifier stays the neutral
        // onSurface tint regardless of `searchActive`. Without this explicit
        // tint, our YaruIcon would inherit `LocalYaruContentColor` which the
        // YaruIconButton overrides to `primary` when selected — turning the
        // magnifier accent-orange, which Dart never does.
        val defaultGlyph: @Composable () -> Unit = {
            YaruIcon(
                glyph = YaruIcons.search,
                size = YaruConstants.IconSize - 4.dp,
                tint = scheme.onSurface,
            )
        }
        YaruIconButton(
            onPressed = onPressed,
            iconSize = YaruConstants.IconSize,
            // Pin the YaruIconButton's outer state-layer to the search-button
            // pill size (34 dp by default). Without this, [YaruIconButton]
            // would default `minimumSize = 40` (the stock IconButton default)
            // and the Modifier.size clamp from the outer Box would visually
            // shrink the state-layer to 34 — but the icon centring math
            // still uses the 40 dp box, so the glyph drifts off-centre.
            minimumSize = safeSize,
            isSelected = isSelected,
            shape = shape,
            // Defensive: forward `semanticLabel` (was previously suppressed) so the search glyph carries an accessible name for screen readers.
            semanticLabel = semanticLabel,
            icon = icon ?: defaultGlyph,
            selectedIcon = selectedIcon,
        )
    }
}

/**
 * A composite that stacks a [YaruSearchButton] (always visible on the leading
 * edge) over either a [title] widget or an inline [YaruSearchField] — toggled
 * by [searchActive].
 *
 * Mirrors `YaruSearchTitleField` from
 * `yaru.dart/lib/src/widgets/yaru_search_field.dart:220-346`. Used in the
 * search-field example to embed a collapsible search input directly in a
 * `YaruDialogTitleBar` without the need for a separate leading slot.
 *
 * Geometry from the Dart constructor:
 *  - default `width = 190` dp
 *  - default `radius = Radius.circular(kYaruTitleBarItemHeight)` → fully rounded ends
 *  - title is padded `EdgeInsets.only(left: 45)` (room for the search button)
 *  - the embedded `YaruSearchField` uses `contentPadding: (10, 45, 10, 15)`
 *    so its text doesn't slide under the search button
 */
@Composable
fun YaruSearchTitleField(
    searchActive: Boolean,
    onSearchActive: () -> Unit,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    width: Dp = 190.dp,
    titlePaddingStart: Dp = 45.dp,
    autoFocus: Boolean = true,
    text: String = "",
    onValueChange: ((String) -> Unit)? = null,
    onSubmitted: ((String) -> Unit)? = null,
    onClear: (() -> Unit)? = null,
    placeholder: String? = null,
    height: Dp = YaruConstants.TitleBarItemHeight,
    radius: Dp = height,
    style: YaruSearchFieldStyle = YaruSearchFieldStyle.Filled,
    searchIcon: (@Composable () -> Unit)? = null,
    clearIcon: (@Composable () -> Unit)? = null,
) {
    val safeWidth = width.sanitise()
    val safeHeight = height.sanitise()
    val safeRadius = radius.sanitise()
    val shape = RoundedCornerShape(safeRadius)

    // `ClipRRect(borderRadius: BorderRadius.all(radius))`
    // (yaru_search_field.dart:291-293) — the pill clips the embedded
    // search field's filled background to the same rounded ends.
    Box(
        modifier = modifier
            .width(safeWidth)
            .height(safeHeight)
            .clip(shape),
        contentAlignment = Alignment.CenterStart,
    ) {
        // `Stack(alignment: centerLeft)` (yaru_search_field.dart:294-340).
        if (searchActive) {
            // `YaruSearchField` with `contentPadding: (10, 45, 10, 15)` so the
            // text starts past the search button and the clear icon sits on
            // the trailing edge (yaru_search_field.dart:298-321).
            YaruSearchField(
                value = text,
                onValueChange = { onValueChange?.invoke(it) },
                onSubmitted = onSubmitted,
                onClear = onClear,
                placeholder = placeholder,
                height = safeHeight,
                radius = safeRadius,
                contentPadding = PaddingValues(start = 45.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
                style = style,
                autoFocus = autoFocus,
                clearIcon = clearIcon,
                modifier = Modifier.width(safeWidth),
            )
        } else {
            // `Padding(padding: titlePadding, child: Align(alignment, child: title))`
            // (yaru_search_field.dart:323-327).
            Box(
                modifier = Modifier
                    .padding(start = titlePaddingStart)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart,
            ) { title() }
        }
        // The leading search button is painted on top of either branch so the
        // user can collapse the field even while it's focused
        // (yaru_search_field.dart:328-340).
        YaruSearchButton(
            onPressed = onSearchActive,
            isSelected = searchActive,
            size = safeHeight,
            radius = safeRadius,
            // Filled stays filled; Outlined keeps the outline state, mirroring
            // the explicit ternary on line 331-333.
            style = if (style == YaruSearchFieldStyle.Outlined) style else YaruSearchFieldStyle.Filled,
            icon = searchIcon,
            selectedIcon = searchIcon,
        )
    }
}

