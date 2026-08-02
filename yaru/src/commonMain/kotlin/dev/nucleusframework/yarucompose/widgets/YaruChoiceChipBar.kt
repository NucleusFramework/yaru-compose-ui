package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.success
import kotlinx.coroutines.launch

// `BorderRadius.circular(100)` — pill-shaped chip from
// yaru_choice_chip_bar.dart line 194 and the chip theme in
// common_themes.dart line 678 (`_createChipTheme`).
private val ChipPillRadius: Dp = 100.dp

// `_kAnimationDuration` — `Duration(milliseconds: 300)` from
// yaru_choice_chip_bar.dart line 13.
private const val CHIP_ANIMATION_DURATION_MILLIS: Int = 300

// `spacing` default — `10.0` from yaru_choice_chip_bar.dart line 12.
private val ChipDefaultSpacing: Dp = 10.dp

// `wrapRunSpacing` default — `10.0` from yaru_choice_chip_bar.dart line 20.
private val ChipDefaultRunSpacing: Dp = 10.dp

// `navigationStep` default — `100.0` from yaru_choice_chip_bar.dart line 14;
// in pixels (logical) consumed by `ScrollController.animateTo(±step)`.
private const val CHIP_NAVIGATION_STEP_PX: Float = 100f

// Defensive: Flutter's `_ChipDefaultsM3` uses `padding: horizontal(8)` (outer) + `labelPadding: horizontal(8)` (inner) = 16dp total horizontal inset around the label. Previously set to 12dp from the older defaults (`padding(4)` + `labelPadding.horizontal(8)`); Yaru's Dart `ChoiceChip` doesn't override them, so we need 16dp to match.
private val ChipHorizontalPadding: Dp = 16.dp

// Flutter's `Chip._kCheckmarkSize = 18.0` — Yaru replaces the icon glyph
// (`YaruIcons.ok`) but keeps the surrounding sizing close. We render slightly
// smaller (16dp) to suit Yaru's icon font, mirroring its compact metrics.
private val ChipCheckmarkSize: Dp = 16.dp

// Flutter's `Chip._kCheckmarkPadding = 4.0` — gap between the checkmark and
// the label (yaru_choice_chip_bar.dart inherits the default). We use 6dp
// to compensate for the Yaru `ok` glyph's tighter optical bounds.
private val ChipCheckmarkLabelGap: Dp = 6.dp

// Border / outline width for chips and nav buttons.
// `BorderSide(width: 1)` from common_themes.dart `_createChipTheme`
// (lines 666-677) and yaru_choice_chip_bar.dart line 343.
private val ChipBorderWidth: Dp = 1.dp

// Selected-chip fill alpha (non-HC):
// `selectedBackgroundColor.withValues(alpha: isHC ? 1 : 0.4)` —
// `selectedBackgroundColor = isHC ? inverseSurface : (elevatedButtonColor ?? primary)`.
// from common_themes.dart L651-653 + L659 + L788 (`selectedColor: elevatedButtonColor ?? primary`).
// Dart's `RawChip` paints this as the surface color directly over the
// parent surface — no implicit alpha-blend with `colorScheme.surface`.
private const val CHIP_SELECTED_BG_ALPHA_NON_HC: Float = 0.4f
private const val CHIP_SELECTED_BG_ALPHA_HC: Float = 1f

// Selected-chip border alpha:
// `selectedBackgroundColor.withValues(alpha: isHC ? 1 : 0.1)`
// from common_themes.dart L669.
private const val CHIP_SELECTED_BORDER_ALPHA_NON_HC: Float = 0.1f
private const val CHIP_SELECTED_BORDER_ALPHA_HC: Float = 1f

// Unselected-chip border alpha when the chip is disabled:
// `outline/outlineVariant.withValues(alpha: isDisabled ? (isHC ? 0.3 : 0.7) : 1)`
// from common_themes.dart L671-674.
private const val CHIP_DISABLED_BORDER_ALPHA_NON_HC: Float = 0.7f
private const val CHIP_DISABLED_BORDER_ALPHA_HC: Float = 0.3f

// Dart `_ChipDefaultsM3.overlayColor` — pressed `onSurface @ 0.12`,
// hovered `onSurface @ 0.08`. Yaru also sets a flat overlay of
// `onSurface @ 0.05` via `_createTabBarTheme.overlayColor`, but `Chip` keeps
// the framework defaults.
private const val CHIP_PRESSED_OVERLAY_ALPHA: Float = 0.12f
private const val CHIP_HOVERED_OVERLAY_ALPHA: Float = 0.08f

// The standard disabled foreground alpha (`_ChipDefaultsM3` derives
// `disabledColor = onSurface @ 0.38`).
private const val CHIP_DISABLED_FG_ALPHA: Float = 0.38f

// `SizedBox.square(dimension: chipHeight - 2)` — nav button is 2dp smaller
// than the bar to leave room for its border, see yaru_choice_chip_bar.dart
// line 348.
private val ChipNavButtonInset: Dp = 2.dp

/** Layout style of [YaruChoiceChipBar]. */
enum class YaruChoiceChipBarStyle {
    /** Horizontal scrolling row with edge navigation buttons in-line. */
    Row,

    /** Wraps to multiple lines when content overflows. */
    Wrap,

    /** Like [Row] but the navigation buttons float over the row's edges. */
    Stack,
}

/**
 * A list of [ChoiceChip]s arranged horizontally or wrapped on multiple lines.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_choice_chip_bar.dart`. The leading
 * tick mark is drawn from the Yaru icon font and only shown when [showCheckMarks]
 * is `true` and the chip is selected. The [Row] and [Stack] styles place the
 * chips inside a horizontally-scrolling lane with go-previous/go-next nav
 * buttons; [Stack] floats those buttons over the lane edges.
 */
@Composable
fun YaruChoiceChipBar(
    isSelected: List<Boolean>,
    onSelected: ((index: Int) -> Unit)?,
    label: @Composable (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    style: YaruChoiceChipBarStyle = YaruChoiceChipBarStyle.Row,
    spacing: Dp = ChipDefaultSpacing,
    runSpacing: Dp = ChipDefaultRunSpacing,
    chipHeight: Dp = YaruConstants.TitleBarItemHeight,
    showCheckMarks: Boolean = true,
    selectedFirst: Boolean = true,
    clearOnSelect: Boolean = true,
    // Mirrors Dart's `animationDuration` + `animationCurve` (defaults
    // `Duration(milliseconds: 300)` + `Curves.bounceIn`) — drives the
    // `animateScrollBy` call on go-previous / go-next nav button taps.
    // Defensive: we deliberately diverge from Dart's `Curves.bounceIn` default.
    // `bounceIn` is `1 - bounceOut(1 - t)`, a piecewise-parabolic curve that
    // stalls and micro-reverses near t=0; over a 100px scroll it reads as a
    // stutter rather than a bounce. `easeInOut` keeps the same 300ms budget
    // while scrolling smoothly. Callers wanting Dart parity can pass
    // `tween(300, easing = YaruEasing.BounceIn)` explicitly.
    scrollAnimation: AnimationSpec<Float> = tween(
        CHIP_ANIMATION_DURATION_MILLIS,
        easing = YaruEasing.EaseInOut,
    ),
) {
    val count = isSelected.size
    // Recompute ordering each composition; a snapshot list reference is stable
    // even when its contents mutate, so a `remember(isSelected)` would never
    // invalidate.
    val orderedIndices = if (selectedFirst) {
        // Defensive: `isSelected` may be a SnapshotStateList; read via `getOrNull` so a transient shrink during sort cannot throw.
        (0 until count).sortedByDescending { isSelected.getOrNull(it) == true }
    } else {
        (0 until count).toList()
    }

    // Defensive clamps: `Modifier.height` and `RoundedCornerShape` corner radii
    // throw `IllegalArgumentException` on negative `Dp`. Callers may forward
    // unvalidated theme tokens / computed sizes. Mirrors the YaruListTile /
    // YaruIconButton / YaruExpansionPanel pattern.
    //
    // `Arrangement.spacedBy(Dp)` invokes `roundToPx()` which blows up on
    // non-finite Dp (NaN / ±Infinity). NaN bypasses `coerceAtLeast` because
    // NaN comparisons return false. Mirrors the YaruDialog actions guard.
    val safeChipHeight = chipHeight.sanitise()
    val safeSpacing = spacing.sanitise()
    val safeRunSpacing = runSpacing.sanitise()

    when (style) {
        YaruChoiceChipBarStyle.Wrap -> WrapBar(
            modifier = modifier,
            orderedIndices = orderedIndices,
            isSelected = isSelected,
            onSelected = onSelected,
            label = label,
            chipHeight = safeChipHeight,
            spacing = safeSpacing,
            runSpacing = safeRunSpacing,
            showCheckMarks = showCheckMarks,
        )
        else -> ScrollableBar(
            modifier = modifier,
            stack = style == YaruChoiceChipBarStyle.Stack,
            orderedIndices = orderedIndices,
            isSelected = isSelected,
            onSelected = onSelected,
            label = label,
            chipHeight = safeChipHeight,
            spacing = safeSpacing,
            showCheckMarks = showCheckMarks,
            clearOnSelect = clearOnSelect,
            scrollAnimation = scrollAnimation,
        )
    }
}

@Composable
private fun WrapBar(
    modifier: Modifier,
    orderedIndices: List<Int>,
    isSelected: List<Boolean>,
    onSelected: ((Int) -> Unit)?,
    label: @Composable (Int) -> Unit,
    chipHeight: Dp,
    spacing: Dp,
    runSpacing: Dp,
    showCheckMarks: Boolean,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalArrangement = Arrangement.spacedBy(runSpacing),
    ) {
        orderedIndices.forEach { index ->
            // Defensive: `isSelected` is caller-supplied and may shrink between the snapshot used to build `orderedIndices` and this read.
            val selected = isSelected.getOrNull(index) ?: return@forEach
            // Defensive: key the chip by its underlying index so a `selectedFirst` reorder doesn't reuse position-N's `remember { MutableInteractionSource }` for whichever chip now sits at position N.
            key(index) {
                ChoiceChip(
                    index = index,
                    chipHeight = chipHeight,
                    selected = selected,
                    showCheckMarks = showCheckMarks,
                    onClick = onSelected?.let { { it(index) } },
                    label = label,
                )
            }
        }
    }
}

@Composable
private fun ScrollableBar(
    modifier: Modifier,
    stack: Boolean,
    orderedIndices: List<Int>,
    isSelected: List<Boolean>,
    onSelected: ((Int) -> Unit)?,
    label: @Composable (Int) -> Unit,
    chipHeight: Dp,
    spacing: Dp,
    showCheckMarks: Boolean,
    clearOnSelect: Boolean,
    scrollAnimation: AnimationSpec<Float>,
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    // Defensive: `canScrollBackward` / `canScrollForward` change on every
    // scroll frame. Reading them directly here would invalidate `ScrollableBar`
    // — and with it the whole `LazyRow` content lambda — 60 times a second,
    // which is what made nav-button scrolling stutter. `derivedStateOf` narrows
    // the subscription to the boolean flips.
    val canGoPrevious by remember(listState) { derivedStateOf { listState.canScrollBackward } }
    val canGoNext by remember(listState) { derivedStateOf { listState.canScrollForward } }

    if (clearOnSelect) {
        LaunchedEffect(isSelected.toList()) {
            if (listState.firstVisibleItemIndex != 0 || listState.firstVisibleItemScrollOffset != 0) {
                listState.animateScrollToItem(0)
            }
        }
    }

    val list: @Composable (Modifier, PaddingValues) -> Unit = { mod, contentPadding ->
        LazyRow(
            modifier = mod,
            state = listState,
            contentPadding = contentPadding,
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            itemsIndexed(
                items = orderedIndices,
                // Defensive: key by underlying chip index, not list position — without this, a `selectedFirst` reorder reuses position-0's interaction/focus state for whatever chip lands at position 0, causing ripple/focus to leak across chips.
                key = { _, index -> index },
            ) { _, index ->
                // Defensive: `LazyRow` invokes this lambda lazily; `isSelected` may shrink between the composition snapshot and this read.
                val selected = isSelected.getOrNull(index) ?: return@itemsIndexed
                ChoiceChip(
                    index = index,
                    chipHeight = chipHeight,
                    selected = selected,
                    showCheckMarks = showCheckMarks,
                    onClick = onSelected?.let { { it(index) } },
                    label = label,
                )
            }
        }
    }

    if (stack) {
        // Match Dart's `ClipRRect` whose corner radii toggle with whether the
        // nav buttons are visible (yaru_choice_chip_bar.dart L280-294).
        val laneShape = RoundedCornerShape(
            topStart = if (canGoPrevious) chipHeight else 0.dp,
            bottomStart = if (canGoPrevious) chipHeight else 0.dp,
            topEnd = if (canGoNext) chipHeight else 0.dp,
            bottomEnd = if (canGoNext) chipHeight else 0.dp,
        )
        // The nav buttons float over the lane, so the lane must reserve a gutter
        // for them — otherwise chips slide underneath and collide with the
        // arrows. The gutter is keyed on "does the content overflow at all"
        // (rather than on each button's own visibility) so it stays constant
        // while scrolling: toggling it per-button would shift the chips sideways
        // every time you reach an edge.
        val overflows = canGoPrevious || canGoNext
        val navSide = (chipHeight - ChipNavButtonInset).coerceAtLeast(0.dp)
        val laneGutter = if (overflows) navSide + spacing else 0.dp
        Box(
            modifier = modifier.height(chipHeight),
            contentAlignment = Alignment.Center,
        ) {
            list(
                Modifier.fillMaxHeight().clip(laneShape),
                PaddingValues(horizontal = laneGutter),
            )
            // Curves.bounceIn / 300 ms — `animationCurve` / `animationDuration`
            // defaults from yaru_choice_chip_bar.dart (lines 13, 15) drive the
            // nav buttons' `AnimatedOpacity`.
            val navFadeIn = fadeIn(
                animationSpec = tween(CHIP_ANIMATION_DURATION_MILLIS, easing = YaruEasing.BounceIn),
            )
            val navFadeOut = fadeOut(
                animationSpec = tween(CHIP_ANIMATION_DURATION_MILLIS, easing = YaruEasing.BounceIn),
            )
            AnimatedVisibility(
                visible = canGoPrevious,
                enter = navFadeIn,
                exit = navFadeOut,
                modifier = Modifier.align(Alignment.CenterStart),
            ) {
                NavigationButton(
                    chipHeight = chipHeight,
                    glyph = YaruIcons.go_previous,
                    opaque = true,
                    onTap = {
                        scope.launch { listState.animateScrollBy(-CHIP_NAVIGATION_STEP_PX, scrollAnimation) }
                    },
                )
            }
            AnimatedVisibility(
                visible = canGoNext,
                enter = navFadeIn,
                exit = navFadeOut,
                modifier = Modifier.align(Alignment.CenterEnd),
            ) {
                NavigationButton(
                    chipHeight = chipHeight,
                    glyph = YaruIcons.go_next,
                    opaque = true,
                    onTap = {
                        scope.launch { listState.animateScrollBy(CHIP_NAVIGATION_STEP_PX, scrollAnimation) }
                    },
                )
            }
        }
    } else {
        Row(
            modifier = modifier.height(chipHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NavigationButton(
                chipHeight = chipHeight,
                glyph = YaruIcons.go_previous,
                onTap = if (canGoPrevious) {
                    { scope.launch { listState.animateScrollBy(-CHIP_NAVIGATION_STEP_PX, scrollAnimation) } }
                } else null,
            )
            Spacer(Modifier.width(spacing))
            Box(modifier = Modifier.weight(1f)) { list(Modifier.fillMaxHeight(), PaddingValues(0.dp)) }
            Spacer(Modifier.width(spacing))
            NavigationButton(
                chipHeight = chipHeight,
                glyph = YaruIcons.go_next,
                onTap = if (canGoNext) {
                    { scope.launch { listState.animateScrollBy(CHIP_NAVIGATION_STEP_PX, scrollAnimation) } }
                } else null,
            )
        }
    }
}

@Composable
private fun ChoiceChip(
    index: Int,
    chipHeight: Dp,
    selected: Boolean,
    showCheckMarks: Boolean,
    onClick: (() -> Unit)?,
    label: @Composable (Int) -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val shape = RoundedCornerShape(ChipPillRadius)
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()
    val focused by rememberKeyboardFocusedState(interactionSource)
    val enabled = onClick != null
    val isHC = scheme.isHighContrast

    // `selectedBackgroundColor` from common_themes.dart L651-653:
    //   isHC ? inverseSurface : (elevatedButtonColor ?? primary).
    // yaru.dart/lib/src/themes/yaru.dart:7,12 sets `elevatedButtonColor = success` (green `0xFF0E8420`),
    // so the resolved chip selected color is GREEN regardless of the theme's primary accent.
    // Defensive: match Dart parity by reading `scheme.success` (Ubuntu green) instead of `scheme.primary` (variant accent). Without this, our chip would show the orange/blue/etc. variant accent while Dart consistently shows green.
    val selectedBackgroundColor = if (isHC) scheme.inverseSurface else scheme.success

    // Border colours from `_createChipTheme` (common_themes.dart L666-676):
    // selected   -> selectedBackgroundColor @ (isHC ? 1 : 0.1)
    // unselected -> (isHC ? outlineVariant : outline) @ (isDisabled ? (isHC ? 0.3 : 0.7) : 1)
    val borderColor = if (selected) {
        selectedBackgroundColor.copy(
            alpha = if (isHC) CHIP_SELECTED_BORDER_ALPHA_HC else CHIP_SELECTED_BORDER_ALPHA_NON_HC,
        )
    } else {
        val base = if (isHC) scheme.outlineVariant else scheme.outline
        val alpha = if (!enabled) {
            if (isHC) CHIP_DISABLED_BORDER_ALPHA_HC else CHIP_DISABLED_BORDER_ALPHA_NON_HC
        } else {
            1f
        }
        base.copy(alpha = alpha)
    }
    // Selected fill: `selectedBackgroundColor @ (isHC ? 1 : 0.4)`
    // from common_themes.dart L659. Unselected fill is transparent; press/hover
    // are drawn as a separate overlay layer on top so the selected base color
    // stays exact under pressure (matches the Dart `ChoiceChip` overlay
    // stacking — `_ChipDefaultsM3.overlayColor`).
    val backgroundColor = if (selected) {
        selectedBackgroundColor.copy(
            alpha = if (isHC) CHIP_SELECTED_BG_ALPHA_HC else CHIP_SELECTED_BG_ALPHA_NON_HC,
        )
    } else {
        Color.Transparent
    }
    // `_ChipDefaultsM3.overlayColor` — onSurface tinted, painted on top.
    val overlayColor = when {
        pressed -> scheme.onSurface.copy(alpha = CHIP_PRESSED_OVERLAY_ALPHA)
        hovered -> scheme.onSurface.copy(alpha = CHIP_HOVERED_OVERLAY_ALPHA)
        else -> Color.Transparent
    }

    val chip: @Composable () -> Unit = {
        // Mirrors Flutter's `SizedBox(height: chipHeight)` wrapping the row variant — chips render at the bar's full `chipHeight` (default 34dp). Use `defaultMinSize` (rather than tight `height`) so callers can still grow the chip via a label that exceeds the baseline (e.g. wrapped multi-line labels in `WrapBar`). Adding the stock `padding(vertical = 8)` here would push intrinsic height to ~36dp, which the parent `Row.height(chipHeight)` then clips internally — squeezing the label's 20dp line into 18dp and visibly cropping descenders. We omit that padding deliberately.
        Row(
            modifier = Modifier
                .defaultMinSize(minHeight = chipHeight)
                .clip(shape)
                .background(color = backgroundColor, shape = shape)
                .background(color = overlayColor, shape = shape)
                .border(width = ChipBorderWidth, color = borderColor, shape = shape)
                .let {
                    if (onClick != null) {
                        it
                            // Mirrors Flutter's `ChoiceChip.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click`).
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                role = Role.Button,
                                onClick = onClick,
                            )
                            // Defensive: announce selected state so screen readers describe whether the chip is chosen alongside its role.
                            .semantics { this.selected = selected }
                    } else it
                }
                .padding(horizontal = ChipHorizontalPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (selected && showCheckMarks) {
                // `YaruIcons.ok` — checkmark glyph used by Yaru's themed
                // `ChoiceChip` (Dart `_kCheckmarkSize` ≈ 18; we use 16
                // because the Yaru glyph fills its bounds more tightly).
                // `checkmarkColor: selectedForeGroundColor` from
                // common_themes.dart L661 — `onInverseSurface` in HC,
                // `onSurface` otherwise.
                val checkmarkColor = if (isHC) scheme.inverseOnSurface else scheme.onSurface
                YaruIcon(YaruIcons.ok, size = ChipCheckmarkSize, tint = checkmarkColor)
                Spacer(Modifier.width(ChipCheckmarkLabelGap))
            }
            if (selected) {
                // `secondaryLabelStyle` from common_themes.dart L662-665:
                //   color: selectedForeGroundColor (onInverseSurface in HC, else onSurface)
                //   fontWeight: isHC ? bold : normal
                val labelColor = if (isHC) scheme.inverseOnSurface else scheme.onSurface
                val labelStyle = LocalYaruTextStyle.current.copy(
                    color = labelColor,
                    fontWeight = if (isHC) FontWeight.Bold else FontWeight.Normal,
                )
                CompositionLocalProvider(
                    LocalYaruContentColor provides labelColor,
                    LocalYaruTextStyle provides labelStyle,
                ) {
                    label(index)
                }
            } else {
                // `labelStyle: textStyle.copyWith(color: onSurface)` — common_themes.dart L660.
                // Default Yaru text style already resolves to onSurface via LocalYaruContentColor.
                label(index)
            }
        }
    }

    if (onClick != null) {
        // Mirrors Dart `YaruFocusBorder.primary(borderStrokeAlign: BorderSide.strokeAlignInside, ...)`
        // from yaru_choice_chip_bar.dart line 193 — drawing the ring INSIDE the
        // chip bounds. Without `-1f` here, the default `strokeAlign = 3` reserves
        // 8dp of outer layout space, squeezing the chip from `chipHeight` (34dp)
        // down to 26dp inside its parent `Row.height(chipHeight)` lane.
        YaruFocusBorder(
            focused = focused,
            borderShape = shape,
            borderStrokeAlign = -1f,
        ) { chip() }
    } else {
        chip()
    }
}

@Composable
private fun NavigationButton(
    chipHeight: Dp,
    glyph: Char,
    onTap: (() -> Unit)?,
    // Stack style floats the button over the scrolling lane. Chips scroll
    // through the lane's content padding, so the button needs a solid fill —
    // otherwise the chips show through the arrow glyph.
    opaque: Boolean = false,
) {
    val scheme = LocalYaruColorScheme.current
    val borderColor = if (scheme.isHighContrast) scheme.outlineVariant else scheme.outline
    val fillColor = if (opaque) scheme.surface else Color.Transparent
    val enabled = onTap != null
    val tint = scheme.onSurface.copy(alpha = if (enabled) 1f else CHIP_DISABLED_FG_ALPHA)
    // `chipHeight` is already `coerceAtLeast(0.dp)` upstream, but subtracting
    // `ChipNavButtonInset` can still produce a negative value when the caller
    // passes a chipHeight smaller than the inset — `Modifier.size()` would
    // then crash. Clamp to keep the button at least 0dp.
    val side = (chipHeight - ChipNavButtonInset).coerceAtLeast(0.dp)
    // shared MutableInteractionSource — drives focus border, hover overlay, ripple
    val interactionSource = remember { MutableInteractionSource() }
    val focused by rememberKeyboardFocusedState(interactionSource)

    val button: @Composable () -> Unit = {
        Box(
            modifier = Modifier
                .size(side)
                .clip(CircleShape)
                .background(color = fillColor, shape = CircleShape)
                .border(width = ChipBorderWidth, color = borderColor, shape = CircleShape)
                .let {
                    if (onTap != null) {
                        it
                            // Mirrors Flutter's `IconButton.mouseCursor` default
                            // (`WidgetStateMouseCursor.clickable` →
                            // `SystemMouseCursors.click`).
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = androidx.compose.foundation.LocalIndication.current,
                                // Defensive: icon-only nav button must announce as `Role.Button` so screen readers don't treat it as a generic clickable region.
                                role = Role.Button,
                                onClick = onTap,
                            )
                    } else it
                },
            contentAlignment = Alignment.Center,
        ) {
            // Dart `_NavigationButton` (yaru_choice_chip_bar.dart:320-360)
            // wraps `Icon(YaruIcons.go_previous/go_next)` with no explicit
            // size, so the glyph inherits `IconTheme.size = kYaruIconSize`
            // (= 20) from `common_themes.dart:152`.
            // Defensive: directional `go_previous`/`go_next` glyphs do not auto-mirror — flip horizontally under RTL so each arrow points toward the visual scroll direction.
            val arrowScaleX = if (LocalLayoutDirection.current == LayoutDirection.Rtl) -1f else 1f
            Box(modifier = Modifier.scale(scaleX = arrowScaleX, scaleY = 1f)) {
                YaruIcon(glyph, size = YaruConstants.IconSize, tint = tint)
            }
        }
    }

    if (enabled) {
        // Draw focus ring inside the button's bounds so it doesn't reserve outer
        // layout space (see ChoiceChip note above for the same `strokeAlign = -1`
        // rationale).
        YaruFocusBorder(
            focused = focused,
            borderShape = CircleShape,
            borderStrokeAlign = -1f,
        ) { button() }
    } else {
        button()
    }
}

