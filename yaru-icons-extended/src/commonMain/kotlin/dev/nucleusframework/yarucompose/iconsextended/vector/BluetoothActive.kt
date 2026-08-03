package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val BluetoothActive: ImageVector
    get() {
        if (_BluetoothActive != null) {
            return _BluetoothActive!!
        }
        _BluetoothActive = ImageVector.Builder(
            name = "BluetoothActive",
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
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.0202878f,
                pathData = addPathNodes("M 101.81 42.0 C 65.71 42.0 61.83 45.69 62.01 81.69 V 156.0 V 230.31 C 61.83 266.31 65.71 270.0 101.81 270.0 h 100.39 c 36.1 0.0 39.81 -3.69 39.81 -39.69 V 156.0 V 81.69 C 242.01 45.69 238.3 42.0 202.2 42.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF5884F4),
                        1f to Color(0xFF80A3FA)
                    ),
                    start = Offset(102.92f, 44f),
                    end = Offset(201.08f, 266f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 201.07 44.0 c 35.3 0.0 39.09 3.63 38.92 38.99 V 156.0 V 229.01 C 240.17 264.37 236.37 268.0 201.07 268.0 H 102.92 C 67.62 268.0 63.99 264.38 63.99 229.01 V 156.0 V 82.99 C 63.99 47.62 67.62 44.0 102.92 44.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 148.0 44.0 v 224.0 h 53.07 c 35.3 0.0 39.09 -3.63 38.92 -38.99 V 156.0 V 82.99 C 240.17 47.63 236.37 44.0 201.07 44.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.87 189.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 V 201.0 v 6.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 C 341.98 209.14 342.0 208.25 342.0 207.13 V 201.0 V 194.88 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 C 338.15 189.02 337.25 189.0 336.13 189.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 325.1 237.0 c -0.72 0.0 -1.3 0.01 -1.84 0.1 c -0.53 0.09 -1.07 0.28 -1.48 0.68 c -0.41 0.41 -0.6 0.94 -0.69 1.48 c -0.09 0.54 -0.1 1.12 -0.1 1.84 V 244.0 v 3.9 c -0.0 0.72 0.01 1.3 0.1 1.84 c 0.09 0.54 0.28 1.07 0.69 1.48 c 0.41 0.41 0.94 0.59 1.48 0.68 c 0.53 0.09 1.12 0.1 1.84 0.1 h 5.81 c 0.72 0.0 1.3 -0.01 1.83 -0.1 c 0.53 -0.09 1.07 -0.28 1.47 -0.69 c 0.41 -0.41 0.59 -0.94 0.68 -1.48 C 334.99 249.2 335.0 248.62 335.0 247.9 V 244.0 V 241.1 c 0.0 -0.72 -0.01 -1.3 -0.1 -1.84 c -0.09 -0.53 -0.28 -1.07 -0.68 -1.48 c -0.41 -0.41 -0.94 -0.6 -1.47 -0.69 C 332.2 237.01 331.62 237.0 330.9 237.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 330.19 134.0 c -1.42 0.0 -2.55 0.03 -3.51 0.19 c -0.96 0.16 -1.79 0.47 -2.41 1.09 c -0.62 0.62 -0.94 1.46 -1.1 2.41 c -0.16 0.96 -0.19 2.09 -0.18 3.51 V 149.0 v 7.8 c -0.01 1.42 0.02 2.55 0.18 3.51 c 0.16 0.96 0.48 1.79 1.1 2.41 c 0.62 0.62 1.46 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 11.62 c 1.42 0.0 2.55 -0.03 3.5 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 C 348.97 159.35 349.0 158.22 349.0 156.8 V 149.0 V 141.2 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.51 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.45 -0.93 -2.41 -1.09 C 344.36 134.03 343.23 134.0 341.81 134.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.23 61.5 c -2.22 0.0 -3.97 0.05 -5.41 0.29 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.32 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.2 -0.28 5.42 V 85.0 V 97.75 c -0.01 2.23 0.04 3.98 0.28 5.42 c 0.24 1.44 0.7 2.62 1.56 3.48 c 0.86 0.86 2.04 1.31 3.48 1.56 c 1.44 0.24 3.19 0.29 5.41 0.29 h 17.54 c 2.22 0.0 3.97 -0.05 5.41 -0.29 c 1.44 -0.24 2.61 -0.7 3.47 -1.56 c 0.86 -0.86 1.31 -2.04 1.55 -3.48 c 0.24 -1.44 0.29 -3.19 0.29 -5.42 V 85.0 V 72.25 c 0.0 -2.23 -0.05 -3.98 -0.29 -5.42 c -0.24 -1.44 -0.69 -2.62 -1.55 -3.48 c -0.86 -0.86 -2.04 -1.32 -3.47 -1.56 c -1.44 -0.24 -3.19 -0.29 -5.41 -0.29 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF5884F4),
                        1f to Color(0xFF80A3FA)
                    ),
                    start = Offset(335.23f, 61.5f),
                    end = Offset(352.27f, 106f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.23 61.5 c -8.23 0.0 -9.77 0.91 -9.73 9.75 V 84.0 V 96.75 c -0.04 8.84 1.5 9.75 9.73 9.75 h 17.54 c 8.23 0.0 9.73 -0.91 9.73 -9.75 V 84.0 V 71.25 c 0.0 -8.84 -1.5 -9.75 -9.73 -9.75 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF5884F4),
                        1f to Color(0xFF80A3FA)
                    ),
                    start = Offset(327.64f, 188.5f),
                    end = Offset(336.36f, 211.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.64 188.5 c -4.66 0.0 -5.16 0.47 -5.14 5.1 v 6.4 v 6.4 c -0.02 4.62 0.48 5.1 5.14 5.1 h 8.73 c 4.66 0.0 5.14 -0.47 5.14 -5.1 v -6.4 v -6.4 c 0.0 -4.62 -0.48 -5.1 -5.14 -5.1 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF5884F4),
                        1f to Color(0xFF80A3FA)
                    ),
                    start = Offset(324.85f, 236.5f),
                    end = Offset(331.15f, 251.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 324.85 236.5 c -3.04 0.0 -3.37 0.31 -3.35 3.32 v 4.18 v 4.18 c -0.01 3.01 0.31 3.32 3.35 3.32 h 6.29 c 3.04 0.0 3.35 -0.31 3.35 -3.32 v -4.18 v -4.18 c 0.0 -3.01 -0.31 -3.32 -3.35 -3.32 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF5884F4),
                        1f to Color(0xFF80A3FA)
                    ),
                    start = Offset(330.08f, 133.5f),
                    end = Offset(341.93f, 162.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.08 133.5 c -5.56 0.0 -6.6 0.58 -6.57 6.28 v 8.22 v 8.22 c -0.03 5.7 1.01 6.28 6.57 6.28 h 11.85 c 5.56 0.0 6.57 -0.58 6.57 -6.28 v -8.22 v -8.22 c 0.0 -5.7 -1.01 -6.28 -6.57 -6.28 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 343.0 61.5 v 45.0 h 9.77 c 8.23 0.0 9.73 -0.91 9.73 -9.75 V 84.0 V 71.25 C 362.5 62.41 361.0 61.5 352.77 61.5 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 336.0 134.0 v 28.0 h 5.51 C 347.4 162.0 348.0 161.42 348.0 155.8 V 148.0 V 140.2 C 348.0 134.58 347.4 134.0 341.51 134.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 332.0 188.5 v 23.0 h 4.37 c 4.66 0.0 5.13 -0.47 5.13 -5.1 V 200.0 V 193.6 c 0.0 -4.62 -0.48 -5.1 -5.13 -5.1 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 328.0 236.5 v 15.0 h 3.15 c 3.04 0.0 3.35 -0.31 3.35 -3.32 V 244.0 V 239.82 c 0.0 -3.01 -0.31 -3.32 -3.35 -3.32 Z")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Square,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 338.01 90.0 l 12.0 -12.0 l -6.0 -6.0 v 24.0 l 6.0 -6.0 l -12.0 -12.0 v 0.0")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Square,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 114.01 190.0 l 76.0 -72.0 l -38.0 -38.0 V 228.0 l 38.0 -38.0 l -76.0 -72.0")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 329.51 203.0 l 6.0 -5.5 l -3.0 -3.0 v 11.5 l 3.0 -3.0 l -6.0 -5.5")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 326.51 246.0 l 4.0 -3.5 l -2.0 -2.0 v 7.5 l 2.0 -2.0 l -4.0 -3.5")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 332.51 152.0 l 8.0 -7.5 l -4.0 -4.0 v 15.5 l 4.0 -4.0 l -8.0 -7.5")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.23 61.5 c -8.23 0.0 -9.77 0.91 -9.73 9.75 V 84.0 V 96.75 c -0.04 8.84 1.5 9.75 9.73 9.75 h 17.54 c 8.23 0.0 9.73 -0.91 9.73 -9.75 V 84.0 V 71.25 c 0.0 -8.84 -1.5 -9.75 -9.73 -9.75 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.08 133.5 c -5.56 0.0 -6.6 0.58 -6.57 6.28 v 8.22 v 8.22 c -0.03 5.7 1.01 6.28 6.57 6.28 h 11.85 c 5.56 0.0 6.57 -0.58 6.57 -6.28 v -8.22 v -8.22 c 0.0 -5.7 -1.01 -6.28 -6.57 -6.28 Z")
            )
            group(
                clipPathData = addPathNodes("m 330.49 134.0 c -5.88 0.0 -6.52 0.58 -6.49 6.2 L 324.0 148.0 L 324.0 155.8 c -0.03 5.63 0.6 6.2 6.49 6.2 l 11.03 0.0 c 5.88 0.0 6.49 -0.58 6.49 -6.2 L 348.0 148.0 L 348.0 140.2 C 348.0 134.58 347.4 134.0 341.51 134.0 Z")
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
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 330.49 134.0 c -5.88 0.0 -6.52 0.58 -6.49 6.2 L 324.0 148.0 L 324.0 155.8 c -0.03 5.63 0.6 6.2 6.49 6.2 l 11.03 0.0 c 5.88 0.0 6.49 -0.58 6.49 -6.2 L 348.0 148.0 L 348.0 140.2 C 348.0 134.58 347.4 134.0 341.51 134.0 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 V 84.0 V 96.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 V 84.0 V 71.75 C 362.0 62.91 361.09 62.0 352.27 62.0 Z")
            ) {
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
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 V 84.0 V 96.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 V 84.0 V 71.75 C 362.0 62.91 361.09 62.0 352.27 62.0 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 V 200.0 V 206.13 C 322.98 210.55 323.45 211.0 327.87 211.0 h 8.27 C 340.55 211.0 341.0 210.55 341.0 206.13 V 200.0 V 193.87 C 341.0 189.45 340.55 189.0 336.13 189.0 Z")
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
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 V 200.0 V 206.13 C 322.98 210.55 323.45 211.0 327.87 211.0 h 8.27 C 340.55 211.0 341.0 210.55 341.0 206.13 V 200.0 V 193.87 C 341.0 189.45 340.55 189.0 336.13 189.0 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 324.85 236.5 c -3.04 0.0 -3.37 0.31 -3.35 3.32 L 321.5 244.0 l 0.0 4.18 c -0.01 3.01 0.31 3.32 3.35 3.32 l 6.29 0.0 C 334.19 251.5 334.5 251.19 334.5 248.18 L 334.5 244.0 L 334.5 239.82 C 334.5 236.81 334.19 236.5 331.15 236.5 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(328f, 236.5f),
                        end = Offset(328f, 251.5f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 324.85 236.5 c -3.04 0.0 -3.37 0.31 -3.35 3.32 L 321.5 244.0 l 0.0 4.18 c -0.01 3.01 0.31 3.32 3.35 3.32 l 6.29 0.0 C 334.19 251.5 334.5 251.19 334.5 248.18 L 334.5 244.0 L 334.5 239.82 C 334.5 236.81 334.19 236.5 331.15 236.5 Z")
                )
            }
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9765289f,
                pathData = addPathNodes("m 336.51 211.51 c 4.23 0.0 5.02 -0.46 5.0 -4.99 v -6.52 v -6.52 c 0.02 -4.52 -0.77 -4.99 -5.0 -4.99 h -9.02 c -4.23 0.0 -5.0 0.46 -5.0 4.99 v 6.52 v 6.52 c 0.0 4.52 0.77 4.99 5.0 4.99 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9765289f,
                pathData = addPathNodes("m 331.09 251.51 c 2.9 0.0 3.44 -0.3 3.42 -3.25 v -4.26 v -4.26 c 0.02 -2.95 -0.53 -3.25 -3.42 -3.25 h -6.17 c -2.9 0.0 -3.42 0.3 -3.42 3.25 v 4.26 v 4.26 c 0.0 2.95 0.53 3.25 3.42 3.25 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.93 268.0 c -35.3 0.0 -39.09 -3.63 -38.92 -38.99 v -2.0 C 63.83 262.37 67.63 266.0 102.93 266.0 h 98.16 c 35.3 0.0 38.92 -3.63 38.92 -38.99 v 2.0 C 240.01 264.37 236.38 268.0 201.08 268.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 44.0 C 67.63 44.0 63.83 47.63 64.0 82.99 v 2.0 C 63.83 49.63 67.63 46.0 102.92 46.0 h 98.16 C 236.37 46.0 240.0 49.63 240.0 84.99 v -2.0 C 240.0 47.63 236.37 44.0 201.08 44.0 Z")
            )
        }.build()

        return _BluetoothActive!!
    }

@Suppress("ObjectPropertyName")
private var _BluetoothActive: ImageVector? = null
