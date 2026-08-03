package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import dev.nucleusframework.yarucompose.foundation.YaruBaseSizeAdjustment
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale

/**
 * Single dropdown entry for [YaruPopupMenuButton] / [YaruSplitButton].
 *
 * Mirrors `PopupMenuItem` / `YaruCheckedPopupMenuItem` /
 * `YaruMultiSelectPopupMenuItem` from
 * `yaru.dart/lib/src/widgets/yaru_popup_menu_button.dart`.
 *
 *  - [enabled]   — disabled rows are non-tappable and rendered at 38% opacity.
 *  - [checked]   — when non-null the row gets a leading [YaruCheckbox]
 *                  matching the Dart "checked" item style.
 *  - [closeOnTap]— set to `false` for the multi-select variant which keeps the
 *                  popup open after each toggle (matches `YaruMultiSelectPopupMenuItem`).
 *  - [onChanged] — invoked alongside [onSelected] when [checked] is non-null,
 *                  giving the caller the new check state without forcing a
 *                  re-render of the whole list.
 */
data class YaruPopupMenuEntry<T>(
    val value: T,
    val label: @Composable () -> Unit,
    val enabled: Boolean = true,
    val checked: Boolean? = null,
    val closeOnTap: Boolean = true,
    val onChanged: ((Boolean) -> Unit)? = null,
)

/**
 * A single-select dropdown button styled as a Yaru button — foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_popup_menu_button.dart`. Uses
 * Compose Foundation's [Popup] and a [Column] of item rows, so the widget
 * needs nothing beyond foundation.
 */
@Composable
fun <T> YaruPopupMenuButton(
    items: List<YaruPopupMenuEntry<T>>,
    onSelected: (T) -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showArrow: Boolean = true,
    icon: (@Composable () -> Unit)? = null,
    // from yaru_popup_menu_button.dart: padding = const EdgeInsets.symmetric(horizontal: 5)
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp),
    // from yaru_popup_menu_button.dart: childPadding = const EdgeInsets.symmetric(horizontal: 5)
    childPadding: PaddingValues = PaddingValues(horizontal = 5.dp),
    variant: YaruButtonVariant = YaruButtonVariant.Outlined,
    minPopupWidth: Dp = 160.dp,
) {
    var expanded by remember { mutableStateOf(false) }
    // Clamp caller-supplied minimum width — `Modifier.widthIn` (via
    // `YaruPopupMenuSurface`) will throw on negatives, and a non-finite Dp
    // (NaN / +-Infinity) blows up `roundToPx()` downstream. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject non-finite
    // values explicitly via `isFinite()`.
    val safeMinPopupWidth = if (minPopupWidth.value.isFinite()) {
        minPopupWidth.coerceAtLeast(0.dp)
    } else {
        0.dp
    }
    // `Modifier.padding(PaddingValues)` throws on any negative edge, and a
    // non-finite Dp (NaN / +-Infinity) blows up `roundToPx()` downstream. NaN
    // bypasses `coerceAtLeast` (NaN comparisons all return false), so reject
    // non-finite values explicitly via `isFinite()`. `contentPadding` is
    // re-sanitized inside `YaruButton`; `childPadding` flows directly into
    // `Modifier.padding` below and must be clamped here.
    val layoutDirection = LocalLayoutDirection.current
    val safeChildPadding = childPadding.coerceNonNegative(layoutDirection)

    Box(modifier = modifier) {
        YaruButton(
            onClick = { if (enabled) expanded = !expanded },
            enabled = enabled,
            variant = variant,
            contentPadding = contentPadding,
        ) {
            // Match Dart: `Row(spaceBetween)` with the chevron on the trailing edge.
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.padding(safeChildPadding)) {
                    // Dart wrapper forces FontWeight.w500 on the label.
                    CompositionLocalProvider(
                        LocalYaruTextStyle provides LocalYaruTypography.current.labelLarge.copy(
                            fontWeight = FontWeight.Medium,
                        ),
                    ) {
                        label()
                    }
                }
                if (showArrow) {
                    Spacer(Modifier.width(4.dp))
                    // Dart `yaru_popup_menu_button.dart:109` uses `Icon(YaruIcons.pan_down)`
                    // without an explicit size, so it inherits `IconTheme.size =
                    // kYaruIconSize` (20) from `common_themes.dart:152`.
                    if (icon != null) icon() else YaruIcon(YaruIcons.pan_down, size = YaruConstants.IconSize)
                }
            }
        }
        // Defensive: an empty `items` list would otherwise render a
        // zero-row popup surface (an empty floating box). Mirrors Dart's
        // `PopupMenuButton` which short-circuits the route when the
        // `itemBuilder` produces no children.
        if (expanded && items.isNotEmpty()) {
            // Defensive: `Popup.offset` is `IntOffset` in *pixels*, not Dp — `TitleBarItemHeight.value.toInt()` would hardcode 35 px regardless of density, overlapping the trigger on >1.0x screens. Convert via `LocalDensity.current.run { TitleBarItemHeight.roundToPx() }`.
            val anchorYPx = with(LocalDensity.current) { YaruConstants.TitleBarItemHeight.roundToPx() }
            Popup(
                onDismissRequest = { expanded = false },
                // from yaru_popup_menu_button.dart: offset = const Offset(0, kYaruTitleBarItemHeight)
                offset = IntOffset(0, anchorYPx),
                properties = PopupProperties(focusable = true),
            ) {
                YaruPopupMenuSurface(minWidth = safeMinPopupWidth) {
                    items.forEach { entry ->
                        PopupMenuRow(
                            entry = entry,
                            onClick = {
                                // Behavior parity with
                                // `_YaruMultiSelectPopupMenuItemState.handleTap`
                                // (yaru_popup_menu_button.dart L217-220): the
                                // multi-select item does NOT call
                                // `super.handleTap()` — it neither dismisses
                                // the menu nor reports a selection. It only
                                // toggles its own state and fires `onChanged`.
                                if (entry.closeOnTap) {
                                    expanded = false
                                    onSelected(entry.value)
                                }
                                if (entry.checked != null) {
                                    entry.onChanged?.invoke(!entry.checked)
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}

/**
 * Background + border + radius + list padding for a `PopupMenuButton`-style
 * surface. Single source of truth so all three widgets (popup, split-button,
 * autocomplete) stay in sync.
 *
 * All values mirror `_createPopupMenuTheme` / `_createMenuBg` in
 * `yaru.dart/lib/src/themes/common_themes.dart`.
 *
 *  - [fixedWidth] — when non-null the surface is locked to that exact width
 *                   (matches `BoxConstraints(minWidth: w, maxWidth: w)` in
 *                   `yaru_split_button.dart` L91-93). Otherwise the surface
 *                   sizes to its widest row's intrinsic width and is bounded
 *                   below by [minWidth].
 */
@Composable
internal fun YaruPopupMenuSurface(
    minWidth: Dp = 160.dp,
    fixedWidth: Dp? = null,
    // from common_themes.dart `_createPopupMenuTheme` L518:
    //   BorderRadius.circular(10).
    radius: Dp = 10.dp,
    // Flutter's `_kMenuVerticalPadding = 8` — Yaru does not override this.
    verticalListPadding: Dp = 8.dp,
    // Flutter's popup menu has none; GNOME's popover menu pads all four edges,
    // which is what insets its row highlights and separators — see
    // [YaruContextMenuSurface].
    horizontalListPadding: Dp = 0.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
    // Clamp caller-supplied dimensions to a finite non-negative range —
    // `RoundedCornerShape`, `Modifier.width`, and `Modifier.padding` throw on
    // negatives, and a non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`
    // downstream. Route through the canonical `Dp.sanitise()` foundation
    // helper for consistent behaviour across widgets.
    val safeMinWidth = minWidth.sanitise()
    val safeFixedWidth = fixedWidth?.let { if (it.value.isFinite()) it.coerceAtLeast(0.dp) else null }
    val safeRadius = radius.sanitise()
    val safeVerticalListPadding = verticalListPadding.sanitise()
    val safeHorizontalListPadding = horizontalListPadding.sanitise()
    val shape = RoundedCornerShape(safeRadius)
    Column(
        modifier = Modifier
            // Width strategy:
            //  - `fixedWidth` set → lock to exact pixels.
            //  - else `width(IntrinsicSize.Max)` sizes to the widest row's
            //    intrinsic width. Without that, `fillMaxWidth` on each row
            //    would expand to the entire Popup window (the screen),
            //    which is the regression the user previously hit.
            .let {
                if (safeFixedWidth != null) {
                    it.width(safeFixedWidth)
                } else {
                    it.width(IntrinsicSize.Max).widthIn(min = safeMinWidth)
                }
            }
            // Dart `PopupMenuButton` default elevation = 8 (popup_menu.dart
            // `_PopupMenuRoute.build` → `elevation: route.elevation
            // ?? popupMenuTheme.elevation ?? 8`). Yaru does not override
            // `popupMenuTheme.elevation`, so we mirror that default here so
            // the menu lifts above hovered content.
            .shadow(
                elevation = 8.dp,
                shape = shape,
            )
            .background(
                color = rememberYaruMenuBackground(),
                shape = shape,
            )
            .border(
                width = 1.dp,
                color = rememberYaruMenuBorder(),
                shape = shape,
            )
            // Mirrors `clipBehavior: Clip.antiAlias` on the surface wrapping
            // the Dart `PopupMenuButton` (yaru_popup_menu_button.dart L71) and
            // the `_PopupMenuRoute` whose own `clipBehavior:
            // Clip.antiAlias` clips item hover/press fills to the rounded
            // shape. Without this, the rectangular row backgrounds bleed past
            // the 10dp corners of the first and last rows. Same fix as
            // YaruAutocomplete (`clipContent = true`).
            .clip(shape)
            .verticalScroll(rememberScrollState())
            .padding(
                vertical = safeVerticalListPadding,
                horizontal = safeHorizontalListPadding,
            ),
        content = content,
    )
}

/**
 * Menu background — `_createMenuBg(colorScheme)` from
 * `yaru.dart/lib/src/themes/common_themes.dart`:
 * `surface.scale(lightness: isLight ? 0 : -0.2)`.
 */
@Composable
internal fun rememberYaruMenuBackground(): Color {
    val scheme = LocalYaruColorScheme.current
    return menuBackground(scheme)
}

internal fun menuBackground(scheme: YaruColorScheme): Color =
    if (scheme.isLight) scheme.surface else scheme.surface.scale(lightness = -0.2f)

/**
 * Menu border — `_createPopupMenuTheme` / `_createMenuStyle` from
 * `yaru.dart/lib/src/themes/common_themes.dart`:
 * `isHighContrast ? outlineVariant : onSurface @ (isLight ? 0.3 : 0.2)`.
 */
@Composable
internal fun rememberYaruMenuBorder(): Color {
    val scheme = LocalYaruColorScheme.current
    return when {
        scheme.isHighContrast -> scheme.outlineVariant
        else -> scheme.onSurface.copy(alpha = if (scheme.isLight) 0.3f else 0.2f)
    }
}

@Composable
private fun <T> PopupMenuRow(
    entry: YaruPopupMenuEntry<T>,
    onClick: () -> Unit,
) {
    YaruMenuItemRow(enabled = entry.enabled, onClick = onClick) {
        if (entry.checked != null) {
            // YaruCheckedPopupMenuItem wraps the row in
            // `Padding(EdgeInsets.symmetric(horizontal: 4))` then a
            // `YaruCheckButton(title: child)` — the check-button itself
            // already inserts the title gap, so we just emit the checkbox
            // and let the title sit beside it.
            YaruCheckbox(
                checked = entry.checked,
                onCheckedChange = null,
                enabled = entry.enabled,
            )
            // from yaru_check_button.dart: ListTile.contentPadding default
            // (the title sits 8dp after the leading widget).
            Spacer(Modifier.width(YaruMenuSlotGap))
        }
        entry.label()
    }
}

/** Gap between a menu row's leading / trailing slot and its label. */
internal val YaruMenuSlotGap: Dp = 8.dp

/**
 * Geometry of one [YaruMenuItemRow]. The two menu families deliberately differ:
 * a dropdown is Flutter's `PopupMenuItem`, a context menu is GNOME's popover
 * menu (see [YaruContextMenu]).
 */
internal data class YaruMenuRowStyle(
    val minHeight: Dp,
    val horizontalPadding: Dp,
    /** Corner radius of the hover / press overlay. */
    val highlightRadius: Dp,
    val disabledAlpha: Float,
) {
    companion object {
        /**
         * Dart `PopupMenuItem` under the Yaru theme:
         *  - `kMinInteractiveDimension = 48` tall; Yaru overrides neither
         *    `popupMenuTheme.menuPadding` nor the global `visualDensity`.
         *  - `_PopupMenuDefaultsM3.menuItemPadding = EdgeInsets.symmetric(horizontal: 12)`.
         *  - the overlay is a full-bleed rectangle, clipped by the surface.
         *  - disabled rows are wrapped in `Opacity(0.38)` (`Theme.disabledColor`).
         */
        val PopupMenu = YaruMenuRowStyle(
            minHeight = 48.dp,
            horizontalPadding = 12.dp,
            highlightRadius = 0.dp,
            disabledAlpha = 0.38f,
        )

        /**
         * GNOME's `popover.menu modelbutton`: 32 px tall on the Ubuntu desktop,
         * 12 px of padding inside a 6 px-radius highlight, and `:disabled`
         * rendered at GTK's insensitive 50%.
         *
         * The height is expressed against [YaruBaseSizeAdjustment] rather than
         * hardcoded so touch targets stay usable where a right-click is a long
         * press: 32 dp on desktop and web, 40 dp on Android / iOS.
         */
        val ContextMenu: YaruMenuRowStyle
            get() = YaruMenuRowStyle(
                minHeight = 40.dp + YaruBaseSizeAdjustment,
                horizontalPadding = 12.dp,
                highlightRadius = 6.dp,
                disabledAlpha = 0.5f,
            )
    }
}

/**
 * One row of a Yaru menu surface — the single source of truth shared by
 * [YaruPopupMenuButton] and [YaruContextMenu]; [style] is what sets the two
 * apart.
 *
 * States mirror Dart's `PopupMenuItem`: the item is a plain `InkWell` with no
 * `overlayColor` override, so it falls back to `ThemeData.hoverColor` /
 * `highlightColor` — `black/white @ 0.04` and `@ 0.1`. `splashFactory:
 * NoSplash` kills the ripple, leaving the static overlay as the only feedback.
 * `_PopupMenuDefaultsM3.labelTextStyle` resolves to `textTheme.labelLarge`,
 * which is also GNOME's 11 pt menu label.
 */
@Composable
internal fun YaruMenuItemRow(
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    role: Role = Role.Button,
    style: YaruMenuRowStyle = YaruMenuRowStyle.PopupMenu,
    content: @Composable androidx.compose.foundation.layout.RowScope.() -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()
    val background = when {
        !enabled -> Color.Transparent
        pressed -> scheme.onSurface.copy(alpha = 0.1f)
        hovered -> scheme.onSurface.copy(alpha = 0.04f)
        else -> Color.Transparent
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = style.minHeight.sanitise())
            .let {
                if (enabled) {
                    it
                        // Mirrors Dart `MouseRegion(cursor: mouseCursor)` in
                        // yaru_popup_menu_button.dart:87-88, where the cursor
                        // resolves to `SystemMouseCursors.click` via
                        // `WidgetStateMouseCursor.clickable` for enabled rows.
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            role = role,
                            onClick = onClick,
                        )
                } else {
                    it
                }
            }
            // Background under the click target so the hover/press overlay
            // spans the entire row width, not just the label.
            .background(background, RoundedCornerShape(style.highlightRadius.sanitise()))
            .padding(horizontal = style.horizontalPadding.sanitise())
            .alpha(if (enabled) 1f else style.disabledAlpha),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CompositionLocalProvider(
            LocalYaruContentColor provides scheme.onSurface,
            LocalYaruTextStyle provides LocalYaruTypography.current.labelLarge,
            content = { content() },
        )
    }
}

/** Convenience overload using simple text labels and string items. */
@Composable
fun YaruPopupMenuButton(
    items: List<String>,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showArrow: Boolean = true,
    placeholder: String = "Select",
    selected: String? = null,
) {
    // Defensive: cache the wrapped entries keyed on `items` so each recomposition does not allocate fresh `YaruPopupMenuEntry` instances with brand-new `label` lambdas — fresh lambda identities would defeat skipping in the inner `YaruPopupMenuButton`.
    val entries = remember(items) {
        items.map { YaruPopupMenuEntry(value = it, label = { YaruText(it) }) }
    }
    // Defensive: empty `selected` string would render an invisible label inside the button surface; fall through to the placeholder in that case so the button always carries text.
    // Defensive: whitespace-only `selected` is equally invisible — fall through to the placeholder so the button never displays a blank gap.
    val effectiveSelected = selected?.takeIf { it.isNotBlank() }
    YaruPopupMenuButton(
        items = entries,
        onSelected = onSelected,
        modifier = modifier,
        enabled = enabled,
        showArrow = showArrow,
        label = { YaruText(effectiveSelected ?: placeholder) },
    )
}
