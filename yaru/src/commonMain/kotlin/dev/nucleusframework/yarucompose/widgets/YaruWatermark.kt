package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative

/**
 * Renders [watermark] on top of [content] with reduced [opacity] and
 * pass-through pointer events.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_watermark.dart`. The Dart code uses
 * `Stack(children: [child, IgnorePointer(...watermark...)])`: the watermark
 * paints ABOVE the child but never receives input.
 *
 * Defaults from yaru_watermark.dart:
 *  - `alignment = AlignmentDirectional.centerEnd` (L18)
 *  - `padding = EdgeInsets.all(20)` (L19)
 *  - `opacity = 0.1` (L20)
 */
@Composable
fun YaruWatermark(
    watermark: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    // AlignmentDirectional.centerEnd from yaru_watermark.dart L18.
    alignment: Alignment = Alignment.CenterEnd,
    // EdgeInsets.all(20) from yaru_watermark.dart L19.
    padding: PaddingValues = PaddingValues(20.dp),
    // opacity = 0.1 from yaru_watermark.dart L20.
    opacity: Float = 0.1f,
    content: @Composable () -> Unit,
) {
    // Defensive clamps: `Modifier.padding` throws `IllegalArgumentException`
    // on negative values, and `Modifier.alpha` should not receive NaN /
    // out-of-range floats. Callers may forward unvalidated config (e.g.
    // user-supplied theme tokens). Mirrors the defensive pattern applied
    // to YaruIconButton/YaruDialog/YaruExpansionPanel.
    val layoutDirection = LocalLayoutDirection.current
    val safePadding = padding.coerceNonNegative(layoutDirection)
    val safeOpacity = if (opacity.isNaN()) 0f else opacity.coerceIn(0f, 1f)
    Box(modifier = modifier) {
        // Child is painted first.
        content()
        // Watermark layer fills the parent and aligns the (padded) glyph.
        // Without pointerInput / clickable on this Box pointer events fall
        // through to the child below — equivalent to Flutter's IgnorePointer.
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(safePadding),
            contentAlignment = alignment,
        ) {
            Box(modifier = Modifier.alpha(safeOpacity)) { watermark() }
        }
    }
}

