package dev.nucleusframework.yarucompose.foundation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.fromKeyword

@OptIn(ExperimentalComposeUiApi::class)
actual val ResizeColumnPointerIcon: PointerIcon =
    PointerIcon.Companion.fromKeyword("ew-resize")

@OptIn(ExperimentalComposeUiApi::class)
actual val ResizeRowPointerIcon: PointerIcon =
    PointerIcon.Companion.fromKeyword("ns-resize")
