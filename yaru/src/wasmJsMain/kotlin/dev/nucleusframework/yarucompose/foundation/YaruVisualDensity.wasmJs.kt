package dev.nucleusframework.yarucompose.foundation

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Web is served to desktop browsers first — `VisualDensity.compact`, matching
 * Flutter web on a Linux / macOS / Windows host.
 */
internal actual val YaruBaseSizeAdjustment: Dp = (-8).dp
