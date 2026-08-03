package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isHighContrast

/** `kYaruWindowControlSize` from `yaru_window_control.dart`. */
private val WindowControlSize = 24.dp

/** The X occupies an 8dp square at the centre — `_iconSize` for the yaru style. */
private val CloseGlyphSize = 8.dp

/** `_kWindowControlIconStrokeWidth` — a 1 logical-pixel stroke. */
private val CloseGlyphStroke = 1.dp

/** `_kWindowControlBackgroundAnimationDuration`. */
private const val BackgroundAnimationMs = 150

/**
 * The circular close control GNOME puts on a headerbar — a grey disc with a
 * drawn X, used to dismiss a dialog or a window.
 *
 * Same button Nucleus draws for client-side-decorated windows
 * (`dev.nucleusframework.window.icons.linux.gnome.Close`: a 24dp disc, a 1px
 * round-capped X spanning the centre 8dp) and the same one yaru.dart builds in
 * `YaruWindowControl(type: close)` — so an in-window dialog title bar and the
 * real window chrome above it read as one widget.
 *
 * Colours come from the Yaru scheme rather than Nucleus' fixed greys, which is
 * what keeps the control correct under the dark and high-contrast themes:
 * `onSurface` at 0.1 / 0.15 / 0.2 for rest / hover / press and 0.05 when
 * disabled, per `_getYaruBackgroundColor`.
 *
 * On the JVM a [dev.nucleusframework.yarucompose.window.YaruDecoratedDialog]
 * gets the real native control from the windowing layer instead; this is the
 * Compose-drawn equivalent for every other target and for dialogs composed
 * inside the window.
 */
@Composable
fun YaruCloseButton(
    onPressed: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alignment: Alignment = Alignment.Center,
    tooltip: String? = null,
    semanticLabel: String? = null,
    // Overrides the drawn X. Left null the button paints the GNOME glyph.
    icon: (@Composable () -> Unit)? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()

    // `_getYaruBackgroundColor` — the disc is always visible, it only deepens
    // on hover and press.
    val targetBackground = when {
        !enabled -> scheme.onSurface.copy(alpha = 0.05f)
        pressed -> scheme.onSurface.copy(alpha = 0.2f)
        hovered -> scheme.onSurface.copy(alpha = 0.15f)
        else -> scheme.onSurface.copy(alpha = 0.1f)
    }
    val background by animateColorAsState(
        targetValue = targetBackground,
        animationSpec = tween(durationMillis = BackgroundAnimationMs),
        label = "yaru-close-button-background",
    )
    // `_getIconColor` fades the glyph to 50% when the control is inert.
    val glyphColor = scheme.onSurface.copy(alpha = if (enabled) 1f else 0.5f)
    // Screen readers get the caller's label, falling back to the hover hint.
    val accessibleLabel = semanticLabel?.takeIf { it.isNotBlank() }
        ?: tooltip?.takeIf { it.isNotBlank() }

    Box(modifier = modifier, contentAlignment = alignment) {
        Box(
            modifier = Modifier
                .size(WindowControlSize)
                .background(color = background, shape = CircleShape)
                // High contrast outlines the disc — `_buildYaruBoxDecoration`.
                .let {
                    if (scheme.isHighContrast) {
                        it.border(width = 1.dp, color = scheme.outlineVariant, shape = CircleShape)
                    } else {
                        it
                    }
                }
                .let { m -> if (accessibleLabel != null) m.semantics { contentDescription = accessibleLabel } else m }
                .let {
                    if (enabled) {
                        it
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                role = Role.Button,
                                onClick = onPressed,
                            )
                    } else {
                        it
                    }
                }
                .then(if (icon == null) Modifier.drawCloseGlyph(glyphColor) else Modifier),
            contentAlignment = Alignment.Center,
        ) {
            icon?.invoke()
        }
    }
}

/**
 * Paints the two diagonals of the X inside the centred [CloseGlyphSize] square
 * — `_drawClose` in `yaru_window_control.dart`.
 */
private fun Modifier.drawCloseGlyph(color: Color): Modifier = drawBehind {
    val glyph = CloseGlyphSize.toPx()
    val stroke = CloseGlyphStroke.toPx()
    // The stroke is centred on the path, so inset by half of it to keep the
    // glyph inside its 8dp box — Dart's `_kWindowControlIconStrokeAlign`.
    val left = (size.width - glyph) / 2f + stroke / 2f
    val top = (size.height - glyph) / 2f + stroke / 2f
    val right = left + glyph - stroke
    val bottom = top + glyph - stroke
    drawLine(
        color = color,
        start = Offset(left, top),
        end = Offset(right, bottom),
        strokeWidth = stroke,
        cap = StrokeCap.Square,
    )
    drawLine(
        color = color,
        start = Offset(right, top),
        end = Offset(left, bottom),
        strokeWidth = stroke,
        cap = StrokeCap.Square,
    )
}
