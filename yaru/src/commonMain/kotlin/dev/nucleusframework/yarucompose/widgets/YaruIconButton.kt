package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.settings.LocalYaruTheme
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * A Yaru-styled icon button — Foundation only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_icon_button.dart`.
 *
 * Geometry (matches Dart `defaultStyleOf`):
 *  - `fixedSize: Size(iconSize, iconSize)` and `padding: zero` → the button is
 *    exactly `iconSize` square. Hover / press overlays are clipped to [shape].
 *  - default shape is [CircleShape] (Material `IconButton` default).
 *
 * Color states (mirror `defaultStyleOf`):
 *  - selected fill (`backgroundColor`): `onSurface @ 0.10`
 *  - foreground tint:
 *      - selected + disabled: `primary @ 0.38`
 *      - selected:            `primary`
 *      - disabled:            `onSurface @ 0.38`
 *      - default:             `onSurface @ 0.8`
 *  - overlay (`overlayColor`):
 *      - selected:  `onSurface` (hover 0.08 / focus 0.12 / press 0.12)
 *      - default:   `onSurfaceVariant` (hover 0.08 / focus 0.08 / press 0.12)
 *
 * Focus ring: [YaruFocusBorder] with the [shape] geometry (defaults to a
 * 100 dp-radius circle, matching `BorderRadius.circular(100)` in Dart).
 *
 * Tooltips are intentionally deferred — they require popup positioning that
 * differs across platforms; host apps can wrap with their own tooltip
 * primitive when needed. The [tooltip] parameter is preserved for API
 * compatibility and will be wired up once a foundation-only tooltip lands.
 */
@Composable
fun YaruIconButton(
    onPressed: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconSize: Dp = YaruConstants.IconSize,
    // Mirrors `_IconButtonDefaultsM3.minimumSize = Size(40, 40)`
    // (material/icon_button.dart:1130). Yaru sets `fixedSize: Size(iconSize, iconSize)`
    // (yaru_icon_button.dart:50) but `_RenderButton` clamps it through
    // `effectiveConstraints.constrain(resolvedFixedSize)`
    // (button_style_button.dart:482), so `Size(20, 20)` becomes `Size(40, 40)` —
    // a 40 dp circular state-layer wraps a 20 dp icon. Without this, the
    // overlay is the icon's exact size and hover/press is barely visible.
    minimumSize: Dp = 40.dp,
    isSelected: Boolean? = null,
    shape: Shape = CircleShape,
    // Suppress: API parity stub — see kdoc; will be wired once a foundation-only tooltip primitive lands. Removing the param would break source compatibility with yaru.dart.
    @Suppress("UNUSED_PARAMETER") tooltip: String? = null,
    // `hasFocusBorder ?? YaruTheme.maybeOf(context)?.focusBorders == true`
    // from yaru_icon_button.dart:112. When `null`, fall back to the inherited
    // `LocalYaruTheme.focusBorders` (default true per inherited_theme.dart:305).
    hasFocusBorder: Boolean? = null,
    // Defensive: optional accessible name for icon-only buttons. Without it screen readers announce only "Button" with no label; default null preserves source compatibility for callers whose icon already supplies a `YaruIcon(semanticLabel = ...)`.
    semanticLabel: String? = null,
    selectedIcon: @Composable (() -> Unit)? = null,
    icon: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val showFocusBorder = hasFocusBorder ?: (LocalYaruTheme.current?.focusBorders == true)
    val selected = isSelected == true
    // Defensive clamp: `Modifier.size(-1.dp)` throws `IllegalArgumentException`,
    // and a non-finite Dp (NaN / ±Infinity) blows up `roundToPx()` →
    // `Float.roundToInt()`. NaN bypasses `coerceAtLeast` (NaN comparisons all
    // return false), so reject it explicitly via `isFinite()`. Mirrors the
    // defensive pattern applied to YaruSlider/Carousel/PanedView/ExpansionPanel.
    val safeIconSize = if (iconSize.value.isFinite()) {
        iconSize.coerceAtLeast(0.dp)
    } else {
        YaruConstants.IconSize
    }
    // Match Flutter's `fixedSize` clamp: button = max(iconSize, minimumSize).
    val safeMinimumSize = if (minimumSize.value.isFinite()) {
        minimumSize.coerceAtLeast(0.dp)
    } else {
        40.dp
    }
    val buttonSize = if (safeIconSize > safeMinimumSize) safeIconSize else safeMinimumSize

    val backgroundColor = if (selected) {
        // Selected fill = `onSurface @ 0.10`, see `defaultStyleOf` in
        // `yaru_icon_button.dart`.
        scheme.onSurface.copy(alpha = 0.1f)
    } else {
        Color.Transparent
    }
    val tint = when {
        // Disabled foreground alpha = 0.38 (see Dart `defaultStyleOf`).
        !enabled && selected -> scheme.primary.copy(alpha = 0.38f)
        !enabled -> scheme.onSurface.copy(alpha = 0.38f)
        selected -> scheme.primary
        else -> scheme.onSurface.copy(alpha = 0.8f)
    }

    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()

    // Per-state overlay alphas mirror Dart's `overlayColor` resolveWith:
    //   selected:    onSurface @ press 0.12 / hover 0.08 / focus 0.12
    //   unselected:  onSurfaceVariant @ press 0.12 / hover 0.08 / focus 0.08
    val overlayBase = if (selected) scheme.onSurface else scheme.onSurfaceVariant
    val overlayAlpha = when {
        !enabled || onPressed == null -> 0f
        pressed -> 0.12f
        hovered -> 0.08f
        focused -> if (selected) 0.12f else 0.08f
        else -> 0f
    }
    val targetOverlay = if (overlayAlpha > 0f) {
        overlayBase.copy(alpha = overlayAlpha).compositeOver(backgroundColor)
    } else {
        backgroundColor
    }
    // Mirrors `InkResponse.hoverDuration` default of 50 ms
    // (material/ink_well.dart:1001) — Yaru disables the splash via
    // `splashFactory: NoSplash.splashFactory` (common_themes.dart),
    // so the visible state-layer change is the InkWell hover/highlight
    // fade. Without this animation, hover/press snaps and the button
    // looks "dead" compared to the Dart version.
    val overlayBackground by animateColorAsState(
        targetValue = targetOverlay,
        animationSpec = tween(durationMillis = 50),
        label = "yaru-icon-button-overlay",
    )

    val button: @Composable () -> Unit = {
        Box(
            modifier = Modifier
                // `fixedSize` clamped through `effectiveConstraints` against
                // `_IconButtonDefaultsM3.minimumSize` (40 dp) — see kdoc on
                // [minimumSize]. The visible icon stays at `safeIconSize`,
                // centered within this larger hit/state-layer box.
                .size(buttonSize)
                // Defensive: forward caller-supplied accessibility label to TalkBack/VoiceOver so an icon-only button is not announced as just "Button"; treat empty as "no label" so an inner `YaruIcon(semanticLabel = ...)` is not overridden.
                // Defensive: also reject whitespace-only labels — they would be announced as silence by screen readers while still suppressing the inner icon's own label.
                .let { m -> if (!semanticLabel.isNullOrBlank()) m.semantics { contentDescription = semanticLabel } else m }
                // `Modifier.background(color, shape)` paints the overlay within
                // [shape] but does NOT clip children — matching Flutter's
                // `Material(clipBehavior: Clip.none)` default. If we used
                // `clip(shape).background(...)` instead, an oversized child
                // icon (e.g. `Icon(size: 30)` inside a 20dp button — see
                // InfoPage's lightbulb) would be truncated to the button's
                // circle. Yaru/Flutter render the icon in full and let it
                // overflow the button bounds.
                .background(color = overlayBackground, shape = shape)
                .let {
                    if (enabled && onPressed != null) {
                        it
                            // Mirrors Dart `IconButton.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click`) — yaru.dart wires no
                            // override, so the desktop cursor turns into a
                            // hand on hover.
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable(
                                interactionSource = interactionSource,
                                // Overlay drawn via background composite — no
                                // additional indication so we can implement the
                                // selected/unselected alpha matrix from the Dart
                                // `overlayColor` resolveWith.
                                indication = null,
                                role = Role.Button,
                                onClick = onPressed,
                            )
                    } else {
                        it
                    }
                },
            contentAlignment = Alignment.Center,
        ) {
            CompositionLocalProvider(LocalYaruContentColor provides tint) {
                // Defensive: wrap the icon slot in `wrapContentSize(unbounded = true)` so a caller-supplied YaruIcon larger than the button's `iconSize` (e.g. 30dp glyph inside a 20dp button — InfoPage's lightbulb) measures at its preferred size and overflows visually instead of being clamped to the button's tight `size()` constraints. This mirrors Flutter `Material(clipBehavior: Clip.none)`.
                Box(modifier = Modifier.wrapContentSize(unbounded = true)) {
                    if (selected && selectedIcon != null) selectedIcon() else icon()
                }
            }
        }
    }

    if (showFocusBorder) {
        YaruFocusBorder(
            modifier = modifier,
            focused = focused && enabled && onPressed != null,
            borderShape = shape,
            borderPadding = YaruFocusBorderPadding.Zero,
        ) { button() }
    } else {
        Box(modifier = modifier) { button() }
    }
}

