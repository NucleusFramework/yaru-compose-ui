package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem

/** Android only contributes plain items — they are always actionable. */
internal actual fun TextContextMenuComponent.toYaruItemInfo(): YaruTextContextMenuItemInfo? {
    if (this !is TextContextMenuItem) return null
    return YaruTextContextMenuItemInfo(
        key = key,
        label = label,
        enabled = true,
        onClick = onClick,
    )
}
