package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.isHighContrast

/** Type of a window control button. */
enum class YaruWindowControlType { Close, Maximize, Restore, Minimize }

/** Style preset of a window control. */
enum class YaruWindowControlPlatform { Yaru, Windows }

// `kYaruWindowControlSize = 24.0` (yaru_window_control.dart:8).
private val YaruControlSize: Dp = 24.dp
// `kYaruWindowsWindowControlSize = 46.0` (yaru_window_control.dart:11), used as
// `SizedBox.square(dimension: kYaruWindowsWindowControlSize)` at L315–318, so
// the Windows control footprint is a 46×46 square.
private val WindowsControlSize: Dp = 46.dp
// Glyph canvas sizes (`_iconSize`, yaru_window_control.dart:266–273).
private val YaruIconSize: Dp = 8.dp
private val WindowsIconSize: Dp = 10.dp

// Mirrors `_kWindowControlIconStrokeWidth` (1.0) from yaru.dart. Expressed as Dp
// so the DrawScope can convert to pixels via `toPx()` — using a raw `1f` here
// would render a single physical pixel regardless of density (a half-thickness
// stroke at 2x), defeating the logical-pixel intent of the upstream constant.
private val WindowControlStrokeWidth: Dp = 1.dp

// Background fade duration `_kWindowControlBackgroundAnimationDuration`.
private const val BackgroundAnimationMs: Int = 150

// Maximize <-> Restore glyph morph duration `_kWindowControlIconAnimationDuration`.
private const val IconAnimationMs: Int = 750

// Windows close-button hover red (`closeButtonHoverBackgroundColor`).
private val WindowsCloseHoverRed: Color = Color(0xFFE81123)

/**
 * A close / maximize / restore / minimize window control button.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_window_control.dart`. The glyph is
 * drawn with [Canvas] at a 1px stroke (square caps), and the maximize <-> restore
 * morph is animated linearly over 750ms.
 */
// Parity divergence vs `yaru_window_control.dart:84-92`: Dart treats `platform =
// null` as "auto-detect via `Platform.isWindows`". Compose Multiplatform has no
// equivalent ambient `Platform` API in commonMain, and our callers in
// `YaruTitleBar.kt` always pass an explicit value, so we deliberately default to
// `Yaru` rather than introducing an `expect/actual` platform probe.
@Composable
fun YaruWindowControl(
    type: YaruWindowControlType,
    onTap: (() -> Unit)?,
    modifier: Modifier = Modifier,
    platform: YaruWindowControlPlatform = YaruWindowControlPlatform.Yaru,
    iconColor: Color? = null,
    backgroundColor: Color? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val interactive = onTap != null

    val interactionSource = remember { MutableInteractionSource() }
    val rawHovered by interactionSource.collectIsHoveredAsState()
    val rawPressed by interactionSource.collectIsPressedAsState()
    // Defensive: when onTap flips null mid-hover/press the clickable modifier is removed without emitting Hover.Exit/Press.Release, leaving the source latched — gate on `interactive` so disabled controls don't render stale hover/press backgrounds.
    val hovered = rawHovered && interactive
    val pressed = rawPressed && interactive

    val iconSize = when (platform) {
        YaruWindowControlPlatform.Yaru -> YaruIconSize
        YaruWindowControlPlatform.Windows -> WindowsIconSize
    }
    val shape: Shape = when (platform) {
        YaruWindowControlPlatform.Yaru -> CircleShape
        YaruWindowControlPlatform.Windows -> RectangleShape
    }

    val resolvedBackground = sanitiseColor(
        backgroundColor ?: defaultBackground(
            scheme = scheme,
            platform = platform,
            type = type,
            interactive = interactive,
            hovered = hovered,
            active = pressed,
        ),
    )
    // Curves.linear / 150 ms (`_kWindowControlBackgroundAnimationDuration`,
    // implicit `AnimatedContainer.curve`) from yaru_window_control.dart.
    val animatedBackground by animateColorAsState(
        targetValue = resolvedBackground,
        animationSpec = tween(durationMillis = BackgroundAnimationMs, easing = LinearEasing),
    )
    val resolvedIcon = sanitiseColor(
        resolveIconColor(
            scheme = scheme,
            platform = platform,
            type = type,
            interactive = interactive,
            hovered = hovered,
            override = iconColor,
        ),
    )

    // Maximize (0.0) <-> restore (1.0) glyph morph —
    // Curves.linear / 750 ms (`_kWindowControlIconAnimationDuration`,
    // `_kWindowControlAnimationCurve = Curves.linear`) from yaru_window_control.dart.
    val animationTarget = if (type == YaruWindowControlType.Maximize) 0f else 1f
    val rawAnimationProgress by animateFloatAsState(
        targetValue = animationTarget,
        animationSpec = tween(durationMillis = IconAnimationMs, easing = LinearEasing),
    )
    // Defensive: `animateFloatAsState` should stay within [0, 1] given a
    // 0->1 / 1->0 target, but a mid-flight target swap or a non-finite
    // intermediate value would feed the glyph painter NaN-laden geometry.
    val animationProgress = if (rawAnimationProgress.isFinite()) {
        rawAnimationProgress.coerceIn(0f, 1f)
    } else {
        animationTarget
    }

    val highContrast = scheme.isHighContrast
    val outlineVariant = scheme.outlineVariant

    val controlSize = when (platform) {
        YaruWindowControlPlatform.Yaru -> YaruControlSize
        YaruWindowControlPlatform.Windows -> WindowsControlSize
    }

    // Mirrors `BorderSide.strokeAlignOutside` (yaru_window_control.dart:295, 311):
    // the high-contrast outline lives entirely outside the colored shape. Compose
    // `Modifier.border` strokes inside, so we wrap the control in an outer 1 dp
    // ring and inset the colored content by 1 dp — equivalent to growing the
    // visual footprint by 1 dp per side, exactly like Flutter's outside stroke.
    val outerModifier = if (highContrast) {
        Modifier
            .border(width = 1.dp, color = outlineVariant, shape = shape)
            .padding(1.dp)
    } else {
        Modifier
    }

    Box(
        modifier = modifier.then(outerModifier),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(controlSize)
                .background(color = animatedBackground, shape = shape)
                .let {
                    if (onTap != null) {
                        it.clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            role = Role.Button,
                            onClick = onTap,
                        )
                    } else it
                },
            contentAlignment = Alignment.Center,
        ) {
            Canvas(modifier = Modifier.size(iconSize)) {
                drawWindowControlGlyph(
                    type = type,
                    platform = platform,
                    color = resolvedIcon,
                    progress = animationProgress,
                )
            }
        }
    }
}

/** Picks the background color matching the upstream `_getBackgoundColor`. */
private fun defaultBackground(
    scheme: YaruColorScheme,
    platform: YaruWindowControlPlatform,
    type: YaruWindowControlType,
    interactive: Boolean,
    hovered: Boolean,
    active: Boolean,
): Color = when (platform) {
    YaruWindowControlPlatform.Yaru -> {
        val onSurface = scheme.onSurface
        when {
            !interactive -> onSurface.copy(alpha = 0.05f)
            active -> onSurface.copy(alpha = 0.2f)
            hovered -> onSurface.copy(alpha = 0.15f)
            else -> onSurface.copy(alpha = 0.1f)
        }
    }
    YaruWindowControlPlatform.Windows -> {
        if (!interactive) {
            Color.Transparent
        } else if (type == YaruWindowControlType.Close) {
            val alpha = when {
                active -> 0.5f
                hovered -> 1f
                else -> 0f
            }
            WindowsCloseHoverRed.copy(alpha = alpha)
        } else {
            when {
                active -> scheme.onSurface.copy(alpha = 0.15f)
                hovered -> scheme.onSurface.copy(alpha = 0.1f)
                else -> Color.Transparent
            }
        }
    }
}

/** Picks the glyph color matching the upstream `_getIconColor`. */
private fun resolveIconColor(
    scheme: YaruColorScheme,
    platform: YaruWindowControlPlatform,
    type: YaruWindowControlType,
    interactive: Boolean,
    hovered: Boolean,
    override: Color?,
): Color {
    val base = override ?: scheme.onSurface
    val withWindowsClose =
        if (platform == YaruWindowControlPlatform.Windows &&
            interactive && hovered && type == YaruWindowControlType.Close
        ) {
            Color.White
        } else {
            base
        }
    // Mirrors Dart `_getIconColor`: `color.withValues(alpha: interactive ? 1.0 : 0.5)`.
    // `withValues` REPLACES the alpha channel — it does not multiply by the
    // existing alpha — so the disabled state is a flat 0.5 regardless of the
    // override color's incoming alpha.
    return withWindowsClose.copy(alpha = if (interactive) 1f else 0.5f)
}

/**
 * Draws the glyph using the same geometry as `_YaruWindowControlIconPainter`.
 *
 * Note: stroke alignment: in Flutter, paint.strokeWidth is centered on the
 * geometry; reproducing that here requires inset by half the stroke width.
 */
private fun DrawScope.drawWindowControlGlyph(
    type: YaruWindowControlType,
    platform: YaruWindowControlPlatform,
    color: Color,
    progress: Float,
) {
    // Guard against zero-sized canvases (e.g. parent imposes `Constraints(0, 0)`):
    // a negative-width rect would feed `saveLayer` an invalid bounds and the
    // restore/maximize paths would build paths with negative coordinates.
    if (size.width <= 0f || size.height <= 0f) return
    // Defensive: convert the logical-pixel stroke width to physical pixels via the DrawScope's density — a raw `1f` would render half-thickness at 2x.
    val strokeWidth = WindowControlStrokeWidth.toPx()
    val strokeAlign = strokeWidth / 2f
    val rect = Rect(
        left = strokeAlign,
        top = strokeAlign,
        right = (size.width - strokeAlign).coerceAtLeast(strokeAlign),
        bottom = (size.height - strokeAlign).coerceAtLeast(strokeAlign),
    )
    val basePaint = Stroke(width = strokeWidth, cap = StrokeCap.Square)

    when (type) {
        YaruWindowControlType.Close -> {
            drawLine(color, Offset(rect.left, rect.top), Offset(rect.right, rect.bottom),
                strokeWidth = strokeWidth, cap = StrokeCap.Square)
            drawLine(color, Offset(rect.right, rect.top), Offset(rect.left, rect.bottom),
                strokeWidth = strokeWidth, cap = StrokeCap.Square)
        }
        YaruWindowControlType.Minimize -> when (platform) {
            YaruWindowControlPlatform.Yaru -> {
                // Defensive: the `-1` inset is a logical-pixel offset — convert via `toPx()` so the line stays 1dp above the bottom at every density.
                val onePx = 1.dp.toPx()
                drawLine(
                    color = color,
                    start = Offset(rect.left, rect.bottom - onePx),
                    end = Offset(rect.right, rect.bottom - onePx),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Square,
                )
            }
            YaruWindowControlPlatform.Windows -> {
                // Defensive: `-0.5` is a half-logical-pixel inset; route through `toPx()` so the centerline math respects density.
                val halfPx = 0.5.dp.toPx()
                val centerY = (rect.top + rect.bottom) / 2f - halfPx
                drawLine(
                    color = color,
                    start = Offset(rect.left, centerY),
                    end = Offset(rect.right, centerY),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Square,
                )
            }
        }
        YaruWindowControlType.Maximize, YaruWindowControlType.Restore -> when (platform) {
            YaruWindowControlPlatform.Yaru -> drawYaruRestoreMaximize(rect, color, progress, basePaint, strokeWidth)
            YaruWindowControlPlatform.Windows -> drawWindowsRestoreMaximize(rect, color, progress, basePaint, strokeWidth)
        }
    }
}

private fun DrawScope.drawYaruRestoreMaximize(
    drawRect: Rect,
    iconColor: Color,
    progress: Float,
    paint: Stroke,
    // Defensive: stroke width is supplied in physical px from the caller's density-aware `toPx()` so children don't double-convert; geometry below mirrors the same convention.
    strokeWidthPx: Float,
) {
    // Defensive: `gap` mirrors Dart's `_kWindowControlIconStrokeWidth + 1` — express the `+ 1` as a logical px via `toPx()` so the gap scales with density.
    val gap = strokeWidthPx + 1.dp.toPx()
    val step1Progress = (progress * 2f).coerceIn(0f, 1f)
    val rect = Rect(
        left = drawRect.left,
        top = drawRect.top + gap * step1Progress,
        right = drawRect.right - gap * step1Progress,
        bottom = drawRect.bottom,
    )
    // Defensive: a sub-icon-sized canvas could collapse the rect (right < left
    // or bottom < top), feeding `drawRect` a negative `Size` that Skia rejects.
    val rectW = (rect.right - rect.left).coerceAtLeast(0f)
    val rectH = (rect.bottom - rect.top).coerceAtLeast(0f)
    drawRect(
        color = iconColor,
        topLeft = Offset(rect.left, rect.top),
        size = androidx.compose.ui.geometry.Size(rectW, rectH),
        style = paint,
    )

    if (progress >= 0.5f) {
        val step2Progress = (progress - 0.5f) * 2f
        // Fading-in second rectangle outline; alpha goes from 0 to 0.5.
        val fadedAlpha = (-1f + 0.5f * step2Progress).coerceIn(-1f, 0f)
        val pathColor = iconColor.copy(alpha = (iconColor.alpha + iconColor.alpha * fadedAlpha).coerceIn(0f, 1f))
        // Defensive: the `1 + strokeWidth/2` corner inset is a logical-pixel value — convert the literal `1` via `toPx()`.
        val cornerInset = 1.dp.toPx() + strokeWidthPx / 2f
        val path = Path().apply {
            moveTo(drawRect.left + cornerInset, drawRect.top)
            lineTo(drawRect.right, drawRect.top)
            lineTo(drawRect.right, drawRect.bottom - cornerInset)
        }
        drawPath(path = path, color = pathColor, style = paint)
    }
}

private fun DrawScope.drawWindowsRestoreMaximize(
    drawRect: Rect,
    iconColor: Color,
    progress: Float,
    paint: Stroke,
    // Defensive: stroke width arrives as physical px from the caller's density-aware `toPx()`; mirrors the Yaru variant for parity.
    strokeWidthPx: Float,
) {
    // Defensive: same gap convention as `drawYaruRestoreMaximize` — convert the `+ 1` literal through `toPx()` so the gap respects density.
    val gap = strokeWidthPx + 1.dp.toPx()
    val step1Progress = (progress * 2f).coerceIn(0f, 1f)
    val rect1 = Rect(
        left = drawRect.left,
        top = drawRect.top + gap * step1Progress,
        right = drawRect.right - gap * step1Progress,
        bottom = drawRect.bottom,
    )

    if (progress >= 0.5f) {
        val step2Progress = (progress - 0.5f) * 2f
        val rect2 = Rect(
            left = drawRect.left + gap,
            top = drawRect.top,
            right = drawRect.right,
            bottom = drawRect.bottom - gap,
        )
        // Composite layer used to subtract `rect1` from `rect2` (mirrors `BlendMode.dstOut`).
        val fadedAlpha = (-1f + step2Progress).coerceIn(-1f, 0f)
        val rect2Color = iconColor.copy(alpha = (iconColor.alpha + iconColor.alpha * fadedAlpha).coerceIn(0f, 1f))
        // Defensive: clamp non-negative if the canvas is smaller than `gap`.
        val rect2W = (rect2.right - rect2.left).coerceAtLeast(0f)
        val rect2H = (rect2.bottom - rect2.top).coerceAtLeast(0f)
        drawIntoCanvas { canvas ->
            val saveLayerPaint = androidx.compose.ui.graphics.Paint()
            canvas.saveLayer(
                Rect(0f, 0f, size.width, size.height),
                saveLayerPaint,
            )
            try {
                drawRect(
                    color = rect2Color,
                    topLeft = Offset(rect2.left, rect2.top),
                    size = androidx.compose.ui.geometry.Size(rect2W, rect2H),
                    style = paint,
                )
                val cutoutPaint = androidx.compose.ui.graphics.Paint().apply {
                    blendMode = BlendMode.DstOut
                    color = Color.Black
                }
                canvas.drawRect(
                    left = rect1.left,
                    top = rect1.top,
                    right = rect1.right,
                    bottom = rect1.bottom,
                    paint = cutoutPaint,
                )
            } finally {
                // Pair `saveLayer` with `restore` even on failure — an
                // unbalanced layer would leak into subsequent draws.
                canvas.restore()
            }
        }
    }

    // Defensive: clamp non-negative if the canvas is smaller than `gap`.
    val rect1W = (rect1.right - rect1.left).coerceAtLeast(0f)
    val rect1H = (rect1.bottom - rect1.top).coerceAtLeast(0f)
    drawRect(
        color = iconColor,
        topLeft = Offset(rect1.left, rect1.top),
        size = androidx.compose.ui.geometry.Size(rect1W, rect1H),
        style = paint,
    )
}
