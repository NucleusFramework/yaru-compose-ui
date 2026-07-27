package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import androidx.compose.ui.text.style.TextOverflow
import dev.nucleusframework.yarucompose.themes.LocalYaruTextMaxLines
import dev.nucleusframework.yarucompose.themes.LocalYaruTextOverflow
import dev.nucleusframework.yarucompose.themes.LocalYaruTextSoftWrap
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.findRootCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.unit.LayoutDirection
import dev.nucleusframework.yarucompose.window.LocalWindowControls
import dev.nucleusframework.yarucompose.window.LocalWindowControlsLeadingInset
import dev.nucleusframework.yarucompose.window.LocalWindowDragAreaModifier
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.isLight

/** Style of the title bar. Mirrors `YaruTitleBarStyle` from Dart. */
enum class YaruTitleBarStyle { Hidden, Undecorated, Normal }

/**
 * A generic title bar.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_title_bar.dart`. The title is rendered
 * with `titleLarge.copy(fontSize = 14.sp, fontWeight = W500)` — see the Dart
 * source line 189-195 (`copyWith(fontSize: 14, fontWeight: w500)` on
 * `titleLarge`). A 1-pixel bottom border is drawn using black at 10% (light) /
 * white at 6% (dark) — see the Dart source line 198-203 — or 100% in
 * high-contrast mode.
 *
 * Window control buttons (minimize/maximize/restore/close) are appended to the
 * trailing edge when the corresponding `is*` flag is `true` and `style` is
 * [YaruTitleBarStyle.Normal]. The button platform style ([YaruWindowControlPlatform])
 * defaults to [YaruWindowControlPlatform.Yaru] but can be overridden — host apps
 * pick the macOS / Windows variant per their environment.
 */
private const val EDGE_TOLERANCE_PX = 1f

@Composable
fun YaruTitleBar(
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null,
    centerTitle: Boolean = true,
    titleSpacing: Dp = 16.dp,
    backgroundColor: Color = LocalYaruColorScheme.current.surface,
    style: YaruTitleBarStyle = YaruTitleBarStyle.Normal,
    isClosable: Boolean = false,
    isMaximizable: Boolean = false,
    isMinimizable: Boolean = false,
    isRestorable: Boolean = false,
    onClose: (() -> Unit)? = null,
    onMaximize: (() -> Unit)? = null,
    onMinimize: (() -> Unit)? = null,
    onRestore: (() -> Unit)? = null,
    platform: YaruWindowControlPlatform = YaruWindowControlPlatform.Yaru,
    buttonSpacing: Dp = 14.dp,
    buttonPadding: PaddingValues = PaddingValues(horizontal = 10.dp),
    showBorder: Boolean = true,
) {
    if (style == YaruTitleBarStyle.Hidden) return

    // Defensive: `Modifier.background` rejects colors with non-finite channels
    // (e.g. `Color.Unspecified` / NaN alpha from a stale animation). Coerce
    // before forwarding to the modifier chain.
    val safeBackgroundColor = sanitiseColor(backgroundColor)

    // Defensive: Compose's `padding` / `Spacer.width` modifiers throw on
    // negative dp, and a non-finite Dp (NaN / +-Infinity) blows up
    // `roundToPx()`. Route through the canonical `Dp.sanitise()` foundation
    // helper.
    val safeTitleSpacing = titleSpacing.sanitise()
    val safeButtonSpacing = buttonSpacing.sanitise()
    val layoutDirection = LocalLayoutDirection.current
    val safeButtonPadding = buttonPadding.coerceNonNegative(layoutDirection)

    // Bottom border color — mirrors the `defaultBorder` block in
    // `yaru_title_bar.dart` line 198-203:
    //   light ? Colors.black.withValues(alpha: HC ? 1 : 0.1)
    //         : Colors.white.withValues(alpha: HC ? 1 : 0.06)
    // This is intentionally NOT the divider color — the title bar uses pure
    // black/white tinted by alpha, not the theme's `outline`-derived divider.
    val scheme = LocalYaruColorScheme.current
    val borderColor = if (scheme.isLight) {
        Color.Black.copy(alpha = if (scheme.isHighContrast) 1f else 0.1f)
    } else {
        Color.White.copy(alpha = if (scheme.isHighContrast) 1f else 0.06f)
    }

    // Border-bottom is only drawn for the "normal" decorated style — mirrors
    // the Dart code which omits the bottom border for `undecorated` / `hidden`.
    val drawBorder = showBorder && style == YaruTitleBarStyle.Normal

    // A windowing layer (Nucleus' `YaruDecoratedWindow`) owns which controls
    // exist, their order and their side; it hands them over through
    // [LocalWindowControls] and the Yaru artwork is used to draw them. Without
    // one, fall back to the callback-driven row below.
    val hostControls = LocalWindowControls.current
    val showWindowControls = style == YaruTitleBarStyle.Normal &&
        (hostControls != null || isClosable || isMaximizable || isMinimizable || isRestorable)

    // Title text style — `titleLarge.copy(fontSize = 14.sp, fontWeight = W500)`
    // matches `theme.textTheme.titleLarge.copyWith(fontSize: 14, fontWeight: w500)`
    // from `yaru_title_bar.dart` line 189-195. Note: NOT `titleMedium` (16) —
    // the Dart code starts from `titleLarge` and overrides the size to 14.
    val titleTextStyle = LocalYaruTypography.current.titleLarge.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
    )

    // Systems that draw their own controls over the client area (the macOS
    // traffic-lights) only cover the window's leading corner, so only a bar
    // sitting there must keep their footprint clear — a GNOME master/detail
    // layout puts a second headerbar next to it that must not be indented.
    val requestedLeadingInset = LocalWindowControlsLeadingInset.current
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    var atWindowLeadingCorner by remember { mutableStateOf(false) }
    val leadingInset = if (atWindowLeadingCorner) requestedLeadingInset else 0.dp

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(YaruConstants.TitleBarHeight)
            .then(
                if (requestedLeadingInset > 0.dp) {
                    Modifier.onGloballyPositioned { coordinates ->
                        val position = coordinates.positionInWindow()
                        val atTop = position.y <= EDGE_TOLERANCE_PX
                        val atLeading =
                            if (isRtl) {
                                val rootWidth = coordinates.findRootCoordinates().size.width
                                position.x + coordinates.size.width >= rootWidth - EDGE_TOLERANCE_PX
                            } else {
                                position.x <= EDGE_TOLERANCE_PX
                            }
                        atWindowLeadingCorner = atTop && atLeading
                    }
                } else {
                    Modifier
                },
            ).background(safeBackgroundColor)
            // Dragging the headerbar background moves the window; interactive
            // children opt out by consuming the press. No-op without a
            // windowing layer.
            .then(LocalWindowDragAreaModifier.current)
            .then(
                if (drawBorder) Modifier.drawBehind {
                    // Defensive: convert the 1 logical-pixel stroke through the DrawScope's `toPx()` so the border keeps its intended thickness on >1.0x screens; a raw `1f` would render as a half-thickness hairline at 2x.
                    val strokePx = 1.dp.toPx()
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, size.height - strokePx / 2f),
                        end = Offset(size.width, size.height - strokePx / 2f),
                        strokeWidth = strokePx,
                    )
                } else Modifier,
            )
            // Defensive: when window controls are present, drop the trailing outer padding so the close button reaches the right edge with only WindowControlsRow's own 10dp inner padding (matching Dart `_kYaruTitleBarPadding = 10`). Without this, the symmetric `horizontal = 16dp` outer padding stacked on top of WindowControlsRow's 10dp inset pushed the close button 26dp away from the corner.
            .padding(
                // Systems that draw their own controls over the client area
                // (macOS traffic-lights) need their footprint kept clear.
                start = safeTitleSpacing + leadingInset,
                end = if (showWindowControls) 0.dp else safeTitleSpacing,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (centerTitle) Arrangement.SpaceBetween else Arrangement.Start,
    ) {
        if (leading != null) {
            leading()
            Spacer(Modifier.width(8.dp))
        }
        if (centerTitle) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                if (title != null) {
                    CompositionLocalProvider(
                        LocalYaruTextStyle provides titleTextStyle,
                        // Mirrors Flutter's AppBar, which wraps its title in a
                        // DefaultTextStyle with `softWrap: false` +
                        // ellipsis: a headerbar title never wraps, it truncates.
                        LocalYaruTextSoftWrap provides false,
                        LocalYaruTextOverflow provides TextOverflow.Ellipsis,
                        LocalYaruTextMaxLines provides 1,
                    ) { title() }
                }
            }
        } else if (title != null) {
            // Defensive: weight the title so a long unellipsised title cannot push trailing actions / window controls offscreen.
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                CompositionLocalProvider(
                    LocalYaruTextStyle provides titleTextStyle,
                    LocalYaruTextSoftWrap provides false,
                    LocalYaruTextOverflow provides TextOverflow.Ellipsis,
                    LocalYaruTextMaxLines provides 1,
                ) { title() }
            }
        }
        if (actions != null) {
            Spacer(Modifier.width(8.dp))
            actions()
        }
        if (showWindowControls) {
            Spacer(Modifier.width(8.dp))
        }
        if (showWindowControls && hostControls != null) {
            hostControls()
        } else if (showWindowControls) {
            WindowControlsRow(
                platform = platform,
                spacing = safeButtonSpacing,
                padding = safeButtonPadding,
                isClosable = isClosable,
                isMaximizable = isMaximizable,
                isMinimizable = isMinimizable,
                isRestorable = isRestorable,
                onClose = onClose,
                onMaximize = onMaximize,
                onMinimize = onMinimize,
                onRestore = onRestore,
            )
        }
    }
}

/**
 * A window title bar — convenience wrapper exposing the standard set of window
 * controls (minimize / maximize / close).
 *
 * Mirrors `YaruWindowTitleBar` in `yaru.dart/lib/src/widgets/yaru_title_bar.dart`.
 */
@Composable
fun YaruWindowTitleBar(
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null,
    centerTitle: Boolean = true,
    titleSpacing: Dp = 16.dp,
    backgroundColor: Color = LocalYaruColorScheme.current.surface,
    style: YaruTitleBarStyle = YaruTitleBarStyle.Normal,
    isClosable: Boolean = true,
    isMaximizable: Boolean = true,
    isMinimizable: Boolean = true,
    isRestorable: Boolean = false,
    onClose: (() -> Unit)? = null,
    onMaximize: (() -> Unit)? = null,
    onMinimize: (() -> Unit)? = null,
    onRestore: (() -> Unit)? = null,
    platform: YaruWindowControlPlatform = YaruWindowControlPlatform.Yaru,
) {
    YaruTitleBar(
        modifier = modifier,
        leading = leading,
        title = title,
        actions = actions,
        centerTitle = centerTitle,
        titleSpacing = titleSpacing,
        backgroundColor = backgroundColor,
        style = style,
        isClosable = isClosable,
        isMaximizable = isMaximizable,
        isMinimizable = isMinimizable,
        isRestorable = isRestorable,
        onClose = onClose,
        onMaximize = onMaximize,
        onMinimize = onMinimize,
        onRestore = onRestore,
        platform = platform,
    )
}

/**
 * A dialog title bar — close-only by default.
 *
 * Mirrors `YaruDialogTitleBar` in `yaru.dart/lib/src/widgets/yaru_title_bar.dart`.
 */
@Composable
fun YaruDialogTitleBar(
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null,
    centerTitle: Boolean = true,
    titleSpacing: Dp = 16.dp,
    backgroundColor: Color = LocalYaruColorScheme.current.surface,
    isClosable: Boolean = true,
    onClose: (() -> Unit)? = null,
    platform: YaruWindowControlPlatform = YaruWindowControlPlatform.Yaru,
) {
    YaruTitleBar(
        modifier = modifier,
        leading = leading,
        title = title,
        actions = actions,
        centerTitle = centerTitle,
        titleSpacing = titleSpacing,
        backgroundColor = backgroundColor,
        style = YaruTitleBarStyle.Normal,
        isClosable = isClosable,
        isMaximizable = false,
        isMinimizable = false,
        isRestorable = false,
        onClose = onClose,
        platform = platform,
    )
}

@Composable
private fun WindowControlsRow(
    platform: YaruWindowControlPlatform,
    spacing: Dp,
    padding: PaddingValues,
    isClosable: Boolean,
    isMaximizable: Boolean,
    isMinimizable: Boolean,
    isRestorable: Boolean,
    onClose: (() -> Unit)?,
    onMaximize: (() -> Unit)?,
    onMinimize: (() -> Unit)?,
    onRestore: (() -> Unit)?,
) {
    Row(
        modifier = Modifier.padding(padding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var first = true
        if (isMinimizable) {
            if (!first) Spacer(Modifier.width(spacing))
            first = false
            YaruWindowControl(
                type = YaruWindowControlType.Minimize,
                platform = platform,
                onTap = onMinimize,
            )
        }
        if (isRestorable) {
            if (!first) Spacer(Modifier.width(spacing))
            first = false
            YaruWindowControl(
                type = YaruWindowControlType.Restore,
                platform = platform,
                onTap = onRestore,
            )
        }
        if (isMaximizable) {
            if (!first) Spacer(Modifier.width(spacing))
            first = false
            YaruWindowControl(
                type = YaruWindowControlType.Maximize,
                platform = platform,
                onTap = onMaximize,
            )
        }
        if (isClosable) {
            if (!first) Spacer(Modifier.width(spacing))
            // Mirrors `yaru_title_bar.dart` line 325-335: when only close is
            // visible (no max/restore), wrap in a topRight rounded clip using
            // `kYaruWindowRadius` so the dialog corner stays round.
            val onlyClose = !isMaximizable && !isRestorable
            val clipModifier = if (onlyClose) {
                Modifier.clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = YaruConstants.WindowRadius,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,
                    ),
                )
            } else {
                Modifier
            }
            Box(modifier = clipModifier) {
                YaruWindowControl(
                    type = YaruWindowControlType.Close,
                    platform = platform,
                    onTap = onClose,
                )
            }
        }
    }
}

