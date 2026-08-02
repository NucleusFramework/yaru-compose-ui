package sample.app.pages

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.widgets.YaruDraggable
import dev.nucleusframework.yarucompose.widgets.YaruText
import sample.app.gallery.ExampleCard
import sample.app.gallery.GalleryExample
import sample.app.gallery.GalleryPage
import sample.app.gallery.generated.GallerySources

/** Mirrors `yaru.dart/example/lib/pages/draggable_page.dart`. */
@Composable
fun DraggablePage() {
    GalleryPage(description = "A child the user can drag around, with the position clamped by the caller.") {
        ExampleCard(
            title = "YaruDraggable",
            description = "`onDragUpdate` returns the accepted position — here clamped to the frame.",
            sourceCode = GallerySources.DraggableExample,
        ) { DraggableExample() }
    }
}

@GalleryExample("YaruDraggable", "Clamped")
@Composable
private fun DraggableExample() {
    val scheme = LocalYaruColorScheme.current
    Box(
        modifier = Modifier
            .size(width = 500.dp, height = 250.dp)
            .background(scheme.onSurface.copy(alpha = 0.1f)),
    ) {
        YaruDraggable(
            initialPosition = Offset.Zero,
            onDragUpdate = { _, candidate ->
                Offset(
                    x = candidate.x.coerceIn(0f, (500 - 192).toFloat()),
                    y = candidate.y.coerceIn(0f, (250 - 108).toFloat()),
                )
            },
        ) { position, isDragging, _ ->
            val opacity by animateFloatAsState(targetValue = if (isDragging) 1f else 0.85f)
            Box(
                modifier = Modifier
                    .size(width = 192.dp, height = 108.dp)
                    .alpha(opacity)
                    .background(scheme.primary)
                    .drawBehind {
                        drawRect(
                            color = Color.Black,
                            topLeft = Offset.Zero,
                            size = Size(size.width, 10.dp.toPx()),
                        )
                    },
                contentAlignment = Alignment.Center,
            ) {
                YaruText(
                    text = "(${position.x.toInt()}, ${position.y.toInt()})",
                    color = scheme.onPrimary,
                )
            }
        }
    }
}
