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

val DriveHarddisk: ImageVector
    get() {
        if (_DriveHarddisk != null) {
            return _DriveHarddisk!!
        }
        _DriveHarddisk = ImageVector.Builder(
            name = "DriveHarddisk",
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
                pathData = addPathNodes("m 335.73 62.0 c -2.22 0.0 -3.97 0.05 -5.41 0.29 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.32 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.2 -0.28 5.42 v 12.25 v 12.25 c -0.01 2.23 0.04 3.98 0.28 5.42 c 0.24 1.44 0.7 2.62 1.56 3.48 c 0.86 0.86 2.04 1.31 3.48 1.56 c 1.44 0.24 3.19 0.29 5.41 0.29 h 16.54 c 2.22 0.0 3.97 -0.05 5.41 -0.29 c 1.44 -0.24 2.61 -0.7 3.47 -1.56 c 0.86 -0.86 1.31 -2.04 1.55 -3.48 c 0.24 -1.44 0.29 -3.19 0.29 -5.42 v -12.25 v -12.25 c 0.0 -2.23 -0.05 -3.98 -0.29 -5.42 c -0.24 -1.44 -0.69 -2.62 -1.55 -3.48 c -0.86 -0.86 -2.04 -1.32 -3.47 -1.56 c -1.44 -0.24 -3.19 -0.29 -5.41 -0.29 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.92 45.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 l 0.0 73.01 l 0.0 73.01 c -0.17 35.37 3.62 38.99 38.92 38.99 l 98.16 0.0 c 35.3 0.0 38.0 -3.64 38.92 -38.99 l 0.0 -73.01 l 0.0 -73.01 c 0.0 -35.37 -3.62 -38.99 -38.92 -38.99 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 102.92 45.0 c -35.3 0.0 -39.09 3.63 -38.92 38.99 l 0.0 73.01 l 0.0 73.01 c -0.17 35.37 3.62 38.99 38.92 38.99 l 98.16 0.0 c 35.3 0.0 38.92 -3.62 38.92 -38.99 l 0.0 -73.01 l 0.0 -73.01 c 0.0 -35.37 -3.62 -38.99 -38.92 -38.99 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(344f, 56f),
                    end = Offset(344f, 112f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 352.27 61.5 c 2.21 0.0 3.95 0.05 5.33 0.29 c 1.38 0.23 2.45 0.65 3.21 1.42 c 0.77 0.76 1.19 1.82 1.42 3.21 c 0.23 1.38 0.28 3.12 0.27 5.34 v 12.25 v 12.25 c 0.01 2.22 -0.04 3.95 -0.27 5.34 c -0.23 1.38 -0.65 2.44 -1.42 3.21 c -0.77 0.76 -1.83 1.19 -3.21 1.42 c -1.38 0.23 -3.12 0.29 -5.33 0.29 h -16.54 c -2.21 0.0 -3.94 -0.05 -5.33 -0.29 c -1.38 -0.23 -2.44 -0.65 -3.2 -1.42 c -0.76 -0.76 -1.18 -1.82 -1.42 -3.21 c -0.23 -1.38 -0.29 -3.12 -0.29 -5.34 v -12.25 v -12.25 c 0.0 -2.22 0.05 -3.95 0.29 -5.34 c 0.23 -1.38 0.65 -2.44 1.42 -3.21 c 0.76 -0.76 1.82 -1.19 3.2 -1.42 c 1.38 -0.23 3.11 -0.29 5.33 -0.29 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(144f, 28f),
                    end = Offset(144f, 284f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 201.07 44.0 c 35.3 0.0 39.09 3.63 38.92 38.99 v 73.01 v 73.01 c 0.17 35.37 -3.62 38.99 -38.92 38.99 h -98.16 c -35.3 0.0 -38.92 -3.63 -38.92 -38.99 v -73.01 v -73.01 c 0.0 -35.37 3.62 -38.99 38.92 -38.99 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(328f, 236f),
                    end = Offset(328f, 252f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.9 236.5 c 0.71 0.0 1.27 0.02 1.75 0.1 c 0.48 0.08 0.9 0.24 1.21 0.55 c 0.31 0.31 0.47 0.73 0.55 1.21 c 0.08 0.48 0.09 1.04 0.09 1.76 v 3.9 v 3.9 c 0.0 0.71 -0.01 1.28 -0.09 1.75 c -0.08 0.48 -0.24 0.9 -0.55 1.21 c -0.31 0.31 -0.73 0.47 -1.21 0.55 c -0.48 0.08 -1.04 0.1 -1.75 0.1 h -5.81 c -0.71 0.0 -1.27 -0.02 -1.75 -0.1 c -0.48 -0.08 -0.9 -0.24 -1.21 -0.55 c -0.31 -0.31 -0.46 -0.73 -0.54 -1.21 c -0.08 -0.48 -0.1 -1.04 -0.1 -1.75 v -3.9 v -3.9 c 0.0 -0.71 0.02 -1.28 0.1 -1.75 c 0.08 -0.48 0.24 -0.9 0.54 -1.21 c 0.31 -0.31 0.73 -0.47 1.21 -0.55 c 0.48 -0.08 1.04 -0.1 1.75 -0.1 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(332f, 185f),
                    end = Offset(332f, 214f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 336.13 188.5 c 1.11 0.0 1.99 0.03 2.71 0.15 c 0.72 0.12 1.31 0.35 1.74 0.78 c 0.43 0.43 0.66 1.02 0.78 1.74 c 0.12 0.72 0.14 1.6 0.14 2.71 v 6.12 v 6.13 c 0.0 1.11 -0.02 1.99 -0.14 2.71 c -0.12 0.72 -0.35 1.31 -0.78 1.74 c -0.43 0.43 -1.02 0.66 -1.74 0.78 c -0.72 0.12 -1.6 0.15 -2.71 0.15 h -8.27 c -1.11 0.0 -1.99 -0.03 -2.71 -0.15 c -0.72 -0.12 -1.31 -0.35 -1.74 -0.78 c -0.43 -0.43 -0.66 -1.02 -0.78 -1.74 c -0.12 -0.72 -0.15 -1.6 -0.15 -2.71 v -6.13 v -6.13 c 0.0 -1.11 0.03 -1.99 0.15 -2.71 c 0.12 -0.72 0.35 -1.31 0.78 -1.74 c 0.43 -0.43 1.02 -0.66 1.74 -0.78 c 0.72 -0.12 1.59 -0.15 2.71 -0.15 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(336f, 128f),
                    end = Offset(336f, 168f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 341.81 133.5 c 1.41 0.0 2.52 0.03 3.42 0.19 c 0.9 0.15 1.62 0.43 2.14 0.95 c 0.52 0.52 0.8 1.24 0.95 2.14 c 0.15 0.9 0.18 2.01 0.17 3.43 v 7.79 v 7.8 c 0.01 1.41 -0.02 2.52 -0.17 3.42 c -0.15 0.9 -0.43 1.62 -0.95 2.14 c -0.52 0.52 -1.24 0.8 -2.14 0.95 c -0.9 0.15 -2.01 0.19 -3.42 0.19 h -11.62 c -1.41 0.0 -2.52 -0.03 -3.42 -0.19 c -0.9 -0.15 -1.62 -0.43 -2.14 -0.95 c -0.52 -0.52 -0.8 -1.24 -0.95 -2.14 c -0.15 -0.9 -0.19 -2.01 -0.19 -3.43 v -7.8 v -7.8 c 0.0 -1.42 0.03 -2.52 0.19 -3.43 c 0.15 -0.9 0.43 -1.62 0.95 -2.14 c 0.52 -0.52 1.24 -0.8 2.14 -0.95 c 0.9 -0.15 2.01 -0.19 3.42 -0.19 Z")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 209.96 162.47 a 60.0 60.0 90.0 0 1 -35.0 70.96 a 60.0 60.0 90.0 0 1 -74.92 -25.43 a 60.0 60.0 90.0 0 1 15.44 -77.6 a 60.0 60.0 90.0 0 1 78.95 5.17 l -12.43 12.43")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 178.0 m -16.0 0.0 a 16.0 16.0 90.0 1 1 32.0 0.0 a 16.0 16.0 90.0 1 1 -32.0 0.0")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(144f, 108f),
                    end = Offset(144f, 252f)
                ),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 209.96 160.47 a 60.0 60.0 90.0 0 1 -35.0 70.96 a 60.0 60.0 90.0 0 1 -74.92 -25.43 a 60.0 60.0 90.0 0 1 15.44 -77.6 a 60.0 60.0 90.0 0 1 78.95 5.17 l -12.43 12.43")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(144f, 108f),
                    end = Offset(144f, 252f)
                ),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 176.0 m -16.0 0.0 a 16.0 16.0 90.0 1 1 32.0 0.0 a 16.0 16.0 90.0 1 1 -32.0 0.0")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.35 244.83 a 4.5 4.5 90.0 0 1 -2.62 5.32 a 4.5 4.5 90.0 0 1 -5.62 -1.91 a 4.5 4.5 90.0 0 1 1.16 -5.82 a 4.5 4.5 90.0 0 1 5.92 0.39 l -0.93 0.93")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 246.0 m -1.5 0.0 a 1.5 1.5 90.05 1 1 3.0 0.0 a 1.5 1.5 90.05 1 1 -3.0 0.0")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 338.28 200.32 c 0.84 3.15 -0.78 6.44 -3.79 7.69 c -3.01 1.25 -6.49 0.07 -8.12 -2.76 c -1.63 -2.83 -0.92 -6.42 1.67 -8.41 c 2.59 -1.99 6.25 -1.75 8.55 0.56 l -1.6 1.6")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 202.0 m -1.5 0.0 a 1.5 1.5 90.03 1 1 3.0 0.0 a 1.5 1.5 90.03 1 1 -3.0 0.0")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 355.59 85.89 a 12.0 12.0 90.0 0 1 -7.0 14.19 a 12.0 12.0 90.0 0 1 -14.99 -5.09 a 12.0 12.0 90.0 0 1 3.09 -15.52 a 12.0 12.0 90.0 0 1 15.79 1.03 l -2.49 2.49")
            )
            addPath(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 89.0 m -3.0 0.0 a 3.0 3.0 90.03 1 1 6.0 0.0 a 3.0 3.0 90.03 1 1 -6.0 0.0")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color(0xFFFBFBFB)),
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 151.0 m -2.5 0.0 a 2.5 2.5 0.0 1 1 5.0 0.0 a 2.5 2.5 0.0 1 1 -5.0 0.0")
            )
            addPath(
                fillAlpha = 0.2f,
                stroke = SolidColor(Color(0xFFFBFBFB)),
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.21 148.8 a 8.5 8.5 0.0 0 1 -4.96 10.05 a 8.5 8.5 0.0 0 1 -10.61 -3.6 a 8.5 8.5 0.0 0 1 2.19 -10.99 a 8.5 8.5 0.0 0 1 11.19 0.73 l -1.76 1.76")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.21 147.8 a 8.5 8.5 0.0 0 1 -4.96 10.05 a 8.5 8.5 0.0 0 1 -10.61 -3.6 a 8.5 8.5 0.0 0 1 2.19 -10.99 a 8.5 8.5 0.0 0 1 11.19 0.73 l -1.76 1.76")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 150.0 m -2.5 0.0 a 2.5 2.5 0.0 1 1 5.0 0.0 a 2.5 2.5 0.0 1 1 -5.0 0.0")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 355.59 84.89 a 12.0 12.0 90.0 0 1 -7.0 14.19 a 12.0 12.0 90.0 0 1 -14.99 -5.09 a 12.0 12.0 90.0 0 1 3.09 -15.52 a 12.0 12.0 90.0 0 1 15.79 1.03 l -2.49 2.49")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 88.0 m -3.0 0.0 a 3.0 3.0 90.03 1 1 6.0 0.0 a 3.0 3.0 90.03 1 1 -6.0 0.0")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.35 243.83 a 4.5 4.5 90.0 0 1 -2.62 5.32 a 4.5 4.5 90.0 0 1 -5.62 -1.91 a 4.5 4.5 90.0 0 1 1.16 -5.82 a 4.5 4.5 90.0 0 1 5.92 0.39 l -0.93 0.93")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 245.0 m -1.5 0.0 a 1.5 1.5 90.05 1 1 3.0 0.0 a 1.5 1.5 90.05 1 1 -3.0 0.0")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 338.28 199.32 c 0.84 3.15 -0.78 6.44 -3.79 7.69 c -3.01 1.25 -6.49 0.07 -8.12 -2.76 c -1.63 -2.83 -0.92 -6.42 1.67 -8.41 c 2.59 -1.99 6.25 -1.75 8.55 0.56 l -1.6 1.6")
            )
            addPath(
                stroke = SolidColor(Color(0xFF808080)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Square,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 201.0 m -1.5 0.0 a 1.5 1.5 90.03 1 1 3.0 0.0 a 1.5 1.5 90.03 1 1 -3.0 0.0")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.73 61.5 c -2.21 0.0 -3.95 0.05 -5.33 0.29 c -1.38 0.23 -2.45 0.65 -3.21 1.42 c -0.77 0.76 -1.19 1.82 -1.42 3.21 c -0.23 1.38 -0.28 3.12 -0.27 5.34 v 12.25 v 12.25 c -0.01 2.22 0.04 3.95 0.27 5.34 c 0.23 1.38 0.65 2.44 1.42 3.21 c 0.77 0.76 1.83 1.19 3.21 1.42 c 1.38 0.23 3.12 0.29 5.33 0.29 h 16.54 c 2.21 0.0 3.94 -0.05 5.33 -0.29 c 1.38 -0.23 2.44 -0.65 3.2 -1.42 c 0.76 -0.76 1.18 -1.82 1.42 -3.21 c 0.23 -1.38 0.29 -3.12 0.29 -5.34 v -12.25 v -12.25 c 0.0 -2.22 -0.05 -3.95 -0.29 -5.34 c -0.23 -1.38 -0.65 -2.44 -1.42 -3.21 c -0.76 -0.76 -1.82 -1.19 -3.2 -1.42 c -1.38 -0.23 -3.11 -0.29 -5.33 -0.29 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.19 133.5 c -1.41 0.0 -2.52 0.03 -3.42 0.19 c -0.9 0.15 -1.62 0.43 -2.14 0.95 c -0.52 0.52 -0.8 1.24 -0.95 2.14 c -0.15 0.9 -0.18 2.01 -0.17 3.43 v 7.79 v 7.8 c -0.01 1.41 0.02 2.52 0.17 3.42 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.19 3.42 0.19 h 11.62 c 1.41 0.0 2.52 -0.03 3.42 -0.19 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.15 -0.9 0.19 -2.01 0.19 -3.43 v -7.8 v -7.8 c 0.0 -1.42 -0.03 -2.52 -0.19 -3.43 c -0.15 -0.9 -0.43 -1.62 -0.95 -2.14 c -0.52 -0.52 -1.24 -0.8 -2.14 -0.95 c -0.9 -0.15 -2.01 -0.19 -3.42 -0.19 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.87 188.5 c -1.11 0.0 -1.99 0.03 -2.71 0.15 c -0.72 0.12 -1.31 0.35 -1.74 0.78 c -0.43 0.43 -0.66 1.02 -0.78 1.74 c -0.12 0.72 -0.14 1.6 -0.14 2.71 v 6.12 v 6.13 c -0.0 1.11 0.02 1.99 0.14 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.15 2.71 0.15 h 8.27 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.6 0.15 -2.71 v -6.13 v -6.13 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.59 -0.15 -2.71 -0.15 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.1 236.5 c -0.71 0.0 -1.27 0.02 -1.75 0.1 c -0.48 0.08 -0.9 0.24 -1.21 0.55 c -0.31 0.31 -0.47 0.73 -0.55 1.21 c -0.08 0.48 -0.09 1.04 -0.09 1.76 v 3.9 v 3.9 c -0.0 0.71 0.01 1.28 0.09 1.75 c 0.08 0.48 0.24 0.9 0.55 1.21 c 0.31 0.31 0.73 0.47 1.21 0.55 c 0.48 0.08 1.04 0.1 1.75 0.1 h 5.81 c 0.71 0.0 1.27 -0.02 1.75 -0.1 c 0.48 -0.08 0.9 -0.24 1.21 -0.55 c 0.31 -0.31 0.46 -0.73 0.54 -1.21 c 0.08 -0.48 0.1 -1.04 0.1 -1.75 v -3.9 v -3.9 c 0.0 -0.71 -0.02 -1.28 -0.1 -1.75 c -0.08 -0.48 -0.24 -0.9 -0.54 -1.21 c -0.31 -0.31 -0.73 -0.47 -1.21 -0.55 c -0.48 -0.08 -1.04 -0.1 -1.75 -0.1 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 64.0 227.01 v 2.0 c -0.17 35.37 3.63 38.99 38.92 38.99 h 98.16 c 35.3 0.0 38.0 -3.64 38.92 -38.99 v -2.0 c -0.92 35.36 -3.63 38.99 -38.92 38.99 h -98.16 c -35.3 0.0 -39.09 -3.63 -38.92 -38.99 Z")
            )
            group(
                clipPathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 L 326.0 84.0 L 326.0 96.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 L 362.0 84.0 L 362.0 71.75 C 362.0 62.91 361.09 62.0 352.27 62.0 Z")
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
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 335.73 62.0 c -8.82 0.0 -9.77 0.91 -9.73 9.75 v 12.25 v 12.25 c -0.04 8.84 0.91 9.75 9.73 9.75 h 16.54 c 8.82 0.0 9.73 -0.91 9.73 -9.75 v -12.25 v -12.25 c 0.0 -8.84 -0.91 -9.75 -9.73 -9.75 Z")
                )
            }
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
                    pathData = addPathNodes("m 327.87 189.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 v 6.13 v 6.13 c -0.02 4.42 0.45 4.87 4.87 4.87 h 8.27 c 4.41 0.0 4.87 -0.45 4.87 -4.87 v -6.13 v -6.13 c 0.0 -4.42 -0.45 -4.87 -4.87 -4.87 Z")
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
                    pathData = addPathNodes("m 325.1 237.0 c -2.81 0.0 -3.11 0.29 -3.1 3.1 v 3.9 v 3.9 c -0.01 2.81 0.29 3.1 3.1 3.1 h 5.81 c 2.81 0.0 3.1 -0.29 3.1 -3.1 v -3.9 v -3.9 c 0.0 -2.81 -0.29 -3.1 -3.1 -3.1 Z")
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
        }.build()

        return _DriveHarddisk!!
    }

@Suppress("ObjectPropertyName")
private var _DriveHarddisk: ImageVector? = null
