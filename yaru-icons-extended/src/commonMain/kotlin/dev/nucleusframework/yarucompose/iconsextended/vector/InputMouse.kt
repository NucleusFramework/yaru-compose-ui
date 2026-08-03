package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val InputMouse: ImageVector
    get() {
        if (_InputMouse != null) {
            return _InputMouse!!
        }
        _InputMouse = ImageVector.Builder(
            name = "InputMouse",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 3.8833706f,
                pathData = addPathNodes("m 328.44 238.0 c -1.31 0.0 -2.56 0.23 -3.79 0.65 l -0.17 0.06 l -1.1 5.08 c -0.19 0.86 -0.37 1.75 -0.38 2.67 c -0.0 0.92 0.18 1.85 0.62 2.69 c 0.44 0.84 1.13 1.58 1.99 2.08 c 0.86 0.51 1.87 0.77 2.89 0.77 c 1.02 0.0 2.03 -0.27 2.89 -0.77 c 0.86 -0.51 1.55 -1.24 1.99 -2.08 c 0.44 -0.84 0.62 -1.77 0.62 -2.69 c -0.0 -0.92 -0.19 -1.81 -0.38 -2.67 l -1.1 -5.08 l -0.17 -0.06 c -1.23 -0.41 -2.59 -0.65 -3.9 -0.65 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 328.44 237.0 c -1.31 0.0 -2.56 0.23 -3.79 0.65 l -0.17 0.06 l -1.1 5.08 c -0.19 0.86 -0.37 1.75 -0.38 2.67 c -0.0 0.92 0.18 1.85 0.62 2.69 c 0.44 0.84 1.13 1.58 1.99 2.08 c 0.86 0.51 1.87 0.77 2.89 0.77 c 1.02 0.0 2.03 -0.27 2.89 -0.77 c 0.86 -0.51 1.55 -1.24 1.99 -2.08 c 0.44 -0.84 0.62 -1.77 0.62 -2.69 c -0.0 -0.92 -0.19 -1.81 -0.38 -2.67 l -1.1 -5.08 l -0.17 -0.06 c -1.23 -0.41 -2.59 -0.65 -3.9 -0.65 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 6.0517898f,
                pathData = addPathNodes("m 332.41 190.0 c -2.02 0.0 -3.96 0.37 -5.86 1.02 l -0.27 0.09 l -1.7 7.98 c -0.29 1.36 -0.58 2.76 -0.58 4.2 c -0.0 1.44 0.28 2.91 0.96 4.23 c 0.68 1.32 1.74 2.48 3.07 3.27 c 1.33 0.79 2.9 1.22 4.47 1.22 c 1.57 0.0 3.14 -0.42 4.47 -1.22 c 1.33 -0.79 2.39 -1.95 3.07 -3.27 c 0.68 -1.32 0.96 -2.79 0.96 -4.23 c -0.0 -1.44 -0.29 -2.84 -0.58 -4.2 l -1.71 -7.98 l -0.27 -0.09 C 336.54 190.37 334.44 190.0 332.41 190.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.41 189.0 c -2.02 0.0 -3.96 0.37 -5.86 1.02 l -0.27 0.09 l -1.7 7.98 c -0.29 1.36 -0.58 2.76 -0.58 4.2 c -0.0 1.44 0.28 2.91 0.96 4.23 c 0.68 1.32 1.74 2.48 3.07 3.27 c 1.33 0.79 2.9 1.22 4.47 1.22 c 1.57 0.0 3.14 -0.42 4.47 -1.22 c 1.33 -0.79 2.39 -1.95 3.07 -3.27 c 0.68 -1.32 0.96 -2.79 0.96 -4.23 c -0.0 -1.44 -0.29 -2.84 -0.58 -4.2 l -1.71 -7.98 l -0.27 -0.09 C 336.54 189.37 334.44 189.0 332.41 189.0 Z")
            )
            addPath(
                fillAlpha = 0.1f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.1f,
                strokeLineWidth = 2.0417206f,
                pathData = addPathNodes("m 336.38 133.98 c -2.73 0.0 -5.35 0.5 -7.91 1.38 l -0.36 0.12 l -2.3 10.88 c -0.39 1.85 -0.78 3.76 -0.79 5.73 c -0.01 1.97 0.38 3.96 1.29 5.77 c 0.92 1.81 2.36 3.38 4.15 4.46 c 1.79 1.08 3.91 1.66 6.04 1.66 c 2.13 0.0 4.24 -0.58 6.04 -1.66 c 1.8 -1.08 3.23 -2.65 4.15 -4.46 c 0.92 -1.81 1.3 -3.8 1.29 -5.77 c -0.01 -1.97 -0.39 -3.87 -0.78 -5.73 l -2.3 -10.88 l -0.36 -0.12 c -2.57 -0.89 -5.41 -1.38 -8.14 -1.38 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.38 132.98 c -2.73 0.0 -5.35 0.5 -7.91 1.38 l -0.36 0.12 l -2.3 10.88 c -0.39 1.85 -0.78 3.76 -0.79 5.73 c -0.01 1.97 0.38 3.96 1.29 5.77 c 0.92 1.81 2.36 3.38 4.15 4.46 c 1.79 1.08 3.91 1.66 6.04 1.66 c 2.13 0.0 4.24 -0.58 6.04 -1.66 c 1.8 -1.08 3.23 -2.65 4.15 -4.46 c 0.92 -1.81 1.3 -3.8 1.29 -5.77 c -0.01 -1.97 -0.39 -3.87 -0.78 -5.73 l -2.3 -10.88 l -0.36 -0.12 c -2.57 -0.89 -5.41 -1.38 -8.14 -1.38 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 344.33 60.94 c -4.05 0.0 -7.93 0.78 -11.71 2.14 l -1.05 0.38 l -3.42 16.89 c -0.56 2.79 -1.14 5.72 -1.15 8.8 c -0.01 3.08 0.56 6.23 1.96 9.11 c 1.4 2.88 3.59 5.38 6.33 7.11 c 2.74 1.73 5.97 2.64 9.21 2.64 c 3.24 0.0 6.46 -0.92 9.21 -2.64 c 2.75 -1.73 4.93 -4.23 6.33 -7.11 c 1.4 -2.87 1.97 -6.03 1.96 -9.11 c -0.01 -3.08 -0.58 -6.01 -1.15 -8.8 l -3.42 -16.89 l -1.05 -0.38 c -3.8 -1.37 -7.99 -2.14 -12.04 -2.14 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.33 60.94 c -3.93 0.0 -7.68 0.75 -11.37 2.08 l -0.52 0.19 l -3.31 16.34 c -0.56 2.78 -1.12 5.65 -1.13 8.6 c -0.01 2.95 0.54 5.95 1.86 8.67 c 1.32 2.71 3.39 5.07 5.97 6.7 c 2.58 1.63 5.62 2.49 8.68 2.49 c 3.05 0.0 6.1 -0.86 8.68 -2.49 c 2.58 -1.63 4.64 -3.98 5.96 -6.7 c 1.32 -2.71 1.87 -5.71 1.86 -8.67 c -0.01 -2.95 -0.56 -5.82 -1.13 -8.6 l -3.31 -16.34 l -0.52 -0.19 c -3.69 -1.33 -7.78 -2.08 -11.71 -2.08 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        0.47f to Color(0xFFCDCDCD),
                        1f to Color(0xFFE6E6E6)
                    ),
                    center = Offset(344.5f, 94f),
                    radius = 30f
                ),
                strokeLineWidth = 12.067644f,
                pathData = addPathNodes("m 344.33 60.94 c -3.93 0.0 -7.68 0.75 -11.37 2.08 l -0.52 0.19 l -3.31 16.34 c -0.56 2.78 -1.12 5.65 -1.13 8.6 c -0.01 2.95 0.54 5.95 1.86 8.67 c 1.32 2.71 3.39 5.07 5.97 6.7 c 2.58 1.63 5.62 2.49 8.68 2.49 c 3.05 0.0 6.1 -0.86 8.68 -2.49 c 2.58 -1.63 4.64 -3.98 5.96 -6.7 c 1.32 -2.71 1.87 -5.71 1.86 -8.67 c -0.01 -2.95 -0.56 -5.82 -1.13 -8.6 l -3.31 -16.34 l -0.52 -0.19 c -3.69 -1.33 -7.78 -2.08 -11.71 -2.08 Z")
            )
            group(
                clipPathData = addPathNodes("m 344.33 60.94 c -3.93 0.0 -7.68 0.75 -11.37 2.08 l -0.52 0.19 l -3.31 16.34 c -0.56 2.78 -1.12 5.65 -1.13 8.6 c -0.01 2.95 0.54 5.95 1.86 8.67 c 1.32 2.71 3.39 5.07 5.97 6.7 c 2.58 1.63 5.62 2.49 8.68 2.49 c 3.05 0.0 6.1 -0.86 8.68 -2.49 c 2.58 -1.63 4.64 -3.98 5.96 -6.7 c 1.32 -2.71 1.87 -5.71 1.86 -8.67 c -0.01 -2.95 -0.56 -5.82 -1.13 -8.6 l -3.31 -16.34 l -0.52 -0.19 c -3.69 -1.33 -7.78 -2.08 -11.71 -2.08 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(348f, 62f),
                        end = Offset(348f, 107f)
                    ),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 344.33 60.94 c -3.93 0.0 -7.68 0.75 -11.37 2.08 l -0.52 0.19 l -3.31 16.34 c -0.56 2.78 -1.12 5.65 -1.13 8.6 c -0.01 2.95 0.54 5.95 1.86 8.67 c 1.32 2.71 3.39 5.07 5.97 6.7 c 2.58 1.63 5.62 2.49 8.68 2.49 c 3.05 0.0 6.1 -0.86 8.68 -2.49 c 2.58 -1.63 4.64 -3.98 5.96 -6.7 c 1.32 -2.71 1.87 -5.71 1.86 -8.67 c -0.01 -2.95 -0.56 -5.82 -1.13 -8.6 l -3.31 -16.34 l -0.52 -0.19 c -3.69 -1.33 -7.78 -2.08 -11.71 -2.08 Z")
                )
            }
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0f),
                        1f to Color.White
                    ),
                    center = Offset(344.5f, 98.5f),
                    radius = 22.5f
                ),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 12.067644f,
                pathData = addPathNodes("m 344.33 60.94 c -3.93 0.0 -7.68 0.75 -11.37 2.08 l -0.52 0.19 l -3.31 16.34 c -0.56 2.78 -1.12 5.65 -1.13 8.6 c -0.01 2.95 0.54 5.95 1.86 8.67 c 1.32 2.71 3.39 5.07 5.97 6.7 c 2.58 1.63 5.62 2.49 8.68 2.49 c 3.05 0.0 6.1 -0.86 8.68 -2.49 c 2.58 -1.63 4.64 -3.98 5.96 -6.7 c 1.32 -2.71 1.87 -5.71 1.86 -8.67 c -0.01 -2.95 -0.56 -5.82 -1.13 -8.6 l -3.31 -16.34 l -0.52 -0.19 c -3.69 -1.33 -7.78 -2.08 -11.71 -2.08 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        0.47f to Color(0xFFCDCDCD),
                        1f to Color(0xFFE6E6E6)
                    ),
                    center = Offset(336.5f, 154.99f),
                    radius = 20.87f
                ),
                strokeLineWidth = 8.21292f,
                pathData = addPathNodes("m 336.38 132.98 c -2.73 0.0 -5.35 0.5 -7.91 1.38 l -0.36 0.12 l -2.3 10.88 c -0.39 1.85 -0.78 3.76 -0.79 5.73 c -0.01 1.97 0.38 3.96 1.29 5.77 c 0.92 1.81 2.36 3.38 4.15 4.46 c 1.79 1.08 3.91 1.66 6.04 1.66 c 2.13 0.0 4.24 -0.58 6.04 -1.66 c 1.8 -1.08 3.23 -2.65 4.15 -4.46 c 0.92 -1.81 1.3 -3.8 1.29 -5.77 c -0.01 -1.97 -0.39 -3.87 -0.78 -5.73 l -2.3 -10.88 l -0.36 -0.12 c -2.57 -0.89 -5.41 -1.38 -8.14 -1.38 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0f),
                        1f to Color.White
                    ),
                    center = Offset(336.5f, 157.99f),
                    radius = 15.65f
                ),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 8.21292f,
                pathData = addPathNodes("m 336.38 132.98 c -2.73 0.0 -5.35 0.5 -7.91 1.38 l -0.36 0.12 l -2.3 10.88 c -0.39 1.85 -0.78 3.76 -0.79 5.73 c -0.01 1.97 0.38 3.96 1.29 5.77 c 0.92 1.81 2.36 3.38 4.15 4.46 c 1.79 1.08 3.91 1.66 6.04 1.66 c 2.13 0.0 4.24 -0.58 6.04 -1.66 c 1.8 -1.08 3.23 -2.65 4.15 -4.46 c 0.92 -1.81 1.3 -3.8 1.29 -5.77 c -0.01 -1.97 -0.39 -3.87 -0.78 -5.73 l -2.3 -10.88 l -0.36 -0.12 c -2.57 -0.89 -5.41 -1.38 -8.14 -1.38 Z")
            )
            addPath(
                stroke = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 1f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("M 344.5 61.0 L 344.5 77.0")
            )
            addPath(
                stroke = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 1f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 336.5 133.0 v 10.0")
            )
            group(
                clipPathData = addPathNodes("m 336.38 132.98 c -2.73 0.0 -5.35 0.5 -7.91 1.38 l -0.36 0.12 l -2.3 10.88 c -0.39 1.85 -0.78 3.76 -0.79 5.73 c -0.01 1.97 0.38 3.96 1.29 5.77 c 0.92 1.81 2.36 3.38 4.15 4.46 c 1.79 1.08 3.91 1.66 6.04 1.66 c 2.13 0.0 4.24 -0.58 6.04 -1.66 c 1.8 -1.08 3.23 -2.65 4.15 -4.46 c 0.92 -1.81 1.3 -3.8 1.29 -5.77 c -0.01 -1.97 -0.39 -3.87 -0.78 -5.73 l -2.3 -10.88 l -0.36 -0.12 c -2.57 -0.89 -5.41 -1.38 -8.14 -1.38 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(340f, 132f),
                        end = Offset(340f, 164f)
                    ),
                    fillAlpha = 0.3f,
                    strokeAlpha = 0.3f,
                    strokeLineWidth = 2.0417206f,
                    pathData = addPathNodes("m 336.38 132.98 c -2.73 0.0 -5.35 0.5 -7.91 1.38 l -0.36 0.12 l -2.3 10.88 c -0.39 1.85 -0.78 3.76 -0.79 5.73 c -0.01 1.97 0.38 3.96 1.29 5.77 c 0.92 1.81 2.36 3.38 4.15 4.46 c 1.79 1.08 3.91 1.66 6.04 1.66 c 2.13 0.0 4.24 -0.58 6.04 -1.66 c 1.8 -1.08 3.23 -2.65 4.15 -4.46 c 0.92 -1.81 1.3 -3.8 1.29 -5.77 c -0.01 -1.97 -0.39 -3.87 -0.78 -5.73 l -2.3 -10.88 l -0.36 -0.12 c -2.57 -0.89 -5.41 -1.38 -8.14 -1.38 Z")
                )
            }
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        0.47f to Color(0xFFCDCDCD),
                        1f to Color(0xFFE6E6E6)
                    ),
                    center = Offset(332.5f, 205.14f),
                    radius = 15.45f
                ),
                strokeLineWidth = 6.0517898f,
                pathData = addPathNodes("m 332.41 189.0 c -2.02 0.0 -3.96 0.37 -5.86 1.02 l -0.27 0.09 l -1.7 7.98 c -0.29 1.36 -0.58 2.76 -0.58 4.2 c -0.0 1.44 0.28 2.91 0.96 4.23 c 0.68 1.32 1.74 2.48 3.07 3.27 c 1.33 0.79 2.9 1.22 4.47 1.22 c 1.57 0.0 3.14 -0.42 4.47 -1.22 c 1.33 -0.79 2.39 -1.95 3.07 -3.27 c 0.68 -1.32 0.96 -2.79 0.96 -4.23 c -0.0 -1.44 -0.29 -2.84 -0.58 -4.2 l -1.71 -7.98 l -0.27 -0.09 C 336.54 189.37 334.44 189.0 332.41 189.0 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0f),
                        1f to Color.White
                    ),
                    center = Offset(332.5f, 207.34f),
                    radius = 11.59f
                ),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 6.0517898f,
                pathData = addPathNodes("m 332.41 189.0 c -2.02 0.0 -3.96 0.37 -5.86 1.02 l -0.27 0.09 l -1.7 7.98 c -0.29 1.36 -0.58 2.76 -0.58 4.2 c -0.0 1.44 0.28 2.91 0.96 4.23 c 0.68 1.32 1.74 2.48 3.07 3.27 c 1.33 0.79 2.9 1.22 4.47 1.22 c 1.57 0.0 3.14 -0.42 4.47 -1.22 c 1.33 -0.79 2.39 -1.95 3.07 -3.27 c 0.68 -1.32 0.96 -2.79 0.96 -4.23 c -0.0 -1.44 -0.29 -2.84 -0.58 -4.2 l -1.71 -7.98 l -0.27 -0.09 C 336.54 189.37 334.44 189.0 332.41 189.0 Z")
            )
            addPath(
                stroke = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 1f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 332.5 189.0 v 7.0")
            )
            group(
                clipPathData = addPathNodes("m 332.41 189.0 c -2.02 0.0 -3.96 0.37 -5.86 1.02 l -0.27 0.09 l -1.7 7.98 c -0.29 1.36 -0.58 2.76 -0.58 4.2 c -0.0 1.44 0.28 2.91 0.96 4.23 c 0.68 1.32 1.74 2.48 3.07 3.27 c 1.33 0.79 2.9 1.22 4.47 1.22 c 1.57 0.0 3.14 -0.42 4.47 -1.22 c 1.33 -0.79 2.39 -1.95 3.07 -3.27 c 0.68 -1.32 0.96 -2.79 0.96 -4.23 c -0.0 -1.44 -0.29 -2.84 -0.58 -4.2 l -1.71 -7.98 l -0.27 -0.09 C 336.54 189.37 334.44 189.0 332.41 189.0 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(334f, 190f),
                        end = Offset(334f, 211f)
                    ),
                    fillAlpha = 0.3f,
                    strokeAlpha = 0.3f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 332.41 189.0 c -2.02 0.0 -3.96 0.37 -5.86 1.02 l -0.27 0.09 l -1.7 7.98 c -0.29 1.36 -0.58 2.76 -0.58 4.2 c -0.0 1.44 0.28 2.91 0.96 4.23 c 0.68 1.32 1.74 2.48 3.07 3.27 c 1.33 0.79 2.9 1.22 4.47 1.22 c 1.57 0.0 3.14 -0.42 4.47 -1.22 c 1.33 -0.79 2.39 -1.95 3.07 -3.27 c 0.68 -1.32 0.96 -2.79 0.96 -4.23 c -0.0 -1.44 -0.29 -2.84 -0.58 -4.2 l -1.71 -7.98 l -0.27 -0.09 C 336.54 189.37 334.44 189.0 332.41 189.0 Z")
                )
            }
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        0.47f to Color(0xFFCDCDCD),
                        1f to Color(0xFFE6E6E6)
                    ),
                    center = Offset(328.5f, 247.27f),
                    radius = 10f
                ),
                strokeLineWidth = 3.8833706f,
                pathData = addPathNodes("m 328.44 237.0 c -1.31 0.0 -2.56 0.23 -3.79 0.65 l -0.17 0.06 l -1.1 5.08 c -0.19 0.86 -0.37 1.75 -0.38 2.67 c -0.0 0.92 0.18 1.85 0.62 2.69 c 0.44 0.84 1.13 1.58 1.99 2.08 c 0.86 0.51 1.87 0.77 2.89 0.77 c 1.02 0.0 2.03 -0.27 2.89 -0.77 c 0.86 -0.51 1.55 -1.24 1.99 -2.08 c 0.44 -0.84 0.62 -1.77 0.62 -2.69 c -0.0 -0.92 -0.19 -1.81 -0.38 -2.67 l -1.1 -5.08 l -0.17 -0.06 c -1.23 -0.41 -2.59 -0.65 -3.9 -0.65 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0f),
                        1f to Color.White
                    ),
                    center = Offset(328.5f, 248.67f),
                    radius = 7.5f
                ),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 3.8833706f,
                pathData = addPathNodes("m 328.44 237.0 c -1.31 0.0 -2.56 0.23 -3.79 0.65 l -0.17 0.06 l -1.1 5.08 c -0.19 0.86 -0.37 1.75 -0.38 2.67 c -0.0 0.92 0.18 1.85 0.62 2.69 c 0.44 0.84 1.13 1.58 1.99 2.08 c 0.86 0.51 1.87 0.77 2.89 0.77 c 1.02 0.0 2.03 -0.27 2.89 -0.77 c 0.86 -0.51 1.55 -1.24 1.99 -2.08 c 0.44 -0.84 0.62 -1.77 0.62 -2.69 c -0.0 -0.92 -0.19 -1.81 -0.38 -2.67 l -1.1 -5.08 l -0.17 -0.06 c -1.23 -0.41 -2.59 -0.65 -3.9 -0.65 Z")
            )
            addPath(
                stroke = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 1f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 328.5 237.0 v 5.0")
            )
            group(
                clipPathData = addPathNodes("m 328.44 237.0 c -1.31 0.0 -2.56 0.23 -3.79 0.65 l -0.17 0.06 l -1.1 5.08 c -0.19 0.86 -0.37 1.75 -0.38 2.67 c -0.0 0.92 0.18 1.85 0.62 2.69 c 0.44 0.84 1.13 1.58 1.99 2.08 c 0.86 0.51 1.87 0.77 2.89 0.77 c 1.02 0.0 2.03 -0.27 2.89 -0.77 c 0.86 -0.51 1.55 -1.24 1.99 -2.08 c 0.44 -0.84 0.62 -1.77 0.62 -2.69 c -0.0 -0.92 -0.19 -1.81 -0.38 -2.67 l -1.1 -5.08 l -0.17 -0.06 c -1.23 -0.41 -2.59 -0.65 -3.9 -0.65 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(329f, 237f),
                        end = Offset(329f, 251f)
                    ),
                    fillAlpha = 0.3f,
                    strokeAlpha = 0.3f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 328.44 237.0 c -1.31 0.0 -2.56 0.23 -3.79 0.65 l -0.17 0.06 l -1.1 5.08 c -0.19 0.86 -0.37 1.75 -0.38 2.67 c -0.0 0.92 0.18 1.85 0.62 2.69 c 0.44 0.84 1.13 1.58 1.99 2.08 c 0.86 0.51 1.87 0.77 2.89 0.77 c 1.02 0.0 2.03 -0.27 2.89 -0.77 c 0.86 -0.51 1.55 -1.24 1.99 -2.08 c 0.44 -0.84 0.62 -1.77 0.62 -2.69 c -0.0 -0.92 -0.19 -1.81 -0.38 -2.67 l -1.1 -5.08 l -0.17 -0.06 c -1.23 -0.41 -2.59 -0.65 -3.9 -0.65 Z")
                )
            }
            addPath(
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 149.11 35.66 c -20.95 0.0 -40.98 4.0 -60.66 11.09 l -2.78 1.0 l -17.63 87.16 c -3.01 14.84 -5.99 30.13 -6.04 45.88 c -0.05 15.76 2.89 31.76 9.92 46.22 c 7.04 14.47 18.06 27.05 31.82 35.72 c 13.76 8.67 29.97 13.28 46.27 13.28 c 16.29 0.0 32.51 -4.61 46.27 -13.28 c 13.76 -8.67 24.76 -21.25 31.79 -35.72 c 7.03 -14.46 9.97 -30.46 9.92 -46.22 c -0.05 -15.75 -3.0 -31.03 -6.0 -45.88 l -17.67 -87.16 l -2.78 -1.0 C 191.87 39.65 170.06 35.66 149.11 35.66 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 64.360794f,
                pathData = addPathNodes("m 149.11 38.66 c -20.95 0.0 -40.98 4.0 -60.66 11.09 l -2.78 1.0 l -17.63 87.16 c -3.01 14.84 -5.99 30.13 -6.04 45.88 c -0.05 15.76 2.89 31.76 9.92 46.22 c 7.04 14.47 18.06 27.05 31.82 35.72 c 13.76 8.67 29.97 13.28 46.27 13.28 c 16.29 0.0 32.51 -4.61 46.27 -13.28 c 13.76 -8.67 24.76 -21.25 31.79 -35.72 c 7.03 -14.46 9.97 -30.46 9.92 -46.22 c -0.05 -15.75 -3.0 -31.03 -6.0 -45.88 l -17.67 -87.16 l -2.78 -1.0 C 191.87 42.65 170.06 38.66 149.11 38.66 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 64.360794f,
                pathData = addPathNodes("m 149.11 36.66 c -20.95 0.0 -40.98 4.0 -60.66 11.09 l -2.78 1.0 l -17.63 87.16 c -3.01 14.84 -5.99 30.13 -6.04 45.88 c -0.05 15.76 2.89 31.76 9.92 46.22 c 7.04 14.47 18.06 27.05 31.82 35.72 c 13.76 8.67 29.97 13.28 46.27 13.28 c 16.29 0.0 32.51 -4.61 46.27 -13.28 c 13.76 -8.67 24.76 -21.25 31.79 -35.72 c 7.03 -14.46 9.97 -30.46 9.92 -46.22 c -0.05 -15.75 -3.0 -31.03 -6.0 -45.88 l -17.67 -87.16 l -2.78 -1.0 C 191.87 40.65 170.06 36.66 149.11 36.66 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.LightGray,
                        0.63f to Color(0xFFB3B3B3),
                        1f to Color(0xFFE6E6E6)
                    ),
                    center = Offset(150f, 212f),
                    radius = 160f
                ),
                strokeLineWidth = 64.360794f,
                pathData = addPathNodes("m 149.11 35.66 c -20.95 0.0 -40.98 4.0 -60.66 11.09 l -2.78 1.0 l -17.63 87.16 c -3.01 14.84 -5.99 30.13 -6.04 45.88 c -0.05 15.76 2.89 31.76 9.92 46.22 c 7.04 14.47 18.06 27.05 31.82 35.72 c 13.76 8.67 29.97 13.28 46.27 13.28 c 16.29 0.0 32.51 -4.61 46.27 -13.28 c 13.76 -8.67 24.76 -21.25 31.79 -35.72 c 7.03 -14.46 9.97 -30.46 9.92 -46.22 c -0.05 -15.75 -3.0 -31.03 -6.0 -45.88 l -17.67 -87.16 l -2.78 -1.0 C 191.87 39.65 170.06 35.66 149.11 35.66 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.White.copy(alpha = 0f),
                        1f to Color.White
                    ),
                    center = Offset(150f, 236f),
                    radius = 120f
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 64.360794f,
                pathData = addPathNodes("m 149.11 35.66 c -20.95 0.0 -40.98 4.0 -60.66 11.09 l -2.78 1.0 l -17.63 87.16 c -3.01 14.84 -5.99 30.13 -6.04 45.88 c -0.05 15.76 2.89 31.76 9.92 46.22 c 7.04 14.47 18.06 27.05 31.82 35.72 c 13.76 8.67 29.97 13.28 46.27 13.28 c 16.29 0.0 32.51 -4.61 46.27 -13.28 c 13.76 -8.67 24.76 -21.25 31.79 -35.72 c 7.03 -14.46 9.97 -30.46 9.92 -46.22 c -0.05 -15.75 -3.0 -31.03 -6.0 -45.88 l -17.67 -87.16 l -2.78 -1.0 C 191.87 39.65 170.06 35.66 149.11 35.66 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 64.360794f,
                pathData = addPathNodes("m 149.11 35.66 c -20.95 0.0 -40.98 4.0 -60.66 11.1 l -2.78 1.0 l -17.63 87.16 c -3.01 14.84 -5.99 30.13 -6.04 45.88 c -0.0 0.41 0.01 0.82 0.01 1.22 c 0.14 -15.47 3.07 -30.5 6.03 -45.1 l 17.63 -87.16 l 2.78 -1.0 c 19.68 -7.1 39.71 -11.1 60.66 -11.1 c 20.95 0.0 42.76 4.0 62.44 11.1 l 2.78 1.0 l 17.67 87.16 c 2.96 14.6 5.85 29.63 5.99 45.1 c 0.0 -0.41 0.01 -0.82 0.01 -1.22 c -0.05 -15.75 -3.0 -31.03 -6.01 -45.88 l -17.67 -87.16 l -2.78 -1.0 C 191.87 39.66 170.06 35.66 149.11 35.66 Z")
            )
            addPath(
                stroke = SolidColor(Color.LightGray),
                strokeLineWidth = 4f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("M 150.0 36.0 V 120.0")
            )
            addPath(
                fillAlpha = 0.5f,
                stroke = SolidColor(Color.White),
                strokeAlpha = 0.5f,
                strokeLineWidth = 4f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 150.0 122.0 v -2.0")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 150.0 120.0 v -2.0")
            )
            addPath(
                fillAlpha = 0.1f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.1f,
                strokeLineWidth = 4f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 150.0 38.0 v -2.0")
            )
        }.build()

        return _InputMouse!!
    }

@Suppress("ObjectPropertyName")
private var _InputMouse: ImageVector? = null
