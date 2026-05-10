package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size as GeomSize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.min

// Every literal traces to yaru_circular_progress_indicator.dart.
private val DefaultMinSize: Dp = 36.dp // from yaru_circular_progress_indicator.dart: _kMinCircularProgressIndicatorSize = 36.0
private val DefaultStrokeWidth: Dp = 4.dp // from yaru_circular_progress_indicator.dart: _kDefaultStrokeWidth = 4.0
private const val DefaultTrackOpacity = 0.25f // from yaru_circular_progress_indicator.dart: _kDefaultTrackColorOpacity = 0.25

private const val InitialAnimationDurationMs = 1000 // from yaru_circular_progress_indicator.dart: _kIndeterminateInitialAnimationDuration = 1000
private const val LoopAnimationDurationMs = 8000 // from yaru_circular_progress_indicator.dart: _kIndeterminateAnimationDuration = 8000
private const val IndeterminateAnimationTurns = 6 // from yaru_circular_progress_indicator.dart: _kIndeterminateAnimationTurns = 6
private const val MinGap = 0.2f // from yaru_circular_progress_indicator.dart: _kMinGap = 0.2
private const val MaxGap = 0.5f // from yaru_circular_progress_indicator.dart: _kMaxGap = 0.5
private const val Turn = (2.0 * PI).toFloat() // from yaru_circular_progress_indicator.dart: _turn = math.pi * 2
private const val CircleThird = Turn / 3f // from yaru_circular_progress_indicator.dart: circleThird = _turn / 3
private const val StartAngleDeg = -90f // from yaru_circular_progress_indicator.dart: _kStartAngle = -math.pi / 2

/**
 * Yaru-flavored circular progress indicator — Canvas-painted, no Material3.
 *
 * Mirrors `_DeterminateYaruCircularProgressIndicatorPainter` and the
 * indeterminate state machine from
 * `yaru.dart/lib/src/widgets/yaru_circular_progress_indicator.dart`.
 *
 * Indeterminate cycle: 1000 ms initial fade-in then 8000 ms continuous loop
 * spanning 6 turns, with `Curves.easeInOutSine`. Three arc segments each cover
 * one third of the circle minus a pulsing gap (0.2..0.5 rad).
 */
@Composable
fun YaruCircularProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float? = null,
    color: Color = LocalYaruColorScheme.current.primary,
    trackColor: Color = color.copy(alpha = DefaultTrackOpacity),
    strokeWidth: Dp = DefaultStrokeWidth,
    trackStrokeWidth: Dp = strokeWidth,
) {
    // Clamp stroke widths to a finite non-negative range — `Stroke(width = ...)`
    // throws on negative or non-finite widths, and a NaN / ±Infinity Dp would
    // explode `defaultMinSize` → `roundToPx`. Falling back to the default
    // keeps the widget renderable instead of crashing the composition.
    val safeStrokeWidth =
        if (strokeWidth.value.isFinite() && strokeWidth.value >= 0f) strokeWidth
        else DefaultStrokeWidth
    val safeTrackStrokeWidth =
        if (trackStrokeWidth.value.isFinite() && trackStrokeWidth.value >= 0f) trackStrokeWidth
        else safeStrokeWidth
    // Defensive: a caller-supplied `color` with non-finite channels (e.g.
    // `Color.Unspecified`, NaN alpha) would propagate into `drawArc`, which
    // Skia rejects. The default `trackColor` derives from `color`, so sanitise
    // it too.
    val safeColor = sanitiseColor(color)
    val safeTrackColor = sanitiseColor(trackColor)
    if (progress != null) {
        // Sanitise NaN — `Float.coerceIn` propagates NaN through unchanged
        // (NaN comparisons all return false), which would later feed `drawArc`
        // with a NaN sweep angle and crash skia's path validation.
        val safe = if (progress.isNaN()) 0f else progress.coerceIn(0f, 1f)
        // Wrap the Canvas in a Box that owns the `defaultMinSize` — without
        // this, callers passing unbounded-height constraints (e.g. a
        // `LazyColumn` item with no explicit `Modifier.height`) make Spacer's
        // measure policy return `0` for the unbounded axis, and the
        // `DrawScope.size` inside the Canvas comes out as `(W, 0)` so
        // `paintDeterminate` exits early on `radius <= 0` and nothing is
        // painted. The Box resolves the layout to at least 36×36 first; then
        // `matchParentSize` snaps the Canvas to that resolved size before
        // drawing. Mirrors Dart's `Container(constraints: minWidth/minHeight: 36)`.
        Box(modifier = modifier.defaultMinSize(DefaultMinSize, DefaultMinSize)) {
            Canvas(modifier = Modifier.matchParentSize()) {
                paintDeterminate(
                    size = GeomSize(size.width, size.height),
                    value = safe,
                    color = safeColor,
                    trackColor = safeTrackColor,
                    strokeWidth = safeStrokeWidth.toPx(),
                    trackStrokeWidth = safeTrackStrokeWidth.toPx(),
                )
            }
        }
    } else {
        // Single Animatable mirrors Dart's one `AnimationController`: it runs
        // the 1000 ms initial ramp once, then transitions into an 8000 ms
        // looping forward animation. Running both stages in one timeline keeps
        // the loop phase aligned with the moment the initial ramp finishes —
        // exactly how the Dart source schedules them via `await forward()`
        // followed by `await repeat()`.
        val progressAnim = remember { Animatable(0f) }
        var initial by remember { mutableStateOf(true) }

        LaunchedEffect(Unit) {
            // Initial ramp: 0 -> 1 over 1000 ms (linear; the eased shape comes
            // from the `Curves.easeInOut` applied below to barSizeProgress).
            progressAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(InitialAnimationDurationMs, easing = LinearEasing),
            )
            initial = false
            // Continuous 8000 ms loop. Snap back to 0 then keep advancing 0->1
            // forever — easeInOutSine is applied per-frame to gap/rotation.
            while (true) {
                progressAnim.snapTo(0f)
                progressAnim.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(LoopAnimationDurationMs, easing = LinearEasing),
                )
            }
        }

        Box(modifier = modifier.defaultMinSize(DefaultMinSize, DefaultMinSize)) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val t = progressAnim.value
            val barSizeProgress: Float
            val gapProgress: Float
            val rotationProgress: Float
            if (initial) {
                // from yaru_circular_progress_indicator.dart L150:
                //   barSizeProgress = CurveTween(curve: Curves.easeInOut).transform(progress)
                barSizeProgress = YaruEasing.EaseInOut.transform(t.coerceIn(0f, 1f))
                gapProgress = 0f
                rotationProgress = 0f
            } else {
                barSizeProgress = 1f
                // from yaru_circular_progress_indicator.dart L156-160:
                //   spacingProgress = 1 - |Tween(-1, 1).chain(easeInOutSine).transform(t)|
                //                   = 1 - |easeInOutSine(t) * 2 - 1|
                val eased = YaruEasing.EaseInOutSine.transform(t)
                gapProgress = 1f - abs(eased * 2f - 1f)
                // from yaru_circular_progress_indicator.dart L162-168:
                //   rotationProgress = Tween(0, turn * 6).chain(easeInOutSine).transform(t)
                rotationProgress = eased * Turn * IndeterminateAnimationTurns
            }
            paintIndeterminate(
                size = GeomSize(size.width, size.height),
                color = safeColor,
                strokeWidth = safeStrokeWidth.toPx(),
                barSizeProgress = barSizeProgress,
                gapProgress = gapProgress,
                rotationProgress = rotationProgress,
            )
        }
        }
    }
}

private fun DrawScope.paintDeterminate(
    size: GeomSize,
    value: Float,
    color: Color,
    trackColor: Color,
    strokeWidth: Float,
    trackStrokeWidth: Float,
) {
    val inset = strokeWidth / 2f
    // Guard against canvas dimensions smaller than the stroke — a negative
    // radius would feed `drawArc` a negative `Size`, which Skia rejects.
    val radius = (min(size.width / 2f, size.height / 2f) - inset).coerceAtLeast(0f)
    if (radius <= 0f) return
    val arcSize = GeomSize(radius * 2f, radius * 2f)
    val topLeft = Offset(size.width / 2f - radius, size.height / 2f - radius)
    drawArc(
        color = trackColor,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = Stroke(width = trackStrokeWidth, cap = StrokeCap.Butt),
    )
    drawArc(
        color = color,
        startAngle = StartAngleDeg,
        sweepAngle = 360f * value,
        useCenter = false,
        topLeft = topLeft,
        size = arcSize,
        style = Stroke(width = strokeWidth, cap = StrokeCap.Butt),
    )
}

private fun DrawScope.paintIndeterminate(
    size: GeomSize,
    color: Color,
    strokeWidth: Float,
    barSizeProgress: Float,
    gapProgress: Float,
    rotationProgress: Float,
) {
    val inset = strokeWidth / 2f
    // Same guard as the determinate painter — avoid negative-size arcs.
    val radius = (min(size.width / 2f, size.height / 2f) - inset).coerceAtLeast(0f)
    if (radius <= 0f) return
    val arcSize = GeomSize(radius * 2f, radius * 2f)
    val topLeft = Offset(size.width / 2f - radius, size.height / 2f - radius)

    val gap = MinGap + (MaxGap - MinGap) * gapProgress
    val sweepRad = (CircleThird - gap) * barSizeProgress
    val sweepDeg = sweepRad * (180f / PI.toFloat())
    val rotationDeg = rotationProgress * (180f / PI.toFloat())
    val thirdDeg = CircleThird * (180f / PI.toFloat())

    val stroke = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
    // from yaru_circular_progress_indicator.dart: `for (var i = 0; i < 3; i++)` — three arc segments per turn
    for (i in 0 until 3) {
        val startDeg =
            i * thirdDeg - (sweepDeg / 2f * barSizeProgress) + rotationDeg
        drawArc(
            color = color,
            startAngle = startDeg,
            sweepAngle = sweepDeg,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = stroke,
        )
    }
}
