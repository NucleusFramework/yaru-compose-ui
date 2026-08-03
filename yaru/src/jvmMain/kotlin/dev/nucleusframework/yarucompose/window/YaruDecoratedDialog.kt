package dev.nucleusframework.yarucompose.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogState
import androidx.compose.ui.window.rememberDialogState
import dev.nucleusframework.application.DecoratedDialog
import dev.nucleusframework.application.NucleusApplicationScope
import dev.nucleusframework.application.NucleusDecoratedDialogScope
import dev.nucleusframework.window.ControlButtonsDirection
import dev.nucleusframework.window.DecoratedDialogScope
import dev.nucleusframework.window.DecoratedDialogState
import dev.nucleusframework.window.DialogTitleBar
import dev.nucleusframework.window.NucleusDecoratedWindowTheme
import dev.nucleusframework.window.TitleBarScope
import dev.nucleusframework.window.noWindowDrag
import dev.nucleusframework.window.styling.LocalDecoratedWindowStyle
import dev.nucleusframework.window.styling.LocalTitleBarStyle
import dev.nucleusframework.window.styling.TitleBarStyle
import dev.nucleusframework.window.windowDragArea
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColorScheme

/**
 * Yaru-styled wrapper for Nucleus' `DecoratedDialog` — the dialog counterpart
 * of [YaruDecoratedWindow], and the same shape as Nucleus' other design-system
 * wrappers (`MaterialDecoratedDialog`, `JewelDecoratedDialog`).
 *
 * The dialog is a real native window owned by the enclosing
 * [YaruDecoratedWindow]: it floats above its owner, follows it across
 * workspaces, stays out of the taskbar and closes with it. Its chrome is
 * close-only and drawn by the windowing layer in the platform's own style, so
 * the close button is the actual GNOME / Fluent control rather than a
 * Compose-drawn stand-in.
 *
 * Compose it from `dev.nucleusframework.application.nucleusApplication`, and
 * put a [YaruDecoratedDialogTitleBar] at the top of [content] to get the
 * headerbar with that native close button:
 *
 * ```
 * YaruDecoratedDialog(onCloseRequest = { showSettings = false }, title = "Settings") {
 *     YaruTheme(isDark = isDark) {
 *         YaruDecoratedDialogTitleBar { YaruText("Settings") }
 *         // …dialog body…
 *     }
 * }
 * ```
 *
 * For a dialog that must stay inside the window — mobile, web, or an overlay
 * that should not become a top-level — use a Compose `Dialog` with
 * [dev.nucleusframework.yarucompose.widgets.YaruDialogTitleBar]; its
 * [dev.nucleusframework.yarucompose.widgets.YaruCloseButton] paints the same
 * control.
 */
@Suppress("FunctionNaming", "LongParameterList")
@Composable
fun NucleusApplicationScope.YaruDecoratedDialog(
    onCloseRequest: () -> Unit,
    state: DialogState = rememberDialogState(),
    visible: Boolean = true,
    title: String = "",
    icon: Painter? = null,
    resizable: Boolean = false,
    enabled: Boolean = true,
    focusable: Boolean = true,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    content: @Composable NucleusDecoratedDialogScope.() -> Unit,
) {
    // Same hop as [YaruDecoratedWindow]: the YaruTheme lives inside [content],
    // so it publishes its resolved scheme back up through LocalNativeWindowSync
    // instead of being read here, where only the defaults exist.
    var themeScheme by remember { mutableStateOf<YaruColorScheme?>(null) }
    val nativeWindowSync: (YaruColorScheme) -> Unit = { scheme -> themeScheme = scheme }
    var contentDirection by remember { mutableStateOf<LayoutDirection?>(null) }
    val layoutDirectionSync: (LayoutDirection) -> Unit = { direction -> contentDirection = direction }
    val isDarkTheme = themeScheme?.isDark ?: false

    // The dialog surface is what shows wherever Compose has not painted (most
    // visibly while the window maps), so hand the native layer the theme's
    // background — same treatment [YaruDecoratedWindow] gives its window.
    val baseWindowStyle = LocalDecoratedWindowStyle.current
    val windowStyle = baseWindowStyle.copy(
        colors = baseWindowStyle.colors.copy(background = themeScheme?.surface ?: Color.Unspecified),
    )
    NucleusDecoratedWindowTheme(isDark = isDarkTheme, windowStyle = windowStyle) {
        DecoratedDialog(
            onCloseRequest = onCloseRequest,
            state = state,
            visible = visible,
            title = title,
            icon = icon,
            resizable = resizable,
            enabled = enabled,
            focusable = focusable,
            onPreviewKeyEvent = onPreviewKeyEvent,
            onKeyEvent = onKeyEvent,
        ) {
            CompositionLocalProvider(
                LocalWindowDragAreaModifier provides Modifier.windowDragArea(),
                LocalNoWindowDragModifier provides Modifier.noWindowDrag(),
                LocalNativeWindowSync provides nativeWindowSync,
                LocalWindowLayoutDirectionSync provides layoutDirectionSync,
            ) {
                content()
            }
        }
    }
}

/**
 * The close-only headerbar of a [YaruDecoratedDialog]: Nucleus draws the
 * native control, this only pins the Yaru title typography over it.
 *
 * Mirrors `YaruDialogTitleBar`'s text style —
 * `titleLarge.copyWith(fontSize: 14, fontWeight: w500)` from
 * `yaru_title_bar.dart`.
 */
@Suppress("FunctionNaming")
@Composable
fun DecoratedDialogScope.YaruDecoratedDialogTitleBar(
    modifier: Modifier = Modifier,
    gradientStartColor: Color = Color.Unspecified,
    style: TitleBarStyle = LocalTitleBarStyle.current,
    controlButtonsDirection: ControlButtonsDirection = ControlButtonsDirection.Auto,
    content: @Composable TitleBarScope.(DecoratedDialogState) -> Unit = {},
) {
    val titleTextStyle = LocalYaruTypography.current.titleLarge.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
    )
    DialogTitleBar(
        modifier = modifier,
        gradientStartColor = gradientStartColor,
        style = style,
        controlButtonsDirection = controlButtonsDirection,
    ) { dialogState ->
        CompositionLocalProvider(LocalYaruTextStyle provides titleTextStyle) {
            content(dialogState)
        }
    }
}
