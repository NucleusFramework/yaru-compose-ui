package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants

/** Where the expand button sits relative to the header. */
enum class YaruExpandableButtonPosition { Start, End }

private const val AnimationDurationMs = 250

// Mirrors `yaru_expandable.dart:102` — `YaruIconButton(iconSize: 36, padding: zero)`.
// In the Dart layer, `iconSize` is the button's `fixedSize` (the hit target), NOT
// the glyph size. The glyph itself inherits the IconButtonTheme `iconSize` set in
// `common_themes.dart:152` to `kYaruIconSize` (= 20).
private val ChevronHitTargetSize: Dp = 36.dp
private val ChevronGlyphSize: Dp = YaruConstants.IconSize // 20.dp

/**
 * A vertically expandable section with an animated header chevron.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_expandable.dart`:
 *  - chevron is a [YaruIconButton] with a 36 dp hit target (Dart `iconSize: 36`
 *    → `fixedSize`) wrapping a 20 dp glyph (theme override
 *    `IconButtonTheme.iconSize = kYaruIconSize` from `common_themes.dart:152`),
 *    rotated 0 -> 90° using `Curves.easeInOutCubic` over 250ms.
 *  - tapping anywhere on the header row toggles the expanded state.
 *  - on toggle the body cross-fades + size-animates between [content] and
 *    [collapsedContent] (empty when null), matching `AnimatedCrossFade`.
 */
@Composable
fun YaruExpandable(
    header: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onChange: ((Boolean) -> Unit)? = null,
    expandIcon: @Composable () -> Unit = { YaruIcon(YaruIcons.pan_end, size = ChevronGlyphSize) },
    expandIconPadding: PaddingValues = PaddingValues(0.dp),
    // Mirrors Dart `expandIconSemanticLabel` (yaru_expandable.dart:23). Forwarded
    // to the chevron's [YaruIconButton] via Compose's `Modifier.semantics`.
    expandIconSemanticLabel: String? = null,
    expandButtonPosition: YaruExpandableButtonPosition = YaruExpandableButtonPosition.End,
    gapHeight: Dp = 4.dp,
    // Mirrors `yaru_expandable.dart` `usePadding`: when true, the gap between
    // header and content is rendered as a `Modifier.padding(top = gapHeight)`
    // around the child rather than a leading `Spacer` inside a `Column`.
    // See https://github.com/ubuntu/yaru.dart/issues/1024.
    usePadding: Boolean = false,
    // Defensive: expose the screen-reader state announcements as caller-overridable strings so consumers can localize them; English defaults match the Compose Foundation convention.
    expandedStateDescription: String = "Expanded",
    collapsedStateDescription: String = "Collapsed",
    collapsedContent: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    var internalExpanded by remember(isExpanded) { mutableStateOf(isExpanded) }
    // Defensive: when `onChange` is provided the widget is controlled — read `isExpanded` directly and ignore the internal state so a caller that intercepts onChange (e.g. shows a confirm dialog, debounces, or rejects the toggle) cannot drift from what's painted. The internal state only drives the uncontrolled mode where the caller does not subscribe.
    val isExpandedState = if (onChange != null) isExpanded else internalExpanded
    // Curves.easeInOutCubic / 250 ms (`_kAnimationCurve`, `_kAnimationDuration`)
    // from yaru_expandable.dart.
    val rotation by animateFloatAsState(
        targetValue = if (isExpandedState) 90f else 0f,
        animationSpec = tween(AnimationDurationMs, easing = YaruEasing.EaseInOutCubic),
    )
    val onTap: () -> Unit = {
        // Defensive: in controlled mode the caller owns the next value — only emit onChange and skip the local mutation that would otherwise shadow the caller's source of truth.
        if (onChange != null) {
            onChange(!isExpanded)
        } else {
            internalExpanded = !internalExpanded
        }
    }

    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val rowInteraction = remember { MutableInteractionSource() }

    // Defensive: `Modifier.padding(PaddingValues)` throws if any edge resolves
    // to a negative `Dp`. Per-edge clamp before forwarding to the chevron box.
    val layoutDirection = LocalLayoutDirection.current
    val safeExpandIconPadding = expandIconPadding.coerceNonNegative(layoutDirection)

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                // Mirrors `GestureDetector(behavior: HitTestBehavior.opaque)` in
                // yaru.dart — the whole row is the tap target. `indication = null`
                // keeps the chevron's own ripple as the only visual feedback.
                .clickable(
                    interactionSource = rowInteraction,
                    indication = null,
                    role = Role.Button,
                    onClick = onTap,
                )
                // Defensive: announce expand/collapse state via stateDescription so screen readers describe whether the section is open (commonMain Compose has no `Semantics.expanded` property; the Android-only `expanded` extension lives in ui-semantics-android). Strings sourced from caller-overridable params for localization.
                .semantics { stateDescription = if (isExpandedState) expandedStateDescription else collapsedStateDescription },
            horizontalArrangement = when (expandButtonPosition) {
                YaruExpandableButtonPosition.Start -> Arrangement.Start
                YaruExpandableButtonPosition.End -> Arrangement.SpaceBetween
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val iconButton: @Composable () -> Unit = {
                val iconBoxModifier = Modifier
                    .padding(safeExpandIconPadding)
                    .let { m ->
                        if (expandIconSemanticLabel != null) {
                            m.semantics { contentDescription = expandIconSemanticLabel }
                        } else {
                            m
                        }
                    }
                Box(modifier = iconBoxModifier) {
                    YaruIconButton(
                        onPressed = onTap,
                        // 36 dp = button hit target (Dart `fixedSize`), see
                        // `yaru_expandable.dart:102` + `yaru_icon_button.dart:48`.
                        iconSize = ChevronHitTargetSize,
                        icon = {
                            // Constrain rotation to a square 20 dp box so the
                            // pivot lands on the glyph's visual center.
                            // Without this, `Modifier.rotate` pivots around
                            // the BasicText metrics box (e.g. ~13 dp wide ×
                            // ~24 dp tall for `pan_end`), which shifts the
                            // glyph off the button center as it rotates.
                            // Mirrors Dart's `Icon` which always paints inside
                            // an `IconTheme.size × size` square.
                            // Defensive: directional chevron glyphs (`pan_end` etc.) are rendered as plain text and do not auto-mirror — apply `scaleX = -1` under RTL so the collapsed glyph points toward the visual start (left in Arabic/Hebrew).
                            val chevronScaleX = if (LocalLayoutDirection.current == LayoutDirection.Rtl) -1f else 1f
                            Box(
                                modifier = Modifier
                                    .size(ChevronGlyphSize)
                                    .scale(scaleX = chevronScaleX, scaleY = 1f)
                                    .rotate(rotation),
                                contentAlignment = Alignment.Center,
                            ) {
                                expandIcon()
                            }
                        },
                    )
                }
            }
            // `Flexible` in Flutter == `weight(1f, fill = false)` in Compose:
            // the header keeps its intrinsic width but may shrink to fit.
            val headerCell: @Composable () -> Unit = {
                Box(modifier = Modifier.weight(1f, fill = false)) {
                    header()
                }
            }
            when (expandButtonPosition) {
                YaruExpandableButtonPosition.Start -> {
                    iconButton()
                    headerCell()
                }
                YaruExpandableButtonPosition.End -> {
                    headerCell()
                    iconButton()
                }
            }
        }
        // `AnimatedCrossFade` between `child` (firstChild) and
        // `collapsedChild ?? Container()` (secondChild). Defaults from Flutter:
        //   firstCurve / secondCurve = Curves.linear
        //   sizeCurve = `_kAnimationCurve` (Curves.easeInOutCubic)
        //   duration = `_kAnimationDuration` (250 ms)
        // from yaru_expandable.dart.
        AnimatedContent(
            targetState = isExpandedState,
            transitionSpec = {
                // Mirrors Flutter's `AnimatedCrossFade`: a synchronized linear
                // cross-fade with a separately-curved size animation.
                // `AnimatedCrossFade.clipBehavior` defaults to `Clip.hardEdge`,
                // so the in-flight content is clipped to the animating size
                // (otherwise the expanding child paints past the row before
                // the size catches up — this was the source of the perceived
                // "different animation" in the sample).
                (fadeIn(animationSpec = tween(AnimationDurationMs, easing = LinearEasing)) togetherWith
                    fadeOut(animationSpec = tween(AnimationDurationMs, easing = LinearEasing))).using(
                    SizeTransform(clip = true) { _, _ ->
                        tween(AnimationDurationMs, easing = YaruEasing.EaseInOutCubic)
                    },
                )
            },
            label = "YaruExpandable",
        ) { isOpen ->
            if (isOpen) {
                BodyChild(gapHeight = gapHeight, usePadding = usePadding, child = content)
            } else if (collapsedContent != null) {
                BodyChild(gapHeight = gapHeight, usePadding = usePadding, child = collapsedContent)
            } else {
                // Empty branch — matches Flutter's `Container()` secondChild.
                Spacer(Modifier.height(0.dp))
            }
        }
    }
}

/**
 * Mirrors `_buildChild` in `yaru_expandable.dart`.
 *  - `usePadding = false` (default): leading `SizedBox` of [gapHeight] inside a `Column`.
 *  - `usePadding = true`: a top padding of [gapHeight] around [child] (the Dart docs flag
 *    this as the future default behaviour, see issue #1024).
 */
@Composable
private fun BodyChild(
    gapHeight: Dp,
    usePadding: Boolean,
    child: @Composable () -> Unit,
) {
    // Defensive clamp via the canonical `Dp.sanitise()` foundation helper:
    // both `Modifier.padding(top = -1.dp)` and `Modifier.height(-1.dp)` throw
    // `IllegalArgumentException`, and a non-finite Dp would later blow up
    // `roundToPx()` → `Float.roundToInt()`.
    val safeGap = gapHeight.sanitise()
    if (usePadding) {
        Box(modifier = Modifier.padding(top = safeGap)) {
            child()
        }
    } else {
        Column {
            Spacer(Modifier.height(safeGap))
            child()
        }
    }
}

