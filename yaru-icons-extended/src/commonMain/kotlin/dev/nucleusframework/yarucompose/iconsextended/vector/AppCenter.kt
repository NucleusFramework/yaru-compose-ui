package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.unit.dp

val AppCenter: ImageVector
    get() {
        if (_AppCenter != null) {
            return _AppCenter!!
        }
        _AppCenter = ImageVector.Builder(
            name = "AppCenter",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.91 46.0 c -35.3 0.0 -36.99 3.68 -38.92 38.99 l -8.0 146.01 C 54.05 266.32 59.61 270.0 94.91 270.0 h 57.08 h 0.01 h 57.08 c 35.3 0.0 40.86 -3.68 38.92 -38.99 L 239.99 84.99 c -1.93 -35.32 -3.63 -38.99 -38.92 -38.99 h -49.08 h -0.01 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.91 46.0 C 67.61 46.0 65.92 49.68 63.99 84.99 l -8.0 146.01 C 54.05 266.32 59.61 270.0 94.91 270.0 h 57.08 h 0.01 h 57.08 c 35.3 0.0 40.86 -3.68 38.92 -38.99 L 239.99 84.99 C 238.06 49.68 236.37 46.0 201.07 46.0 h -49.08 h -0.01 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(176.53f, 266f),
                    end = Offset(110.91f, 46f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 44.0 C 67.62 44.0 65.93 47.68 63.99 82.99 l -8.0 146.01 C 54.06 264.32 59.62 268.0 94.92 268.0 h 57.08 h 0.01 h 57.08 c 35.3 0.0 40.86 -3.68 38.92 -38.99 L 240.0 82.99 C 238.07 47.68 236.37 44.0 201.08 44.0 H 152.0 h -0.01 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(176.88f, 266f),
                    end = Offset(111.25f, 46f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 103.26 44.0 C 67.96 44.0 66.27 47.68 64.34 82.99 l -8.0 146.01 C 54.4 264.32 59.96 268.0 95.26 268.0 h 57.08 h 0.01 h 57.08 c 35.3 0.0 40.86 -3.68 38.92 -38.99 L 240.34 82.99 C 238.41 47.68 236.72 44.0 201.42 44.0 h -49.08 h -0.01 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 328.87 189.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 L 322.0 206.12 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.78 0.25 -1.68 0.15 -2.79 l -1.0 -11.25 c -0.1 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 C 337.15 189.02 336.25 189.0 335.13 189.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 325.7 237.0 c -0.72 0.0 -1.3 0.01 -1.84 0.1 c -0.53 0.09 -1.07 0.28 -1.48 0.68 c -0.41 0.41 -0.6 0.94 -0.69 1.48 c -0.09 0.54 -0.1 1.12 -0.1 1.84 l -0.6 6.79 c -0.0 0.72 0.01 1.3 0.1 1.84 c 0.09 0.54 0.28 1.07 0.69 1.48 c 0.41 0.41 0.94 0.59 1.48 0.68 c 0.53 0.09 1.12 0.1 1.84 0.1 h 5.81 c 0.72 0.0 1.3 -0.01 1.83 -0.1 c 0.53 -0.09 1.07 -0.28 1.47 -0.69 c 0.41 -0.41 0.59 -0.94 0.68 -1.48 c 0.16 -0.98 -0.44 -9.49 -0.6 -10.47 c -0.09 -0.53 -0.28 -1.07 -0.68 -1.48 c -0.41 -0.41 -0.94 -0.6 -1.47 -0.69 C 331.6 237.01 331.02 237.0 330.3 237.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 331.19 134.0 c -1.42 0.0 -2.55 0.03 -3.51 0.19 c -0.96 0.16 -1.79 0.47 -2.41 1.09 c -0.62 0.62 -0.94 1.46 -1.1 2.41 c -0.16 0.96 -0.19 2.09 -0.18 3.51 L 323.0 156.8 c -0.01 1.42 0.02 2.55 0.18 3.51 c 0.16 0.96 0.48 1.79 1.1 2.41 c 0.62 0.62 1.46 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 11.62 c 1.42 0.0 2.55 -0.03 3.5 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 C 348.97 159.35 349.0 158.22 349.0 156.8 l -1.0 -15.59 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.51 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.45 -0.93 -2.41 -1.09 C 343.36 134.03 342.23 134.0 340.81 134.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                pathData = addPathNodes("m 336.35 62.0 c -2.07 0.0 -3.68 0.06 -4.98 0.29 c -1.3 0.24 -2.32 0.67 -3.06 1.43 c -1.5 1.52 -1.84 4.07 -2.18 8.49 l -2.0 25.5 c -0.17 2.22 -0.17 3.97 0.08 5.37 c 0.25 1.4 0.77 2.47 1.61 3.22 c 1.68 1.51 4.41 1.7 8.54 1.7 H 343.0 h 2.12 h 8.65 c 4.13 0.0 6.86 -0.19 8.54 -1.7 c 0.84 -0.75 1.36 -1.82 1.61 -3.22 c 0.25 -1.4 0.25 -3.14 0.08 -5.37 l -2.0 -25.5 c -0.35 -4.42 -0.68 -6.97 -2.18 -8.49 c -0.75 -0.76 -1.76 -1.19 -3.06 -1.43 C 355.45 62.06 353.84 62.0 351.77 62.0 H 345.12 H 343.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(353.27f, 106f),
                    end = Offset(336.93f, 63.09f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 336.35 61.5 C 328.12 61.5 327.31 62.43 326.62 71.25 L 324.62 96.75 C 323.93 105.57 326.12 106.5 334.35 106.5 L 343.0 106.5 L 345.12 106.5 L 353.77 106.5 C 362.0 106.5 364.19 105.57 363.5 96.75 L 361.5 71.25 C 360.81 62.43 360.0 61.5 351.77 61.5 L 345.12 61.5 L 343.0 61.5 L 336.35 61.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(353.27f, 106f),
                    end = Offset(336.93f, 63.09f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 336.35 61.5 c -8.23 0.0 -9.04 0.93 -9.73 9.75 l -2.0 25.5 C 323.93 105.57 326.12 106.5 334.35 106.5 H 343.0 h 2.12 h 8.65 c 8.23 0.0 10.42 -0.93 9.73 -9.75 L 361.5 71.25 C 360.81 62.43 360.0 61.5 351.77 61.5 H 345.12 H 343.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(353.27f, 106f),
                    end = Offset(336.93f, 63.09f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 336.35 61.5 c -8.23 0.0 -9.04 0.93 -9.73 9.75 l -2.0 25.5 c -0.69 8.82 1.5 9.75 9.73 9.75 h 8.65 h 2.12 h 8.65 c 8.23 0.0 10.42 -0.93 9.73 -9.75 L 361.5 71.25 C 360.81 62.43 360.0 61.5 351.77 61.5 h -6.65 h -2.12 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFBD3C1),
                        1f to Color(0x00F9B598)
                    ),
                    start = Offset(336f, 76f),
                    end = Offset(347f, 106f)
                ),
                fillAlpha = 0.15f,
                strokeAlpha = 0.15f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.25 76.0 L 324.62 96.75 C 323.93 105.57 326.12 106.5 334.35 106.5 L 343.0 106.5 L 345.12 106.5 L 353.77 106.5 C 362.0 106.5 364.2 105.57 363.5 96.75 L 361.88 76.0 L 326.25 76.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(334.85f, 211f),
                    end = Offset(328.5f, 189f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.64 188.5 c -4.66 0.0 -4.89 0.5 -5.14 5.1 l -1.0 12.81 c -0.02 4.62 0.48 5.1 5.14 5.1 h 8.73 c 4.66 0.0 5.5 -0.49 5.14 -5.1 l -1.0 -12.81 c -0.36 -4.61 -0.48 -5.1 -5.14 -5.1 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFF9F2)),
                strokeLineWidth = 0.649351f,
                pathData = addPathNodes("m 331.0 199.0 l -4.0 10.0 h 2.0 l 0.94 -2.24 L 334.0 206.7 L 335.0 209.0 h 2.0 l -4.0 -10.0 Z M 333.64 205.62 L 330.33 205.81 L 332.0 201.36 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 333.0 199.0 l -1.0 2.36 L 335.0 209.0 h 2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF8F8F8)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 327.71 205.0 L 336.29 205.0 A 1.21 0.94 0.0 0 1 337.5 205.94 L 337.5 206.06 A 1.21 0.94 0.0 0 1 336.29 207.0 L 327.71 207.0 A 1.21 0.94 0.0 0 1 326.5 206.06 L 326.5 205.94 A 1.21 0.94 0.0 0 1 327.71 205.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.75 205.6 c -0.28 0.0 -0.5 0.17 -0.5 0.37 c 0.0 0.21 0.22 0.38 0.5 0.38 h 1.4 h 4.86 h 2.24 c 0.28 0.0 0.5 -0.17 0.5 -0.38 c 0.0 -0.21 -0.22 -0.37 -0.5 -0.37 h -2.24 h -4.86 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.5 192.43 a 1.11 1.08 0.0 1 0 2.22 0.0 a 1.11 1.08 0.0 1 0 -2.22 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.4 192.43 a 1.11 1.08 0.0 1 0 2.22 0.0 a 1.11 1.08 0.0 1 0 -2.22 0.0 Z")
            )
            addPath(
                fillAlpha = 0.15f,
                stroke = SolidColor(Color(0xFF1A1A1A)),
                strokeAlpha = 0.15f,
                strokeLineWidth = 0.999996f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 327.61 192.43 c 0.0 0.0 -0.56 6.18 4.45 6.18 c 5.0 0.0 4.45 -6.18 4.45 -6.18")
            )
            addPath(
                stroke = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 0.999997f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 327.61 192.43 c 0.0 0.0 -0.56 5.13 4.45 5.13 c 5.0 0.0 4.45 -5.13 4.45 -5.13")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(331.08f, 251f),
                    end = Offset(325.52f, 236.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.45 236.5 c -3.04 0.0 -3.06 0.5 -3.35 3.32 l -0.6 8.35 c -0.01 3.01 0.31 3.32 3.35 3.32 h 6.29 c 3.04 0.0 3.57 -0.32 3.35 -3.32 l -0.6 -8.35 c -0.21 -2.96 -0.43 -3.32 -3.35 -3.32 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 324.81 239.45 a 0.63 0.62 0.0 1 0 1.26 0.0 a 0.63 0.62 0.0 1 0 -1.26 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 329.86 239.45 a 0.63 0.62 0.0 1 0 1.26 0.0 a 0.63 0.62 0.0 1 0 -1.26 0.0 Z")
            )
            addPath(
                fillAlpha = 0.15f,
                stroke = SolidColor(Color(0xFF1A1A1A)),
                strokeAlpha = 0.15f,
                strokeLineWidth = 0.999999f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 325.44 239.45 c 0.0 0.0 -0.32 3.98 2.53 3.98 c 2.84 0.0 2.53 -3.98 2.53 -3.98")
            )
            addPath(
                stroke = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 325.44 239.45 c 0.0 0.0 -0.32 2.98 2.53 2.98 c 2.84 0.0 2.53 -2.98 2.53 -2.98")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF37E40),
                        1f to Color(0xFFF34F17)
                    ),
                    start = Offset(341f, 162f),
                    end = Offset(331f, 134f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 330.13 133.5 C 324.56 133.5 323.55 134.08 323.55 139.78 L 322.55 156.22 C 322.55 161.92 323.56 162.5 329.13 162.5 L 335.0 162.5 L 336.05 162.5 L 341.93 162.5 C 347.49 162.5 348.5 161.92 348.5 156.22 L 347.5 139.78 C 347.5 134.08 346.49 133.5 340.93 133.5 L 336.05 133.5 L 335.0 133.5 L 330.13 133.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFBD3C1),
                        1f to Color(0x00F9B598)
                    ),
                    start = Offset(332f, 146f),
                    end = Offset(340f, 161f)
                ),
                fillAlpha = 0.15f,
                strokeAlpha = 0.15f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 323.28 145.15 L 322.5 156.22 c 0.0 5.7 1.01 6.28 6.57 6.28 h 5.88 h 1.05 h 5.88 c 5.56 0.0 6.57 -0.58 6.57 -6.28 L 347.77 145.15 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                pathData = addPathNodes("M 330.13 133.0 C 327.33 133.0 325.56 133.1 324.42 134.13 C 323.85 134.65 323.5 135.37 323.31 136.29 C 323.11 137.2 323.05 138.33 323.05 139.75 L 322.05 156.2 L 322.05 156.22 C 322.05 157.66 322.11 158.79 322.31 159.71 C 322.5 160.63 322.85 161.35 323.42 161.87 C 324.56 162.9 326.33 163.0 329.13 163.0 L 335.0 163.0 L 336.05 163.0 L 341.93 163.0 C 344.72 163.0 346.49 162.9 347.63 161.87 C 348.2 161.35 348.55 160.63 348.74 159.71 C 348.94 158.79 349.0 157.66 349.0 156.22 L 349.0 156.2 L 348.0 139.75 C 348.0 138.33 347.94 137.2 347.74 136.29 C 347.55 135.37 347.21 134.65 346.63 134.13 C 345.49 133.1 343.72 133.0 340.93 133.0 L 336.05 133.0 L 335.0 133.0 L 330.13 133.0 Z M 330.13 134.0 L 335.0 134.0 L 336.05 134.0 L 340.93 134.0 C 343.69 134.0 345.21 134.19 345.96 134.88 C 346.34 135.22 346.6 135.71 346.77 136.5 C 346.93 137.29 347.0 138.37 347.0 139.78 L 347.0 139.8 L 348.0 156.23 C 348.0 157.63 347.93 158.71 347.77 159.5 C 347.6 160.29 347.34 160.78 346.96 161.13 C 346.21 161.81 344.69 162.0 341.93 162.0 L 336.05 162.0 L 335.0 162.0 L 329.13 162.0 C 326.36 162.0 324.84 161.81 324.09 161.13 C 323.71 160.78 323.45 160.29 323.29 159.5 C 323.12 158.71 323.05 157.63 323.05 156.23 L 324.05 139.8 L 324.05 139.78 C 324.05 138.37 324.12 137.29 324.29 136.5 C 324.45 135.71 324.71 135.22 325.09 134.88 C 325.84 134.19 327.36 134.0 330.13 134.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(335.05f, 134f),
                    end = Offset(335.05f, 162f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 0.651327f,
                pathData = addPathNodes("M 330.13 134.0 C 327.36 134.0 325.84 134.19 325.09 134.88 C 324.71 135.22 324.45 135.71 324.29 136.5 C 324.12 137.29 324.14 138.38 324.05 139.78 L 323.05 156.22 C 322.97 157.62 323.12 158.71 323.29 159.5 C 323.45 160.29 323.71 160.78 324.09 161.13 C 324.84 161.81 326.36 162.0 329.13 162.0 L 335.0 162.0 L 336.05 162.0 L 341.93 162.0 C 344.69 162.0 346.21 161.81 346.96 161.13 C 347.34 160.78 347.6 160.29 347.77 159.5 C 347.93 158.71 348.09 157.62 348.0 156.22 L 347.0 139.78 C 346.91 138.38 346.93 137.29 346.77 136.5 C 346.6 135.71 346.34 135.22 345.96 134.88 C 345.21 134.19 343.69 134.0 340.93 134.0 L 336.05 134.0 L 335.0 134.0 L 330.13 134.0 Z M 330.54 134.98 L 335.0 134.98 L 336.05 134.98 L 340.51 134.98 C 341.97 134.98 343.07 135.02 343.84 135.14 C 344.61 135.26 345.0 135.45 345.24 135.68 C 345.48 135.91 345.68 136.28 345.8 137.02 C 345.93 137.76 345.89 138.82 345.98 140.2 L 346.98 155.8 C 347.07 157.18 346.93 158.24 346.8 158.98 C 346.68 159.72 346.48 160.09 346.24 160.32 C 346.0 160.55 345.61 160.74 344.84 160.86 C 344.07 160.98 342.97 161.02 341.51 161.02 L 336.05 161.02 L 335.0 161.02 L 329.54 161.02 C 328.08 161.02 326.98 160.98 326.21 160.86 C 325.44 160.74 325.06 160.55 324.81 160.32 C 324.57 160.09 324.38 159.72 324.25 158.98 C 324.12 158.24 323.99 157.18 324.07 155.8 L 325.07 140.2 C 325.16 138.82 325.12 137.76 325.25 137.02 C 325.38 136.28 325.57 135.91 325.81 135.68 C 326.06 135.45 326.44 135.26 327.21 135.14 C 327.98 135.02 329.08 134.98 330.54 134.98 Z M 323.27 136.51 C 323.26 136.57 323.24 136.63 323.23 136.7 C 323.21 136.8 323.2 136.92 323.18 137.02 C 323.21 136.84 323.24 136.67 323.27 136.51 Z M 323.18 137.02 C 323.06 137.88 323.1 138.87 323.03 140.07 L 323.05 139.78 C 323.12 138.71 323.08 137.8 323.18 137.02 Z M 323.03 140.07 L 322.99 140.85 L 323.03 140.2 C 323.03 140.16 323.03 140.11 323.03 140.07 Z M 322.99 140.85 L 322.03 155.8 C 321.95 157.06 322.06 158.09 322.18 158.98 C 322.08 158.2 321.99 157.29 322.05 156.22 L 322.99 140.85 Z M 322.18 158.98 C 322.2 159.08 322.21 159.2 322.23 159.3 C 322.24 159.37 322.26 159.43 322.27 159.49 C 322.24 159.33 322.21 159.16 322.18 158.98 Z M 347.78 136.51 C 347.81 136.67 347.84 136.84 347.87 137.02 C 347.85 136.92 347.84 136.8 347.82 136.7 C 347.81 136.63 347.79 136.57 347.78 136.51 Z M 347.87 137.02 C 347.97 137.8 347.93 138.71 348.0 139.78 L 348.02 140.07 C 347.95 138.87 347.99 137.88 347.87 137.02 Z M 348.02 140.07 C 348.02 140.11 348.02 140.16 348.02 140.2 L 348.06 140.85 L 348.02 140.07 Z M 348.06 140.85 L 349.0 156.22 C 349.07 157.29 348.97 158.2 348.87 158.98 C 348.99 158.09 349.1 157.06 349.02 155.8 L 348.06 140.85 Z M 348.87 158.98 C 348.84 159.16 348.81 159.33 348.78 159.49 C 348.79 159.43 348.81 159.37 348.82 159.3 C 348.84 159.2 348.85 159.08 348.87 158.98 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFBD3C1),
                        1f to Color(0x00F9B598)
                    ),
                    start = Offset(103.41f, 120.5f),
                    end = Offset(124.26f, 194.45f)
                ),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 62.75 112.0 L 56.34 229.01 C 54.4 264.32 59.96 268.0 95.26 268.0 L 152.34 268.0 L 152.34 268.0 L 209.42 268.0 C 244.72 268.0 250.28 264.32 248.34 229.01 L 241.93 112.0 L 62.75 112.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 140.5 130.0 c -4.71 9.81 -9.22 19.76 -13.54 29.83 c -4.32 9.94 -8.7 20.41 -13.15 31.4 c -1.66 4.24 -3.37 8.66 -5.07 13.09 c -1.05 2.4 -2.23 5.27 -4.08 10.23 c -3.1 8.23 -6.63 17.55 -10.09 26.68 c -1.26 3.19 -2.64 6.75 -4.83 12.77 h 14.72 h 11.1 l 12.36 -34.74 l 24.33 -1.06 l 24.33 1.06 L 188.96 254.0 h 11.1 h 14.72 c -2.19 -6.01 -3.57 -9.58 -4.83 -12.77 c -3.46 -9.13 -6.99 -18.45 -10.09 -26.68 c -1.85 -4.96 -3.03 -7.83 -4.08 -10.23 c -1.7 -4.43 -3.41 -8.85 -5.07 -13.09 c -4.45 -10.99 -8.83 -21.46 -13.15 -31.4 C 173.25 149.76 168.73 139.81 164.02 130.0 h -0.39 h -11.11 h -0.52 h -11.11 Z M 152.26 157.04 c 0.09 0.2 0.17 0.4 0.26 0.6 v 0.15 c 3.59 7.98 7.07 16.24 10.41 24.81 c 4.06 10.6 4.11 9.59 8.17 20.97 l -18.84 0.68 l -18.84 -0.68 c 4.06 -11.38 4.11 -10.37 8.17 -20.97 c 3.34 -8.57 6.82 -16.83 10.41 -24.81 v -0.15 c 0.09 -0.2 0.17 -0.4 0.26 -0.6 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 140.5 130.0 c -4.71 9.81 -9.22 19.76 -13.54 29.83 c -4.32 9.94 -8.7 20.41 -13.15 31.4 c -1.66 4.24 -3.37 8.66 -5.07 13.09 c -1.05 2.4 -2.23 5.27 -4.08 10.23 c -3.1 8.23 -6.63 17.55 -10.09 26.68 c -1.26 3.19 -2.64 6.75 -4.83 12.77 h 14.72 h 11.1 l 12.36 -34.74 l 24.33 -1.06 l 24.33 1.06 l 12.36 34.74 h 11.1 h 14.72 c -2.19 -6.01 -3.57 -9.58 -4.83 -12.77 c -3.46 -9.13 -6.99 -18.45 -10.09 -26.68 c -1.85 -4.96 -3.03 -7.83 -4.08 -10.23 c -1.7 -4.43 -3.41 -8.85 -5.07 -13.09 c -4.45 -10.99 -8.83 -21.46 -13.15 -31.4 c -4.32 -10.07 -8.83 -20.02 -13.54 -29.83 h -0.39 h -11.11 h -0.52 h -11.11 Z M 152.26 157.04 c 0.09 0.2 0.17 0.4 0.26 0.6 v 0.15 c 3.59 7.98 7.07 16.24 10.41 24.81 c 4.06 10.6 4.11 9.59 8.17 20.97 l -18.84 0.68 l -18.84 -0.68 c 4.06 -11.38 4.11 -10.37 8.17 -20.97 c 3.34 -8.57 6.82 -16.83 10.41 -24.81 v -0.15 c 0.09 -0.2 0.17 -0.4 0.26 -0.6 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFF9F2)),
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 140.5 128.0 c -4.71 9.81 -9.22 19.76 -13.54 29.83 c -4.32 9.94 -8.7 20.41 -13.15 31.4 c -1.66 4.24 -3.37 8.66 -5.07 13.09 c -1.05 2.4 -2.23 5.27 -4.08 10.23 c -3.1 8.23 -6.63 17.55 -10.09 26.68 c -1.26 3.19 -2.64 6.75 -4.83 12.77 h 14.72 h 11.1 l 12.36 -34.74 l 24.33 -1.06 l 24.33 1.06 L 188.96 252.0 h 11.1 h 14.72 c -2.19 -6.01 -3.57 -9.58 -4.83 -12.77 c -3.46 -9.13 -6.99 -18.45 -10.09 -26.68 c -1.85 -4.96 -3.03 -7.83 -4.08 -10.23 c -1.7 -4.43 -3.41 -8.85 -5.07 -13.09 c -4.45 -10.99 -8.83 -21.46 -13.15 -31.4 C 173.25 147.76 168.73 137.81 164.02 128.0 h -0.39 h -11.11 h -0.52 h -11.11 Z M 152.26 155.04 c 0.09 0.2 0.17 0.4 0.26 0.6 v 0.15 c 3.59 7.98 7.07 16.24 10.41 24.81 c 4.06 10.6 4.11 9.59 8.17 20.97 l -18.84 0.68 l -18.84 -0.68 c 4.06 -11.38 4.11 -10.37 8.17 -20.97 c 3.34 -8.57 6.82 -16.83 10.41 -24.81 v -0.15 c 0.09 -0.2 0.17 -0.4 0.26 -0.6 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 96.0 202.0 L 208.0 202.0 A 12.0 12.0 0.0 0 1 220.0 214.0 L 220.0 214.0 A 12.0 12.0 0.0 0 1 208.0 226.0 L 96.0 226.0 A 12.0 12.0 0.0 0 1 84.0 214.0 L 84.0 214.0 A 12.0 12.0 0.0 0 1 96.0 202.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 163.76 128.35 l -11.05 27.87 c 3.53 7.85 6.94 15.97 10.22 24.38 c 4.06 10.6 4.11 9.59 8.17 20.97 l -6.35 0.23 l 4.41 15.15 l 7.44 0.32 L 188.96 252.0 h 11.1 h 14.72 c -2.19 -6.01 -3.57 -9.58 -4.83 -12.77 c -3.46 -9.13 -6.99 -18.45 -10.09 -26.68 c -1.85 -4.96 -3.03 -7.83 -4.08 -10.23 c -1.7 -4.43 -3.41 -8.85 -5.07 -13.09 c -4.45 -10.99 -8.83 -21.46 -13.15 -31.4 c -3.11 -7.26 -6.33 -14.46 -9.65 -21.58 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 96.0 200.0 L 208.0 200.0 A 12.0 12.0 0.0 0 1 220.0 212.0 L 220.0 212.0 A 12.0 12.0 0.0 0 1 208.0 224.0 L 96.0 224.0 A 12.0 12.0 0.0 0 1 84.0 212.0 L 84.0 212.0 A 12.0 12.0 0.0 0 1 96.0 200.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 96.0 208.0 c -2.22 0.0 -4.0 1.78 -4.0 4.0 c 0.0 2.22 1.78 4.0 4.0 4.0 h 39.62 h 32.38 h 40.38 c 2.01 0.0 3.63 -1.62 3.63 -3.63 v -0.75 c 0.0 -2.01 -1.62 -3.63 -3.63 -3.63 h -40.38 h -32.38 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFD74612),
                        1f to Color(0x00D74612)
                    ),
                    start = Offset(152f, 112f),
                    end = Offset(152.34f, 88f)
                ),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 64.06 88.0 L 62.75 112.0 L 241.93 112.0 L 240.62 88.0 L 64.06 88.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 66.0 m -2.0 0.0 a 2.0 2.0 0.0 1 1 4.0 0.0 a 2.0 2.0 0.0 1 1 -4.0 0.0")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 352.0 66.0 m -2.0 0.0 a 2.0 2.0 0.0 1 1 4.0 0.0 a 2.0 2.0 0.0 1 1 -4.0 0.0")
            )
            addPath(
                fillAlpha = 0.15f,
                stroke = SolidColor(Color(0xFF1A1A1A)),
                strokeAlpha = 0.15f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.0 66.0 c 0.0 0.0 -1.0 11.0 8.0 11.0 c 9.0 0.0 8.0 -11.0 8.0 -11.0")
            )
            addPath(
                stroke = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.0 66.0 c 0.0 0.0 -1.0 9.0 8.0 9.0 c 9.0 0.0 8.0 -9.0 8.0 -9.0")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 329.5 137.5 m -1.5 0.0 a 1.5 1.5 0.0 1 1 3.0 0.0 a 1.5 1.5 0.0 1 1 -3.0 0.0")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.5 137.5 m -1.5 0.0 a 1.5 1.5 0.0 1 1 3.0 0.0 a 1.5 1.5 0.0 1 1 -3.0 0.0")
            )
            addPath(
                fillAlpha = 0.15f,
                stroke = SolidColor(Color(0xFF1A1A1A)),
                strokeAlpha = 0.15f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.5 137.5 c 0.0 0.0 -0.75 8.05 6.0 8.05 c 6.75 0.0 6.0 -8.05 6.0 -8.05")
            )
            addPath(
                stroke = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.5 137.5 c 0.0 0.0 -0.75 7.15 6.0 7.15 c 6.75 0.0 6.0 -7.15 6.0 -7.15")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 341.38 79.0 c -0.97 2.02 -1.7 3.47 -2.59 5.54 c -0.89 2.05 -1.79 4.2 -2.71 6.46 c -0.34 0.87 -0.69 1.78 -1.04 2.7 c -0.22 0.49 -0.46 1.09 -0.84 2.11 c -0.64 1.69 -1.07 2.71 -1.78 4.59 c -0.26 0.66 -0.54 1.39 -0.99 2.63 h 3.03 h 2.29 l 2.25 -6.25 l 5.01 -0.22 l 3.48 0.15 l 1.53 0.07 l 2.25 6.25 h 2.29 h 3.03 c -0.45 -1.24 -0.73 -1.97 -0.99 -2.63 c -0.71 -1.88 -1.14 -2.9 -1.78 -4.59 c -0.38 -1.02 -0.62 -1.61 -0.84 -2.11 c -0.35 -0.91 -0.7 -1.82 -1.04 -2.7 c -0.92 -2.26 -1.62 -3.82 -2.51 -5.86 c -0.58 -1.35 -1.18 -2.68 -1.79 -4.01 c -0.07 -0.14 -0.13 -0.29 -0.2 -0.44 l -0.08 -0.14 c -0.24 -0.52 -0.48 -1.04 -0.72 -1.55 h -0.08 h -2.69 h -0.11 h -2.29 Z M 344.0 83.97 c 0.02 0.04 0.04 0.08 0.05 0.12 v 0.03 c 0.74 1.64 1.46 3.34 2.14 5.11 c 0.42 1.09 0.63 1.58 0.84 2.1 c 0.21 0.51 0.42 1.05 0.84 2.22 l -1.25 0.05 l -0.06 0.0 l -2.57 0.09 l -3.88 -0.14 c 0.83 -2.34 0.85 -2.14 1.68 -4.32 c 0.69 -1.76 1.4 -3.46 2.14 -5.11 v -0.03 c 0.02 -0.04 0.04 -0.08 0.05 -0.12 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFF9F2)),
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 341.38 78.0 c -0.97 2.02 -1.7 3.47 -2.59 5.54 c -0.89 2.05 -1.79 4.2 -2.71 6.46 c -0.34 0.87 -0.69 1.78 -1.04 2.7 c -0.22 0.49 -0.46 1.08 -0.84 2.11 c -0.64 1.69 -1.07 2.71 -1.78 4.59 c -0.26 0.66 -0.54 1.39 -0.99 2.63 h 3.03 h 2.29 l 2.25 -6.25 l 5.01 -0.22 l 5.01 0.22 l 2.25 6.25 h 2.29 h 3.03 c -0.45 -1.24 -0.73 -1.97 -0.99 -2.63 c -0.71 -1.88 -1.14 -2.9 -1.78 -4.59 c -0.38 -1.02 -0.62 -1.61 -0.84 -2.11 c -0.35 -0.91 -0.7 -1.82 -1.04 -2.7 c -0.92 -2.26 -1.62 -3.82 -2.51 -5.86 C 348.52 82.07 347.59 80.02 346.62 78.0 h -0.08 l -2.69 0.0 h -0.11 l -2.29 0.0 Z M 344.0 82.97 c 0.02 0.04 0.04 0.08 0.05 0.12 v 0.03 c 0.74 1.64 1.46 3.34 2.14 5.11 c 0.84 2.18 0.85 1.97 1.68 4.32 l -3.88 0.14 l -3.88 -0.14 c 0.83 -2.34 0.85 -2.14 1.68 -4.32 c 0.69 -1.76 1.4 -3.46 2.14 -5.11 v -0.03 c 0.02 -0.04 0.04 -0.08 0.05 -0.12 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("m 346.57 78.07 l -2.57 4.86 c 0.73 1.62 1.52 3.57 2.2 5.3 c 0.84 2.18 0.85 1.97 1.68 4.32 l -1.31 0.05 l 0.91 3.12 l 1.53 0.07 l 2.25 6.25 h 2.29 h 3.03 c -0.45 -1.24 -0.73 -1.97 -0.99 -2.63 c -0.71 -1.88 -1.14 -2.9 -1.78 -4.59 c -0.38 -1.02 -0.62 -1.61 -0.84 -2.11 c -0.35 -0.91 -0.7 -1.82 -1.04 -2.7 c -0.92 -2.26 -1.62 -3.82 -2.51 -5.86 c -0.64 -1.5 -1.3 -2.98 -1.99 -4.44 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 332.42 92.93 L 355.48 92.93 A 2.47 2.5 0.0 0 1 357.95 95.43 L 357.95 95.43 A 2.47 2.5 0.0 0 1 355.48 97.93 L 332.42 97.93 A 2.47 2.5 0.0 0 1 329.95 95.43 L 329.95 95.43 A 2.47 2.5 0.0 0 1 332.42 92.93 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 332.42 91.93 L 355.48 91.93 A 2.47 2.5 0.0 0 1 357.95 94.43 L 357.95 94.43 A 2.47 2.5 0.0 0 1 355.48 96.93 L 332.42 96.93 A 2.47 2.5 0.0 0 1 329.95 94.43 L 329.95 94.43 A 2.47 2.5 0.0 0 1 332.42 91.93 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 332.8 93.93 c -0.44 0.0 -0.8 0.22 -0.8 0.5 c 0.0 0.28 0.36 0.5 0.8 0.5 h 7.92 h 6.47 h 8.08 c 0.4 0.0 0.72 -0.2 0.72 -0.45 v -0.09 c 0.0 -0.25 -0.32 -0.45 -0.72 -0.45 h -8.08 h -6.47 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFF9F2)),
                strokeLineWidth = 0.649351f,
                pathData = addPathNodes("M 334.3 146.05 L 329.94 156.73 L 328.58 160.0 L 332.0 160.0 l 1.25 -3.4 l 5.65 0.4 L 340.0 160.0 h 3.4 L 337.34 146.05 Z M 338.42 155.56 L 333.78 155.32 L 336.0 149.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 4.9062f,
                pathData = addPathNodes("M 337.34 146.05 L 336.0 149.0 l 4.0 11.0 h 3.4 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF8F8F8)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 329.47 154.0 L 342.53 154.0 A 1.47 1.32 0.0 0 1 344.0 155.32 L 344.0 155.68 A 1.47 1.32 0.0 0 1 342.53 157.0 L 329.47 157.0 A 1.47 1.32 0.0 0 1 328.0 155.68 L 328.0 155.32 A 1.47 1.32 0.0 0 1 329.47 154.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 329.6 155.0 c -0.33 0.0 -0.6 0.22 -0.6 0.5 c 0.0 0.28 0.27 0.5 0.6 0.5 h 3.0 h 5.8 h 4.0 c 0.33 0.0 0.6 -0.22 0.6 -0.5 c 0.0 -0.28 -0.27 -0.5 -0.6 -0.5 h -4.0 h -5.8 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFF9F2)),
                strokeLineWidth = 0.649351f,
                pathData = addPathNodes("m 327.4 244.0 l -1.99 4.77 l -0.51 1.23 L 326.0 250.0 l 0.46 -1.27 l 2.8 -0.35 l 0.56 1.62 h 1.28 l -0.55 -1.21 l -2.0 -4.79 h -0.58 Z M 329.15 248.33 L 326.66 248.25 L 328.02 245.03 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF34F17)),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.649351f,
                pathData = addPathNodes("m 328.55 244.0 l -0.53 1.03 l 1.13 3.3 v 0.0 l 1.23 0.03 L 328.55 244.0 Z M 328.28 248.66 L 329.27 248.73 L 329.82 250.0 h 1.28 l -0.56 -1.27 l -0.01 -0.03 l -2.24 -0.04 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF8F8F8)),
                strokeLineWidth = 2.00001f,
                pathData = addPathNodes("M 325.17 247.88 L 330.83 247.88 A 0.67 0.63 0.0 0 1 331.5 248.5 L 331.5 248.5 A 0.67 0.63 0.0 0 1 330.83 249.13 L 325.17 249.13 A 0.67 0.63 0.0 0 1 324.5 248.5 L 324.5 248.5 A 0.67 0.63 0.0 0 1 325.17 247.88 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 336.35 61.5 C 328.12 61.5 327.31 62.43 326.62 71.25 L 324.62 96.75 C 323.93 105.57 326.12 106.5 334.35 106.5 L 343.0 106.5 L 345.12 106.5 L 353.77 106.5 C 362.0 106.5 364.19 105.57 363.5 96.75 L 361.5 71.25 C 360.81 62.43 360.0 61.5 351.77 61.5 L 345.12 61.5 L 343.0 61.5 L 336.35 61.5 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 336.5 211.5 c 4.23 0.0 5.02 -0.46 5.0 -4.98 L 340.5 193.48 C 340.52 188.96 339.73 188.5 335.5 188.5 h -7.01 c -4.23 0.0 -4.65 0.48 -5.0 4.98 L 322.5 206.52 c -0.35 4.51 0.77 4.98 5.0 4.98 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 331.08 251.5 c 2.89 0.0 3.43 -0.3 3.42 -3.25 l -0.6 -8.5 C 333.69 237.0 333.37 236.5 330.48 236.5 h -4.96 c -2.89 0.0 -3.21 0.31 -3.42 3.25 L 321.5 248.25 c -0.21 2.94 0.53 3.25 3.42 3.25 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 55.99 227.01 v 2.0 c 0.0 0.11 0.0 0.19 0.0 0.3 C 54.03 263.01 58.11 268.0 94.93 268.0 h 57.07 h 0.01 h 57.07 c 36.81 0.0 40.9 -4.99 38.94 -38.7 c 0.0 -0.11 0.0 -0.19 0.0 -0.3 v -2.0 c 0.0 0.64 -0.01 1.18 -0.02 1.8 v -1.8 c 0.0 0.98 -0.01 1.84 -0.01 2.77 c -0.03 3.65 -0.1 7.02 -0.26 9.98 v 0.51 C 246.41 263.27 239.31 266.0 209.07 266.0 L 152.0 266.0 h -0.01 h -57.07 c -30.24 0.0 -37.34 -2.73 -38.65 -25.73 v -0.51 c -0.17 -2.96 -0.23 -6.33 -0.26 -9.98 c -0.0 -0.93 -0.01 -1.79 -0.01 -2.77 v 1.8 c -0.0 -0.62 -0.02 -1.16 -0.02 -1.8 Z M 56.03 232.86 c 0.0 0.19 0.0 0.38 0.01 0.56 c -0.0 -0.18 -0.0 -0.38 -0.01 -0.56 Z M 247.97 232.86 c -0.0 0.18 -0.0 0.38 -0.01 0.56 c 0.0 -0.18 0.0 -0.38 0.01 -0.56 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 44.0 C 69.11 44.06 65.46 46.44 64.0 82.99 v 2.0 C 65.11 51.8 68.51 46.0 102.92 46.0 h 23.24 h 25.83 h 0.01 h 25.83 h 23.24 c 34.41 0.0 37.81 5.8 38.92 38.99 v -2.0 C 238.54 46.44 234.89 44.06 201.07 44.0 H 177.83 H 152.0 h -0.01 h -25.83 Z")
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
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 336.73 62.0 C 327.91 62.0 327.72 62.94 327.0 71.75 L 325.0 96.25 C 324.28 105.06 325.91 106.0 334.73 106.0 L 343.0 106.0 L 345.0 106.0 L 353.27 106.0 C 362.09 106.0 363.72 105.06 363.0 96.25 L 361.0 71.75 C 360.28 62.94 360.09 62.0 351.27 62.0 L 345.0 62.0 L 343.0 62.0 L 336.73 62.0 Z M 340.68 63.08 C 341.51 63.09 342.24 63.09 343.0 63.09 L 343.0 63.1 C 343.33 63.1 343.67 63.1 344.0 63.1 C 344.33 63.1 344.67 63.1 345.0 63.1 L 345.0 63.09 C 345.76 63.09 346.49 63.09 347.32 63.08 C 348.9 63.08 349.49 63.08 351.07 63.09 C 353.32 63.21 355.69 62.93 357.85 63.77 C 359.46 64.59 359.75 66.59 359.83 68.22 C 359.98 77.17 361.89 86.16 361.89 95.13 C 361.78 97.55 362.13 100.03 361.38 102.38 C 361.03 103.85 359.51 104.49 358.16 104.72 C 353.83 104.85 348.87 104.88 343.97 104.88 C 339.09 104.87 334.15 104.85 329.84 104.72 C 328.49 104.49 326.97 103.85 326.62 102.38 C 325.87 100.03 326.22 97.55 326.11 95.13 C 326.11 86.16 328.02 77.17 328.17 68.22 C 328.25 66.59 328.54 64.59 330.15 63.77 C 332.31 62.93 334.68 63.21 336.93 63.09 C 338.51 63.08 339.1 63.08 340.68 63.08 Z")
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
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.5 189.0 c -2.09 0.0 -3.11 0.16 -3.64 0.66 c -0.27 0.25 -0.46 0.62 -0.58 1.24 c -0.13 0.62 -0.19 1.47 -0.28 2.59 L 323.0 206.52 c -0.09 1.11 0.05 1.97 0.18 2.59 c 0.13 0.62 0.32 0.99 0.58 1.24 c 0.53 0.5 1.64 0.66 3.74 0.66 h 9.01 c 2.1 0.0 3.21 -0.16 3.75 -0.66 c 0.27 -0.25 0.46 -0.62 0.58 -1.24 c 0.12 -0.62 0.17 -1.47 0.17 -2.58 l -1.0 -13.04 c 0.0 -1.12 -0.04 -1.97 -0.17 -2.58 c -0.12 -0.62 -0.31 -0.99 -0.58 -1.24 C 338.72 189.16 337.6 189.0 335.5 189.0 Z M 329.38 190.07 c 2.73 -0.0 3.46 0.01 6.19 0.03 c 0.86 0.05 1.77 -0.08 2.61 0.17 c 0.57 0.1 0.63 0.77 0.68 1.23 c 0.1 5.12 1.07 10.27 1.04 15.39 c -0.07 0.88 0.14 1.86 -0.33 2.66 c -0.52 0.38 -1.22 0.31 -1.83 0.39 c -3.79 0.08 -7.57 0.07 -11.36 0.01 c -0.64 -0.07 -1.38 -0.0 -1.93 -0.4 c -0.51 -0.8 -0.31 -1.8 -0.38 -2.7 c -0.04 -5.06 1.03 -10.16 1.13 -15.22 c 0.08 -0.48 0.1 -1.2 0.68 -1.35 c 1.18 -0.31 2.29 -0.15 3.49 -0.21 Z")
            )
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
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.52 237.0 c -0.71 0.0 -1.25 0.02 -1.62 0.09 c -0.37 0.07 -0.56 0.16 -0.7 0.29 c -0.27 0.27 -0.51 0.96 -0.61 2.43 l -0.6 8.5 c -0.08 0.71 -0.09 1.24 -0.02 1.6 c 0.06 0.36 0.17 0.54 0.34 0.68 c 0.34 0.28 1.17 0.41 2.6 0.41 h 6.16 c 1.43 0.0 2.16 -0.12 2.47 -0.39 c 0.15 -0.14 0.26 -0.33 0.34 -0.71 c 0.08 -0.37 0.11 -0.91 0.11 -1.62 l -0.6 -8.48 l -0.0 -0.01 c -0.11 -1.36 -0.26 -2.04 -0.56 -2.34 C 332.54 237.15 331.9 237.0 330.48 237.0 Z M 325.96 238.02 c 1.29 -0.0 3.37 0.0 4.66 0.01 c 0.5 0.02 1.02 -0.05 1.51 0.14 c 0.11 0.21 0.13 0.47 0.17 0.71 c 0.18 1.61 0.27 3.21 0.46 4.81 c 0.18 1.55 0.08 3.09 0.23 4.64 c 0.02 0.51 0.02 1.03 -0.12 1.52 c -0.17 0.08 -0.38 0.09 -0.56 0.12 c -2.49 0.04 -4.99 0.03 -7.48 0.03 c -0.61 -0.01 -1.24 0.02 -1.82 -0.16 c -0.09 -0.33 -0.05 -0.7 -0.03 -1.04 c 0.35 -3.04 0.31 -6.08 0.67 -9.13 c 0.07 -0.5 0.11 -0.96 0.25 -1.44 c 0.0 -0.12 0.12 -0.12 0.21 -0.14 c 0.62 -0.08 1.24 -0.05 1.87 -0.06 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 108.0 60.0 m -8.0 0.0 a 8.0 8.0 0.0 1 1 16.0 0.0 a 8.0 8.0 0.0 1 1 -16.0 0.0")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 188.43 60.0 a 7.79 8.0 0.0 1 0 15.57 0.0 a 7.79 8.0 0.0 1 0 -15.57 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF1A1A1A)),
                fillAlpha = 0.15f,
                stroke = SolidColor(Color(0xFF1A1A1A)),
                strokeAlpha = 0.15f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 108.29 56.51 a 4.03 3.5 90.0 0 0 -3.78 3.68 c 0.0 0.0 -1.12 14.64 4.26 29.51 C 114.15 104.57 126.83 119.8 152.0 119.8 c 25.17 0.0 37.85 -15.23 43.23 -30.1 c 5.38 -14.87 4.26 -29.51 4.26 -29.51 a 4.03 3.5 90.0 0 0 -3.78 -3.68 a 4.03 3.5 90.0 0 0 -3.2 4.35 c 0.0 0.0 0.88 12.98 -3.74 25.74 C 184.15 99.36 174.83 111.74 152.0 111.74 c -22.83 0.0 -32.15 -12.39 -36.77 -25.14 c -4.62 -12.75 -3.74 -25.74 -3.74 -25.74 a 4.03 3.5 90.0 0 0 -3.2 -4.35 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF5F4F3)),
                stroke = SolidColor(Color(0xFFE4D1C1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 108.29 56.51 a 3.5 3.5 0.0 0 0 -3.78 3.2 c 0.0 0.0 -1.12 12.72 4.26 25.64 C 114.15 98.26 126.83 111.5 152.0 111.5 c 25.17 0.0 37.85 -13.24 43.23 -26.15 c 5.38 -12.92 4.26 -25.64 4.26 -25.64 a 3.5 3.5 0.0 0 0 -3.78 -3.2 a 3.5 3.5 0.0 0 0 -3.2 3.78 c 0.0 0.0 0.88 11.28 -3.74 22.36 C 184.15 93.74 174.83 104.5 152.0 104.5 c -22.83 0.0 -32.15 -10.76 -36.77 -21.85 c -4.62 -11.08 -3.74 -22.36 -3.74 -22.36 a 3.5 3.5 0.0 0 0 -3.2 -3.78 Z")
            )
        }.build()

        return _AppCenter!!
    }

@Suppress("ObjectPropertyName")
private var _AppCenter: ImageVector? = null
