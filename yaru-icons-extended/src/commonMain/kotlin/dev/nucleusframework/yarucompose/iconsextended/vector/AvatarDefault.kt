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

val AvatarDefault: ImageVector
    get() {
        if (_AvatarDefault != null) {
            return _AvatarDefault!!
        }
        _AvatarDefault = ImageVector.Builder(
            name = "AvatarDefault",
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
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 157.0 m -112.0 0.0 a 112.0 112.0 0.0 1 1 224.0 0.0 a 112.0 112.0 0.0 1 1 -224.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 157.0 m -112.0 0.0 a 112.0 112.0 0.0 1 1 224.0 0.0 a 112.0 112.0 0.0 1 1 -224.0 0.0")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF1A7FD4),
                        1f to Color(0xFF37A6E6)
                    ),
                    start = Offset(104f, 44f),
                    end = Offset(200f, 268f)
                ),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 156.0 m -112.0 0.0 a 112.0 112.0 0.0 1 1 224.0 0.0 a 112.0 112.0 0.0 1 1 -224.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.9543769f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 85.0 m 23.0 -0.0 a 23.0 23.0 0.0 1 1 -46.0 -0.0 a 23.0 23.0 0.0 1 1 46.0 -0.0")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF1A7FD4),
                        1f to Color(0xFF37A6E6)
                    ),
                    start = Offset(333.48f, 62.8f),
                    end = Offset(356.5f, 103.5f)
                ),
                strokeLineWidth = 1.8694037f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 84.0 m -22.5 0.0 a 22.5 22.5 0.0 1 1 45.0 0.0 a 22.5 22.5 0.0 1 1 -45.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.9543769f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 149.0 m 15.0 -0.0 a 15.0 15.0 0.0 1 1 -30.0 -0.0 a 15.0 15.0 0.0 1 1 30.0 -0.0")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF1A7FD4),
                        1f to Color(0xFF37A6E6)
                    ),
                    start = Offset(329.22f, 134.34f),
                    end = Offset(344.06f, 160.57f)
                ),
                strokeLineWidth = 1.8694037f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 148.0 m -14.5 0.0 a 14.5 14.5 0.0 1 1 29.0 0.0 a 14.5 14.5 0.0 1 1 -29.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.9543769f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 200.52 a 11.48 12.0 90.0 1 0 -24.0 -0.0 a 11.48 12.0 90.0 1 0 24.0 -0.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF1A7FD4),
                        1f to Color(0xFF37A6E6)
                    ),
                    start = Offset(326.62f, 189.17f),
                    end = Offset(338.39f, 209.97f)
                ),
                strokeLineWidth = 1.8694036f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 320.5 200.0 a 11.5 11.5 0.0 1 0 23.0 0.0 a 11.5 11.5 0.0 1 0 -23.0 0.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.954377f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.0 244.5 a 6.5 7.0 90.0 1 0 -14.0 -0.0 a 6.5 7.0 90.0 1 0 14.0 -0.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF1A7FD4),
                        1f to Color(0xFF37A6E6)
                    ),
                    start = Offset(324.49f, 236.93f),
                    end = Offset(332.17f, 250.5f)
                ),
                strokeLineWidth = 1.8694038f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 244.0 m -7.5 0.0 a 7.5 7.5 0.0 1 1 15.0 0.0 a 7.5 7.5 0.0 1 1 -15.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 44.0 V 268.0 A 112.0 112.0 0.0 0 0 264.0 156.0 A 112.0 112.0 0.0 0 0 152.0 44.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.0 61.52 v 44.96 a 22.5 22.5 0.0 0 0 22.0 -22.47 a 22.5 22.5 0.0 0 0 -22.0 -22.48 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.06 133.55 v 28.95 a 14.5 14.5 0.0 0 0 13.94 -14.47 a 14.5 14.5 0.0 0 0 -13.94 -14.48 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 189.52 v 20.96 a 10.5 10.5 0.0 0 0 10.0 -10.47 a 10.5 10.5 0.0 0 0 -10.0 -10.48 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.07999998f,
                strokeAlpha = 0.07999998f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 328.0 237.51 v 12.98 a 6.5 6.5 0.0 0 0 6.25 -6.49 a 6.5 6.5 0.0 0 0 -6.25 -6.49 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9999999f,
                pathData = addPathNodes("m 328.0 241.0 v 0.0 c -0.28 0.0 -0.55 0.05 -0.8 0.15 c -0.25 0.09 -0.47 0.23 -0.65 0.41 v 0.0 l -0.0 0.0 c -0.18 0.18 -0.31 0.39 -0.41 0.64 c -0.1 0.24 -0.14 0.51 -0.14 0.8 c 0.0 0.29 0.05 0.56 0.14 0.81 c 0.1 0.24 0.23 0.45 0.41 0.63 h 0.0 c 0.18 0.18 0.4 0.32 0.64 0.42 l 0.0 0.0 h 0.0 c 0.25 0.09 0.52 0.14 0.8 0.14 c 0.28 0.0 0.55 -0.05 0.8 -0.14 c 0.24 -0.1 0.46 -0.24 0.64 -0.42 c 0.18 -0.18 0.32 -0.39 0.42 -0.63 c 0.1 -0.25 0.14 -0.52 0.14 -0.81 h 0.0 c 0.0 -0.29 -0.05 -0.55 -0.14 -0.8 c -0.1 -0.25 -0.24 -0.46 -0.42 -0.64 c -0.18 -0.18 -0.39 -0.32 -0.64 -0.41 C 328.55 241.05 328.28 241.0 328.0 241.0 Z M 328.01 246.0 c -1.23 0.0 -1.9 0.11 -2.39 0.46 c -0.25 0.17 -0.41 0.41 -0.5 0.69 c -0.09 0.28 -0.12 0.86 -0.12 0.86 h 6.0 c 0.0 0.0 -0.03 -0.58 -0.12 -0.86 c -0.09 -0.28 -0.25 -0.51 -0.5 -0.69 C 329.89 246.11 329.25 246.0 328.01 246.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 332.0 195.0 V 195.0 c -0.42 0.0 -0.83 0.07 -1.2 0.22 c -0.37 0.14 -0.69 0.35 -0.97 0.62 l -0.0 0.0 c -0.27 0.27 -0.47 0.59 -0.62 0.96 c -0.15 0.37 -0.21 0.77 -0.21 1.2 c 0.0 0.44 0.07 0.84 0.21 1.21 c 0.14 0.36 0.35 0.68 0.62 0.95 v 0.0 h 0.0 c 0.27 0.27 0.6 0.48 0.96 0.63 h 0.0 l 0.0 0.0 c 0.37 0.14 0.77 0.21 1.2 0.21 c 0.42 0.0 0.82 -0.07 1.2 -0.21 v -0.0 c 0.37 -0.15 0.69 -0.36 0.95 -0.63 c 0.27 -0.27 0.48 -0.59 0.63 -0.95 c 0.15 -0.37 0.22 -0.77 0.22 -1.21 h 0.01 c 0.0 -0.43 -0.07 -0.83 -0.22 -1.2 c -0.14 -0.37 -0.35 -0.69 -0.63 -0.96 c -0.27 -0.27 -0.59 -0.48 -0.96 -0.62 c -0.37 -0.15 -0.77 -0.22 -1.2 -0.22 Z M 332.02 202.0 c -2.06 0.0 -3.16 0.21 -3.98 0.91 c -0.41 0.35 -0.68 0.82 -0.83 1.38 c -0.15 0.55 -0.2 1.71 -0.2 1.71 l 10.0 0.0 c 0.0 0.0 -0.05 -1.16 -0.2 -1.71 c -0.15 -0.55 -0.42 -1.03 -0.83 -1.38 C 335.15 202.21 334.08 202.0 332.02 202.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 336.0 141.0 c -0.53 0.0 -1.03 0.1 -1.49 0.29 c -0.46 0.19 -0.87 0.46 -1.21 0.82 l -0.0 0.0 l -0.0 0.0 c -0.33 0.36 -0.59 0.79 -0.77 1.28 c -0.18 0.49 -0.27 1.03 -0.27 1.6 c 0.0 0.58 0.09 1.12 0.27 1.61 c 0.18 0.48 0.44 0.91 0.77 1.27 l 0.0 0.0 l 0.0 0.0 c 0.34 0.36 0.74 0.64 1.2 0.83 l 0.0 0.0 l 0.0 0.0 c 0.46 0.19 0.96 0.28 1.49 0.28 c 0.53 0.0 1.03 -0.09 1.49 -0.28 v -0.0 c 0.46 -0.2 0.86 -0.48 1.19 -0.83 c 0.34 -0.36 0.6 -0.79 0.78 -1.27 c 0.18 -0.49 0.27 -1.03 0.27 -1.61 h 0.01 c 0.0 -0.57 -0.09 -1.11 -0.27 -1.6 c -0.18 -0.49 -0.44 -0.92 -0.78 -1.28 c -0.33 -0.36 -0.74 -0.64 -1.2 -0.82 c -0.46 -0.2 -0.97 -0.29 -1.49 -0.29 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                strokeLineWidth = 1.9999999f,
                pathData = addPathNodes("m 343.0 156.0 l -14.0 -0.0 c 0.0 0.0 0.07 -1.44 0.28 -2.13 c 0.21 -0.69 0.59 -1.28 1.17 -1.71 c 1.15 -0.87 2.7 -1.13 5.58 -1.13 c 2.88 0.0 4.38 0.27 5.52 1.14 c 0.57 0.43 0.95 1.02 1.17 1.71 c 0.21 0.69 0.28 2.13 0.28 2.13 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 336.0 140.0 c -0.53 0.0 -1.03 0.1 -1.49 0.29 c -0.46 0.19 -0.87 0.46 -1.21 0.82 l -0.0 0.0 l -0.0 0.0 c -0.33 0.36 -0.59 0.79 -0.77 1.28 c -0.18 0.49 -0.27 1.03 -0.27 1.6 c 0.0 0.58 0.09 1.12 0.27 1.61 c 0.18 0.48 0.44 0.91 0.77 1.27 l 0.0 0.0 l 0.0 0.0 c 0.34 0.36 0.74 0.64 1.2 0.83 l 0.0 0.0 l 0.0 0.0 c 0.46 0.19 0.96 0.28 1.49 0.28 c 0.53 0.0 1.03 -0.09 1.49 -0.28 v -0.0 c 0.46 -0.2 0.86 -0.48 1.19 -0.83 c 0.34 -0.36 0.6 -0.79 0.78 -1.27 c 0.18 -0.49 0.27 -1.03 0.27 -1.61 h 0.01 c 0.0 -0.57 -0.09 -1.11 -0.27 -1.6 c -0.18 -0.49 -0.44 -0.92 -0.78 -1.28 c -0.33 -0.36 -0.74 -0.64 -1.2 -0.82 c -0.46 -0.2 -0.97 -0.29 -1.49 -0.29 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 1.9999999f,
                pathData = addPathNodes("m 343.0 155.0 l -14.0 -0.0 c 0.0 0.0 0.07 -1.44 0.28 -2.13 c 0.21 -0.69 0.59 -1.28 1.17 -1.71 c 1.15 -0.87 2.7 -1.13 5.58 -1.13 c 2.88 0.0 4.38 0.27 5.52 1.14 c 0.57 0.43 0.95 1.02 1.17 1.71 c 0.21 0.69 0.28 2.13 0.28 2.13 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 332.0 194.0 c -0.42 0.0 -0.83 0.07 -1.2 0.22 c -0.37 0.14 -0.7 0.35 -0.97 0.62 l -0.0 0.0 l -0.0 0.0 c -0.27 0.27 -0.47 0.59 -0.61 0.96 c -0.15 0.37 -0.22 0.77 -0.22 1.2 c 0.0 0.44 0.07 0.84 0.22 1.21 c 0.14 0.36 0.35 0.68 0.61 0.95 l 0.0 0.0 l 0.0 0.0 c 0.27 0.27 0.6 0.48 0.96 0.62 l 0.0 0.0 l 0.0 0.0 c 0.37 0.14 0.77 0.21 1.2 0.21 c 0.42 0.0 0.82 -0.07 1.2 -0.21 v -0.0 c 0.37 -0.15 0.69 -0.36 0.95 -0.63 c 0.27 -0.27 0.48 -0.59 0.63 -0.95 c 0.15 -0.37 0.22 -0.77 0.22 -1.21 h 0.01 c 0.0 -0.43 -0.07 -0.83 -0.22 -1.2 c -0.14 -0.37 -0.35 -0.69 -0.63 -0.96 c -0.27 -0.27 -0.59 -0.48 -0.96 -0.62 c -0.37 -0.15 -0.77 -0.22 -1.2 -0.22 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 337.0 205.0 l -10.0 -0.0 c 0.0 0.0 0.05 -1.16 0.2 -1.71 c 0.15 -0.55 0.42 -1.03 0.83 -1.38 c 0.82 -0.7 1.93 -0.91 3.98 -0.91 c 2.06 0.0 3.13 0.22 3.95 0.91 c 0.41 0.35 0.68 0.82 0.83 1.38 c 0.15 0.55 0.2 1.71 0.2 1.71 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 1.9999999f,
                pathData = addPathNodes("m 328.0 240.0 c -0.28 0.0 -0.55 0.05 -0.8 0.15 c -0.25 0.09 -0.46 0.23 -0.65 0.41 l -0.0 0.0 l -0.0 0.0 c -0.18 0.18 -0.31 0.4 -0.41 0.64 c -0.1 0.24 -0.14 0.51 -0.14 0.8 c 0.0 0.29 0.05 0.56 0.14 0.81 c 0.1 0.24 0.23 0.45 0.41 0.63 l 0.0 0.0 l 0.0 0.0 c 0.18 0.18 0.4 0.32 0.64 0.42 l 0.0 0.0 l 0.0 0.0 c 0.25 0.09 0.52 0.14 0.8 0.14 c 0.28 0.0 0.55 -0.05 0.8 -0.14 v -0.0 c 0.24 -0.1 0.46 -0.24 0.64 -0.42 c 0.18 -0.18 0.32 -0.39 0.42 -0.63 c 0.1 -0.25 0.15 -0.52 0.15 -0.81 h 0.0 c 0.0 -0.29 -0.05 -0.55 -0.14 -0.8 c -0.1 -0.25 -0.24 -0.46 -0.42 -0.64 c -0.18 -0.18 -0.39 -0.32 -0.64 -0.41 C 328.55 240.05 328.28 240.0 328.0 240.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 1.9999998f,
                pathData = addPathNodes("m 331.0 247.0 l -6.0 -0.0 c 0.0 0.0 0.03 -0.58 0.12 -0.86 c 0.09 -0.28 0.25 -0.51 0.5 -0.69 c 0.49 -0.35 1.16 -0.46 2.39 -0.46 c 1.23 0.0 1.88 0.11 2.37 0.46 c 0.25 0.17 0.41 0.41 0.5 0.69 c 0.09 0.28 0.12 0.86 0.12 0.86 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9999999f,
                pathData = addPathNodes("m 344.0 71.0 c -0.85 0.0 -1.66 0.17 -2.4 0.52 c -0.74 0.33 -1.39 0.81 -1.94 1.44 l -0.0 0.01 l -0.0 0.0 c -0.53 0.63 -0.94 1.38 -1.23 2.24 c -0.29 0.86 -0.43 1.79 -0.43 2.8 c 0.0 1.02 0.14 1.97 0.43 2.82 c 0.29 0.84 0.7 1.59 1.23 2.21 l 0.0 0.0 l 0.0 0.0 c 0.54 0.62 1.19 1.11 1.93 1.46 l 0.01 0.0 l 0.01 0.0 c 0.74 0.33 1.55 0.49 2.39 0.49 c 0.85 0.0 1.65 -0.16 2.39 -0.49 v -0.0 c 0.73 -0.34 1.38 -0.83 1.91 -1.46 c 0.54 -0.63 0.96 -1.37 1.25 -2.22 c 0.29 -0.86 0.44 -1.81 0.44 -2.82 h 0.01 c 0.0 -1.0 -0.14 -1.94 -0.43 -2.8 c -0.29 -0.86 -0.71 -1.62 -1.25 -2.24 c -0.53 -0.63 -1.18 -1.11 -1.92 -1.44 c -0.74 -0.35 -1.55 -0.52 -2.4 -0.52 Z M 344.05 89.0 c -4.94 0.0 -7.59 0.43 -9.56 1.82 c -0.99 0.7 -1.63 1.65 -2.0 2.75 c -0.37 1.11 -0.49 3.42 -0.49 3.42 l 24.0 0.0 c -0.0 -0.0 -0.11 -2.31 -0.48 -3.42 c -0.37 -1.11 -1.02 -2.05 -2.0 -2.75 c -1.97 -1.39 -4.53 -1.83 -9.47 -1.83 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 1.9999999f,
                pathData = addPathNodes("m 344.0 70.0 c -0.85 0.0 -1.65 0.17 -2.4 0.52 c -0.74 0.33 -1.39 0.81 -1.94 1.44 l -0.0 0.01 l -0.0 0.0 c -0.53 0.63 -0.94 1.38 -1.23 2.24 c -0.29 0.86 -0.43 1.8 -0.43 2.8 c 0.0 1.02 0.14 1.96 0.43 2.82 c 0.29 0.84 0.7 1.59 1.23 2.21 l 0.0 0.0 l 0.0 0.0 c 0.54 0.62 1.19 1.11 1.93 1.46 l 0.01 0.0 l 0.01 0.0 c 0.74 0.33 1.55 0.49 2.39 0.49 c 0.85 0.0 1.65 -0.16 2.39 -0.49 v -0.0 c 0.73 -0.34 1.38 -0.83 1.91 -1.46 c 0.54 -0.63 0.96 -1.38 1.25 -2.22 c 0.29 -0.86 0.44 -1.81 0.44 -2.82 h 0.01 c 0.0 -1.0 -0.14 -1.94 -0.43 -2.8 c -0.29 -0.86 -0.71 -1.62 -1.25 -2.25 c -0.53 -0.63 -1.18 -1.11 -1.92 -1.44 c -0.74 -0.35 -1.55 -0.52 -2.4 -0.52 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 356.0 96.0 l -24.0 -0.0 c 0.0 0.0 0.12 -2.32 0.49 -3.42 c 0.37 -1.11 1.02 -2.05 2.0 -2.75 c 1.97 -1.39 4.62 -1.82 9.56 -1.82 c 4.94 0.0 7.5 0.43 9.47 1.83 c 0.98 0.7 1.63 1.65 2.0 2.75 c 0.37 1.11 0.48 3.42 0.48 3.42 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1.9999998f,
                pathData = addPathNodes("m 152.0 86.0 c -4.52 0.0 -8.83 0.88 -12.78 2.65 c -3.93 1.69 -7.42 4.17 -10.33 7.38 l -0.02 0.04 l -0.02 0.02 c -2.83 3.23 -5.01 7.11 -6.55 11.51 c -1.56 4.41 -2.31 9.23 -2.31 14.4 c 0.0 5.23 0.74 10.1 2.31 14.52 c 1.54 4.34 3.73 8.17 6.55 11.39 l 0.02 0.02 l 0.02 0.02 c 2.9 3.21 6.36 5.72 10.28 7.49 l 0.04 0.02 l 0.03 0.02 c 3.95 1.69 8.25 2.53 12.77 2.53 c 4.52 0.0 8.8 -0.84 12.75 -2.53 v -0.02 c 3.91 -1.76 7.35 -4.29 10.18 -7.51 c 2.9 -3.22 5.14 -7.07 6.68 -11.43 c 1.57 -4.42 2.32 -9.29 2.32 -14.52 h 0.07 c 0.0 -5.16 -0.75 -9.98 -2.31 -14.38 c -1.54 -4.42 -3.77 -8.32 -6.68 -11.55 c -2.83 -3.23 -6.3 -5.73 -10.23 -7.42 C 160.83 86.88 156.53 86.0 152.0 86.0 Z M 152.26 174.0 c -26.34 0.0 -40.48 2.15 -50.99 9.12 c -5.25 3.49 -8.72 8.23 -10.68 13.76 c -1.96 5.53 -2.59 17.11 -2.59 17.11 l 128.0 0.01 c -0.0 -0.02 -0.61 -11.58 -2.56 -17.1 c -1.95 -5.53 -5.41 -10.27 -10.67 -13.76 C 192.27 176.15 178.61 174.0 152.26 174.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 1.9999998f,
                pathData = addPathNodes("m 152.0 84.0 c -4.52 0.0 -8.83 0.88 -12.78 2.65 c -3.93 1.69 -7.42 4.17 -10.33 7.38 l -0.02 0.04 l -0.02 0.02 c -2.83 3.23 -5.02 7.11 -6.55 11.51 c -1.56 4.41 -2.31 9.23 -2.31 14.4 c 0.0 5.23 0.74 10.1 2.31 14.52 c 1.54 4.34 3.73 8.17 6.55 11.39 l 0.02 0.02 l 0.02 0.02 c 2.9 3.21 6.36 5.72 10.28 7.49 l 0.03 0.02 l 0.03 0.02 c 3.95 1.69 8.25 2.53 12.76 2.53 c 4.52 0.0 8.8 -0.84 12.75 -2.53 v -0.02 c 3.91 -1.76 7.35 -4.29 10.18 -7.51 c 2.9 -3.22 5.14 -7.07 6.68 -11.43 c 1.57 -4.42 2.32 -9.29 2.32 -14.52 h 0.07 c 0.0 -5.16 -0.75 -9.98 -2.31 -14.38 c -1.54 -4.42 -3.77 -8.32 -6.68 -11.55 c -2.83 -3.23 -6.3 -5.73 -10.23 -7.42 c -3.96 -1.78 -8.26 -2.65 -12.78 -2.65 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6FCFE)),
                strokeLineWidth = 1.9999996f,
                pathData = addPathNodes("m 216.0 211.99 l -128.0 -0.01 c 0.0 0.0 0.63 -11.58 2.59 -17.11 c 1.96 -5.53 5.43 -10.27 10.68 -13.76 C 111.78 174.15 125.92 172.0 152.26 172.0 c 26.34 0.0 40.01 2.15 50.51 9.13 c 5.25 3.49 8.71 8.23 10.67 13.76 C 215.39 200.42 216.0 212.0 216.0 212.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 244.0 m -7.5 0.0 a 7.5 7.5 0.0 1 1 15.0 0.0 a 7.5 7.5 0.0 1 1 -15.0 0.0")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 320.55 199.98 a 11.45 11.48 0.0 1 0 22.91 0.0 a 11.45 11.48 0.0 1 0 -22.91 0.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 148.0 m -14.5 0.0 a 14.5 14.5 0.0 1 1 29.0 0.0 a 14.5 14.5 0.0 1 1 -29.0 0.0")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 84.0 m -22.5 0.0 a 22.5 22.5 0.0 1 1 45.0 0.0 a 22.5 22.5 0.0 1 1 -45.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 152.0 268.0 a 112.0 112.0 0.0 0 1 -112.0 -112.0 a 112.0 112.0 0.0 0 1 0.04 -1.17 A 112.0 112.0 0.0 0 0 152.0 266.0 A 112.0 112.0 0.0 0 0 263.96 155.17 a 112.0 112.0 0.0 0 1 0.04 0.83 a 112.0 112.0 0.0 0 1 -112.0 112.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 44.0 A 112.0 112.0 0.0 0 0 40.0 156.0 A 112.0 112.0 0.0 0 0 40.04 157.17 A 112.0 112.0 0.0 0 1 152.0 46.0 A 112.0 112.0 0.0 0 1 263.96 156.83 a 112.0 112.0 0.0 0 0 0.04 -0.83 a 112.0 112.0 0.0 0 0 -112.0 -112.0 Z")
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
                strokeLineWidth = 1.8694036f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 62.0 A 22.0 22.0 0.0 0 0 322.0 84.0 A 22.0 22.0 0.0 0 0 344.0 106.0 A 22.0 22.0 0.0 0 0 366.0 84.0 A 22.0 22.0 0.0 0 0 344.0 62.0 Z M 344.0 62.96 A 21.04 21.04 0.0 0 1 365.04 84.0 A 21.04 21.04 0.0 0 1 344.0 105.04 A 21.04 21.04 0.0 0 1 322.96 84.0 A 21.04 21.04 0.0 0 1 344.0 62.96 Z")
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
                strokeLineWidth = 1.8694036f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.0 134.0 c -7.73 0.0 -14.0 6.27 -14.0 14.0 c 0.0 7.73 6.27 14.0 14.0 14.0 c 7.73 0.0 14.0 -6.27 14.0 -14.0 c 0.0 -7.73 -6.27 -14.0 -14.0 -14.0 Z M 336.0 135.0 a 13.0 13.0 0.0 0 1 13.0 13.0 a 13.0 13.0 0.0 0 1 -13.0 13.0 a 13.0 13.0 0.0 0 1 -13.0 -13.0 a 13.0 13.0 0.0 0 1 13.0 -13.0 Z")
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
                strokeLineWidth = 1.8694036f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 189.0 c -6.08 0.0 -11.0 4.92 -11.0 11.0 c 0.0 6.08 4.92 11.0 11.0 11.0 c 6.08 0.0 11.0 -4.92 11.0 -11.0 c 0.0 -6.08 -4.92 -11.0 -11.0 -11.0 Z M 332.0 190.0 a 10.0 10.0 0.0 0 1 10.0 10.0 a 10.0 10.0 0.0 0 1 -10.0 10.0 a 10.0 10.0 0.0 0 1 -10.0 -10.0 a 10.0 10.0 0.0 0 1 10.0 -10.0 Z")
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
                strokeLineWidth = 1.8694037f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 328.0 237.0 c -3.87 0.0 -7.0 3.13 -7.0 7.0 c 0.0 3.87 3.13 7.0 7.0 7.0 c 3.87 0.0 7.0 -3.13 7.0 -7.0 c 0.0 -3.87 -3.13 -7.0 -7.0 -7.0 Z M 328.0 238.0 a 6.0 6.0 0.0 0 1 6.0 6.0 a 6.0 6.0 0.0 0 1 -6.0 6.0 a 6.0 6.0 0.0 0 1 -6.0 -6.0 a 6.0 6.0 0.0 0 1 6.0 -6.0 Z")
            )
        }.build()

        return _AvatarDefault!!
    }

@Suppress("ObjectPropertyName")
private var _AvatarDefault: ImageVector? = null
