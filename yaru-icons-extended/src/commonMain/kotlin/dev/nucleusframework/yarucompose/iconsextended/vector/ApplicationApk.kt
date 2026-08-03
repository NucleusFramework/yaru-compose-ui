package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val ApplicationApk: ImageVector
    get() {
        if (_ApplicationApk != null) {
            return _ApplicationApk!!
        }
        _ApplicationApk = ImageVector.Builder(
            name = "ApplicationApk",
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
                pathData = addPathNodes("m 335.73 62.0 c -2.22 0.0 -3.97 0.05 -5.41 0.29 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.32 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.2 -0.28 5.42 V 85.0 V 97.25 c -0.01 2.23 0.04 3.98 0.28 5.42 c 0.24 1.44 0.7 2.62 1.56 3.48 c 0.86 0.86 2.04 1.31 3.48 1.56 c 1.44 0.24 3.19 0.29 5.41 0.29 h 16.54 c 2.22 0.0 3.97 -0.05 5.41 -0.29 c 1.44 -0.24 2.61 -0.7 3.47 -1.56 c 0.86 -0.86 1.31 -2.04 1.55 -3.48 C 362.95 101.23 363.0 99.48 363.0 97.25 V 85.0 V 72.75 c 0.0 -2.23 -0.05 -3.98 -0.29 -5.42 c -0.24 -1.44 -0.69 -2.62 -1.55 -3.48 c -0.86 -0.86 -2.04 -1.32 -3.47 -1.56 C 356.24 62.05 354.49 62.0 352.27 62.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 45.0 C 67.62 45.0 63.83 48.63 64.0 83.99 L 64.0 157.0 L 64.0 230.01 C 63.83 265.37 67.62 269.0 102.92 269.0 L 201.08 269.0 C 236.38 269.0 239.08 265.36 240.0 230.01 L 240.0 157.0 L 240.0 83.99 C 240.0 48.62 236.38 45.0 201.08 45.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 45.0 C 67.62 45.0 63.83 48.63 64.0 83.99 L 64.0 157.0 L 64.0 230.01 C 63.83 265.37 67.62 269.0 102.92 269.0 L 201.08 269.0 C 236.38 269.0 240.0 265.38 240.0 230.01 L 240.0 157.0 L 240.0 83.99 C 240.0 48.62 236.38 45.0 201.08 45.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF76C22B),
                        1f to Color(0xFFA6D74F)
                    ),
                    start = Offset(334.4f, 54f),
                    end = Offset(365.22f, 112f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 335.73 61.0 C 333.51 61.0 331.76 61.05 330.32 61.29 C 328.88 61.54 327.7 61.99 326.83 62.85 C 325.97 63.71 325.52 64.89 325.28 66.33 C 325.04 67.77 324.99 69.52 325.0 71.75 L 325.0 84.0 L 325.0 96.25 C 324.99 98.48 325.04 100.23 325.28 101.67 C 325.52 103.11 325.97 104.29 326.83 105.15 C 327.7 106.01 328.88 106.46 330.32 106.71 C 331.76 106.95 333.51 107.0 335.73 107.0 L 352.27 107.0 C 354.49 107.0 356.24 106.95 357.68 106.71 C 359.12 106.46 360.29 106.01 361.15 105.15 C 362.01 104.29 362.47 103.11 362.71 101.67 C 362.95 100.23 363.0 98.48 363.0 96.25 L 363.0 84.0 L 363.0 71.75 C 363.0 69.52 362.95 67.77 362.71 66.33 C 362.47 64.89 362.01 63.71 361.15 62.85 C 360.29 61.99 359.12 61.54 357.68 61.29 C 356.24 61.05 354.49 61.0 352.27 61.0 L 335.73 61.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF76C22B),
                        1f to Color(0xFFA6D74F)
                    ),
                    start = Offset(95.99f, 28f),
                    end = Offset(223.99f, 284f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 201.07 44.0 c 35.3 0.0 39.09 3.63 38.92 38.99 V 156.0 V 229.01 C 240.17 264.37 236.37 268.0 201.07 268.0 H 102.92 C 67.62 268.0 63.99 264.38 63.99 229.01 V 156.0 V 82.99 C 63.99 47.62 67.62 44.0 102.92 44.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF76C22B),
                        1f to Color(0xFFA6D74F)
                    ),
                    start = Offset(324.45f, 236.36f),
                    end = Offset(332.09f, 251.64f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.9 236.5 c 0.71 0.0 1.27 0.02 1.75 0.1 c 0.48 0.08 0.9 0.24 1.21 0.55 c 0.31 0.31 0.47 0.73 0.55 1.21 c 0.08 0.48 0.09 1.04 0.09 1.76 V 244.0 v 3.9 c 0.0 0.71 -0.01 1.28 -0.09 1.75 c -0.08 0.48 -0.24 0.9 -0.55 1.21 c -0.31 0.31 -0.73 0.47 -1.21 0.55 c -0.48 0.08 -1.04 0.1 -1.75 0.1 h -5.81 c -0.71 0.0 -1.27 -0.02 -1.75 -0.1 c -0.48 -0.08 -0.9 -0.24 -1.21 -0.55 c -0.31 -0.31 -0.46 -0.73 -0.54 -1.21 c -0.08 -0.48 -0.1 -1.04 -0.1 -1.75 V 244.0 V 240.1 c 0.0 -0.71 0.02 -1.28 0.1 -1.75 c 0.08 -0.48 0.24 -0.9 0.54 -1.21 c 0.31 -0.31 0.73 -0.47 1.21 -0.55 c 0.48 -0.08 1.04 -0.1 1.75 -0.1 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF76C22B),
                        1f to Color(0xFFA6D74F)
                    ),
                    start = Offset(326f, 188f),
                    end = Offset(338f, 212f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 336.13 188.5 c 1.11 0.0 1.99 0.03 2.71 0.15 c 0.72 0.12 1.31 0.35 1.74 0.78 c 0.43 0.43 0.66 1.02 0.78 1.74 c 0.12 0.72 0.14 1.6 0.14 2.71 V 200.0 v 6.13 c 0.0 1.11 -0.02 1.99 -0.14 2.71 c -0.12 0.72 -0.35 1.31 -0.78 1.74 c -0.43 0.43 -1.02 0.66 -1.74 0.78 c -0.72 0.12 -1.6 0.15 -2.71 0.15 h -8.27 c -1.11 0.0 -1.99 -0.03 -2.71 -0.15 c -0.72 -0.12 -1.31 -0.35 -1.74 -0.78 c -0.43 -0.43 -0.66 -1.02 -0.78 -1.74 c -0.12 -0.72 -0.15 -1.6 -0.15 -2.71 V 200.0 V 193.88 c 0.0 -1.11 0.03 -1.99 0.15 -2.71 c 0.12 -0.72 0.35 -1.31 0.78 -1.74 c 0.43 -0.43 1.02 -0.66 1.74 -0.78 c 0.72 -0.12 1.59 -0.15 2.71 -0.15 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF76C22B),
                        1f to Color(0xFFA6D74F)
                    ),
                    start = Offset(328.91f, 132.73f),
                    end = Offset(344.18f, 163.27f)
                ),
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 341.81 133.5 c 1.41 0.0 2.52 0.03 3.42 0.19 c 0.9 0.15 1.62 0.43 2.14 0.95 c 0.52 0.52 0.8 1.24 0.95 2.14 c 0.15 0.9 0.18 2.01 0.17 3.43 V 148.0 v 7.8 c 0.01 1.41 -0.02 2.52 -0.17 3.42 c -0.15 0.9 -0.43 1.62 -0.95 2.14 c -0.52 0.52 -1.24 0.8 -2.14 0.95 c -0.9 0.15 -2.01 0.19 -3.42 0.19 H 330.19 c -1.41 0.0 -2.52 -0.03 -3.42 -0.19 c -0.9 -0.15 -1.62 -0.43 -2.14 -0.95 c -0.52 -0.52 -0.8 -1.24 -0.95 -2.14 c -0.15 -0.9 -0.19 -2.01 -0.19 -3.43 V 148.0 V 140.2 c 0.0 -1.42 0.03 -2.52 0.19 -3.43 c 0.15 -0.9 0.43 -1.62 0.95 -2.14 c 0.52 -0.52 1.24 -0.8 2.14 -0.95 c 0.9 -0.15 2.01 -0.19 3.42 -0.19 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.Black.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(344f, 61f),
                    end = Offset(344f, 107f)
                ),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.73 61.5 c -2.21 0.0 -3.95 0.05 -5.33 0.29 c -1.38 0.23 -2.45 0.65 -3.21 1.42 c -0.77 0.76 -1.19 1.82 -1.42 3.21 c -0.23 1.38 -0.28 3.12 -0.27 5.34 V 84.0 V 96.25 c -0.01 2.22 0.04 3.95 0.27 5.34 c 0.23 1.38 0.65 2.44 1.42 3.21 c 0.77 0.76 1.83 1.19 3.21 1.42 c 1.38 0.23 3.12 0.29 5.33 0.29 h 16.54 c 2.21 0.0 3.94 -0.05 5.33 -0.29 c 1.38 -0.23 2.44 -0.65 3.2 -1.42 c 0.76 -0.76 1.18 -1.82 1.42 -3.21 c 0.23 -1.38 0.29 -3.12 0.29 -5.34 V 84.0 V 71.75 c 0.0 -2.22 -0.05 -3.95 -0.29 -5.34 c -0.23 -1.38 -0.65 -2.44 -1.42 -3.21 c -0.76 -0.76 -1.82 -1.19 -3.2 -1.42 C 356.22 61.55 354.49 61.5 352.27 61.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 144.0 129.0 v 26.0 c 0.0 1.11 0.89 2.0 2.0 2.0 h 12.0 c 1.11 0.0 2.0 -0.89 2.0 -2.0 v -26.0 Z M 148.0 145.0 h 8.0 v 8.0 h -8.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 152.0 45.0 h -8.0 v 8.0 h 8.0 Z M 152.0 53.0 v 8.0 h 8.0 v -8.0 Z M 152.0 61.0 h -8.0 v 8.0 h 8.0 Z M 152.0 69.0 L 152.0 77.0 h 8.0 L 160.0 69.0 Z M 152.0 77.0 h -8.0 v 8.0 h 8.0 Z M 152.0 85.0 v 8.0 h 8.0 v -8.0 Z M 152.0 93.0 h -8.0 v 8.0 h 8.0 Z M 152.0 101.0 v 8.0 h 8.0 v -8.0 Z M 152.0 109.0 h -8.0 v 8.0 h 8.0 Z M 152.0 117.0 v 8.0 h 8.0 v -8.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 342.0 75.0 v 6.5 c 0.0 0.28 0.22 0.5 0.5 0.5 h 3.0 c 0.28 0.0 0.5 -0.22 0.5 -0.5 v -6.5 Z M 343.0 79.0 h 2.0 v 2.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 344.0 62.0 h -2.0 v 2.0 h 2.0 Z M 344.0 64.0 v 2.0 h 2.0 L 346.0 64.0 Z M 344.0 66.0 h -2.0 v 2.0 h 2.0 Z M 344.0 68.0 v 2.0 h 2.0 v -2.0 Z M 344.0 70.0 h -2.0 v 2.0 h 2.0 Z M 344.0 72.0 v 2.0 h 2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 334.0 144.0 v 4.5 c 0.0 0.28 0.22 0.5 0.5 0.5 h 3.0 c 0.28 0.0 0.5 -0.22 0.5 -0.5 L 338.0 144.0 Z M 335.0 146.0 h 2.0 v 2.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 336.0 135.0 h -2.0 v 2.0 h 2.0 Z M 336.0 137.0 L 336.0 139.0 h 2.0 v -2.0 Z M 336.0 139.0 h -2.0 v 2.0 h 2.0 Z M 336.0 141.0 v 2.0 h 2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 327.0 241.0 v 2.75 c 0.0 0.14 0.11 0.25 0.25 0.25 h 1.5 c 0.14 0.0 0.25 -0.11 0.25 -0.25 L 329.0 241.0 Z M 327.5 242.5 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 328.0 237.0 v 1.0 h 1.0 v -1.0 Z M 328.0 238.0 h -1.0 v 1.0 h 1.0 Z M 328.0 239.0 v 1.0 h 1.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 331.0 197.0 v 2.75 c 0.0 0.14 0.11 0.25 0.25 0.25 h 1.5 c 0.14 0.0 0.25 -0.11 0.25 -0.25 L 333.0 197.0 Z M 331.5 198.5 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 332.0 189.0 v 1.0 h 1.0 v -1.0 Z M 332.0 190.0 h -1.0 v 1.0 h 1.0 Z M 332.0 191.0 v 1.0 h 1.0 v -1.0 Z M 332.0 192.0 h -1.0 v 1.0 h 1.0 Z M 332.0 193.0 v 1.0 h 1.0 v -1.0 Z M 332.0 194.0 h -1.0 v 1.0 h 1.0 Z M 332.0 195.0 v 1.0 h 1.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 144.0 128.0 v 26.0 c 0.0 1.11 0.89 2.0 2.0 2.0 h 12.0 c 1.11 0.0 2.0 -0.89 2.0 -2.0 v -26.0 Z M 148.0 144.0 h 8.0 v 8.0 h -8.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 152.0 44.0 h -8.0 v 8.0 h 8.0 Z M 152.0 52.0 v 8.0 h 8.0 v -8.0 Z M 152.0 60.0 h -8.0 v 8.0 h 8.0 Z M 152.0 68.0 L 152.0 76.0 h 8.0 L 160.0 68.0 Z M 152.0 76.0 h -8.0 v 8.0 h 8.0 Z M 152.0 84.0 v 8.0 h 8.0 v -8.0 Z M 152.0 92.0 h -8.0 v 8.0 h 8.0 Z M 152.0 100.0 v 8.0 h 8.0 v -8.0 Z M 152.0 108.0 h -8.0 v 8.0 h 8.0 Z M 152.0 116.0 v 8.0 h 8.0 v -8.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 342.0 74.0 v 6.5 c 0.0 0.28 0.22 0.5 0.5 0.5 h 3.0 c 0.28 0.0 0.5 -0.22 0.5 -0.5 v -6.5 Z M 343.0 78.0 h 2.0 v 2.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 344.0 61.0 h -2.0 v 2.0 h 2.0 Z M 344.0 63.0 v 2.0 h 2.0 L 346.0 63.0 Z M 344.0 65.0 h -2.0 v 2.0 h 2.0 Z M 344.0 67.0 v 2.0 h 2.0 v -2.0 Z M 344.0 69.0 h -2.0 v 2.0 h 2.0 Z M 344.0 71.0 v 2.0 h 2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 334.0 143.0 v 4.5 c 0.0 0.28 0.22 0.5 0.5 0.5 h 3.0 c 0.28 0.0 0.5 -0.22 0.5 -0.5 L 338.0 143.0 Z M 335.0 145.0 h 2.0 v 2.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15f,
                pathData = addPathNodes("m 336.0 134.0 h -2.0 v 2.0 h 2.0 Z M 336.0 136.0 L 336.0 138.0 h 2.0 v -2.0 Z M 336.0 138.0 h -2.0 v 2.0 h 2.0 Z M 336.0 140.0 v 2.0 h 2.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 327.0 240.0 v 2.75 c 0.0 0.14 0.11 0.25 0.25 0.25 h 1.5 c 0.14 0.0 0.25 -0.11 0.25 -0.25 L 329.0 240.0 Z M 327.5 241.5 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 328.0 237.0 h -1.0 v 1.0 h 1.0 Z M 328.0 238.0 v 1.0 h 1.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 331.0 196.0 v 2.75 c 0.0 0.14 0.11 0.25 0.25 0.25 h 1.5 c 0.14 0.0 0.25 -0.11 0.25 -0.25 L 333.0 196.0 Z M 331.5 197.5 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 15.000001f,
                pathData = addPathNodes("m 332.0 189.0 h -1.0 v 1.0 h 1.0 Z M 332.0 190.0 v 1.0 h 1.0 v -1.0 Z M 332.0 191.0 h -1.0 v 1.0 h 1.0 Z M 332.0 192.0 v 1.0 h 1.0 v -1.0 Z M 332.0 193.0 h -1.0 v 1.0 h 1.0 Z M 332.0 194.0 v 1.0 h 1.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0C2809)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                pathData = addPathNodes("m 335.53 204.16 l 1.3 -1.3 c 0.2 -0.2 0.2 -0.51 0.0 -0.71 c -0.2 -0.2 -0.51 -0.2 -0.71 0.0 l -1.48 1.48 c -0.79 -0.4 -1.69 -0.63 -2.64 -0.63 c -0.96 0.0 -1.86 0.23 -2.66 0.63 l -1.49 -1.48 c -0.2 -0.2 -0.51 -0.2 -0.71 0.0 c -0.2 0.2 -0.2 0.51 0.0 0.71 l 1.31 1.31 c -1.48 1.09 -2.45 2.84 -2.45 4.83 h 12.0 c 0.0 -1.99 -0.97 -3.75 -2.47 -4.84 Z M 330.0 207.0 h -1.0 v -1.0 h 1.0 Z M 335.0 207.0 h -1.0 v -1.0 h 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0C2809)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 351.06 90.32 l 2.6 -2.6 c 0.4 -0.4 0.4 -1.02 0.0 -1.42 c -0.4 -0.4 -1.02 -0.4 -1.42 0.0 l -2.96 2.96 C 347.7 88.46 345.9 88.0 344.0 88.0 c -1.92 0.0 -3.72 0.46 -5.32 1.26 L 335.7 86.3 c -0.4 -0.4 -1.02 -0.4 -1.42 0.0 c -0.4 0.4 -0.4 1.02 0.0 1.42 l 2.62 2.62 c -2.96 2.18 -4.9 5.68 -4.9 9.66 h 24.0 c 0.0 -3.98 -1.94 -7.5 -4.94 -9.68 Z M 340.0 96.0 h -2.0 v -2.0 h 2.0 Z M 350.0 96.0 h -2.0 v -2.0 h 2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0C2809)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 1.3333334f,
                pathData = addPathNodes("m 340.71 151.55 l 1.73 -1.73 c 0.27 -0.27 0.27 -0.68 0.0 -0.95 c -0.27 -0.27 -0.68 -0.27 -0.95 0.0 L 339.52 150.84 C 338.47 150.31 337.27 150.0 336.0 150.0 c -1.28 0.0 -2.48 0.31 -3.55 0.84 l -1.99 -1.97 c -0.27 -0.27 -0.68 -0.27 -0.95 0.0 c -0.27 0.27 -0.27 0.68 0.0 0.95 l 1.75 1.75 C 329.29 153.01 328.0 155.35 328.0 158.0 h 16.0 c 0.0 -2.65 -1.29 -5.0 -3.29 -6.45 Z M 333.33 155.33 L 332.0 155.33 L 332.0 154.0 h 1.33 Z M 340.0 155.33 h -1.33 L 338.67 154.0 L 340.0 154.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0C2809)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 9.333333f,
                pathData = addPathNodes("M 184.95 190.83 L 197.08 178.69 c 1.87 -1.87 1.87 -4.76 0.0 -6.63 c -1.87 -1.87 -4.76 -1.87 -6.63 0.0 L 176.64 185.88 C 169.27 182.15 160.87 180.0 152.0 180.0 c -8.96 0.0 -17.36 2.15 -24.83 5.88 l -13.91 -13.81 c -1.87 -1.87 -4.76 -1.87 -6.63 0.0 c -1.87 1.87 -1.87 4.76 0.0 6.63 L 118.87 190.92 C 105.05 201.09 96.0 217.43 96.0 236.0 h 112.0 c 0.0 -18.57 -9.05 -35.0 -23.05 -45.17 Z M 132.0 216.0 h -8.0 v -8.0 h 8.0 Z M 180.0 216.0 h -8.0 v -8.0 h 8.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF0C2809)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 0.6666667f,
                pathData = addPathNodes("m 330.35 245.77 l 0.87 -0.87 c 0.13 -0.13 0.13 -0.34 0.0 -0.47 c -0.13 -0.13 -0.34 -0.13 -0.47 0.0 L 329.76 245.42 C 329.23 245.15 328.63 245.0 328.0 245.0 c -0.64 0.0 -1.24 0.15 -1.77 0.42 l -0.99 -0.99 c -0.13 -0.13 -0.34 -0.13 -0.47 0.0 c -0.13 0.13 -0.13 0.34 0.0 0.47 l 0.87 0.87 C 324.65 246.51 324.0 247.67 324.0 249.0 h 8.0 c 0.0 -1.33 -0.65 -2.5 -1.65 -3.23 Z M 326.67 247.67 L 326.0 247.67 L 326.0 247.0 h 0.67 Z M 330.0 247.67 h -0.67 L 329.33 247.0 L 330.0 247.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 152.0 44.0 v 224.0 h 49.08 C 236.37 268.0 239.08 264.36 240.0 229.01 V 156.0 V 82.99 C 240.0 47.62 236.37 44.0 201.08 44.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 64.0 156.0 v 73.01 C 63.83 264.37 67.63 268.0 102.92 268.0 h 98.16 C 236.37 268.0 239.08 264.36 240.0 229.01 V 156.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 7.9999995f,
                pathData = addPathNodes("m 180.0 268.0 l 60.0 -60.0 v 22.48 C 239.95 264.48 236.2 268.0 201.83 268.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 326.0 84.0 V 96.25 C 325.96 105.09 326.91 106.0 335.73 106.0 h 16.54 C 361.09 106.0 362.0 105.09 362.0 96.25 V 84.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 344.0 62.0 v 44.0 h 8.27 C 361.09 106.0 362.0 105.09 362.0 96.25 V 84.0 V 71.75 C 362.0 62.91 361.09 62.0 352.27 62.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 323.0 200.0 v 6.13 c -0.02 4.42 0.45 4.88 4.87 4.88 h 8.27 C 340.55 211.0 341.0 210.55 341.0 206.13 V 200.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.0 189.0 v 22.0 h 4.13 C 340.55 211.0 341.0 210.55 341.0 206.13 V 200.0 V 193.88 C 341.0 189.45 340.55 189.0 336.13 189.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 324.0 148.0 v 7.8 C 323.97 161.42 324.58 162.0 330.19 162.0 h 11.62 C 347.42 162.0 348.0 161.42 348.0 155.8 V 148.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 336.0 134.0 v 28.0 h 5.81 C 347.42 162.0 348.0 161.42 348.0 155.8 V 148.0 V 140.2 C 348.0 134.58 347.42 134.0 341.81 134.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.0 237.0 v 14.0 h 2.9 C 333.71 251.0 334.0 250.71 334.0 247.9 V 244.0 V 240.1 C 334.0 237.29 333.71 237.0 330.9 237.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 322.0 244.0 v 3.9 C 321.99 250.71 322.29 251.0 325.1 251.0 h 5.81 C 333.71 251.0 334.0 250.71 334.0 247.9 V 244.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 330.19 133.5 c -1.41 0.0 -2.52 0.03 -3.42 0.19 c -0.9 0.15 -1.62 0.43 -2.14 0.95 c -0.52 0.52 -0.8 1.24 -0.95 2.14 c -0.15 0.9 -0.18 2.01 -0.17 3.43 V 148.0 v 7.8 c -0.01 1.41 0.02 2.52 0.17 3.42 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.19 3.42 0.19 h 11.62 c 1.41 0.0 2.52 -0.03 3.42 -0.19 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.15 -0.9 0.19 -2.01 0.19 -3.43 V 148.0 V 140.2 c 0.0 -1.42 -0.03 -2.52 -0.19 -3.43 c -0.15 -0.9 -0.43 -1.62 -0.95 -2.14 c -0.52 -0.52 -1.24 -0.8 -2.14 -0.95 C 344.33 133.53 343.22 133.5 341.81 133.5 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.87 188.5 c -1.11 0.0 -1.99 0.03 -2.71 0.15 c -0.72 0.12 -1.31 0.35 -1.74 0.78 c -0.43 0.43 -0.66 1.02 -0.78 1.74 c -0.12 0.72 -0.14 1.6 -0.14 2.71 V 200.0 v 6.13 c -0.0 1.11 0.02 1.99 0.14 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.15 2.71 0.15 h 8.27 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.6 0.15 -2.71 V 200.0 V 193.88 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.59 -0.15 -2.71 -0.15 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.1 236.5 c -0.71 0.0 -1.27 0.02 -1.75 0.1 c -0.48 0.08 -0.9 0.24 -1.21 0.55 c -0.31 0.31 -0.47 0.73 -0.55 1.21 c -0.08 0.48 -0.09 1.04 -0.09 1.76 V 244.0 v 3.9 c -0.0 0.71 0.01 1.28 0.09 1.75 c 0.08 0.48 0.24 0.9 0.55 1.21 c 0.31 0.31 0.73 0.47 1.21 0.55 c 0.48 0.08 1.04 0.1 1.75 0.1 h 5.81 c 0.71 0.0 1.27 -0.02 1.75 -0.1 c 0.48 -0.08 0.9 -0.24 1.21 -0.55 c 0.31 -0.31 0.46 -0.73 0.54 -1.21 c 0.08 -0.48 0.1 -1.04 0.1 -1.75 V 244.0 V 240.1 c 0.0 -0.71 -0.02 -1.28 -0.1 -1.75 c -0.08 -0.48 -0.24 -0.9 -0.54 -1.21 c -0.31 -0.31 -0.73 -0.47 -1.21 -0.55 c -0.48 -0.08 -1.04 -0.1 -1.75 -0.1 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 64.0 227.01 v 2.0 C 63.83 264.37 67.63 268.0 102.92 268.0 h 98.16 c 35.3 0.0 38.0 -3.64 38.92 -38.99 v -2.0 C 239.08 262.36 236.37 266.0 201.08 266.0 H 102.92 C 67.63 266.0 63.83 262.37 64.0 227.01 Z")
            )
            group(
                clipPathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 L 323.0 200.0 L 323.0 206.13 C 322.98 210.55 323.45 211.0 327.87 211.0 h 8.27 C 340.55 211.0 341.0 210.55 341.0 206.13 L 341.0 200.0 L 341.0 193.87 C 341.0 189.45 340.55 189.0 336.13 189.0 Z")
            ) {
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
                    pathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 L 323.0 200.0 L 323.0 206.13 C 322.98 210.55 323.45 211.0 327.87 211.0 h 8.27 C 340.55 211.0 341.0 210.55 341.0 206.13 L 341.0 200.0 L 341.0 193.87 C 341.0 189.45 340.55 189.0 336.13 189.0 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 325.1 237.0 c -2.81 0.0 -3.11 0.29 -3.1 3.1 L 322.0 244.0 v 3.9 c -0.01 2.81 0.29 3.1 3.1 3.1 h 5.81 C 333.71 251.0 334.0 250.71 334.0 247.9 L 334.0 244.0 L 334.0 240.1 C 334.0 237.29 333.71 237.0 330.9 237.0 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(328f, 237f),
                        end = Offset(328f, 251f)
                    ),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 325.1 237.0 c -2.81 0.0 -3.11 0.29 -3.1 3.1 L 322.0 244.0 v 3.9 c -0.01 2.81 0.29 3.1 3.1 3.1 h 5.81 C 333.71 251.0 334.0 250.71 334.0 247.9 L 334.0 244.0 L 334.0 240.1 C 334.0 237.29 333.71 237.0 330.9 237.0 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 330.19 134.0 c -5.62 0.0 -6.22 0.58 -6.19 6.2 v 7.8 v 7.8 c -0.03 5.63 0.58 6.2 6.19 6.2 h 11.61 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 v -7.8 c 0.0 -5.63 -0.58 -6.2 -6.19 -6.2 Z")
            ) {
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
                    pathData = addPathNodes("m 330.19 134.0 c -5.62 0.0 -6.22 0.58 -6.19 6.2 v 7.8 v 7.8 c -0.03 5.63 0.58 6.2 6.19 6.2 h 11.61 c 5.62 0.0 6.19 -0.58 6.19 -6.2 v -7.8 v -7.8 c 0.0 -5.63 -0.58 -6.2 -6.19 -6.2 Z")
                )
            }
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 44.0 C 67.63 44.0 63.83 47.63 64.0 82.99 v 2.0 C 63.83 49.63 67.63 46.0 102.92 46.0 h 98.16 C 236.37 46.0 240.0 49.63 240.0 84.99 v -2.0 C 240.0 47.63 236.37 44.0 201.08 44.0 Z")
            )
        }.build()

        return _ApplicationApk!!
    }

@Suppress("ObjectPropertyName")
private var _ApplicationApk: ImageVector? = null
