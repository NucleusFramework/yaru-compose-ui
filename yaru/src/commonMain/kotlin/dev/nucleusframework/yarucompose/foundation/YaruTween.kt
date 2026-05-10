package dev.nucleusframework.yarucompose.foundation

/**
 * Sample-based animation transforms ported from
 * `yaru.dart/lib/src/foundation/yaru_tween.dart`.
 *
 * Each transform takes a normalized `t` value (typically in [0, 1])
 * and returns the resulting value.
 */

/** A four-stage tween that fades out then back in over a single animation cycle. */
internal class ProgressiveVisibilityTween(
    val fadeOutStart: Float,
    val fadeOutEnd: Float,
    val fadeInStart: Float,
    val fadeInEnd: Float,
) {
    init {
        require(fadeOutStart < fadeOutEnd) {
            "fadeOutStart ($fadeOutStart) must be < fadeOutEnd ($fadeOutEnd)"
        }
        require(fadeInStart < fadeInEnd) {
            "fadeInStart ($fadeInStart) must be < fadeInEnd ($fadeInEnd)"
        }
        require(fadeOutEnd <= fadeInStart) {
            "fadeOutEnd ($fadeOutEnd) must be <= fadeInStart ($fadeInStart)"
        }
    }

    fun transform(t: Float): Float = when {
        t.isNaN() -> 1f // Defensive: NaN would fall through every comparison and silently land on `else`.
        t < fadeOutStart -> 1f
        t < fadeOutEnd -> 1f - ((t - fadeOutStart) / (fadeOutEnd - fadeOutStart))
        t < fadeInStart -> 0f
        t < fadeInEnd -> (t - fadeInStart) / (fadeInEnd - fadeInStart)
        else -> 1f
    }
}

/** A linear tween that ramps from 0 to 1 between [start] and [end] and clamps outside. */
internal class YaruClampingTween(val start: Float, val end: Float) {
    init {
        // Defensive: NaN/Infinity bounds would poison every transform call.
        require(start.isFinite() && end.isFinite()) {
            "start ($start) and end ($end) must be finite"
        }
        // Defensive: equal or inverted bounds would divide by zero or produce negative output.
        require(start < end) { "start ($start) must be < end ($end)" }
    }

    fun transform(t: Float): Float = when {
        t.isNaN() -> 0f // Defensive: NaN passes neither `<=` nor `>=` and would reach the division branch.
        t <= start -> 0f
        t >= end -> 1f
        else -> (t - start) / (end - start)
    }
}
