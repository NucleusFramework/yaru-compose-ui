package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.foundation.sanitiseStrokeWidth
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.success
import dev.nucleusframework.yarucompose.themes.contrastColor
import dev.nucleusframework.yarucompose.themes.isHighContrast

/** Visual variant of [YaruButton]. */
enum class YaruButtonVariant { Filled, Tonal, Outlined, Text, Elevated }

/**
 * Generic Yaru button — flat, foundation-only. Mirrors the Dart variants
 * configured in `_createOutlinedButtonTheme` / `_createTextButtonTheme` /
 * `_createElevatedButtonTheme` / `_createFilledButtonTheme` from
 * `yaru.dart/lib/src/themes/common_themes.dart`.
 *
 * Geometry: minimum size = `kYaruButtonHeight × kYaruButtonHeight` (34dp),
 * shape = `RoundedRectangleBorder(borderRadius: kYaruButtonRadius)` (8dp),
 * content padding = `EdgeInsets.all(16)` from `_createCommonButtonStyle` —
 * applied to all four sides. The 34dp `minimumSize` only kicks in when the
 * combined content + padding is smaller than 34dp on either axis.
 *
 * State overlays mirror Flutter's per-variant `overlayColor` defaults
 * (`_FilledButtonDefaultsM3`, `_OutlinedButtonDefaultsM3`,
 * `_TextButtonDefaultsM3`, `_ElevatedButtonDefaultsM3` in the Flutter SDK):
 * the state layer base is the variant's foreground colour, with
 * `hover @ 0.08` and `focus @ 0.10` / `press @ 0.10`. Yaru does not
 * register a `filledTonal` theme, so Tonal falls back to
 * `_FilledTonalButtonDefaultsM3` whose state layer is `onSecondaryContainer`
 * — same alphas.
 */
@Composable
fun YaruButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: YaruButtonVariant = YaruButtonVariant.Filled,
    shape: Shape = RoundedCornerShape(YaruConstants.ButtonRadius),
    // EdgeInsets.all(16) from `_createCommonButtonStyle` in common_themes.dart.
    contentPadding: PaddingValues = PaddingValues(16.dp),
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    border: BorderStroke? = null,
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val layoutDirection = LocalLayoutDirection.current

    // Coerce per-edge to defend against negative paddings (Compose `padding`
    // throws `IllegalArgumentException` on negative values), and a non-finite
    // Dp (NaN / +-Infinity) blows up `roundToPx()`. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject non-finite
    // values via `isFinite()`. Mirrors the YaruListTile fix.
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)

    // Base background per variant — see `_create*ButtonTheme` in common_themes.dart.
    // Defensive: caller-supplied colors with non-finite channels (e.g.
    // `Color.Unspecified`) would propagate through `compositeOver`,
    // `.copy(alpha=)` and `Modifier.background`, ultimately crashing Skia.
    val baseBackground = sanitiseColor(
        backgroundColor ?: when (variant) {
            YaruButtonVariant.Filled -> scheme.onSurface.copy(alpha = 0.1f)
            YaruButtonVariant.Tonal -> scheme.secondaryContainer
            YaruButtonVariant.Outlined -> Color.Transparent
            YaruButtonVariant.Text -> Color.Transparent
            // Defensive: Dart `_createElevatedButtonTheme` uses `backgroundColor: elevatedButtonColor ?? primary`, and yaru.dart sets `elevatedButtonColor = success` (green `0xFF0E8420`). Match that here so YaruSplitButton's main half (Elevated variant) and any other Elevated callers render the Yaru-spec green instead of the variant accent.
            YaruButtonVariant.Elevated -> scheme.success
        },
    )
    // Base foreground per variant.
    val baseContent = sanitiseColor(
        contentColor ?: when (variant) {
            YaruButtonVariant.Filled -> scheme.onSurface
            YaruButtonVariant.Tonal -> scheme.onSecondaryContainer
            YaruButtonVariant.Outlined -> scheme.onSurface
            YaruButtonVariant.Text -> scheme.primary
            // Defensive: pair with `scheme.success` background — `contrastColor(success)` produces white-ish text on green, matching Dart's auto-resolved foreground for ElevatedButton over a green elevatedButtonColor.
            YaruButtonVariant.Elevated -> contrastColor(scheme.success)
        },
    )
    // Border per variant. Outlined always has a 1dp outline; Elevated/Filled gain
    // an outlineVariant border under high contrast (matches Dart `BorderSide`).
    val baseBorder: BorderStroke? = border ?: when (variant) {
        YaruButtonVariant.Outlined -> BorderStroke(
            1.dp,
            if (scheme.isHighContrast) scheme.outlineVariant else scheme.outline,
        )
        YaruButtonVariant.Filled,
        YaruButtonVariant.Elevated,
        YaruButtonVariant.Tonal -> if (scheme.isHighContrast) {
            BorderStroke(1.dp, scheme.outlineVariant)
        } else null
        YaruButtonVariant.Text -> null
    }

    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()
    val focused by rememberKeyboardFocusedState(interactionSource)

    // State-layer overlays composited over the base background. Alphas mirror
    // Flutter's per-variant `overlayColor` resolution exactly:
    //   pressed = 0.10, hovered = 0.08, focused = 0.10
    // (see `_FilledButtonDefaultsM3.overlayColor` etc. in the Flutter SDK —
    // Yaru leaves this field untouched in `_create*ButtonTheme`).
    // Press wins over hover; hover wins over focus.
    val overlay = when {
        !enabled -> Color.Transparent
        // State layer base = foreground color, matching Flutter's
        // `_buttonDefaultOverlay(foreground)` helper that `styleFrom` wires
        // up when only `foregroundColor` is overridden.
        pressed -> baseContent.copy(alpha = 0.1f)
        hovered -> baseContent.copy(alpha = 0.08f)
        focused -> baseContent.copy(alpha = 0.1f)
        else -> Color.Transparent
    }

    // Resolve the visible background. Filled has an explicit disabled colour
    // (`disabledBackgroundColor: onSurface @ 0.12` in Dart). Tonal isn't themed
    // by Yaru, so `_FilledTonalButtonDefaultsM3`'s disabled background applies:
    // also `onSurface @ 0.12`. Elevated leaves the disabled background to the
    // framework defaults too: `onSurface @ 0.12`. Outlined and Text are transparent.
    val resolvedBackground = when {
        !enabled && (
            variant == YaruButtonVariant.Filled ||
                variant == YaruButtonVariant.Tonal ||
                variant == YaruButtonVariant.Elevated
            ) -> scheme.onSurface.copy(alpha = 0.12f)
        !enabled -> Color.Transparent
        else -> overlay.compositeOver(baseBackground)
    }

    // Standard disabled foreground alpha — `onSurface @ 0.38`, used by Flutter's
    // ButtonStyleButton when no explicit `disabledForegroundColor` is set in the
    // Yaru styles (see `_createOutlinedButtonTheme` etc. in common_themes.dart).
    val resolvedContent = if (enabled) {
        baseContent
    } else {
        baseContent.copy(alpha = baseContent.alpha * 0.38f)
    }
    // Yaru pins the outlined border via `styleFrom(side: BorderSide(...))`, which
    // Flutter wraps as a `WidgetStatePropertyAll<BorderSide>`. The same colour is
    // therefore applied in every state, including disabled — no fade. (Without the
    // override, the default would use `onSurface @ 0.12` for disabled.)
    // Defensive clamp: `Modifier.border` with a negative or non-finite
    // `BorderStroke.width` throws `IllegalArgumentException`. NaN bypasses
    // `<` (all NaN comparisons return false), so reject non-finite values
    // explicitly via `isFinite()`. Mirrors `YaruBorderContainer`'s
    // safeBorder pattern.
    val resolvedBorder = baseBorder?.sanitiseStrokeWidth()

    // No focus ring: Dart `_create*ButtonTheme` in common_themes.dart customises
    // only `overlayColor` — focus is handled by the state-layer overlay,
    // not by `YaruFocusBorder` (verified: `_create*ButtonTheme` in
    // `yaru.dart/lib/src/themes/common_themes.dart` contains no
    // `YaruFocusBorder` / `focusBorders`).
    Box(
        modifier = modifier
            .heightIn(min = YaruConstants.ButtonHeight)
            .widthIn(min = YaruConstants.ButtonHeight)
            .clip(shape)
            .background(color = resolvedBackground)
            .let {
                if (resolvedBorder != null) it.border(resolvedBorder, shape) else it
            }
            // Mirrors Flutter's `ButtonStyleButton.mouseCursor` default
            // (`WidgetStateMouseCursor.clickable` → `SystemMouseCursors.click`).
            // Yaru's `_create*ButtonTheme` doesn't override mouseCursor, so all
            // variants hand-cursor on hover. Apply only when enabled — disabled
            // state resolves to `basic` via `WidgetStateMouseCursor.clickable`.
            .let { if (enabled) it.pointerHoverIcon(PointerIcon.Hand) else it }
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                // Yaru uses `NoSplash.splashFactory`; we draw our own state layers.
                indication = null,
                role = Role.Button,
                onClick = onClick,
            )
            .padding(safeContentPadding),
        contentAlignment = Alignment.Center,
    ) {
        CompositionLocalProvider(
            LocalYaruContentColor provides resolvedContent,
            LocalYaruTextStyle provides LocalYaruTypography.current.labelLarge,
        ) {
            content()
        }
    }
}

/** Convenience wrapper — `YaruButton(variant = Filled)`. */
@Composable
fun YaruFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) = YaruButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    variant = YaruButtonVariant.Filled,
    content = content,
)

/** Convenience wrapper — `YaruButton(variant = Tonal)`. */
@Composable
fun YaruTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) = YaruButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    variant = YaruButtonVariant.Tonal,
    content = content,
)

/** Convenience wrapper — `YaruButton(variant = Outlined)`. */
@Composable
fun YaruOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) = YaruButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    variant = YaruButtonVariant.Outlined,
    content = content,
)

/** Convenience wrapper — `YaruButton(variant = Text)`. */
@Composable
fun YaruTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) = YaruButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    variant = YaruButtonVariant.Text,
    content = content,
)

/** Convenience wrapper — `YaruButton(variant = Elevated)`. */
@Composable
fun YaruElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) = YaruButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    variant = YaruButtonVariant.Elevated,
    content = content,
)

