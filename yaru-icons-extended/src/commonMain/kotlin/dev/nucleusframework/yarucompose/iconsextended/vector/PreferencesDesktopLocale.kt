package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val PreferencesDesktopLocale: ImageVector
    get() {
        if (_PreferencesDesktopLocale != null) {
            return _PreferencesDesktopLocale!!
        }
        _PreferencesDesktopLocale = ImageVector.Builder(
            name = "PreferencesDesktopLocale",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.6 190.5 C 323.63 190.49 322.42 190.58 321.67 191.04 C 321.55 191.18 321.45 191.33 321.35 191.5 C 321.16 191.83 321.0 192.22 320.88 192.66 C 320.83 192.88 320.77 193.12 320.73 193.38 C 320.69 193.63 320.65 193.9 320.62 194.18 C 320.62 194.2 320.62 194.23 320.62 194.25 C 320.59 194.52 320.57 194.79 320.55 195.08 C 320.52 195.74 320.5 196.46 320.5 197.28 L 320.5 202.72 C 320.5 203.55 320.52 204.28 320.55 204.94 C 320.57 205.24 320.59 205.53 320.62 205.8 C 320.65 206.08 320.68 206.35 320.73 206.6 C 320.73 206.6 320.73 206.61 320.73 206.61 C 320.77 206.86 320.82 207.1 320.88 207.31 C 320.88 207.32 320.88 207.32 320.88 207.33 C 320.94 207.55 321.01 207.75 321.08 207.95 C 321.16 208.14 321.24 208.31 321.33 208.47 C 321.34 208.48 321.34 208.49 321.34 208.49 C 321.44 208.66 321.54 208.81 321.66 208.95 C 322.4 209.41 323.62 209.5 325.6 209.5 L 332.0 209.5 L 332.0 190.5 L 325.6 190.5 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 323.82 237.5 C 322.06 237.49 321.24 237.62 320.85 238.32 C 320.58 239.09 320.5 240.16 320.5 241.68 L 320.5 245.32 C 320.5 249.85 321.15 250.5 325.69 250.5 L 328.0 250.5 L 328.0 237.5 L 323.82 237.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 344.0 196.87 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.24 -0.79 -2.01 -0.92 c -0.78 -0.13 -1.67 -0.15 -2.79 -0.14 h -6.12 h -6.13 c -1.12 -0.0 -2.02 0.02 -2.79 0.14 c -0.78 0.13 -1.49 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.23 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.15 2.79 v 8.27 c 0.0 1.12 0.02 2.01 0.15 2.79 c 0.13 0.77 0.39 1.48 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 6.13 h 6.13 c 1.12 0.0 2.02 -0.02 2.79 -0.15 c 0.78 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.77 0.15 -1.67 0.15 -2.79 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.5 241.6 c 0.0 -0.72 -0.01 -1.3 -0.1 -1.84 c -0.09 -0.53 -0.28 -1.07 -0.68 -1.48 c -0.41 -0.41 -0.94 -0.6 -1.48 -0.69 c -0.54 -0.09 -1.12 -0.1 -1.84 -0.1 h -2.89 h -3.9 c -0.72 -0.0 -1.3 0.01 -1.84 0.1 c -0.54 0.09 -1.07 0.28 -1.48 0.69 c -0.41 0.41 -0.59 0.94 -0.68 1.48 c -0.09 0.53 -0.1 1.12 -0.1 1.84 v 5.81 c 0.0 0.72 0.01 1.3 0.1 1.83 c 0.09 0.53 0.28 1.07 0.69 1.47 c 0.41 0.41 0.94 0.59 1.48 0.68 c 0.53 0.09 1.12 0.1 1.84 0.1 h 3.9 h 2.9 c 0.72 0.0 1.3 -0.01 1.84 -0.1 c 0.53 -0.09 1.07 -0.28 1.48 -0.68 c 0.41 -0.41 0.6 -0.94 0.69 -1.47 c 0.09 -0.53 0.1 -1.11 0.1 -1.83 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 351.0 143.19 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.51 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.46 -0.94 -2.41 -1.1 c -0.96 -0.16 -2.09 -0.19 -3.51 -0.18 h -7.79 h -7.8 c -1.42 -0.01 -2.55 0.02 -3.51 0.18 c -0.96 0.16 -1.79 0.48 -2.41 1.1 c -0.62 0.62 -0.93 1.46 -1.09 2.41 c -0.16 0.96 -0.19 2.08 -0.19 3.51 v 11.62 c 0.0 1.42 0.03 2.55 0.19 3.5 c 0.16 0.96 0.47 1.79 1.09 2.41 c 0.62 0.62 1.45 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 7.8 h 7.8 c 1.42 0.0 2.55 -0.03 3.51 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 c 0.16 -0.96 0.19 -2.08 0.19 -3.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 367.5 76.23 c 0.0 -2.22 -0.05 -3.97 -0.29 -5.41 c -0.24 -1.44 -0.7 -2.62 -1.56 -3.48 c -0.86 -0.86 -2.04 -1.32 -3.48 -1.56 c -1.44 -0.24 -3.2 -0.29 -5.42 -0.28 H 344.0 H 331.25 c -2.23 -0.01 -3.98 0.04 -5.42 0.28 c -1.44 0.24 -2.62 0.7 -3.48 1.56 c -0.86 0.86 -1.31 2.04 -1.56 3.48 c -0.24 1.44 -0.29 3.19 -0.29 5.41 v 17.54 c 0.0 2.22 0.05 3.97 0.29 5.41 c 0.24 1.44 0.7 2.61 1.56 3.47 c 0.86 0.86 2.04 1.31 3.48 1.55 c 1.44 0.24 3.19 0.29 5.42 0.29 h 12.75 h 12.75 c 2.23 0.0 3.98 -0.05 5.42 -0.29 c 1.44 -0.24 2.62 -0.69 3.48 -1.55 c 0.86 -0.86 1.32 -2.04 1.56 -3.47 c 0.24 -1.44 0.29 -3.19 0.29 -5.41 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 264.0 107.92 C 264.0 72.63 260.37 68.83 225.0 69.0 L 152.0 69.0 L 78.99 69.0 C 43.62 68.83 40.0 72.63 40.0 107.92 L 40.0 206.08 C 40.0 241.38 43.63 244.08 78.99 245.0 L 152.0 245.0 L 225.0 245.0 C 260.37 245.0 264.0 241.38 264.0 206.08 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 264.0 107.92 C 264.0 72.63 260.37 68.83 225.0 69.0 L 152.0 69.0 L 78.99 69.0 C 43.62 68.83 40.0 72.63 40.0 107.92 L 40.0 206.08 C 40.0 241.38 43.62 245.0 78.99 245.0 L 152.0 245.0 L 225.0 245.0 C 260.37 245.0 264.0 241.38 264.0 206.08 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1.0202878f,
                pathData = addPathNodes("m 266.0 105.81 c 0.0 -36.1 -3.69 -39.98 -39.69 -39.81 H 152.0 H 77.69 C 41.69 65.83 38.0 69.71 38.0 105.81 v 100.39 c 0.0 36.1 3.69 39.81 39.69 39.81 h 74.31 h 74.31 c 36.0 0.0 39.69 -3.71 39.69 -39.81 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 366.5 75.23 c 0.0 -8.23 -0.91 -9.77 -9.75 -9.73 H 344.0 H 331.25 c -8.84 -0.04 -9.75 1.5 -9.75 9.73 v 17.54 c 0.0 8.23 0.91 9.73 9.75 9.73 h 12.75 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF3584E4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.0 65.5 v 37.0 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 V 75.23 c 0.0 -8.23 -0.91 -9.77 -9.75 -9.73 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 344.0 84.0 v 18.5 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 V 84.0 Z")
            )
            group(
                clipPathData = addPathNodes("M 350.94 65.5 C 364.56 65.5 366.51 67.21 366.51 79.2 l -0.0 9.6 C 366.51 100.79 364.56 102.5 350.94 102.5 L 344.01 102.5 L 344.01 65.5 Z")
            ) {
                addPath(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    pathData = addPathNodes("m 344.01 65.5 l -0.0 37.0 l -6.93 0.0 C 323.45 102.5 321.51 100.79 321.51 88.8 l -0.0 -9.6 C 321.51 67.21 323.45 65.5 337.08 65.5 Z")
                )
                addPath(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.1f,
                    strokeAlpha = 0.1f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    pathData = addPathNodes("m 344.01 65.5 l -0.0 37.0 l -6.93 0.0 C 323.45 102.5 321.51 100.79 321.51 88.8 l -0.0 -9.6 C 321.51 67.21 323.45 65.5 337.08 65.5 Z")
                )
            }
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 264.0 205.08 c 0.0 35.3 -3.63 39.09 -38.99 38.92 H 152.0 H 78.99 C 43.62 244.17 40.0 240.37 40.0 205.08 v -98.16 c 0.0 -35.3 3.63 -38.92 38.99 -38.92 h 73.01 h 73.01 c 35.37 0.0 38.99 3.62 38.99 38.92 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 343.5 195.64 c 0.0 -4.66 -0.47 -5.16 -5.1 -5.14 h -6.4 h -6.4 c -4.62 -0.02 -5.1 0.48 -5.1 5.14 v 8.73 c 0.0 4.66 0.47 5.14 5.1 5.14 h 6.4 h 6.4 c 4.62 0.0 5.1 -0.48 5.1 -5.14 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.5 240.85 c 0.0 -3.04 -0.31 -3.37 -3.32 -3.35 h -4.18 h -4.18 c -3.01 -0.01 -3.32 0.31 -3.32 3.35 v 6.29 c 0.0 3.04 0.31 3.35 3.32 3.35 h 4.18 h 4.18 c 3.01 0.0 3.32 -0.31 3.32 -3.35 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF6F5F4)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 350.5 142.08 c 0.0 -5.56 -0.58 -6.6 -6.28 -6.57 h -8.22 h -8.22 c -5.7 -0.03 -6.28 1.01 -6.28 6.57 v 11.85 c 0.0 5.56 0.58 6.57 6.28 6.57 h 8.22 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF3584E4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 152.0 68.0 V 243.99 h 73.0 c 35.37 0.17 38.99 -3.63 38.99 -38.92 v -98.16 c 0.0 -35.3 -3.63 -38.92 -38.99 -38.92 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 152.0 156.0 v 88.0 h 73.0 c 35.37 0.17 38.99 -3.63 38.99 -38.92 V 156.0 Z")
            )
            group(
                clipPathData = addPathNodes("M 188.97 68.0 C 261.62 68.0 272.0 76.14 272.0 133.17 l -0.0 45.67 C 272.0 235.87 261.62 244.0 188.97 244.0 L 152.0 244.0 L 152.0 68.0 Z")
            ) {
                addPath(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    pathData = addPathNodes("m 152.0 68.0 l -0.0 176.01 l -36.97 0.0 C 42.38 244.0 32.0 235.87 32.0 178.84 l -0.0 -45.67 C 32.0 76.14 42.38 68.0 115.03 68.0 Z")
                )
            }
            addPath(
                fill = SolidColor(Color(0xFF3584E4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.0 135.5 v 25.0 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 v -11.85 c 0.0 -5.56 -0.59 -6.6 -6.28 -6.57 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 336.0 148.0 v 12.5 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 V 148.0 Z")
            )
            group(
                clipPathData = addPathNodes("M 340.66 135.5 C 349.74 135.5 351.04 136.66 351.04 144.76 l -0.0 6.49 C 351.04 159.34 349.74 160.5 340.66 160.5 L 336.04 160.5 L 336.04 135.5 Z")
            ) {
                addPath(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.4f,
                    strokeAlpha = 0.4f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    pathData = addPathNodes("m 336.04 135.5 l -0.0 25.0 l -4.62 0.0 C 322.34 160.5 321.04 159.34 321.04 151.24 l -0.0 -6.49 C 321.04 136.66 322.34 135.5 331.42 135.5 Z")
                )
                addPath(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.1f,
                    strokeAlpha = 0.1f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    pathData = addPathNodes("m 336.04 135.5 l -0.0 25.0 l -4.62 0.0 C 322.34 160.5 321.04 159.34 321.04 151.24 l -0.0 -6.49 C 321.04 136.66 322.34 135.5 331.42 135.5 Z")
                )
            }
            addPath(
                fill = SolidColor(Color(0xFF3584E4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 190.5 v 19.0 h 6.4 c 1.98 0.0 3.19 -0.09 3.94 -0.55 c 0.93 -1.13 1.16 -3.02 1.16 -6.22 v -5.45 c 0.0 -3.21 -0.23 -5.11 -1.17 -6.23 c -0.75 -0.46 -1.96 -0.55 -3.93 -0.54 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 200.0 v 9.5 h 6.4 c 1.98 0.0 3.19 -0.09 3.94 -0.55 c 0.93 -1.13 1.16 -3.02 1.16 -6.22 V 200.0 Z")
            )
            addPath(
                fillAlpha = 0.1f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathFillType = PathFillType.EvenOdd,
                pathData = addPathNodes("m 332.5 190.5 v 19.0")
            )
            addPath(
                fill = SolidColor(Color(0xFF3584E4)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 328.0 237.5 v 13.0 h 4.18 c 3.01 0.0 3.32 -0.31 3.32 -3.35 v -6.29 c 0.0 -3.04 -0.31 -3.37 -3.32 -3.36 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 328.0 244.0 v 6.5 h 2.31 c 4.54 0.0 5.19 -0.65 5.19 -5.18 V 244.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                pathData = addPathNodes("m 208.21 116.02 v 12.0 h -32.0 v 8.0 h 13.24 c 4.76 12.29 10.61 22.71 17.5 31.22 c -8.01 8.3 -17.29 13.88 -27.85 16.94 l 2.23 7.68 c 11.73 -3.4 22.05 -9.67 30.89 -18.7 c 8.84 9.03 19.16 15.3 30.89 18.7 l 2.23 -7.68 c -10.56 -3.06 -19.83 -8.64 -27.85 -16.94 c 6.89 -8.51 12.74 -18.93 17.5 -31.22 h 13.24 v -8.0 h -32.0 v -12.0 Z M 198.05 136.02 h 28.31 c -4.06 9.89 -8.78 18.24 -14.16 25.14 c -5.38 -6.9 -10.09 -15.25 -14.16 -25.14 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF77767B)),
                strokeLineWidth = 0.1155f,
                pathData = addPathNodes("m 118.55 192.34 c -1.23 -3.25 -2.38 -6.42 -3.46 -9.52 c -1.08 -3.17 -2.2 -6.13 -3.35 -9.37 L 77.75 173.44 l -6.82 18.9 L 60.0 192.34 c 2.89 -7.94 5.59 -15.26 8.12 -21.97 c 2.53 -6.78 4.98 -13.2 7.36 -19.26 c 2.45 -6.06 4.87 -11.83 7.25 -17.32 c 2.38 -5.56 4.87 -11.04 7.47 -16.45 h 9.63 c 2.6 5.41 5.09 10.89 7.47 16.45 c 2.38 5.48 4.76 11.26 7.14 17.32 c 2.45 6.06 4.94 12.48 7.47 19.26 c 2.53 6.71 5.23 14.03 8.12 21.97 Z M 108.7 164.84 c -2.31 -6.28 -4.62 -12.65 -6.93 -18.5 c -2.24 -5.92 -4.58 -11.58 -7.03 -16.99 c -2.53 5.41 -4.94 11.08 -7.25 16.99 c -2.24 5.84 -4.47 12.22 -6.71 18.5 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                pathData = addPathNodes("m 354.91 76.79 v 2.22 L 349.0 79.0 v 1.48 h 2.44 c 0.88 2.27 1.96 4.19 3.23 5.76 c -1.48 1.53 -3.19 2.56 -5.14 3.13 l 0.41 1.42 c 2.17 -0.63 4.07 -1.79 5.7 -3.45 c 1.63 1.67 3.54 2.82 5.7 3.45 l 0.41 -1.42 c -1.95 -0.56 -3.66 -1.59 -5.14 -3.13 c 1.27 -1.57 2.35 -3.49 3.23 -5.76 h 2.44 v -1.48 h -5.91 v -2.22 Z M 353.03 80.48 h 5.23 c -0.75 1.83 -1.62 3.37 -2.61 4.64 c -0.99 -1.27 -1.86 -2.82 -2.61 -4.64 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF77767B)),
                strokeLineWidth = 0.11550001f,
                pathData = addPathNodes("m 337.43 90.0 c -0.2 -0.52 -0.38 -1.03 -0.55 -1.52 c -0.17 -0.51 -0.35 -0.98 -0.54 -1.5 h -5.44 l -1.09 3.02 h -1.75 c 0.46 -1.27 0.89 -2.44 1.3 -3.52 c 0.4 -1.09 0.8 -2.11 1.18 -3.08 c 0.39 -0.97 0.78 -1.89 1.16 -2.77 c 0.38 -0.89 0.78 -1.77 1.19 -2.63 h 1.54 c 0.42 0.87 0.81 1.74 1.19 2.63 c 0.38 0.88 0.76 1.8 1.14 2.77 c 0.39 0.97 0.79 2.0 1.19 3.08 c 0.4 1.07 0.84 2.25 1.3 3.52 Z M 335.85 85.6 c -0.37 -1.0 -0.74 -2.02 -1.11 -2.96 c -0.36 -0.95 -0.73 -1.85 -1.13 -2.72 c -0.4 0.87 -0.79 1.77 -1.16 2.72 c -0.36 0.94 -0.72 1.95 -1.07 2.96 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF77767B)),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.07 153.0 q -0.22 -0.58 -0.42 -1.14 q -0.19 -0.57 -0.4 -1.16 h -4.08 l -0.82 2.3 h -1.31 q 0.52 -1.43 0.97 -2.64 q 0.45 -1.22 0.88 -2.31 q 0.44 -1.09 0.87 -2.08 q 0.43 -1.0 0.9 -1.97 h 1.16 q 0.47 0.97 0.9 1.97 q 0.43 0.99 0.86 2.08 q 0.44 1.09 0.9 2.31 q 0.45 1.21 0.97 2.64 Z M 330.89 149.66 q -0.42 -1.13 -0.83 -2.18 q -0.4 -1.06 -0.84 -2.04 q -0.45 0.97 -0.87 2.04 q -0.4 1.05 -0.81 2.18 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF77767B)),
                strokeLineWidth = 6.9299994f,
                pathData = addPathNodes("m 326.21 245.8 q -0.08 -0.24 -0.17 -0.47 q -0.09 -0.23 -0.17 -0.47 h -1.69 q -0.08 0.24 -0.17 0.48 q -0.08 0.23 -0.16 0.46 h -0.76 q 0.23 -0.64 0.43 -1.18 q 0.2 -0.54 0.39 -1.03 q 0.2 -0.48 0.39 -0.92 q 0.19 -0.44 0.39 -0.87 h 0.69 q 0.2 0.43 0.39 0.87 q 0.19 0.44 0.38 0.92 q 0.2 0.48 0.4 1.03 q 0.21 0.54 0.43 1.18 Z M 325.03 242.57 q -0.13 0.31 -0.31 0.74 q -0.17 0.44 -0.35 0.95 h 1.32 q -0.18 -0.51 -0.36 -0.96 q -0.17 -0.44 -0.3 -0.74 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF77767B)),
                strokeLineWidth = 6.9299994f,
                pathData = addPathNodes("m 327.99 203.0 q -0.12 -0.35 -0.25 -0.7 q -0.13 -0.35 -0.25 -0.71 h -2.53 q -0.12 0.36 -0.25 0.72 q -0.12 0.35 -0.24 0.69 h -1.13 q 0.34 -0.96 0.64 -1.77 q 0.3 -0.81 0.59 -1.54 q 0.29 -0.73 0.58 -1.39 q 0.29 -0.66 0.59 -1.3 h 1.03 q 0.3 0.64 0.59 1.3 q 0.29 0.66 0.57 1.39 q 0.29 0.73 0.6 1.54 q 0.31 0.81 0.65 1.77 Z M 326.22 198.16 q -0.2 0.46 -0.46 1.12 q -0.25 0.66 -0.53 1.43 h 1.97 q -0.28 -0.77 -0.54 -1.44 q -0.26 -0.67 -0.45 -1.11 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round,
                pathData = addPathNodes("m 342.99 143.21 v 1.58 h -4.22 v 1.05 h 1.75 c 0.63 1.62 1.4 2.99 2.31 4.12 c -1.06 1.09 -2.28 1.83 -3.67 2.23 l 0.29 1.01 c 1.55 -0.45 2.91 -1.28 4.07 -2.47 c 1.17 1.19 2.53 2.02 4.07 2.47 l 0.29 -1.01 c -1.39 -0.4 -2.62 -1.14 -3.67 -2.23 c 0.91 -1.12 1.68 -2.5 2.31 -4.12 h 1.75 v -1.05 h -4.22 v -1.58 Z M 341.65 145.84 h 3.73 c -0.54 1.3 -1.16 2.4 -1.87 3.32 c -0.71 -0.91 -1.33 -2.01 -1.87 -3.32 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 0.25f,
                strokeLineCap = StrokeCap.Round,
                pathData = addPathNodes("m 337.26 195.96 v 1.22 L 334.0 197.19 v 0.81 h 1.35 c 0.48 1.25 1.08 2.31 1.78 3.18 c -0.82 0.85 -1.76 1.41 -2.83 1.72 l 0.23 0.78 c 1.19 -0.35 2.24 -0.98 3.14 -1.9 c 0.9 0.92 1.95 1.56 3.14 1.9 l 0.23 -0.78 c -1.07 -0.31 -2.02 -0.88 -2.83 -1.72 c 0.7 -0.87 1.3 -1.93 1.78 -3.18 h 1.35 v -0.81 L 338.07 197.19 v -1.22 Z M 336.22 198.0 h 2.88 c -0.41 1.01 -0.89 1.86 -1.44 2.56 c -0.55 -0.7 -1.03 -1.55 -1.44 -2.56 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 0.25f,
                strokeLineCap = StrokeCap.Round,
                pathData = addPathNodes("m 331.17 240.99 v 0.79 h -2.11 v 0.53 h 0.87 c 0.31 0.81 0.7 1.5 1.15 2.06 c -0.53 0.55 -1.14 0.91 -1.84 1.12 l 0.15 0.51 c 0.77 -0.22 1.45 -0.64 2.04 -1.23 c 0.58 0.59 1.26 1.01 2.04 1.23 l 0.15 -0.51 c -0.7 -0.2 -1.31 -0.57 -1.84 -1.12 c 0.45 -0.56 0.84 -1.25 1.15 -2.06 h 0.87 v -0.53 h -2.11 v -0.79 Z M 330.5 242.31 h 1.87 c -0.27 0.65 -0.58 1.2 -0.93 1.66 c -0.35 -0.45 -0.67 -1.01 -0.93 -1.66 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 78.99 68.0 c -35.37 0.0 -38.99 3.62 -38.99 38.92 v 98.16 c 0.0 0.09 0.0 0.16 0.0 0.25 V 108.92 C 40.0 73.62 43.63 69.99 78.99 69.99 H 152.0 H 225.01 c 35.28 0.0 38.97 3.62 38.99 38.67 v -1.75 c 0.0 -35.3 -3.63 -38.92 -38.99 -38.92 h -73.01 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 40.0 203.08 v 2.0 c 0.0 35.3 3.62 39.09 38.99 38.92 h 73.01 h 73.01 c 35.37 0.17 38.99 -3.63 38.99 -38.92 v -2.0 c 0.0 35.3 -3.63 39.09 -38.99 38.92 H 152.0 H 78.99 c -35.37 0.17 -38.99 -3.63 -38.99 -38.92 Z")
            )
            group(
                clipPathData = addPathNodes("m 335.0 241.1 c -0.0 -2.81 -0.29 -3.11 -3.1 -3.1 L 328.0 238.0 l -3.9 0.0 c -2.81 -0.01 -3.1 0.29 -3.1 3.1 l -0.0 5.81 C 321.0 249.71 321.29 250.0 324.1 250.0 L 328.0 250.0 L 331.9 250.0 C 334.71 250.0 335.0 249.71 335.0 246.9 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(328f, 238f),
                        end = Offset(328f, 250f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 335.0 241.1 c -0.0 -2.81 -0.29 -3.11 -3.1 -3.1 L 328.0 238.0 l -3.9 0.0 c -2.81 -0.01 -3.1 0.29 -3.1 3.1 l -0.0 5.81 C 321.0 249.71 321.29 250.0 324.1 250.0 L 328.0 250.0 L 331.9 250.0 C 334.71 250.0 335.0 249.71 335.0 246.9 Z")
                )
            }
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9765289f,
                pathData = addPathNodes("m 335.51 240.91 c 0.0 -2.9 -0.3 -3.44 -3.25 -3.42 h -4.26 h -4.26 c -2.95 -0.02 -3.25 0.53 -3.25 3.42 v 6.17 c 0.0 2.9 0.3 3.42 3.25 3.42 h 4.26 h 4.26 c 2.95 0.0 3.25 -0.53 3.25 -3.42 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9765289f,
                pathData = addPathNodes("m 343.51 195.49 c 0.0 -4.23 -0.46 -5.02 -4.99 -5.0 h -6.52 h -6.52 c -4.52 -0.02 -4.99 0.77 -4.99 5.0 v 9.02 c 0.0 4.23 0.46 5.0 4.99 5.0 h 6.52 h 6.52 c 4.52 0.0 4.99 -0.77 4.99 -5.0 Z")
            )
            group(
                clipPathData = addPathNodes("m 343.0 195.87 c -0.0 -4.41 -0.45 -4.89 -4.87 -4.87 L 332.0 191.0 L 325.87 191.0 C 321.45 190.98 321.0 191.45 321.0 195.87 l -0.0 8.27 C 321.0 208.55 321.45 209.0 325.87 209.0 L 332.0 209.0 L 338.13 209.0 C 342.55 209.0 343.0 208.55 343.0 204.14 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(332f, 191f),
                        end = Offset(332f, 209f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 343.0 195.87 c -0.0 -4.41 -0.45 -4.89 -4.87 -4.87 L 332.0 191.0 L 325.87 191.0 C 321.45 190.98 321.0 191.45 321.0 195.87 l -0.0 8.27 C 321.0 208.55 321.45 209.0 325.87 209.0 L 332.0 209.0 L 338.13 209.0 C 342.55 209.0 343.0 208.55 343.0 204.14 Z")
                )
            }
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 350.5 142.08 c 0.0 -5.56 -0.58 -6.6 -6.28 -6.57 h -8.22 h -8.22 c -5.7 -0.03 -6.28 1.01 -6.28 6.57 v 11.85 c 0.0 5.56 0.58 6.57 6.28 6.57 h 8.22 h 8.22 c 5.7 0.0 6.28 -1.01 6.28 -6.57 Z")
            )
            group(
                clipPathData = addPathNodes("m 350.0 142.49 c -0.0 -5.88 -0.58 -6.52 -6.2 -6.49 L 336.0 136.0 L 328.2 136.0 c -5.63 -0.03 -6.2 0.6 -6.2 6.49 l -0.0 11.03 c -0.0 5.88 0.58 6.49 6.2 6.49 L 336.0 160.0 L 343.8 160.0 C 349.42 160.0 350.0 159.4 350.0 153.51 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(336f, 136f),
                        end = Offset(336f, 160f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 350.0 142.49 c -0.0 -5.88 -0.58 -6.52 -6.2 -6.49 L 336.0 136.0 L 328.2 136.0 c -5.63 -0.03 -6.2 0.6 -6.2 6.49 l -0.0 11.03 c -0.0 5.88 0.58 6.49 6.2 6.49 L 336.0 160.0 L 343.8 160.0 C 349.42 160.0 350.0 159.4 350.0 153.51 Z")
                )
            }
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 366.5 75.23 c 0.0 -8.23 -0.91 -9.77 -9.75 -9.73 H 344.0 H 331.25 c -8.84 -0.04 -9.75 1.5 -9.75 9.73 v 17.54 c 0.0 8.23 0.91 9.73 9.75 9.73 h 12.75 h 12.75 c 8.84 0.0 9.75 -1.5 9.75 -9.73 Z")
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
                        start = Offset(344f, 66f),
                        end = Offset(344f, 102f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 366.0 75.73 c -0.0 -8.82 -0.91 -9.77 -9.75 -9.73 L 344.0 66.0 L 331.75 66.0 c -8.84 -0.04 -9.75 0.91 -9.75 9.73 l -0.0 16.54 c -0.0 8.82 0.91 9.73 9.75 9.73 L 344.0 102.0 L 356.25 102.0 C 365.09 102.0 366.0 101.09 366.0 92.27 Z")
                )
            }
        }.build()

        return _PreferencesDesktopLocale!!
    }

@Suppress("ObjectPropertyName")
private var _PreferencesDesktopLocale: ImageVector? = null
