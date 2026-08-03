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

val Rom: ImageVector
    get() {
        if (_Rom != null) {
            return _Rom!!
        }
        _Rom = ImageVector.Builder(
            name = "Rom",
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
                        0f to Color(0xFF4D4D4D),
                        1f to Color(0xFF707070)
                    ),
                    start = Offset(334.4f, 54f),
                    end = Offset(365.22f, 112f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.73 61.0 c -2.22 0.0 -3.97 0.05 -5.41 0.29 c -1.44 0.24 -2.62 0.69 -3.48 1.56 c -0.86 0.86 -1.32 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.19 -0.28 5.42 V 84.0 V 96.25 c -0.01 2.23 0.04 3.98 0.28 5.42 c 0.24 1.44 0.69 2.62 1.56 3.48 c 0.86 0.86 2.04 1.31 3.48 1.56 c 1.44 0.24 3.19 0.29 5.41 0.29 h 16.54 c 2.22 0.0 3.97 -0.05 5.41 -0.29 c 1.44 -0.24 2.61 -0.69 3.47 -1.56 c 0.86 -0.86 1.31 -2.04 1.55 -3.48 C 362.95 100.23 363.0 98.48 363.0 96.25 V 84.0 V 71.75 c 0.0 -2.23 -0.05 -3.98 -0.29 -5.42 c -0.24 -1.44 -0.69 -2.62 -1.55 -3.48 c -0.86 -0.86 -2.04 -1.31 -3.47 -1.56 C 356.24 61.05 354.49 61.0 352.27 61.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF4D4D4D),
                        1f to Color(0xFF707070)
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
                        0f to Color(0xFF4D4D4D),
                        1f to Color(0xFF707070)
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
                        0f to Color(0xFF4D4D4D),
                        1f to Color(0xFF707070)
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
                        0f to Color(0xFF4D4D4D),
                        1f to Color(0xFF707070)
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
                        0f to Color(0xFF216C4D),
                        1f to Color(0xFF2D976B)
                    ),
                    start = Offset(128.25f, 100.17f),
                    end = Offset(176.09f, 211f)
                ),
                strokeLineWidth = 0.4910596f,
                pathData = addPathNodes("m 116.11 212.0 c -17.33 0.0 -19.2 -1.78 -19.11 -19.15 v -36.85 v -35.85 c -0.08 -17.37 1.78 -19.15 19.11 -19.15 h 71.77 c 17.33 0.0 19.11 1.78 19.11 19.15 v 35.85 v 36.85 c 0.0 17.37 -1.78 19.15 -19.11 19.15 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF216C4D),
                        1f to Color(0xFF2D976B)
                    ),
                    start = Offset(338.82f, 71.82f),
                    end = Offset(349.26f, 96f)
                ),
                strokeLineWidth = 0.10713931f,
                pathData = addPathNodes("m 336.17 96.0 c -3.78 0.0 -4.19 -0.39 -4.17 -4.18 v -7.82 v -7.82 c -0.02 -3.79 0.39 -4.18 4.17 -4.18 h 15.66 c 3.78 0.0 4.17 0.39 4.17 4.18 v 7.82 v 7.82 c 0.0 3.79 -0.39 4.18 -4.17 4.18 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.42855725f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 337.0 93.0 v 3.0 h 2.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.10713931f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 337.0 92.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 0.10715742f,
                pathData = addPathNodes("m 336.17 72.0 c -3.78 0.0 -4.19 0.39 -4.17 4.18 v 7.82 v 7.82 c -0.02 3.53 0.22 4.17 3.49 4.17 L 336.0 96.0 v -4.0 h 16.0 v 4.0 l 0.51 -0.0 c 3.27 0.0 3.49 -0.65 3.49 -4.17 v -7.82 v -7.82 c 0.0 -3.79 -0.39 -4.18 -4.17 -4.18 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 0.10562587f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.0 75.0 h 18.0 v 11.0 h -18.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.10713931f,
                pathData = addPathNodes("m 344.0 90.0 l -3.0 -2.0 h 6.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF216C4D),
                        1f to Color(0xFF2D976B)
                    ),
                    start = Offset(332.55f, 139.88f),
                    end = Offset(339.5f, 156f)
                ),
                strokeLineWidth = 0.07142621f,
                pathData = addPathNodes("m 330.78 156.0 c -2.52 0.0 -2.79 -0.26 -2.78 -2.79 v -5.21 v -5.21 c -0.01 -2.53 0.26 -2.79 2.78 -2.79 h 10.44 c 2.52 0.0 2.78 0.26 2.78 2.79 v 5.21 v 5.21 c 0.0 2.53 -0.26 2.79 -2.78 2.79 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 0.07142621f,
                pathData = addPathNodes("m 330.78 140.0 c -2.52 0.0 -2.79 0.26 -2.78 2.79 V 148.0 v 5.21 c -0.01 2.53 0.26 2.79 2.78 2.79 H 331.0 v -3.0 h 10.0 v 3.0 h 0.22 C 343.74 156.0 344.0 155.74 344.0 153.21 V 148.0 V 142.79 C 344.0 140.26 343.74 140.0 341.22 140.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 0.07041724f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 142.0 h 12.0 v 7.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.07142621f,
                pathData = addPathNodes("m 336.0 152.0 l -2.0 -2.0 h 4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.34991553f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 154.0 v 2.0 h 8.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.05726837f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 153.0 h 8.0 v 1.0 h -8.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF216C4D),
                        1f to Color(0xFF2D976B)
                    ),
                    start = Offset(329.41f, 193.91f),
                    end = Offset(334.63f, 206f)
                ),
                strokeLineWidth = 0.0535683f,
                pathData = addPathNodes("m 328.08 206.0 c -1.89 0.0 -2.09 -0.19 -2.08 -2.09 v -3.91 v -3.91 c -0.01 -1.89 0.19 -2.09 2.08 -2.09 h 7.83 c 1.89 0.0 2.08 0.19 2.08 2.09 v 3.91 v 3.91 c 0.0 1.89 -0.19 2.09 -2.08 2.09 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 0.0535683f,
                pathData = addPathNodes("m 328.08 194.0 c -1.89 0.0 -2.09 0.2 -2.08 2.09 V 200.0 v 3.91 c -0.01 1.86 0.21 2.08 2.0 2.09 V 204.0 h 8.0 v 2.0 c 1.79 -0.01 2.0 -0.23 2.0 -2.09 V 200.0 V 196.09 C 338.0 194.2 337.8 194.0 335.91 194.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 0.05281159f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.5 195.5 h 9.0 v 4.5 h -9.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.0535683f,
                pathData = addPathNodes("m 332.0 203.0 l -2.0 -2.0 h 4.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF216C4D),
                        1f to Color(0xFF2D976B)
                    ),
                    start = Offset(326.27f, 239.94f),
                    end = Offset(329.75f, 248f)
                ),
                strokeLineWidth = 0.0357122f,
                pathData = addPathNodes("m 325.39 248.0 c -1.26 0.0 -1.4 -0.13 -1.39 -1.39 v -2.61 v -2.61 c -0.01 -1.26 0.13 -1.39 1.39 -1.39 h 5.22 c 1.26 0.0 1.39 0.13 1.39 1.39 v 2.61 v 2.61 c 0.0 1.26 -0.13 1.39 -1.39 1.39 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 0.0357122f,
                pathData = addPathNodes("m 325.39 240.0 c -1.26 0.0 -1.39 0.13 -1.39 1.39 V 244.0 v 2.61 c -0.0 1.1 0.14 1.33 1.0 1.37 V 246.0 h 1.0 h 4.0 h 1.0 v 1.98 c 0.85 -0.04 1.0 -0.27 1.0 -1.37 V 244.0 V 241.39 C 332.0 240.13 331.87 240.0 330.61 240.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 0.03520773f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.0 241.0 h 6.0 v 4.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.17495334f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.0 247.0 V 248.0 l 4.0 -0.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.02863346f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.0 246.0 l 4.0 -0.0 v 1.0 l -4.0 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.26243f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.0 205.0 v 1.0 h 6.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.04295019f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.0 204.0 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.42855725f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 340.0 93.0 v 3.0 h 2.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.10713931f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 340.0 92.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.42855725f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 343.0 93.0 v 3.0 h 2.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.10713931f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 343.0 92.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.42855725f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 346.0 93.0 v 3.0 h 2.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.10713931f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 346.0 92.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFEAB305)),
                strokeLineWidth = 0.42855725f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 349.0 93.0 v 3.0 h 2.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.10713931f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 349.0 92.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(119f, 153.05f),
                    end = Offset(149.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 118.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 118.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 119.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(126f, 153.05f),
                    end = Offset(156.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 125.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 125.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 126.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(140f, 153.05f),
                    end = Offset(170.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 139.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 139.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 140.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(147f, 153.05f),
                    end = Offset(177.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 146.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 146.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 147.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(154f, 153.05f),
                    end = Offset(184.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 153.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 153.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 154.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(161f, 153.05f),
                    end = Offset(191.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 160.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 160.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 161.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(168f, 153.05f),
                    end = Offset(198.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 167.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 167.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 168.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(175f, 153.05f),
                    end = Offset(205.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 174.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 174.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 175.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(182f, 153.05f),
                    end = Offset(212.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 181.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 181.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 v 11.02 l -3.0 -0.02 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 182.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEAB305),
                        1f to Color(0xFFFFDA64)
                    ),
                    start = Offset(126f, 153.05f),
                    end = Offset(156.44f, 211f)
                ),
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 132.0 200.0 v 12.0 h 5.0 v -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9642384f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 132.0 200.0 v 12.0 h 5.0 v -12.0 h -1.0 V 211.02 L 133.0 211.0 v -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5CA487)),
                strokeLineWidth = 0.4910596f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 133.0 196.0 h 3.0 l 0.0 4.0 h -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFB3B3B3)),
                strokeLineWidth = 0.4911426f,
                pathData = addPathNodes("M 115.11 100.0 C 97.78 100.0 95.92 101.78 96.0 119.15 v 36.86 v 36.86 c -0.08 16.16 1.0 19.12 16.0 19.12 L 112.0 196.0 H 192.0 l 0.0 16.0 c 15.0 0.0 16.0 -2.96 16.0 -19.12 V 156.02 V 119.15 C 208.0 101.78 206.22 100.0 188.89 100.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 0.4910596f,
                pathData = addPathNodes("m 152.0 184.0 l -16.0 -12.0 h 32.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 0.48412293f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 112.0 116.0 h 80.0 v 48.0 h -80.0 Z")
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
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 330.19 133.5 c -1.41 0.0 -2.52 0.03 -3.42 0.19 c -0.9 0.15 -1.62 0.43 -2.14 0.95 c -0.52 0.52 -0.8 1.24 -0.95 2.14 c -0.15 0.9 -0.18 2.01 -0.17 3.43 V 148.0 v 7.8 c -0.01 1.41 0.02 2.52 0.17 3.42 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.19 3.42 0.19 h 11.62 c 1.41 0.0 2.52 -0.03 3.42 -0.19 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.15 -0.9 0.19 -2.01 0.19 -3.43 V 148.0 V 140.2 c 0.0 -1.42 -0.03 -2.52 -0.19 -3.43 c -0.15 -0.9 -0.43 -1.62 -0.95 -2.14 c -0.52 -0.52 -1.24 -0.8 -2.14 -0.95 C 344.33 133.53 343.22 133.5 341.81 133.5 Z")
            )
            addPath(
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.87 188.5 c -1.11 0.0 -1.99 0.03 -2.71 0.15 c -0.72 0.12 -1.31 0.35 -1.74 0.78 c -0.43 0.43 -0.66 1.02 -0.78 1.74 c -0.12 0.72 -0.14 1.6 -0.14 2.71 V 200.0 v 6.13 c -0.0 1.11 0.02 1.99 0.14 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.15 2.71 0.15 h 8.27 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.6 0.15 -2.71 V 200.0 V 193.88 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.59 -0.15 -2.71 -0.15 Z")
            )
            addPath(
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
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
        }.build()

        return _Rom!!
    }

@Suppress("ObjectPropertyName")
private var _Rom: ImageVector? = null
