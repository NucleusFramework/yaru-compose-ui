package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.unit.dp

val DocumentPageSetup: ImageVector
    get() {
        if (_DocumentPageSetup != null) {
            return _DocumentPageSetup!!
        }
        _DocumentPageSetup = ImageVector.Builder(
            name = "DocumentPageSetup",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.87 189.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 v 6.12 v 6.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.78 0.15 -1.67 0.15 -2.79 v -6.13 v -6.0 l -6.0 -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 330.19 134.0 c -1.42 0.0 -2.55 0.03 -3.51 0.19 c -0.96 0.16 -1.79 0.47 -2.41 1.09 c -0.62 0.62 -0.94 1.46 -1.1 2.41 c -0.16 0.96 -0.19 2.09 -0.18 3.51 v 7.79 v 7.8 c -0.01 1.42 0.02 2.55 0.18 3.51 c 0.16 0.96 0.48 1.79 1.1 2.41 c 0.62 0.62 1.46 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 11.62 c 1.42 0.0 2.55 -0.03 3.5 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 c 0.16 -0.96 0.19 -2.08 0.19 -3.51 v -7.8 v -8.0 l -7.0 -7.0 Z")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 v 6.13 v 6.13 c -0.02 4.42 0.45 4.87 4.87 4.87 h 8.27 c 4.41 0.0 4.87 -0.45 4.87 -4.87 v -6.13 v -6.13 l -4.87 -4.87 Z")
            )
            addPath(
                fillAlpha = 0.6f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.6f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 325.1 237.0 c -2.81 0.0 -3.11 0.29 -3.1 3.1 v 3.9 v 3.9 c -0.01 2.81 0.29 3.1 3.1 3.1 h 5.81 c 2.81 0.0 3.1 -0.29 3.1 -3.1 v -3.9 v -4.0 l -3.0 -3.0 Z")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 330.19 134.0 c -5.62 0.0 -6.22 0.58 -6.19 6.2 v 7.8 v 7.8 c -0.03 5.63 0.58 6.2 6.19 6.2 h 11.61 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 v -7.8 l -6.19 -6.2 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.73 62.0 c -2.22 -0.03 -3.97 0.05 -5.41 0.29 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.32 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.2 -0.28 5.42 v 12.25 v 12.25 c -0.01 2.23 0.04 3.98 0.28 5.42 c 0.24 1.44 0.7 2.62 1.56 3.48 c 0.86 0.86 2.04 1.31 3.48 1.56 c 1.44 0.24 3.19 0.29 5.41 0.29 h 16.54 c 2.22 0.0 3.97 -0.05 5.41 -0.29 c 1.44 -0.24 2.61 -0.7 3.47 -1.56 c 0.86 -0.86 1.31 -2.04 1.55 -3.48 c 0.24 -1.44 0.29 -3.19 0.29 -5.42 v -12.25 v -12.0 l -10.73 -10.75 Z")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 102.92 44.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 v 73.01 v 73.01 c -0.17 35.37 3.62 38.99 38.92 38.99 h 98.16 c 35.3 0.0 38.92 -3.63 38.92 -38.99 v -73.01 v -48.0 l -64.0 -64.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.92 45.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 l 0.0 73.01 l 0.0 73.01 c -0.17 35.37 3.62 38.99 38.92 38.99 l 98.16 0.0 c 35.3 0.0 38.0 -3.64 38.92 -38.99 l 0.0 -73.01 l 0.0 -49.0 l -64.0 -63.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.92 45.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 l 0.0 73.01 l 0.0 73.01 c -0.17 35.37 3.62 38.99 38.92 38.99 l 98.16 0.0 c 35.3 0.0 38.92 -3.62 38.92 -38.99 l 0.0 -73.01 l 0.0 -48.0 l -64.0 -64.0 Z")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 v 12.25 v 12.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 v -12.25 l -0.0 -12.0 l -10.0 -10.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 379.87 191.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 v 4.12 v 6.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 6.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.78 0.15 -1.67 0.15 -2.79 v -6.13 v -4.0 l -6.0 -6.0 Z")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 379.87 191.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 v 4.13 v 6.13 c -0.02 4.42 0.45 4.87 4.87 4.87 h 6.27 c 4.41 0.0 4.87 -0.45 4.87 -4.87 v -6.13 v -4.13 l -4.87 -4.87 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF2F2F2),
                        1f to Color(0xFFF9F9F9)
                    ),
                    start = Offset(389f, 188f),
                    end = Offset(377f, 212f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 379.87 191.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 v 4.13 v 6.13 c -0.02 4.42 0.45 4.87 4.87 4.87 h 6.27 c 4.41 0.0 4.87 -0.45 4.87 -4.87 v -6.13 v -4.0 l -5.0 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 375.0 200.0 v 6.13 c -0.02 4.42 0.45 4.88 4.87 4.88 h 6.27 c 4.41 0.0 4.87 -0.45 4.87 -4.88 v -6.13 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF2F2F2),
                        1f to Color(0xFFF9F9F9)
                    ),
                    start = Offset(356f, 60f),
                    end = Offset(332f, 108f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 v 12.25 v 12.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 v -12.25 l -0.0 -12.0 l -10.0 -10.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF2F2F2),
                        1f to Color(0xFFF9F9F9)
                    ),
                    start = Offset(207.92f, 28f),
                    end = Offset(79.92f, 284f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.84 44.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 v 73.01 v 73.01 c -0.17 35.37 3.62 38.99 38.92 38.99 h 98.16 c 35.3 0.0 38.92 -3.63 38.92 -38.99 v -73.01 v -48.0 l -64.0 -64.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.92 44.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 v 2.0 c -0.17 -35.37 3.63 -38.99 38.92 -38.99 h 73.08 v -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF2F2F2),
                        1f to Color(0xFFF9F9F9)
                    ),
                    start = Offset(338f, 188f),
                    end = Offset(326f, 212f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 v 6.13 v 6.13 c -0.02 4.42 0.45 4.87 4.87 4.87 h 8.27 c 4.41 0.0 4.87 -0.45 4.87 -4.87 v -6.13 v -6.0 l -5.0 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.1 237.0 c -2.81 0.0 -3.11 0.29 -3.1 3.1 v 3.9 v 3.9 c -0.01 2.81 0.29 3.1 3.1 3.1 h 5.81 c 2.81 0.0 3.1 -0.29 3.1 -3.1 v -3.9 v -4.0 l -3.0 -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF2F2F2),
                        1f to Color(0xFFF9F9F9)
                    ),
                    start = Offset(343.09f, 132.73f),
                    end = Offset(327.82f, 163.27f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.19 134.0 c -5.62 0.0 -6.22 0.58 -6.19 6.2 v 7.8 v 7.8 c -0.03 5.63 0.58 6.2 6.19 6.2 h 11.61 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 l 0.0 -8.0 l -6.0 -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 152.0 44.0 v 224.0 h 49.08 c 35.3 0.0 38.0 -3.64 38.92 -38.99 v -73.01 v -48.0 l -64.0 -64.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 64.0 156.0 v 73.01 c -0.17 35.37 3.63 38.99 38.92 38.99 h 98.16 c 35.3 0.0 38.0 -3.64 38.92 -38.99 v -73.01 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 326.0 84.0 v 12.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 v -12.25 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 344.0 62.0 v 44.0 h 8.27 c 8.82 0.0 9.73 -0.91 9.73 -9.75 v -12.25 v -12.0 l -10.0 -10.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 323.0 200.0 v 6.13 c -0.02 4.42 0.45 4.88 4.87 4.88 h 8.27 c 4.41 0.0 4.87 -0.45 4.87 -4.88 v -6.13 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 324.0 148.0 v 7.8 c -0.03 5.63 0.58 6.2 6.19 6.2 h 11.62 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.0 189.0 v 22.0 h 4.13 c 4.41 0.0 4.87 -0.45 4.87 -4.88 v -6.13 v -6.0 l -5.0 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 336.0 134.0 v 28.0 h 5.81 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 v -8.0 l -6.0 -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 383.0 191.0 v 20.0 h 3.13 c 4.41 0.0 4.15 -0.51 4.87 -4.88 v -6.13 v -4.0 l -5.0 -5.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(344f, 62f),
                    end = Offset(344f, 106f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 v 12.25 v 12.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 v -12.25 v -12.0 h -1.0 v 12.0 v 12.25 c 0.0 2.19 -0.06 3.87 -0.27 5.09 c -0.2 1.22 -0.53 1.92 -1.0 2.39 c -0.47 0.47 -1.17 0.8 -2.39 1.0 c -1.21 0.2 -2.89 0.27 -5.08 0.27 h -16.54 c -2.19 0.0 -3.87 -0.06 -5.08 -0.27 c -1.22 -0.2 -1.93 -0.53 -2.4 -1.0 c -0.47 -0.47 -0.8 -1.18 -1.0 -2.39 c -0.2 -1.22 -0.26 -2.89 -0.25 -5.09 v -0.0 v -12.25 v -12.25 v -0.0 c -0.01 -2.19 0.05 -3.87 0.25 -5.09 c 0.2 -1.22 0.53 -1.92 1.0 -2.39 c 0.47 -0.47 1.18 -0.8 2.4 -1.0 c 1.22 -0.2 2.89 -0.27 5.08 -0.27 h 16.27 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(332f, 189f),
                    end = Offset(332f, 211f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.88 v 6.13 v 6.13 c -0.02 4.42 0.45 4.88 4.87 4.88 h 8.27 c 4.41 0.0 4.87 -0.45 4.87 -4.88 v -6.13 v -6.0 l -5.0 -5.0 Z M 327.87 190.0 h 8.13 l 4.0 4.0 v 6.0 v 6.13 c 0.0 1.09 -0.03 1.91 -0.13 2.46 c -0.09 0.55 -0.22 0.79 -0.36 0.93 c -0.14 0.14 -0.37 0.27 -0.92 0.36 c -0.55 0.09 -1.37 0.13 -2.46 0.13 h -8.27 c -1.09 0.0 -1.91 -0.03 -2.46 -0.13 c -0.55 -0.09 -0.79 -0.22 -0.93 -0.36 c -0.14 -0.14 -0.27 -0.37 -0.36 -0.93 c -0.09 -0.55 -0.12 -1.37 -0.12 -2.46 v -0.0 v -6.13 v -6.13 v -0.0 c -0.0 -1.09 0.03 -1.91 0.12 -2.46 c 0.09 -0.55 0.22 -0.79 0.36 -0.93 c 0.14 -0.14 0.38 -0.27 0.93 -0.36 c 0.55 -0.09 1.37 -0.13 2.46 -0.13 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(336f, 134f),
                    end = Offset(336f, 162f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 330.19 134.0 c -5.62 0.0 -6.22 0.58 -6.19 6.2 v 7.8 v 7.8 c -0.03 5.63 0.58 6.2 6.19 6.2 h 11.62 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 v -7.8 l -6.19 -6.2 Z M 330.19 135.0 h 11.62 l 5.19 5.2 v 7.8 v 7.8 c 0.0 1.39 -0.04 2.44 -0.16 3.18 c -0.12 0.73 -0.31 1.1 -0.53 1.33 c -0.23 0.23 -0.59 0.41 -1.32 0.53 c -0.73 0.12 -1.78 0.16 -3.17 0.16 h -11.62 c -1.39 0.0 -2.44 -0.04 -3.18 -0.16 c -0.73 -0.12 -1.1 -0.31 -1.33 -0.54 c -0.23 -0.23 -0.41 -0.59 -0.53 -1.33 c -0.12 -0.73 -0.16 -1.79 -0.15 -3.17 v -0.0 v -7.8 v -7.8 v -0.0 c -0.01 -1.39 0.03 -2.44 0.15 -3.18 c 0.12 -0.73 0.3 -1.1 0.53 -1.32 c 0.23 -0.23 0.6 -0.41 1.33 -0.54 c 0.73 -0.12 1.79 -0.16 3.18 -0.16 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(383f, 189f),
                    end = Offset(383f, 211f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 379.87 191.0 c -4.41 0.0 -4.89 0.45 -4.87 4.88 v 4.13 v 6.13 c -0.02 4.42 0.45 4.88 4.87 4.88 h 6.27 c 4.41 0.0 4.15 -0.51 4.87 -4.88 v -6.13 v -4.0 l -5.0 -5.0 Z M 379.87 192.0 h 6.14 l 4.0 4.0 v 4.0 v 6.13 c 0.0 1.09 -0.03 1.91 -0.13 2.46 c -0.09 0.55 -0.22 0.79 -0.36 0.93 c -0.14 0.14 -0.37 0.27 -0.92 0.36 c -0.55 0.09 -1.37 0.13 -2.46 0.13 h -6.27 c -1.09 0.0 -1.91 -0.03 -2.46 -0.13 c -0.55 -0.09 -0.79 -0.22 -0.93 -0.36 c -0.14 -0.14 -0.27 -0.37 -0.36 -0.93 c -0.09 -0.55 -0.12 -1.37 -0.12 -2.46 v -0.0 v -6.13 v -4.13 v -0.0 c -0.0 -1.09 0.03 -1.91 0.12 -2.46 c 0.09 -0.55 0.22 -0.79 0.36 -0.93 c 0.14 -0.14 0.38 -0.27 0.93 -0.36 c 0.55 -0.09 2.46 -0.13 2.46 -0.13 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 362.0 73.0 v -1.0 l -10.0 -10.0 h -1.0 v 4.21 v 0.16 v 0.09 c 0.0 5.69 0.76 6.57 6.47 6.54 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 362.0 72.0 l -10.0 -10.0 v 3.71 v 0.16 v 0.09 c 0.0 5.69 0.26 6.07 5.97 6.04 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 348.0 141.0 v -1.0 l -6.0 -6.0 h -1.0 v 2.68 v 0.1 v 0.06 c 0.0 3.62 0.48 4.18 4.12 4.16 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 348.0 140.0 l -6.0 -6.0 v 2.23 v 0.1 v 0.05 c 0.0 3.42 0.16 3.64 3.58 3.63 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 341.0 195.0 v -1.0 l -5.0 -5.0 h -1.0 v 2.3 v 0.09 v 0.05 c 0.0 3.1 0.42 3.58 3.53 3.57 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 341.0 194.0 l -5.0 -5.0 v 1.85 v 0.08 v 0.04 c 0.0 2.85 0.13 3.03 2.98 3.02 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 334.0 241.0 v -1.0 l -3.0 -3.0 h -1.0 v 1.53 v 0.06 v 0.03 c 0.0 2.07 0.28 2.39 2.35 2.38 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 334.0 240.0 l -3.0 -3.0 v 1.11 v 0.05 v 0.03 c 0.0 1.71 0.08 1.82 1.79 1.81 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.Black,
                        1f to Color.Transparent.copy(alpha = 0f)
                    ),
                    center = Offset(180f, 104f),
                    radius = 48f
                ),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 240.0 110.0 l -66.0 -66.0 l 0.0 25.0 v 1.0 v 0.54 c 0.0 35.29 3.63 39.63 38.99 39.46 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.15f,
                strokeAlpha = 0.15f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 240.0 110.0 v -2.0 l -64.0 -64.0 h -2.0 v 25.0 v 1.0 v 0.54 c 0.0 34.46 6.0 39.46 38.99 39.46 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 240.0 107.99 l -63.99 -63.99 v 23.0 v 1.0 v 0.54 c 0.0 35.29 3.63 39.63 38.99 39.46 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 391.0 197.0 v -1.0 l -5.0 -5.0 h -1.0 v 2.3 v 0.09 v 0.05 c 0.0 3.1 0.42 3.58 3.53 3.57 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.250023f,
                pathData = addPathNodes("m 391.0 196.0 l -5.0 -5.0 v 1.85 v 0.08 v 0.04 c 0.0 2.85 0.13 3.03 2.98 3.02 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("m 320.0 196.04 v 12.96 h 24.0 v -0.17 Z M 333.0 206.0 L 323.04 205.95 c -0.01 -1.18 -0.04 -5.0 -0.04 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("m 322.0 77.0 v 25.0 h 44.0 v -0.23 Z M 349.0 97.0 h -22.0 l -0.0 -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.92f,
                pathData = addPathNodes("m 51.0 120.1 l 0.0 122.25 l 206.0 0.0 Z M 69.98 153.42 c 39.34 23.32 78.66 46.66 117.98 70.0 c -39.33 0.03 -78.66 0.01 -118.0 0.01 c 0.0 -21.88 -0.01 -43.75 0.01 -65.63 c 0.0 -1.46 0.0 -2.92 0.0 -4.39 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.92f,
                pathData = addPathNodes("m 51.0 120.1 l 0.0 122.25 l 206.0 0.0 Z M 69.98 153.42 c 39.34 23.32 78.66 46.66 117.98 70.0 c -39.33 0.03 -78.66 0.01 -118.0 0.01 c 0.0 -21.88 -0.01 -43.75 0.01 -65.63 c 0.0 -1.46 0.0 -2.92 0.0 -4.39 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFDC92B)),
                strokeLineWidth = 0.92f,
                pathData = addPathNodes("m 51.0 117.75 l 0.0 122.25 l 206.0 0.0 Z M 69.98 151.07 c 39.34 23.32 78.66 46.66 117.98 70.0 c -39.33 0.03 -78.66 0.01 -118.0 0.01 c 0.0 -21.88 -0.01 -43.75 0.01 -65.63 c 0.0 -1.46 0.0 -2.92 0.0 -4.39 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.92f,
                pathData = addPathNodes("m 69.98 148.72 c -0.0 1.46 -0.0 2.92 -0.0 4.39 c -0.0 0.78 0.0 1.57 0.0 2.35 c 0.0 -1.46 0.0 -2.92 0.0 -4.39 c 38.02 22.54 80.2 47.56 118.2 70.12 c 1.32 -0.0 2.64 0.0 3.96 0.0 c -39.32 -23.35 -82.82 -49.15 -122.16 -72.47 Z M 51.0 238.0 L 51.0 240.0 l 206.0 0.0 l -3.96 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.92f,
                pathData = addPathNodes("m 51.0 117.75 l 0.0 2.35 l 202.04 119.9 l 3.96 0.0 Z M 184.0 221.08 c -38.01 0.02 -76.02 0.01 -114.03 0.01 c -0.0 0.78 0.04 1.12 0.04 1.91 c 39.33 -0.0 78.66 0.01 118.0 -0.01 c -1.32 -0.78 -2.68 -1.12 -4.0 -1.91 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63299f,
                pathData = addPathNodes("M 51.0 220.0 h 4.0 v 2.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 212.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63299f,
                pathData = addPathNodes("M 51.0 204.0 h 4.0 v 2.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 196.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63299f,
                pathData = addPathNodes("M 51.0 188.0 h 4.0 v 2.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 180.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63299f,
                pathData = addPathNodes("M 51.0 172.0 h 4.0 v 2.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 164.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63299f,
                pathData = addPathNodes("M 51.0 156.0 h 4.0 v 2.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 148.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63299f,
                pathData = addPathNodes("M 51.0 140.0 h 4.0 v 2.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 228.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 61.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 69.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 77.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 85.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 93.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 101.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 109.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 117.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 125.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 133.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 143.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 151.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 159.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 167.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 175.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 183.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 191.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 199.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 207.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 215.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFDC92B)),
                pathData = addPathNodes("m 322.0 76.0 v 25.0 h 44.0 v -0.23 Z M 349.0 96.0 h -22.0 l -0.0 -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 324.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 327.0 99.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 330.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 333.0 99.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 336.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 339.0 99.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 342.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 345.0 99.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 324.0 84.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 323.0 87.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 324.0 90.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 323.0 93.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 324.0 96.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 323.0 99.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 348.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 351.0 99.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 354.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 357.0 99.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 360.0 100.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("m 320.0 140.06 v 19.95 h 32.0 v -0.23 Z M 339.0 156.0 L 324.05 155.93 c -0.01 -1.57 -0.05 -8.93 -0.05 -8.93 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFDC92B)),
                pathData = addPathNodes("m 320.0 139.05 v 19.95 h 32.0 v -0.23 Z M 339.0 155.0 L 324.05 154.93 c -0.01 -1.57 -0.05 -8.93 -0.05 -8.93 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 322.0 158.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 325.0 157.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 328.0 158.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 331.0 157.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 334.0 158.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 337.0 157.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 340.0 158.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 343.0 157.0 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 322.0 142.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 321.0 145.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 322.0 148.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 321.0 151.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 322.0 154.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 321.0 157.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.707107f,
                pathData = addPathNodes("M 346.0 158.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.71f,
                pathData = addPathNodes("M 323.0 81.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFDC92B)),
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("m 320.0 195.04 v 12.96 h 24.0 v -0.17 Z M 333.0 205.0 L 323.04 204.95 c -0.01 -1.18 -0.04 -5.0 -0.04 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 336.0 205.99 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 322.0 200.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 321.0 202.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 322.0 204.0 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 321.0 206.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 328.0 205.99 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 326.0 206.99 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 324.0 205.99 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 322.0 206.99 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 334.0 206.99 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 332.0 205.99 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 330.0 206.99 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 338.0 206.99 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 321.0 198.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("m 372.0 195.95 v 12.96 h 22.0 v -0.17 Z M 384.25 205.9 L 375.04 205.85 c -0.01 -1.18 -0.04 -4.7 -0.04 -4.7 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFDC92B)),
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("m 372.0 195.0 v 12.96 h 22.0 v -0.17 Z M 384.25 204.96 L 375.04 204.91 c -0.01 -1.18 -0.04 -4.7 -0.04 -4.7 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 388.0 205.95 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 374.0 199.95 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 373.0 201.95 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 374.0 203.95 l -0.0 -1.0 l -2.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 373.0 205.95 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 380.0 205.94 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 378.0 206.94 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 376.0 205.94 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 374.0 206.94 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 386.0 206.95 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.75f,
                pathData = addPathNodes("M 384.0 205.95 h 1.0 v 2.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 382.0 206.95 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 390.0 206.95 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 373.0 197.95 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFDC92B)),
                strokeLineWidth = 0.545455f,
                pathData = addPathNodes("m 320.0 239.5 v 9.52 h 16.0 v -0.13 Z M 329.0 247.0 h -7.0 v -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 320.0 246.0 l 1.0 -0.0 l 0.0 -1.0 l -1.0 -0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 320.0 242.0 l 1.0 -0.0 l 0.0 -1.0 l -1.0 -0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 327.0 248.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 321.0 244.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 322.0 248.0 l -0.0 1.0 l -1.0 0.0 l -0.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53f,
                pathData = addPathNodes("M 321.0 248.0 l -0.0 -1.0 l -1.0 -0.0 l -0.0 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 323.0 248.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 326.0 248.0 l -0.0 1.0 l -1.0 0.0 l -0.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 330.0 248.0 l -0.0 1.0 l -1.0 0.0 l -0.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                pathData = addPathNodes("M 331.0 248.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 0.53033f,
                pathData = addPathNodes("M 334.0 248.0 l -0.0 1.0 l -1.0 0.0 l -0.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF4D4D4D)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 223.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.63f,
                pathData = addPathNodes("M 231.0 240.0 l -0.0 -4.0 l -2.0 -0.0 l -0.0 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.99999f,
                pathData = addPathNodes("M 51.0 132.0 h 6.0 v 2.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 239.0 240.0 l -0.0 -6.0 l -2.0 -0.0 l -0.0 6.0 Z")
            )
        }.build()

        return _DocumentPageSetup!!
    }

@Suppress("ObjectPropertyName")
private var _DocumentPageSetup: ImageVector? = null
