package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val TerminalApp: ImageVector
    get() {
        if (_TerminalApp != null) {
            return _TerminalApp!!
        }
        _TerminalApp = ImageVector.Builder(
            name = "TerminalApp",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 107.92 c -0.0 -35.3 -3.63 -39.09 -38.99 -38.92 l -73.01 0.0 l -73.01 0.0 c -35.37 -0.17 -38.99 3.62 -38.99 38.92 l -0.0 98.16 c -0.0 35.3 3.62 38.92 38.99 38.92 l 73.01 0.0 l 73.01 0.0 c 35.37 0.0 38.99 -3.62 38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 344.0 196.87 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.24 -0.79 -2.01 -0.92 c -0.78 -0.13 -1.67 -0.15 -2.79 -0.14 h -6.12 h -6.13 c -1.12 -0.0 -2.02 0.02 -2.79 0.14 c -0.78 0.13 -1.49 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.23 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.15 2.79 v 8.27 c 0.0 1.12 0.02 2.01 0.15 2.79 c 0.13 0.77 0.39 1.48 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 6.13 h 6.13 c 1.12 0.0 2.02 -0.02 2.79 -0.15 c 0.78 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.77 0.15 -1.67 0.15 -2.79 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.5 241.6 c 0.0 -0.72 -0.01 -1.3 -0.1 -1.84 c -0.09 -0.53 -0.28 -1.07 -0.68 -1.48 c -0.41 -0.41 -0.94 -0.6 -1.48 -0.69 c -0.54 -0.09 -1.12 -0.1 -1.84 -0.1 h -2.89 h -3.9 c -0.72 -0.0 -1.3 0.01 -1.84 0.1 c -0.54 0.09 -1.07 0.28 -1.48 0.69 c -0.41 0.41 -0.59 0.94 -0.68 1.48 c -0.09 0.53 -0.1 1.12 -0.1 1.84 v 5.81 c 0.0 0.72 0.01 1.3 0.1 1.83 c 0.09 0.53 0.28 1.07 0.69 1.47 c 0.41 0.41 0.94 0.59 1.48 0.68 c 0.53 0.09 1.12 0.1 1.84 0.1 h 3.9 h 2.9 c 0.72 0.0 1.3 -0.01 1.84 -0.1 c 0.53 -0.09 1.07 -0.28 1.48 -0.68 c 0.41 -0.41 0.6 -0.94 0.69 -1.47 c 0.09 -0.53 0.1 -1.11 0.1 -1.83 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 351.0 143.19 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.51 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.46 -0.94 -2.41 -1.1 c -0.96 -0.16 -2.09 -0.19 -3.51 -0.18 h -7.79 h -7.8 c -1.42 -0.01 -2.55 0.02 -3.51 0.18 c -0.96 0.16 -1.79 0.48 -2.41 1.1 c -0.62 0.62 -0.93 1.46 -1.09 2.41 c -0.16 0.96 -0.19 2.08 -0.19 3.51 v 11.62 c 0.0 1.42 0.03 2.55 0.19 3.5 c 0.16 0.96 0.47 1.79 1.09 2.41 c 0.62 0.62 1.45 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 7.8 h 7.8 c 1.42 0.0 2.55 -0.03 3.51 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 c 0.16 -0.96 0.19 -2.08 0.19 -3.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 367.5 76.23 c 0.0 -2.22 -0.05 -3.97 -0.29 -5.41 c -0.24 -1.44 -0.7 -2.62 -1.56 -3.48 c -0.86 -0.86 -2.04 -1.32 -3.48 -1.56 c -1.44 -0.24 -3.2 -0.29 -5.42 -0.28 h -12.75 h -12.75 c -2.23 -0.01 -3.98 0.04 -5.42 0.28 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.31 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.19 -0.29 5.41 v 17.54 c 0.0 2.22 0.05 3.97 0.29 5.41 c 0.24 1.44 0.7 2.61 1.56 3.47 c 0.86 0.86 2.04 1.31 3.48 1.55 c 1.44 0.24 3.19 0.29 5.42 0.29 h 12.75 h 12.75 c 2.23 0.0 3.98 -0.05 5.42 -0.29 c 1.44 -0.24 2.62 -0.69 3.48 -1.55 c 0.86 -0.86 1.32 -2.04 1.56 -3.47 c 0.24 -1.44 0.29 -3.19 0.29 -5.41 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 107.92 c -0.0 -35.3 -3.63 -39.09 -38.99 -38.92 l -73.01 0.0 l -73.01 0.0 c -35.37 -0.17 -38.99 3.62 -38.99 38.92 l -0.0 98.16 c -0.0 35.3 3.64 38.0 38.99 38.92 l 73.01 0.0 l 73.01 0.0 c 35.37 0.0 38.99 -3.62 38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.02029f,
                pathData = addPathNodes("m 266.0 105.81 c 0.0 -36.1 -3.69 -39.98 -39.69 -39.81 h -74.31 h -74.31 c -36.0 -0.18 -39.69 3.71 -39.69 39.81 v 100.39 c 0.0 36.1 3.69 39.81 39.69 39.81 h 74.31 h 74.31 c 36.0 0.0 39.69 -3.71 39.69 -39.81 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 366.5 75.23 c 0.0 -8.23 -0.91 -9.77 -9.75 -9.73 h -12.75 h -12.75 c -8.84 -0.04 -9.75 1.5 -9.75 9.73 v 17.54 c 0.0 8.23 0.91 9.73 9.75 9.73 h 12.75 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 205.08 c 0.0 35.3 -3.63 39.09 -38.99 38.92 h -73.01 h -73.01 c -35.37 0.17 -38.99 -3.62 -38.99 -38.92 v -98.16 c 0.0 -35.3 3.63 -38.92 38.99 -38.92 h 73.01 h 73.01 c 35.37 0.0 38.99 3.62 38.99 38.92 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 343.5 195.64 c 0.0 -4.66 -0.47 -5.16 -5.1 -5.14 h -6.4 h -6.4 c -4.62 -0.02 -5.1 0.48 -5.1 5.14 v 8.73 c 0.0 4.66 0.47 5.14 5.1 5.14 h 6.4 h 6.4 c 4.62 0.0 5.1 -0.48 5.1 -5.14 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.5 240.85 c 0.0 -3.04 -0.31 -3.37 -3.32 -3.35 h -4.18 h -4.18 c -3.01 -0.01 -3.32 0.31 -3.32 3.35 v 6.29 c 0.0 3.04 0.31 3.35 3.32 3.35 h 4.18 h 4.18 c 3.01 0.0 3.32 -0.31 3.32 -3.35 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 366.5 75.23 c 0.0 -8.23 -0.91 -9.77 -9.75 -9.73 h -12.75 h -12.75 c -8.84 -0.04 -9.75 1.5 -9.75 9.73 v 17.54 c 0.0 8.23 0.91 9.73 9.75 9.73 h 12.75 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 350.5 142.08 c 0.0 -5.56 -0.58 -6.6 -6.28 -6.57 h -8.22 h -8.22 c -5.7 -0.03 -6.28 1.01 -6.28 6.57 v 11.85 c 0.0 5.56 0.58 6.57 6.28 6.57 h 8.22 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 350.5 142.08 c 0.0 -5.56 -0.58 -6.6 -6.28 -6.57 h -8.22 h -8.22 c -5.7 -0.03 -6.28 1.01 -6.28 6.57 v 11.85 c 0.0 5.56 0.58 6.57 6.28 6.57 h 8.22 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 Z")
            )
            group(
                clipPathData = addPathNodes("m 350.0 142.49 c -0.0 -5.88 -0.58 -6.52 -6.2 -6.49 L 336.0 136.0 L 328.2 136.0 c -5.63 -0.03 -6.2 0.6 -6.2 6.49 l -0.0 11.03 c -0.0 5.88 0.58 6.49 6.2 6.49 L 336.0 160.0 L 343.8 160.0 C 349.42 160.0 350.0 159.4 350.0 153.51 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(336f, 136f),
                        end = Offset(336f, 160f)
                    ),
                    fillAlpha = 0.16f,
                    strokeAlpha = 0.16f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 350.0 142.49 c -0.0 -5.88 -0.58 -6.52 -6.2 -6.49 l -7.8 0.0 l -7.8 0.0 c -5.63 -0.03 -6.2 0.6 -6.2 6.49 l -0.0 11.03 c -0.0 5.88 0.58 6.49 6.2 6.49 l 7.8 0.0 l 7.8 0.0 c 5.63 0.0 6.2 -0.6 6.2 -6.49 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 366.0 75.73 c -0.0 -8.82 -0.91 -9.77 -9.75 -9.73 L 344.0 66.0 L 331.75 66.0 c -8.84 -0.04 -9.75 0.91 -9.75 9.73 l -0.0 16.54 c -0.0 8.82 0.91 9.73 9.75 9.73 L 344.0 102.0 L 356.25 102.0 C 365.09 102.0 366.0 101.09 366.0 92.27 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(344f, 66f),
                        end = Offset(344f, 102f)
                    ),
                    fillAlpha = 0.16f,
                    strokeAlpha = 0.16f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 366.0 75.73 c -0.0 -8.82 -0.91 -9.77 -9.75 -9.73 l -12.25 0.0 l -12.25 0.0 c -8.84 -0.04 -9.75 0.91 -9.75 9.73 l -0.0 16.54 c -0.0 8.82 0.91 9.73 9.75 9.73 l 12.25 0.0 l 12.25 0.0 c 8.84 0.0 9.75 -0.91 9.75 -9.73 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 343.0 195.87 c -0.0 -4.41 -0.45 -4.89 -4.87 -4.87 L 332.0 191.0 L 325.87 191.0 C 321.45 190.98 321.0 191.45 321.0 195.87 l -0.0 8.27 C 321.0 208.55 321.45 209.0 325.87 209.0 L 332.0 209.0 L 338.13 209.0 C 342.55 209.0 343.0 208.55 343.0 204.14 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(332f, 191f),
                        end = Offset(332f, 209f)
                    ),
                    fillAlpha = 0.16f,
                    strokeAlpha = 0.16f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 343.0 195.87 c -0.0 -4.41 -0.45 -4.89 -4.87 -4.87 l -6.13 0.0 l -6.13 0.0 c -4.42 -0.02 -4.87 0.45 -4.87 4.87 l -0.0 8.27 c -0.0 4.41 0.45 4.87 4.87 4.87 l 6.13 0.0 l 6.13 0.0 c 4.42 0.0 4.87 -0.45 4.87 -4.87 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 335.0 241.1 c -0.0 -2.81 -0.29 -3.11 -3.1 -3.1 L 328.0 238.0 l -3.9 0.0 c -2.81 -0.01 -3.1 0.29 -3.1 3.1 l -0.0 5.81 C 321.0 249.71 321.29 250.0 324.1 250.0 L 328.0 250.0 L 331.9 250.0 C 334.71 250.0 335.0 249.71 335.0 246.9 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(328f, 238f),
                        end = Offset(328f, 250f)
                    ),
                    fillAlpha = 0.16f,
                    strokeAlpha = 0.16f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 335.0 241.1 c -0.0 -2.81 -0.29 -3.11 -3.1 -3.1 l -3.9 0.0 l -3.9 0.0 c -2.81 -0.01 -3.1 0.29 -3.1 3.1 l -0.0 5.81 c -0.0 2.81 0.29 3.1 3.1 3.1 l 3.9 0.0 l 3.9 0.0 c 2.81 0.0 3.1 -0.29 3.1 -3.1 Z")
                )
            }
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 78.99 68.0 c -35.37 0.0 -38.99 3.62 -38.99 38.92 v 98.16 c 0.0 0.09 0.0 0.16 0.0 0.25 v -96.41 c 0.0 -35.3 3.63 -38.92 38.99 -38.92 h 73.01 h 73.01 c 35.28 0.0 38.97 3.62 38.99 38.67 v -1.75 c 0.0 -35.3 -3.63 -38.92 -38.99 -38.92 h -73.01 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 203.08 v 2.0 c 0.0 35.3 3.62 39.09 38.99 38.92 h 73.01 h 73.01 c 35.37 0.17 38.99 -3.63 38.99 -38.92 v -2.0 c 0.0 35.3 -3.63 39.09 -38.99 38.92 h -73.01 h -73.01 c -35.37 0.17 -38.99 -3.63 -38.99 -38.92 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.976529f,
                pathData = addPathNodes("m 343.51 195.49 c 0.0 -4.23 -0.46 -5.02 -4.99 -5.0 h -6.52 h -6.52 c -4.52 -0.02 -4.99 0.77 -4.99 5.0 v 9.02 c 0.0 4.23 0.46 5.0 4.99 5.0 h 6.52 h 6.52 c 4.52 0.0 4.99 -0.77 4.99 -5.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.976529f,
                pathData = addPathNodes("m 335.51 240.91 c 0.0 -2.9 -0.3 -3.44 -3.25 -3.42 h -4.26 h -4.26 c -2.95 -0.02 -3.25 0.53 -3.25 3.42 v 6.17 c 0.0 2.9 0.3 3.42 3.25 3.42 h 4.26 h 4.26 c 2.95 0.0 3.25 -0.53 3.25 -3.42 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 148.0 v 57.08 c 0.0 35.3 3.62 39.09 38.99 38.92 h 73.01 h 73.01 c 35.37 0.17 38.99 -3.63 38.99 -38.92 v -57.08 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.Black,
                        1f to Color.Transparent.copy(alpha = 0f)
                    ),
                    start = Offset(152f, 132f),
                    end = Offset(32f, 132f)
                ),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 78.52 94.08 l -2.57 7.72 l 26.06 10.45 l -26.06 10.45 l 2.57 7.72 l 33.53 -14.2 l 0.0 -7.96 Z M 112.0 141.04 l 0.0 7.88 l 39.9 0.0 l 0.0 -7.88 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF2F2F2)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 78.52 93.04 l -2.57 7.72 l 26.06 10.45 l -26.06 10.45 l 2.57 7.72 l 33.53 -14.2 v -7.96 Z M 112.0 140.0 v 8.0 h 40.0 v -8.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 323.28 240.43 l -0.29 0.86 l 2.89 1.16 l -2.89 1.16 l 0.29 0.86 l 3.71 -1.57 v -0.88 Z M 327.0 245.0 v 0.98 h 4.0 v -0.98 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 324.28 195.43 l -0.29 0.86 l 2.89 1.16 l -2.89 1.16 l 0.29 0.86 l 3.71 -1.57 v -0.88 Z M 328.0 200.0 v 0.98 h 4.0 v -0.98 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.69 140.14 l -0.32 0.97 l 3.26 1.31 l -3.26 1.31 l 0.32 0.97 l 4.19 -1.77 v -0.99 Z M 330.0 146.01 v 0.98 h 4.99 v -0.98 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.53 72.19 l -0.48 1.45 l 4.89 1.96 l -4.89 1.96 l 0.48 1.45 l 6.29 -2.66 v -1.49 Z M 335.0 81.0 v 1.48 h 7.48 v -1.48 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 78.52 93.04 l -2.57 7.72 l 0.31 0.12 l 2.26 -6.8 l 33.53 14.2 v -1.04 Z M 100.71 111.74 L 75.95 121.67 L 76.26 122.59 L 102.01 112.26 Z M 112.0 140.0 v 1.04 h 40.0 v -1.04 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF2F2F2)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.69 139.14 l -0.32 0.97 l 3.26 1.31 l -3.26 1.31 l 0.32 0.97 l 4.19 -1.77 v -0.99 Z M 330.0 145.01 v 0.98 h 4.99 v -0.98 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF2F2F2)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.53 71.19 l -0.48 1.45 l 4.89 1.96 l -4.89 1.96 l 0.48 1.45 l 6.29 -2.66 v -1.49 Z M 335.0 80.0 v 1.48 h 7.48 v -1.48 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF2F2F2)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 323.28 239.43 l -0.29 0.86 l 2.89 1.16 l -2.89 1.16 l 0.29 0.86 l 3.71 -1.57 v -0.88 Z M 327.0 244.0 v 0.98 h 4.0 v -0.98 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF2F2F2)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 324.28 194.43 l -0.29 0.86 l 2.89 1.16 l -2.89 1.16 l 0.29 0.86 l 3.71 -1.57 v -0.88 Z M 328.0 199.0 v 0.98 h 4.0 v -0.98 Z")
            )
        }.build()

        return _TerminalApp!!
    }

@Suppress("ObjectPropertyName")
private var _TerminalApp: ImageVector? = null
