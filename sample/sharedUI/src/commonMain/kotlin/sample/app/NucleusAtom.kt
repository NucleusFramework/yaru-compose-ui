package sample.app

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private data class OrbitConfig(
    val rotateXDeg: Float,
    val rotateYDeg: Float,
    val ringColors: List<Color>,
    val electronColors: List<Color>,
    val glowColor: Color,
    val periodMs: Int,
    val initialAngleDeg: Float,
)

private fun radians(degrees: Float): Float = degrees * PI.toFloat() / 180f

/**
 * Nucleus Framework mark: three tilted orbits with a glowing nucleus, shared
 * with the compose-macos-26-ui sample.
 */
@Composable
fun NucleusAtom(
    modifier: Modifier = Modifier,
    atomSize: Dp = 200.dp,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val orbits = remember {
        listOf(
            OrbitConfig(
                rotateXDeg = -52f,
                rotateYDeg = 62f,
                ringColors = listOf(
                    Color(0xFF6366F1),
                    Color(0xFF8B5CF6),
                    Color(0xFFA855C8),
                    Color(0xFFC084D8),
                    Color(0xFFA855C8),
                    Color(0xFF8B5CF6),
                    Color(0xFF6366F1),
                ),
                electronColors = listOf(Color(0xFFE0D0FF), Color(0xFFB8A0E8), Color(0xFF9678D3)),
                glowColor = Color(0xFFA082DC),
                periodMs = 4000,
                initialAngleDeg = (0.5f / 4f) * 360f,
            ),
            OrbitConfig(
                rotateXDeg = 56f,
                rotateYDeg = 62f,
                ringColors = listOf(
                    Color(0xFF38BDF8),
                    Color(0xFF60A5FA),
                    Color(0xFF818CF8),
                    Color(0xFF60A5FA),
                    Color(0xFF38BDF8),
                ),
                electronColors = listOf(Color(0xFFD6EEFF), Color(0xFF7EC8F8), Color(0xFF56A0E0)),
                glowColor = Color(0xFF64B4F5),
                periodMs = 3200,
                initialAngleDeg = (1.2f / 3.2f) * 360f,
            ),
            OrbitConfig(
                rotateXDeg = 3f,
                rotateYDeg = 62f,
                ringColors = listOf(
                    Color(0xFFF97316),
                    Color(0xFFEF4444),
                    Color(0xFFE06080),
                    Color(0xFFEF4444),
                    Color(0xFFF97316),
                ),
                electronColors = listOf(Color(0xFFFFE0B0), Color(0xFFF5A050), Color(0xFFE88830)),
                glowColor = Color(0xFFF0A032),
                periodMs = 3800,
                initialAngleDeg = (2f / 3.8f) * 360f,
            ),
        )
    }

    val electronAngles = orbits.map { orbit ->
        infiniteTransition.animateFloat(
            initialValue = orbit.initialAngleDeg,
            targetValue = orbit.initialAngleDeg + 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(orbit.periodMs, easing = LinearEasing),
                repeatMode = RepeatMode.Restart,
            ),
        )
    }

    val nucleusPulse by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1400, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse,
        ),
    )

    Canvas(modifier = modifier.size(atomSize)) {
        val center = Offset(size.width / 2f, size.height / 2f)
        val scale = size.minDimension / 340f
        val orbitRadius = 140f * scale
        val ringStroke = 7.5f * scale
        val nucleusR = 18f * scale
        val electronR = 10f * scale

        fun orbitPoint3D(thetaDeg: Float, config: OrbitConfig): Triple<Float, Float, Float> {
            val t = radians(thetaDeg)
            val a = radians(config.rotateXDeg)
            val b = radians(config.rotateYDeg)
            val ct = cos(t)
            val st = sin(t)
            val ca = cos(a)
            val sa = sin(a)
            val cb = cos(b)
            val sb = sin(b)
            return Triple(
                (cb * ct + sb * sa * st) * orbitRadius,
                (ca * st) * orbitRadius,
                (-sb * ct + cb * sa * st) * orbitRadius,
            )
        }

        fun gradientColor(colors: List<Color>, fraction: Float): Color {
            val clamped = fraction.coerceIn(0f, 1f)
            val scaled = clamped * (colors.size - 1)
            val idx = scaled.toInt().coerceAtMost(colors.size - 2)
            return lerp(colors[idx], colors[idx + 1], scaled - idx)
        }

        val segments = 180

        // ── Back halves of the orbit rings (z < 0) ──
        for (orbit in orbits) {
            for (i in 0 until segments) {
                val (x1, y1, z1) = orbitPoint3D(i * 360f / segments, orbit)
                val (x2, y2, z2) = orbitPoint3D((i + 1) * 360f / segments, orbit)
                if ((z1 + z2) / 2f >= 0) continue
                drawLine(
                    color = gradientColor(orbit.ringColors, i.toFloat() / segments).copy(alpha = 0.35f),
                    start = Offset(center.x + x1, center.y + y1),
                    end = Offset(center.x + x2, center.y + y2),
                    strokeWidth = ringStroke,
                    cap = StrokeCap.Round,
                )
            }
        }

        // ── Electrons, split around the nucleus so the front ones draw last ──
        fun drawElectron(orbit: OrbitConfig, angle: Float, front: Boolean) {
            val (ex, ey, ez) = orbitPoint3D(angle, orbit)
            if ((ez >= 0) != front) return
            val depthAlpha = (0.4f + 0.6f * ((ez + orbitRadius) / (2f * orbitRadius))).coerceIn(0.4f, 1f)
            val eCenter = Offset(center.x + ex, center.y + ey)
            listOf(3.5f to 0.5f, 1.8f to 0.8f).forEach { (radiusFactor, alpha) ->
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(orbit.glowColor.copy(alpha = alpha * depthAlpha), Color.Transparent),
                        center = eCenter,
                        radius = electronR * radiusFactor,
                    ),
                    center = eCenter,
                    radius = electronR * radiusFactor,
                )
            }
            drawCircle(
                brush = Brush.radialGradient(
                    colors = orbit.electronColors.map { it.copy(alpha = depthAlpha) },
                    center = Offset(eCenter.x - electronR * 0.15f, eCenter.y - electronR * 0.15f),
                    radius = electronR,
                ),
                center = eCenter,
                radius = electronR,
            )
        }

        orbits.forEachIndexed { index, orbit ->
            drawElectron(orbit, electronAngles[index].value, front = false)
        }

        // ── Nucleus glow + body ──
        val glowScale = 1f + nucleusPulse * 0.35f
        listOf(
            Triple(120f, Color(0xFF1840B0), 0.10f + nucleusPulse * 0.08f),
            Triple(85f, Color(0xFF2850DC), 0.18f + nucleusPulse * 0.12f),
            Triple(60f, Color(0xFF3C78FF), 0.30f + nucleusPulse * 0.15f),
            Triple(42f, Color(0xFF5AA0FF), 0.50f + nucleusPulse * 0.18f),
            Triple(28f, Color(0xFF80C0FF), 0.70f + nucleusPulse * 0.2f),
            Triple(18f, Color(0xFFB0DFFF), 0.90f + nucleusPulse * 0.1f),
        ).forEach { (r, color, alpha) ->
            val radius = r * scale * glowScale
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(color.copy(alpha = alpha.coerceAtMost(1f)), Color.Transparent),
                    center = center,
                    radius = radius,
                ),
                center = center,
                radius = radius,
            )
        }
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFFFFFFFF),
                    Color(0xFFE8F4FF),
                    Color(0xFFC5E0FF),
                    Color(0xFF5BA3F5),
                    Color(0xFF2D6FD4),
                ),
                center = Offset(center.x - nucleusR * 0.2f, center.y - nucleusR * 0.22f),
                radius = nucleusR * 1.2f,
            ),
            center = center,
            radius = nucleusR,
        )

        // ── Front halves of the orbit rings (z >= 0) ──
        for (orbit in orbits) {
            for (i in 0 until segments) {
                val (x1, y1, z1) = orbitPoint3D(i * 360f / segments, orbit)
                val (x2, y2, z2) = orbitPoint3D((i + 1) * 360f / segments, orbit)
                if ((z1 + z2) / 2f < 0) continue
                drawLine(
                    color = gradientColor(orbit.ringColors, i.toFloat() / segments),
                    start = Offset(center.x + x1, center.y + y1),
                    end = Offset(center.x + x2, center.y + y2),
                    strokeWidth = ringStroke,
                    cap = StrokeCap.Round,
                )
            }
        }

        orbits.forEachIndexed { index, orbit ->
            drawElectron(orbit, electronAngles[index].value, front = true)
        }
    }
}
