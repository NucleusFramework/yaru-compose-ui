@file:OptIn(ExperimentalFoundationApi::class)

package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.ComposeFoundationFlags
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
import androidx.compose.foundation.text.contextmenu.provider.LocalTextContextMenuDropdownProvider
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuItem
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuSeparator
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuShortcut
import dev.nucleusframework.yarucompose.widgets.YaruContextMenuSurface
import dev.nucleusframework.yarucompose.widgets.YaruText
import kotlinx.coroutines.channels.Channel

/**
 * One entry of the platform's built-in text context menu, flattened into the
 * fields the Yaru rows need. The concrete component type differs per target,
 * hence [toItemInfo].
 */
internal data class YaruTextContextMenuItemInfo(
    val key: Any,
    val label: String,
    val enabled: Boolean,
    val onClick: (TextContextMenuSession) -> Unit,
)

/** Reads a platform [TextContextMenuComponent]; `null` for anything unknown. */
internal expect fun TextContextMenuComponent.toYaruItemInfo(): YaruTextContextMenuItemInfo?

private class OpenTextMenu(
    val dataProvider: TextContextMenuDataProvider,
    val onDismiss: () -> Unit,
)

/**
 * Replaces the cut / copy / paste menu Compose shows on a text field with a
 * Yaru-styled one, so a right-click inside a [dev.nucleusframework.yarucompose.widgets.YaruTextField]
 * looks like the rest of the toolkit instead of the platform default.
 *
 * Installed by [YaruTheme]; nothing to call by hand.
 */
@Composable
internal fun YaruTextContextMenuOverride(content: @Composable () -> Unit) {
    // Opt into the Foundation context-menu system that routes through
    // LocalTextContextMenuDropdownProvider. Without it the old, unstyleable
    // toolbar is used instead.
    ComposeFoundationFlags.isNewContextMenuEnabled = true

    var openMenu by remember { mutableStateOf<OpenTextMenu?>(null) }
    var rootCoordinates by remember { mutableStateOf<LayoutCoordinates?>(null) }

    val provider = remember {
        object : TextContextMenuProvider {
            override suspend fun showTextContextMenu(dataProvider: TextContextMenuDataProvider) {
                // The call suspends for as long as the menu is on screen; the
                // rendezvous channel is what turns "the user dismissed it" back
                // into a resumption.
                val closeSignal = Channel<Unit>(Channel.RENDEZVOUS)
                openMenu = OpenTextMenu(
                    dataProvider = dataProvider,
                    onDismiss = { closeSignal.trySend(Unit) },
                )
                try {
                    closeSignal.receive()
                } finally {
                    openMenu = null
                }
            }
        }
    }

    CompositionLocalProvider(LocalTextContextMenuDropdownProvider provides provider) {
        Box(modifier = Modifier.onGloballyPositioned { rootCoordinates = it }) {
            content()
        }
    }

    val menu = openMenu
    val coordinates = rootCoordinates
    if (menu != null && coordinates != null) {
        YaruTextContextMenuPopup(menu, coordinates)
    }
}

@Composable
private fun YaruTextContextMenuPopup(
    menu: OpenTextMenu,
    coordinates: LayoutCoordinates,
) {
    // A text field inside a Dialog composes in its own hierarchy, so the
    // coordinates handed to us may not be an ancestor of the field's.
    val position = try {
        menu.dataProvider.position(coordinates)
    } catch (_: IllegalArgumentException) {
        Offset.Zero
    }
    val data = menu.dataProvider.data()
    val session = remember(menu) {
        object : TextContextMenuSession {
            override fun close() = menu.onDismiss()
        }
    }
    val cursor = IntOffset(position.x.toInt(), position.y.toInt())

    Popup(
        popupPositionProvider = remember(cursor) { TextMenuPositionProvider(cursor) },
        onDismissRequest = menu.onDismiss,
        properties = PopupProperties(focusable = true),
    ) {
        // Same panel and rows as YaruContextMenu.
        YaruContextMenuSurface(minWidth = 160.dp) {
            for (component in data.components) {
                if (component is TextContextMenuSeparator) {
                    YaruContextMenuSeparator()
                    continue
                }
                val item = component.toYaruItemInfo() ?: continue
                val shortcut = shortcutFor(item.key)
                YaruContextMenuItem(
                    onSelect = { item.onClick(session) },
                    enabled = item.enabled,
                    trailing = shortcut?.let { { YaruContextMenuShortcut(it, control = true) } },
                ) {
                    YaruText(item.label)
                }
            }
        }
    }
}

/**
 * GNOME's accelerators for the four standard edit actions. Anything else the
 * platform contributes (e.g. autofill) has none.
 */
private fun shortcutFor(key: Any): String? = when (key) {
    TextContextMenuKeys.CutKey -> "X"
    TextContextMenuKeys.CopyKey -> "C"
    TextContextMenuKeys.PasteKey -> "V"
    TextContextMenuKeys.SelectAllKey -> "A"
    else -> null
}

/** Anchors the menu at the caret / pointer, clamped inside the window. */
private class TextMenuPositionProvider(private val cursor: IntOffset) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize,
    ): IntOffset = IntOffset(
        x = cursor.x.coerceIn(0, (windowSize.width - popupContentSize.width).coerceAtLeast(0)),
        y = cursor.y.coerceIn(0, (windowSize.height - popupContentSize.height).coerceAtLeast(0)),
    )
}
