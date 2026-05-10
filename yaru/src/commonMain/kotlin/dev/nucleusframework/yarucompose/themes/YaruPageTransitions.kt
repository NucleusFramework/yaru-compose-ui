package dev.nucleusframework.yarucompose.themes

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import dev.nucleusframework.yarucompose.foundation.YaruEasing

/**
 * Page transitions equivalent to Yaru's
 * `YaruPageTransitionsTheme.horizontal` / `.vertical`.
 *
 * Mirrors `yaru.dart/lib/src/themes/page_transitions.dart`. Use these
 * with `AnimatedContent` (or any container that consumes a [ContentTransform])
 * by passing the result of [yaruHorizontalTransition] / [yaruVerticalTransition].
 */
object YaruPageTransitions {
    // Flutter's default `PageRoute.transitionDuration` is 300ms.
    private const val DURATION_MS = 300

    /** Horizontal slide and fade — best for desktop wizards or master-detail in portrait. */
    fun horizontal(): ContentTransform =
        (slideInHorizontally(
            animationSpec = tween(DURATION_MS, easing = YaruEasing.FastOutSlowIn),
            initialOffsetX = { (it * 0.2f).toInt() },
        ) + fadeIn(animationSpec = tween(DURATION_MS, easing = YaruEasing.EaseIn)))
            .togetherWith(
                slideOutHorizontally(
                    animationSpec = tween(DURATION_MS, easing = YaruEasing.FastOutSlowIn),
                    targetOffsetX = { -(it * 0.2f).toInt() },
                ) + fadeOut(animationSpec = tween(DURATION_MS, easing = YaruEasing.EaseIn)),
            )

    /** Vertical slide and fade — best for master-detail in landscape mode. */
    fun vertical(): ContentTransform =
        (slideInVertically(
            animationSpec = tween(DURATION_MS, easing = YaruEasing.FastOutSlowIn),
            initialOffsetY = { (it * 0.1f).toInt() },
        ) + fadeIn(animationSpec = tween(DURATION_MS, easing = YaruEasing.EaseIn)))
            .togetherWith(
                // Dart's vertical secondary slide tween is `Offset.zero → Offset.zero`
                // (no-op), so only the outgoing opacity is animated, with `easeOutExpo`.
                fadeOut(animationSpec = tween(DURATION_MS, easing = YaruEasing.EaseOutExpo)),
            )
}

/** Convenience accessor matching Dart naming. */
fun yaruHorizontalTransition(): ContentTransform = YaruPageTransitions.horizontal()

/** Convenience accessor matching Dart naming. */
fun yaruVerticalTransition(): ContentTransform = YaruPageTransitions.vertical()
