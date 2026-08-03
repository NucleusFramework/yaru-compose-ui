package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val PreferencesDesktopWallpaper: ImageVector
    get() {
        if (_PreferencesDesktopWallpaper != null) {
            return _PreferencesDesktopWallpaper!!
        }
        _PreferencesDesktopWallpaper = ImageVector.Builder(
            name = "PreferencesDesktopWallpaper",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 40.0 222.08 C 40.0 257.37 43.62 261.17 78.99 261.0 L 152.0 261.0 L 225.0 261.0 C 260.37 261.17 264.0 257.37 264.0 222.08 L 264.0 107.92 C 264.0 72.62 260.36 69.97 225.0 69.0 L 152.0 69.0 L 78.99 69.0 C 43.62 69.0 40.0 72.62 40.0 107.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 40.0 107.92 C 40.0 72.63 43.62 68.83 78.99 69.0 L 152.0 69.0 L 225.0 69.0 C 260.37 68.83 264.0 72.63 264.0 107.92 L 264.0 222.08 C 264.0 257.38 260.37 261.0 225.0 261.0 L 152.0 261.0 L 78.99 261.0 C 43.62 261.0 40.0 257.38 40.0 222.08 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFB7C38),
                        1f to Color(0xFF9B33AE)
                    ),
                    start = Offset(280f, 228f),
                    end = Offset(24f, 100f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 68.0 C 43.62 67.83 40.0 72.17 40.0 107.46 L 40.0 108.0 L 40.0 109.0 L 40.0 221.08 C 40.0 256.38 43.62 260.0 78.99 260.0 L 152.0 260.0 L 225.0 260.0 C 260.37 260.0 264.0 256.38 264.0 221.08 L 264.0 109.0 L 264.0 108.0 L 264.0 107.46 C 264.0 72.17 260.37 67.83 225.0 68.0 L 152.0 68.0 L 78.99 68.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 219.08 v 2.0 c 0.0 35.3 3.62 38.92 38.99 38.92 h 73.01 h 73.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 v -2.0 c 0.0 35.3 -3.63 38.92 -38.99 38.92 H 152.0 H 78.99 c -35.37 0.0 -38.99 -3.62 -38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 74.81 68.0 C 43.24 67.83 40.0 72.17 40.0 107.46 V 108.0 v 1.0 v 112.08 c 0.0 35.3 3.24 38.92 34.81 38.92 H 90.0 V 68.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 200.0 68.0 l 63.99 63.99 V 109.0 v -1.0 v -0.54 c 0.0 -35.29 -3.63 -39.63 -38.99 -39.46 Z")
            )
            addPath(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color.Black,
                        1f to Color.Transparent.copy(alpha = 0f)
                    ),
                    center = Offset(200f, 132f),
                    radius = 32f
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 264.0 131.99 L 200.0 68.0 v 23.0 v 1.0 v 0.54 c 0.0 35.29 3.63 39.63 38.99 39.46 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 264.0 131.99 L 200.0 68.0 v 23.0 v 1.0 v 0.54 c 0.0 35.29 3.63 39.63 38.99 39.46 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 325.6 190.5 c -1.97 -0.01 -3.18 0.08 -3.93 0.54 c -0.12 0.14 -0.22 0.29 -0.32 0.46 c -0.19 0.33 -0.35 0.72 -0.46 1.16 c -0.06 0.22 -0.11 0.46 -0.15 0.71 c -0.04 0.25 -0.08 0.52 -0.11 0.8 c -0.0 0.02 -0.0 0.05 -0.01 0.07 c -0.03 0.26 -0.05 0.54 -0.06 0.83 c -0.04 0.66 -0.05 1.38 -0.05 2.19 v 5.45 c 0.0 0.82 0.02 1.55 0.05 2.21 c 0.02 0.3 0.04 0.59 0.07 0.86 c 0.03 0.28 0.06 0.55 0.11 0.8 c 0.0 0.0 0.0 0.01 0.0 0.02 c 0.04 0.25 0.09 0.48 0.15 0.7 c 0.0 0.0 0.0 0.01 0.0 0.01 c 0.06 0.22 0.13 0.43 0.2 0.62 c 0.07 0.19 0.16 0.36 0.25 0.53 c 0.0 0.01 0.01 0.01 0.01 0.02 c 0.09 0.16 0.2 0.31 0.31 0.45 c 0.75 0.46 1.96 0.55 3.94 0.55 h 6.4 v -19.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 323.82 237.5 c -1.76 -0.01 -2.59 0.12 -2.98 0.82 c -0.27 0.77 -0.35 1.85 -0.35 3.37 v 3.63 c 0.0 4.54 0.65 5.18 5.19 5.18 h 2.31 v -13.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 344.0 196.87 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.24 -0.79 -2.01 -0.92 c -0.78 -0.13 -1.67 -0.15 -2.79 -0.14 H 332.0 H 325.88 c -1.12 -0.0 -2.02 0.02 -2.79 0.14 c -0.78 0.13 -1.49 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.23 -0.92 2.01 C 320.02 194.85 320.0 195.75 320.0 196.87 v 8.27 c 0.0 1.12 0.02 2.01 0.15 2.79 c 0.13 0.77 0.39 1.48 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 6.13 h 6.13 c 1.12 0.0 2.02 -0.02 2.79 -0.15 c 0.78 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.77 0.15 -1.67 0.15 -2.79 Z")
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
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFB7C38),
                        1f to Color(0xFF9B33AE)
                    ),
                    start = Offset(367.21f, 99.18f),
                    end = Offset(320.79f, 70.82f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 321.5 75.23 c 0.0 -8.23 0.91 -9.77 9.75 -9.73 h 12.75 h 12.75 c 8.84 -0.04 9.75 1.5 9.75 9.73 v 17.54 c 0.0 8.23 -0.91 9.73 -9.75 9.73 h -12.75 h -12.75 c -8.84 0.0 -9.75 -1.5 -9.75 -9.73 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFB7C38),
                        1f to Color(0xFF9B33AE)
                    ),
                    start = Offset(343f, 204.13f),
                    end = Offset(320.55f, 195.08f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 195.64 c 0.0 -4.66 0.47 -5.16 5.1 -5.14 h 6.4 h 6.4 c 4.62 -0.02 5.1 0.48 5.1 5.14 v 8.73 c 0.0 4.66 -0.47 5.14 -5.1 5.14 h -6.4 h -6.4 c -4.62 0.0 -5.1 -0.48 -5.1 -5.14 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFB7C38),
                        1f to Color(0xFF9B33AE)
                    ),
                    start = Offset(335.51f, 247.09f),
                    end = Offset(320.5f, 240.85f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 240.85 c 0.0 -3.04 0.31 -3.37 3.32 -3.35 h 4.18 h 4.18 c 3.01 -0.01 3.32 0.31 3.32 3.35 v 6.29 c 0.0 3.04 -0.31 3.35 -3.32 3.35 h -4.18 h -4.18 c -3.01 0.0 -3.32 -0.31 -3.32 -3.35 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFB7C38),
                        1f to Color(0xFF9B33AE)
                    ),
                    start = Offset(350.5f, 153.92f),
                    end = Offset(322f, 142.49f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 321.5 153.92 c 0.0 5.56 0.58 6.6 6.28 6.57 h 8.22 h 8.22 c 5.7 0.03 6.28 -1.01 6.28 -6.57 v -11.85 c 0.0 -5.56 -0.58 -6.57 -6.28 -6.57 h -8.22 h -8.22 c -5.7 0.0 -6.28 1.01 -6.28 6.57 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 330.67 65.0 c -1.97 0.0 -3.54 0.05 -4.83 0.29 c -1.31 0.24 -2.38 0.69 -3.16 1.55 c -0.78 0.86 -1.2 2.04 -1.42 3.47 c -0.08 0.51 -0.13 1.08 -0.17 1.68 C 321.03 73.08 321.0 74.3 321.0 75.73 v 16.54 c 0.0 2.22 0.05 3.97 0.27 5.41 c 0.22 1.44 0.63 2.62 1.42 3.48 c 0.78 0.86 1.85 1.32 3.16 1.56 c 1.31 0.24 2.9 0.29 4.93 0.28 H 331.0 V 65.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.37 135.5 c -1.2 0.0 -2.15 0.03 -2.93 0.18 c -0.79 0.15 -1.44 0.43 -1.92 0.97 c -0.48 0.54 -0.73 1.27 -0.86 2.17 c -0.05 0.32 -0.08 0.68 -0.1 1.05 c -0.04 0.68 -0.06 1.44 -0.06 2.33 v 11.59 c 0.0 1.39 0.03 2.48 0.16 3.38 c 0.13 0.9 0.38 1.64 0.86 2.18 c 0.48 0.54 1.12 0.82 1.92 0.97 c 0.79 0.15 1.76 0.18 2.99 0.17 l 0.57 0.0 V 135.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 325.47 190.5 c -1.01 0.0 -1.82 0.02 -2.48 0.14 c -0.67 0.11 -1.22 0.33 -1.62 0.74 c -0.4 0.41 -0.61 0.97 -0.73 1.65 c -0.04 0.24 -0.07 0.51 -0.09 0.8 c -0.04 0.51 -0.05 1.09 -0.05 1.77 v 8.81 c 0.0 1.06 0.02 1.89 0.14 2.57 c 0.11 0.68 0.32 1.24 0.73 1.65 c 0.4 0.41 0.95 0.63 1.62 0.74 c 0.67 0.11 1.49 0.14 2.53 0.13 l 0.48 0.0 V 190.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 323.66 237.5 c -0.64 0.0 -1.16 0.02 -1.58 0.09 c -0.43 0.08 -0.78 0.23 -1.03 0.51 c -0.26 0.28 -0.39 0.66 -0.46 1.13 c -0.03 0.17 -0.04 0.35 -0.06 0.55 c -0.02 0.35 -0.03 0.75 -0.03 1.21 v 6.03 c 0.0 0.72 0.02 1.29 0.09 1.76 c 0.07 0.47 0.21 0.85 0.46 1.13 c 0.26 0.28 0.61 0.43 1.03 0.51 c 0.43 0.08 0.95 0.09 1.61 0.09 l 0.31 0.0 V 237.5 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 0.2500229f,
                pathData = addPathNodes("m 350.5 65.5 l 16.0 16.0 v -5.27 c 0.0 -1.43 -0.03 -2.65 -0.11 -3.73 c -0.04 -0.6 -0.1 -1.17 -0.19 -1.68 c -0.24 -1.44 -0.69 -2.61 -1.56 -3.47 c -0.86 -0.86 -2.04 -1.31 -3.48 -1.55 c -1.43 -0.24 -2.96 -0.29 -5.42 -0.29 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.2500229f,
                pathData = addPathNodes("m 349.5 66.0 l 0.5 0.5 l 0.0 5.75 v 0.25 v 0.13 c 0.0 8.82 0.41 9.41 9.25 9.37 h 6.25 l 0.5 0.5 V 82.0 V 77.23 c 0.0 -1.43 -0.03 -2.65 -0.11 -3.73 c -0.04 -0.6 -0.1 -1.17 -0.19 -1.68 c -0.24 -1.44 -0.69 -3.11 -1.56 -3.97 c -0.86 -0.86 -2.54 -1.31 -3.98 -1.55 c -1.43 -0.24 -2.96 -0.29 -5.42 -0.29 h -4.75 h -0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.2500229f,
                pathData = addPathNodes("M 366.5 81.0 L 351.0 65.5 v 5.75 v 0.25 v 0.13 c 0.0 8.82 0.41 9.41 9.25 9.37 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("M 337.88 136.0 L 337.88 140.81 L 337.88 141.0 L 337.88 141.1 C 337.88 147.72 338.18 148.16 344.81 148.13 L 350.0 148.13 L 350.0 137.57 C 349.7 136.82 349.22 136.31 348.45 136.0 L 337.88 136.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("M 338.5 135.5 L 350.5 147.5 L 350.5 142.07 C 350.5 137.59 350.12 136.07 346.99 135.64 C 346.79 135.7 346.62 135.74 346.5 135.72 C 345.43 135.54 344.28 135.5 342.44 135.5 L 338.5 135.5 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("m 350.5 147.13 l -11.63 -11.63 v 4.31 v 0.19 v 0.1 c 0.0 6.62 0.3 7.06 6.94 7.03 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("m 338.5 135.5 l 12.0 12.0 v -5.43 c 0.0 -4.48 -0.38 -6.01 -3.51 -6.43 c -0.2 0.06 -0.37 0.1 -0.49 0.08 c -1.07 -0.18 -2.22 -0.22 -4.06 -0.22 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("m 334.5 190.5 l 9.0 9.0 v -3.13 c 0.0 -4.48 0.12 -5.31 -3.01 -5.73 c -1.55 -0.08 -1.05 -0.14 -1.05 -0.14 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 8.00126f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.34 190.5 C 334.53 191.04 334.0 191.95 334.0 193.0 L 334.0 197.0 C 334.0 198.66 335.34 200.0 337.0 200.0 L 341.0 200.0 C 342.05 200.0 342.96 199.47 343.5 198.66 L 343.5 195.63 C 343.5 190.98 343.03 190.48 338.4 190.5 L 335.34 190.5 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("m 343.0 199.0 l -8.0 -8.0 v 2.13 c 0.0 4.48 -0.12 5.31 3.01 5.73 c 1.55 0.08 1.05 0.14 1.05 0.14 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.0 237.5 v 5.5 c 0.0 1.66 1.34 3.0 3.0 3.0 h 5.5 v -5.15 c 0.0 -3.04 -0.31 -3.37 -3.32 -3.35 H 328.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("M 335.5 244.96 L 328.0 237.5 v 1.13 c 0.0 5.36 0.52 6.18 2.76 6.34 c 1.55 0.08 1.8 -0.0 1.8 -0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 0.18751717f,
                pathData = addPathNodes("m 328.0 237.5 l 7.5 7.5 v -1.63 c 0.0 -5.36 -0.02 -5.72 -2.27 -5.88 c -1.55 -0.08 -1.8 0.0 -1.8 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 68.0 C 43.62 67.83 40.0 71.63 40.0 106.92 L 40.0 108.92 C 40.0 73.63 43.62 69.83 78.99 70.0 L 152.0 70.0 L 225.0 70.0 C 260.37 69.83 264.0 73.63 264.0 108.92 L 264.0 106.92 C 264.0 71.63 260.37 67.83 225.0 68.0 L 152.0 68.0 L 78.99 68.0 Z")
            )
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
                    fillAlpha = 0.5f,
                    strokeAlpha = 0.5f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 366.0 75.73 c -0.0 -8.82 -0.91 -9.77 -9.75 -9.73 L 344.0 66.0 L 331.75 66.0 c -8.84 -0.04 -9.75 0.91 -9.75 9.73 l -0.0 16.54 c -0.0 8.82 0.91 9.73 9.75 9.73 L 344.0 102.0 L 356.25 102.0 C 365.09 102.0 366.0 101.09 366.0 92.27 Z")
                )
            }
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 366.5 75.23 c 0.0 -8.23 -0.91 -9.77 -9.75 -9.73 h -12.75 h -12.75 c -8.84 -0.04 -9.75 1.5 -9.75 9.73 v 17.54 c 0.0 8.23 0.91 9.73 9.75 9.73 h 12.75 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 350.5 142.07 c 0.0 -5.56 -0.58 -6.6 -6.28 -6.57 h -8.22 h -8.22 c -5.7 -0.03 -6.28 1.01 -6.28 6.57 v 11.85 c 0.0 5.56 0.58 6.57 6.28 6.57 h 8.22 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9765289f,
                pathData = addPathNodes("m 343.51 195.49 c 0.0 -4.23 -0.46 -5.02 -4.99 -5.0 h -6.52 h -6.52 c -4.52 -0.02 -4.99 0.77 -4.99 5.0 v 9.02 c 0.0 4.23 0.46 5.0 4.99 5.0 h 6.52 h 6.52 c 4.52 0.0 4.99 -0.77 4.99 -5.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9765289f,
                pathData = addPathNodes("m 335.51 240.91 c 0.0 -2.9 -0.3 -3.44 -3.25 -3.42 h -4.26 h -4.26 c -2.95 -0.02 -3.25 0.53 -3.25 3.42 v 6.17 c 0.0 2.9 0.3 3.42 3.25 3.42 h 4.26 h 4.26 c 2.95 0.0 3.25 -0.53 3.25 -3.42 Z")
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
                    fillAlpha = 0.5f,
                    strokeAlpha = 0.5f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 350.0 142.49 c -0.0 -5.88 -0.58 -6.52 -6.2 -6.49 L 336.0 136.0 L 328.2 136.0 c -5.63 -0.03 -6.2 0.6 -6.2 6.49 l -0.0 11.03 c -0.0 5.88 0.58 6.49 6.2 6.49 L 336.0 160.0 L 343.8 160.0 C 349.42 160.0 350.0 159.4 350.0 153.51 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 343.0 195.87 c -0.0 -4.41 -0.45 -4.89 -4.87 -4.87 L 332.0 191.0 L 325.87 191.0 C 321.45 190.98 321.0 191.45 321.0 195.87 l -0.0 8.27 C 321.0 208.55 321.45 209.0 325.87 209.0 L 332.0 209.0 L 338.13 209.0 C 342.55 209.0 343.0 208.55 343.0 204.13 Z")
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
                    fillAlpha = 0.5f,
                    strokeAlpha = 0.5f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 343.0 195.87 c -0.0 -4.41 -0.45 -4.89 -4.87 -4.87 L 332.0 191.0 L 325.87 191.0 C 321.45 190.98 321.0 191.45 321.0 195.87 l -0.0 8.27 C 321.0 208.55 321.45 209.0 325.87 209.0 L 332.0 209.0 L 338.13 209.0 C 342.55 209.0 343.0 208.55 343.0 204.13 Z")
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
                    fillAlpha = 0.5f,
                    strokeAlpha = 0.5f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 335.0 241.1 c -0.0 -2.81 -0.29 -3.11 -3.1 -3.1 L 328.0 238.0 l -3.9 0.0 c -2.81 -0.01 -3.1 0.29 -3.1 3.1 l -0.0 5.81 C 321.0 249.71 321.29 250.0 324.1 250.0 L 328.0 250.0 L 331.9 250.0 C 334.71 250.0 335.0 249.71 335.0 246.9 Z")
                )
            }
        }.build()

        return _PreferencesDesktopWallpaper!!
    }

@Suppress("ObjectPropertyName")
private var _PreferencesDesktopWallpaper: ImageVector? = null
