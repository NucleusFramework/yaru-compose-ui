package dev.nucleusframework.yarucompose.foundation

import androidx.compose.ui.input.pointer.PointerIcon

// iOS has no cursor model; ignore the resize affordance and use the default.
actual val ResizeColumnPointerIcon: PointerIcon = PointerIcon.Default
actual val ResizeRowPointerIcon: PointerIcon = PointerIcon.Default
