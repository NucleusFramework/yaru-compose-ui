package dev.nucleusframework.yarucompose.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/** Describe the position of a diagonal clip. */
enum class YaruDiagonalClip { TopLeft, TopRight, BottomLeft, BottomRight }

/**
 * Clips [content] using a diagonal triangle path at the given [position].
 *
 * Mirrors `YaruClip.diagonal` from `yaru.dart/lib/src/foundation/yaru_clip.dart`.
 */
@Composable
fun YaruDiagonalClipBox(
    position: YaruDiagonalClip,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {},
) {
    Box(modifier = modifier.clip(DiagonalShape(position))) {
        content()
    }
}

private class DiagonalShape(private val position: YaruDiagonalClip) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline = Outline.Generic(buildPath(size))

    private fun buildPath(size: Size): Path = Path().apply {
        // Degenerate or non-finite sizes can yield malformed outlines on some
        // backends — emit an empty path instead of building a triangle with
        // NaN/Inf or zero-area coordinates.
        val w = size.width
        val h = size.height
        if (!w.isFinite() || !h.isFinite() || w <= 0f || h <= 0f) return@apply
        when (position) {
            YaruDiagonalClip.TopLeft -> {
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(0f, size.height)
                close()
            }
            YaruDiagonalClip.TopRight -> {
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                close()
            }
            YaruDiagonalClip.BottomLeft -> {
                moveTo(0f, 0f)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            YaruDiagonalClip.BottomRight -> {
                moveTo(size.width, 0f)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
        }
    }
}
