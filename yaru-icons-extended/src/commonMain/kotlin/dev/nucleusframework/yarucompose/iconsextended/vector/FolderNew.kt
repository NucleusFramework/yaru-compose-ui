package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val FolderNew: ImageVector
    get() {
        if (_FolderNew != null) {
            return _FolderNew!!
        }
        _FolderNew = ImageVector.Builder(
            name = "FolderNew",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.0 249.0 v -10.0 c 0.0 -1.0 1.0 -2.0 2.0 -2.0 h 4.0 c 1.0 0.0 1.0 0.0 2.0 1.0 c 1.0 1.0 1.0 1.0 2.0 1.0 h 4.0 c 1.0 0.0 2.0 1.0 2.0 2.0 v 8.0 c 0.0 1.0 -1.0 2.0 -2.0 2.0 h -12.0 c -1.0 0.0 -2.0 -1.0 -2.0 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 0.866025f,
                pathData = addPathNodes("m 321.0 248.0 v -8.0 c 0.0 -1.5 0.5 -2.0 2.0 -2.0 h 2.75 c 0.88 0.0 0.88 0.29 1.75 1.14 C 328.38 240.0 328.38 240.0 329.25 240.0 H 333.0 c 1.5 0.0 2.0 0.5 2.0 2.0 v 6.0 c 0.0 1.5 -0.5 2.0 -2.0 2.0 h -10.0 c -1.5 0.0 -2.0 -0.5 -2.0 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 52.0 C 43.63 52.0 40.0 54.0 40.0 89.3 v 41.63 v 9.08 v 81.08 c 0.0 35.3 3.63 38.92 38.99 38.92 H 225.01 C 260.37 260.0 264.0 256.38 264.0 221.08 v -81.08 v -25.08 v -6.0 C 264.0 73.62 260.37 68.0 225.01 68.0 H 138.0 l -16.0 -16.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.03 135.0 c -1.53 0.0 -2.7 0.06 -3.67 0.25 c -0.97 0.2 -1.78 0.57 -2.34 1.22 c -0.56 0.65 -0.79 1.47 -0.9 2.36 c -0.11 0.89 -0.11 1.91 -0.12 3.16 v 0.0 v 0.0 v 14.0 v 0.0 v 0.0 c 0.02 2.49 -0.08 4.16 0.84 5.45 c 0.48 0.66 1.21 1.07 2.06 1.28 c 0.85 0.21 1.85 0.26 3.13 0.26 H 344.03 c 1.53 0.0 2.7 -0.06 3.67 -0.25 c 0.97 -0.2 1.78 -0.56 2.34 -1.22 c 0.56 -0.65 0.79 -1.47 0.89 -2.36 c 0.1 -0.89 0.1 -1.91 0.1 -3.16 v -12.0 c 0.0 -1.25 0.0 -2.27 -0.1 -3.16 c -0.1 -0.89 -0.33 -1.71 -0.89 -2.36 c -0.56 -0.65 -1.37 -1.02 -2.34 -1.22 c -0.97 -0.2 -2.14 -0.25 -3.67 -0.25 h -8.61 l -2.14 -2.0 h -0.39 c -2.06 -0.0 -3.91 -0.0 -4.36 0.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2C001E),
                        0.11f to Color(0xFF2C001E),
                        0.19f to Color(0xFF370626),
                        0.3f to Color(0xFF55163B),
                        0.37f to Color(0xFF772953),
                        0.45f to Color(0xFF7C2B51),
                        0.52f to Color(0xFF8B314B),
                        0.6f to Color(0xFF8B314B),
                        0.67f to Color(0xFFA33A41),
                        0.8f to Color(0xFFC44732),
                        0.91f to Color(0xFFE65524),
                        1f to Color(0xFFE65524)
                    ),
                    start = Offset(320f, 164f),
                    end = Offset(352f, 134f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.03 134.5 c -1.51 0.0 -2.66 0.06 -3.57 0.24 c -0.91 0.18 -1.6 0.51 -2.06 1.05 c -0.47 0.54 -0.68 1.25 -0.78 2.09 c -0.1 0.84 -0.11 1.85 -0.12 3.1 v 0.0 v 14.0 v 0.0 c 0.02 2.5 -0.04 4.07 0.75 5.16 c 0.39 0.55 1.0 0.9 1.78 1.09 c 0.78 0.19 1.74 0.25 3.01 0.25 h 17.0 c 1.51 0.0 2.66 -0.06 3.57 -0.24 c 0.91 -0.18 1.59 -0.51 2.06 -1.05 c 0.47 -0.54 0.67 -1.25 0.77 -2.1 c 0.1 -0.85 0.1 -1.86 0.1 -3.11 v -12.0 c 0.0 -1.25 0.0 -2.26 -0.1 -3.11 c -0.1 -0.85 -0.31 -1.55 -0.77 -2.1 c -0.47 -0.54 -1.15 -0.87 -2.06 -1.05 c -0.91 -0.18 -2.05 -0.24 -3.57 -0.24 h -8.8 l -2.14 -2.0 h -0.2 c -2.3 -0.0 -4.86 0.0 -4.86 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 54.0 C 43.63 54.0 40.0 56.0 40.0 91.3 v 41.63 v 9.08 v 73.08 c 0.0 35.3 3.63 38.92 38.99 38.92 H 225.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 v -73.08 v -25.08 v -6.0 C 264.0 75.62 260.37 70.0 225.01 70.0 H 138.0 l -16.0 -16.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 329.81 64.0 c -2.9 0.0 -5.05 -0.09 -6.66 1.12 c -0.81 0.62 -1.35 1.54 -1.66 2.72 c -0.31 1.17 -0.43 2.61 -0.43 4.49 v 9.41 v 3.27 v 12.27 c 0.0 1.95 0.05 3.44 0.27 4.64 c 0.22 1.21 0.62 2.18 1.39 2.87 c 0.76 0.68 1.75 0.96 2.89 1.09 c 1.14 0.13 2.5 0.13 4.2 0.13 h 28.5 c 1.67 0.0 3.01 0.0 4.14 -0.13 v 0.0 c 1.14 -0.13 2.13 -0.41 2.89 -1.09 c 0.77 -0.68 1.19 -1.65 1.42 -2.86 c 0.23 -1.21 0.29 -2.7 0.29 -4.65 v -18.54 c 0.0 -0.26 -0.01 -0.43 -0.01 -0.61 v -0.01 l 0.01 -1.88 c 0.01 -1.81 0.02 -3.25 -0.12 -4.46 c -0.13 -1.2 -0.42 -2.23 -1.1 -3.03 c -0.68 -0.8 -1.67 -1.24 -2.89 -1.47 c -1.21 -0.23 -2.7 -0.29 -4.65 -0.29 h -15.9 l -3.0 -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2C001E),
                        0.11f to Color(0xFF2C001E),
                        0.19f to Color(0xFF370626),
                        0.3f to Color(0xFF55163B),
                        0.37f to Color(0xFF772953),
                        0.45f to Color(0xFF7C2B51),
                        0.52f to Color(0xFF8B314B),
                        0.6f to Color(0xFF8B314B),
                        0.67f to Color(0xFFA33A41),
                        0.8f to Color(0xFFC44732),
                        0.91f to Color(0xFFE65524),
                        1f to Color(0xFFE65524)
                    ),
                    start = Offset(321f, 106f),
                    end = Offset(367f, 63f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 329.81 63.0 c -2.9 0.0 -5.05 -0.09 -6.66 1.12 c -0.81 0.62 -1.35 1.54 -1.66 2.72 c -0.31 1.17 -0.43 2.61 -0.43 4.49 v 8.68 h 46.0 v -2.27 c 0.0 -0.26 -0.01 -0.43 -0.01 -0.61 v -0.01 l 0.01 -1.88 c 0.01 -1.81 0.02 -3.25 -0.12 -4.46 c -0.13 -1.2 -0.42 -2.23 -1.1 -3.03 c -0.68 -0.8 -1.67 -1.24 -2.89 -1.47 c -1.21 -0.23 -2.7 -0.29 -4.65 -0.29 h -15.9 l -3.0 -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 53.0 C 43.63 53.0 40.0 55.0 40.0 90.3 v 41.63 v 60.66 v 29.5 c 0.0 35.3 3.63 38.92 38.99 38.92 H 225.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 v -29.5 v -76.66 v -6.0 C 264.0 74.62 260.37 69.0 225.01 69.0 H 138.0 l -16.0 -16.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2C001E),
                        0.11f to Color(0xFF2C001E),
                        0.19f to Color(0xFF370626),
                        0.3f to Color(0xFF55163B),
                        0.37f to Color(0xFF772953),
                        0.45f to Color(0xFF7C2B51),
                        0.52f to Color(0xFF8B314B),
                        0.6f to Color(0xFF8B314B),
                        0.67f to Color(0xFFA33A41),
                        0.8f to Color(0xFFC44732),
                        0.91f to Color(0xFFE65524),
                        1f to Color(0xFFE65524)
                    ),
                    start = Offset(40f, 260f),
                    end = Offset(264f, 52f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 52.0 C 43.63 52.0 40.0 54.0 40.0 89.3 V 140.0 H 264.0 V 108.92 C 264.0 73.62 260.37 68.0 225.01 68.0 H 138.0 l -16.0 -16.0 Z")
            )
            group(
                clipPathData = addPathNodes("M 78.99 60.0 C 43.63 60.0 40.0 62.0 40.0 97.3 L 40.0 148.0 L 264.0 148.0 L 264.0 116.92 C 264.0 81.62 260.37 76.0 225.01 76.0 L 138.0 76.0 L 122.0 60.0 Z")
            ) {
                addPath(
                    fill = SolidColor(Color(0xFF903906)),
                    fillAlpha = 0.5f,
                    strokeAlpha = 0.5f,
                    strokeLineWidth = 1f,
                    pathData = addPathNodes("M 78.99 100.0 C 43.63 100.0 40.0 103.63 40.0 138.92 v 82.15 C 40.0 256.38 43.63 260.0 78.99 260.0 L 225.01 260.0 C 260.38 260.0 264.0 256.38 264.0 221.08 L 264.0 122.92 C 264.0 87.63 260.38 84.0 225.01 84.0 L 143.75 84.0 l -16.01 16.0 Z")
                )
            }
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF666666),
                        1f to Color(0xFF7A7A7A)
                    ),
                    start = Offset(40f, 84f),
                    end = Offset(264f, 260f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 100.0 C 43.63 100.0 40.0 103.63 40.0 138.92 v 82.15 c 0.0 35.3 3.63 38.92 38.99 38.92 H 225.01 c 35.37 0.0 38.99 -3.63 38.99 -38.92 V 122.92 C 264.0 87.63 260.38 84.0 225.01 84.0 H 143.75 l -16.01 16.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 78.99 52.0 C 43.63 52.0 40.0 54.0 40.0 89.3 v 2.0 c 0.0 -35.3 3.63 -37.3 38.99 -37.3 H 122.0 l 16.0 16.0 h 87.01 c 35.37 0.0 38.99 5.62 38.99 40.92 v -2.0 C 264.0 73.62 260.37 68.0 225.01 68.0 H 138.0 l -16.0 -16.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 143.75 84.0 L 127.74 100.0 H 78.99 C 43.63 100.0 40.0 103.62 40.0 138.92 v 2.0 c 0.0 -35.3 3.63 -38.92 38.99 -38.92 h 48.75 L 143.75 86.0 h 81.26 c 35.37 0.0 38.99 3.62 38.99 38.92 v -2.0 c 0.0 -35.3 -3.63 -38.92 -38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 194.0 l -64.0 64.0 h 25.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 343.0 70.0 l -3.0 3.0 h -10.19 c -6.81 0.0 -7.75 -0.0 -7.75 7.73 v 1.0 c 0.0 -7.73 0.94 -7.73 7.75 -7.73 H 340.0 l 3.0 -3.0 h 15.31 c 6.68 0.0 7.75 -0.0 7.75 7.73 v -1.0 c 0.0 -7.73 -1.06 -7.73 -7.75 -7.73 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF491706)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 219.08 v 2.0 c 0.0 35.3 3.63 38.92 38.99 38.92 H 225.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 v -2.0 c 0.0 35.3 -3.63 38.92 -38.99 38.92 H 78.99 C 43.63 258.0 40.0 254.38 40.0 219.08 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF666666),
                        1f to Color(0xFF7A7A7A)
                    ),
                    start = Offset(321f, 139f),
                    end = Offset(352f, 163f)
                ),
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 335.14 139.0 l -2.14 2.0 h -5.5 c -5.97 0.0 -6.0 1.0 -6.0 5.93 v 0.07 c 0.0 2.46 0.02 3.91 0.01 6.36 c -0.0 0.01 -0.0 0.02 0.0 0.03 c 0.05 1.76 -0.1 3.64 0.21 5.57 c 0.0 0.01 0.01 0.02 0.01 0.03 c 0.27 1.34 1.43 2.19 2.66 2.35 c 1.81 0.27 3.56 0.11 5.18 0.16 c 0.01 0.0 0.02 0.0 0.03 0.0 c 6.49 -0.01 11.01 0.02 17.51 -0.13 c 0.04 -0.0 0.07 -0.0 0.11 -0.01 c 0.57 -0.09 1.21 -0.26 1.78 -0.62 c 0.58 -0.36 1.11 -0.95 1.28 -1.75 c 0.0 -0.02 0.01 -0.04 0.01 -0.06 c 0.3 -2.28 0.15 -4.52 0.2 -6.66 c 0.0 -0.01 0.0 -0.01 0.0 -0.02 c -0.01 -3.5 0.02 -6.01 -0.03 -9.54 c -0.18 -3.0 -1.05 -3.71 -5.97 -3.71 c 0.0 0.0 -7.06 -0.0 -9.36 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 335.14 139.0 l -2.14 2.0 H 327.5 c -6.0 0.0 -6.0 1.0 -6.0 6.0 v 1.0 c 0.0 -5.0 0.0 -6.0 6.0 -6.0 h 5.5 l 2.14 -2.0 c 2.3 -0.0 9.36 0.0 9.36 0.0 c 6.0 0.0 6.0 1.0 6.03 6.0 v -1.0 c -0.03 -5.0 -0.03 -6.0 -6.03 -6.0 c 0.0 0.0 -7.06 -0.0 -9.36 0.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.03 134.5 c -1.51 0.0 -2.66 0.06 -3.57 0.24 c -0.91 0.18 -1.6 0.51 -2.06 1.05 c -0.47 0.54 -0.68 1.25 -0.78 2.09 c -0.1 0.84 -0.11 1.85 -0.12 3.1 v 0.0 v 14.0 v 0.0 c 0.02 2.5 -0.04 4.07 0.75 5.16 c 0.39 0.55 1.0 0.9 1.78 1.09 c 0.78 0.19 1.74 0.25 3.01 0.25 h 17.0 c 1.51 0.0 2.66 -0.06 3.57 -0.24 c 0.91 -0.18 1.59 -0.51 2.06 -1.05 c 0.47 -0.54 0.67 -1.25 0.77 -2.1 c 0.1 -0.85 0.1 -1.86 0.1 -3.11 v -12.0 c 0.0 -1.25 0.0 -2.26 -0.1 -3.11 c -0.1 -0.85 -0.31 -1.55 -0.77 -2.1 c -0.47 -0.54 -1.15 -0.87 -2.06 -1.05 c -0.91 -0.18 -2.05 -0.24 -3.57 -0.24 h -8.8 l -2.14 -2.0 h -0.2 c -2.3 -0.0 -4.86 0.0 -4.86 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF491706)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 335.14 138.0 l -2.14 2.0 H 327.5 c -6.0 0.0 -6.0 1.0 -6.0 6.0 v 1.0 c 0.0 -5.0 0.0 -6.0 6.0 -6.0 h 5.5 l 2.14 -2.0 c 2.3 -0.0 9.36 0.0 9.36 0.0 c 6.0 0.0 6.0 1.0 6.03 6.0 v -1.0 c -0.03 -5.0 -0.03 -6.0 -6.03 -6.0 c 0.0 0.0 -7.06 -0.0 -9.36 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFEC589)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 328.03 135.0 c -6.0 0.0 -6.0 1.0 -6.03 6.0 v 1.0 c 0.03 -5.0 0.03 -6.0 6.03 -6.0 c 0.0 0.0 2.56 -0.0 4.86 0.0 l 2.14 2.0 h 9.0 c 6.0 0.0 6.0 1.0 6.0 6.0 v -1.0 c 0.0 -5.0 0.0 -6.0 -6.0 -6.0 h -9.0 l -2.14 -2.0 c -2.3 -0.0 -4.86 0.0 -4.86 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 4f,
                pathData = addPathNodes("m 350.0 152.0 l -9.0 9.0 h 4.0 c 5.0 0.0 5.0 -1.0 5.03 -6.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF666666),
                        1f to Color(0xFF7A7A7A)
                    ),
                    start = Offset(321f, 70f),
                    end = Offset(367f, 105f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 358.32 70.0 c 2.9 0.0 5.05 -0.09 6.66 1.12 c 0.81 0.62 1.35 1.54 1.66 2.72 c 0.31 1.17 0.43 2.61 0.43 4.49 v 9.41 v 4.27 v 4.27 c 0.0 1.95 -0.05 3.44 -0.27 4.64 c -0.22 1.21 -0.62 2.18 -1.39 2.87 c -0.76 0.68 -1.75 0.96 -2.89 1.09 c -1.14 0.13 -2.5 0.13 -4.2 0.13 h -28.5 c -1.67 0.0 -3.01 0.0 -4.14 -0.13 v 0.0 c -1.14 -0.13 -2.13 -0.41 -2.89 -1.09 c -0.77 -0.68 -1.19 -1.65 -1.42 -2.86 c -0.23 -1.21 -0.29 -2.7 -0.29 -4.65 v -11.54 c 0.0 -0.26 0.01 -0.43 0.01 -0.61 v -0.01 l -0.01 -1.88 c -0.01 -1.81 -0.02 -3.25 0.12 -4.46 c 0.13 -1.2 0.42 -2.23 1.1 -3.03 c 0.68 -0.8 1.67 -1.24 2.89 -1.47 c 1.21 -0.23 2.71 -0.48 4.65 -0.29 h 9.9 l 3.0 -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 367.0 92.0 l -12.0 12.0 h 4.69 c 6.63 0.0 7.31 -0.68 7.31 -7.3 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 321.06 95.27 v 1.0 c 0.0 1.95 0.05 3.44 0.27 4.64 c 0.22 1.21 0.62 2.18 1.39 2.87 c 0.76 0.68 1.75 0.96 2.89 1.09 c 1.14 0.13 2.5 0.13 4.2 0.13 h 28.5 c 1.67 0.0 3.01 0.0 4.14 -0.13 v 0.0 c 1.14 -0.13 2.13 -0.41 2.89 -1.09 c 0.77 -0.68 1.19 -1.65 1.42 -2.86 c 0.23 -1.21 0.29 -2.7 0.29 -4.65 v -1.0 c 0.0 1.96 -0.06 3.45 -0.29 4.65 c -0.23 1.21 -0.65 2.19 -1.42 2.86 c -0.77 0.67 -1.76 0.95 -2.89 1.09 v 0.0 c -1.13 0.13 -2.47 0.13 -4.14 0.13 h -28.5 c -1.7 0.0 -3.06 0.0 -4.2 -0.13 c -1.14 -0.13 -2.13 -0.41 -2.89 -1.09 c -0.76 -0.68 -1.17 -1.66 -1.39 -2.87 c -0.21 -1.2 -0.27 -2.69 -0.27 -4.64 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 342.72 70.0 l -3.0 3.0 h -9.9 c -1.93 -0.2 -3.43 0.06 -4.65 0.29 c -1.22 0.23 -2.21 0.67 -2.89 1.47 c -0.68 0.8 -0.96 1.82 -1.1 3.03 c -0.07 0.66 -0.1 1.4 -0.11 2.22 h 0.04 c 0.02 -0.42 0.03 -0.85 0.07 -1.22 c 0.13 -1.2 0.42 -2.23 1.1 -3.03 c 0.68 -0.8 1.67 -1.24 2.89 -1.47 c 1.21 -0.23 2.71 -0.48 4.65 -0.29 h 9.9 l 3.0 -3.0 h 15.6 c 2.9 0.0 5.05 -0.09 6.66 1.12 c 0.81 0.62 1.35 1.54 1.66 2.72 c 0.31 1.17 0.43 2.61 0.43 4.49 v -1.0 c 0.0 -1.87 -0.12 -3.32 -0.43 -4.49 c -0.31 -1.17 -0.85 -2.1 -1.66 -2.72 c -1.61 -1.21 -3.76 -1.12 -6.66 -1.12 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF732206)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 342.72 69.0 l -3.0 3.0 h -9.9 c -1.93 -0.2 -3.43 0.06 -4.65 0.29 c -1.22 0.23 -2.21 0.67 -2.89 1.47 c -0.68 0.8 -0.96 1.82 -1.1 3.03 c -0.07 0.66 -0.1 1.4 -0.11 2.22 h 0.04 c 0.02 -0.42 0.03 -0.85 0.07 -1.22 c 0.13 -1.2 0.42 -2.23 1.1 -3.03 c 0.68 -0.8 1.67 -1.24 2.89 -1.47 c 1.21 -0.23 2.71 -0.48 4.65 -0.29 h 9.9 l 3.0 -3.0 h 15.6 c 2.9 0.0 5.05 -0.09 6.66 1.12 c 0.81 0.62 1.35 1.54 1.66 2.72 c 0.31 1.17 0.43 2.61 0.43 4.49 v -1.0 c 0.0 -1.87 -0.12 -3.32 -0.43 -4.49 c -0.31 -1.17 -0.85 -2.1 -1.66 -2.72 c -1.61 -1.21 -3.76 -1.12 -6.66 -1.12 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 329.81 63.0 c -2.9 0.0 -5.05 -0.09 -6.66 1.12 c -0.81 0.62 -1.35 1.54 -1.66 2.72 c -0.31 1.17 -0.43 2.61 -0.43 4.49 v 1.0 c 0.0 -1.87 0.12 -3.32 0.43 -4.49 c 0.31 -1.17 0.85 -2.1 1.66 -2.72 c 1.61 -1.21 3.76 -1.12 6.66 -1.12 h 9.6 l 3.0 3.0 h 15.9 c 1.94 0.0 3.43 0.06 4.65 0.29 c 1.22 0.23 2.21 0.67 2.89 1.47 c 0.68 0.8 0.96 1.82 1.1 3.03 c 0.07 0.6 0.1 1.26 0.11 2.0 c 0.0 -1.13 -0.02 -2.15 -0.11 -3.0 c -0.13 -1.2 -0.42 -2.23 -1.1 -3.03 c -0.68 -0.8 -1.67 -1.24 -2.89 -1.47 c -1.21 -0.23 -2.7 -0.29 -4.65 -0.29 h -15.9 l -3.0 -3.0 Z M 367.06 77.37 L 367.05 78.11 v 0.01 c 0.0 0.18 0.01 0.35 0.01 0.61 v -1.0 c 0.0 -0.15 0.0 -0.25 -0.01 -0.36 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF491706)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 326.0 191.0 c -1.49 0.0 -2.75 -0.09 -3.76 0.71 c -0.52 0.42 -0.85 1.03 -1.03 1.73 c -0.17 0.7 -0.22 1.52 -0.21 2.56 v 9.99 c 0.0 1.04 0.06 1.86 0.23 2.55 c 0.18 0.7 0.5 1.31 1.02 1.73 c 1.01 0.81 2.26 0.72 3.75 0.72 H 338.0 c 1.04 0.0 1.86 -0.06 2.55 -0.23 c 0.7 -0.18 1.31 -0.5 1.73 -1.02 c 0.81 -1.01 0.72 -2.26 0.72 -3.75 v -8.0 c 0.0 -1.04 -0.06 -1.86 -0.23 -2.55 c -0.18 -0.7 -0.5 -1.31 -1.02 -1.73 c -1.01 -0.81 -2.26 -0.72 -3.75 -0.72 h -6.56 l -2.03 -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2C001E),
                        0.11f to Color(0xFF2C001E),
                        0.19f to Color(0xFF370626),
                        0.3f to Color(0xFF55163B),
                        0.37f to Color(0xFF772953),
                        0.45f to Color(0xFF7C2B51),
                        0.52f to Color(0xFF8B314B),
                        0.6f to Color(0xFF8B314B),
                        0.67f to Color(0xFFA33A41),
                        0.8f to Color(0xFFC44732),
                        0.91f to Color(0xFFE65524),
                        1f to Color(0xFFE65524)
                    ),
                    start = Offset(321f, 211f),
                    end = Offset(345f, 188f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 326.0 190.5 c -1.5 0.0 -2.62 -0.05 -3.45 0.61 c -0.42 0.33 -0.69 0.83 -0.85 1.46 c -0.16 0.63 -0.21 1.42 -0.2 2.44 v 9.99 c 0.0 1.02 0.06 1.8 0.22 2.43 c 0.16 0.63 0.43 1.13 0.84 1.46 c 0.83 0.66 1.94 0.61 3.44 0.61 H 338.0 c 1.02 0.0 1.8 -0.06 2.43 -0.22 c 0.63 -0.16 1.13 -0.43 1.46 -0.84 c 0.66 -0.83 0.61 -1.94 0.61 -3.44 v -8.0 c 0.0 -1.02 -0.06 -1.8 -0.22 -2.43 c -0.16 -0.63 -0.43 -1.13 -0.84 -1.46 c -0.83 -0.66 -1.94 -0.61 -3.44 -0.61 h -6.76 l -2.03 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 342.07 202.94 l -6.06 6.06 h 1.19 c 4.42 0.0 4.88 -0.45 4.88 -4.87 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF903906)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.03 194.0 l -2.03 2.0 l -3.56 0.07 c -4.42 0.07 -4.88 0.45 -4.88 4.87 v 1.0 c 0.0 -4.41 0.45 -4.79 4.88 -4.87 l 3.56 -0.07 l 2.03 -2.0 h 5.66 c 4.42 0.0 4.88 0.45 4.88 4.87 v -1.0 c 0.0 -4.41 -0.45 -4.87 -4.88 -4.87 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF666666),
                        1f to Color(0xFF7A7A7A)
                    ),
                    start = Offset(321f, 193f),
                    end = Offset(345f, 210f)
                ),
                strokeLineWidth = 1.00009f,
                pathData = addPathNodes("m 332.0 195.0 l -2.03 2.0 h -4.47 c -2.96 0.0 -3.97 0.02 -4.0 3.87 c -0.0 2.53 0.01 3.06 0.07 5.59 c -0.02 1.09 0.43 2.31 1.5 2.77 c 0.83 0.4 1.78 0.19 2.67 0.25 c 5.37 0.02 8.73 0.02 14.1 -0.01 c 0.86 -0.2 1.86 -0.48 2.28 -1.35 c 0.54 -1.02 0.29 -2.22 0.37 -3.32 c 0.0 -1.69 0.02 -1.37 0.02 -3.06 v -0.73 c -0.0 -1.13 -0.02 -2.25 -0.04 -3.38 c -0.22 -2.64 -1.35 -2.65 -3.96 -2.65 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.0 195.0 l -2.03 2.0 h -4.47 c -3.0 0.0 -4.0 0.0 -4.0 4.0 v 1.0 c 0.0 -4.0 0.73 -4.0 4.0 -4.0 h 4.47 l 2.03 -2.0 h 6.5 c 3.0 0.0 4.04 0.0 4.0 4.0 v -1.0 c 0.04 -4.0 -0.96 -4.0 -4.0 -4.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 326.0 190.5 c -1.5 0.0 -2.62 -0.05 -3.45 0.61 c -0.42 0.33 -0.69 0.83 -0.85 1.46 c -0.16 0.63 -0.21 1.42 -0.2 2.44 v 9.99 c 0.0 1.02 0.06 1.8 0.22 2.43 c 0.16 0.63 0.43 1.13 0.84 1.46 c 0.83 0.66 1.94 0.61 3.44 0.61 H 338.0 c 1.02 0.0 1.8 -0.06 2.43 -0.22 c 0.63 -0.16 1.13 -0.43 1.46 -0.84 c 0.66 -0.83 0.61 -1.94 0.61 -3.44 v -8.0 c 0.0 -1.02 -0.06 -1.8 -0.22 -2.43 c -0.16 -0.63 -0.43 -1.13 -0.84 -1.46 c -0.83 -0.66 -1.94 -0.61 -3.44 -0.61 h -6.76 l -2.03 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFEC589)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 329.0 191.0 l 2.03 2.0 h 6.97 c 3.0 0.0 4.0 0.0 4.0 4.0 v 1.0 c 0.0 -4.0 -1.0 -4.0 -4.0 -4.0 h -6.97 l -2.03 -2.0 h -3.0 c -3.0 0.0 -4.04 0.0 -4.0 4.0 v -1.0 c -0.04 -4.0 1.0 -4.0 4.0 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 342.0 202.0 l -7.0 7.0 h 3.0 c 3.0 0.0 4.0 0.0 4.0 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF491706)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 378.0 193.0 c -1.49 0.0 -2.75 -0.09 -3.76 0.71 c -0.52 0.42 -0.85 1.03 -1.03 1.73 c -0.17 0.7 -0.22 1.52 -0.21 2.56 v 7.99 c 0.0 1.04 0.06 1.86 0.23 2.55 c 0.18 0.7 0.5 1.31 1.02 1.73 c 1.01 0.81 2.26 0.72 3.75 0.72 h 10.0 c 1.04 0.0 1.86 -0.06 2.55 -0.23 c 0.7 -0.18 1.31 -0.5 1.73 -1.02 c 0.81 -1.01 0.72 -2.26 0.72 -3.75 v -6.0 c 0.0 -1.04 -0.06 -1.86 -0.23 -2.55 c -0.18 -0.7 -0.5 -1.31 -1.02 -1.73 c -1.01 -0.81 -2.26 -0.72 -3.75 -0.72 h -5.56 l -2.03 -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2C001E),
                        0.11f to Color(0xFF2C001E),
                        0.19f to Color(0xFF370626),
                        0.3f to Color(0xFF55163B),
                        0.37f to Color(0xFF772953),
                        0.45f to Color(0xFF7C2B51),
                        0.52f to Color(0xFF8B314B),
                        0.6f to Color(0xFF8B314B),
                        0.67f to Color(0xFFA33A41),
                        0.8f to Color(0xFFC44732),
                        0.91f to Color(0xFFE65524),
                        1f to Color(0xFFE65524)
                    ),
                    start = Offset(372f, 211f),
                    end = Offset(396f, 188f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 378.0 192.5 c -1.5 0.0 -2.62 -0.05 -3.45 0.61 c -0.42 0.33 -0.69 0.83 -0.85 1.46 c -0.16 0.63 -0.21 1.42 -0.2 2.44 v 7.99 c 0.0 1.02 0.06 1.8 0.22 2.43 c 0.16 0.63 0.43 1.13 0.84 1.46 c 0.83 0.66 1.94 0.61 3.44 0.61 h 10.0 c 1.02 0.0 1.8 -0.06 2.43 -0.22 c 0.63 -0.16 1.13 -0.43 1.46 -0.84 c 0.66 -0.83 0.61 -1.94 0.61 -3.44 v -6.0 c 0.0 -1.02 -0.06 -1.8 -0.22 -2.43 c -0.16 -0.63 -0.43 -1.13 -0.84 -1.46 c -0.83 -0.66 -1.44 -0.61 -3.44 -0.61 h -4.76 l -2.03 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF903906)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 383.03 196.0 l -2.03 2.0 l -2.56 0.07 c -4.42 0.07 -4.88 0.45 -4.88 4.87 v 1.0 c 0.0 -4.41 0.45 -4.79 4.88 -4.87 l 2.56 -0.07 l 2.03 -2.0 h 4.66 c 4.42 0.0 4.88 0.45 4.88 4.87 v -1.0 c 0.0 -4.41 -0.45 -4.87 -4.88 -4.87 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF666666),
                        1f to Color(0xFF7A7A7A)
                    ),
                    start = Offset(372f, 193f),
                    end = Offset(396f, 210f)
                ),
                strokeLineWidth = 1.00009f,
                pathData = addPathNodes("m 383.0 197.0 l -2.03 2.0 h -3.47 c -2.96 0.0 -3.97 0.02 -4.0 3.87 c -0.0 2.53 0.01 1.06 0.07 3.59 c -0.02 1.09 0.43 2.31 1.5 2.77 c 0.83 0.4 1.78 0.19 2.67 0.25 c 5.37 0.02 6.73 0.02 12.1 -0.01 c 0.86 -0.2 1.86 -0.48 2.28 -1.35 c 0.54 -1.02 0.29 -2.22 0.37 -3.32 c 0.0 -1.69 0.02 0.63 0.02 -1.06 v -0.73 c -0.0 -1.13 -0.02 -2.25 -0.04 -3.38 c -0.22 -2.64 -1.35 -2.65 -3.96 -2.65 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 383.0 197.0 l -2.03 2.0 H 377.5 c -3.0 0.0 -4.0 0.0 -4.0 4.0 v 1.0 c 0.0 -4.0 0.73 -4.0 4.0 -4.0 h 3.47 l 2.03 -2.0 h 5.5 c 3.0 0.0 4.04 0.0 4.0 4.0 v -1.0 c 0.04 -4.0 -0.96 -4.0 -4.0 -4.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 378.0 192.5 c -1.5 0.0 -2.62 -0.05 -3.45 0.61 c -0.42 0.33 -0.69 0.83 -0.85 1.46 c -0.16 0.63 -0.21 1.42 -0.2 2.44 v 7.99 c 0.0 1.02 0.06 1.8 0.22 2.43 c 0.16 0.63 0.43 1.13 0.84 1.46 c 0.83 0.66 1.94 0.61 3.44 0.61 h 10.0 c 1.02 0.0 1.8 -0.06 2.43 -0.22 c 0.63 -0.16 1.13 -0.43 1.46 -0.84 c 0.66 -0.83 0.61 -1.94 0.61 -3.44 v -6.0 c 0.0 -1.02 -0.06 -1.8 -0.22 -2.43 c -0.16 -0.63 -0.43 -1.13 -0.84 -1.46 c -0.83 -0.66 -1.94 -0.61 -3.44 -0.61 h -4.76 l -2.03 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFEC589)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 381.0 193.0 l 2.03 2.0 H 388.0 c 3.0 0.0 4.0 0.0 4.0 4.0 v 1.0 c 0.0 -4.0 -1.0 -4.0 -4.0 -4.0 h -4.97 l -2.03 -2.0 h -3.0 c -3.0 0.0 -4.04 0.0 -4.0 4.0 v -1.0 c -0.04 -4.0 1.0 -4.0 4.0 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 392.0 202.0 l -7.0 7.0 h 3.0 c 3.0 0.0 4.0 0.0 4.0 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 4.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 389.5 207.5 m -4.5 0.0 a 4.5 4.5 0.0 1 1 9.0 0.0 a 4.5 4.5 0.0 1 1 -9.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 389.0 205.0 v 2.0 h -2.0 v 1.0 h 2.0 v 2.0 h 1.0 v -2.0 h 2.0 v -1.0 h -2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 3.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.5 248.5 m -3.5 0.0 a 3.5 3.5 0.0 1 1 7.0 0.0 a 3.5 3.5 0.0 1 1 -7.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 332.0 246.0 v 2.0 h -2.0 v 1.0 h 2.0 v 2.0 h 1.0 v -2.0 h 2.0 v -1.0 h -2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 34f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 238.0 244.0 m -34.0 0.0 a 34.0 34.0 0.0 1 1 68.0 0.0 a 34.0 34.0 0.0 1 1 -68.0 0.0")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 4.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 389.5 207.5 m -4.5 0.0 a 4.5 4.5 0.0 1 1 9.0 0.0 a 4.5 4.5 0.0 1 1 -9.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 389.0 205.0 v 2.0 h -2.0 v 1.0 h 2.0 v 2.0 h 1.0 v -2.0 h 2.0 v -1.0 h -2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 4.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 339.5 207.5 m -4.5 0.0 a 4.5 4.5 0.0 1 1 9.0 0.0 a 4.5 4.5 0.0 1 1 -9.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 339.0 205.0 v 2.0 h -2.0 v 1.0 h 2.0 v 2.0 h 1.0 v -2.0 h 2.0 v -1.0 h -2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 3.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.5 248.5 m -3.5 0.0 a 3.5 3.5 0.0 1 1 7.0 0.0 a 3.5 3.5 0.0 1 1 -7.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 332.0 246.0 v 2.0 h -2.0 v 1.0 h 2.0 v 2.0 h 1.0 v -2.0 h 2.0 v -1.0 h -2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 4.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 347.5 159.5 m -4.5 0.0 a 4.5 4.5 0.0 1 1 9.0 0.0 a 4.5 4.5 0.0 1 1 -9.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 347.0 157.0 v 2.0 h -2.0 v 1.0 h 2.0 v 2.0 h 1.0 v -2.0 h 2.0 v -1.0 h -2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 6.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 361.5 101.5 m -6.5 0.0 a 6.5 6.5 0.0 1 1 13.0 0.0 a 6.5 6.5 0.0 1 1 -13.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                pathData = addPathNodes("m 361.0 98.0 v 3.0 h -3.0 v 1.0 h 3.0 v 3.0 h 1.0 v -3.0 h 3.0 v -1.0 h -3.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0F8420)),
                strokeLineWidth = 34f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 238.0 242.0 m -34.0 0.0 a 34.0 34.0 0.0 1 1 68.0 0.0 a 34.0 34.0 0.0 1 1 -68.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 6f,
                pathData = addPathNodes("m 236.0 220.0 v 20.0 h -20.0 v 4.0 h 20.0 v 20.0 h 4.0 v -20.0 h 20.0 v -4.0 h -20.0 v -20.0 Z")
            )
        }.build()

        return _FolderNew!!
    }

@Suppress("ObjectPropertyName")
private var _FolderNew: ImageVector? = null
