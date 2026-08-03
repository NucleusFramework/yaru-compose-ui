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

val MediaFlash: ImageVector
    get() {
        if (_MediaFlash != null) {
            return _MediaFlash!!
        }
        _MediaFlash = ImageVector.Builder(
            name = "MediaFlash",
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
                pathData = addPathNodes("m 344.0 62.0 c -3.18 0.0 -4.94 1.13 -7.21 3.28 l -0.01 0.0 l -8.51 8.51 l -0.0 0.0 l -0.01 0.01 c -1.39 1.26 -3.26 2.98 -3.27 5.22 v 18.91 v 0.0 c 0.0 1.08 0.03 2.05 0.09 2.91 c -0.0 -0.07 -0.01 -0.06 0.0 0.02 c 0.01 0.08 0.01 0.12 0.01 0.13 v 0.0 v 0.0 c 0.03 0.38 0.06 0.75 0.11 1.1 c 0.05 0.39 0.11 0.75 0.18 1.09 c 0.07 0.34 0.16 0.66 0.25 0.96 c 0.1 0.3 0.21 0.58 0.34 0.84 c 0.11 0.23 0.25 0.45 0.39 0.65 l 0.01 0.01 l 0.02 0.04 l 0.02 0.02 l 0.01 0.02 c 0.0 0.0 0.0 0.0 0.0 0.0 c 0.06 0.08 0.09 0.1 0.06 0.07 c 0.14 0.19 0.3 0.37 0.48 0.54 c 0.2 0.19 0.42 0.35 0.65 0.5 c 0.23 0.15 0.49 0.28 0.75 0.39 c 0.27 0.11 0.55 0.21 0.85 0.29 c 0.6 0.16 1.26 0.27 2.01 0.35 c 0.0 0.0 0.0 -0.0 0.0 0.0 c 0.0 0.0 0.0 -0.0 0.0 0.0 c 0.0 0.0 0.0 0.0 0.01 0.0 h 0.0 c 0.1 0.01 0.17 0.01 0.21 0.01 h 0.0 c 0.31 0.03 0.63 0.05 0.98 0.07 c 0.84 0.04 1.76 0.06 2.79 0.06 h 17.54 c 2.51 0.0 4.37 -0.1 5.87 -0.48 c 0.01 0.0 0.03 0.0 0.03 0.0 c 0.0 0.0 0.03 -0.0 0.06 -0.01 c -0.02 0.0 -0.02 0.0 -0.04 0.0 c 0.03 -0.01 0.1 -0.0 0.13 -0.01 h 0.0 c 0.6 -0.17 1.14 -0.39 1.61 -0.69 c 0.24 -0.15 0.45 -0.32 0.65 -0.51 c 0.4 -0.38 0.72 -0.83 0.98 -1.37 h 0.0 c 0.26 -0.53 0.44 -1.14 0.58 -1.84 c 0.07 -0.35 0.13 -0.72 0.17 -1.11 c 0.09 -0.79 0.15 -1.67 0.17 -2.66 c 0.01 -0.5 0.01 -1.02 0.01 -1.58 v -0.0 v -12.75 v -12.75 v -0.0 c 0.0 -0.56 -0.0 -1.08 -0.01 -1.58 c -0.02 -1.0 -0.07 -1.88 -0.17 -2.66 c -0.05 -0.39 -0.1 -0.76 -0.17 -1.11 c -0.07 -0.35 -0.15 -0.67 -0.25 -0.98 c -0.09 -0.3 -0.2 -0.57 -0.32 -0.83 c 0.0 0.01 0.02 0.07 0.03 0.1 c -0.01 -0.03 -0.04 -0.12 -0.04 -0.13 l -0.0 -0.0 c -0.07 -0.14 -0.13 -0.23 -0.16 -0.27 c -0.22 -0.4 -0.48 -0.77 -0.82 -1.09 c -1.6 -1.51 -4.18 -1.7 -8.31 -1.7 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(344f, 60f),
                    end = Offset(344f, 108f)
                ),
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 346.63 61.49 c -2.31 0.04 -4.83 -0.27 -6.89 1.03 c -1.58 0.93 -2.73 2.39 -4.07 3.6 c -3.02 2.98 -6.08 5.92 -9.0 9.0 c -0.79 0.97 -1.33 2.19 -1.22 3.46 c -0.06 7.2 -0.05 14.41 0.1 21.61 c 0.15 1.75 0.51 3.72 1.91 4.94 c 1.59 1.27 3.75 1.37 5.69 1.39 c 7.67 0.06 15.34 0.09 23.01 -0.03 c 1.74 -0.17 3.76 -0.44 4.93 -1.89 c 1.05 -1.4 1.32 -3.22 1.37 -4.92 c 0.13 -9.54 0.15 -19.09 0.08 -28.64 c -0.09 -2.03 0.02 -4.13 -0.62 -6.09 c -0.43 -1.35 -1.5 -2.47 -2.87 -2.88 c -2.36 -0.79 -4.9 -0.45 -7.35 -0.56 c -1.69 -0.02 -3.38 -0.03 -5.07 -0.02 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.04 236.87 c -0.09 0.0 -0.18 0.04 -0.25 0.1 l -4.69 4.47 c -0.07 0.06 -0.1 0.15 -0.1 0.24 v 3.0 v 3.42 c -0.0 0.75 0.01 1.34 0.1 1.86 c 0.09 0.52 0.27 0.99 0.64 1.34 c 0.37 0.35 0.87 0.52 1.41 0.61 c 0.54 0.09 1.17 0.1 1.95 0.1 h 5.79 c 0.78 0.0 1.41 -0.01 1.95 -0.1 c 0.54 -0.09 1.03 -0.26 1.4 -0.61 c 0.37 -0.35 0.55 -0.82 0.64 -1.34 c 0.09 -0.52 0.11 -1.12 0.11 -1.86 v -3.42 v -3.88 c 0.0 -0.75 -0.02 -1.35 -0.11 -1.86 c -0.09 -0.52 -0.27 -0.99 -0.64 -1.34 c -0.37 -0.35 -0.86 -0.53 -1.4 -0.61 c -0.54 -0.09 -1.17 -0.1 -1.95 -0.1 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.2 189.0 c -0.13 0.0 -0.26 0.05 -0.35 0.15 l -6.7 6.7 c -0.09 0.09 -0.15 0.22 -0.15 0.35 V 201.0 v 5.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.48 0.92 2.01 c 0.53 0.53 1.24 0.79 2.01 0.92 c 0.77 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.02 -0.02 2.79 -0.15 c 0.78 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.77 0.15 -1.67 0.15 -2.79 V 201.0 V 194.88 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 C 338.15 189.02 337.25 189.0 336.14 189.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.9915842f,
                pathData = addPathNodes("m 334.97 134.0 l 6.96 0.0 c 2.8 0.0 4.58 0.1 5.72 1.13 c 0.24 0.22 0.43 0.48 0.59 0.74 c 0.01 0.02 0.06 0.08 0.11 0.19 c 0.09 0.18 0.17 0.37 0.24 0.58 c 0.07 0.2 0.12 0.42 0.17 0.65 c 0.05 0.23 0.09 0.47 0.12 0.73 v 0.0 c 0.06 0.52 0.1 1.09 0.12 1.74 c 0.01 0.32 0.01 0.66 0.01 1.02 v 8.22 v 8.22 c 0.0 0.36 -0.0 0.7 -0.01 1.02 c -0.02 0.65 -0.05 1.22 -0.12 1.74 c -0.03 0.26 -0.07 0.5 -0.12 0.73 c -0.1 0.46 -0.23 0.87 -0.41 1.23 c -0.18 0.36 -0.41 0.68 -0.7 0.93 c -0.14 0.13 -0.3 0.24 -0.47 0.34 c -0.33 0.2 -0.71 0.35 -1.13 0.46 v 0.0 C 345.0 163.95 343.68 164.0 341.93 164.0 H 330.07 c -0.7 0.0 -1.32 -0.01 -1.89 -0.04 h -0.0 c -0.24 -0.01 -0.46 -0.03 -0.67 -0.05 h -0.0 h -0.0 c -0.01 -0.0 -0.05 -0.0 -0.09 -0.01 h -0.01 c -0.02 -0.0 -0.01 -0.0 -0.03 -0.0 h -0.0 c -0.51 -0.05 -0.97 -0.12 -1.39 -0.23 c -0.21 -0.05 -0.41 -0.12 -0.6 -0.19 c -0.19 -0.08 -0.36 -0.16 -0.53 -0.26 c -0.17 -0.1 -0.32 -0.21 -0.46 -0.34 c -0.13 -0.11 -0.24 -0.24 -0.34 -0.37 c 0.0 0.0 -0.0 -0.0 -0.01 -0.01 l -0.02 -0.02 l -0.02 -0.02 l -0.01 -0.01 l -0.0 -0.0 l -0.01 -0.01 l -0.01 -0.01 c -0.0 -0.0 -0.01 -0.02 -0.01 -0.02 c -0.0 -0.0 -0.01 -0.01 -0.01 -0.01 c 0.0 0.0 0.01 0.0 0.01 0.0 c -0.01 -0.02 -0.02 -0.03 -0.03 -0.05 c 0.01 0.01 0.01 0.02 0.01 0.03 c -0.09 -0.13 -0.19 -0.27 -0.27 -0.42 c -0.09 -0.18 -0.17 -0.37 -0.24 -0.57 c -0.07 -0.2 -0.13 -0.41 -0.18 -0.64 c -0.05 -0.23 -0.09 -0.47 -0.13 -0.72 c -0.03 -0.23 -0.05 -0.47 -0.07 -0.72 l -0.0 -0.0 v -0.0 c 0.0 0.02 -0.0 -0.01 -0.01 -0.08 v -0.0 c -0.0 -0.03 -0.0 -0.06 0.0 -0.01 v -0.0 v -0.0 c -0.04 -0.56 -0.06 -1.19 -0.06 -1.89 v -0.0 v -13.19 c 0.01 -1.56 1.32 -2.69 2.27 -3.5 l 0.01 -0.01 l 0.0 -0.0 l 4.71 -4.47 l 0.01 -0.01 c 1.54 -1.39 2.79 -2.15 4.97 -2.15 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 201.08 46.0 C 236.38 46.0 240.0 49.63 240.0 84.99 L 240.0 156.0 l -0.0 2.0 l -0.0 71.01 c -0.0 15.47 -0.69 24.87 -4.43 30.55 c -0.53 0.81 -1.13 1.55 -1.79 2.21 C 228.46 267.09 218.73 268.0 201.08 268.0 l -98.16 0.0 c -2.05 0.0 -3.99 -0.01 -5.83 -0.04 c -0.66 -0.01 -1.26 -0.04 -1.89 -0.05 c -1.15 -0.03 -2.29 -0.06 -3.36 -0.11 c -1.27 -0.06 -2.51 -0.12 -3.67 -0.21 c -0.47 -0.04 -0.93 -0.07 -1.39 -0.12 c -0.22 -0.02 -0.45 -0.04 -0.67 -0.06 c -0.73 -0.07 -1.44 -0.15 -2.12 -0.23 c -0.67 -0.09 -1.31 -0.18 -1.94 -0.29 c -0.22 -0.04 -0.43 -0.08 -0.65 -0.12 c -0.4 -0.07 -0.79 -0.14 -1.17 -0.22 c -0.25 -0.05 -0.49 -0.11 -0.73 -0.16 c -0.32 -0.07 -0.64 -0.15 -0.94 -0.23 c -0.26 -0.07 -0.51 -0.14 -0.76 -0.21 c -0.28 -0.08 -0.56 -0.17 -0.83 -0.26 c -0.23 -0.07 -0.45 -0.15 -0.67 -0.23 c -0.29 -0.1 -0.56 -0.21 -0.83 -0.32 c -0.2 -0.08 -0.39 -0.16 -0.58 -0.24 c -0.27 -0.12 -0.54 -0.25 -0.8 -0.38 c -0.17 -0.09 -0.35 -0.17 -0.52 -0.26 c -0.41 -0.22 -0.81 -0.45 -1.18 -0.7 c -0.41 -0.27 -0.79 -0.55 -1.16 -0.85 c -0.34 -0.28 -0.66 -0.57 -0.97 -0.87 c -0.07 -0.07 -0.15 -0.15 -0.22 -0.22 c -0.23 -0.24 -0.45 -0.48 -0.66 -0.73 c -0.08 -0.09 -0.16 -0.18 -0.23 -0.28 c -0.54 -0.68 -1.03 -1.42 -1.46 -2.22 c -0.06 -0.1 -0.11 -0.21 -0.16 -0.31 c -0.16 -0.31 -0.31 -0.62 -0.46 -0.95 c -0.06 -0.14 -0.12 -0.27 -0.18 -0.41 c -0.18 -0.43 -0.36 -0.88 -0.52 -1.35 c -0.16 -0.47 -0.31 -0.95 -0.45 -1.46 c -0.04 -0.15 -0.08 -0.29 -0.12 -0.44 c -0.06 -0.24 -0.12 -0.5 -0.18 -0.75 c -0.14 -0.6 -0.28 -1.23 -0.4 -1.88 c -0.03 -0.17 -0.07 -0.34 -0.1 -0.51 c -0.14 -0.81 -0.27 -1.66 -0.38 -2.54 c -0.02 -0.18 -0.04 -0.37 -0.06 -0.55 c -0.08 -0.72 -0.16 -1.46 -0.22 -2.23 c -0.03 -0.3 -0.05 -0.61 -0.07 -0.92 c -0.06 -0.77 -0.11 -1.56 -0.15 -2.38 c -0.01 -0.25 -0.03 -0.5 -0.04 -0.76 c -0.01 -0.15 -0.01 -0.31 -0.02 -0.46 c -0.06 -1.46 -0.1 -3.02 -0.13 -4.64 c -0.01 -0.42 -0.01 -0.85 -0.02 -1.28 c -0.02 -1.77 -0.03 -3.61 -0.02 -5.57 L 64.0 128.24 c 0.04 -9.73 8.18 -17.96 14.76 -24.16 l 0.05 -0.05 L 119.34 61.62 C 130.01 51.06 137.4 46.0 152.0 46.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 201.08 45.0 C 236.38 45.0 240.0 48.63 240.0 83.99 L 240.0 156.0 l -0.0 1.0 l -0.0 72.01 c -0.0 15.47 -0.69 24.87 -4.43 30.55 c -0.53 0.81 -1.13 1.55 -1.79 2.21 C 228.46 267.09 218.73 268.0 201.08 268.0 l -98.16 0.0 c -2.05 0.0 -3.99 -0.01 -5.83 -0.04 c -0.66 -0.01 -1.26 -0.04 -1.89 -0.05 c -1.15 -0.03 -2.29 -0.06 -3.36 -0.11 c -1.27 -0.06 -2.51 -0.12 -3.67 -0.21 c -0.47 -0.04 -0.93 -0.07 -1.39 -0.12 c -0.22 -0.02 -0.45 -0.04 -0.67 -0.06 c -0.73 -0.07 -1.44 -0.15 -2.12 -0.23 c -0.67 -0.09 -1.31 -0.18 -1.94 -0.29 c -0.22 -0.04 -0.43 -0.08 -0.65 -0.12 c -0.4 -0.07 -0.79 -0.14 -1.17 -0.22 c -0.25 -0.05 -0.49 -0.11 -0.73 -0.16 c -0.32 -0.07 -0.64 -0.15 -0.94 -0.23 c -0.26 -0.07 -0.51 -0.14 -0.76 -0.21 c -0.28 -0.08 -0.56 -0.17 -0.83 -0.26 c -0.23 -0.07 -0.45 -0.15 -0.67 -0.23 c -0.29 -0.1 -0.56 -0.21 -0.83 -0.32 c -0.2 -0.08 -0.39 -0.16 -0.58 -0.24 c -0.27 -0.12 -0.54 -0.25 -0.8 -0.38 c -0.17 -0.09 -0.35 -0.17 -0.52 -0.26 c -0.41 -0.22 -0.81 -0.45 -1.18 -0.7 c -0.41 -0.27 -0.79 -0.55 -1.16 -0.85 c -0.34 -0.28 -0.66 -0.57 -0.97 -0.87 c -0.07 -0.07 -0.15 -0.15 -0.22 -0.22 c -0.23 -0.24 -0.45 -0.48 -0.66 -0.73 c -0.08 -0.09 -0.16 -0.18 -0.23 -0.28 c -0.54 -0.68 -1.03 -1.42 -1.46 -2.22 c -0.06 -0.1 -0.11 -0.21 -0.16 -0.31 c -0.16 -0.31 -0.31 -0.62 -0.46 -0.95 c -0.06 -0.14 -0.12 -0.27 -0.18 -0.41 c -0.18 -0.43 -0.36 -0.88 -0.52 -1.35 c -0.16 -0.47 -0.31 -0.95 -0.45 -1.46 c -0.04 -0.15 -0.08 -0.29 -0.12 -0.44 c -0.06 -0.24 -0.12 -0.5 -0.18 -0.75 c -0.14 -0.6 -0.28 -1.23 -0.4 -1.88 c -0.03 -0.17 -0.07 -0.34 -0.1 -0.51 c -0.14 -0.81 -0.27 -1.66 -0.38 -2.54 c -0.02 -0.18 -0.04 -0.37 -0.06 -0.55 c -0.08 -0.72 -0.16 -1.46 -0.22 -2.23 c -0.03 -0.3 -0.05 -0.61 -0.07 -0.92 c -0.06 -0.77 -0.11 -1.56 -0.15 -2.38 c -0.01 -0.25 -0.03 -0.5 -0.04 -0.76 c -0.01 -0.15 -0.01 -0.31 -0.02 -0.46 c -0.06 -1.46 -0.1 -3.02 -0.13 -4.64 c -0.01 -0.42 -0.01 -0.85 -0.02 -1.28 c -0.02 -1.77 -0.03 -3.61 -0.02 -5.57 L 64.0 119.24 c 0.04 -9.73 8.18 -17.96 14.76 -24.16 l 0.05 -0.05 L 111.34 60.62 C 122.01 50.06 129.4 45.0 144.0 45.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(168f, 28f),
                    end = Offset(168f, 284f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 201.08 44.0 c 35.3 0.0 38.92 3.63 38.92 38.99 V 156.0 V 229.01 C 240.0 264.37 236.38 268.0 201.08 268.0 H 102.93 C 67.63 268.0 63.83 264.37 64.0 229.01 V 118.24 c 0.04 -9.73 8.18 -17.96 14.76 -24.16 l 0.05 -0.05 l 32.52 -34.41 c 10.68 -10.56 18.06 -15.62 32.67 -15.62 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(332f, 188f),
                    end = Offset(332f, 212f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 329.2 188.5 l -6.7 6.7 v 4.8 v 6.13 c 0.0 1.11 0.03 1.99 0.15 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.59 0.15 2.71 0.15 h 8.27 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 C 341.48 208.11 341.51 207.24 341.5 206.13 V 200.0 V 193.88 c 0.0 -1.11 -0.02 -1.99 -0.14 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 C 338.12 188.53 337.25 188.5 336.13 188.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(335.85f, 131.99f),
                    end = Offset(336.13f, 163.89f)
                ),
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.44 133.5 c -1.39 0.04 -2.89 -0.15 -4.15 0.6 c -1.56 0.83 -2.7 2.24 -4.01 3.38 c -1.32 1.31 -2.75 2.52 -3.95 3.93 c -0.46 0.64 -0.97 1.33 -0.82 2.16 c 0.02 5.03 -0.15 10.07 0.14 15.1 c 0.04 1.33 0.6 2.85 1.95 3.34 c 1.77 0.66 3.71 0.36 5.55 0.45 c 4.56 -0.01 9.12 0.05 13.68 -0.08 c 1.32 -0.07 2.8 -0.7 3.22 -2.07 c 0.62 -1.94 0.34 -4.0 0.44 -6.0 c 0.01 -5.57 0.07 -11.14 -0.07 -16.71 c -0.1 -1.33 -0.43 -2.95 -1.81 -3.52 c -1.45 -0.68 -3.11 -0.44 -4.66 -0.54 c -1.84 -0.02 -3.67 -0.04 -5.51 -0.03 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(328f, 235.97f),
                    end = Offset(328f, 251.83f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 326.08 236.5 L 321.5 240.93 v 2.97 v 4.05 c 0.0 0.74 0.02 1.32 0.1 1.79 c 0.08 0.48 0.24 0.86 0.53 1.15 c 0.29 0.28 0.7 0.44 1.19 0.51 c 0.49 0.08 1.09 0.1 1.85 0.1 h 5.66 c 0.76 0.0 1.36 -0.02 1.85 -0.1 c 0.49 -0.08 0.9 -0.23 1.19 -0.51 c 0.3 -0.28 0.45 -0.67 0.53 -1.15 c 0.08 -0.48 0.1 -1.05 0.09 -1.79 v -4.05 v -3.85 c 0.0 -0.74 -0.01 -1.32 -0.09 -1.79 c -0.08 -0.48 -0.24 -0.87 -0.53 -1.15 c -0.3 -0.28 -0.7 -0.44 -1.19 -0.51 c -0.49 -0.08 -1.09 -0.1 -1.85 -0.1 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.07962964f,
                strokeLineWidth = 0.22406487f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.0 203.0 L 338.0 203.0 A 1.0 1.0 0.0 0 1 339.0 204.0 L 339.0 208.0 A 1.0 1.0 0.0 0 1 338.0 209.0 L 326.0 209.0 A 1.0 1.0 0.0 0 1 325.0 208.0 L 325.0 204.0 A 1.0 1.0 0.0 0 1 326.0 203.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.07962964f,
                strokeLineWidth = 0.2828741f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 151.0 L 344.0 151.0 A 1.0 1.0 0.0 0 1 345.0 152.0 L 345.0 158.0 A 1.0 1.0 0.0 0 1 344.0 159.0 L 328.0 159.0 A 1.0 1.0 0.0 0 1 327.0 158.0 L 327.0 152.0 A 1.0 1.0 0.0 0 1 328.0 151.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.07962964f,
                strokeLineWidth = 0.4495003f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 333.0 88.0 L 355.0 88.0 A 2.0 2.0 0.0 0 1 357.0 90.0 L 357.0 99.0 A 2.0 2.0 0.0 0 1 355.0 101.0 L 333.0 101.0 A 2.0 2.0 0.0 0 1 331.0 99.0 L 331.0 90.0 A 2.0 2.0 0.0 0 1 333.0 88.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.07962964f,
                strokeLineWidth = 2.195104f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 96.0 174.0 L 208.0 174.0 A 8.0 8.0 0.0 0 1 216.0 182.0 L 216.0 238.0 A 8.0 8.0 0.0 0 1 208.0 246.0 L 96.0 246.0 A 8.0 8.0 0.0 0 1 88.0 238.0 L 88.0 182.0 A 8.0 8.0 0.0 0 1 96.0 174.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 240.0 227.01 v 2.0 C 240.18 264.37 236.38 268.0 201.08 268.0 h -98.56 c -35.3 0.0 -38.0 -3.64 -38.92 -38.99 v -2.0 C 64.52 262.36 67.23 266.0 102.52 266.0 h 98.56 c 35.3 0.0 39.09 -3.63 38.92 -38.99 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(152f, 172f),
                    end = Offset(152f, 244f)
                ),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 2.195104f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 96.0 172.0 L 208.0 172.0 A 8.0 8.0 0.0 0 1 216.0 180.0 L 216.0 236.0 A 8.0 8.0 0.0 0 1 208.0 244.0 L 96.0 244.0 A 8.0 8.0 0.0 0 1 88.0 236.0 L 88.0 180.0 A 8.0 8.0 0.0 0 1 96.0 172.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(344f, 87f),
                    end = Offset(344f, 101f)
                ),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.4495003f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 333.0 87.0 L 355.0 87.0 A 2.0 2.0 0.0 0 1 357.0 89.0 L 357.0 98.0 A 2.0 2.0 0.0 0 1 355.0 100.0 L 333.0 100.0 A 2.0 2.0 0.0 0 1 331.0 98.0 L 331.0 89.0 A 2.0 2.0 0.0 0 1 333.0 87.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(336f, 150f),
                    end = Offset(336f, 159f)
                ),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.2828741f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 150.0 L 344.0 150.0 A 1.0 1.0 0.0 0 1 345.0 151.0 L 345.0 157.0 A 1.0 1.0 0.0 0 1 344.0 158.0 L 328.0 158.0 A 1.0 1.0 0.0 0 1 327.0 157.0 L 327.0 151.0 A 1.0 1.0 0.0 0 1 328.0 150.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(332f, 202f),
                    end = Offset(332f, 209f)
                ),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.22406487f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.0 202.0 L 338.0 202.0 A 1.0 1.0 0.0 0 1 339.0 203.0 L 339.0 207.0 A 1.0 1.0 0.0 0 1 338.0 208.0 L 326.0 208.0 A 1.0 1.0 0.0 0 1 325.0 207.0 L 325.0 203.0 A 1.0 1.0 0.0 0 1 326.0 202.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF808080),
                        1f to Color(0xFF999999)
                    ),
                    start = Offset(328f, 244f),
                    end = Offset(328f, 249f)
                ),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.15606669f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.0 245.0 L 331.0 245.0 A 1.0 1.0 0.0 0 1 332.0 246.0 L 332.0 248.0 A 1.0 1.0 0.0 0 1 331.0 249.0 L 325.0 249.0 A 1.0 1.0 0.0 0 1 324.0 248.0 L 324.0 246.0 A 1.0 1.0 0.0 0 1 325.0 245.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 2.3650117f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 132.0 60.0 h 12.0 v 48.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 2.367187f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 60.0 h 12.0 v 48.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 2.3606546f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 172.0 60.0 h 12.0 v 48.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 2.367187f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 192.0 60.0 h 12.0 v 48.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 2.3693604f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 212.0 60.0 h 11.9 v 48.09 h -11.9 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.484293f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.0 65.0 h 2.0 v 10.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.48473847f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 345.0 65.0 h 2.0 v 10.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.48340082f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 349.0 65.0 h 2.0 v 10.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.48473847f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 353.0 65.0 h 2.0 v 10.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.4851835f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 357.0 65.0 h 2.0 v 10.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.30476946f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 136.0 h 2.0 v 6.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.30504978f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.0 136.0 h 2.0 v 6.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.30420798f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 338.0 136.0 h 2.0 v 6.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.30504978f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.0 136.0 h 2.0 v 6.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.30532986f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 136.0 h 2.0 v 6.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.2414082f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 191.0 h 1.0 v 4.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.24163024f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 191.0 h 1.0 v 4.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.24096344f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 334.0 191.0 h 1.0 v 4.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.24163024f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 191.0 h 1.0 v 4.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.24185209f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 338.0 191.0 h 1.0 v 4.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.16814674f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.0 238.0 h 1.0 v 3.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.16783696f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 238.0 h 1.0 v 3.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.1683014f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 238.0 h 1.0 v 3.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFFFDA64)),
                strokeAlpha = 0.39814818f,
                strokeLineWidth = 0.16845593f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 238.0 h 1.0 v 3.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 132.0 60.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 132.0 108.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 60.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 108.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 172.0 60.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 172.0 108.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 192.0 60.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 192.0 108.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 212.0 60.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 212.0 108.0 h 12.0 v 2.0 h -12.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.04f,
                strokeAlpha = 0.015925927f,
                strokeLineWidth = 0.4495003f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 333.0 87.0 C 331.89 87.0 331.0 87.89 331.0 89.0 L 331.0 90.0 C 331.0 88.89 331.89 88.0 333.0 88.0 L 355.0 88.0 C 356.11 88.0 357.0 88.89 357.0 90.0 L 357.0 89.0 C 357.0 87.89 356.11 87.0 355.0 87.0 L 333.0 87.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.0 75.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 345.0 75.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 349.0 75.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 353.0 75.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 357.0 75.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 357.0 65.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 353.0 65.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 349.0 65.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 345.0 65.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.0 65.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.05f,
                strokeAlpha = 0.01990741f,
                strokeLineWidth = 0.2828741f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 328.0 150.0 C 327.45 150.0 327.0 150.45 327.0 151.0 L 327.0 152.0 C 327.0 151.45 327.45 151.0 328.0 151.0 L 344.0 151.0 C 344.55 151.0 345.0 151.45 345.0 152.0 L 345.0 151.0 C 345.0 150.45 344.55 150.0 344.0 150.0 L 328.0 150.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 142.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.0 142.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 338.0 142.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.0 142.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 142.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 344.0 136.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 341.0 136.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 338.0 136.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 335.0 136.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 136.0 h 2.0 v 1.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.05f,
                strokeAlpha = 0.01990741f,
                strokeLineWidth = 0.22406487f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.0 202.0 C 325.45 202.0 325.0 202.45 325.0 203.0 L 325.0 204.0 C 325.0 203.45 325.45 203.0 326.0 203.0 L 338.0 203.0 C 338.55 203.0 339.0 203.45 339.0 204.0 L 339.0 203.0 C 339.0 202.45 338.55 202.0 338.0 202.0 L 326.0 202.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 191.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 191.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 334.0 191.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 191.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 338.0 191.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 338.0 195.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 336.0 195.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 334.0 195.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 332.0 195.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.075f,
                strokeAlpha = 0.075f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 195.0 h 1.0 v 1.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.05f,
                strokeAlpha = 0.01990741f,
                strokeLineWidth = 2.195104f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 96.0 172.0 C 91.57 172.0 88.0 175.57 88.0 180.0 L 88.0 182.0 C 88.0 177.57 91.57 174.0 96.0 174.0 L 208.0 174.0 C 212.43 174.0 216.0 177.57 216.0 182.0 L 216.0 180.0 C 216.0 175.57 212.43 172.0 208.0 172.0 L 96.0 172.0 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 352.77 61.5 c 4.12 0.0 6.56 0.23 7.97 1.56 c 0.29 0.27 0.52 0.6 0.73 0.97 c 0.05 0.08 0.1 0.16 0.14 0.25 c 0.0 0.0 -0.0 0.0 0.0 0.0 c 0.12 0.24 0.22 0.5 0.31 0.79 c 0.09 0.29 0.17 0.59 0.24 0.93 c 0.07 0.33 0.12 0.69 0.17 1.07 c 0.09 0.76 0.14 1.63 0.16 2.62 c 0.01 0.49 0.01 1.01 0.01 1.57 V 84.0 V 96.75 c 0.0 0.55 -0.0 1.07 -0.01 1.57 c -0.02 0.98 -0.07 1.85 -0.16 2.62 c -0.05 0.38 -0.1 0.74 -0.17 1.07 c -0.13 0.66 -0.31 1.23 -0.54 1.72 c -0.23 0.48 -0.52 0.89 -0.87 1.22 c -0.18 0.17 -0.37 0.32 -0.58 0.45 c -0.42 0.27 -0.91 0.47 -1.48 0.63 c -0.0 0.0 -0.0 -0.0 -0.0 0.0 c -1.42 0.39 -3.34 0.48 -5.91 0.48 h -17.54 c -1.02 0.0 -1.94 -0.01 -2.76 -0.06 c -0.34 -0.02 -0.66 -0.04 -0.96 -0.07 c -0.06 -0.01 -0.14 -0.01 -0.2 -0.01 c -0.0 -0.0 -0.0 0.0 -0.0 0.0 c -0.73 -0.07 -1.38 -0.18 -1.94 -0.33 c -0.28 -0.08 -0.55 -0.16 -0.79 -0.27 c -0.24 -0.1 -0.47 -0.22 -0.68 -0.35 c -0.21 -0.13 -0.4 -0.28 -0.58 -0.44 c -0.16 -0.14 -0.3 -0.31 -0.43 -0.48 c -0.02 -0.02 -0.04 -0.04 -0.05 -0.06 c -0.0 -0.0 -0.0 -0.0 -0.0 -0.01 c -0.14 -0.2 -0.27 -0.41 -0.39 -0.65 c -0.12 -0.24 -0.22 -0.5 -0.31 -0.78 c -0.09 -0.28 -0.17 -0.58 -0.24 -0.91 c -0.07 -0.33 -0.13 -0.68 -0.17 -1.05 c -0.04 -0.33 -0.08 -0.7 -0.1 -1.07 c -0.0 -0.05 -0.01 -0.08 -0.01 -0.13 c -0.0 -0.01 0.0 -0.01 0.0 -0.02 c -0.06 -0.85 -0.09 -1.8 -0.09 -2.88 V 78.02 c 0.01 -1.96 1.72 -3.61 3.1 -4.85 l 0.01 -0.01 l 8.52 -8.52 C 339.38 62.52 340.93 61.5 344.0 61.5 Z")
            )
            group(
                clipPathData = addPathNodes("m 352.27 62.0 c 8.82 0.0 9.77 0.91 9.73 9.75 L 362.0 84.0 L 362.0 96.25 c 0.04 8.84 -0.91 9.75 -9.73 9.75 l -16.54 0.0 c -8.82 0.0 -9.73 -0.91 -9.73 -9.75 L 326.0 84.0 L 326.0 71.75 C 326.0 62.91 326.91 62.0 335.73 62.0 Z")
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
                    pathData = addPathNodes("m 352.77 61.5 c 8.23 0.0 9.77 0.91 9.73 9.75 L 362.5 84.0 L 362.5 96.75 c 0.04 8.84 -1.5 9.75 -9.73 9.75 l -17.54 0.0 c -8.17 0.0 -9.71 -0.9 -9.73 -9.57 L 325.5 79.02 C 325.51 77.81 326.17 76.71 327.0 75.76 L 327.0 84.0 L 327.0 96.25 c -0.0 2.19 0.06 3.87 0.27 5.09 c 0.2 1.22 0.53 1.92 1.0 2.39 c 0.47 0.47 1.17 0.8 2.39 1.0 c 1.21 0.2 2.89 0.27 5.08 0.27 l 16.54 0.0 c 2.19 0.0 3.87 -0.06 5.08 -0.27 c 1.22 -0.2 1.93 -0.53 2.4 -1.0 c 0.47 -0.47 0.8 -1.18 1.0 -2.39 c 0.2 -1.22 0.26 -2.89 0.25 -5.09 l -0.0 -0.0 L 361.0 84.0 L 361.0 71.75 l -0.0 -0.0 c 0.01 -2.19 -0.05 -3.87 -0.25 -5.09 c -0.2 -1.22 -0.53 -1.92 -1.0 -2.39 c -0.47 -0.47 -1.18 -0.8 -2.4 -1.0 C 356.14 63.06 354.46 63.0 352.27 63.0 L 340.0 63.0 c 1.4 -1.0 3.8 -1.5 5.92 -1.5 Z")
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
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 330.4 188.0 l -2.0 2.0 h 7.73 c 1.09 0.0 1.9 0.03 2.46 0.13 c 0.55 0.09 0.79 0.22 0.92 0.36 c 0.14 0.14 0.27 0.37 0.36 0.93 c 0.09 0.55 0.13 1.37 0.13 2.46 v 6.13 v 6.13 c 0.0 1.09 -0.03 1.91 -0.13 2.46 c -0.09 0.55 -0.22 0.79 -0.36 0.93 c -0.14 0.14 -0.37 0.27 -0.92 0.36 c -0.55 0.09 -1.37 0.13 -2.46 0.13 h -8.27 c -1.09 0.0 -1.91 -0.03 -2.46 -0.13 c -0.55 -0.09 -0.79 -0.22 -0.93 -0.36 c -0.14 -0.14 -0.27 -0.37 -0.36 -0.93 c -0.09 -0.55 -0.12 -1.37 -0.12 -2.46 v -0.0 V 200.0 V 196.0 h -2.0 v 4.0 v 6.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 C 341.98 208.14 342.0 207.25 342.0 206.13 V 200.0 V 193.88 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 C 338.15 188.02 337.25 188.0 336.13 188.0 Z")
                )
            }
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9915842f,
                pathData = addPathNodes("m 341.93 133.5 c 2.78 0.0 4.43 0.15 5.39 1.0 c 0.19 0.17 0.35 0.39 0.49 0.63 c 0.03 0.05 0.07 0.1 0.1 0.16 c 0.08 0.16 0.15 0.33 0.21 0.51 c 0.06 0.18 0.12 0.38 0.16 0.6 c 0.05 0.21 0.08 0.44 0.11 0.69 c 0.06 0.49 0.1 1.05 0.11 1.69 c 0.01 0.32 0.01 0.65 0.01 1.01 V 148.0 v 8.22 c 0.0 0.36 -0.0 0.69 -0.01 1.01 c -0.01 0.63 -0.05 1.19 -0.11 1.69 c -0.03 0.25 -0.07 0.48 -0.11 0.69 c -0.09 0.43 -0.21 0.79 -0.37 1.11 c -0.16 0.31 -0.35 0.57 -0.59 0.79 c -0.12 0.11 -0.25 0.2 -0.39 0.29 c -0.28 0.17 -0.61 0.31 -1.0 0.41 c -0.96 0.25 -2.26 0.31 -4.0 0.31 h -11.86 c -0.69 0.0 -1.31 -0.01 -1.87 -0.04 c -0.23 -0.01 -0.44 -0.03 -0.65 -0.04 c -0.04 -0.0 -0.09 -0.0 -0.14 -0.01 h -0.0 c -0.49 -0.05 -0.93 -0.12 -1.31 -0.22 c -0.19 -0.05 -0.37 -0.11 -0.54 -0.17 c -0.17 -0.07 -0.32 -0.14 -0.46 -0.23 c -0.14 -0.08 -0.27 -0.18 -0.39 -0.29 c -0.11 -0.09 -0.2 -0.2 -0.29 -0.31 c -0.01 -0.01 -0.03 -0.03 -0.04 -0.04 c -0.0 -0.0 -0.0 -0.0 -0.0 -0.0 c -0.1 -0.13 -0.19 -0.27 -0.26 -0.42 c -0.08 -0.15 -0.15 -0.32 -0.21 -0.5 c -0.06 -0.18 -0.12 -0.38 -0.16 -0.59 c -0.05 -0.21 -0.08 -0.44 -0.12 -0.68 c -0.03 -0.22 -0.05 -0.45 -0.07 -0.69 c -0.0 -0.03 -0.01 -0.05 -0.01 -0.08 c -0.0 -0.0 0.0 -0.01 0.0 -0.01 c -0.04 -0.55 -0.06 -1.16 -0.06 -1.86 v -13.19 c 0.01 -1.26 2.1 -3.13 2.1 -3.13 l 0.01 -0.01 l 4.73 -4.49 c 1.52 -1.37 2.57 -2.02 4.64 -2.02 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(337f, 134f),
                    end = Offset(337f, 162f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.125f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 337.67 134.01 c 5.17 0.0 7.89 0.06 8.9 0.58 c 0.6 0.31 1.04 1.07 1.25 2.17 c 0.24 1.3 0.24 21.52 -0.01 22.6 c -0.41 1.81 -1.06 2.33 -3.19 2.56 c -0.49 0.05 -4.64 0.09 -9.21 0.07 c -7.44 -0.02 -8.39 -0.05 -9.06 -0.24 c -1.21 -0.35 -1.68 -0.8 -2.03 -1.96 c -0.18 -0.59 -0.21 -3.68 -0.25 -10.28 c -0.05 -7.56 -0.05 -6.6 0.22 -7.15 c 0.07 -0.15 0.34 -0.46 0.72 -0.88 v 4.07 c 0.0 0.12 0.02 0.24 0.05 0.36 c -0.02 3.83 0.04 8.68 0.12 12.47 c -0.09 0.99 0.26 2.21 1.37 2.43 c 4.18 0.21 8.4 0.16 12.61 0.19 c 2.09 -0.07 4.22 0.13 6.29 -0.2 c 1.21 -0.09 1.37 -1.43 1.47 -2.38 c 0.18 -6.58 0.13 -13.38 0.04 -19.99 c -0.09 -1.09 0.04 -2.66 -1.18 -3.16 c -2.37 -0.42 -6.78 -0.22 -9.18 -0.31 c -0.61 0.03 -0.29 0.01 -0.94 0.01 c -0.06 -0.01 -0.12 -0.02 -0.18 -0.02 h -3.79 c 0.43 -0.31 0.79 -0.53 1.17 -0.68 c 0.61 -0.25 0.07 -0.26 4.8 -0.26 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0f,
                strokeAlpha = 0f,
                strokeLineWidth = 1.2f,
                pathData = addPathNodes("m 352.41 61.52 c 2.42 0.08 4.97 -0.14 7.24 0.84 c 1.66 0.66 2.3 2.52 2.58 4.13 c 0.32 2.05 0.16 4.13 0.23 6.2 c 0.02 8.78 0.1 17.56 -0.01 26.34 c -0.13 1.97 -0.19 4.19 -1.58 5.74 c -1.36 1.43 -3.49 1.51 -5.33 1.64 c -6.24 0.13 -12.49 0.05 -18.73 0.03 c -2.02 -0.06 -4.05 0.05 -6.05 -0.16 c -1.61 -0.2 -3.4 -0.8 -4.19 -2.34 c -0.94 -1.69 -0.92 -3.68 -0.95 -5.56 c -0.05 -6.73 -0.09 -13.46 -0.04 -20.2 c -0.08 -1.11 0.37 -2.2 1.13 -2.99 c 2.71 -2.98 5.65 -5.74 8.49 -8.59 c 1.79 -1.68 3.39 -3.74 5.76 -4.62 c 1.57 -0.64 3.31 -0.35 4.96 -0.45 c 2.16 -0.01 4.33 -0.03 6.49 -0.02 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.2 188.5 l -6.7 6.7 v 4.8 v 6.13 c -0.0 1.11 0.02 1.99 0.14 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.15 2.71 0.15 h 8.27 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.6 0.15 -2.71 V 200.0 V 193.88 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.59 -0.15 -2.71 -0.15 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.08 236.0 a 0.49 0.5 0.0 0 0 -0.34 0.14 l -4.59 4.48 a 0.49 0.5 0.0 0 0 -0.15 0.36 v 3.01 v 3.92 c -0.0 0.75 0.01 1.36 0.1 1.9 c 0.09 0.54 0.28 1.05 0.68 1.44 c 0.39 0.38 0.91 0.56 1.46 0.65 c 0.54 0.09 1.16 0.1 1.93 0.1 h 5.67 c 0.77 0.0 1.39 -0.02 1.93 -0.11 c 0.55 -0.09 1.06 -0.27 1.45 -0.65 c 0.39 -0.38 0.58 -0.9 0.68 -1.44 c 0.09 -0.54 0.11 -1.15 0.11 -1.9 v -3.92 v -3.89 c 0.0 -0.75 -0.02 -1.36 -0.11 -1.9 c -0.09 -0.54 -0.28 -1.05 -0.68 -1.44 c -0.39 -0.38 -0.9 -0.56 -1.45 -0.65 C 332.22 236.01 331.6 236.0 330.83 236.0 Z M 326.28 237.0 h 4.55 c 0.75 0.0 1.33 0.02 1.78 0.09 c 0.44 0.07 0.73 0.2 0.93 0.39 c 0.2 0.19 0.32 0.47 0.39 0.89 c 0.07 0.42 0.09 0.99 0.09 1.73 v 3.89 v 3.92 c 0.0 0.74 -0.02 1.3 -0.09 1.73 c -0.07 0.42 -0.19 0.69 -0.39 0.89 c -0.2 0.19 -0.49 0.32 -0.93 0.39 c -0.44 0.07 -1.02 0.09 -1.78 0.09 h -5.67 c -0.75 0.0 -1.33 -0.02 -1.78 -0.09 c -0.44 -0.07 -0.74 -0.2 -0.94 -0.39 c -0.2 -0.19 -0.32 -0.46 -0.39 -0.89 c -0.07 -0.42 -0.09 -0.99 -0.09 -1.72 a 0.49 0.5 0.0 0 0 0.0 -0.0 v -3.92 v -2.79 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(329f, 238f),
                    end = Offset(329f, 250f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 1.2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.25 236.99 c -1.45 1.37 -2.87 2.79 -4.3 4.19 c -0.03 1.86 0.01 3.73 0.01 5.59 c 0.03 1.01 -0.04 2.03 0.11 3.03 c 0.06 0.5 0.44 0.92 0.92 1.04 c 1.01 0.28 2.07 0.15 3.1 0.2 c 2.0 -0.0 4.01 0.04 6.01 -0.05 c 0.61 -0.05 1.38 -0.13 1.68 -0.75 c 0.34 -0.71 0.2 -1.52 0.25 -2.28 c 0.02 -2.94 0.06 -5.88 0.0 -8.81 c -0.04 -0.63 -0.04 -1.43 -0.64 -1.81 c -0.79 -0.45 -1.74 -0.29 -2.61 -0.34 c -1.51 -0.01 -3.02 -0.0 -4.52 -0.0 Z M 331.03 238.0 c 0.59 0.06 1.21 0.01 1.77 0.22 c 0.14 0.2 0.12 0.49 0.16 0.72 c 0.09 2.47 0.07 7.45 0.07 7.45 l 0.06 0.76 l -0.05 1.27 c 0.0 0.0 -0.05 0.9 -0.2 1.32 c -0.15 0.16 -0.43 0.13 -0.62 0.19 c -2.3 0.08 -4.64 0.05 -6.95 0.04 c -0.69 -0.05 -1.4 0.07 -2.06 -0.18 c -0.18 -0.25 -0.13 -0.62 -0.17 -0.92 c -0.07 -2.39 -0.03 -4.82 -0.04 -7.23 c 1.23 -1.2 2.47 -2.4 3.7 -3.6 c 1.44 -0.0 2.89 -0.01 4.33 -0.01 Z M 321.11 240.6 c 0.0 0.01 -0.04 0.1 -0.14 0.25 c 0.08 -0.18 0.14 -0.26 0.14 -0.25 Z")
            )
        }.build()

        return _MediaFlash!!
    }

@Suppress("ObjectPropertyName")
private var _MediaFlash: ImageVector? = null
