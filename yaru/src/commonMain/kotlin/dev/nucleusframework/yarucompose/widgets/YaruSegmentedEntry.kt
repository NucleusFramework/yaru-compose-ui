package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isShiftPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.utf16CodePoint
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEntrySegment
import dev.nucleusframework.yarucompose.foundation.YaruSegmentEventReturnAction
import dev.nucleusframework.yarucompose.foundation.YaruSegmentedEntryController
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isHighContrast
import dev.nucleusframework.yarucompose.themes.scale

/**
 * Multi-segment entry — each [YaruEntrySegment] is independently selectable
 * and editable from the keyboard. Tab / Shift+Tab / arrow / character /
 * backspace keys traverse and edit segments according to each segment's
 * logic.
 *
 * Mirrors `YaruSegmentedEntry` from
 * `yaru.dart/lib/src/widgets/yaru_segmented_entry.dart`. The decoration matches
 * [YaruTextField]:
 *  - radius: `kYaruButtonRadius` (8 dp)
 *  - border width unfocused: 1 dp / focused: `kYaruFocusBorderWidth` (2 dp)
 *  - filled background: `surface.scale(lightness = if light -0.05 else -0.1)`
 *
 * Each focused segment is highlighted with a `primary @ 0.25` background.
 */
@Composable
fun YaruSegmentedEntry(
    segments: List<YaruEntrySegment>,
    delimiters: List<String?>,
    modifier: Modifier = Modifier,
    controller: YaruSegmentedEntryController = remember(segments.size) {
        YaruSegmentedEntryController(length = segments.size)
    },
    contentPadding: PaddingValues = PaddingValues(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 9.dp),
    filled: Boolean = true,
    isError: Boolean = false,
    autofocus: Boolean = false,
    onChanged: ((String) -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
) {
    require(segments.isEmpty() && delimiters.isEmpty() ||
        delimiters.size == segments.size - 1) {
        "delimiters.size must equal segments.size - 1 (got ${delimiters.size} / ${segments.size})"
    }
    // A caller-supplied controller whose `length` doesn't match `segments.size`
    // would let `controller.index = N` succeed for indices outside the rendered
    // range (or reject valid ones), surfacing as confusing IndexOutOfBounds
    // crashes during click/key handling. Catch the mismatch up front.
    require(controller.length == segments.size) {
        "controller.length (${controller.length}) must equal segments.size (${segments.size})"
    }

    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current
    val isLight = !scheme.isDark
    val shape = RoundedCornerShape(YaruConstants.ButtonRadius)
    val fillColor = scheme.surface.scale(lightness = if (isLight) -0.05f else -0.1f)
    // Defensive clamp: `Modifier.padding` throws on negative `Dp`, and a
    // non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`. NaN bypasses
    // `coerceAtLeast` (NaN comparisons all return false), so reject non-finite
    // values explicitly via `isFinite()`. Mirrors YaruWatermark/YaruDialog.
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)

    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    var hasFocus by remember { mutableStateOf(false) }

    // Mirrors `_createInputDecorationTheme` (common_themes.dart L48-50):
    // high-contrast themes use `outlineVariant`, others use `outline`.
    val borderColor = when {
        isError -> scheme.error
        hasFocus -> scheme.primary
        scheme.isHighContrast -> scheme.outlineVariant
        else -> scheme.outline
    }
    val borderWidth = if (hasFocus) YaruConstants.FocusBorderWidth else 1.dp

    // Notify external `onChanged` and segment listeners — segment text/value is
    // already backed by `mutableStateOf`, so no version ticker is required for
    // recomposition.
    DisposableEffect(segments, onChanged) {
        if (onChanged == null) {
            return@DisposableEffect onDispose {}
        }
        val listener: () -> Unit = {
            onChanged(segments.joinToString(separator = "") { it.text })
        }
        segments.forEach { it.addListener(listener) }
        onDispose { segments.forEach { it.removeListener(listener) } }
    }

    // Keep onSelect bookkeeping in sync with the controller index — mirrors the
    // Dart `_controllerCallback` in `_YaruSegmentedEntryState`.
    DisposableEffect(controller, segments) {
        val listener: () -> Unit = {
            segments.forEach { it.onSelect(false) }
            segments.getOrNull(controller.index)?.onSelect(true)
        }
        controller.addListener(listener)
        listener()
        onDispose { controller.removeListener(listener) }
    }

    // Mirrors `_onKeyEvent` in `yaru_segmented_entry.dart` line 225-234:
    //   final ltr = Directionality.of(context) == TextDirection.ltr;
    //   final left  = (ltr ? shiftTab : tab) || arrowLeft;
    //   final right = (ltr ? tab : shiftTab) || arrowRight;
    // i.e. arrow-left always selects the *previous* segment in LTR and the
    // *next* segment in RTL — the mapping flips with text direction.
    val ltr = layoutDirection == LayoutDirection.Ltr
    val keyHandler = Modifier.onKeyEvent { event ->
        // Mirrors `_onKeyEvent` in `yaru_segmented_entry.dart` line 219-220:
        // accept both `KeyDownEvent` and `KeyRepeatEvent`. Compose folds
        // repeats into `KeyDown` on most backends but explicitly skipping
        // `KeyUp` keeps parity.
        if (event.type == KeyEventType.KeyUp) return@onKeyEvent false
        if (segments.isEmpty()) return@onKeyEvent false
        val segment = segments.getOrNull(controller.index) ?: return@onKeyEvent false
        // Mirrors Dart's `_onKeyEvent` switch (lines 259-273): each branch
        // returns `KeyEventResult.handled` / `ignored`. In Compose terms, we
        // return `true` to consume the event and `false` to let it bubble.
        // At a segment boundary, arrows / Tab return `false` so the parent
        // focus traversal (or external listeners) can react.
        when (event.key) {
            Key.Tab -> {
                if (event.isShiftPressed) controller.maybeSelectPreviousSegment()
                else controller.maybeSelectNextSegment()
            }
            Key.DirectionLeft -> {
                if (ltr) controller.maybeSelectPreviousSegment()
                else controller.maybeSelectNextSegment()
            }
            Key.DirectionRight -> {
                if (ltr) controller.maybeSelectNextSegment()
                else controller.maybeSelectPreviousSegment()
            }
            Key.DirectionUp -> handleAction(controller, segment.onUpArrowKey())
            Key.DirectionDown -> handleAction(controller, segment.onDownArrowKey())
            Key.Backspace -> handleAction(controller, segment.onBackspaceKey())
            else -> {
                val cp = event.utf16CodePoint
                // Reject control chars (< 0x20), unpaired surrogates
                // (0xD800..0xDFFF — `cp.toChar()` would yield a malformed
                // String), and DEL (0x7F). Supplementary code points
                // (> 0xFFFF) can't be represented as a single Char and are
                // dropped here too — the segment input layer is BMP-scoped.
                val isPrintableBmp = cp in 0x20..0xFFFF &&
                    cp !in 0xD800..0xDFFF &&
                    cp != 0x7F
                if (isPrintableBmp) {
                    handleAction(controller, segment.onInput(cp.toChar().toString()))
                } else false
            }
        }
    }

    if (autofocus) {
        // Guard against a race where the FocusRequester hasn't been attached
        // yet (or has already been detached due to an immediate dispose):
        // `requestFocus()` would throw `IllegalStateException` in that window.
        LaunchedEffect(focusRequester) {
            runCatching { focusRequester.requestFocus() }
        }
    }

    // Edge-of-segment focus traversal mirrors `_onFocusFromEdge` from the
    // Dart source (line 381-385): in LTR, focus from the previous node selects
    // the first segment; in RTL it selects the last. Compose-side, we let the
    // ambient layout direction drive that decision so external focus traversal
    // stays consistent with the visual order rendered above.
    val onFocusFromPrev: () -> Unit = {
        if (ltr) controller.selectFirstSegment() else controller.selectLastSegment()
    }
    val onFocusFromNext: () -> Unit = {
        if (ltr) controller.selectLastSegment() else controller.selectFirstSegment()
    }

    YaruEdgeFocusInterceptor(
        onFocusFromPreviousNode = onFocusFromPrev,
        onFocusFromNextNode = onFocusFromNext,
        modifier = modifier,
    ) {
        // Mirrors yaru.dart's `TextFormField`-based rendering: numeric segments
        // and delimiters always paint left-to-right because digits are LTR
        // (Unicode BiDi-class L). Forcing `LayoutDirection.Ltr` on the segment
        // Row keeps Day/Month/Year (or HH:mm) in the same visual order in RTL
        // contexts — matching the Dart sample, which renders the same digit
        // order regardless of `Directionality`.
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Row(
            modifier = Modifier
                // Mirrors Flutter `TextFormField`'s default sizing: in a bounded
                // parent (e.g. `SizedBox(width: 275)`), the field fills the
                // available cross-axis width. Without `fillMaxWidth()` the Row
                // would shrink to its content, leaving the entry visibly
                // narrower than the surrounding column.
                .fillMaxWidth()
                .background(
                    color = if (filled) fillColor else Color.Transparent,
                    shape = shape,
                )
                .border(width = borderWidth, color = borderColor, shape = shape)
                .focusRequester(focusRequester)
                .onFocusChanged { hasFocus = it.isFocused || it.hasFocus }
                .focusable(interactionSource = interactionSource)
                .then(keyHandler)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) { runCatching { focusRequester.requestFocus() } }
                // Mirrors yaru.dart's `TextFormField` rendering with the
                // `_createInputDecorationTheme` defaults: `isDense: true` plus
                // `contentPadding: EdgeInsets.only(left: 12, right: 12, bottom: 9, top: 10)`
                // produces a ~`kYaruButtonHeight` (34 dp) tall field. The
                // [YaruTextField] port enforces the same minHeight — without it
                // the segmented entry rendered ~28 dp tall, visibly shorter
                // than the rest of the Yaru text inputs.
                .defaultMinSize(minHeight = YaruConstants.ButtonHeight)
                .padding(safeContentPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val textStyle = typography.bodyMedium.copy(color = scheme.onSurface)
            val delimiterStyle = typography.bodyMedium.copy(color = scheme.onSurface)

            segments.forEachIndexed { index, segment ->
                val selected = hasFocus && index == controller.index
                Box(
                    modifier = Modifier
                        .background(
                            color = if (selected) {
                                scheme.primary.copy(alpha = 0.25f)
                            } else {
                                Color.Transparent
                            },
                        )
                        .clickable(
                            interactionSource = remember(index) { MutableInteractionSource() },
                            indication = null,
                        ) {
                            controller.index = index
                            runCatching { focusRequester.requestFocus() }
                        },
                ) {
                    // Route through YaruText so a misconfigured typography
                    // (negative fontSize/lineHeight) is sanitised; raw
                    // BasicText would crash paragraph layout.
                    YaruText(text = segment.text, style = textStyle)
                }
                val delimiter = delimiters.getOrNull(index)
                if (!delimiter.isNullOrEmpty()) {
                    YaruText(text = delimiter, style = delimiterStyle)
                }
            }
            // Mirrors Flutter's `InputDecorator` behaviour: the suffix icon is
            // pinned to the trailing edge while the segments stay at the
            // leading edge. A weighted Spacer pushes the trailing slot to the
            // far end of the now-fillMaxWidth Row.
            if (trailing != null) {
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.padding(start = 8.dp)) { trailing() }
            }
        }
        }
    }
}

// Mirrors the action switch in `_onKeyEvent` (yaru_segmented_entry.dart
// L259-273): a returning segment action of `ignored` propagates as
// `KeyEventResult.ignored`; everything else is consumed.
private fun handleAction(
    controller: YaruSegmentedEntryController,
    action: YaruSegmentEventReturnAction,
): Boolean {
    return when (action) {
        YaruSegmentEventReturnAction.SelectPreviousSegment -> {
            controller.maybeSelectPreviousSegment(); true
        }
        YaruSegmentEventReturnAction.SelectNextSegment -> {
            controller.maybeSelectNextSegment(); true
        }
        YaruSegmentEventReturnAction.Handled -> true
        YaruSegmentEventReturnAction.Ignored -> false
    }
}

