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

val DriveOptical: ImageVector
    get() {
        if (_DriveOptical != null) {
            return _DriveOptical!!
        }
        _DriveOptical = ImageVector.Builder(
            name = "DriveOptical",
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
                pathData = addPathNodes("m 367.0 76.73 c 0.0 -2.22 -0.05 -3.97 -0.29 -5.41 c -0.24 -1.44 -0.7 -2.62 -1.56 -3.48 c -0.86 -0.86 -2.04 -1.32 -3.48 -1.56 c -1.44 -0.24 -3.2 -0.29 -5.42 -0.28 h -12.25 h -12.25 c -2.23 -0.01 -3.98 0.04 -5.42 0.28 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.31 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.19 -0.29 5.41 v 16.54 c 0.0 2.22 0.05 3.97 0.29 5.41 c 0.24 1.44 0.7 2.61 1.56 3.47 c 0.86 0.86 2.04 1.31 3.48 1.55 c 1.44 0.24 3.19 0.29 5.42 0.29 h 12.25 h 12.25 c 2.23 0.0 3.98 -0.05 5.42 -0.29 c 1.44 -0.24 2.62 -0.69 3.48 -1.55 c 0.86 -0.86 1.32 -2.04 1.56 -3.47 c 0.24 -1.44 0.29 -3.19 0.29 -5.41 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 107.92 c -0.0 -35.3 -3.63 -39.09 -38.99 -38.92 l -73.01 0.0 l -73.01 0.0 c -35.37 -0.17 -38.99 3.62 -38.99 38.92 l -0.0 98.16 c -0.0 35.3 3.64 38.0 38.99 38.92 l 73.01 0.0 l 73.01 0.0 c 35.37 0.0 38.99 -3.62 38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 107.92 c -0.0 -35.3 -3.63 -39.09 -38.99 -38.92 l -73.01 0.0 l -73.01 0.0 c -35.37 -0.17 -38.99 3.62 -38.99 38.92 l -0.0 98.16 c -0.0 35.3 3.62 38.92 38.99 38.92 l 73.01 0.0 l 73.01 0.0 c 35.37 0.0 38.99 -3.62 38.99 -38.92 Z")
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
                pathData = addPathNodes("m 366.5 92.27 c 0.0 2.21 -0.05 3.95 -0.29 5.33 c -0.23 1.38 -0.65 2.45 -1.42 3.21 c -0.76 0.77 -1.82 1.19 -3.21 1.42 c -1.38 0.23 -3.12 0.28 -5.34 0.27 h -12.25 h -12.25 c -2.22 0.01 -3.95 -0.04 -5.34 -0.27 c -1.38 -0.23 -2.44 -0.65 -3.21 -1.42 c -0.76 -0.77 -1.19 -1.83 -1.42 -3.21 c -0.23 -1.38 -0.29 -3.12 -0.29 -5.33 v -16.54 c 0.0 -2.21 0.05 -3.94 0.29 -5.33 c 0.23 -1.38 0.65 -2.44 1.42 -3.2 c 0.76 -0.76 1.82 -1.18 3.21 -1.42 c 1.38 -0.23 3.12 -0.29 5.34 -0.29 h 12.25 h 12.25 c 2.22 0.0 3.95 0.05 5.34 0.29 c 1.38 0.23 2.44 0.65 3.21 1.42 c 0.76 0.76 1.19 1.82 1.42 3.2 c 0.23 1.38 0.29 3.11 0.29 5.33 Z")
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
                pathData = addPathNodes("m 264.0 205.08 c 0.0 35.3 -3.63 39.09 -38.99 38.92 H 152.0 H 78.99 C 43.62 244.17 40.0 240.37 40.0 205.08 v -98.16 c 0.0 -35.3 3.63 -38.92 38.99 -38.92 h 73.01 h 73.01 c 35.37 0.0 38.99 3.62 38.99 38.92 Z")
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
                pathData = addPathNodes("m 320.5 241.1 c 0.0 -0.71 0.02 -1.27 0.1 -1.75 c 0.08 -0.48 0.24 -0.9 0.55 -1.21 c 0.31 -0.31 0.73 -0.47 1.21 -0.55 c 0.48 -0.08 1.04 -0.09 1.76 -0.09 h 3.9 h 3.9 c 0.71 -0.0 1.28 0.01 1.75 0.09 c 0.48 0.08 0.9 0.24 1.21 0.55 c 0.31 0.31 0.47 0.73 0.55 1.21 c 0.08 0.48 0.1 1.04 0.1 1.75 v 5.81 c 0.0 0.71 -0.02 1.27 -0.1 1.75 c -0.08 0.48 -0.24 0.9 -0.55 1.21 c -0.31 0.31 -0.73 0.46 -1.21 0.54 c -0.48 0.08 -1.04 0.1 -1.75 0.1 h -3.9 h -3.9 c -0.71 0.0 -1.28 -0.02 -1.75 -0.1 c -0.48 -0.08 -0.9 -0.24 -1.21 -0.54 c -0.31 -0.31 -0.47 -0.73 -0.55 -1.21 c -0.08 -0.48 -0.1 -1.04 -0.1 -1.75 Z")
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
                pathData = addPathNodes("m 320.5 195.87 c 0.0 -1.11 0.03 -1.99 0.15 -2.71 c 0.12 -0.72 0.35 -1.31 0.78 -1.74 c 0.43 -0.43 1.02 -0.66 1.74 -0.78 c 0.72 -0.12 1.6 -0.14 2.71 -0.14 h 6.12 h 6.13 c 1.11 -0.0 1.99 0.02 2.71 0.14 c 0.72 0.12 1.31 0.35 1.74 0.78 c 0.43 0.43 0.66 1.02 0.78 1.74 c 0.12 0.72 0.15 1.6 0.15 2.71 v 8.27 c 0.0 1.11 -0.03 1.99 -0.15 2.71 c -0.12 0.72 -0.35 1.31 -0.78 1.74 c -0.43 0.43 -1.02 0.66 -1.74 0.78 c -0.72 0.12 -1.6 0.15 -2.71 0.15 h -6.13 h -6.13 c -1.11 0.0 -1.99 -0.03 -2.71 -0.15 c -0.72 -0.12 -1.31 -0.35 -1.74 -0.78 c -0.43 -0.43 -0.66 -1.02 -0.78 -1.74 c -0.12 -0.72 -0.15 -1.59 -0.15 -2.71 Z")
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
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 321.5 142.19 c 0.0 -1.41 0.03 -2.52 0.19 -3.42 c 0.15 -0.9 0.43 -1.62 0.95 -2.14 c 0.52 -0.52 1.24 -0.8 2.14 -0.95 c 0.9 -0.15 2.01 -0.18 3.43 -0.17 h 7.79 h 7.8 c 1.41 -0.01 2.52 0.02 3.42 0.17 c 0.9 0.15 1.62 0.43 2.14 0.95 c 0.52 0.52 0.8 1.24 0.95 2.14 c 0.15 0.9 0.19 2.01 0.19 3.42 v 11.62 c 0.0 1.41 -0.03 2.52 -0.19 3.42 c -0.15 0.9 -0.43 1.62 -0.95 2.14 c -0.52 0.52 -1.24 0.8 -2.14 0.95 c -0.9 0.15 -2.01 0.19 -3.43 0.19 h -7.8 h -7.8 c -1.42 0.0 -2.52 -0.03 -3.43 -0.19 c -0.9 -0.15 -1.62 -0.43 -2.14 -0.95 c -0.52 -0.52 -0.8 -1.24 -0.95 -2.14 c -0.15 -0.9 -0.19 -2.01 -0.19 -3.42 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 203.08 v 2.0 c 0.0 35.3 3.62 39.09 38.99 38.92 h 73.01 h 73.01 c 35.37 0.17 38.99 -3.63 38.99 -38.92 v -2.0 c 0.0 35.3 -3.63 39.09 -38.99 38.92 H 152.0 H 78.99 c -35.37 0.17 -38.99 -3.63 -38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 196.0 v 9.08 c 0.0 35.3 3.62 39.09 38.99 38.92 h 73.01 h 73.01 c 35.37 0.17 38.99 -3.63 38.99 -38.92 V 196.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 64.5 213.48 c 0.07 4.53 0.12 9.05 0.33 13.57 c 49.54 0.77 99.32 0.6 148.84 0.37 c 8.51 -0.08 17.03 -0.13 25.54 -0.34 c 0.2 -5.0 0.31 -10.0 0.39 -15.01 c -58.37 0.0 -116.75 0.0 -175.12 0.0 c 0.01 0.47 0.01 0.94 0.02 1.41 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("M 40.0 194.0 h 224.0 v 2.0 h -224.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 64.48 214.07 c 0.01 0.47 0.01 0.94 0.02 1.41 c 0.07 4.53 0.12 9.05 0.33 13.57 c 49.54 0.77 99.32 0.6 148.85 0.37 c 8.51 -0.08 17.03 -0.13 25.54 -0.34 c 0.2 -5.0 0.31 -10.0 0.39 -15.01 h -0.04 c -0.08 4.34 -0.18 8.67 -0.35 13.01 c -8.51 0.21 -17.02 0.27 -25.54 0.34 c -49.52 0.23 -99.31 0.41 -148.85 -0.37 c -0.2 -4.32 -0.26 -8.65 -0.32 -12.98 Z")
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
                pathData = addPathNodes("m 366.5 92.27 c 0.0 2.21 -0.05 3.95 -0.29 5.33 c -0.23 1.38 -0.65 2.45 -1.42 3.21 c -0.76 0.77 -1.82 1.19 -3.21 1.42 c -1.38 0.23 -3.12 0.28 -5.34 0.27 h -12.25 h -12.25 c -2.22 0.01 -3.95 -0.04 -5.34 -0.27 c -1.38 -0.23 -2.44 -0.65 -3.21 -1.42 c -0.76 -0.77 -1.19 -1.83 -1.42 -3.21 c -0.23 -1.38 -0.29 -3.12 -0.29 -5.33 V 75.73 c 0.0 -2.21 0.05 -3.94 0.29 -5.33 c 0.23 -1.38 0.65 -2.44 1.42 -3.2 c 0.76 -0.76 1.82 -1.18 3.21 -1.42 c 1.38 -0.23 3.12 -0.29 5.34 -0.29 h 12.25 h 12.25 c 2.22 0.0 3.95 0.05 5.34 0.29 c 1.38 0.23 2.44 0.65 3.21 1.42 c 0.76 0.76 1.19 1.82 1.42 3.2 c 0.23 1.38 0.29 3.11 0.29 5.33 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 321.5 90.0 v 2.27 c 0.0 2.21 0.05 3.95 0.29 5.33 c 0.23 1.38 0.65 2.45 1.42 3.21 c 0.76 0.77 1.82 1.19 3.21 1.42 c 1.38 0.23 3.12 0.28 5.34 0.27 H 344.0 H 356.25 c 2.22 0.01 3.95 -0.04 5.34 -0.27 c 1.38 -0.23 2.44 -0.65 3.21 -1.42 c 0.76 -0.77 1.19 -1.83 1.42 -3.21 C 366.45 96.22 366.5 94.48 366.5 92.27 V 90.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.15f,
                strokeAlpha = 0.15f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 321.5 89.0 v 1.0 h 45.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 321.5 154.0 c 0.0 1.31 0.04 2.37 0.18 3.23 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.19 3.43 0.19 H 336.0 h 7.8 c 1.42 0.0 2.52 -0.03 3.43 -0.19 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.14 -0.85 0.18 -1.91 0.18 -3.23 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 324.64 156.21 c 0.09 0.69 0.07 1.75 0.92 1.95 c 1.59 0.42 2.24 0.19 3.85 0.28 c 5.6 0.01 10.21 0.07 15.8 -0.06 c 0.71 -0.1 1.75 -0.11 1.95 -0.98 c 0.13 -0.45 0.16 -0.92 0.19 -1.38 h -22.75 c 0.01 0.06 0.01 0.13 0.02 0.19 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 321.5 153.0 c 0.0 0.37 0.01 0.67 0.02 1.0 h 28.95 c 0.01 -0.33 0.02 -0.63 0.02 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 203.0 v 1.13 c 0.0 1.11 0.03 1.99 0.15 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.15 2.71 0.15 h 6.13 h 6.13 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.59 0.15 -2.71 V 203.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 202.0 v 1.0 h 23.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 320.5 247.0 c 0.0 0.66 0.02 1.2 0.09 1.65 c 0.08 0.48 0.24 0.9 0.55 1.21 c 0.31 0.31 0.73 0.46 1.21 0.54 c 0.48 0.08 1.04 0.1 1.75 0.1 H 328.0 h 3.9 c 0.71 0.0 1.28 -0.02 1.75 -0.1 c 0.48 -0.08 0.9 -0.24 1.21 -0.54 c 0.31 -0.31 0.47 -0.73 0.55 -1.21 c 0.08 -0.45 0.09 -0.99 0.09 -1.65 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 320.5 246.0 c 0.0 0.37 0.01 0.7 0.03 1.0 h 14.94 c 0.02 -0.3 0.03 -0.63 0.03 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.71689266f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 73.4 212.0 A 80.29 80.29 0.0 0 0 152.0 276.29 A 80.29 80.29 0.0 0 0 230.68 212.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.71689254f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 72.58 212.0 A 81.73 81.73 0.0 0 0 152.0 274.86 A 81.73 81.73 0.0 0 0 231.43 212.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        1f to Color(0xFFD9D9D9)
                    ),
                    start = Offset(117.59f, 112.84f),
                    end = Offset(186.41f, 273.42f)
                ),
                strokeLineWidth = 0.71689266f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 74.05 212.0 A 80.29 80.29 0.0 0 0 152.0 273.42 A 80.29 80.29 0.0 0 0 229.95 212.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.71689266f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 152.0 212.0 v 61.42 A 80.29 80.29 0.0 0 0 229.95 212.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.02000002f,
                strokeAlpha = 0.02000002f,
                strokeLineWidth = 0.71689266f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 133.13 212.0 l -37.91 37.91 a 80.29 80.29 0.0 0 0 113.55 0.0 L 170.87 212.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.71689266f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 170.88 212.0 l 37.88 37.88 a 80.29 80.29 0.0 0 0 12.78 -16.61 L 184.69 212.0 Z M 208.47 250.2 a 80.29 80.29 0.0 0 1 -0.91 0.85 a 80.29 80.29 0.0 0 0 0.91 -0.85 Z M 203.43 254.72 a 80.29 80.29 0.0 0 1 -3.18 2.49 a 80.29 80.29 0.0 0 0 3.18 -2.49 Z M 197.02 259.55 a 80.29 80.29 0.0 0 1 -3.41 2.16 a 80.29 80.29 0.0 0 0 3.41 -2.16 Z M 111.91 262.58 L 111.86 262.67 a 80.29 80.29 0.0 0 0 1.37 0.7 a 80.29 80.29 0.0 0 1 -1.32 -0.78 Z M 190.17 263.71 a 80.29 80.29 0.0 0 1 -3.61 1.81 a 80.29 80.29 0.0 0 0 3.61 -1.81 Z M 116.79 265.19 a 80.29 80.29 0.0 0 0 3.64 1.7 a 80.29 80.29 0.0 0 1 -3.64 -1.7 Z M 182.92 267.17 a 80.29 80.29 0.0 0 1 -3.76 1.43 a 80.29 80.29 0.0 0 0 3.76 -1.43 Z M 124.18 268.35 a 80.29 80.29 0.0 0 0 3.77 1.32 a 80.29 80.29 0.0 0 1 -3.77 -1.32 Z M 175.38 269.88 a 80.29 80.29 0.0 0 1 -3.88 1.05 a 80.29 80.29 0.0 0 0 3.88 -1.05 Z M 131.83 270.76 a 80.29 80.29 0.0 0 0 3.88 0.93 a 80.29 80.29 0.0 0 1 -3.88 -0.93 Z M 167.6 271.83 a 80.29 80.29 0.0 0 1 -3.96 0.66 a 80.29 80.29 0.0 0 0 3.96 -0.66 Z M 139.67 272.38 a 80.29 80.29 0.0 0 0 3.98 0.54 a 80.29 80.29 0.0 0 1 -3.98 -0.54 Z M 159.65 273.0 a 80.29 80.29 0.0 0 1 -3.99 0.26 a 80.29 80.29 0.0 0 0 3.99 -0.26 Z M 147.64 273.22 a 80.29 80.29 0.0 0 0 4.0 0.14 a 80.29 80.29 0.0 0 1 -4.0 -0.14 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF7F7F7F)),
                strokeLineWidth = 1.9788116f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 128.0 212.0 c 5.44 6.22 12.86 10.99 24.0 11.0 c 9.88 0.11 18.57 -4.78 24.0 -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 1.8434381f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 134.44 212.0 A 25.81 25.81 0.0 0 0 152.0 218.94 A 25.81 25.81 0.0 0 0 169.58 212.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.71689266f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 74.05 212.0 A 80.29 80.29 0.0 0 0 152.0 273.42 A 80.29 80.29 0.0 0 0 229.95 212.0 h -0.34 A 80.29 80.29 0.0 0 1 152.0 271.99 A 80.29 80.29 0.0 0 1 74.45 212.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF969696)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 72.0 196.0 h 164.0 v 16.0 h -164.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 64.48 212.07 c 0.01 0.47 0.01 0.94 0.02 1.41 c 0.0 0.2 0.01 0.4 0.01 0.59 H 239.56 c 0.01 -0.67 0.03 -1.33 0.04 -2.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 366.5 75.73 c 0.0 -2.21 -0.05 -3.95 -0.29 -5.33 c -0.23 -1.38 -0.65 -2.45 -1.42 -3.21 c -0.76 -0.77 -1.82 -1.19 -3.21 -1.42 c -1.38 -0.23 -3.12 -0.28 -5.34 -0.27 h -12.25 h -12.25 c -2.22 -0.01 -3.95 0.04 -5.34 0.27 c -1.38 0.23 -2.44 0.65 -3.21 1.42 c -0.76 0.77 -1.19 1.83 -1.42 3.21 c -0.23 1.38 -0.29 3.12 -0.29 5.33 v 16.54 c 0.0 2.21 0.05 3.94 0.29 5.33 c 0.23 1.38 0.65 2.44 1.42 3.2 c 0.76 0.76 1.82 1.18 3.21 1.42 c 1.38 0.23 3.12 0.29 5.34 0.29 h 12.25 h 12.25 c 2.22 0.0 3.95 -0.05 5.34 -0.29 c 1.38 -0.23 2.44 -0.65 3.21 -1.42 c 0.76 -0.76 1.19 -1.82 1.42 -3.2 c 0.23 -1.38 0.29 -3.11 0.29 -5.33 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 321.5 153.81 c 0.0 1.41 0.03 2.52 0.19 3.42 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.18 3.43 0.17 h 7.79 h 7.8 c 1.41 0.01 2.52 -0.02 3.42 -0.17 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.15 -0.9 0.19 -2.01 0.19 -3.42 v -11.62 c 0.0 -1.41 -0.03 -2.52 -0.19 -3.42 c -0.15 -0.9 -0.43 -1.62 -0.95 -2.14 c -0.52 -0.52 -1.24 -0.8 -2.14 -0.95 c -0.9 -0.15 -2.01 -0.19 -3.43 -0.19 h -7.8 h -7.8 c -1.42 0.0 -2.52 0.03 -3.43 0.19 c -0.9 0.15 -1.62 0.43 -2.14 0.95 c -0.52 0.52 -0.8 1.24 -0.95 2.14 c -0.15 0.9 -0.19 2.01 -0.19 3.42 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 204.13 c 0.0 1.11 0.03 1.99 0.15 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.14 2.71 0.14 h 6.12 h 6.13 c 1.11 0.0 1.99 -0.02 2.71 -0.14 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.6 0.15 -2.71 v -8.27 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.6 -0.15 -2.71 -0.15 h -6.13 h -6.13 c -1.11 0.0 -1.99 0.03 -2.71 0.15 c -0.72 0.12 -1.31 0.35 -1.74 0.78 c -0.43 0.43 -0.66 1.02 -0.78 1.74 c -0.12 0.72 -0.15 1.59 -0.15 2.71 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 246.9 c 0.0 0.71 0.02 1.27 0.1 1.75 c 0.08 0.48 0.24 0.9 0.55 1.21 c 0.31 0.31 0.73 0.47 1.21 0.55 c 0.48 0.08 1.04 0.09 1.76 0.09 h 3.9 h 3.9 c 0.71 0.0 1.28 -0.01 1.75 -0.09 c 0.48 -0.08 0.9 -0.24 1.21 -0.55 c 0.31 -0.31 0.47 -0.73 0.55 -1.21 c 0.08 -0.48 0.1 -1.04 0.1 -1.75 v -5.81 c 0.0 -0.71 -0.02 -1.27 -0.1 -1.75 c -0.08 -0.48 -0.24 -0.9 -0.55 -1.21 c -0.31 -0.31 -0.73 -0.46 -1.21 -0.54 c -0.48 -0.08 -1.04 -0.1 -1.75 -0.1 h -3.9 h -3.9 c -0.71 0.0 -1.28 0.02 -1.75 0.1 c -0.48 0.08 -0.9 0.24 -1.21 0.54 c -0.31 0.31 -0.47 0.73 -0.55 1.21 c -0.08 0.48 -0.1 1.04 -0.1 1.75 Z")
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
                        start = Offset(344f, 62f),
                        end = Offset(344f, 106f)
                    ),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 366.0 75.73 c -0.0 -8.82 -0.91 -9.77 -9.75 -9.73 L 344.0 66.0 L 331.75 66.0 c -8.84 -0.04 -9.75 0.91 -9.75 9.73 l -0.0 16.54 c -0.0 8.82 0.91 9.73 9.75 9.73 L 344.0 102.0 L 356.25 102.0 C 365.09 102.0 366.0 101.09 366.0 92.27 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 321.0 204.13 c 0.0 4.41 0.45 4.89 4.87 4.87 L 332.0 209.0 L 338.13 209.0 C 342.55 209.02 343.0 208.55 343.0 204.13 l 0.0 -8.27 C 343.0 191.45 342.55 191.0 338.13 191.0 L 332.0 191.0 L 325.87 191.0 C 321.45 191.0 321.0 191.45 321.0 195.86 Z")
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
                    pathData = addPathNodes("m 321.0 204.13 c 0.0 4.41 0.45 4.89 4.87 4.87 L 332.0 209.0 L 338.13 209.0 C 342.55 209.02 343.0 208.55 343.0 204.13 l 0.0 -8.27 C 343.0 191.45 342.55 191.0 338.13 191.0 L 332.0 191.0 L 325.87 191.0 C 321.45 191.0 321.0 191.45 321.0 195.86 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 321.0 246.9 c 0.0 2.81 0.29 3.11 3.1 3.1 L 328.0 250.0 l 3.9 -0.0 c 2.81 0.01 3.1 -0.29 3.1 -3.1 l 0.0 -5.81 C 335.0 238.29 334.71 238.0 331.9 238.0 L 328.0 238.0 L 324.1 238.0 C 321.29 238.0 321.0 238.29 321.0 241.1 Z")
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
                    pathData = addPathNodes("m 321.0 246.9 c 0.0 2.81 0.29 3.11 3.1 3.1 L 328.0 250.0 l 3.9 -0.0 c 2.81 0.01 3.1 -0.29 3.1 -3.1 l 0.0 -5.81 C 335.0 238.29 334.71 238.0 331.9 238.0 L 328.0 238.0 L 324.1 238.0 C 321.29 238.0 321.0 238.29 321.0 241.1 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 322.0 153.81 c 0.0 5.62 0.58 6.22 6.2 6.19 l 7.8 -0.0 l 7.8 -0.0 c 5.63 0.03 6.2 -0.58 6.2 -6.19 l 0.0 -11.61 c 0.0 -5.62 -0.58 -6.19 -6.2 -6.19 l -7.8 -0.0 l -7.8 -0.0 c -5.63 -0.0 -6.2 0.58 -6.2 6.19 Z")
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
                    pathData = addPathNodes("m 322.0 153.81 c 0.0 5.62 0.58 6.22 6.2 6.19 l 7.8 -0.0 l 7.8 -0.0 c 5.63 0.03 6.2 -0.58 6.2 -6.19 l 0.0 -11.61 c 0.0 -5.62 -0.58 -6.19 -6.2 -6.19 l -7.8 -0.0 l -7.8 -0.0 c -5.63 -0.0 -6.2 0.58 -6.2 6.19 Z")
                )
            }
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 325.61 94.42 c 0.12 1.17 -0.02 2.46 0.53 3.53 c 1.65 0.59 3.45 0.27 5.16 0.39 c 9.1 0.03 18.33 0.09 27.42 -0.02 c 1.02 -0.11 2.18 0.12 3.11 -0.37 c 0.62 -0.93 0.38 -2.18 0.5 -3.24 c 0.38 -1.09 -0.85 -0.61 -1.48 -0.7 c -11.75 0.0 -23.5 0.0 -35.25 0.0 c 0.0 0.14 0.01 0.27 0.02 0.41 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 325.59 95.01 c 0.0 0.14 0.01 0.27 0.02 0.41 c 0.12 1.17 -0.02 2.46 0.53 3.53 c 1.65 0.59 3.45 0.27 5.16 0.38 c 9.1 0.03 18.33 0.09 27.42 -0.02 c 1.02 -0.11 2.18 0.12 3.12 -0.37 c 0.62 -0.93 0.38 -2.18 0.5 -3.24 c 0.11 -0.3 0.08 -0.48 -0.02 -0.58 c -0.04 0.96 0.07 2.01 -0.48 2.82 c -0.94 0.49 -2.09 0.26 -3.12 0.37 c -9.09 0.11 -18.31 0.05 -27.42 0.02 c -1.71 -0.12 -3.51 0.2 -5.16 -0.38 c -0.46 -0.89 -0.45 -1.94 -0.5 -2.94 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.5719972f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.08 94.0 A 18.5 18.5 0.0 0 0 344.0 108.0 A 18.5 18.5 0.0 0 0 361.92 94.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        1f to Color(0xFFD9D9D9)
                    ),
                    start = Offset(335.54f, 71.64f),
                    end = Offset(354.06f, 104.38f)
                ),
                strokeLineWidth = 1.5036491f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.72 94.0 A 18.1 18.1 0.0 0 0 344.0 106.79 A 18.1 18.1 0.0 0 0 361.3 94.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.16158757f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.0 94.0 v 12.79 A 18.1 18.1 0.0 0 0 361.29 94.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.02000002f,
                strokeAlpha = 0.02000002f,
                strokeLineWidth = 0.16158757f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 338.7 94.0 l -7.49 7.49 a 18.1 18.1 0.0 0 0 25.59 0.0 L 349.31 94.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.16158757f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 349.31 94.0 l 7.49 7.49 a 18.1 18.1 0.0 0 0 2.88 -3.74 L 353.19 94.0 Z M 356.73 101.56 a 18.1 18.1 0.0 0 1 -0.21 0.19 a 18.1 18.1 0.0 0 0 0.21 -0.19 Z M 355.6 102.58 a 18.1 18.1 0.0 0 1 -0.72 0.56 a 18.1 18.1 0.0 0 0 0.72 -0.56 Z M 354.15 103.67 a 18.1 18.1 0.0 0 1 -0.77 0.49 a 18.1 18.1 0.0 0 0 0.77 -0.49 Z M 334.97 104.35 L 334.96 104.37 a 18.1 18.1 0.0 0 0 0.31 0.16 a 18.1 18.1 0.0 0 1 -0.3 -0.18 Z M 352.61 104.6 a 18.1 18.1 0.0 0 1 -0.81 0.41 a 18.1 18.1 0.0 0 0 0.81 -0.41 Z M 336.07 104.94 a 18.1 18.1 0.0 0 0 0.82 0.38 a 18.1 18.1 0.0 0 1 -0.82 -0.38 Z M 350.97 105.38 a 18.1 18.1 0.0 0 1 -0.85 0.32 a 18.1 18.1 0.0 0 0 0.85 -0.32 Z M 337.73 105.65 a 18.1 18.1 0.0 0 0 0.85 0.3 a 18.1 18.1 0.0 0 1 -0.85 -0.3 Z M 349.27 106.0 a 18.1 18.1 0.0 0 1 -0.88 0.24 a 18.1 18.1 0.0 0 0 0.88 -0.24 Z M 339.46 106.19 a 18.1 18.1 0.0 0 0 0.88 0.21 a 18.1 18.1 0.0 0 1 -0.88 -0.21 Z M 347.52 106.44 a 18.1 18.1 0.0 0 1 -0.89 0.15 a 18.1 18.1 0.0 0 0 0.89 -0.15 Z M 341.22 106.56 a 18.1 18.1 0.0 0 0 0.9 0.12 a 18.1 18.1 0.0 0 1 -0.9 -0.12 Z M 345.73 106.7 a 18.1 18.1 0.0 0 1 -0.9 0.06 a 18.1 18.1 0.0 0 0 0.9 -0.06 Z M 343.02 106.75 a 18.1 18.1 0.0 0 0 0.9 0.03 a 18.1 18.1 0.0 0 1 -0.9 -0.03 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF7F7F7F)),
                strokeLineWidth = 0.5175492f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 338.02 94.0 a 7.5 7.5 0.0 0 0 5.99 3.0 a 7.5 7.5 0.0 0 0 5.99 -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.46428573f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 339.32 94.0 a 6.5 6.5 0.0 0 0 4.69 2.0 a 6.5 6.5 0.0 0 0 4.68 -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1.5719972f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.29 94.0 A 18.5 18.5 0.0 0 0 344.0 107.2 A 18.5 18.5 0.0 0 0 361.71 94.0 h -0.82 c -2.25 7.18 -8.96 12.39 -16.88 12.39 c -7.92 0.0 -14.63 -5.21 -16.88 -12.39 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(344f, 71f),
                    end = Offset(344f, 106.39f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 1.5036491f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.13 94.0 A 17.7 17.7 0.0 0 0 344.0 106.39 A 17.7 17.7 0.0 0 0 360.87 94.0 h -0.8 A 16.93 16.93 0.0 0 1 344.0 105.62 A 16.93 16.93 0.0 0 1 327.95 94.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 361.96 93.99 c -0.34 -0.03 -0.8 0.07 -1.12 0.02 h -35.25 c 0.0 0.14 0.01 0.27 0.02 0.41 c 0.02 0.19 0.02 0.4 0.03 0.59 h 35.21 c 0.46 0.07 1.21 -0.15 1.46 0.12 c 0.01 -0.14 0.01 -0.28 0.02 -0.42 c 0.19 -0.54 -0.02 -0.69 -0.36 -0.72 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.5634992f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 324.7 156.0 A 12.0 12.0 0.0 0 0 336.0 164.0 a 12.0 12.0 0.0 0 0 11.3 -8.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        1f to Color(0xFFE9E9E9)
                    ),
                    start = Offset(330.58f, 140.27f),
                    end = Offset(342.44f, 161.25f)
                ),
                strokeLineWidth = 1.4955207f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.46 156.0 A 11.6 11.6 0.0 0 0 336.0 162.8 A 11.6 11.6 0.0 0 0 346.55 156.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.10357127f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.0 156.0 v 6.8 A 11.6 11.6 0.0 0 0 346.54 156.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.02000002f,
                strokeAlpha = 0.02000002f,
                strokeLineWidth = 0.10357127f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 331.2 156.0 l -3.4 3.4 a 11.6 11.6 0.0 0 0 16.41 0.0 L 340.8 156.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.10357127f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 340.8 156.0 l 3.4 3.4 A 11.6 11.6 0.0 0 0 346.05 157.0 l -1.73 -1.0 Z M 344.16 159.45 a 11.6 11.6 0.0 0 1 -0.13 0.12 a 11.6 11.6 0.0 0 0 0.13 -0.12 Z M 343.43 160.1 a 11.6 11.6 0.0 0 1 -0.46 0.36 a 11.6 11.6 0.0 0 0 0.46 -0.36 Z M 342.5 160.79 a 11.6 11.6 0.0 0 1 -0.49 0.31 a 11.6 11.6 0.0 0 0 0.49 -0.31 Z M 330.21 161.23 L 330.2 161.25 a 11.6 11.6 0.0 0 0 0.2 0.1 a 11.6 11.6 0.0 0 1 -0.19 -0.11 Z M 341.51 161.4 a 11.6 11.6 0.0 0 1 -0.52 0.26 a 11.6 11.6 0.0 0 0 0.52 -0.26 Z M 330.91 161.61 a 11.6 11.6 0.0 0 0 0.53 0.24 a 11.6 11.6 0.0 0 1 -0.53 -0.24 Z M 340.47 161.9 a 11.6 11.6 0.0 0 1 -0.54 0.21 a 11.6 11.6 0.0 0 0 0.54 -0.21 Z M 331.98 162.07 a 11.6 11.6 0.0 0 0 0.54 0.19 a 11.6 11.6 0.0 0 1 -0.54 -0.19 Z M 339.38 162.29 a 11.6 11.6 0.0 0 1 -0.56 0.15 a 11.6 11.6 0.0 0 0 0.56 -0.15 Z M 333.09 162.41 a 11.6 11.6 0.0 0 0 0.56 0.13 a 11.6 11.6 0.0 0 1 -0.56 -0.13 Z M 338.25 162.57 a 11.6 11.6 0.0 0 1 -0.57 0.09 a 11.6 11.6 0.0 0 0 0.57 -0.09 Z M 334.22 162.65 a 11.6 11.6 0.0 0 0 0.57 0.08 a 11.6 11.6 0.0 0 1 -0.57 -0.08 Z M 337.11 162.74 a 11.6 11.6 0.0 0 1 -0.58 0.04 a 11.6 11.6 0.0 0 0 0.58 -0.04 Z M 335.37 162.77 a 11.6 11.6 0.0 0 0 0.58 0.02 a 11.6 11.6 0.0 0 1 -0.58 -0.02 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1.5634992f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 325.01 156.0 c 1.85 4.24 6.07 7.2 10.99 7.2 c 4.92 0.0 9.14 -2.96 10.99 -7.2 h -0.83 c -1.75 3.83 -5.56 6.4 -10.17 6.4 c -4.6 0.0 -8.42 -2.57 -10.17 -6.4 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(336f, 140f),
                    end = Offset(336f, 162.4f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 1.4955206f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 325.89 156.0 c 1.8 3.78 5.64 6.4 10.11 6.4 c 4.47 0.0 8.31 -2.62 10.11 -6.4 h -0.82 c -1.68 3.38 -5.13 5.6 -9.29 5.6 c -4.16 0.0 -7.61 -2.22 -9.29 -5.6 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2.667f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Bevel,
                pathData = addPathNodes("m 324.62 156.01 c 0.01 0.06 0.01 0.13 0.02 0.19 c 0.03 0.24 0.06 0.53 0.11 0.81 h 22.5 c 0.06 -0.33 0.1 -0.67 0.12 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF3C3C3C)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 333.01 156.0 a 5.0 5.0 0.0 0 0 2.99 1.0 a 5.0 5.0 0.0 0 0 2.99 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.3680618f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 322.25 205.0 a 10.5 10.5 0.0 0 0 9.89 7.0 a 10.5 10.5 0.0 0 0 9.89 -7.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCDCDCD),
                        1f to Color(0xFFE9E9E9)
                    ),
                    start = Offset(327.39f, 190.94f),
                    end = Offset(337.78f, 209.3f)
                ),
                strokeLineWidth = 1.3085806f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 322.91 204.7 a 10.15 10.15 0.0 0 0 9.23 5.95 a 10.15 10.15 0.0 0 0 9.23 -5.95 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 0.09062486f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.14 204.7 v 5.95 a 10.15 10.15 0.0 0 0 9.23 -5.95 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.02000002f,
                strokeAlpha = 0.02000002f,
                strokeLineWidth = 0.09062486f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 327.94 204.7 l -2.98 2.98 a 10.15 10.15 0.0 0 0 14.36 0.0 l -2.98 -2.98 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.09062486f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.34 204.7 l 2.97 2.97 a 10.15 10.15 0.0 0 0 1.62 -2.1 l -1.52 -0.88 Z M 339.27 207.72 a 10.15 10.15 0.0 0 1 -0.11 0.11 a 10.15 10.15 0.0 0 0 0.11 -0.11 Z M 338.64 208.29 a 10.15 10.15 0.0 0 1 -0.4 0.31 a 10.15 10.15 0.0 0 0 0.4 -0.31 Z M 337.83 208.9 a 10.15 10.15 0.0 0 1 -0.43 0.27 a 10.15 10.15 0.0 0 0 0.43 -0.27 Z M 327.07 209.28 L 327.06 209.29 a 10.15 10.15 0.0 0 0 0.17 0.09 a 10.15 10.15 0.0 0 1 -0.17 -0.1 Z M 336.96 209.42 a 10.15 10.15 0.0 0 1 -0.46 0.23 a 10.15 10.15 0.0 0 0 0.46 -0.23 Z M 327.69 209.61 a 10.15 10.15 0.0 0 0 0.46 0.21 a 10.15 10.15 0.0 0 1 -0.46 -0.21 Z M 336.04 209.86 a 10.15 10.15 0.0 0 1 -0.47 0.18 a 10.15 10.15 0.0 0 0 0.47 -0.18 Z M 328.62 210.01 a 10.15 10.15 0.0 0 0 0.48 0.17 a 10.15 10.15 0.0 0 1 -0.48 -0.17 Z M 335.09 210.2 a 10.15 10.15 0.0 0 1 -0.49 0.13 a 10.15 10.15 0.0 0 0 0.49 -0.13 Z M 329.59 210.31 a 10.15 10.15 0.0 0 0 0.49 0.12 a 10.15 10.15 0.0 0 1 -0.49 -0.12 Z M 334.11 210.45 a 10.15 10.15 0.0 0 1 -0.5 0.08 a 10.15 10.15 0.0 0 0 0.5 -0.08 Z M 330.58 210.52 a 10.15 10.15 0.0 0 0 0.5 0.07 a 10.15 10.15 0.0 0 1 -0.5 -0.07 Z M 333.1 210.6 a 10.15 10.15 0.0 0 1 -0.5 0.03 a 10.15 10.15 0.0 0 0 0.5 -0.03 Z M 331.58 210.62 a 10.15 10.15 0.0 0 0 0.51 0.02 a 10.15 10.15 0.0 0 1 -0.51 -0.02 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1.3680618f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 322.52 204.7 c 1.62 3.71 5.32 6.3 9.62 6.3 c 4.3 0.0 8.0 -2.59 9.62 -6.3 h -0.72 c -1.53 3.35 -4.87 5.6 -8.9 5.6 c -4.03 0.0 -7.36 -2.25 -8.9 -5.6 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(332.14f, 190.7f),
                    end = Offset(332.14f, 210.3f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 1.3085805f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 323.29 204.7 c 1.57 3.31 4.94 5.6 8.84 5.6 c 3.91 0.0 7.27 -2.29 8.84 -5.6 h -0.72 c -1.47 2.95 -4.49 4.9 -8.13 4.9 c -3.64 0.0 -6.66 -1.95 -8.13 -4.9 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF3C3C3C)),
                strokeLineWidth = 1.75f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.52 204.98 a 4.38 4.38 0.0 0 0 2.62 0.88 a 4.38 4.38 0.0 0 0 2.62 -0.88 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 322.0 205.0 h 20.0 v 1.0 h -20.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.9697368f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 320.93 247.0 a 7.39 7.5 0.0 0 0 6.95 5.0 a 7.39 7.5 0.0 0 0 6.95 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFAF8F6)),
                strokeLineWidth = 0.9697368f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 321.37 247.0 a 7.39 7.5 0.0 0 0 6.51 4.0 a 7.39 7.5 0.0 0 0 6.52 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF3C3C3C)),
                strokeLineWidth = 1.2404699f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.04 247.0 a 3.08 3.13 0.0 0 0 1.84 0.63 a 3.08 3.13 0.0 0 0 1.84 -0.63 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0f,
                strokeAlpha = 0f,
                strokeLineWidth = 0.9697368f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 320.93 247.0 a 7.39 7.5 0.0 0 0 6.95 5.0 a 7.39 7.5 0.0 0 0 6.95 -5.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF555555)),
                strokeLineWidth = 0.9697368f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 321.37 247.0 A 7.39 7.5 0.0 0 0 327.88 251.0 A 7.39 7.5 0.0 0 0 334.4 247.0 L 333.77 247.0 A 7.39 7.5 0.0 0 1 327.88 250.0 A 7.39 7.5 0.0 0 1 322.0 247.0 L 321.37 247.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF919191)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 321.0 247.0 h 14.0 v 1.0 h -14.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF949494)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 322.0 204.0 h 20.0 v 1.0 h -20.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF555555)),
                strokeLineWidth = 0.84771854f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.0 248.0 a 5.64 7.5 0.0 0 0 2.0 0.5 A 5.64 7.5 0.0 0 0 330.0 248.0 Z")
            )
        }.build()

        return _DriveOptical!!
    }

@Suppress("ObjectPropertyName")
private var _DriveOptical: ImageVector? = null
