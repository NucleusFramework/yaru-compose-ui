package dev.nucleusframework.yarucompose.foundation

import androidx.compose.ui.input.pointer.PointerIcon
import java.awt.Cursor

actual val ResizeColumnPointerIcon: PointerIcon =
    PointerIcon(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR))

actual val ResizeRowPointerIcon: PointerIcon =
    PointerIcon(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR))
