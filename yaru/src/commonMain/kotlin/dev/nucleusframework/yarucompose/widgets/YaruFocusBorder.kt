package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.InputMode
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import kotlin.math.roundToInt

/** Color variants for [YaruFocusBorder]. */
enum class YaruFocusBorderVariant { Primary, Secondary, OnSurface }

/** Padding presets between border and child. */
object YaruFocusBorderPadding {
    val Zero: PaddingValues = PaddingValues(0.dp)
    val Small: PaddingValues = PaddingValues(2.dp)
    val Medium: PaddingValues = PaddingValues(4.dp)
    val Large: PaddingValues = PaddingValues(6.dp)
}

/**
 * Draws an animated colored border around [content] when it gains focus.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_focus_border.dart`.
 */
@Composable
fun YaruFocusBorder(
    modifier: Modifier = Modifier,
    variant: YaruFocusBorderVariant = YaruFocusBorderVariant.Primary,
    borderColor: Color? = null,
    borderWidth: Dp = YaruConstants.FocusBorderWidth,
    borderShape: Shape = RoundedCornerShape(YaruConstants.ButtonRadius + 2.dp),
    borderPadding: PaddingValues = YaruFocusBorderPadding.Zero,
    // Mirrors Dart `BorderSide.strokeAlign` (yaru_focus_border.dart:114 → default 3).
    // Dart formula: visible stroke center sits at `strokeAlign * width / 2` outside
    // the bounds, leaving a gap between the content and the focus ring.
    // With `strokeAlign = 3` and `width = 2`, the ring's center is 3dp outside →
    // visible inner edge sits 2dp outside the content, outer edge 4dp outside.
    borderStrokeAlign: Float = 3f,
    focused: Boolean? = null,
    onFocusChange: ((Boolean) -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val resolvedBorderColor = sanitiseColor(
        borderColor ?: when (variant) {
            YaruFocusBorderVariant.Primary -> scheme.primary
            YaruFocusBorderVariant.Secondary -> scheme.secondary
            YaruFocusBorderVariant.OnSurface -> scheme.onSurface
        },
    )

    var internalFocused by remember { mutableStateOf(focused ?: false) }
    val effectiveFocused = focused ?: internalFocused
    // Curves.linear / 250 ms (`Durations.medium1`, default `AnimatedContainer.curve`)
    // from yaru_focus_border.dart line 110: `duration: Durations.medium1` (250 ms in Flutter).
    val animatedColor by animateColorAsState(
        targetValue = if (effectiveFocused) resolvedBorderColor else Color.Transparent,
        animationSpec = tween(durationMillis = 250, easing = LinearEasing),
    )

    // Defensive: `Modifier.padding(PaddingValues)` throws on negative edges; sanitise per-edge.
    val safeBorderPadding = borderPadding.coerceNonNegative(LocalLayoutDirection.current)
    Box(
        modifier = modifier
            .padding(safeBorderPadding)
            // Reserve layout space for the outside stroke so parents that clip
            // (LazyColumn items, `Modifier.clip`, default `clipToBounds`) do not
            // crop the focus ring. The visual offset of the stroke's outer edge
            // from the content edge is `(strokeAlign + 1) * width / 2` (with
            // `strokeAlign = 3`, `width = 2dp` → `4dp` on each side).
            //
            // We inflate the reported size on all four sides and translate the
            // child back to its natural top-left, so visually the content stays
            // put while the layout occupies the same footprint as the visible
            // halo. Min constraints are honored so callers like
            // `Modifier.fillMaxWidth()` keep the OUTER size, not the inner one.
            .layout { measurable, constraints ->
                // Defensive clamps via the canonical `Float.sanitise()`
                // foundation helper: a negative `borderWidth` would feed a
                // negative `Stroke.width` to `drawOutline`, which throws
                // `IllegalArgumentException`. A negative `borderStrokeAlign`
                // is meaningful in Dart (`-1` = inside) but our drawing math
                // assumes the stroke sits outside.
                val strokeWidthPx = borderWidth.toPx().sanitise()
                val safeStrokeAlign = borderStrokeAlign.sanitise()
                // Outer halo extent = stroke center offset + half the stroke width.
                val haloPx = ((safeStrokeAlign + 1f) * strokeWidthPx / 2f)
                    .roundToInt()
                    .coerceAtLeast(0)
                val horizontalInset = haloPx * 2
                val verticalInset = haloPx * 2
                val childConstraints = Constraints(
                    minWidth = (constraints.minWidth - horizontalInset).coerceAtLeast(0),
                    maxWidth = if (constraints.hasBoundedWidth) {
                        (constraints.maxWidth - horizontalInset).coerceAtLeast(0)
                    } else {
                        constraints.maxWidth
                    },
                    minHeight = (constraints.minHeight - verticalInset).coerceAtLeast(0),
                    maxHeight = if (constraints.hasBoundedHeight) {
                        (constraints.maxHeight - verticalInset).coerceAtLeast(0)
                    } else {
                        constraints.maxHeight
                    },
                )
                val placeable = measurable.measure(childConstraints)
                // Guard against `Constraints.Infinity` (Int.MAX_VALUE) on the
                // upper bound: feeding that into `layout(width, height)` would
                // overflow downstream. When unbounded, only honor the lower
                // bound and the natural inflated size.
                val rawWidth = placeable.width + horizontalInset
                val rawHeight = placeable.height + verticalInset
                val width = if (constraints.hasBoundedWidth) {
                    rawWidth.coerceIn(constraints.minWidth, constraints.maxWidth)
                } else {
                    rawWidth.coerceAtLeast(constraints.minWidth)
                }
                val height = if (constraints.hasBoundedHeight) {
                    rawHeight.coerceIn(constraints.minHeight, constraints.maxHeight)
                } else {
                    rawHeight.coerceAtLeast(constraints.minHeight)
                }
                layout(width, height) {
                    placeable.place(haloPx, haloPx)
                }
            }
            // `Modifier.drawWithCache` lets us draw OUTSIDE the inner content
            // bounds — required to mirror Dart `BorderSide.strokeAlign = 3`,
            // which paints the stroke entirely outside the content. The layout
            // step above reserves the halo room; here we draw inside that
            // reserved space at the correct visual offset from the inner box.
            .drawWithCache {
                // Mirror the defensive clamps from the `layout { ... }` block
                // above via the canonical `Float.sanitise()` foundation helper.
                // Without these, a negative `borderWidth` reaches
                // `Stroke(width = ...)` and crashes with
                // `IllegalArgumentException: width must be non-negative`.
                val strokeWidthPx = borderWidth.toPx().sanitise()
                val safeStrokeAlign = borderStrokeAlign.sanitise()
                val haloPx = ((safeStrokeAlign + 1f) * strokeWidthPx / 2f)
                    .coerceAtLeast(0f)
                // Stroke center offset from the inner content edge (Dart convention).
                val centerOffsetPx = safeStrokeAlign * strokeWidthPx / 2f
                // Inner content size, derived from outer layout size.
                val innerWidth = (size.width - 2f * haloPx).coerceAtLeast(0f)
                val innerHeight = (size.height - 2f * haloPx).coerceAtLeast(0f)
                val outerStrokeSize = Size(
                    innerWidth + 2f * centerOffsetPx,
                    innerHeight + 2f * centerOffsetPx,
                )
                val outline = borderShape.createOutline(
                    size = outerStrokeSize,
                    layoutDirection = layoutDirection,
                    density = this,
                )
                // Outline's top-left in outer-layout coordinates: content sits
                // at (haloPx, haloPx); stroke starts `centerOffsetPx` further
                // out from there.
                val strokeOriginX = haloPx - centerOffsetPx
                val strokeOriginY = haloPx - centerOffsetPx
                onDrawWithContent {
                    drawContent()
                    if (animatedColor.alpha > 0f) {
                        translate(left = strokeOriginX, top = strokeOriginY) {
                            drawOutline(
                                outline = outline,
                                color = animatedColor,
                                style = Stroke(width = strokeWidthPx),
                            )
                        }
                    }
                }
            }
            .onFocusChanged { state ->
                if (focused == null) internalFocused = state.isFocused
                onFocusChange?.invoke(state.isFocused)
            },
    ) {
        content()
    }
}

/**
 * Tracks focus driven by KEYBOARD navigation only — gated by Compose's
 * [LocalInputModeManager]. When the active input mode is [InputMode.Touch]
 * (mouse / pointer), the returned state is permanently `false` so the focus
 * ring never paints; when the mode is [InputMode.Keyboard], the returned
 * state mirrors the source's actual focus state.
 *
 * This matches Flutter's `FocusManager.highlightStrategy =
 * automatic` semantics: focus rings appear only when the user navigates
 * with Tab / arrow keys, not when they click with a mouse.
 */
@Composable
internal fun rememberKeyboardFocusedState(source: InteractionSource): State<Boolean> {
    val inputMode = LocalInputModeManager.current
    val rawFocused by source.collectIsFocusedAsState()
    return remember(source, inputMode) {
        derivedStateOf {
            inputMode.inputMode == InputMode.Keyboard && rawFocused
        }
    }
}
