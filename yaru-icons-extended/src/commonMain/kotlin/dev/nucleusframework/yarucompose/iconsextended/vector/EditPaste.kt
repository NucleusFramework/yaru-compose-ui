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

val EditPaste: ImageVector
    get() {
        if (_EditPaste != null) {
            return _EditPaste!!
        }
        _EditPaste = ImageVector.Builder(
            name = "EditPaste",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 96.0 62.0 L 84.31 62.0 c -2.41 0.0 -4.55 0.04 -6.56 0.1 c -2.69 0.08 -5.11 0.22 -7.19 0.48 c -12.77 1.61 -14.58 7.38 -14.54 26.37 c -0.0 0.31 -0.01 0.58 -0.01 0.9 v 52.15 v 50.72 v 1.43 v 0.0 v 0.0 c -0.1 20.53 1.7 26.08 16.16 27.44 c 1.11 0.1 2.29 0.19 3.55 0.25 c 0.0 0.0 0.0 -0.0 0.01 0.0 c 1.26 0.06 2.61 0.1 4.04 0.13 c 0.0 0.0 0.0 0.0 0.0 0.0 c 1.43 0.03 2.94 0.04 4.55 0.04 h 35.69 h 35.69 c 4.82 0.0 8.82 -0.09 12.15 -0.41 c 3.89 -0.37 6.86 -1.04 9.13 -2.22 c 0.65 -0.34 1.24 -0.72 1.77 -1.15 c 0.27 -0.21 0.52 -0.44 0.77 -0.68 c 0.24 -0.24 0.47 -0.49 0.69 -0.75 c 1.09 -1.32 1.88 -2.96 2.45 -4.99 c 0.0 -0.0 -0.0 -0.0 0.0 -0.0 c 0.23 -0.82 0.42 -1.69 0.58 -2.64 c 0.0 -0.0 -0.0 -0.0 0.0 -0.0 c 0.16 -0.95 0.29 -1.97 0.39 -3.06 c 0.0 -0.0 -0.0 -0.0 0.0 -0.0 c 0.31 -3.27 0.39 -7.21 0.37 -11.95 v -0.0 L 183.99 142.0 L 183.99 90.78 c 0.0 0.17 0.0 0.32 0.0 0.5 v -1.43 c 0.0 -0.26 -0.0 -0.49 -0.01 -0.74 c -0.0 -0.05 -0.0 -0.1 -0.0 -0.15 c 0.01 -4.32 -0.07 -8.0 -0.36 -11.06 c -0.05 -0.55 -0.11 -1.07 -0.18 -1.58 c -0.07 -0.51 -0.14 -1.0 -0.22 -1.48 c -0.08 -0.47 -0.17 -0.93 -0.27 -1.37 c -0.1 -0.44 -0.2 -0.86 -0.31 -1.27 c -0.11 -0.41 -0.24 -0.8 -0.37 -1.18 c -0.53 -1.51 -1.21 -2.77 -2.08 -3.82 c -0.22 -0.26 -0.45 -0.51 -0.69 -0.75 c -0.24 -0.24 -0.5 -0.46 -0.77 -0.68 c -0.54 -0.43 -1.13 -0.81 -1.77 -1.15 c -1.94 -1.02 -4.41 -1.65 -7.52 -2.05 c -0.0 -0.0 -0.0 0.0 -0.0 0.0 c -0.52 -0.07 -1.05 -0.12 -1.61 -0.18 c -0.0 -0.0 -0.0 0.0 -0.01 0.0 c -1.11 -0.1 -2.29 -0.19 -3.56 -0.25 c -0.0 -0.0 -0.0 0.0 -0.0 0.0 c -0.63 -0.03 -1.35 -0.04 -2.02 -0.06 c -0.22 -0.01 -0.44 -0.02 -0.67 -0.02 c -0.46 -0.01 -0.87 -0.03 -1.35 -0.04 h -0.0 C 158.81 62.01 157.29 62.0 155.69 62.0 h -0.0 h -11.69 Z M 56.03 86.59 c -0.0 0.4 -0.01 0.82 -0.01 1.23 c 0.0 -0.41 0.0 -0.84 0.01 -1.23 Z M 56.01 195.29 c 0.0 0.79 0.01 1.57 0.02 2.32 c -0.01 -0.74 -0.01 -1.53 -0.02 -2.32 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(326.18f, 185.21f),
                    end = Offset(331.82f, 204f)
                ),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 324.43 190.5 L 334.57 190.5 A 1.93 1.94 0.0 0 1 336.5 192.44 L 336.5 203.56 A 1.93 1.94 0.0 0 1 334.57 205.5 L 324.43 205.5 A 1.93 1.94 0.0 0 1 322.5 203.56 L 322.5 192.44 A 1.93 1.94 0.0 0 1 324.43 190.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(330f, 192f),
                    end = Offset(330f, 204f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 190.5 A 0.5 0.5 0.0 0 1 326.5 191.0 L 325.5 191.0 L 324.5 191.0 C 323.66 191.0 323.0 191.66 323.0 192.5 L 323.0 203.5 C 323.0 204.34 323.66 205.0 324.5 205.0 L 330.5 205.0 L 334.5 205.0 L 335.86 205.0 C 335.89 204.97 335.92 204.95 335.95 204.92 A 0.5 0.5 0.0 0 1 335.79 204.25 C 335.93 204.02 336.0 203.77 336.0 203.5 L 336.0 192.5 C 336.0 191.66 335.34 191.0 334.5 191.0 L 333.5 191.0 L 332.5 191.0 A 0.5 0.5 0.0 0 1 332.0 190.5 L 327.0 190.5 Z M 324.5 192.0 L 334.5 192.0 C 334.78 192.0 335.0 192.22 335.0 192.5 L 335.0 203.5 C 335.0 203.78 334.78 204.0 334.5 204.0 L 324.5 204.0 C 324.22 204.0 324.0 203.78 324.0 203.5 L 324.0 192.5 C 324.0 192.22 324.22 192.0 324.5 192.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.0 191.0 L 325.0 193.0 C 325.0 193.55 325.45 194.0 326.0 194.0 L 333.0 194.0 C 333.55 194.0 334.0 193.55 334.0 193.0 L 334.0 191.0 L 325.0 191.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.0 190.5 h 7.0 v 2.5 h -7.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 326.5 189.5 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(81.94f, 36f),
                    end = Offset(155.69f, 218.57f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 155.69 60.0 c 25.67 0.0 28.43 2.59 28.3 27.85 v 52.15 v 52.15 C 184.12 217.41 181.35 220.0 155.69 220.0 H 84.31 C 58.64 220.0 56.01 217.41 56.01 192.15 V 140.0 V 87.85 C 56.01 62.59 58.64 60.0 84.31 60.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 84.31 220.0 C 58.64 220.0 55.88 217.41 56.01 192.15 v -1.43 c -0.13 25.26 2.64 27.85 28.3 27.85 h 71.38 c 25.67 0.0 28.3 -2.59 28.3 -27.85 v 1.43 C 183.99 217.41 181.35 220.0 155.69 220.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.05f,
                strokeAlpha = 0.05f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 120.0 60.0 v 160.0 h 35.68 c 25.67 0.0 28.43 -2.59 28.3 -27.85 V 140.0 V 87.85 C 184.12 62.59 181.35 60.0 155.69 60.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 332.19 66.0 c -1.42 0.0 -2.55 0.03 -3.51 0.19 c -0.96 0.16 -1.79 0.47 -2.41 1.09 c -0.62 0.62 -0.94 1.46 -1.1 2.41 c -0.16 0.96 -0.19 2.09 -0.18 3.51 v 8.79 v 7.8 c -0.01 1.42 0.02 2.55 0.18 3.51 c 0.16 0.96 0.48 1.79 1.1 2.41 c 0.62 0.62 1.46 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 12.62 c 1.42 0.0 2.55 -0.03 3.5 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 c 0.16 -0.96 0.19 -2.08 0.19 -3.51 v -7.8 v -8.8 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.51 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.45 -0.93 -2.41 -1.09 C 347.36 66.03 346.23 66.0 344.81 66.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(335.63f, 60f),
                    end = Offset(344.81f, 97f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 332.08 65.5 c -5.56 0.0 -6.6 0.58 -6.57 6.28 v 9.22 v 8.22 c -0.03 5.7 1.01 6.28 6.57 6.28 h 12.85 c 5.56 0.0 6.57 -0.58 6.57 -6.28 v -8.22 v -9.22 c 0.0 -5.7 -1.01 -6.28 -6.57 -6.28 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.0 62.0 c -1.11 0.0 -2.0 0.89 -2.0 2.0 v 1.0 h -0.92 c -2.8 0.0 -4.57 0.1 -5.72 1.13 c -0.57 0.52 -0.92 1.24 -1.11 2.16 c -0.19 0.92 -0.25 2.05 -0.24 3.49 v 9.21 v 8.22 c -0.01 1.44 0.05 2.57 0.24 3.49 c 0.19 0.92 0.54 1.64 1.11 2.16 c 1.14 1.03 2.92 1.13 5.72 1.13 h 12.85 c 2.8 0.0 4.57 -0.1 5.71 -1.13 c 0.57 -0.52 0.91 -1.24 1.11 -2.16 c 0.2 -0.92 0.26 -2.05 0.26 -3.49 v -8.22 v -9.22 c 0.0 -1.44 -0.06 -2.57 -0.26 -3.49 c -0.2 -0.92 -0.54 -1.64 -1.11 -2.16 C 349.49 65.1 347.72 65.0 344.93 65.0 L 344.0 65.0 v -1.0 c 0.0 -1.11 -0.89 -2.0 -2.0 -2.0 Z M 332.08 66.0 h 1.2 c 0.35 0.6 0.98 1.0 1.72 1.0 L 342.0 67.0 c 0.74 0.0 1.38 -0.4 1.72 -1.0 h 1.2 c 2.76 0.0 4.28 0.19 5.04 0.88 c 0.38 0.34 0.63 0.83 0.8 1.63 c 0.17 0.79 0.24 1.87 0.24 3.28 v 9.22 v 8.22 c 0.0 1.41 -0.07 2.49 -0.24 3.28 c -0.17 0.79 -0.42 1.28 -0.8 1.63 c -0.76 0.68 -2.27 0.88 -5.04 0.88 h -12.85 c -2.76 0.0 -4.29 -0.19 -5.05 -0.88 c -0.38 -0.34 -0.64 -0.83 -0.8 -1.63 c -0.17 -0.79 -0.22 -1.87 -0.22 -3.28 v -0.0 v -8.22 v -9.22 v -0.0 c 0.0 -1.41 0.06 -2.49 0.22 -3.28 c 0.17 -0.79 0.42 -1.28 0.8 -1.63 c 0.76 -0.68 2.29 -0.88 5.05 -0.88 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(339f, 66f),
                    end = Offset(339f, 94f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 332.08 66.0 c -2.76 0.0 -4.29 0.19 -5.05 0.88 c -0.38 0.34 -0.64 0.83 -0.8 1.63 c -0.17 0.79 -0.22 1.87 -0.22 3.28 v 0.0 L 326.0 81.0 v 8.22 v 0.0 c 0.0 1.41 0.05 2.49 0.22 3.28 c 0.17 0.79 0.42 1.28 0.8 1.63 c 0.76 0.68 2.29 0.88 5.05 0.88 h 12.85 c 2.76 0.0 4.28 -0.19 5.04 -0.88 c 0.38 -0.34 0.63 -0.83 0.8 -1.63 c 0.17 -0.79 0.24 -1.87 0.24 -3.28 L 351.0 81.0 L 351.0 71.78 c 0.0 -1.41 -0.07 -2.49 -0.24 -3.28 c -0.17 -0.79 -0.42 -1.28 -0.8 -1.63 C 349.21 66.19 347.69 66.0 344.93 66.0 h -1.2 c -0.35 0.6 -0.98 1.0 -1.72 1.0 h -7.0 c -0.74 0.0 -1.38 -0.4 -1.72 -1.0 Z M 332.49 67.0 h 0.41 c 0.54 0.57 1.25 1.0 2.1 1.0 h 7.0 c 0.85 0.0 1.55 -0.43 2.1 -1.0 h 0.42 c 0.73 0.0 1.37 0.01 1.92 0.03 c 1.38 0.06 2.21 0.26 2.62 0.51 c 0.41 0.25 0.61 0.56 0.77 1.45 c 0.0 0.0 0.0 0.0 0.0 0.0 c -0.0 -0.0 0.0 0.05 0.02 0.16 l 0.0 0.01 v 0.01 c 0.05 0.33 0.09 0.7 0.12 1.13 c 0.01 0.2 0.01 0.45 0.02 0.7 v 0.0 v 0.0 c 0.01 0.37 0.02 0.71 0.02 1.1 L 350.0 81.0 L 350.0 88.89 c -0.0 0.4 -0.01 0.73 -0.02 1.1 v 0.0 v 0.0 c -0.01 0.26 -0.01 0.51 -0.02 0.71 c -0.02 0.43 -0.06 0.8 -0.12 1.13 v 0.0 v 0.0 c -0.02 0.11 -0.02 0.18 -0.02 0.17 c -0.16 0.89 -0.36 1.19 -0.77 1.45 c -0.41 0.25 -1.24 0.45 -2.62 0.51 C 345.88 93.99 345.24 94.0 344.51 94.0 h -12.03 c -0.73 0.0 -1.37 -0.01 -1.92 -0.03 c -1.65 -0.08 -2.47 -0.33 -2.84 -0.68 c -0.37 -0.35 -0.61 -1.05 -0.69 -2.59 c -0.01 -0.16 -0.01 -0.38 -0.02 -0.6 v -0.0 c -0.01 -0.43 -0.02 -0.82 -0.02 -1.29 L 327.0 88.8 L 327.0 81.0 v -8.8 v -0.0 c -0.0 -0.44 0.01 -0.8 0.02 -1.21 v -0.0 c 0.0 -0.25 0.01 -0.51 0.02 -0.71 v -0.0 c 0.08 -1.53 0.33 -2.22 0.7 -2.57 c 0.37 -0.34 1.18 -0.6 2.83 -0.68 C 331.12 67.01 331.76 67.0 332.49 67.0 Z M 325.02 90.02 c 0.0 0.04 0.0 0.09 0.0 0.13 c 0.0 0.1 0.01 0.22 0.01 0.33 c -0.0 -0.15 -0.01 -0.3 -0.01 -0.46 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.87 134.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 v 6.12 v 6.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.78 0.15 -1.67 0.15 -2.79 v -6.13 v -6.13 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 c -0.77 -0.13 -1.67 -0.15 -2.79 -0.15 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(327.79f, 128.34f),
                    end = Offset(336.14f, 158f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.64 134.5 c -4.66 0.0 -5.16 0.47 -5.14 5.1 v 6.4 v 6.4 c -0.02 4.62 0.48 5.1 5.14 5.1 h 8.73 c 4.66 0.0 5.14 -0.47 5.14 -5.1 v -6.4 v -6.4 c 0.0 -4.62 -0.48 -5.1 -5.14 -5.1 Z")
            )
            group(
                clipPathData = addPathNodes("m 327.87 135.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 L 323.0 146.0 L 323.0 152.13 C 322.98 156.55 323.45 157.0 327.87 157.0 h 8.27 C 340.55 157.0 341.0 156.55 341.0 152.13 L 341.0 146.0 L 341.0 139.87 C 341.0 135.45 340.55 135.0 336.14 135.0 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(332f, 135f),
                        end = Offset(332f, 157f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 327.87 135.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 L 323.0 146.0 L 323.0 152.13 C 322.98 156.55 323.45 157.0 327.87 157.0 h 8.27 C 340.55 157.0 341.0 156.55 341.0 152.13 L 341.0 146.0 L 341.0 139.87 C 341.0 135.45 340.55 135.0 336.14 135.0 Z")
                )
            }
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 135.0 L 327.0 137.0 C 327.0 137.55 327.45 138.0 328.0 138.0 L 336.0 138.0 C 336.55 138.0 337.0 137.55 337.0 137.0 L 337.0 135.0 L 327.0 135.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 0.976529f,
                pathData = addPathNodes("m 330.0 132.0 c -1.11 0.0 -2.0 0.89 -2.0 2.0 h -0.51 c -2.13 0.0 -3.52 0.08 -4.42 0.93 c -0.45 0.43 -0.72 1.02 -0.87 1.76 c -0.15 0.74 -0.2 1.64 -0.2 2.79 L 322.0 146.0 v 6.53 c 0.0 1.14 0.04 2.05 0.2 2.79 c 0.15 0.74 0.42 1.33 0.87 1.76 c 0.91 0.86 2.29 0.93 4.42 0.93 h 9.02 c 2.13 0.0 3.52 -0.07 4.43 -0.93 c 0.45 -0.43 0.72 -1.02 0.87 -1.76 c 0.15 -0.74 0.19 -1.64 0.19 -2.79 L 342.0 146.0 v -6.52 v -0.0 c 0.01 -1.14 -0.04 -2.05 -0.19 -2.79 c -0.15 -0.74 -0.42 -1.33 -0.87 -1.76 C 340.03 134.07 338.64 134.0 336.51 134.0 L 336.0 134.0 c 0.0 -1.11 -0.89 -2.0 -2.0 -2.0 Z M 327.49 134.98 L 328.0 134.98 h 8.0 h 0.51 c 2.1 0.0 3.22 0.16 3.76 0.67 c 0.27 0.25 0.46 0.62 0.59 1.24 c 0.13 0.62 0.17 1.47 0.17 2.59 L 341.02 146.0 v 6.53 v 0.0 c 0.0 1.12 -0.04 1.97 -0.17 2.59 c -0.13 0.62 -0.32 0.99 -0.59 1.24 c -0.54 0.51 -1.66 0.66 -3.76 0.66 h -9.02 c -2.1 0.0 -3.21 -0.16 -3.75 -0.66 c -0.27 -0.25 -0.46 -0.62 -0.59 -1.24 c -0.13 -0.62 -0.18 -1.47 -0.18 -2.59 L 322.98 146.0 L 322.98 139.48 c 0.0 -1.12 0.05 -1.97 0.18 -2.59 c 0.13 -0.62 0.32 -0.99 0.59 -1.25 c 0.54 -0.51 1.65 -0.66 3.75 -0.66 Z")
            )
            addPath(
                fillAlpha = 0.6f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 326.5 189.5 v 1.0 h -1.0 h -1.0 c -1.11 0.0 -2.0 0.89 -2.0 2.0 v 11.0 c 0.0 1.11 0.89 2.0 2.0 2.0 h 6.0 h 4.0 h 2.0 v -1.0 h -0.28 c 0.17 -0.29 0.28 -0.63 0.28 -1.0 v -11.0 c 0.0 -1.11 -0.89 -2.0 -2.0 -2.0 h -1.0 h -1.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE8E8E8),
                        1f to Color(0xFFF5F5F5)
                    ),
                    start = Offset(332.8f, 195.5f),
                    end = Offset(336.52f, 210.5f)
                ),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 329.43 195.5 L 339.57 195.5 A 1.93 1.93 0.0 0 1 341.5 197.43 L 341.5 208.57 A 1.93 1.93 0.0 0 1 339.57 210.5 L 329.43 210.5 A 1.93 1.93 0.0 0 1 327.5 208.57 L 327.5 197.43 A 1.93 1.93 0.0 0 1 329.43 195.5 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 199.0 h 9.0 v 1.0 h -9.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 202.0 h 9.0 v 1.0 h -9.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 330.0 205.0 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 335.87 140.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 v 6.12 v 6.13 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 c 0.13 -0.78 0.15 -1.67 0.15 -2.79 v -6.13 v -6.13 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 c -0.77 -0.13 -1.67 -0.15 -2.79 -0.15 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE8E8E8),
                        1f to Color(0xFFF5F5F5)
                    ),
                    start = Offset(335.64f, 140.5f),
                    end = Offset(344.37f, 163.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 335.64 140.5 c -4.66 0.0 -5.16 0.47 -5.14 5.1 v 6.4 v 6.4 c -0.02 4.62 0.48 5.1 5.14 5.1 h 8.73 c 4.66 0.0 5.14 -0.47 5.14 -5.1 v -6.4 v -6.4 c 0.0 -4.62 -0.48 -5.1 -5.14 -5.1 Z")
            )
            group(
                clipPathData = addPathNodes("m 335.87 141.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 L 331.0 152.0 L 331.0 158.13 C 330.98 162.55 331.45 163.0 335.87 163.0 h 8.27 C 348.55 163.0 349.0 162.55 349.0 158.13 L 349.0 152.0 L 349.0 145.87 C 349.0 141.45 348.55 141.0 344.14 141.0 Z")
            ) {
                addPath(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color.White,
                            0.13f to Color.White.copy(alpha = 0.09803922f),
                            0.93f to Color.White.copy(alpha = 0.09803922f),
                            1f to Color.White.copy(alpha = 0.49803922f)
                        ),
                        start = Offset(340f, 141f),
                        end = Offset(340f, 163f)
                    ),
                    fillAlpha = 0.7f,
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 335.87 141.0 c -4.41 0.0 -4.89 0.45 -4.87 4.87 L 331.0 152.0 L 331.0 158.13 C 330.98 162.55 331.45 163.0 335.87 163.0 h 8.27 C 348.55 163.0 349.0 162.55 349.0 158.13 L 349.0 152.0 L 349.0 145.87 C 349.0 141.45 348.55 141.0 344.14 141.0 Z")
                )
            }
            addPath(
                fillAlpha = 0.5f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.5f,
                strokeLineWidth = 0.976529f,
                pathData = addPathNodes("m 344.51 163.51 c 4.23 0.0 5.02 -0.46 5.0 -4.99 v -6.52 v -6.52 c 0.02 -4.52 -0.77 -4.99 -5.0 -4.99 h -9.02 c -4.23 0.0 -5.0 0.46 -5.0 4.99 v 6.52 v 6.52 c 0.0 4.52 0.77 4.99 5.0 4.99 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 334.0 146.0 v -1.0 h 12.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 334.0 149.0 v -1.0 h 12.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 334.0 152.0 v -1.0 h 12.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 334.0 155.0 v -1.0 h 7.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 330.0 133.0 c -0.55 0.0 -1.0 0.45 -1.0 1.0 v 1.0 h -1.0 v 2.0 h 2.0 h 4.0 h 2.0 v -2.0 h -1.0 v -1.0 c 0.0 -0.55 -0.45 -1.0 -1.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 343.19 76.0 c -1.42 0.0 -2.55 0.03 -3.51 0.19 c -0.96 0.16 -1.79 0.47 -2.41 1.09 c -0.62 0.62 -0.94 1.46 -1.1 2.41 c -0.16 0.96 -0.19 2.09 -0.18 3.51 v 7.79 v 8.8 c -0.01 1.42 0.02 2.55 0.18 3.51 c 0.16 0.96 0.48 1.79 1.1 2.41 c 0.62 0.62 1.46 0.93 2.41 1.09 c 0.96 0.16 2.08 0.19 3.51 0.19 h 12.61 c 1.42 0.0 2.55 -0.03 3.5 -0.19 c 0.96 -0.16 1.79 -0.47 2.41 -1.09 c 0.62 -0.62 0.93 -1.45 1.09 -2.41 c 0.16 -0.96 0.19 -2.08 0.19 -3.51 V 91.0 V 83.2 c 0.0 -1.42 -0.03 -2.55 -0.19 -3.51 c -0.16 -0.96 -0.47 -1.79 -1.09 -2.41 c -0.62 -0.62 -1.45 -0.93 -2.41 -1.09 C 358.36 76.03 357.23 76.0 355.81 76.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE8E8E8),
                        1f to Color(0xFFF5F5F5)
                    ),
                    start = Offset(343.08f, 76.5f),
                    end = Offset(354.93f, 105.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 343.08 75.5 c -5.56 0.0 -6.6 0.58 -6.57 6.28 v 8.22 v 9.22 c -0.03 5.7 1.01 6.28 6.57 6.28 h 12.85 c 5.56 0.0 6.57 -0.58 6.57 -6.28 V 90.0 V 81.78 c 0.0 -5.7 -1.01 -6.28 -6.57 -6.28 Z")
            )
            addPath(
                fillAlpha = 0.5f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.5f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 343.08 75.5 c -5.56 0.0 -6.6 0.58 -6.57 6.28 v 8.22 v 9.22 c -0.03 5.7 1.01 6.28 6.57 6.28 h 12.85 c 5.56 0.0 6.57 -0.58 6.57 -6.28 V 90.0 V 81.78 c 0.0 -5.7 -1.01 -6.28 -6.57 -6.28 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(349f, 77f),
                    end = Offset(349f, 105f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 343.07 76.0 c -2.76 0.0 -4.29 0.19 -5.05 0.88 c -0.38 0.34 -0.64 0.83 -0.8 1.63 c -0.17 0.79 -0.23 1.87 -0.22 3.28 v 0.0 L 337.0 90.0 v 9.22 v 0.0 c -0.01 1.41 0.06 2.49 0.22 3.28 c 0.17 0.79 0.42 1.28 0.8 1.63 c 0.76 0.68 2.29 0.88 5.05 0.88 h 12.85 c 2.76 0.0 4.28 -0.19 5.04 -0.88 c 0.38 -0.34 0.63 -0.83 0.8 -1.63 C 361.93 101.71 362.0 100.63 362.0 99.22 L 362.0 90.0 L 362.0 81.78 C 362.0 80.37 361.93 79.29 361.77 78.5 C 361.6 77.71 361.34 77.22 360.96 76.88 C 360.21 76.19 358.69 76.0 355.93 76.0 Z M 343.49 76.98 h 12.03 c 1.45 0.0 2.56 0.04 3.33 0.16 c 0.77 0.12 1.16 0.31 1.4 0.54 c 0.24 0.23 0.44 0.6 0.57 1.34 c 0.13 0.74 0.17 1.79 0.17 3.18 L 360.98 90.0 L 360.98 98.8 c 0.0 1.39 -0.04 2.44 -0.17 3.18 c -0.13 0.74 -0.32 1.11 -0.57 1.34 c -0.24 0.23 -0.63 0.42 -1.4 0.54 c -0.77 0.12 -1.87 0.16 -3.33 0.16 h -12.03 c -1.45 0.0 -2.56 -0.04 -3.33 -0.16 c -0.77 -0.12 -1.16 -0.31 -1.41 -0.54 c -0.24 -0.23 -0.44 -0.6 -0.57 -1.34 c -0.13 -0.74 -0.17 -1.79 -0.16 -3.18 L 338.03 98.8 L 338.03 90.0 v -7.8 v -0.0 c -0.01 -1.39 0.03 -2.44 0.16 -3.18 c 0.13 -0.74 0.32 -1.11 0.57 -1.34 c 0.24 -0.23 0.63 -0.42 1.41 -0.54 c 0.77 -0.12 1.88 -0.16 3.33 -0.16 Z M 362.78 78.51 c 0.03 0.17 0.06 0.33 0.09 0.52 c -0.02 -0.11 -0.02 -0.22 -0.04 -0.32 c -0.01 -0.07 -0.03 -0.13 -0.04 -0.19 Z M 362.87 79.02 C 362.97 79.8 363.0 80.7 363.0 81.78 L 363.0 90.0 L 363.0 99.22 c 0.0 1.08 -0.03 1.99 -0.13 2.76 c 0.12 -0.89 0.16 -1.91 0.16 -3.18 L 363.02 90.0 L 363.02 82.2 c 0.0 -1.27 -0.03 -2.29 -0.16 -3.18 Z M 362.87 101.98 c -0.02 0.18 -0.06 0.35 -0.09 0.52 c 0.01 -0.07 0.03 -0.13 0.04 -0.19 c 0.02 -0.1 0.03 -0.22 0.04 -0.32 Z M 336.21 78.53 c -0.01 0.06 -0.03 0.11 -0.04 0.17 c -0.02 0.1 -0.03 0.21 -0.04 0.32 c 0.02 -0.17 0.05 -0.33 0.08 -0.48 Z M 336.12 79.03 c -0.12 0.89 -0.15 1.91 -0.14 3.18 L 335.98 90.0 L 335.98 98.8 c -0.01 1.27 0.02 2.29 0.14 3.18 c -0.1 -0.77 -0.13 -1.68 -0.12 -2.76 L 336.0 90.0 L 336.0 81.79 c -0.01 -1.08 0.03 -1.98 0.12 -2.76 Z M 336.12 101.98 c 0.01 0.1 0.03 0.22 0.04 0.32 c 0.01 0.06 0.03 0.11 0.04 0.17 c -0.03 -0.16 -0.06 -0.31 -0.08 -0.48 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 341.0 82.0 v -1.0 h 17.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 341.0 86.0 v -1.0 h 17.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 341.0 90.0 v -1.0 h 17.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 3f,
                pathData = addPathNodes("m 341.0 94.0 v -1.0 h 10.0 v 1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 88.0 62.0 v 4.0 v 10.0 v 6.0 c 0.0 2.22 3.57 4.0 8.0 4.0 h 48.0 c 4.43 0.0 7.3 -1.9 8.0 -4.0 V 76.0 V 66.0 V 62.0 h -4.0 h -56.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF2F2F2),
                        1f to Color(0xFFF9F9F9)
                    ),
                    start = Offset(116f, 48f),
                    end = Offset(124f, 80f)
                ),
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 104.0 44.0 c -4.43 0.0 -7.64 1.81 -8.0 4.0 v 12.0 h -4.0 h -4.0 v 4.0 v 4.0 v 12.0 c 0.0 2.22 3.57 4.0 8.0 4.0 h 48.0 c 4.43 0.0 7.64 -1.81 8.0 -4.0 V 68.0 V 64.0 V 60.0 h -4.0 h -4.0 V 48.0 c 0.0 -2.22 -3.57 -4.0 -8.0 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 84.31 60.0 C 58.65 60.0 55.88 62.59 56.01 87.85 v 1.43 C 55.88 64.02 58.65 61.43 84.31 61.43 h 71.38 c 25.67 0.0 28.3 2.59 28.3 27.85 V 87.85 C 183.99 62.59 181.36 60.0 155.69 60.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(111.19f, -5.27f),
                    end = Offset(120f, 60f)
                ),
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 104.0 44.0 c -4.43 0.0 -7.64 1.81 -8.0 4.0 v 12.0 h 48.0 V 48.0 c 0.0 -2.22 -3.57 -4.0 -8.0 -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 104.0 44.0 c -4.43 0.0 -8.0 1.78 -8.0 4.0 v 1.0 c 0.0 -2.22 3.57 -4.0 8.0 -4.0 h 32.0 c 4.43 0.0 8.0 1.78 8.0 4.0 v -1.0 c 0.0 -2.22 -3.57 -4.0 -8.0 -4.0 Z")
            )
            addPath(
                fillAlpha = 0.6f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 329.43 195.5 L 339.57 195.5 A 1.93 1.93 0.0 0 1 341.5 197.43 L 341.5 208.57 A 1.93 1.93 0.0 0 1 339.57 210.5 L 329.43 210.5 A 1.93 1.93 0.0 0 1 327.5 208.57 L 327.5 197.43 A 1.93 1.93 0.0 0 1 329.43 195.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(334f, 197f),
                    end = Offset(334f, 209f)
                ),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 329.43 196.0 C 328.63 196.0 328.0 196.63 328.0 197.43 v 11.14 c 0.0 0.8 0.63 1.43 1.43 1.43 h 10.14 C 340.37 210.0 341.0 209.37 341.0 208.57 L 341.0 197.43 C 341.0 196.63 340.37 196.0 339.57 196.0 Z M 329.5 197.0 h 10.0 c 0.28 0.0 0.5 0.22 0.5 0.5 v 11.0 c 0.0 0.28 -0.22 0.5 -0.5 0.5 h -10.0 c -0.28 0.0 -0.5 -0.22 -0.5 -0.5 v -11.0 c 0.0 -0.28 0.22 -0.5 0.5 -0.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF999999),
                        0.61f to Color(0xFFB7B7B7),
                        1f to Color(0xFFDBDBDB)
                    ),
                    start = Offset(369.18f, 186.21f),
                    end = Offset(374.82f, 205f)
                ),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 367.43 191.5 L 377.57 191.5 A 1.93 1.94 0.0 0 1 379.5 193.44 L 379.5 204.56 A 1.93 1.94 0.0 0 1 377.57 206.5 L 367.43 206.5 A 1.93 1.94 0.0 0 1 365.5 204.56 L 365.5 193.44 A 1.93 1.94 0.0 0 1 367.43 191.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(373f, 193f),
                    end = Offset(373f, 205f)
                ),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 370.0 191.5 a 0.5 0.5 0.0 0 1 -0.5 0.5 h -1.0 h -1.0 c -0.84 0.0 -1.5 0.66 -1.5 1.5 v 11.0 c 0.0 0.84 0.66 1.5 1.5 1.5 h 6.0 h 4.0 h 1.36 c 0.03 -0.03 0.06 -0.05 0.09 -0.08 a 0.5 0.5 0.0 0 1 -0.16 -0.67 C 378.93 205.02 379.0 204.77 379.0 204.5 v -11.0 c 0.0 -0.84 -0.66 -1.5 -1.5 -1.5 h -1.0 h -1.0 a 0.5 0.5 0.0 0 1 -0.5 -0.5 Z M 367.5 193.0 h 10.0 c 0.28 0.0 0.5 0.22 0.5 0.5 v 11.0 c 0.0 0.28 -0.22 0.5 -0.5 0.5 h -10.0 c -0.28 0.0 -0.5 -0.22 -0.5 -0.5 v -11.0 c 0.0 -0.28 0.22 -0.5 0.5 -0.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 368.0 192.0 v 2.0 c 0.0 0.55 0.45 1.0 1.0 1.0 h 7.0 c 0.55 0.0 1.0 -0.45 1.0 -1.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 369.0 191.5 h 7.0 v 2.5 h -7.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 369.5 190.5 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fillAlpha = 0.6f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 369.5 190.5 v 1.0 h -1.0 h -1.0 c -1.11 0.0 -2.0 0.89 -2.0 2.0 v 11.0 c 0.0 1.11 0.89 2.0 2.0 2.0 h 6.0 h 4.0 h 2.0 v -1.0 h -0.28 c 0.17 -0.29 0.28 -0.63 0.28 -1.0 v -11.0 c 0.0 -1.11 -0.89 -2.0 -2.0 -2.0 h -1.0 h -1.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE8E8E8),
                        1f to Color(0xFFF5F5F5)
                    ),
                    start = Offset(375.8f, 196.5f),
                    end = Offset(379.52f, 211.5f)
                ),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 372.43 196.5 L 382.57 196.5 A 1.93 1.93 0.0 0 1 384.5 198.43 L 384.5 209.57 A 1.93 1.93 0.0 0 1 382.57 211.5 L 372.43 211.5 A 1.93 1.93 0.0 0 1 370.5 209.57 L 370.5 198.43 A 1.93 1.93 0.0 0 1 372.43 196.5 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 373.0 200.0 h 9.0 v 1.0 h -9.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 373.0 203.0 h 9.0 v 1.0 h -9.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 373.0 206.0 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fillAlpha = 0.6f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 372.43 196.5 L 382.57 196.5 A 1.93 1.93 0.0 0 1 384.5 198.43 L 384.5 209.57 A 1.93 1.93 0.0 0 1 382.57 211.5 L 372.43 211.5 A 1.93 1.93 0.0 0 1 370.5 209.57 L 370.5 198.43 A 1.93 1.93 0.0 0 1 372.43 196.5 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.13f to Color.White.copy(alpha = 0.09803922f),
                        0.93f to Color.White.copy(alpha = 0.09803922f),
                        1f to Color.White.copy(alpha = 0.49803922f)
                    ),
                    start = Offset(377f, 198f),
                    end = Offset(377f, 210f)
                ),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 372.43 197.0 C 371.63 197.0 371.0 197.63 371.0 198.43 v 11.14 c 0.0 0.8 0.63 1.43 1.43 1.43 h 10.14 C 383.37 211.0 384.0 210.37 384.0 209.57 L 384.0 198.43 C 384.0 197.63 383.37 197.0 382.57 197.0 Z M 372.5 198.0 h 10.0 c 0.28 0.0 0.5 0.22 0.5 0.5 v 11.0 c 0.0 0.28 -0.22 0.5 -0.5 0.5 h -10.0 c -0.28 0.0 -0.5 -0.22 -0.5 -0.5 v -11.0 c 0.0 -0.28 0.22 -0.5 0.5 -0.5 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 0.5f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 332.0 66.0 v 3.0 c 0.0 0.55 0.45 1.0 1.0 1.0 H 344.0 c 0.55 0.0 1.0 -0.45 1.0 -1.0 v -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 335.0 63.0 c 0.0 0.0 -1.0 0.0 -1.0 1.0 v 2.0 h -1.0 v 3.0 h 2.0 h 7.0 h 2.0 v -3.0 h -1.0 v -2.0 c 0.0 -1.0 -1.0 -1.0 -1.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 102.0 66.0 m -2.0 0.0 a 2.0 2.0 0.0 1 1 4.0 0.0 a 2.0 2.0 0.0 1 1 -4.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 110.0 66.0 m -2.0 0.0 a 2.0 2.0 0.0 1 1 4.0 0.0 a 2.0 2.0 0.0 1 1 -4.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 138.0 66.0 m -2.0 0.0 a 2.0 2.0 0.0 1 1 4.0 0.0 a 2.0 2.0 0.0 1 1 -4.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 130.0 66.0 m -2.0 0.0 a 2.0 2.0 0.0 1 1 4.0 0.0 a 2.0 2.0 0.0 1 1 -4.0 0.0")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 219.69 110.0 c 25.67 0.0 28.43 2.59 28.3 27.85 v 52.15 v 52.15 C 248.11 267.41 245.35 270.0 219.69 270.0 h -71.38 c -25.67 0.0 -28.3 -2.59 -28.3 -27.85 V 190.0 V 137.85 C 120.0 112.59 122.64 110.0 148.31 110.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE8E8E8),
                        1f to Color(0xFFF5F5F5)
                    ),
                    start = Offset(148.31f, 108f),
                    end = Offset(219.69f, 266.57f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 219.69 108.0 c 25.67 0.0 28.43 2.59 28.3 27.85 v 52.15 v 52.15 C 248.11 265.41 245.35 268.0 219.69 268.0 h -71.38 c -25.67 0.0 -28.3 -2.59 -28.3 -27.85 V 188.0 V 135.85 C 120.0 110.59 122.64 108.0 148.31 108.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 247.99 230.86 L 210.18 268.0 h 9.51 c 25.67 0.0 28.43 -2.59 28.3 -27.85 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 148.31 108.0 c -25.67 0.0 -28.43 2.59 -28.3 27.85 v 1.43 c -0.13 -25.26 2.64 -27.85 28.3 -27.85 h 71.38 c 25.67 0.0 28.3 2.59 28.3 27.85 v -1.43 C 247.99 110.59 245.36 108.0 219.69 108.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 148.31 268.0 c -25.67 0.0 -28.43 -2.59 -28.3 -27.85 v -1.43 c -0.13 25.26 2.64 27.85 28.3 27.85 h 71.38 c 25.67 0.0 28.3 -2.59 28.3 -27.85 v 1.43 c 0.0 25.26 -2.64 27.85 -28.3 27.85 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 184.0 108.0 v 160.0 h 35.68 c 25.67 0.0 28.43 -2.59 28.3 -27.85 V 188.0 V 135.85 C 248.11 110.59 245.35 108.0 219.68 108.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 120.02 184.0 l -0.0 56.12 c -0.0 25.26 2.64 27.85 28.3 27.85 h 71.38 c 25.67 0.0 28.43 -2.59 28.3 -27.85 L 248.0 184.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 144.0 132.0 h 80.0 v 8.0 h -80.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 144.0 156.0 h 80.0 v 8.0 h -80.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 144.0 180.0 h 80.0 v 8.0 h -80.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f,
                strokeLineWidth = 4f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 144.0 204.0 h 40.0 v 8.0 h -40.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 325.0 236.0 c -0.55 0.0 -1.0 0.45 -1.0 1.0 h -1.0 c -1.11 0.0 -2.0 0.89 -2.0 2.0 v 7.0 c 0.0 1.11 0.89 2.0 2.0 2.0 h 2.0 v -5.0 c 0.0 -1.11 0.89 -2.0 2.0 -2.0 h 4.0 v -2.0 c 0.0 -1.11 -0.89 -2.0 -2.0 -2.0 h -1.0 c 0.0 -0.55 -0.45 -1.0 -1.0 -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 241.0 L 333.0 241.0 A 2.0 2.0 0.0 0 1 335.0 243.0 L 335.0 250.0 A 2.0 2.0 0.0 0 1 333.0 252.0 L 327.0 252.0 A 2.0 2.0 0.0 0 1 325.0 250.0 L 325.0 243.0 A 2.0 2.0 0.0 0 1 327.0 241.0 Z")
            )
            addPath(
                fill = SolidColor(Color.LightGray),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 323.0 238.0 L 329.0 238.0 A 1.0 1.0 0.0 0 1 330.0 239.0 L 330.0 246.0 A 1.0 1.0 0.0 0 1 329.0 247.0 L 323.0 247.0 A 1.0 1.0 0.0 0 1 322.0 246.0 L 322.0 239.0 A 1.0 1.0 0.0 0 1 323.0 238.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 241.0 L 333.0 241.0 A 2.0 2.0 0.0 0 1 335.0 243.0 L 335.0 250.0 A 2.0 2.0 0.0 0 1 333.0 252.0 L 327.0 252.0 A 2.0 2.0 0.0 0 1 325.0 250.0 L 325.0 243.0 A 2.0 2.0 0.0 0 1 327.0 241.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 242.0 L 333.0 242.0 A 1.0 1.0 0.0 0 1 334.0 243.0 L 334.0 250.0 A 1.0 1.0 0.0 0 1 333.0 251.0 L 327.0 251.0 A 1.0 1.0 0.0 0 1 326.0 250.0 L 326.0 243.0 A 1.0 1.0 0.0 0 1 327.0 242.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 243.0 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 245.0 h 6.0 v 1.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFA7A7F1)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 327.0 247.0 h 3.0 v 1.0 h -3.0 Z")
            )
            addPath(
                fill = SolidColor(Color.LightGray),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.0 237.0 h 2.0 v 2.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 324.0 238.0 h 4.0 v 1.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("M 325.0 237.0 h 2.0 v 1.0 h -2.0 Z")
            )
        }.build()

        return _EditPaste!!
    }

@Suppress("ObjectPropertyName")
private var _EditPaste: ImageVector? = null
