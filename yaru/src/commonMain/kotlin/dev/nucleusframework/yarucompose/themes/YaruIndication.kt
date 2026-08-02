package dev.nucleusframework.yarucompose.themes

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.invalidateDraw
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import kotlinx.coroutines.launch

/**
 * Yaru-flavored [Indication] — replaces the stock ripple (`splashFactory:
 * NoSplash.splashFactory` in `yaru.dart/lib/src/themes/common_themes.dart`)
 * with a flat state-layer overlay.
 *
 * yaru.dart does not expose a single global indication alpha — different
 * components in `common_themes.dart` apply their own state-specific values
 * (e.g. IconButton/ToggleButtons `hoverColor: onSurface @ 0.05`, RadioButton
 * `overlayColor: onSurface @ 0.05`, TabBar `overlayColor: onSurface @ 0.05`).
 * Components that mirror those exact values (YaruTabBar, YaruWindowControl)
 * paint their overlay manually and do not consume this indication.
 *
 * For the generic fall-through case we use the common desktop state-layer
 * defaults (`onSurfaceVariant @ 0.08` for hover/focus, `0.12` for press) —
 * close to Yaru's flat-overlay feel without per-component overrides:
 *
 *  - hovered:  `onSurfaceVariant @ 0.08`
 *  - focused:  `onSurfaceVariant @ 0.08`
 *  - pressed:  `onSurfaceVariant @ 0.12`
 *
 * Use via `LocalIndication provides YaruIndication(LocalYaruColorScheme.current.onSurfaceVariant)`
 * inside [YaruTheme].
 */
class YaruIndication(private val baseColor: Color) : IndicationNodeFactory {

    override fun create(interactionSource: InteractionSource): DelegatableNode =
        YaruIndicationNode(interactionSource, baseColor)

    override fun equals(other: Any?): Boolean =
        other is YaruIndication && other.baseColor == baseColor

    override fun hashCode(): Int = baseColor.hashCode()
}

private class YaruIndicationNode(
    private val interactionSource: InteractionSource,
    private val baseColor: Color,
) : Modifier.Node(), DrawModifierNode {

    // Counters rather than booleans: consecutive Enter/Exit / multiple pointers
    // arrive in the same flow and need to balance out properly.
    private var hoverCount = 0
    private var focusCount = 0
    private var pressCount = 0

    override fun onAttach() {
        // Reset counters defensively in case the node is reused after detach.
        hoverCount = 0
        focusCount = 0
        pressCount = 0
        coroutineScope.launch {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is HoverInteraction.Enter -> hoverCount++
                    is HoverInteraction.Exit -> hoverCount = (hoverCount - 1).coerceAtLeast(0)
                    is FocusInteraction.Focus -> focusCount++
                    is FocusInteraction.Unfocus -> focusCount = (focusCount - 1).coerceAtLeast(0)
                    is PressInteraction.Press -> pressCount++
                    is PressInteraction.Release,
                    is PressInteraction.Cancel -> pressCount = (pressCount - 1).coerceAtLeast(0)
                    is DragInteraction.Start -> pressCount++
                    is DragInteraction.Stop,
                    is DragInteraction.Cancel -> pressCount = (pressCount - 1).coerceAtLeast(0)
                }
                invalidateDraw()
            }
        }
    }

    override fun onDetach() {
        // The collect coroutine is cancelled automatically when the node detaches
        // (coroutineScope is tied to the node lifecycle), but reset state so a
        // subsequent onAttach() never observes stale interaction counts.
        hoverCount = 0
        focusCount = 0
        pressCount = 0
    }

    override fun ContentDrawScope.draw() {
        drawContent()
        val alpha = when {
            pressCount > 0 -> 0.12f
            hoverCount > 0 || focusCount > 0 -> 0.08f
            else -> 0f
        }
        if (alpha > 0f) {
            // Defensive: a parent scheme may supply Color.Unspecified or NaN channels for onSurfaceVariant; .copy(alpha=...) on those keeps NaN RGB and crashes drawRect.
            drawRect(color = sanitiseColor(baseColor).copy(alpha = alpha), size = size)
        }
    }
}
