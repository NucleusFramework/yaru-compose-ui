package sample.app.pages

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruDraggable
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText

/**
 * Mirrors `yaru.dart/example/lib/pages/draggable_page.dart`.
 *
 * Dart wraps a single `YaruDraggable` inside a 500x250 `Container` tinted
 * `onSurface @ 0.1`, then renders a 192x108 rectangle with a *top-only* 10px
 * black border filled with `primaryColor`. Opacity animates 0.85 → 1.0 while
 * dragging (Dart `AnimatedOpacity` 100ms).
 */
@Composable
fun DraggablePage() {
    val scheme = LocalYaruColorScheme.current
    val scrollState = rememberScrollState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        // `padding: const EdgeInsets.all(kYaruPagePadding)` (draggable_page.dart:13).
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(YaruConstants.PagePadding),
        ) {
            // `Container(color: onSurface @ 0.1, child: SizedBox(500, 250, ...))` (draggable_page.dart:14-21).
            Box(
                modifier = Modifier
                    .size(width = 500.dp, height = 250.dp)
                    .background(scheme.onSurface.copy(alpha = 0.1f)),
            ) {
                // `YaruDraggable(initialPosition: Offset.zero, onDragUpdate: ..., childBuilder: ...)` (draggable_page.dart:23-65).
                YaruDraggable(
                    initialPosition = Offset.Zero,
                    onDragUpdate = { _, candidate ->
                        // Dart clamps to [0, 500-192] x [0, 250-108] (draggable_page.dart:26-33).
                        val maxX = (500 - 192).toFloat()
                        val maxY = (250 - 108).toFloat()
                        Offset(
                            x = candidate.x.coerceIn(0f, maxX),
                            y = candidate.y.coerceIn(0f, maxY),
                        )
                    },
                ) { position, isDragging, _ ->
                    // `AnimatedOpacity(opacity: isDragging ? 1 : .85, duration: 100ms)` (draggable_page.dart:40-42).
                    val opacity by animateFloatAsState(targetValue = if (isDragging) 1f else 0.85f)
                    Box(
                        modifier = Modifier
                            .size(width = 192.dp, height = 108.dp)
                            .alpha(opacity)
                            .background(scheme.primary)
                            // `Border(top: BorderSide(width: 10))` — top-only 10px black (draggable_page.dart:45-47).
                            .drawBehind {
                                val strokePx = 10.dp.toPx()
                                drawRect(
                                    color = Color.Black,
                                    topLeft = Offset.Zero,
                                    size = androidx.compose.ui.geometry.Size(size.width, strokePx),
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
    }
}
