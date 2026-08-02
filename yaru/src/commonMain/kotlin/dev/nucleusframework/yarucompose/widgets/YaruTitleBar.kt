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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
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
import dev.nucleusframework.yarucompose.window.LocalWindowControlsLeadingInset
import dev.nucleusframework.yarucompose.window.LocalWindowControlsTrailingInset
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
 * The bar draws no window controls: minimize / maximize / restore / close are
 * the windowing layer's business (Nucleus' `YaruDecoratedWindow` draws them in
 * the platform's own style, on the side the desktop asks for) and it reserves
 * their footprint through [LocalWindowControlsLeadingInset] /
 * [LocalWindowControlsTrailingInset]. [isClosable] only covers the dialog case
 * — a close affordance on a surface that is not a window.
 *
 * [shape] mirrors the Dart `shape` argument: square by default, rounded on top
 * for the dialog variant (see [YaruDialogTitleBarDefaults.Shape]) so a bar
 * capping a rounded surface does not square off its corners.
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
    shape: Shape = RectangleShape,
    isClosable: Boolean = false,
    onClose: (() -> Unit)? = null,
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

    // Dialog-only close affordance; real windows get their controls from the
    // windowing layer.
    val showCloseButton = style == YaruTitleBarStyle.Normal && isClosable

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
    val requestedTrailingInset = LocalWindowControlsTrailingInset.current
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    var atWindowLeadingCorner by remember { mutableStateOf(false) }
    var atWindowTrailingCorner by remember { mutableStateOf(false) }
    val leadingInset = if (atWindowLeadingCorner) requestedLeadingInset else 0.dp
    val trailingInset = if (atWindowTrailingCorner) requestedTrailingInset else 0.dp
    val tracksCorners = requestedLeadingInset > 0.dp || requestedTrailingInset > 0.dp

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(YaruConstants.TitleBarHeight)
            .then(
                if (tracksCorners) {
                    Modifier.onGloballyPositioned { coordinates ->
                        val position = coordinates.positionInWindow()
                        val rootWidth = coordinates.findRootCoordinates().size.width
                        val atTop = position.y <= EDGE_TOLERANCE_PX
                        val atLeft = position.x <= EDGE_TOLERANCE_PX
                        val atRight =
                            position.x + coordinates.size.width >= rootWidth - EDGE_TOLERANCE_PX
                        atWindowLeadingCorner = atTop && if (isRtl) atRight else atLeft
                        atWindowTrailingCorner = atTop && if (isRtl) atLeft else atRight
                    }
                } else {
                    Modifier
                },
            ).background(color = safeBackgroundColor, shape = shape)
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
            // Defensive: when the close button is present, drop the trailing outer padding so it reaches the right edge with only its own 10dp inner padding (matching Dart `_kYaruTitleBarPadding = 10`). Without this, the symmetric `horizontal = 16dp` outer padding stacked on top of that 10dp inset pushed the button 26dp away from the corner.
            .padding(
                // Systems that draw their own controls over the client area
                // (macOS traffic-lights) need their footprint kept clear.
                start = safeTitleSpacing + leadingInset,
                end = (if (showCloseButton) 0.dp else safeTitleSpacing) + trailingInset,
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
        if (showCloseButton) {
            Spacer(Modifier.width(8.dp))
            YaruCloseButton(
                modifier = Modifier.padding(safeButtonPadding),
                onPressed = onClose ?: {},
                enabled = onClose != null,
            )
        }
    }
}

/** Defaults of [YaruDialogTitleBar]. */
object YaruDialogTitleBarDefaults {
    /**
     * Mirrors `YaruDialogTitleBar.defaultShape` — `BorderRadius.vertical(top:
     * Radius.circular(kYaruWindowRadius))`. The bar caps a rounded dialog
     * surface, so it rounds its own top corners rather than relying on the
     * caller to clip it.
     */
    val Shape: Shape = RoundedCornerShape(
        topStart = YaruConstants.WindowRadius,
        topEnd = YaruConstants.WindowRadius,
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
    shape: Shape = YaruDialogTitleBarDefaults.Shape,
    isClosable: Boolean = true,
    onClose: (() -> Unit)? = null,
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
        shape = shape,
        isClosable = isClosable,
        onClose = onClose,
    )
}
