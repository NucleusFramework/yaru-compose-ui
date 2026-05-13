package dev.nucleusframework.yarucompose.foundation

import androidx.compose.ui.input.pointer.PointerIcon

// Android touch devices have no persistent cursor concept; mouse-attached
// Chromebooks/tablets fall back to the default arrow rather than crashing on
// a stale Context lookup at static-init time.
actual val ResizeColumnPointerIcon: PointerIcon = PointerIcon.Default
actual val ResizeRowPointerIcon: PointerIcon = PointerIcon.Default
