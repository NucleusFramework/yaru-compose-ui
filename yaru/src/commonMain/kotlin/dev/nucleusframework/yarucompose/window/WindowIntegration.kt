package dev.nucleusframework.yarucompose.window

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruColorScheme

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
 * Horizontal space reserved at the LEADING edge of a headerbar for window
 * controls the system draws itself — the macOS traffic-lights, which float
 * over the client area.
 *
 * Zero when the window layer draws no controls over the bar, or draws them
 * on the trailing edge (see [LocalWindowControlsTrailingInset]).
 */
val LocalWindowControlsLeadingInset = compositionLocalOf { 0.dp }

/**
 * Horizontal space reserved at the TRAILING edge of a headerbar for window
 * controls the window layer draws over it — the toolkit-drawn buttons on
 * Windows and Linux, when the desktop puts them on that side.
 *
 * Zero when the controls sit on the leading edge (see
 * [LocalWindowControlsLeadingInset]) or when there are none.
 */
val LocalWindowControlsTrailingInset = compositionLocalOf { 0.dp }

/**
 * Lets the theme push its resolved color scheme up to the windowing layer.
 *
 * The window needs it for its own surfaces — the native background (which
 * shows wherever Compose has not painted, most visibly while resizing), the
 * appearance of native controls, and any chrome it draws *outside* the app
 * content, such as the window control buttons: those are composed above the
 * content and would otherwise fall back to the default light scheme, leaving
 * their hover states invisible on a dark theme.
 *
 * The theme is applied *inside* the window content, so the window cannot read
 * it directly — hence this upward hop. `null` when there is no window to sync.
 */
val LocalNativeWindowSync = compositionLocalOf<((scheme: YaruColorScheme) -> Unit)?> { null }
