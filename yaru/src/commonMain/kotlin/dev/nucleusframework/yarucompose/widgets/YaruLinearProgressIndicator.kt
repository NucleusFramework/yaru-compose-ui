package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size as GeomSize
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import kotlin.math.abs

// Every literal traces to yaru_linear_progress_indicator.dart.
private val DefaultStrokeWidth: Dp = 4.dp // from yaru_linear_progress_indicator.dart: _kDefaultStrokeWidth = 4.0
private const val DefaultTrackOpacity = 0.25f // from yaru_linear_progress_indicator.dart: _kDefaultTrackColorOpacity = 0.25
private const val IndeterminateAnimationCycles = 7 // from yaru_linear_progress_indicator.dart: _kIndeterminateAnimationCycles = 7.0
private const val IndeterminateAnimationDurationMs = 8000 // from yaru_linear_progress_indicator.dart: _kIndeterminateAnimationDuration = 8000

/**
 * Yaru-flavored linear progress indicator — Canvas-painted, no Material3.
 *
 * Mirrors the determinate / indeterminate paths from
 * `yaru.dart/lib/src/widgets/yaru_linear_progress_indicator.dart`. The
 * indeterminate state uses the 8 s × 7-cycle `Curves.easeInOutSine` schedule
 * from the Dart source: a continuous primary-coloured line with three gap
 * "windows" punched out via `BlendMode.dstOut`.
 */
@Composable
fun YaruLinearProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float? = null,
    color: Color = LocalYaruColorScheme.current.primary,
    trackColor: Color = color.copy(alpha = DefaultTrackOpacity),
    strokeWidth: Dp = DefaultStrokeWidth,
    trackStrokeWidth: Dp = strokeWidth,
) {
    // Clamp stroke widths to a finite non-negative range — `Paint.strokeWidth`
    // rejects negative / non-finite values, a zero `strokeWidth` would later
    // trigger a divide-by-zero when computing `realTrackStrokeWidth`, and a
    // non-finite Dp (NaN / ±Infinity) would explode `defaultMinSize` →
    // `roundToPx` and feed Skia an invalid stroke. Falling back to the Yaru
    // default keeps rendering well-defined for misuse instead of crashing.
    val safeStrokeWidth =
        if (strokeWidth.value.isFinite() && strokeWidth.value > 0f) strokeWidth
        else DefaultStrokeWidth
    val safeTrackStrokeWidth =
        if (trackStrokeWidth.value.isFinite() && trackStrokeWidth.value >= 0f) trackStrokeWidth
        else safeStrokeWidth
    // Defensive: a caller-supplied `color` with non-finite channels (e.g.
    // `Color.Unspecified`, NaN alpha) would propagate into `Paint.color` /
    // `drawCircle`, which Skia rejects. The default `trackColor` derives from
    // `color`, so sanitise it too.
    val safeColor = sanitiseColor(color)
    val safeTrackColor = sanitiseColor(trackColor)
    if (progress != null) {
        // Sanitise NaN — `Float.coerceIn` propagates NaN through unchanged
        // (NaN comparisons all return false), which would later feed `drawLine`
        // with NaN coordinates and crash skia's path validation.
        val safe = if (progress.isNaN()) 0f else progress.coerceIn(0f, 1f)
        // Dart L96-99 uses `BoxConstraints(minWidth: double.infinity, minHeight: strokeWidth)`
        // — minHeight only, so the parent may stretch us taller.
        // Wrap with Box + matchParentSize so the Canvas always sees a bounded
        // height — Spacer's measure policy returns `0` for unbounded
        // dimensions, which leaks through `defaultMinSize` into
        // `DrawScope.size` and trips the `size.height <= 0f` early return
        // below, leaving the line invisible whenever the parent provides
        // unbounded height (e.g. a `LazyColumn` item without an explicit
        // `height(...)`).
        Box(modifier = modifier.fillMaxWidth().defaultMinSize(minHeight = safeStrokeWidth)) {
        Canvas(modifier = Modifier.matchParentSize()) {
            // Skip painting on zero-area canvases — `(size.width - y) * value`
            // would feed `drawLine` with a negative x and `drawCircle` with a
            // 0-radius center off-canvas. Guard for parity with the
            // indeterminate branch below.
            if (size.width <= 0f || size.height <= 0f) return@Canvas
            paintLinearDeterminate(
                size = GeomSize(size.width, size.height),
                value = safe,
                color = safeColor,
                trackColor = safeTrackColor,
                // realStrokeWidth = size.height (Dart L250).
                strokeWidth = size.height,
                // realTrackStrokeWidth = trackStrokeWidth * (realStrokeWidth / strokeWidth).
                trackStrokeWidth = safeTrackStrokeWidth.toPx() *
                    (size.height / safeStrokeWidth.toPx()),
            )
        }
        }
    } else {
        val transition = rememberInfiniteTransition()
        val t by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(IndeterminateAnimationDurationMs, easing = LinearEasing),
                repeatMode = RepeatMode.Restart,
            ),
        )
        // Same Box+matchParentSize wrap as the determinate branch — see the
        // comment above for the unbounded-constraint rationale.
        Box(modifier = modifier.fillMaxWidth().defaultMinSize(minHeight = safeStrokeWidth)) {
        Canvas(modifier = Modifier.matchParentSize()) {
            // Skip painting on zero-area canvases — `saveLayer` with an empty
            // bounds rect is undefined behaviour on Skia.
            if (size.width <= 0f || size.height <= 0f) return@Canvas
            // spacingProgress = 1 - |easeInOutSine(t) * 2 - 1|.
            val eased = YaruEasing.EaseInOutSine.transform(t)
            val spacingProgress = 1f - abs(eased * 2f - 1f)
            // trackProgress travels through 7 cycles, eased — only fractional part is used.
            val trackProgress = eased * IndeterminateAnimationCycles
            val realTrackPosition = trackProgress - trackProgress.toInt().toFloat()
            paintLinearIndeterminate(
                size = GeomSize(size.width, size.height),
                color = safeColor,
                strokeWidth = size.height,
                spacingProgress = spacingProgress,
                realTrackPosition = realTrackPosition,
            )
        }
        }
    }
}

private fun DrawScope.paintLinearDeterminate(
    size: GeomSize,
    value: Float,
    color: Color,
    trackColor: Color,
    strokeWidth: Float,
    trackStrokeWidth: Float,
) {
    val y = size.height / 2f
    // Defensive: DrawScope does not auto-mirror x for RTL — flip the active fill so it grows from the visual start (right edge) under Arabic/Hebrew, matching Material's LinearProgressIndicator and Dart's Directionality-aware paint.
    val isRtl = layoutDirection == LayoutDirection.Rtl
    drawIntoCanvas { canvas ->
        // Track: full-width rounded line, mirrors Dart L271-275.
        val trackPaint = Paint().apply {
            this.color = trackColor
            this.strokeWidth = trackStrokeWidth
            strokeCap = StrokeCap.Round
            style = PaintingStyle.Stroke
        }
        canvas.drawLine(
            Offset(trackStrokeWidth / 2f, y),
            Offset(size.width - trackStrokeWidth / 2f, y),
            trackPaint,
        )

        if (value <= 0f) return@drawIntoCanvas

        if (size.width * value > size.height) {
            // Long fill: rounded line from x=y to x=(width - y) * value.
            // Mirrors Dart L277-282 — `drawLine(Offset(y,y), Offset((w-y)*v, y))`.
            val strokePaint = Paint().apply {
                this.color = color
                this.strokeWidth = strokeWidth
                strokeCap = StrokeCap.Round
                style = PaintingStyle.Stroke
            }
            val startX = if (isRtl) size.width - y else y
            val endX = if (isRtl) size.width - (size.width - y) * value else (size.width - y) * value
            canvas.drawLine(
                Offset(startX, y),
                Offset(endX, y),
                strokePaint,
            )
        } else {
            // Short fill collapses to a circle, matching Dart's special case
            // L283-289: `drawCircle(Offset(y, y), y, fillPaint)`.
            val cx = if (isRtl) size.width - y else y
            drawCircle(
                color = color,
                radius = y,
                center = Offset(cx, y),
            )
        }
    }
}

private fun DrawScope.paintLinearIndeterminate(
    size: GeomSize,
    color: Color,
    strokeWidth: Float,
    spacingProgress: Float,
    realTrackPosition: Float,
) {
    drawIntoCanvas { canvas ->
        // Save layer so the dstOut blend only affects the bar we draw inside.
        canvas.saveLayer(
            androidx.compose.ui.geometry.Rect(0f, 0f, size.width, size.height),
            Paint(),
        )
        try {
            val y = size.height / 2f
            val strokePaint = Paint().apply {
                this.color = color
                this.strokeWidth = strokeWidth
                strokeCap = StrokeCap.Round
                style = PaintingStyle.Stroke
            }
            val invertPaint = Paint().apply {
                this.color = Color.Black
                this.strokeWidth = strokeWidth
                strokeCap = StrokeCap.Square
                style = PaintingStyle.Stroke
                blendMode = BlendMode.DstOut
            }

            // Continuous primary-coloured line (rounded ends).
            canvas.drawLine(
                Offset(strokeWidth / 2f, y),
                Offset(size.width - strokeWidth / 2f, y),
                strokePaint,
            )

            // Three gap windows that scroll across, with widths driven by
            // spacingProgress. Mirrors the Dart point-stack maths exactly.
            // Defensive: the `50` literal is a logical-pixel constant from Dart — DrawScope works in physical px, so route it through `toPx()` to avoid a half-scale offset on 2x screens.
            val fiftyPx = 50.dp.toPx()
            // from yaru_linear_progress_indicator.dart: `for (var i = -1; i <= 1; i++)`
            for (i in -1..1) {
                // from yaru_linear_progress_indicator.dart: `size.width / 2 + 50 * i + (size.width / 3 - 50) * spacingProgress * i + size.width * realTrackPosition`
                val rawX = size.width / 2f +
                    fiftyPx * i +
                    (size.width / 3f - fiftyPx) * spacingProgress * i +
                    size.width * realTrackPosition
                val px = if (rawX < size.width) rawX else rawX - size.width
                // from yaru_linear_progress_indicator.dart: `final gap = size.width / 20 * spacingProgress`
                val gap = size.width / 20f * spacingProgress
                canvas.drawLine(
                    Offset(px - gap / 2f, y),
                    Offset(px + gap / 2f, y),
                    invertPaint,
                )
            }
        } finally {
            // Pair `saveLayer` with `restore` even on failure — an unbalanced
            // layer would leak into the next frame's draw state.
            canvas.restore()
        }
    }
}
