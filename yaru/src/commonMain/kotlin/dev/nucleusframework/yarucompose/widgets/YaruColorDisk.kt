package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitiseColor

/**
 * A small circular swatch used to pick an accent color.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_color_disk.dart`:
 *  - 42 dp outer width with 8 dp padding (L18-L20).
 *  - 20 dp inner colored disc (L48-L50).
 *  - 2 dp ring drawn OUTSIDE the disc (`strokeAlign: 1` -> StrokeAlign.outside, L31-L32).
 *  - Ring alpha: `1.0` selected/pressed, `0.5` hovered/focused, else `0` (L33-L42).
 */
@Composable
fun YaruColorDisk(
    color: Color,
    selected: Boolean,
    onPressed: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val focused by rememberKeyboardFocusedState(interactionSource)
    val pressed by interactionSource.collectIsPressedAsState()

    val ringAlpha = when {
        // from yaru_color_disk.dart L36-L37: `selected || pressed ? 1.0`
        selected || pressed -> 1.0f
        // from yaru_color_disk.dart L38-L40: `hovered || focused ? 0.5`
        hovered || focused -> 0.5f
        // from yaru_color_disk.dart L41: default returns `0`
        else -> 0.0f
    }

    // Defensive: a caller-supplied `color` with non-finite channels (e.g. NaN
    // from upstream interpolation, or `Color.Unspecified`) would propagate
    // into `drawCircle` and the disc background, where Skia rejects it.
    // `sanitiseColor` coerces the alpha channel and falls back to transparent
    // for `Color.Unspecified` / NaN RGB.
    val safeColor = sanitiseColor(color)

    // from yaru_color_disk.dart L17-L20: `SizedBox(width: 42) > Padding(EdgeInsets.all(8))`.
    // Dart only constrains WIDTH at 42; vertical extent is content-driven (8 + 20 + 8 = 36 dp).
    // Forcing a square 42x42 here would inflate the vertical padding to ~11 dp and push the
    // disc away from neighbours / surrounding content — visibly off in the sample.
    Box(
        modifier = modifier
            .width(42.dp) // from yaru_color_disk.dart L18: `width: 42` (no height)
            .padding(8.dp), // from yaru_color_disk.dart L20: `EdgeInsets.all(8.0)` — all four sides
        contentAlignment = Alignment.Center,
    ) {
        // The visible disc is 20 dp; the 2 dp ring is drawn OUTSIDE that circle
        // (Flutter `strokeAlign: 1` == StrokeAlign.outside). Click target matches the
        // disc bounds (the TextButton wraps its child with EdgeInsets.zero padding).
        Box(
            modifier = Modifier
                .size(20.dp) // from yaru_color_disk.dart L49-L50: `height: 20, width: 20`
                .drawBehind {
                    // from yaru_color_disk.dart L29-L43: `CircleBorder(side: BorderSide(strokeAlign: 1, width: 2, color))`
                    // Defensive: a parent imposing `Constraints(0, 0)` (or a non-finite
                    // canvas dimension) would feed Skia a degenerate / NaN radius and
                    // crash the draw layer. Skip the ring outright in that case.
                    val minDim = size.minDimension
                    if (!minDim.isFinite() || minDim <= 0f) return@drawBehind
                    val strokeWidthPx = 2.dp.toPx() // from yaru_color_disk.dart L32: `width: 2`
                    // Defensive: in Dart the `CircleBorder` is sized by the enclosing `TextButton` (kYaruButtonHeight=34 min), not the 20dp child — so the ring sits at radius ~13dp leaving a visible ~3dp gap to the inner disc; mirror that by inflating the ring radius beyond the disc edge.
                    val ringGapPx = 3.dp.toPx()
                    val radius = ((minDim + strokeWidthPx) / 2f + ringGapPx).coerceAtLeast(0f)
                    drawCircle(
                        color = safeColor.copy(alpha = ringAlpha),
                        radius = radius,
                        style = Stroke(width = strokeWidthPx),
                    )
                }
                .background(color = safeColor, shape = CircleShape) // from yaru_color_disk.dart L52-L55: `BorderRadius.circular(100)` + `color`
                .then(
                    // Mirrors Dart's `TextButton(onPressed: onPressed)` — when null,
                    // the disc is non-interactive and any enclosing tappable parent
                    // (e.g. a `PopupMenuItem` row) drives selection instead.
                    if (onPressed != null) {
                        Modifier
                            // Mirrors Material `TextButton.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click`) used by the inner
                            // `TextButton(onPressed: onPressed)` in
                            // yaru_color_disk.dart.
                            .let { if (enabled) it.pointerHoverIcon(PointerIcon.Hand) else it }
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                enabled = enabled,
                                role = Role.Button,
                                onClick = onPressed,
                            )
                    } else {
                        Modifier
                    },
                ),
        )
    }
}
