package dev.nucleusframework.yarucompose.iconsextended.vector

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.unit.dp

val FormatTextUnderline: ImageVector
    get() {
        if (_FormatTextUnderline != null) {
            return _FormatTextUnderline!!
        }
        _FormatTextUnderline = ImageVector.Builder(
            name = "FormatTextUnderline",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 8f,
                pathData = addPathNodes("M 97.79 53.0 V 175.88 c 0.0 36.14 25.3 50.6 54.21 50.6 c 28.91 0.0 54.21 -21.68 54.21 -50.6 V 53.0 H 184.53 V 175.88 c 0.0 15.97 -16.56 28.91 -32.53 28.91 c -15.97 0.0 -33.46 -12.97 -32.53 -28.91 V 53.0 h -7.23 Z M 86.95 248.16 V 259.0 H 217.05 v -10.84 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                pathData = addPathNodes("M 334.0 65.0 L 334.0 87.67 C 334.0 94.33 338.67 97.0 344.0 97.0 c 5.33 0.0 10.0 -4.0 10.0 -9.33 L 354.0 65.0 h -4.0 L 350.0 87.67 C 350.0 90.61 346.95 93.0 344.0 93.0 c -2.95 0.0 -6.17 -2.39 -6.0 -5.33 L 338.0 65.0 h -1.33 Z M 332.0 101.0 v 2.0 h 24.0 v -2.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 327.0 192.0 v 9.33 c 0.0 3.33 2.33 4.67 5.0 4.67 c 2.67 0.0 5.0 -2.0 5.0 -4.67 L 337.0 192.0 h -2.0 v 9.33 c 0.0 1.47 -1.53 2.67 -3.0 2.67 c -1.47 0.0 -3.09 -1.2 -3.0 -2.67 L 329.0 192.0 h -0.67 Z M 326.0 207.0 v 1.0 h 12.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 325.0 239.0 v 3.0 v 1.0 v 1.0 c 0.0 1.66 1.34 3.0 3.0 3.0 c 1.66 0.0 3.0 -1.34 3.0 -3.0 v -1.0 v -1.0 v -3.0 h -1.0 v 2.0 v 2.0 v 1.0 c 0.0 1.11 -0.89 2.0 -2.0 2.0 c -1.11 0.0 -2.0 -0.89 -2.0 -2.0 v -1.0 v -2.0 v -2.0 Z M 324.0 248.0 v 1.0 h 8.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF151515),
                        1f to Color(0xFF4D4D4D)
                    ),
                    start = Offset(327.89f, 239f),
                    end = Offset(327.89f, 250f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 325.0 239.0 v 3.0 v 1.0 v 1.0 c 0.0 1.66 1.34 3.0 3.0 3.0 c 1.66 0.0 3.0 -1.34 3.0 -3.0 v -1.0 v -1.0 v -3.0 h -1.0 v 2.0 v 2.0 v 1.0 c 0.0 1.11 -0.89 2.0 -2.0 2.0 c -1.11 0.0 -2.0 -0.89 -2.0 -2.0 v -1.0 v -2.0 v -2.0 Z M 324.0 248.0 v 1.0 h 8.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 329.0 136.0 v 14.0 c 0.0 5.0 3.0 7.0 7.0 7.0 c 4.0 0.0 7.0 -3.0 7.0 -7.0 v -14.0 h -3.0 v 14.0 c 0.0 2.21 -1.79 4.0 -4.0 4.0 c -2.21 0.0 -4.13 -1.79 -4.0 -4.0 v -14.0 h -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.Black),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round,
                pathData = addPathNodes("m 327.0 159.0 v 1.0 h 18.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF151515),
                        1f to Color(0xFF4D4D4D)
                    ),
                    start = Offset(336f, 136f),
                    end = Offset(336f, 160f)
                ),
                pathData = addPathNodes("m 329.0 136.0 v 14.0 c 0.0 5.0 3.0 7.0 7.0 7.0 c 4.0 0.0 7.0 -3.0 7.0 -7.0 v -14.0 h -3.0 v 14.0 c 0.0 2.21 -1.79 4.0 -4.0 4.0 c -2.21 0.0 -4.13 -1.79 -4.0 -4.0 v -14.0 h -1.0 Z M 327.0 159.0 v 1.0 h 18.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF151515),
                        1f to Color(0xFF4D4D4D)
                    ),
                    start = Offset(332f, 192f),
                    end = Offset(332f, 208f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 327.0 192.0 v 9.33 c 0.0 3.33 2.33 4.67 5.0 4.67 c 2.67 0.0 5.0 -2.0 5.0 -4.67 L 337.0 192.0 h -2.0 v 9.33 c 0.0 1.47 -1.53 2.67 -3.0 2.67 c -1.47 0.0 -3.09 -1.2 -3.0 -2.67 L 329.0 192.0 h -0.67 Z M 326.0 207.0 v 1.0 h 12.0 v -1.0 Z")
            )
            addPath(
                fill = SolidColor(Color.White),
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                pathData = addPathNodes("m 370.0 193.0 v 9.33 c 0.0 3.33 2.33 4.67 5.0 4.67 c 2.67 0.0 5.0 -2.0 5.0 -4.67 L 380.0 193.0 h -2.0 v 9.33 c 0.0 1.47 -1.53 2.67 -3.0 2.67 c -1.47 0.0 -3.09 -1.2 -3.0 -2.67 L 372.0 193.0 h -0.67 Z M 369.0 208.0 v 1.0 h 12.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF151515),
                        1f to Color(0xFF4D4D4D)
                    ),
                    start = Offset(375f, 193f),
                    end = Offset(375f, 209f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 370.0 193.0 v 9.33 c 0.0 3.33 2.33 4.67 5.0 4.67 c 2.67 0.0 5.0 -2.0 5.0 -4.67 L 380.0 193.0 h -2.0 v 9.33 c 0.0 1.47 -1.53 2.67 -3.0 2.67 c -1.47 0.0 -3.09 -1.2 -3.0 -2.67 L 372.0 193.0 h -0.67 Z M 369.0 208.0 v 1.0 h 12.0 v -1.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF151515),
                        1f to Color(0xFF4D4D4D)
                    ),
                    start = Offset(344f, 69f),
                    end = Offset(344f, 101f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("M 334.0 65.0 L 334.0 87.67 C 334.0 94.33 338.67 97.0 344.0 97.0 c 5.33 0.0 10.0 -4.0 10.0 -9.33 L 354.0 65.0 h -4.0 L 350.0 87.67 C 350.0 90.61 346.95 93.0 344.0 93.0 c -2.95 0.0 -6.17 -2.39 -6.0 -5.33 L 338.0 65.0 h -1.33 Z M 332.0 101.0 v 2.0 h 24.0 v -2.0 Z")
            )
            addPath(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF151515),
                        1f to Color(0xFF4D4D4D)
                    ),
                    start = Offset(152f, 74.68f),
                    end = Offset(152f, 248.16f)
                ),
                strokeLineWidth = 1f,
                pathData = addPathNodes("m 97.79 53.0 v 122.88 c 0.0 36.14 25.3 50.6 54.21 50.6 c 28.91 0.0 54.21 -21.68 54.21 -50.6 V 53.0 h -21.68 v 122.88 c 0.0 15.97 -16.56 28.91 -32.53 28.91 c -15.97 0.0 -33.46 -12.97 -32.53 -28.91 V 53.0 h -7.23 Z M 86.95 248.16 V 259.0 H 217.05 v -10.84 Z")
            )
        }.build()

        return _FormatTextUnderline!!
    }

@Suppress("ObjectPropertyName")
private var _FormatTextUnderline: ImageVector? = null
