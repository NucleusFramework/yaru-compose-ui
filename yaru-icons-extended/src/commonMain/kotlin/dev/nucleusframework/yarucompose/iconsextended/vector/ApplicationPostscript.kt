package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val ApplicationPostscript: ImageVector
    get() {
        if (_ApplicationPostscript != null) {
            return _ApplicationPostscript!!
        }
        _ApplicationPostscript = ImageVector.Builder(
            name = "ApplicationPostscript",
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
                        0f to Color(0xFFDA1636),
                        1f to Color(0xFFF22C42)
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
                        0f to Color(0xFFDA1636),
                        1f to Color(0xFFF22C42)
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
                        0f to Color(0xFFDA1636),
                        1f to Color(0xFFF22C42)
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
                        0f to Color(0xFFDA1636),
                        1f to Color(0xFFF22C42)
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
                        0f to Color(0xFFDA1636),
                        1f to Color(0xFFF22C42)
                    ),
                    start = Offset(328.91f, 132.73f),
                    end = Offset(344.18f, 163.27f)
                ),
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 341.81 133.5 c 1.41 0.0 2.52 0.03 3.42 0.19 c 0.9 0.15 1.62 0.43 2.14 0.95 c 0.52 0.52 0.8 1.24 0.95 2.14 c 0.15 0.9 0.18 2.01 0.17 3.43 V 148.0 v 7.8 c 0.01 1.41 -0.02 2.52 -0.17 3.42 c -0.15 0.9 -0.43 1.62 -0.95 2.14 c -0.52 0.52 -1.24 0.8 -2.14 0.95 c -0.9 0.15 -2.01 0.19 -3.42 0.19 H 330.19 c -1.41 0.0 -2.52 -0.03 -3.42 -0.19 c -0.9 -0.15 -1.62 -0.43 -2.14 -0.95 c -0.52 -0.52 -0.8 -1.24 -0.95 -2.14 c -0.15 -0.9 -0.19 -2.01 -0.19 -3.43 V 148.0 V 140.2 c 0.0 -1.42 0.03 -2.52 0.19 -3.43 c 0.15 -0.9 0.43 -1.62 0.95 -2.14 c 0.52 -0.52 1.24 -0.8 2.14 -0.95 c 0.9 -0.15 2.01 -0.19 3.42 -0.19 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.9999998f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 161.26 93.37 l -45.69 54.11 c 11.9 1.91 31.99 16.95 28.96 36.93 c 6.17 -14.82 -5.16 -32.89 -16.05 -40.19 l 39.85 -47.6 c -2.13 -1.57 -3.82 -2.36 -7.07 -3.26 Z M 145.89 97.14 c -1.78 0.01 -3.11 0.27 -3.04 0.27 l -14.59 16.73 c -8.19 0.45 -16.17 1.01 -23.91 1.8 c -5.5 0.56 -9.88 4.94 -10.66 10.78 c -1.12 10.22 -1.68 20.99 -1.68 32.1 c 0.0 11.11 0.56 21.89 1.68 32.22 c 0.79 6.51 5.16 9.77 10.66 10.78 c 15.27 2.47 37.38 0.11 37.38 -20.88 c 0.0 -19.64 -32.22 -28.06 -43.22 -22.68 L 149.36 97.52 c -1.18 -0.29 -2.4 -0.38 -3.47 -0.38 Z M 179.44 114.36 c 0.0 0.0 -28.62 63.54 -31.43 70.05 c -4.27 9.65 -10.1 16.73 -18.52 19.2 c 7.41 0.34 14.82 0.45 22.45 0.45 c 16.72 0.0 32.67 -0.79 47.6 -2.24 c 5.5 -0.56 9.99 -5.05 10.66 -10.78 c 1.24 -10.33 1.8 -21.1 1.8 -32.22 c 0.0 -11.11 -0.56 -21.89 -1.8 -32.1 c -0.67 -5.84 -5.16 -10.22 -10.66 -10.78 c -6.51 -0.67 -13.25 -1.24 -20.1 -1.57 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.99999994f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("M 346.04 69.9 L 335.96 81.85 c 2.63 0.42 7.07 3.74 6.4 8.16 c 1.36 -3.27 -1.14 -7.26 -3.55 -8.87 l 8.8 -10.51 c -0.47 -0.35 -0.84 -0.52 -1.56 -0.72 Z M 342.65 70.73 c -0.39 0.0 -0.69 0.06 -0.67 0.06 l -3.22 3.69 c -1.81 0.1 -3.57 0.22 -5.28 0.4 c -1.21 0.12 -2.18 1.09 -2.36 2.38 c -0.25 2.26 -0.37 4.64 -0.37 7.09 c 0.0 2.45 0.12 4.83 0.37 7.11 c 0.17 1.44 1.14 2.16 2.36 2.38 c 3.37 0.55 8.26 0.02 8.26 -4.61 c 0.0 -4.34 -7.11 -6.2 -9.54 -5.01 l 11.23 -13.41 c -0.26 -0.07 -0.53 -0.08 -0.77 -0.08 Z M 350.06 74.54 c 0.0 0.0 -6.32 14.03 -6.94 15.47 c -0.94 2.13 -2.23 3.69 -4.09 4.24 c 1.64 0.07 3.27 0.1 4.96 0.1 c 3.69 0.0 7.21 -0.17 10.51 -0.5 c 1.21 -0.12 2.21 -1.12 2.36 -2.38 c 0.27 -2.28 0.4 -4.66 0.4 -7.11 c 0.0 -2.45 -0.12 -4.83 -0.4 -7.09 c -0.15 -1.29 -1.14 -2.26 -2.36 -2.38 c -1.44 -0.15 -2.93 -0.27 -4.44 -0.35 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.9999999f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 337.39 138.4 l -6.85 8.12 c 1.78 0.29 4.8 2.54 4.34 5.54 c 0.93 -2.22 -0.77 -4.93 -2.41 -6.03 l 5.98 -7.14 c -0.32 -0.24 -0.57 -0.35 -1.06 -0.49 Z M 335.08 138.97 c -0.27 0.0 -0.47 0.04 -0.46 0.04 l -2.19 2.51 c -1.23 0.07 -2.42 0.15 -3.59 0.27 c -0.83 0.08 -1.48 0.74 -1.6 1.62 c -0.17 1.53 -0.25 3.15 -0.25 4.82 c 0.0 1.67 0.08 3.28 0.25 4.83 c 0.12 0.98 0.77 1.47 1.6 1.62 c 2.29 0.37 5.61 0.02 5.61 -3.13 c 0.0 -2.95 -4.83 -4.21 -6.48 -3.4 l 7.63 -9.11 c -0.18 -0.04 -0.36 -0.06 -0.52 -0.06 Z M 340.12 141.55 c 0.0 0.0 -4.29 9.53 -4.71 10.51 c -0.64 1.45 -1.52 2.51 -2.78 2.88 c 1.11 0.05 2.22 0.07 3.37 0.07 c 2.51 0.0 4.9 -0.12 7.14 -0.34 c 0.82 -0.08 1.5 -0.76 1.6 -1.62 c 0.19 -1.55 0.27 -3.17 0.27 -4.83 c 0.0 -1.67 -0.08 -3.28 -0.27 -4.82 c -0.1 -0.88 -0.77 -1.53 -1.6 -1.62 c -0.98 -0.1 -1.99 -0.19 -3.01 -0.24 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.9999999f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 332.93 192.95 l -4.57 5.41 c 1.19 0.19 3.2 1.7 2.9 3.69 c 0.62 -1.48 -0.52 -3.29 -1.61 -4.02 l 3.99 -4.76 c -0.21 -0.16 -0.38 -0.24 -0.71 -0.33 Z M 331.39 193.33 c -0.18 0.0 -0.31 0.03 -0.3 0.03 l -1.46 1.67 c -0.82 0.04 -1.62 0.1 -2.39 0.18 c -0.55 0.06 -0.99 0.49 -1.07 1.08 c -0.11 1.02 -0.17 2.1 -0.17 3.21 c 0.0 1.11 0.06 2.19 0.17 3.22 c 0.08 0.65 0.52 0.98 1.07 1.08 c 1.53 0.25 3.74 0.01 3.74 -2.09 c 0.0 -1.96 -3.22 -2.81 -4.32 -2.27 l 5.09 -6.07 c -0.12 -0.03 -0.24 -0.04 -0.35 -0.04 Z M 334.74 195.05 c 0.0 0.0 -2.86 6.35 -3.14 7.0 c -0.43 0.97 -1.01 1.67 -1.85 1.92 c 0.74 0.03 1.48 0.04 2.25 0.04 c 1.67 0.0 3.27 -0.08 4.76 -0.22 c 0.55 -0.06 1.0 -0.51 1.07 -1.08 c 0.12 -1.03 0.18 -2.11 0.18 -3.22 c 0.0 -1.11 -0.06 -2.19 -0.18 -3.21 c -0.07 -0.58 -0.52 -1.02 -1.07 -1.08 c -0.65 -0.07 -1.32 -0.12 -2.01 -0.16 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.99999994f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 328.63 239.64 l -3.05 3.61 c 0.79 0.13 2.13 1.13 1.93 2.46 c 0.41 -0.99 -0.34 -2.19 -1.07 -2.68 l 2.66 -3.17 c -0.14 -0.1 -0.25 -0.16 -0.47 -0.22 Z M 327.61 239.89 c -0.12 0.0 -0.21 0.02 -0.2 0.02 l -0.97 1.12 c -0.55 0.03 -1.08 0.07 -1.59 0.12 c -0.37 0.04 -0.66 0.33 -0.71 0.72 c -0.07 0.68 -0.11 1.4 -0.11 2.14 c 0.0 0.74 0.04 1.46 0.11 2.15 c 0.05 0.43 0.34 0.65 0.71 0.72 c 1.02 0.16 2.49 0.01 2.49 -1.39 c 0.0 -1.31 -2.15 -1.87 -2.88 -1.51 l 3.39 -4.05 c -0.08 -0.02 -0.16 -0.03 -0.23 -0.03 Z M 329.84 241.04 c 0.0 0.0 -1.91 4.24 -2.1 4.67 c -0.28 0.64 -0.67 1.12 -1.23 1.28 c 0.49 0.02 0.99 0.03 1.5 0.03 c 1.11 0.0 2.18 -0.05 3.17 -0.15 c 0.37 -0.04 0.67 -0.34 0.71 -0.72 c 0.08 -0.69 0.12 -1.41 0.12 -2.15 c 0.0 -0.74 -0.04 -1.46 -0.12 -2.14 c -0.04 -0.39 -0.34 -0.68 -0.71 -0.72 c -0.43 -0.04 -0.88 -0.08 -1.34 -0.1 Z")
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
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(344f, 61f),
                    end = Offset(344f, 107f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.73 61.5 c -2.21 0.0 -3.95 0.05 -5.33 0.29 c -1.38 0.23 -2.45 0.65 -3.21 1.42 c -0.77 0.76 -1.19 1.82 -1.42 3.21 c -0.23 1.38 -0.28 3.12 -0.27 5.34 V 84.0 V 96.25 c -0.01 2.22 0.04 3.95 0.27 5.34 c 0.23 1.38 0.65 2.44 1.42 3.21 c 0.77 0.76 1.83 1.19 3.21 1.42 c 1.38 0.23 3.12 0.29 5.33 0.29 h 16.54 c 2.21 0.0 3.94 -0.05 5.33 -0.29 c 1.38 -0.23 2.44 -0.65 3.2 -1.42 c 0.76 -0.76 1.18 -1.82 1.42 -3.21 c 0.23 -1.38 0.29 -3.12 0.29 -5.34 V 84.0 V 71.75 c 0.0 -2.22 -0.05 -3.95 -0.29 -5.34 c -0.23 -1.38 -0.65 -2.44 -1.42 -3.21 c -0.76 -0.76 -1.82 -1.19 -3.2 -1.42 C 356.21 61.55 354.48 61.5 352.27 61.5 Z")
            )
        }.build()

        return _ApplicationPostscript!!
    }

@Suppress("ObjectPropertyName")
private var _ApplicationPostscript: ImageVector? = null
