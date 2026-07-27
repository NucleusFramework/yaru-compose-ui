package dev.nucleusframework.yarucompose.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Contracts a windowing layer can fulfil so the Yaru widgets behave like a
 * real GNOME client-side-decorated window.
 *
 * They are all optional: with no window layer (Android, web, iOS, a plain
 * Compose Desktop window) the defaults make the widgets behave exactly as
 * before, driven by the callbacks the caller passes them. On the JVM,
 * `YaruDecoratedWindow` provides all of them.
 */

/**
 * Modifier that turns a component into a window drag region — dragging its
 * background moves the window, as a GNOME headerbar does.
 *
 * Interactive children opt out by consuming the press; those that only claim
 * the pointer once it moves (scrollbars, sliders) must use
 * [LocalNoWindowDragModifier].
 *
 * Defaults to [Modifier] (no-op).
 */
val LocalWindowDragAreaModifier = compositionLocalOf<Modifier> { Modifier }

/**
 * Modifier that opts a component out of the surrounding window drag area.
 *
 * Defaults to [Modifier] (no-op).
 */
val LocalNoWindowDragModifier = compositionLocalOf<Modifier> { Modifier }

/**
 * The window controls (minimize / maximize-restore / close) as rendered by
 * the windowing layer.
 *
 * The host owns the semantics — which buttons exist, their order and side
 * (on Linux the desktop's own `button-layout` decides), the
 * maximize/restore swap and the close routing — while the artwork stays
 * Yaru's. [dev.nucleusframework.yarucompose.widgets.YaruTitleBar] renders
 * this instead of its own callback-driven control row whenever it is
 * present.
 *
 * `null` when no window layer is available; the title bar then falls back to
 * its `isClosable` / `onClose` … parameters.
 */
val LocalWindowControls = compositionLocalOf<(@Composable () -> Unit)?> { null }

/**
 * Horizontal space reserved at the LEADING edge of a headerbar for window
 * controls the system draws itself — the macOS traffic-lights, which float
 * over the client area.
 *
 * Zero on GNOME and Windows, where the buttons are drawn by the toolkit and
 * come through [LocalWindowControls] instead.
 */
val LocalWindowControlsLeadingInset = compositionLocalOf { 0.dp }

/**
 * Lets the theme push its resolved appearance up to the windowing layer, so
 * native surfaces (window background, and on macOS the traffic lights and
 * system materials) follow the Yaru theme instead of the OS setting.
 *
 * The theme is applied *inside* the window content, so the window cannot read
 * it directly — hence this upward hop. `null` when there is no window to sync.
 */
val LocalNativeWindowSync = compositionLocalOf<((isDark: Boolean, background: Color) -> Unit)?> { null }
