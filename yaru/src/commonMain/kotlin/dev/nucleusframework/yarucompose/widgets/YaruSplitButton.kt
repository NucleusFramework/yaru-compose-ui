package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants

/** Visual variant of [YaruSplitButton]. */
enum class YaruSplitButtonVariant { Elevated, Filled, Outlined }

/**
 * Single dropdown entry for a [YaruSplitButton].
 *
 * Mirrors a `PopupMenuItem` row passed to `YaruSplitButton.items` in
 * `yaru.dart/lib/src/widgets/yaru_split_button.dart`.
 */
data class YaruSplitButtonItem(
    val label: String,
    val onClick: () -> Unit,
    val enabled: Boolean = true,
)

/**
 * A button paired with a chevron that opens a dropdown of secondary actions.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_split_button.dart`. Foundation-only.
 *
 * Layout parity:
 *  - Two side-by-side buttons inside an `IntrinsicHeight + Row` joined by a
 *    1dp [YaruVerticalDivider] (non-outlined variants only — the outlined
 *    variant relies on the shared 1dp outline at the join).
 *  - The left half (main action) gets `BorderRadius.horizontal(left)`; the
 *    right half (chevron) gets `BorderRadius.horizontal(right)`.
 *  - Both halves share `kYaruButtonHeight = 34dp`.
 *  - The chevron is exactly 37dp wide (`Size(37, 0)` from the Dart source).
 *
 * Behavior parity:
 *  - When [items] is empty AND [onOptionsPressed] is null the dropdown half
 *    collapses entirely and the main button gets all four corners rounded
 *    (matches `onDropdownPressed == null` in Dart).
 *  - When [items] is non-empty but [onOptionsPressed] is null, the chevron
 *    falls back to opening the dropdown menu (matches `onDropdownPressed ??
 *    (items?.isNotEmpty == true ? () => showMenu(...) : null)`).
 *  - When [onPressed] is null the main half is disabled (rendered at 38%).
 *  - The dropdown opens at the entire split-button's bottom-left
 *    (`box.localToGlobal(box.size.bottomLeft, ...)` in `_menuPosition`).
 */
@Composable
fun YaruSplitButton(
    onPressed: (() -> Unit)?,
    modifier: Modifier = Modifier,
    items: List<YaruSplitButtonItem> = emptyList(),
    onOptionsPressed: (() -> Unit)? = null,
    variant: YaruSplitButtonVariant = YaruSplitButtonVariant.Elevated,
    // from yaru_split_button.dart L62: defaultRadius = Radius.circular(radius ?? kYaruButtonRadius)
    radius: Dp = YaruConstants.ButtonRadius,
    menuWidth: Dp? = null,
    icon: (@Composable () -> Unit)? = null,
    label: @Composable () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    // Clamp caller-supplied dimensions to a finite non-negative range —
    // `RoundedCornerShape` and `Modifier.width` (via `YaruPopupMenuSurface`)
    // throw on negatives, and a non-finite Dp (NaN / ±Infinity) blows up
    // `roundToPx()` downstream. NaN bypasses `coerceAtLeast` (NaN comparisons
    // all return false), so reject non-finite values explicitly via
    // `isFinite()`.
    val safeRadius = if (radius.value.isFinite()) {
        radius.coerceAtLeast(0.dp)
    } else {
        YaruConstants.ButtonRadius
    }
    val safeMenuWidth = menuWidth?.let {
        if (it.value.isFinite()) it.coerceAtLeast(0.dp) else null
    }

    // from yaru_split_button.dart L80-95: dropdown half is visible when an
    // explicit onOptionsPressed is provided, OR items is non-empty (in which
    // case the chevron tap defaults to opening the menu).
    val hasItems = items.isNotEmpty()
    val hasDropdown = onOptionsPressed != null || hasItems

    val buttonVariant = when (variant) {
        YaruSplitButtonVariant.Elevated -> YaruButtonVariant.Elevated
        // from yaru_split_button.dart L126-130: the .filled() constructor
        // uses the Dart `FilledButton` — Yaru theme = onSurface @ 0.1.
        YaruSplitButtonVariant.Filled -> YaruButtonVariant.Filled
        YaruSplitButtonVariant.Outlined -> YaruButtonVariant.Outlined
    }

    // from yaru_split_button.dart L97-104:
    //   mainActionShape = onDropdownPressed == null
    //     ? BorderRadius.all(defaultRadius)
    //     : BorderRadius.only(topLeft, bottomLeft).
    val mainShape = if (hasDropdown) {
        RoundedCornerShape(topStart = safeRadius, bottomStart = safeRadius)
    } else {
        RoundedCornerShape(safeRadius)
    }
    // from yaru_split_button.dart L115-118:
    //   dropdownBorderRadius = BorderRadius.horizontal(right: kYaruButtonRadius).
    val dropdownShape = RoundedCornerShape(topEnd = safeRadius, bottomEnd = safeRadius)

    Box(modifier = modifier) {
        Row(
            // Defensive: pin the row to `kYaruButtonHeight = 34dp` to match Dart's `minimumSize: Size(64, 34)` in `_createElevatedButtonTheme`. Both halves share this height. Previously we used `IntrinsicSize.Max` which let YaruButton's default 16dp-all `contentPadding` push the row to ~49dp tall — taller than Flutter's 34dp.
            modifier = Modifier.height(YaruConstants.ButtonHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            YaruButton(
                onClick = { onPressed?.invoke() },
                enabled = onPressed != null,
                variant = buttonVariant,
                shape = mainShape,
                // Defensive: drop the default 16dp top/bottom padding so the label fits inside the row's pinned 34dp height. Mirrors the Dart `ElevatedButton`'s compact horizontal-only padding at fixed-height.
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 24.dp, vertical = 0.dp),
                modifier = Modifier.fillMaxHeight(),
            ) { label() }

            if (hasDropdown) {
                // from yaru_split_button.dart L181-183: a 1dp filler is
                // inserted between the halves for non-outlined variants
                // only. The outlined variant relies on the shared outline.
                if (variant != YaruSplitButtonVariant.Outlined) {
                    YaruVerticalDivider(
                        modifier = Modifier.fillMaxHeight(),
                        thickness = 1.dp,
                    )
                }

                YaruButton(
                    onClick = {
                        if (onOptionsPressed != null) {
                            onOptionsPressed.invoke()
                        } else {
                            expanded = !expanded
                        }
                    },
                    // The chevron is always enabled when visible (Dart falls
                    // back to the menu opener when onOptionsPressed is null).
                    enabled = true,
                    variant = buttonVariant,
                    shape = dropdownShape,
                    // from yaru_split_button.dart L143: padding: EdgeInsets.zero.
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                    // from yaru_split_button.dart L60: dropdownSize = Size(37, 0).
                    // `fillMaxHeight()` matches the main button's intrinsic
                    // height so the chevron and label halves are flush.
                    modifier = Modifier.width(37.dp).fillMaxHeight(),
                ) {
                    if (icon != null) {
                        icon()
                    } else {
                        // from yaru_split_button.dart L106-107:
                        //   Icon(YaruIcons.pan_down) — the ambient IconTheme
                        //   sets size = kYaruIconSize (20).
                        YaruIcon(YaruIcons.pan_down, size = YaruConstants.IconSize)
                    }
                }
            }
        }

        // The popup is anchored at the entire split-button's bottom-left
        // (matches `_menuPosition` which uses the YaruSplitButton's render
        // box, not the chevron's). Living inside the outer Box gives us the
        // correct origin without measuring children.
        if (expanded && hasItems) {
            SplitButtonMenu(
                items = items,
                menuWidth = safeMenuWidth,
                onDismiss = { expanded = false },
            )
        }
    }
}

@Composable
private fun SplitButtonMenu(
    items: List<YaruSplitButtonItem>,
    menuWidth: Dp?,
    onDismiss: () -> Unit,
) {
    // Defensive: `Popup.offset` is `IntOffset` in *pixels*, not Dp — passing `ButtonHeight.value.toInt()` (34) hardcoded the offset to 34 px regardless of density, overlapping the button on >1.0x screens.
    val anchorYPx = with(LocalDensity.current) { YaruConstants.ButtonHeight.roundToPx() }
    Popup(
        onDismissRequest = onDismiss,
        // from yaru_split_button.dart `_menuPosition` (L196-208): anchored at
        // the split-button's bottom-left → y == kYaruButtonHeight (34).
        offset = IntOffset(0, anchorYPx),
        properties = PopupProperties(focusable = true),
    ) {
        // Reuse the shared popup-menu surface so background, border, radius,
        // and vertical list padding stay in lockstep with YaruPopupMenuButton
        // and any other widget that opens a Yaru menu. When the caller pins
        // menuWidth, the Dart source clamps the surface to that exact width
        // (see `BoxConstraints(minWidth: menuWidth!, maxWidth: menuWidth!)`
        // at yaru_split_button.dart L91-93). Otherwise we let the surface
        // grow to the widest row's intrinsic width.
        YaruPopupMenuSurface(
            minWidth = menuWidth ?: 160.dp,
            fixedWidth = menuWidth,
        ) {
            items.forEach { item ->
                SplitMenuRow(item = item, onDismiss = onDismiss)
            }
        }
    }
}

@Composable
private fun SplitMenuRow(
    item: YaruSplitButtonItem,
    onDismiss: () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()
    // SplitButton dispatches via `showMenu(...)` (yaru_split_button.dart
    // L83-94) which builds `PopupMenuItem`s. Those wrap their child in
    // a plain `InkWell` (no `overlayColor` override), which falls back to
    // `ThemeData.hoverColor`/`highlightColor` — Dart defaults `0.04`/`0.1`.
    // Yaru's global `splashFactory: NoSplash` kills the ripple, so the
    // press feedback is the static highlight (NOT the splash) color.
    val background = when {
        !item.enabled -> Color.Transparent
        pressed -> scheme.onSurface.copy(alpha = 0.1f)
        hovered -> scheme.onSurface.copy(alpha = 0.04f)
        else -> Color.Transparent
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            // SplitButton dispatches the popup via `showMenu(...)` (see
            // yaru_split_button.dart L83-94) which renders Dart
            // `PopupMenuItem`s — those default to `kMinInteractiveDimension =
            // 48` and Yaru does not override `popupMenuTheme.menuItemHeight`.
            .heightIn(min = 48.dp)
            .let {
                if (item.enabled) {
                    it
                        // Mirrors Flutter's `PopupMenuItem` / `InkWell.mouseCursor`
                        // default (`WidgetStateMouseCursor.clickable` →
                        // `SystemMouseCursors.click`).
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            role = Role.Button,
                            onClick = {
                                onDismiss()
                                item.onClick()
                            },
                        )
                } else {
                    it
                }
            }
            .background(background)
            // Dart `_PopupMenuDefaultsM3.menuItemPadding =
            // EdgeInsets.symmetric(horizontal: 12)` (the older default was 16).
            // Yaru does not override `popupMenuTheme.menuPadding`.
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CompositionLocalProvider(
            LocalYaruContentColor provides if (item.enabled) {
                scheme.onSurface
            } else {
                // Dart `Theme.disabledColor` ≈ onSurface @ 0.38.
                scheme.onSurface.copy(alpha = 0.38f)
            },
            // Dart `_PopupMenuDefaultsM3.labelTextStyle` returns `labelLarge`
            // (yaru: 14.66sp Normal). `showMenu` items go through the same
            // theme path as `PopupMenuButton`, so we mirror the popup widget.
            LocalYaruTextStyle provides LocalYaruTypography.current.labelLarge,
        ) {
            YaruText(item.label)
        }
    }
}
