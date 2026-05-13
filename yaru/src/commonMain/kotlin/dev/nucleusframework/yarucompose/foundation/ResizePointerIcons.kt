package dev.nucleusframework.yarucompose.foundation

import androidx.compose.ui.input.pointer.PointerIcon

/**
 * Pointer icon for a horizontal-resize affordance — a left/right double-arrow,
 * shown over a vertical sash that the user drags horizontally to resize a
 * column.
 *
 * Mirrors Flutter's `SystemMouseCursors.resizeColumn`. Each platform supplies
 * the closest native cursor; targets without a cursor concept (mobile)
 * fall back to [PointerIcon.Default].
 */
expect val ResizeColumnPointerIcon: PointerIcon

/**
 * Pointer icon for a vertical-resize affordance — an up/down double-arrow,
 * shown over a horizontal sash that the user drags vertically to resize a row.
 *
 * Mirrors Flutter's `SystemMouseCursors.resizeRow`.
 */
expect val ResizeRowPointerIcon: PointerIcon
