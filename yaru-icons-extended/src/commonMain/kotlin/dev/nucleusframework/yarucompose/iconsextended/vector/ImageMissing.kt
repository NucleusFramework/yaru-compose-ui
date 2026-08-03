package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val ImageMissing: ImageVector
    get() {
        if (_ImageMissing != null) {
            return _ImageMissing!!
        }
        _ImageMissing = ImageVector.Builder(
            name = "ImageMissing",
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
                pathData = addPathNodes("m 324.1 238.0 c -0.72 0.0 -1.3 0.01 -1.84 0.1 c -0.54 0.09 -1.07 0.28 -1.48 0.69 c -0.41 0.41 -0.6 0.94 -0.69 1.47 c -0.09 0.53 -0.1 1.12 -0.1 1.83 v 5.81 c 0.0 0.72 0.01 1.3 0.1 1.83 c 0.09 0.54 0.28 1.07 0.69 1.48 c 0.41 0.41 0.94 0.6 1.48 0.69 c 0.53 0.09 1.12 0.1 1.84 0.1 H 328.0 h 3.9 c 0.72 0.0 1.31 -0.01 1.84 -0.1 c 0.54 -0.09 1.07 -0.28 1.48 -0.69 c 0.41 -0.41 0.6 -0.94 0.69 -1.48 C 335.99 249.21 336.0 248.62 336.0 247.9 v -5.81 c 0.0 -0.72 -0.01 -1.3 -0.1 -1.83 c -0.09 -0.54 -0.28 -1.07 -0.69 -1.47 c -0.41 -0.41 -0.94 -0.6 -1.48 -0.69 C 333.2 238.01 332.62 238.0 331.9 238.0 H 328.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 321.0 95.27 c 0.0 2.22 0.05 3.97 0.29 5.41 c 0.24 1.44 0.7 2.62 1.56 3.48 c 0.86 0.86 2.04 1.32 3.48 1.56 c 1.44 0.24 3.2 0.29 5.42 0.28 h 12.25 h 12.25 c 2.23 0.01 3.98 -0.04 5.42 -0.28 c 1.44 -0.24 2.62 -0.7 3.48 -1.56 c 0.86 -0.86 1.31 -2.04 1.56 -3.48 c 0.24 -1.44 0.29 -3.19 0.29 -5.41 v -16.54 c 0.0 -2.22 -0.05 -3.97 -0.29 -5.41 c -0.24 -1.44 -0.7 -2.61 -1.56 -3.47 c -0.86 -0.86 -2.04 -1.31 -3.48 -1.55 c -1.44 -0.24 -3.19 -0.29 -5.42 -0.29 h -12.25 h -12.25 c -2.23 0.0 -3.98 0.05 -5.42 0.29 c -1.44 0.24 -2.62 0.69 -3.48 1.55 c -0.86 0.86 -1.32 2.04 -1.56 3.47 c -0.24 1.44 -0.29 3.19 -0.29 5.41 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 40.0 222.08 C 40.0 257.37 43.62 261.17 78.99 261.0 L 152.0 261.0 L 225.0 261.0 C 260.37 261.17 264.0 257.37 264.0 222.08 L 264.0 107.92 C 264.0 72.62 260.36 69.97 225.0 69.0 L 152.0 69.0 L 78.99 69.0 C 43.62 69.0 40.0 72.62 40.0 107.92 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 40.0 107.92 C 40.0 72.63 43.62 68.83 78.99 69.0 L 152.0 69.0 L 225.0 69.0 C 260.37 68.83 264.0 72.63 264.0 107.92 L 264.0 222.08 C 264.0 257.38 260.37 261.0 225.0 261.0 L 152.0 261.0 L 78.99 261.0 C 43.62 261.0 40.0 257.38 40.0 222.08 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 321.0 155.81 c 0.0 1.42 0.03 2.55 0.19 3.51 c 0.16 0.96 0.47 1.79 1.09 2.41 c 0.62 0.62 1.46 0.94 2.41 1.1 c 0.96 0.16 2.09 0.19 3.51 0.18 h 7.79 h 7.8 c 1.42 0.01 2.55 -0.02 3.51 -0.18 c 0.96 -0.16 1.79 -0.48 2.41 -1.1 c 0.62 -0.62 0.93 -1.46 1.09 -2.41 c 0.16 -0.96 0.19 -2.08 0.19 -3.51 v -11.62 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.5 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.45 -0.93 -2.41 -1.09 c -0.96 -0.16 -2.08 -0.19 -3.51 -0.19 h -7.8 h -7.8 c -1.42 0.0 -2.55 0.03 -3.51 0.19 c -0.96 0.16 -1.79 0.47 -2.41 1.09 c -0.62 0.62 -0.93 1.45 -1.09 2.41 c -0.16 0.96 -0.19 2.08 -0.19 3.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.88 192.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.23 -0.92 2.01 C 320.02 195.85 320.0 196.75 320.0 197.87 v 8.27 c 0.0 1.12 0.02 2.02 0.15 2.79 c 0.13 0.78 0.39 1.48 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.77 0.13 1.67 0.15 2.79 0.14 H 332.0 h 6.12 c 1.12 0.0 2.02 -0.02 2.79 -0.14 c 0.78 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.24 0.92 -2.01 c 0.13 -0.77 0.15 -1.67 0.15 -2.79 v -8.27 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 C 340.14 192.02 339.25 192.0 338.13 192.0 H 332.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFED3146)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 331.75 65.0 c -2.23 0.0 -3.98 0.05 -5.42 0.29 c -1.44 0.24 -2.61 0.69 -3.48 1.55 c -0.86 0.86 -1.32 2.04 -1.56 3.47 C 321.05 71.76 321.0 73.51 321.0 75.73 v 18.54 c 0.0 2.22 0.05 3.97 0.29 5.41 c 0.24 1.44 0.69 2.62 1.56 3.48 c 0.86 0.86 2.04 1.32 3.48 1.56 c 1.44 0.24 3.19 0.29 5.42 0.28 H 344.0 H 356.25 c 2.23 0.01 3.98 -0.04 5.42 -0.28 c 1.44 -0.24 2.62 -0.69 3.48 -1.56 c 0.86 -0.86 1.31 -2.04 1.56 -3.48 C 366.95 98.24 367.0 96.49 367.0 94.27 V 75.73 c 0.0 -2.22 -0.05 -3.97 -0.29 -5.41 c -0.24 -1.44 -0.69 -2.61 -1.56 -3.47 c -0.86 -0.86 -2.04 -1.31 -3.48 -1.55 C 360.24 65.05 358.71 65.0 356.25 65.0 H 344.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFED3146)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 106.92 c 0.0 -35.3 -3.63 -39.09 -38.99 -38.92 H 152.0 H 78.99 C 43.62 67.83 40.0 71.63 40.0 106.92 v 114.16 c 0.0 35.3 3.63 38.92 38.99 38.92 h 73.01 h 73.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFED3146)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.5 241.1 c 0.0 -0.71 -0.02 -1.27 -0.1 -1.75 c -0.08 -0.48 -0.24 -0.9 -0.55 -1.21 c -0.31 -0.31 -0.73 -0.47 -1.21 -0.55 c -0.48 -0.08 -1.04 -0.09 -1.76 -0.09 h -3.9 h -3.9 c -0.71 -0.0 -1.28 0.01 -1.75 0.09 c -0.48 0.08 -0.9 0.24 -1.21 0.55 c -0.31 0.31 -0.47 0.73 -0.55 1.21 c -0.08 0.48 -0.1 1.04 -0.1 1.75 v 5.81 c 0.0 0.71 0.02 1.27 0.1 1.75 c 0.08 0.48 0.24 0.9 0.55 1.21 c 0.31 0.31 0.73 0.46 1.21 0.54 c 0.48 0.08 1.04 0.1 1.75 0.1 h 3.9 h 3.9 c 0.71 0.0 1.28 -0.02 1.75 -0.1 c 0.48 -0.08 0.9 -0.24 1.21 -0.54 c 0.31 -0.31 0.47 -0.73 0.55 -1.21 c 0.08 -0.48 0.1 -1.04 0.1 -1.75 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFED3146)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 343.5 196.87 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.6 -0.14 -2.71 -0.14 h -6.12 h -6.13 c -1.11 -0.0 -1.99 0.02 -2.71 0.14 c -0.72 0.12 -1.31 0.35 -1.74 0.78 c -0.43 0.43 -0.66 1.02 -0.78 1.74 c -0.12 0.72 -0.15 1.6 -0.15 2.71 v 8.27 c 0.0 1.11 0.03 1.99 0.15 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.15 2.71 0.15 h 6.13 h 6.13 c 1.11 0.0 1.99 -0.03 2.71 -0.15 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.59 0.15 -2.71 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFED3146)),
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 350.5 143.19 c 0.0 -1.41 -0.03 -2.52 -0.19 -3.42 c -0.15 -0.9 -0.43 -1.62 -0.95 -2.14 c -0.52 -0.52 -1.24 -0.8 -2.14 -0.95 c -0.9 -0.15 -2.01 -0.18 -3.43 -0.17 h -7.79 h -7.8 c -1.41 -0.01 -2.52 0.02 -3.42 0.17 c -0.9 0.15 -1.62 0.43 -2.14 0.95 c -0.52 0.52 -0.8 1.24 -0.95 2.14 c -0.15 0.9 -0.19 2.01 -0.19 3.42 v 11.62 c 0.0 1.41 0.03 2.52 0.19 3.42 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.19 3.43 0.19 h 7.8 h 7.8 c 1.42 0.0 2.52 -0.03 3.43 -0.19 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.15 -0.9 0.19 -2.01 0.19 -3.42 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 219.08 v 2.0 c 0.0 35.3 3.62 38.92 38.99 38.92 h 73.01 h 73.01 c 35.37 0.0 38.99 -3.62 38.99 -38.92 v -2.0 c 0.0 35.3 -3.63 38.92 -38.99 38.92 H 152.0 H 78.99 c -35.37 0.0 -38.99 -3.62 -38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 78.99 68.0 c -35.37 -0.17 -38.99 3.63 -38.99 38.92 v 2.0 c 0.0 -35.3 3.62 -39.09 38.99 -38.92 h 73.01 h 73.01 c 35.37 -0.17 38.99 3.63 38.99 38.92 v -2.0 c 0.0 -35.3 -3.63 -39.09 -38.99 -38.92 h -73.01 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 8.041323f,
                strokeLineCap = StrokeCap.Square,
                pathData = addPathNodes("m 152.0 100.54 c -35.48 0.0 -64.33 28.85 -64.33 64.33 c 0.0 35.48 28.85 64.33 64.33 64.33 c 35.48 0.0 64.33 -28.85 64.33 -64.33 c 0.0 -35.48 -28.85 -64.33 -64.33 -64.33 Z M 152.0 108.59 c 31.14 0.0 56.29 25.15 56.29 56.29 c 0.0 14.12 -5.2 26.97 -13.76 36.85 l -79.38 -79.38 c 9.87 -8.56 22.73 -13.76 36.85 -13.76 Z M 109.47 128.03 L 188.84 207.41 c -9.87 8.56 -22.73 13.76 -36.85 13.76 c -31.14 0.0 -56.29 -25.15 -56.29 -56.29 c 0.0 -14.12 5.2 -26.97 13.76 -36.85 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 1.5047358f,
                strokeLineCap = StrokeCap.Square,
                pathData = addPathNodes("m 344.0 72.96 c -6.64 0.0 -12.04 5.4 -12.04 12.04 c 0.0 6.64 5.4 12.04 12.04 12.04 c 6.64 0.0 12.04 -5.4 12.04 -12.04 c 0.0 -6.64 -5.4 -12.04 -12.04 -12.04 Z M 344.0 74.47 c 5.83 0.0 10.53 4.71 10.53 10.53 c 0.0 2.64 -0.97 5.05 -2.57 6.89 L 337.1 77.04 c 1.85 -1.6 4.25 -2.57 6.89 -2.57 Z M 336.04 78.11 L 350.89 92.96 c -1.85 1.6 -4.25 2.57 -6.89 2.57 c -5.83 0.0 -10.53 -4.71 -10.53 -10.53 c 0.0 -2.64 0.97 -5.05 2.57 -6.89 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 1.0032135f,
                strokeLineCap = StrokeCap.Square,
                pathData = addPathNodes("m 336.0 140.97 c -4.43 0.0 -8.03 3.6 -8.03 8.03 c 0.0 4.43 3.6 8.03 8.03 8.03 c 4.43 0.0 8.03 -3.6 8.03 -8.03 c 0.0 -4.43 -3.6 -8.03 -8.03 -8.03 Z M 336.0 141.98 c 3.88 0.0 7.02 3.14 7.02 7.02 c 0.0 1.76 -0.65 3.37 -1.72 4.6 l -9.9 -9.9 c 1.23 -1.07 2.84 -1.72 4.6 -1.72 Z M 330.69 144.4 L 340.6 154.31 c -1.23 1.07 -2.84 1.72 -4.6 1.72 c -3.88 0.0 -7.02 -3.14 -7.02 -7.02 c 0.0 -1.76 0.65 -3.37 1.72 -4.6 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 0.7524097f,
                strokeLineCap = StrokeCap.Square,
                pathData = addPathNodes("m 332.0 194.98 c -3.32 0.0 -6.02 2.7 -6.02 6.02 c 0.0 3.32 2.7 6.02 6.02 6.02 c 3.32 0.0 6.02 -2.7 6.02 -6.02 c 0.0 -3.32 -2.7 -6.02 -6.02 -6.02 Z M 332.0 195.73 c 2.91 0.0 5.27 2.35 5.27 5.27 c 0.0 1.32 -0.49 2.52 -1.29 3.45 l -7.43 -7.43 c 0.92 -0.8 2.13 -1.29 3.45 -1.29 Z M 328.02 197.55 L 335.45 204.98 c -0.92 0.8 -2.13 1.29 -3.45 1.29 c -2.91 0.0 -5.27 -2.35 -5.27 -5.27 c 0.0 -1.32 0.49 -2.52 1.29 -3.45 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 0.5015787f,
                strokeLineCap = StrokeCap.Square,
                pathData = addPathNodes("m 328.0 239.99 c -2.21 0.0 -4.01 1.8 -4.01 4.01 c 0.0 2.21 1.8 4.01 4.01 4.01 c 2.21 0.0 4.01 -1.8 4.01 -4.01 c 0.0 -2.21 -1.8 -4.01 -4.01 -4.01 Z M 328.0 240.49 c 1.94 0.0 3.51 1.57 3.51 3.51 c 0.0 0.88 -0.32 1.68 -0.86 2.3 l -4.95 -4.95 c 0.62 -0.53 1.42 -0.86 2.3 -0.86 Z M 325.35 241.7 L 330.3 246.65 c -0.62 0.53 -1.42 0.86 -2.3 0.86 c -1.94 0.0 -3.51 -1.57 -3.51 -3.51 c 0.0 -0.88 0.32 -1.68 0.86 -2.3 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 164.0 h 224.0 v 57.08 c 0.0 35.3 -3.64 38.0 -38.99 38.92 H 152.0 H 78.99 c -35.37 0.0 -38.99 -3.63 -38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 152.0 68.0 h 73.01 c 35.37 -0.17 38.99 3.63 38.99 38.92 v 114.16 c 0.0 35.3 -3.64 38.0 -38.99 38.92 H 152.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 7.9999995f,
                pathData = addPathNodes("m 204.0 258.6 l 60.0 -60.0 v 22.48 c -0.05 34.0 -3.8 37.52 -38.17 37.52 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 344.0 66.0 h 12.25 c 8.84 -0.04 9.75 0.91 9.75 9.73 v 18.54 c 0.0 8.82 -0.91 9.73 -9.75 9.73 h -12.25 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 322.0 85.0 h 44.0 v 9.27 c 0.0 8.82 -0.91 9.73 -9.75 9.73 h -12.25 h -12.25 c -8.84 0.0 -9.75 -0.91 -9.75 -9.73 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.0 192.0 h 6.13 c 4.42 -0.02 4.88 0.45 4.88 4.87 v 8.27 c 0.0 4.41 -0.45 4.87 -4.88 4.87 h -6.13 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 321.0 201.0 h 22.0 v 4.13 c 0.0 4.41 -0.45 4.87 -4.88 4.87 h -6.13 h -6.13 c -4.42 0.0 -4.88 -0.45 -4.88 -4.87 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 336.0 137.0 h 7.8 c 5.63 -0.03 6.2 0.58 6.2 6.19 v 11.62 c 0.0 5.62 -0.58 6.19 -6.2 6.19 h -7.8 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 322.0 149.0 h 28.0 v 5.81 c 0.0 5.62 -0.58 6.19 -6.2 6.19 h -7.8 h -7.8 c -5.63 0.0 -6.2 -0.58 -6.2 -6.19 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.03999999f,
                strokeAlpha = 0.03999999f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 321.0 244.0 l 14.0 0.0 l 0.0 2.9 C 335.0 249.71 334.71 250.0 331.9 250.0 L 328.0 250.0 L 324.1 250.0 C 321.29 250.0 321.0 249.71 321.0 246.9 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.03999999f,
                strokeAlpha = 0.03999999f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 328.0 238.0 l 3.9 0.0 C 334.71 237.99 335.0 238.29 335.0 241.1 l 0.0 5.81 C 335.0 249.71 334.71 250.0 331.9 250.0 L 328.0 250.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.Black.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(348f, 65f),
                    end = Offset(348f, 105f)
                ),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 321.5 94.27 c 0.0 2.21 0.05 3.95 0.29 5.33 c 0.23 1.38 0.65 2.45 1.42 3.21 c 0.76 0.77 1.82 1.19 3.21 1.42 c 1.38 0.23 3.12 0.28 5.34 0.27 h 12.25 h 12.25 c 2.22 0.01 3.95 -0.04 5.34 -0.27 c 1.38 -0.23 2.44 -0.65 3.21 -1.42 c 0.76 -0.77 1.19 -1.83 1.42 -3.21 c 0.23 -1.38 0.29 -3.12 0.29 -5.33 v -18.54 c 0.0 -2.21 -0.05 -3.94 -0.29 -5.33 c -0.23 -1.38 -0.65 -2.44 -1.42 -3.2 c -0.76 -0.76 -1.82 -1.18 -3.21 -1.42 c -1.38 -0.23 -2.89 -0.29 -5.34 -0.29 h -12.25 h -12.25 c -2.22 0.0 -3.95 0.05 -5.34 0.29 c -1.38 0.23 -2.44 0.65 -3.21 1.42 c -0.76 0.76 -1.19 1.82 -1.42 3.2 c -0.23 1.38 -0.29 3.11 -0.29 5.33 Z")
            )
            addPath(
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.99999994f,
                pathData = addPathNodes("m 321.5 154.81 c 0.0 1.41 0.03 2.52 0.19 3.42 c 0.15 0.9 0.43 1.62 0.95 2.14 c 0.52 0.52 1.24 0.8 2.14 0.95 c 0.9 0.15 2.01 0.18 3.43 0.17 h 7.79 h 7.8 c 1.41 0.01 2.52 -0.02 3.42 -0.17 c 0.9 -0.15 1.62 -0.43 2.14 -0.95 c 0.52 -0.52 0.8 -1.24 0.95 -2.14 c 0.15 -0.9 0.19 -2.01 0.19 -3.42 v -11.62 c 0.0 -1.41 -0.03 -2.52 -0.19 -3.42 c -0.15 -0.9 -0.43 -1.62 -0.95 -2.14 c -0.52 -0.52 -1.24 -0.8 -2.14 -0.95 c -0.9 -0.15 -2.01 -0.19 -3.43 -0.19 h -7.8 h -7.8 c -1.42 0.0 -2.52 0.03 -3.43 0.19 c -0.9 0.15 -1.62 0.43 -2.14 0.95 c -0.52 0.52 -0.8 1.24 -0.95 2.14 c -0.15 0.9 -0.19 2.01 -0.19 3.42 Z")
            )
            addPath(
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 205.13 c 0.0 1.11 0.03 1.99 0.15 2.71 c 0.12 0.72 0.35 1.31 0.78 1.74 c 0.43 0.43 1.02 0.66 1.74 0.78 c 0.72 0.12 1.6 0.14 2.71 0.14 h 6.12 h 6.13 c 1.11 0.0 1.99 -0.02 2.71 -0.14 c 0.72 -0.12 1.31 -0.35 1.74 -0.78 c 0.43 -0.43 0.66 -1.02 0.78 -1.74 c 0.12 -0.72 0.15 -1.6 0.15 -2.71 v -8.27 c 0.0 -1.11 -0.03 -1.99 -0.15 -2.71 c -0.12 -0.72 -0.35 -1.31 -0.78 -1.74 c -0.43 -0.43 -1.02 -0.66 -1.74 -0.78 c -0.72 -0.12 -1.6 -0.15 -2.71 -0.15 h -6.13 h -6.13 c -1.11 0.0 -1.99 0.03 -2.71 0.15 c -0.72 0.12 -1.31 0.35 -1.74 0.78 c -0.43 0.43 -0.66 1.02 -0.78 1.74 c -0.12 0.72 -0.15 1.59 -0.15 2.71 Z")
            )
            addPath(
                fillAlpha = 0.3f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 320.5 246.9 c 0.0 0.71 0.02 1.27 0.1 1.75 c 0.08 0.48 0.24 0.9 0.55 1.21 c 0.31 0.31 0.73 0.47 1.21 0.55 c 0.48 0.08 1.04 0.09 1.76 0.09 h 3.9 h 3.9 c 0.71 0.0 1.28 -0.01 1.75 -0.09 c 0.48 -0.08 0.9 -0.24 1.21 -0.55 c 0.31 -0.31 0.47 -0.73 0.55 -1.21 c 0.08 -0.48 0.1 -1.04 0.1 -1.75 v -5.81 c 0.0 -0.71 -0.02 -1.27 -0.1 -1.75 c -0.08 -0.48 -0.24 -0.9 -0.55 -1.21 c -0.31 -0.31 -0.73 -0.46 -1.21 -0.54 c -0.48 -0.08 -1.04 -0.1 -1.75 -0.1 h -3.9 h -3.9 c -0.71 0.0 -1.28 0.02 -1.75 0.1 c -0.48 0.08 -0.9 0.24 -1.21 0.54 c -0.31 0.31 -0.47 0.73 -0.55 1.21 c -0.08 0.48 -0.1 1.04 -0.1 1.75 Z")
            )
            group(
                clipPathData = addPathNodes("m 321.0 205.13 c 0.0 4.41 0.45 4.89 4.87 4.87 L 332.0 210.0 L 338.13 210.0 C 342.55 210.02 343.0 209.55 343.0 205.13 l 0.0 -8.27 C 343.0 192.45 342.55 192.0 338.13 192.0 L 332.0 192.0 L 325.87 192.0 C 321.45 192.0 321.0 192.45 321.0 196.86 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(333f, 193f),
                        end = Offset(333f, 209f)
                    ),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 321.0 205.13 c 0.0 4.41 0.45 4.89 4.87 4.87 L 332.0 210.0 L 338.13 210.0 C 342.55 210.02 343.0 209.55 343.0 205.13 l 0.0 -8.27 C 343.0 192.45 342.55 192.0 338.13 192.0 L 332.0 192.0 L 325.87 192.0 C 321.45 192.0 321.0 192.45 321.0 196.86 Z")
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
                        start = Offset(329f, 239f),
                        end = Offset(329f, 250f)
                    ),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 321.0 246.9 c 0.0 2.81 0.29 3.11 3.1 3.1 L 328.0 250.0 l 3.9 -0.0 c 2.81 0.01 3.1 -0.29 3.1 -3.1 l 0.0 -5.81 C 335.0 238.29 334.71 238.0 331.9 238.0 L 328.0 238.0 L 324.1 238.0 C 321.29 238.0 321.0 238.29 321.0 241.1 Z")
                )
            }
            group(
                clipPathData = addPathNodes("m 322.0 154.81 c 0.0 5.62 0.58 6.22 6.2 6.19 l 7.8 -0.0 l 7.8 -0.0 c 5.63 0.03 6.2 -0.58 6.2 -6.19 l 0.0 -11.61 c 0.0 -5.62 -0.58 -6.19 -6.2 -6.19 l -7.8 -0.0 l -7.8 -0.0 c -5.63 -0.0 -6.2 0.58 -6.2 6.19 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(336f, 137f),
                        end = Offset(336f, 161f)
                    ),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 322.0 154.81 c 0.0 5.62 0.58 6.22 6.2 6.19 l 7.8 -0.0 l 7.8 -0.0 c 5.63 0.03 6.2 -0.58 6.2 -6.19 l 0.0 -11.61 c 0.0 -5.62 -0.58 -6.19 -6.2 -6.19 l -7.8 -0.0 l -7.8 -0.0 c -5.63 -0.0 -6.2 0.58 -6.2 6.19 Z")
                )
            }
        }.build()

        return _ImageMissing!!
    }

@Suppress("ObjectPropertyName")
private var _ImageMissing: ImageVector? = null
