package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.foundation.sanitiseStrokeWidth
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * A box with a rounded Yaru-style border.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_border_container.dart`
 * (`YaruBorderContainer` + `YaruTranslucentContainer`).
 */
@Composable
fun YaruBorderContainer(
    modifier: Modifier = Modifier,
    color: Color = Color.Transparent,
    border: BorderStroke = BorderStroke(1.dp, rememberYaruDividerColor()),
    shape: Shape = RoundedCornerShape(YaruConstants.ContainerRadius),
    padding: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.TopStart,
    clipContent: Boolean = false,
    // Flutter's `Container` wraps its child; the port fills the available width
    // because that is what every box-shaped Yaru widget wants. Pill-shaped ones
    // (`YaruInfoBadge`) opt out so several of them can share a row.
    fillMaxWidth: Boolean = true,
    content: @Composable () -> Unit = {},
) {
    // Defensive clamp: `Modifier.border` with a negative or non-finite
    // `BorderStroke.width` throws `IllegalArgumentException`. NaN bypasses
    // `<` (all NaN comparisons return false), so reject non-finite values
    // explicitly via `isFinite()`.
    val safeBorder = border.sanitiseStrokeWidth()
    // Defensive: `Modifier.background` rejects colors with non-finite channels
    // (e.g. `Color.Unspecified`, NaN alpha from a stale animation). Coerce
    // before forwarding to the modifier chain.
    val safeColor = sanitiseColor(color)
    // Defensive clamp: `Modifier.padding` throws on negative `Dp`, and a
    // non-finite Dp (NaN / +-Infinity) blows up `roundToPx()` downstream.
    // NaN bypasses `coerceAtLeast` (NaN comparisons all return false), so
    // reject non-finite values via `isFinite()`. Mirrors
    // YaruWatermark/YaruTile/YaruDialog.
    val layoutDirection = LocalLayoutDirection.current
    val safePadding = padding.coerceNonNegative(layoutDirection)
    Box(
        // Defensive: default to filling the available width — caller's modifier comes FIRST so explicit `width()`/`size()`/`widthIn(max=N)` tightens incoming constraints before the inner `fillMaxWidth()` runs, letting fillMaxWidth fill the caller's tight max instead of the parent's max. Callers like the autocomplete popup that gate on a measured width still get their explicit width respected; otherwise the container fills parent width by default.
        modifier = modifier
            .then(if (fillMaxWidth) Modifier.fillMaxWidth() else Modifier)
            .then(if (clipContent) Modifier.clip(shape) else Modifier)
            // Apply the shape to the background fill so non-transparent
            // colors (e.g. `YaruTranslucentContainer`) don't paint square
            // corners past the rounded border when `clipContent = false`.
            .background(safeColor, shape)
            .border(safeBorder, shape)
            .padding(safePadding),
        contentAlignment = contentAlignment,
        content = { content() },
    )
}

/**
 * A [YaruBorderContainer] whose background is a translucent tint of [color].
 */
@Composable
fun YaruTranslucentContainer(
    color: Color,
    modifier: Modifier = Modifier,
    opacity: Float = 0.1f,
    shape: Shape = RoundedCornerShape(YaruConstants.ContainerRadius),
    padding: PaddingValues = PaddingValues(0.dp),
    contentAlignment: Alignment = Alignment.TopStart,
    clipContent: Boolean = false,
    fillMaxWidth: Boolean = true,
    content: @Composable () -> Unit = {},
) {
    // Defensive clamp: `Color.copy(alpha = ...)` throws `IllegalArgumentException`
    // when alpha is outside `[0f, 1f]` (or NaN). Callers may forward
    // unvalidated theme/config values.
    val safeOpacity = if (opacity.isNaN()) 0f else opacity.coerceIn(0f, 1f)
    // Defensive: `Color.Unspecified` has NaN R/G/B which would propagate into
    // the inner `Modifier.background` and `BorderStroke`, both of which reject
    // non-finite channels in Skia.
    val safeColor = sanitiseColor(color)
    YaruBorderContainer(
        modifier = modifier,
        color = safeColor.copy(alpha = safeOpacity),
        border = BorderStroke(1.dp, safeColor),
        shape = shape,
        padding = padding,
        contentAlignment = contentAlignment,
        clipContent = clipContent,
        fillMaxWidth = fillMaxWidth,
        content = content,
    )
}

