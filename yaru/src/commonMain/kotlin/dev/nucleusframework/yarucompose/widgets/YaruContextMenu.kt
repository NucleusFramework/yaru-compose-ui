package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants

/** Closes the enclosing [YaruContextMenu] — provided to every row. */
internal val LocalYaruContextMenuClose = staticCompositionLocalOf<() -> Unit> { {} }

/**
 * Wraps [trigger] in a right-click (or long-press) target that opens [content]
 * as a menu at the pointer.
 *
 * yaru.dart has no context-menu widget of its own — GTK apps get theirs from
 * the toolkit — so this is a Compose-side addition. It is *not* a new menu
 * design: the panel is [YaruPopupMenuSurface] and the rows are
 * [YaruMenuItemRow], the same two pieces [YaruPopupMenuButton] is built from,
 * so a context menu and a popup menu are pixel-identical.
 *
 * ```
 * YaruContextMenu(trigger = { YaruText("Right-click me") }) {
 *     YaruContextMenuItem(onSelect = ::copy, trailing = { YaruContextMenuShortcut("C", control = true) }) {
 *         YaruText("Copy")
 *     }
 *     YaruContextMenuSeparator()
 *     YaruContextMenuItem(onSelect = ::delete) { YaruText("Delete") }
 * }
 * ```
 *
 * Text fields do not need this: [dev.nucleusframework.yarucompose.themes.YaruTheme]
 * already restyles their built-in cut / copy / paste menu with the same surface.
 */
@Composable
fun YaruContextMenu(
    trigger: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    minWidth: Dp = 160.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
    var open by remember { mutableStateOf(false) }
    // Pointer position within the trigger, in local coordinates — the menu's
    // top-left corner, as every desktop toolkit places it.
    var cursorOffset by remember { mutableStateOf(IntOffset.Zero) }

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .pointerInput(enabled) {
                    if (!enabled) return@pointerInput
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            if (event.type == PointerEventType.Press && event.buttons.isSecondaryPressed) {
                                val position = event.changes.first().position
                                cursorOffset = IntOffset(position.x.toInt(), position.y.toInt())
                                open = true
                                event.changes.forEach { it.consume() }
                            }
                        }
                    }
                }
                // Touch platforms have no secondary button — long press is the
                // equivalent gesture there. Registered as its own pointer input
                // so it keeps working alongside the loop above.
                .pointerInput(enabled) {
                    if (!enabled) return@pointerInput
                    detectTapGestures(
                        onLongPress = { position ->
                            cursorOffset = IntOffset(position.x.toInt(), position.y.toInt())
                            open = true
                        },
                    )
                },
        ) {
            trigger()
        }

        if (open) {
            val dismiss = { open = false }
            Popup(
                popupPositionProvider = remember(cursorOffset) { CursorPositionProvider(cursorOffset) },
                onDismissRequest = dismiss,
                properties = PopupProperties(focusable = true),
            ) {
                CompositionLocalProvider(LocalYaruContextMenuClose provides dismiss) {
                    YaruPopupMenuSurface(minWidth = minWidth, content = content)
                }
            }
        }
    }
}

/**
 * Places the menu's top-left corner at the pointer, flipping it back over the
 * cursor when it would overflow the window and clamping as a last resort.
 */
private class CursorPositionProvider(private val cursorOffset: IntOffset) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize,
    ): IntOffset {
        val originX = anchorBounds.left + cursorOffset.x
        val originY = anchorBounds.top + cursorOffset.y
        val startsAtCursor = layoutDirection == LayoutDirection.Ltr
        val preferredX = if (startsAtCursor) originX else originX - popupContentSize.width
        val x = when {
            startsAtCursor && preferredX + popupContentSize.width > windowSize.width ->
                originX - popupContentSize.width
            !startsAtCursor && preferredX < 0 -> originX
            else -> preferredX
        }
        val y = if (originY + popupContentSize.height > windowSize.height) {
            originY - popupContentSize.height
        } else {
            originY
        }
        return IntOffset(
            x = x.coerceIn(0, (windowSize.width - popupContentSize.width).coerceAtLeast(0)),
            y = y.coerceIn(0, (windowSize.height - popupContentSize.height).coerceAtLeast(0)),
        )
    }
}

/**
 * A selectable menu row — a `PopupMenuItem` in everything but its trigger.
 * Selecting it runs [onSelect] and closes the menu.
 *
 * [leading] and [trailing] are free-form slots: a glyph (see
 * [YaruContextMenuIcon]) and a [YaruContextMenuShortcut] in the usual case.
 */
@Composable
fun YaruContextMenuItem(
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val close = LocalYaruContextMenuClose.current
    YaruMenuItemRow(
        modifier = modifier,
        enabled = enabled,
        onClick = {
            onSelect()
            close()
        },
    ) {
        if (leading != null) {
            leading()
            Spacer(Modifier.width(YaruMenuSlotGap))
        }
        Box(modifier = Modifier.weight(1f)) { content() }
        if (trailing != null) {
            Spacer(Modifier.width(YaruMenuSlotGap))
            trailing()
        }
    }
}

/**
 * A menu row carrying a [YaruCheckbox], laid out like
 * `YaruCheckedPopupMenuItem`. It leaves the menu open so several entries can be
 * ticked in one pass — the `closeOnTap = false` behaviour of its popup-menu
 * counterpart.
 */
@Composable
fun YaruContextMenuCheckboxItem(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    YaruMenuItemRow(
        modifier = modifier,
        enabled = enabled,
        role = Role.Checkbox,
        onClick = { onCheckedChange(!checked) },
    ) {
        YaruCheckbox(checked = checked, onCheckedChange = null, enabled = enabled)
        Spacer(Modifier.width(YaruMenuSlotGap))
        Box(modifier = Modifier.weight(1f)) { content() }
    }
}

/** A non-interactive caption above a group of rows. */
@Composable
fun YaruContextMenuLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    val scheme = LocalYaruColorScheme.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp)
            // Aligned with `_PopupMenuDefaultsM3.menuItemPadding`, so the
            // caption sits flush with the labels below it.
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        YaruText(
            text = text,
            style = LocalYaruTypography.current.labelMedium,
            color = scheme.onSurface.copy(alpha = 0.7f),
        )
    }
}

/**
 * A hairline between two groups of rows — Flutter's `PopupMenuDivider`, a
 * `Divider` inside a 16dp band.
 */
@Composable
fun YaruContextMenuSeparator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().height(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        YaruHorizontalDivider()
    }
}

/**
 * A keyboard-shortcut hint, meant for [YaruContextMenuItem]'s `trailing` slot.
 *
 * Renders GNOME's notation (`Ctrl+Shift+C`) on every target: Yaru is Ubuntu's
 * design system, so its accelerators read the same wherever the app runs.
 */
@Composable
fun YaruContextMenuShortcut(
    key: String,
    modifier: Modifier = Modifier,
    control: Boolean = false,
    shift: Boolean = false,
    alt: Boolean = false,
    `super`: Boolean = false,
) {
    val scheme = LocalYaruColorScheme.current
    val label = remember(key, control, shift, alt, `super`) {
        buildList {
            if (control) add("Ctrl")
            if (alt) add("Alt")
            if (shift) add("Shift")
            if (`super`) add("Super")
            add(key)
        }.joinToString("+")
    }
    YaruText(
        text = label,
        modifier = modifier,
        color = scheme.onSurface.copy(alpha = 0.7f),
    )
}

/**
 * Square box sized for a leading glyph inside a menu row — `kYaruIconSize`,
 * the same footprint the checkbox of a [YaruContextMenuCheckboxItem] takes.
 */
@Composable
fun YaruContextMenuIcon(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.size(YaruConstants.IconSize),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}
