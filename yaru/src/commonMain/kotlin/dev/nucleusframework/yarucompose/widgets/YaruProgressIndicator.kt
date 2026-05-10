package dev.nucleusframework.yarucompose.widgets

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * Shared properties for [YaruCircularProgressIndicator] and
 * [YaruLinearProgressIndicator].
 *
 * Mirrors the abstract `YaruProgressIndicator` from
 * `yaru.dart/lib/src/widgets/yaru_progress_indicator.dart`. The abstract class
 * mostly served as a parameter holder in Dart; in Compose the parameters are
 * already first-class on each composable, so this data class is provided as a
 * convenience for callers that want to share defaults.
 */
@Immutable
data class YaruProgressIndicatorDefaults(
    val progress: Float? = null,
    val color: Color? = null,
    val trackColor: Color? = null,
    val strokeWidth: Dp? = null,
    val trackStrokeWidth: Dp? = null,
    val semanticsLabel: String? = null,
    val semanticsValue: String? = null,
)
