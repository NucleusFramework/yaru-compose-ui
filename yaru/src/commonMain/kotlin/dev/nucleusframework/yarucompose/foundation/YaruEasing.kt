package dev.nucleusframework.yarucompose.foundation

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing

/**
 * Animation curves used by yaru.dart, lifted from Flutter's `Curves` constants.
 *
 * Source: https://github.com/flutter/flutter/blob/master/packages/flutter/lib/src/animation/curves.dart
 *
 * All values are the exact cubic-bezier control points used by Flutter's
 * `Curves` class, so animations stay bit-identical to the Flutter Yaru reference.
 *
 * The `bounceIn` / `bounceOut` curves are not cubic bezier — Flutter implements
 * them with a piecewise polynomial in `_bounce(double t)` which is reproduced
 * verbatim below.
 */
object YaruEasing {

    /** `Curves.ease` — Flutter's default `AnimationController.animateTo` curve. */
    val Ease: Easing = CubicBezierEasing(0.25f, 0.1f, 0.25f, 1f)

    /** `Curves.easeIn` — generic enter curve. */
    val EaseIn: Easing = CubicBezierEasing(0.42f, 0f, 1f, 1f)

    /** `Curves.easeOut` — generic exit curve. */
    val EaseOut: Easing = CubicBezierEasing(0f, 0f, 0.58f, 1f)

    /** `Curves.easeInOut` — symmetric ease. */
    val EaseInOut: Easing = CubicBezierEasing(0.42f, 0f, 0.58f, 1f)

    /** `Curves.easeInQuad` — togglable position forward curve. */
    val EaseInQuad: Easing = CubicBezierEasing(0.55f, 0.085f, 0.68f, 0.53f)

    /** `Curves.easeOutQuad` — togglable position reverse curve. */
    val EaseOutQuad: Easing = CubicBezierEasing(0.25f, 0.46f, 0.45f, 0.94f)

    /** `Curves.easeInOutCubic` — chevron rotation, expandable content. */
    val EaseInOutCubic: Easing = CubicBezierEasing(0.645f, 0.045f, 0.355f, 1f)

    /** `Curves.easeInOutSine` — indeterminate progress indicators. */
    val EaseInOutSine: Easing = CubicBezierEasing(0.445f, 0.05f, 0.55f, 0.95f)

    /** `Curves.easeOutExpo` — secondary fade in vertical page transitions. */
    val EaseOutExpo: Easing = CubicBezierEasing(0.19f, 1f, 0.22f, 1f)

    /** `Curves.fastOutSlowIn`. */
    val FastOutSlowIn: Easing = CubicBezierEasing(0.4f, 0f, 0.2f, 1f)

    /** `Curves.linearToEaseOut` — carousel transitions when slowing in. */
    val LinearToEaseOut: Easing = CubicBezierEasing(0.35f, 0.91f, 0.33f, 0.97f)

    /** `Curves.bounceIn` — defined as `1 - bounceOut(1 - t)` in Flutter. */
    val BounceIn: Easing = Easing { t -> 1f - bounceOut(1f - t) }

    /** `Curves.bounceOut` — Flutter's piecewise `_bounce(t)` polynomial. */
    val BounceOut: Easing = Easing { t -> bounceOut(t) }

    /** `Curves.bounceInOut` — Flutter's symmetric bounce. */
    val BounceInOut: Easing = Easing { t ->
        if (t < 0.5f) (1f - bounceOut(1f - 2f * t)) * 0.5f
        else bounceOut(2f * t - 1f) * 0.5f + 0.5f
    }

    /**
     * Reproduces Flutter's private `_bounce(double t)` from
     * `packages/flutter/lib/src/animation/curves.dart`.
     */
    private fun bounceOut(t: Float): Float {
        var x = t
        if (x < 1f / 2.75f) {
            return 7.5625f * x * x
        } else if (x < 2f / 2.75f) {
            x -= 1.5f / 2.75f
            return 7.5625f * x * x + 0.75f
        } else if (x < 2.5f / 2.75f) {
            x -= 2.25f / 2.75f
            return 7.5625f * x * x + 0.9375f
        }
        x -= 2.625f / 2.75f
        return 7.5625f * x * x + 0.984375f
    }
}

/**
 * Apply an [Easing] to a normalized [Float].
 *
 * Inputs outside `[0, 1]` (or NaN) are clamped before evaluation: Compose's
 * [CubicBezierEasing] only guarantees defined behavior on the unit interval and
 * will throw for inputs outside it.
 */
internal fun Float.applyEase(easing: Easing): Float {
    val clamped = if (this.isNaN()) 0f else this.coerceIn(0f, 1f)
    return easing.transform(clamped)
}
