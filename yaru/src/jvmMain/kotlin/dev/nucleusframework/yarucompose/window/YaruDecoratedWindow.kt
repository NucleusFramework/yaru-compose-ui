package dev.nucleusframework.yarucompose.window

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import dev.nucleusframework.application.DecoratedWindow
import dev.nucleusframework.application.NucleusApplicationScope
import dev.nucleusframework.application.NucleusDecoratedWindowScope
import dev.nucleusframework.core.runtime.Platform
import dev.nucleusframework.window.ControlButtonsDirection
import dev.nucleusframework.window.DecoratedWindowScope
import dev.nucleusframework.window.LocalWindowChromeInsets
import dev.nucleusframework.window.TitleBarPlacement
import dev.nucleusframework.window.WindowControlType
import dev.nucleusframework.window.WindowControls
import dev.nucleusframework.window.WindowControlsRenderer
import dev.nucleusframework.window.WindowScaffold
import dev.nucleusframework.window.utils.linux.rememberLinuxButtonLayout
import dev.nucleusframework.window.noWindowDrag
import dev.nucleusframework.window.styling.LocalDecoratedWindowStyle
import dev.nucleusframework.window.windowDragArea
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruWindowControl
import dev.nucleusframework.yarucompose.widgets.YaruWindowControlPlatform
import dev.nucleusframework.yarucompose.widgets.YaruWindowControlType

/**
 * Yaru-styled wrapper for Nucleus' `DecoratedWindow` — the YaruCompose
 * counterpart of `JewelDecoratedWindow` / `MaterialDecoratedWindow`.
 *
 * The window is client-side decorated: no system title bar, the Yaru
 * headerbar *is* the chrome. It wires the widgets to the windowing layer so
 * they behave like a native GNOME window:
 * - [dev.nucleusframework.yarucompose.widgets.YaruTitleBar] drags the window
 *   by its background and double-click toggles maximize;
 * - its control buttons are drawn with [YaruWindowControl] but driven by
 *   Nucleus, which follows the desktop's own `button-layout` (order and
 *   side), swaps maximize/restore with the window state and routes close
 *   through [onCloseRequest];
 * - the window background follows the Yaru theme, so resizing never flashes.
 *
 * Call it from `dev.nucleusframework.application.nucleusApplication`. The
 * [content] receives the window scope, so it can reach the window state and
 * the Nucleus chrome APIs.
 */
@Suppress("FunctionNaming", "LongParameterList")
@Composable
fun NucleusApplicationScope.YaruDecoratedWindow(
    onCloseRequest: () -> Unit,
    state: WindowState = rememberWindowState(),
    visible: Boolean = true,
    title: String = "",
    icon: Painter? = null,
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    hiddenFromDock: Boolean = false,
    minimumSize: DpSize? = null,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    // Height of the app's headerbar. The native layer centres the macOS
    // traffic-lights against it, so it must match the bar actually composed.
    titleBarHeight: Dp = YaruConstants.TitleBarHeight,
    // Windows draws square Fluent-metric buttons rather than the Yaru discs;
    // the artwork stays Yaru's in both cases (see [YaruWindowControlPlatform]).
    controlPlatform: YaruWindowControlPlatform =
        if (Platform.Current == Platform.Windows) {
            YaruWindowControlPlatform.Windows
        } else {
            YaruWindowControlPlatform.Yaru
        },
    content: @Composable NucleusDecoratedWindowScope.() -> Unit,
) {
    // The YaruTheme lives inside [content], so it pushes its resolved scheme
    // up through LocalNativeWindowSync — reading it here would only ever see
    // the defaults.
    var themeScheme by remember { mutableStateOf<YaruColorScheme?>(null) }
    val nativeWindowSync: (YaruColorScheme) -> Unit = { scheme -> themeScheme = scheme }
    val background = themeScheme?.surface ?: Color.Unspecified

    val baseWindowStyle = LocalDecoratedWindowStyle.current
    CompositionLocalProvider(
        LocalDecoratedWindowStyle provides
            baseWindowStyle.copy(colors = baseWindowStyle.colors.copy(background = background)),
    ) {
        DecoratedWindow(
            onCloseRequest = onCloseRequest,
            state = state,
            visible = visible,
            title = title,
            icon = icon,
            resizable = resizable,
            enabled = enabled,
            focusable = focusable,
            alwaysOnTop = alwaysOnTop,
            hiddenFromDock = hiddenFromDock,
            minimumSize = minimumSize,
            onPreviewKeyEvent = onPreviewKeyEvent,
            onKeyEvent = onKeyEvent,
        ) {
            val windowScope = this
            // Transparent, non-interactive strip matching the headerbar
            // height: a Yaru app composes its own headerbars (GNOME layouts
            // routinely show several side by side), so the slot only exists to
            // publish that height to the native layer — which is what centres
            // the macOS traffic-lights inside the bar and sizes the Windows
            // caption zone. Overlay placement keeps the app's content starting
            // at the top, under the strip.
            // macOS keeps its real AppKit traffic-lights on the leading edge;
            // everywhere else the window is fully undecorated and the controls
            // are drawn here — at window level rather than inside a headerbar,
            // because a Yaru app may compose several (master + detail) or none
            // at all, and the window must stay closable either way.
            val isMacOS = Platform.Current == Platform.MacOS
            val linuxLayout =
                if (Platform.Current == Platform.Linux) rememberLinuxButtonLayout() else null
            // The desktop decides which side the buttons live on
            // (GNOME's `button-layout`); default to the trailing edge.
            val controlsOnTrailingEdge = linuxLayout?.controlsOnRight ?: true
            var controlsWidth by remember { mutableStateOf(0.dp) }
            val density = LocalDensity.current

            WindowScaffold(
                titleBar = {
                    Box(Modifier.fillMaxWidth().height(titleBarHeight)) {
                        if (!isMacOS) {
                            Box(
                                modifier =
                                    Modifier
                                        .align(
                                            if (controlsOnTrailingEdge) {
                                                Alignment.CenterEnd
                                            } else {
                                                Alignment.CenterStart
                                            },
                                        ).onSizeChanged { size ->
                                            controlsWidth = with(density) { size.width.toDp() }
                                        },
                            ) {
                                // Composed above the app content, so outside
                                // YaruTheme: without the synced scheme the
                                // buttons would use the default light palette
                                // and their hover states would be invisible on
                                // a dark theme.
                                WithYaruScheme(themeScheme) {
                                    windowScope.YaruWindowControls(controlPlatform)
                                }
                            }
                        }
                    }
                },
                titleBarPlacement = TitleBarPlacement.Overlay(autoHideInFullscreen = false),
            ) { _ ->
                // Whatever the window draws over a headerbar has to be kept
                // clear of its content: the traffic-light footprint on macOS,
                // the measured button strip elsewhere.
                val trafficLightInset =
                    if (isMacOS) {
                        val insets = LocalWindowChromeInsets.current.controlsInsets
                        maxOf(
                            insets.calculateLeftPadding(LayoutDirection.Ltr),
                            insets.calculateRightPadding(LayoutDirection.Ltr),
                        )
                    } else {
                        0.dp
                    }
                CompositionLocalProvider(
                    LocalWindowDragAreaModifier provides Modifier.windowDragArea(),
                    LocalNoWindowDragModifier provides Modifier.noWindowDrag(),
                    LocalNativeWindowSync provides nativeWindowSync,
                    LocalWindowControlsLeadingInset provides
                        if (isMacOS) {
                            trafficLightInset
                        } else if (!controlsOnTrailingEdge) {
                            controlsWidth
                        } else {
                            0.dp
                        },
                    LocalWindowControlsTrailingInset provides
                        if (!isMacOS && controlsOnTrailingEdge) controlsWidth else 0.dp,
                ) {
                    windowScope.content()
                }
            }
        }
    }
}

/** Applies the theme scheme the app pushed up, if any. */
@Suppress("FunctionNaming")
@Composable
private fun WithYaruScheme(
    scheme: YaruColorScheme?,
    content: @Composable () -> Unit,
) {
    if (scheme == null) {
        content()
    } else {
        CompositionLocalProvider(LocalYaruColorScheme provides scheme, content = content)
    }
}

/** The platform's window controls, drawn with Yaru artwork. */
@Suppress("FunctionNaming")
@Composable
private fun DecoratedWindowScope.YaruWindowControls(controlPlatform: YaruWindowControlPlatform) {
    Row(
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        WindowControls(
            direction = ControlButtonsDirection.Auto,
            renderer = YaruWindowControlsRenderer(controlPlatform),
        )
    }
}

/**
 * Draws each control Nucleus asks for with [YaruWindowControl]. Nucleus keeps
 * every decision (which buttons, in which order, on which side, and what they
 * do); this only maps the type onto the Yaru glyph.
 */
private class YaruWindowControlsRenderer(
    private val controlPlatform: YaruWindowControlPlatform,
) : WindowControlsRenderer {
    @Composable
    override fun Control(
        type: WindowControlType,
        state: dev.nucleusframework.window.DecoratedWindowState,
        onClick: () -> Unit,
    ) {
        val yaruType =
            when (type) {
                WindowControlType.Minimize -> YaruWindowControlType.Minimize
                WindowControlType.Maximize -> YaruWindowControlType.Maximize
                // Leaving fullscreen is the same "shrink back" affordance as
                // restoring a maximized window.
                WindowControlType.Restore, WindowControlType.ExitFullscreen ->
                    YaruWindowControlType.Restore
                WindowControlType.Close -> YaruWindowControlType.Close
            }
        YaruWindowControl(
            type = yaruType,
            onTap = onClick,
            platform = controlPlatform,
        )
    }
}
