@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItemWithComposableLeadingIcon

/** Desktop and web ship the richer component type, which carries `enabled`. */
internal actual fun TextContextMenuComponent.toYaruItemInfo(): YaruTextContextMenuItemInfo? {
    if (this !is TextContextMenuItemWithComposableLeadingIcon) return null
    return YaruTextContextMenuItemInfo(
        key = key,
        label = label,
        enabled = enabled,
        onClick = onClick,
    )
}
