package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.unit.dp

val Synaptic: ImageVector
    get() {
        if (_Synaptic != null) {
            return _Synaptic!!
        }
        _Synaptic = ImageVector.Builder(
            name = "Synaptic",
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
                pathData = addPathNodes("m 201.07 45.0 c 35.3 0.0 39.09 3.63 38.92 38.99 V 157.0 V 230.01 C 240.17 265.37 236.37 269.0 201.07 269.0 H 102.92 C 67.62 269.0 63.99 265.38 63.99 230.01 V 157.0 V 83.99 C 63.99 48.62 67.62 45.0 102.92 45.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 201.07 45.0 c 35.3 0.0 39.09 3.63 38.92 38.99 V 157.0 V 230.01 C 240.17 265.37 236.37 269.0 201.07 269.0 H 102.92 C 67.62 269.0 63.99 265.38 63.99 230.01 V 157.0 V 83.99 C 63.99 48.62 67.62 45.0 102.92 45.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 102.92 45.0 C 67.62 45.0 63.83 48.63 64.0 83.99 L 64.0 157.0 L 64.0 230.01 C 63.83 265.37 67.62 269.0 102.92 269.0 L 201.08 269.0 C 236.38 269.0 239.08 265.36 240.0 230.01 L 240.0 157.0 L 240.0 83.99 C 240.0 48.62 236.38 45.0 201.08 45.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF8367B),
                        1f to Color(0xFFF29CBB)
                    ),
                    start = Offset(102.92f, 44f),
                    end = Offset(201.08f, 266f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 201.07 44.0 c 35.3 0.0 39.09 3.63 38.92 38.99 V 156.0 V 229.01 C 240.17 264.37 236.37 268.0 201.07 268.0 H 102.92 C 67.62 268.0 63.99 264.38 63.99 229.01 V 156.0 V 82.99 C 63.99 47.62 67.62 44.0 102.92 44.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.1f,
                strokeAlpha = 0.1f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.87 189.0 c -1.12 0.0 -2.02 0.02 -2.79 0.15 c -0.78 0.13 -1.48 0.39 -2.01 0.92 c -0.53 0.53 -0.79 1.24 -0.92 2.01 c -0.13 0.78 -0.15 1.67 -0.14 2.79 V 201.0 v 5.12 c -0.0 1.12 0.02 2.02 0.14 2.79 c 0.13 0.78 0.39 1.49 0.92 2.01 c 0.53 0.53 1.23 0.79 2.01 0.92 c 0.78 0.13 1.67 0.15 2.79 0.15 h 8.27 c 1.12 0.0 2.01 -0.02 2.79 -0.15 c 0.77 -0.13 1.48 -0.39 2.01 -0.92 c 0.53 -0.53 0.79 -1.23 0.92 -2.01 C 341.98 208.14 342.0 207.25 342.0 206.12 V 201.0 V 194.88 c 0.0 -1.12 -0.02 -2.02 -0.15 -2.79 c -0.13 -0.78 -0.39 -1.48 -0.92 -2.01 c -0.53 -0.53 -1.23 -0.79 -2.01 -0.92 C 338.15 189.02 337.25 189.0 336.13 189.0 Z")
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
                pathData = addPathNodes("m 335.46 62.0 c -2.17 0.0 -3.87 0.05 -5.28 0.29 c -1.4 0.24 -2.55 0.68 -3.39 1.52 c -0.84 0.84 -1.29 2.0 -1.52 3.41 c -0.23 1.41 -0.28 3.13 -0.27 5.31 v 12.47 v 12.48 c -0.01 2.18 0.04 3.89 0.27 5.3 c 0.23 1.41 0.68 2.56 1.52 3.41 c 0.84 0.84 1.99 1.29 3.39 1.52 c 1.4 0.24 3.11 0.29 5.28 0.29 H 352.55 c 2.17 0.0 3.87 -0.05 5.27 -0.29 c 1.4 -0.24 2.55 -0.68 3.38 -1.53 c 0.84 -0.84 1.28 -2.0 1.51 -3.4 C 362.95 101.37 363.0 99.66 363.0 97.48 V 85.0 V 72.52 c 0.0 -2.18 -0.05 -3.89 -0.29 -5.3 c -0.24 -1.41 -0.68 -2.56 -1.51 -3.4 c -0.84 -0.84 -1.98 -1.29 -3.38 -1.53 C 356.42 62.05 354.71 62.0 352.55 62.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF8367B),
                        1f to Color(0xFFF29CBB)
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
                        0f to Color(0xFFF8367B),
                        1f to Color(0xFFF29CBB)
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
                        0f to Color(0xFFF8367B),
                        1f to Color(0xFFF29CBB)
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
                        0f to Color(0xFFF8367B),
                        1f to Color(0xFFF29CBB)
                    ),
                    start = Offset(330.08f, 133.5f),
                    end = Offset(341.93f, 162.5f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 330.08 133.5 c -5.56 0.0 -6.6 0.58 -6.57 6.28 v 8.22 v 8.22 c -0.03 5.7 1.01 6.28 6.57 6.28 h 11.85 c 5.56 0.0 6.57 -0.58 6.57 -6.28 v -8.22 v -8.22 c 0.0 -5.7 -1.01 -6.28 -6.57 -6.28 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(152f, 44f),
                    end = Offset(152f, 364f)
                ),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 16f,
                pathData = addPathNodes("M 144.0 44.0 h 16.0 v 224.0 h -16.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(344f, 62f),
                    end = Offset(344f, 142f)
                ),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 16f,
                pathData = addPathNodes("M 342.0 62.0 h 4.0 v 44.0 h -4.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(335f, 134f),
                    end = Offset(335f, 214f)
                ),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 335.0 134.0 h 2.0 v 28.0 h -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(331f, 183f),
                    end = Offset(331f, 263f)
                ),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 331.0 189.0 h 2.0 v 22.0 h -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(327f, 231f),
                    end = Offset(327f, 311f)
                ),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 327.0 237.0 h 2.0 v 14.0 h -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFE9578B)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f,
                strokeLineWidth = 2.18499f,
                pathData = addPathNodes("m 130.0 66.0 v 72.0 h -22.0 c 0.0 0.0 18.04 44.03 44.03 80.0 c 0.01 0.0 0.01 -0.0 0.02 -0.01 c 0.01 -0.0 0.02 -0.01 0.03 -0.02 c 0.01 -0.01 0.02 -0.01 0.03 -0.02 c 0.01 -0.0 0.02 -0.01 0.03 -0.01 C 178.95 180.0 196.0 138.0 196.0 138.0 H 174.0 V 66.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(174f, 45f),
                    end = Offset(175.17f, 268f)
                ),
                strokeLineWidth = 2.18499f,
                pathData = addPathNodes("m 130.0 44.0 v 86.0 h -22.0 c 0.0 0.0 18.04 44.03 44.03 80.0 c 0.01 0.0 0.01 -0.0 0.02 -0.01 c 0.01 -0.0 0.02 -0.01 0.03 -0.02 c 0.01 -0.01 0.02 -0.01 0.03 -0.02 c 0.01 -0.0 0.02 -0.01 0.03 -0.01 C 178.95 172.0 196.0 130.0 196.0 130.0 H 174.0 V 44.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFE9578B)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.41061f,
                pathData = addPathNodes("m 339.82 65.37 v 16.16 h -4.13 c 0.0 0.0 3.39 8.27 8.27 15.03 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.01 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 5.04 -7.13 8.24 -15.02 8.24 -15.02 h -4.13 V 65.37 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(348.09f, 63.18f),
                    end = Offset(348.31f, 105.09f)
                ),
                strokeLineWidth = 0.41061f,
                pathData = addPathNodes("m 339.82 62.0 l 0.18 17.0 h -4.0 c 0.0 0.0 3.08 8.43 7.96 15.19 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.01 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 5.04 -7.13 8.02 -15.18 8.02 -15.18 h -4.0 L 348.09 62.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFE9578B)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 0.300218f,
                pathData = addPathNodes("m 333.01 135.0 v 11.0 h -3.0 c 0.0 0.0 2.47 6.13 6.04 11.07 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 -0.05 -0.07 -0.05 -0.07 c 3.68 -5.21 6.0 -11.0 6.0 -11.0 h -3.0 v -11.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(339.07f, 132.03f),
                    end = Offset(339.23f, 162.67f)
                ),
                strokeLineWidth = 0.300218f,
                pathData = addPathNodes("m 333.01 133.89 v 10.11 l -3.01 -0.0 c 0.0 0.0 2.48 5.76 6.05 10.7 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 3.68 -5.21 6.03 -10.69 6.03 -10.69 l -3.08 -0.0 v -10.11 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFE9578B)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 0.200145f,
                pathData = addPathNodes("m 330.0 191.06 v 7.94 h -2.09 c 0.0 0.0 1.71 4.04 4.09 7.34 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 2.46 -3.48 3.96 -7.33 3.96 -7.33 H 334.0 v -7.94 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(333.95f, 190.04f),
                    end = Offset(334.06f, 210.47f)
                ),
                strokeLineWidth = 0.200145f,
                pathData = addPathNodes("m 330.0 189.0 v 9.0 l -2.0 -0.0 c 0.0 0.0 1.59 3.71 3.97 7.0 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.05 -0.0 0.05 -0.0 c 2.46 -3.48 3.97 -7.0 3.97 -7.0 L 334.0 198.0 V 189.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFE9578B)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 0.13343f,
                pathData = addPathNodes("m 326.0 237.0 v 6.0 h -2.0 c 0.0 0.0 2.48 3.13 4.07 5.32 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 C 329.71 246.0 332.0 243.0 332.0 243.0 h -2.0 v -6.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF29CBB),
                        1f to Color(0xFFFAC4D7)
                    ),
                    start = Offset(329.41f, 237.12f),
                    end = Offset(329.48f, 250.74f)
                ),
                strokeLineWidth = 0.13343f,
                pathData = addPathNodes("m 326.0 237.0 v 5.0 h -2.0 c 0.0 0.0 2.48 3.0 4.07 5.2 c 0.0 0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 c 0.0 -0.0 0.0 -0.0 0.0 -0.0 C 329.71 244.88 332.0 242.0 332.0 242.0 h -2.0 v -4.94 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("M 80.0 204.0 h 52.0 v 32.0 h -52.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 84.0 212.0 v 16.0 h 8.0 v -16.0 Z M 96.0 212.0 v 16.0 h 4.0 L 100.0 212.0 Z M 104.0 212.0 v 16.0 h 8.0 v -16.0 Z M 116.0 212.0 v 16.0 h 4.0 v -16.0 Z M 124.0 212.0 v 16.0 h 4.0 v -16.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("M 328.0 92.0 h 11.0 v 8.0 h -11.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 329.0 94.0 v 4.0 h 1.0 v -4.0 Z M 331.0 94.0 v 4.0 h 0.5 v -4.0 Z M 332.5 94.0 v 4.0 h 0.5 v -4.0 Z M 334.0 94.0 v 4.0 h 1.0 v -4.0 Z M 336.0 94.0 v 4.0 h 0.5 v -4.0 Z M 337.5 94.0 v 4.0 h 0.5 v -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF71364)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 338.0 153.0 v 1.0 h 9.0 v -1.0 Z M 338.0 155.0 v 1.0 h 5.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 325.0 153.0 h 9.0 v 4.0 h -9.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 326.0 154.0 v 2.0 h 1.0 v -2.0 Z M 328.0 154.0 v 2.0 h 0.5 v -2.0 Z M 329.0 154.0 v 2.0 h 0.5 v -2.0 Z M 330.0 154.0 v 2.0 h 1.0 v -2.0 Z M 332.5 154.0 v 2.0 h 0.5 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF71364)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 334.0 205.0 v 1.0 h 5.0 v -1.0 Z M 334.0 207.0 v 1.0 h 3.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 324.0 205.0 h 6.0 v 4.0 h -6.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 325.0 206.0 v 2.0 h 0.5 v -2.0 Z M 326.0 206.0 v 2.0 h 0.5 v -2.0 Z M 327.0 206.0 v 2.0 h 1.0 v -2.0 Z M 328.5 206.0 v 2.0 h 0.5 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF71364)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 329.0 246.0 v 0.5 h 5.0 L 334.0 246.0 Z M 329.0 248.0 v 0.5 h 3.0 L 332.0 248.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFF9F9F9)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 322.0 246.0 h 4.0 v 3.0 h -4.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFF5D5D5D)),
                strokeLineWidth = 16f,
                pathData = addPathNodes("m 322.5 247.0 v 1.0 h 0.5 v -1.0 Z M 323.5 247.0 v 1.0 h 0.5 v -1.0 Z M 324.5 247.0 v 1.0 h 1.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 204.46 224.91 c -0.99 0.01 0.19 0.51 1.48 0.71 c 0.36 -0.28 0.68 -0.56 0.97 -0.83 c -0.8 0.2 -1.62 0.2 -2.45 0.13")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 209.77 223.59 c 0.59 -0.81 1.02 -1.7 1.17 -2.63 c -0.13 0.66 -0.49 1.22 -0.82 1.82 c -1.85 1.17 -0.17 -0.69 -0.0 -1.4 c -1.99 2.51 -0.27 1.5 -0.35 2.2")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 211.74 218.48 c 0.12 -1.78 -0.35 -1.22 -0.51 -0.54 c 0.18 0.1 0.33 1.26 0.51 0.54")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 200.71 194.11 c 0.53 0.09 1.14 0.17 1.05 0.29 c 0.58 -0.13 0.71 -0.24 -1.05 -0.29")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("M 201.76 194.41 L 201.39 194.49 L 201.74 194.45 L 201.76 194.41")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 218.24 219.16 c 0.06 1.6 -0.47 2.38 -0.94 3.75 l -0.86 0.43 c -0.7 1.36 0.07 0.86 -0.43 1.95 c -1.09 0.97 -3.32 3.04 -4.03 3.23 c -0.52 -0.01 0.35 -0.61 0.47 -0.85 c -1.46 1.0 -1.17 1.51 -3.41 2.12 L 208.96 229.64 c -5.52 2.6 -13.19 -2.55 -13.08 -9.57 c -0.06 0.45 -0.17 0.33 -0.29 0.51 c -0.28 -3.61 1.67 -7.24 4.96 -8.72 c 3.22 -1.59 7.0 -0.94 9.31 1.21 c -1.27 -1.66 -3.79 -3.42 -6.78 -3.26 c -2.93 0.05 -5.67 1.91 -6.58 3.93 c -1.5 0.94 -1.67 3.64 -2.33 4.14 c -0.88 6.47 1.65 9.26 5.94 12.55 c 0.67 0.45 0.19 0.52 0.28 0.87 c -1.42 -0.67 -2.73 -1.67 -3.8 -2.91 c 0.57 0.83 1.18 1.64 1.98 2.28 c -1.34 -0.45 -3.14 -3.25 -3.66 -3.37 c 2.32 4.15 9.39 7.27 13.1 5.72 c -1.72 0.06 -3.89 0.04 -5.82 -0.68 c -0.81 -0.42 -1.91 -1.28 -1.71 -1.44 c 5.06 1.89 10.28 1.43 14.66 -2.08 c 1.11 -0.87 2.33 -2.34 2.68 -2.36 c -0.53 0.8 0.09 0.38 -0.32 1.09 c 1.11 -1.79 -0.48 -0.73 1.15 -3.09 l 0.6 0.83 c -0.23 -1.49 1.85 -3.29 1.63 -5.64 c 0.48 -0.72 0.53 0.77 0.03 2.43 c 0.7 -1.83 0.18 -2.13 0.36 -3.64 c 0.19 0.51 0.45 1.05 0.58 1.59 c -0.46 -1.77 0.47 -2.98 0.69 -4.01 c -0.23 -0.1 -0.7 0.78 -0.81 -1.31 c 0.02 -0.91 0.25 -0.48 0.34 -0.7 c -0.18 -0.1 -0.65 -0.8 -0.93 -2.14 c 0.2 -0.31 0.55 0.81 0.83 0.86 c -0.18 -1.06 -0.49 -1.87 -0.5 -2.69 c -0.82 -1.72 -0.29 0.23 -0.96 -0.74 c -0.87 -2.73 0.72 -0.63 0.83 -1.87 c 1.32 1.92 2.08 4.89 2.43 6.12 c -0.27 -1.5 -0.69 -2.96 -1.22 -4.37 c 0.4 0.17 -0.65 -3.09 0.52 -0.93 C 221.83 203.65 217.73 199.35 213.96 197.33 C 214.42 197.75 215.0 198.28 214.79 198.37 C 212.92 197.25 213.25 197.16 212.98 196.69 C 211.45 196.07 211.35 196.74 210.34 196.69 C 207.46 195.16 206.9 195.33 204.25 194.37 L 204.37 194.93 C 202.46 194.3 202.14 195.17 200.08 194.93 C 199.96 194.84 200.74 194.58 201.39 194.49 C 199.55 194.73 199.63 194.12 197.83 194.55 C 198.27 194.24 198.74 194.03 199.22 193.77 C 197.71 193.86 195.62 194.64 196.27 193.93 C 193.81 195.03 189.45 196.56 187.01 198.86 L 186.93 198.34 c -1.12 1.35 -4.89 4.02 -5.19 5.76 l -0.3 0.07 c -0.58 0.99 -0.96 2.11 -1.42 3.12 c -0.76 1.3 -1.12 0.5 -1.01 0.7 c -1.5 3.04 -2.25 5.6 -2.89 7.7 c 0.46 0.69 0.01 4.13 0.18 6.88 c -0.75 13.61 9.55 26.83 20.82 29.88 c 1.65 0.59 4.11 0.57 6.19 0.63 c -2.46 -0.7 -2.78 -0.37 -5.18 -1.21 c -1.73 -0.82 -2.11 -1.75 -3.34 -2.81 l 0.49 0.86 c -2.4 -0.85 -1.4 -1.05 -3.36 -1.67 l 0.52 -0.68 c -0.78 -0.06 -2.07 -1.31 -2.42 -2.01 l -0.85 0.03 c -1.02 -1.26 -1.57 -2.18 -1.53 -2.88 l -0.28 0.49 c -0.31 -0.54 -3.77 -4.74 -1.98 -3.76 c -0.33 -0.3 -0.78 -0.49 -1.26 -1.37 l 0.37 -0.42 c -0.86 -1.11 -1.59 -2.53 -1.53 -3.01 c 0.46 0.62 0.78 0.74 1.1 0.84 c -2.18 -5.41 -2.3 -0.3 -3.95 -5.51 l 0.35 -0.03 c -0.27 -0.4 -0.43 -0.84 -0.65 -1.27 l 0.15 -1.51 c -1.57 -1.81 -0.44 -7.72 -0.21 -10.95 c 0.16 -1.32 1.31 -2.72 2.19 -4.91 l -0.53 -0.09 c 1.02 -1.78 5.83 -7.15 8.06 -6.88 c 1.08 -1.36 -0.21 -0.01 -0.43 -0.35 c 2.37 -2.45 3.12 -1.73 4.72 -2.18 c 1.72 -1.02 -1.48 0.4 -0.66 -0.39 c 2.98 -0.76 2.11 -1.73 6.0 -2.12 c 0.41 0.23 -0.95 0.36 -1.29 0.66 c 2.48 -1.22 7.86 -0.94 11.36 0.67 c 4.05 1.9 8.61 7.5 8.79 12.76 l 0.2 0.05 c -0.1 2.09 0.32 4.52 -0.42 6.74 l 0.5 -1.05")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 193.65 226.27 l -0.14 0.69 c 0.65 0.88 1.17 1.84 2.0 2.53 c -0.6 -1.17 -1.04 -1.65 -1.86 -3.23")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 195.19 226.21 c -0.34 -0.38 -0.55 -0.84 -0.78 -1.3 c 0.22 0.8 0.67 1.49 1.08 2.19 l -0.31 -0.9")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 222.41 220.29 l -0.15 0.37 c -0.27 1.89 -0.84 3.77 -1.73 5.5 c 0.98 -1.83 1.6 -3.84 1.87 -5.87")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("M 200.9 193.64 C 201.57 193.4 202.55 193.51 203.26 193.34 C 202.33 193.42 201.41 193.47 200.5 193.58 l 0.4 0.06")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 177.4 206.14 c 0.15 1.43 -1.07 1.98 0.27 1.04 c 0.72 -1.63 -0.28 -0.45 -0.27 -1.04")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 175.82 212.74 c 0.31 -0.95 0.37 -1.52 0.48 -2.08 c -0.86 1.1 -0.39 1.33 -0.48 2.08")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 355.5 96.51 c -0.23 0.0 0.04 0.12 0.34 0.16 c 0.08 -0.06 0.16 -0.13 0.22 -0.19 c -0.18 0.05 -0.37 0.05 -0.56 0.03")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 356.72 96.21 c 0.14 -0.19 0.23 -0.39 0.27 -0.6 c -0.03 0.15 -0.11 0.28 -0.19 0.42 c -0.42 0.27 -0.04 -0.16 -0.0 -0.32 c -0.46 0.57 -0.06 0.34 -0.08 0.5")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 357.17 95.04 c 0.03 -0.41 -0.08 -0.28 -0.12 -0.12 c 0.04 0.02 0.08 0.29 0.12 0.12")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 354.64 89.45 c 0.12 0.02 0.26 0.04 0.24 0.07 c 0.13 -0.03 0.16 -0.06 -0.24 -0.07")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("M 354.88 89.52 L 354.79 89.54 L 354.87 89.53 L 354.88 89.52")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 358.66 95.19 c 0.01 0.37 -0.11 0.55 -0.22 0.86 l -0.2 0.1 c -0.16 0.31 0.02 0.2 -0.1 0.45 c -0.25 0.22 -0.76 0.7 -0.92 0.74 c -0.12 -0.0 0.08 -0.14 0.11 -0.19 c -0.34 0.23 -0.27 0.35 -0.78 0.49 L 356.53 97.59 c -1.26 0.6 -3.02 -0.58 -3.0 -2.19 c -0.01 0.1 -0.04 0.08 -0.07 0.12 c -0.07 -0.83 0.38 -1.66 1.14 -2.0 c 0.74 -0.37 1.6 -0.22 2.13 0.28 c -0.29 -0.38 -0.87 -0.78 -1.55 -0.75 c -0.67 0.01 -1.3 0.44 -1.51 0.9 c -0.34 0.22 -0.38 0.83 -0.53 0.95 c -0.2 1.48 0.38 2.12 1.36 2.88 c 0.15 0.1 0.04 0.12 0.06 0.2 c -0.33 -0.15 -0.63 -0.38 -0.87 -0.67 c 0.13 0.19 0.27 0.38 0.45 0.52 c -0.31 -0.1 -0.72 -0.75 -0.84 -0.77 c 0.53 0.95 2.15 1.67 3.0 1.31 c -0.39 0.01 -0.89 0.01 -1.33 -0.16 c -0.19 -0.1 -0.44 -0.29 -0.39 -0.33 c 1.16 0.43 2.36 0.33 3.36 -0.48 c 0.26 -0.2 0.53 -0.54 0.61 -0.54 c -0.12 0.18 0.02 0.09 -0.07 0.25 c 0.25 -0.41 -0.11 -0.17 0.26 -0.71 l 0.14 0.19 c -0.05 -0.34 0.42 -0.75 0.37 -1.29 c 0.11 -0.16 0.12 0.18 0.01 0.56 c 0.16 -0.42 0.04 -0.49 0.08 -0.83 c 0.04 0.12 0.1 0.24 0.13 0.36 c -0.1 -0.41 0.11 -0.68 0.16 -0.92 c -0.05 -0.02 -0.16 0.18 -0.19 -0.3 c 0.0 -0.21 0.06 -0.11 0.08 -0.16 c -0.04 -0.02 -0.15 -0.18 -0.21 -0.49 c 0.05 -0.07 0.13 0.19 0.19 0.2 c -0.04 -0.24 -0.11 -0.43 -0.12 -0.62 c -0.19 -0.39 -0.07 0.05 -0.22 -0.17 c -0.2 -0.62 0.17 -0.14 0.19 -0.43 c 0.3 0.44 0.48 1.12 0.56 1.4 c -0.06 -0.34 -0.16 -0.68 -0.28 -1.0 c 0.09 0.04 -0.15 -0.71 0.12 -0.21 C 359.48 91.64 358.54 90.65 357.68 90.19 C 357.78 90.29 357.91 90.41 357.87 90.43 C 357.44 90.17 357.51 90.15 357.45 90.04 C 357.1 89.9 357.08 90.05 356.85 90.04 C 356.18 89.69 356.06 89.73 355.45 89.51 L 355.48 89.64 C 355.04 89.49 354.97 89.69 354.5 89.64 C 354.47 89.62 354.65 89.56 354.8 89.54 C 354.37 89.59 354.39 89.45 353.98 89.55 C 354.08 89.48 354.19 89.43 354.3 89.37 C 353.95 89.39 353.47 89.57 353.62 89.41 C 353.06 89.66 352.06 90.01 351.5 90.54 L 351.48 90.42 c -0.26 0.31 -1.12 0.92 -1.19 1.32 l -0.07 0.02 c -0.13 0.23 -0.22 0.48 -0.33 0.72 c -0.17 0.3 -0.26 0.11 -0.23 0.16 c -0.34 0.7 -0.52 1.28 -0.66 1.76 c 0.11 0.16 0.0 0.95 0.04 1.58 c -0.17 3.12 2.19 6.15 4.77 6.85 c 0.38 0.14 0.94 0.13 1.42 0.14 c -0.56 -0.16 -0.64 -0.09 -1.19 -0.28 c -0.4 -0.19 -0.48 -0.4 -0.76 -0.64 l 0.11 0.2 c -0.55 -0.2 -0.32 -0.24 -0.77 -0.38 l 0.12 -0.16 c -0.18 -0.01 -0.47 -0.3 -0.55 -0.46 l -0.2 0.01 c -0.23 -0.29 -0.36 -0.5 -0.35 -0.66 l -0.06 0.11 c -0.07 -0.12 -0.86 -1.09 -0.45 -0.86 c -0.08 -0.07 -0.18 -0.11 -0.29 -0.31 l 0.08 -0.1 c -0.2 -0.25 -0.36 -0.58 -0.35 -0.69 c 0.11 0.14 0.18 0.17 0.25 0.19 c -0.5 -1.24 -0.53 -0.07 -0.91 -1.26 l 0.08 -0.01 c -0.06 -0.09 -0.1 -0.19 -0.15 -0.29 l 0.03 -0.35 c -0.36 -0.42 -0.1 -1.77 -0.05 -2.51 c 0.04 -0.3 0.3 -0.62 0.5 -1.13 l -0.12 -0.02 c 0.23 -0.41 1.34 -1.64 1.85 -1.58 c 0.25 -0.31 -0.05 -0.0 -0.1 -0.08 c 0.54 -0.56 0.71 -0.4 1.08 -0.5 c 0.4 -0.23 -0.34 0.09 -0.15 -0.09 c 0.68 -0.17 0.48 -0.4 1.38 -0.49 c 0.09 0.05 -0.22 0.08 -0.3 0.15 c 0.57 -0.28 1.8 -0.22 2.6 0.15 c 0.93 0.43 1.97 1.72 2.01 2.93 l 0.05 0.01 c -0.02 0.48 0.07 1.04 -0.1 1.55 l 0.11 -0.24")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 353.02 96.82 l -0.03 0.16 c 0.15 0.2 0.27 0.42 0.46 0.58 c -0.14 -0.27 -0.24 -0.38 -0.43 -0.74")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 353.37 96.81 c -0.08 -0.09 -0.13 -0.19 -0.18 -0.3 c 0.05 0.18 0.15 0.34 0.25 0.5 l -0.07 -0.21")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 359.61 95.45 l -0.03 0.08 c -0.06 0.43 -0.19 0.86 -0.4 1.26 c 0.22 -0.42 0.37 -0.88 0.43 -1.35")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("M 354.68 89.34 C 354.84 89.29 355.06 89.31 355.22 89.28 C 355.01 89.29 354.8 89.3 354.59 89.33 l 0.09 0.01")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 349.3 92.21 c 0.04 0.33 -0.25 0.45 0.06 0.24 c 0.17 -0.37 -0.06 -0.1 -0.06 -0.24")
            )
            addPath(
                fill = SolidColor(Color(0xFFD70751)),
                pathData = addPathNodes("m 348.93 93.72 c 0.07 -0.22 0.08 -0.35 0.11 -0.48 c -0.2 0.25 -0.09 0.3 -0.11 0.48")
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
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 0.9999999f,
                pathData = addPathNodes("m 336.5 211.5 c 4.23 0.0 5.02 -0.46 5.0 -4.98 v -6.52 v -6.52 c 0.02 -4.52 -0.77 -4.98 -5.0 -4.98 h -9.01 c -4.23 0.0 -5.0 0.46 -5.0 4.98 v 6.52 v 6.52 c 0.0 4.52 0.77 4.98 5.0 4.98 Z")
            )
            addPath(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.Black),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 331.08 251.5 c 2.89 0.0 3.43 -0.3 3.42 -3.25 v -4.25 v -4.25 c 0.02 -2.95 -0.53 -3.25 -3.42 -3.25 h -6.16 c -2.89 0.0 -3.42 0.3 -3.42 3.25 v 4.25 v 4.25 c 0.0 2.95 0.53 3.25 3.42 3.25 Z")
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
                    fillAlpha = 0.6f,
                    strokeAlpha = 0.6f,
                    strokeLineWidth = 2f,
                    pathData = addPathNodes("m 330.49 134.0 c -5.88 0.0 -6.52 0.58 -6.49 6.2 L 324.0 148.0 L 324.0 155.8 c -0.03 5.63 0.6 6.2 6.49 6.2 l 11.03 0.0 c 5.88 0.0 6.49 -0.58 6.49 -6.2 L 348.0 148.0 L 348.0 140.2 C 348.0 134.58 347.4 134.0 341.51 134.0 Z")
                )
            }
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
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 335.73 62.0 C 326.91 62.0 325.96 62.91 326.0 71.75 L 326.0 84.0 L 326.0 96.25 C 325.96 105.09 326.91 106.0 335.73 106.0 h 16.54 C 361.09 106.0 362.0 105.09 362.0 96.25 L 362.0 84.0 L 362.0 71.75 C 362.0 62.91 361.09 62.0 352.27 62.0 Z M 347.32 63.08 c 1.59 -0.0 3.17 -0.0 4.76 0.01 c 2.24 0.11 4.62 -0.16 6.78 0.68 c 1.61 0.82 1.9 2.82 1.98 4.45 c 0.15 8.95 0.06 17.94 0.07 26.91 c -0.11 2.42 0.23 4.9 -0.51 7.25 c -0.35 1.47 -1.87 2.11 -3.22 2.34 c -7.12 0.21 -14.25 0.17 -21.38 0.17 c -2.38 -0.11 -4.97 0.29 -7.12 -0.96 c -1.54 -1.12 -1.38 -3.33 -1.49 -4.96 c -0.14 -9.23 -0.02 -18.55 0.0 -27.81 c 0.11 -1.79 -0.17 -3.61 0.34 -5.36 c 0.36 -1.61 2.02 -2.38 3.52 -2.52 c 5.41 -0.23 10.85 -0.13 16.28 -0.18 Z")
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
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 324.91 236.99 c -1.43 0.0 -2.16 0.12 -2.46 0.39 c -0.15 0.14 -0.26 0.33 -0.34 0.71 c -0.08 0.38 -0.12 0.93 -0.12 1.65 L 321.99 244.0 v 4.26 c 0.0 0.72 0.04 1.27 0.12 1.65 c 0.08 0.38 0.19 0.58 0.34 0.71 c 0.3 0.27 1.03 0.39 2.46 0.39 h 6.17 c 1.43 0.0 2.17 -0.12 2.47 -0.39 c 0.15 -0.14 0.26 -0.33 0.34 -0.71 c 0.08 -0.38 0.12 -0.93 0.11 -1.65 v -0.0 L 334.01 244.0 v -4.26 v -0.0 c 0.0 -0.72 -0.03 -1.27 -0.11 -1.65 c -0.08 -0.38 -0.19 -0.58 -0.34 -0.71 c -0.3 -0.27 -1.04 -0.39 -2.47 -0.39 Z M 327.23 238.02 c 0.91 -0.0 1.82 -0.0 2.73 0.0 c 0.91 0.03 1.83 -0.05 2.73 0.1 c 0.25 -0.02 0.2 0.27 0.24 0.44 c 0.08 2.81 0.05 5.68 0.04 8.51 c -0.02 0.86 0.02 1.71 -0.07 2.55 c 0.01 0.31 -0.36 0.26 -0.58 0.31 c -2.08 0.06 -4.23 0.04 -6.34 0.04 c -0.89 -0.03 -1.78 0.04 -2.66 -0.09 c -0.25 0.03 -0.21 -0.26 -0.26 -0.43 c -0.08 -2.9 -0.05 -5.84 -0.04 -8.75 c 0.03 -0.79 -0.03 -1.58 0.08 -2.37 c -0.02 -0.28 0.3 -0.21 0.47 -0.26 c 1.21 -0.08 2.44 -0.04 3.65 -0.06 Z")
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
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f,
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.5 189.0 c -2.09 0.0 -3.21 0.16 -3.74 0.66 c -0.27 0.25 -0.46 0.62 -0.58 1.24 C 323.05 191.52 323.0 192.37 323.0 193.48 L 323.0 200.0 v 6.52 c 0.0 1.12 0.05 1.97 0.18 2.59 c 0.13 0.62 0.32 0.99 0.58 1.24 c 0.53 0.5 1.64 0.66 3.74 0.66 h 9.01 c 2.1 0.0 3.21 -0.16 3.75 -0.66 c 0.27 -0.25 0.46 -0.62 0.58 -1.24 c 0.12 -0.62 0.17 -1.47 0.17 -2.58 L 341.0 200.0 L 341.0 193.48 c 0.0 -1.12 -0.04 -1.97 -0.17 -2.58 c -0.12 -0.62 -0.31 -0.99 -0.58 -1.24 C 339.72 189.16 338.6 189.0 336.5 189.0 Z M 328.38 190.07 c 2.73 -0.0 5.46 0.01 8.2 0.03 c 0.86 0.05 1.77 -0.08 2.61 0.17 c 0.57 0.1 0.63 0.77 0.68 1.23 c 0.1 5.12 0.07 10.27 0.04 15.39 c -0.07 0.88 0.14 1.86 -0.33 2.66 c -0.52 0.38 -1.22 0.31 -1.83 0.39 c -3.79 0.08 -7.57 0.07 -11.36 0.01 c -0.64 -0.07 -1.38 -0.0 -1.93 -0.4 c -0.51 -0.8 -0.31 -1.8 -0.38 -2.7 c -0.04 -5.06 -0.07 -10.16 0.03 -15.22 c 0.08 -0.48 0.1 -1.2 0.68 -1.35 c 1.18 -0.31 2.39 -0.15 3.59 -0.21 Z")
            )
        }.build()

        return _Synaptic!!
    }

@Suppress("ObjectPropertyName")
private var _Synaptic: ImageVector? = null
