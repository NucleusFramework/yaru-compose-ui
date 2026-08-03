package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isShiftPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.utf16CodePoint
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
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
    // Mirrors `InputDecoration.errorText` from the Dart `decoration` parameter:
    // when non-null the border switches to the error color and the text is
    // rendered below the field.
    errorText: String? = null,
    // Mirrors `InputDecoration.labelText`: rendered as a floating label cut
    // into the top border. The segmented entry always shows text (segment
    // placeholders count as content, exactly like the Dart `TextFormField`
    // whose controller text is never empty), so only the floating position
    // exists — there is no resting/animated state to port.
    label: String? = null,
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
        isError || errorText != null -> scheme.error
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
        Column {
        val hasLabel = !label.isNullOrEmpty()
        val field: @Composable () -> Unit = {
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
                // With a floating label the border is drawn by
                // [YaruFloatingLabelDecoration] instead, so the label can sit
                // in a gap cut into the top stroke — `Modifier.border` cannot
                // express that gap.
                .then(
                    if (hasLabel) Modifier
                    else Modifier.border(width = borderWidth, color = borderColor, shape = shape),
                )
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
                .defaultMinSize(minHeight = YaruConstants.ButtonHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Mirrors yaru.dart's `TextFormField`-based rendering: numeric segments
            // and delimiters always paint left-to-right because digits are LTR
            // (Unicode BiDi-class L). Forcing `LayoutDirection.Ltr` on the segment
            // Row keeps Day/Month/Year (or HH:mm) in the same visual order in RTL
            // contexts — matching the Dart sample, which renders the same digit
            // order regardless of `Directionality`.
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Row(
                // The content padding only wraps the segments — Flutter's
                // `InputDecorator` lays the `suffixIcon` out against the raw
                // container edge, outside `contentPadding`. Padding the icon
                // too inflated the field to ~55 dp (36 dp button + 19 dp
                // vertical padding) instead of the Dart ~40 dp.
                //
                // The I-beam hover cursor covers the segment area only, so the
                // trailing clear button keeps the default arrow — same split as
                // a text field with a suffix icon.
                modifier = Modifier
                    .weight(1f)
                    .pointerHoverIcon(PointerIcon.Text)
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
            }
            }
            // Mirrors Flutter's `InputDecorator` behaviour: the suffix icon is
            // pinned to the trailing edge (the weighted segment Row pushes it
            // to the far end) and is vertically centered against the raw
            // container, not the padded content box.
            if (trailing != null) {
                Box { trailing() }
            }
        }
        }

        if (hasLabel) {
            // Mirrors Flutter's floating `labelText` on an `OutlineInputBorder`:
            // the label renders in `bodySmall`, vertically centered on the top
            // border line, inside a gap cut into the stroke. Label color follows
            // the border resolution (error > focused > default).
            val labelColor = when {
                isError || errorText != null -> scheme.error
                hasFocus -> scheme.primary
                else -> scheme.onSurfaceVariant
            }
            YaruFloatingLabelDecoration(
                label = label!!,
                labelStyle = typography.bodySmall.copy(color = labelColor),
                borderColor = borderColor,
                borderWidth = borderWidth,
                cornerRadius = YaruConstants.ButtonRadius,
                labelStart = safeContentPadding.calculateStartPadding(layoutDirection),
                field = field,
            )
        } else {
            field()
        }

        // Mirrors Flutter's `InputDecorator` subtext line: the error renders
        // below the container in `bodySmall` + error color, indented to the
        // field's content start. Rendered outside the forced-LTR provider so
        // prose error messages follow the ambient layout direction.
        if (!errorText.isNullOrEmpty()) {
            YaruText(
                text = errorText,
                style = typography.bodySmall.copy(color = scheme.error),
                modifier = Modifier.padding(
                    top = 4.dp,
                    start = safeContentPadding.calculateStartPadding(layoutDirection),
                ),
            )
        }
        }
    }
}

// Horizontal breathing room between the floating label text and the border
// stroke on each side — mirrors `OutlineInputBorder.gapPadding` (4.0).
private val FloatingLabelGapPadding = 4.dp

/**
 * Lays [field] out below a floating [label] and draws the outline border with
 * a gap cut into the top stroke where the label sits — the Compose port of
 * Flutter's `InputDecorator` + `OutlineInputBorder` floating-label rendering.
 *
 * The layout reserves `labelHeight / 2` above the field so the label (centered
 * on the border line) is not clipped by the parent, matching how Flutter's
 * decorator sizes an outlined field with a floating label.
 */
@Composable
private fun YaruFloatingLabelDecoration(
    label: String,
    labelStyle: TextStyle,
    borderColor: Color,
    borderWidth: Dp,
    cornerRadius: Dp,
    labelStart: Dp,
    field: @Composable () -> Unit,
) {
    // Gap geometry is produced during measure and consumed by the draw phase.
    // Snapshot state keeps the draw invalidation correct when the label or
    // field size changes (layout runs before draw within the same frame).
    var fieldTopPx by remember { mutableFloatStateOf(0f) }
    var gapLeftPx by remember { mutableFloatStateOf(0f) }
    var gapRightPx by remember { mutableFloatStateOf(0f) }

    Layout(
        content = {
            field()
            YaruText(
                text = label,
                style = labelStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        modifier = Modifier.drawWithContent {
            drawContent()
            val strokeWidth = borderWidth.toPx()
            val inset = strokeWidth / 2
            // Clip out the label's horizontal extent across the whole label
            // band so no stroke remnant shows behind the text, then draw the
            // stroke the same way `Modifier.border` does: centered on a rect
            // inset by half the stroke width, with the corner radius reduced
            // accordingly.
            clipRect(
                left = gapLeftPx,
                top = 0f,
                right = gapRightPx,
                bottom = fieldTopPx * 2,
                clipOp = ClipOp.Difference,
            ) {
                drawRoundRect(
                    color = borderColor,
                    topLeft = Offset(inset, fieldTopPx + inset),
                    size = Size(size.width - strokeWidth, size.height - fieldTopPx - strokeWidth),
                    cornerRadius = CornerRadius((cornerRadius.toPx() - inset).coerceAtLeast(0f)),
                    style = Stroke(width = strokeWidth),
                )
            }
        },
    ) { measurables, constraints ->
        val labelStartPx = labelStart.roundToPx()
        val gapPaddingPx = FloatingLabelGapPadding.roundToPx()
        // Keep the label inside the border's horizontal bounds, mirrored on
        // both sides so RTL placement can't overflow either edge.
        val labelMaxWidth = (constraints.maxWidth - 2 * (labelStartPx + gapPaddingPx))
            .coerceAtLeast(0)
        val labelPlaceable = measurables[1].measure(
            Constraints(maxWidth = labelMaxWidth, maxHeight = constraints.maxHeight),
        )
        val topOffset = labelPlaceable.height / 2
        val fieldPlaceable = measurables[0].measure(constraints.offset(vertical = -topOffset))
        val width = fieldPlaceable.width
        val labelX = when (layoutDirection) {
            LayoutDirection.Ltr -> labelStartPx
            LayoutDirection.Rtl -> (width - labelStartPx - labelPlaceable.width).coerceAtLeast(0)
        }

        fieldTopPx = topOffset.toFloat()
        gapLeftPx = (labelX - gapPaddingPx).toFloat()
        gapRightPx = (labelX + labelPlaceable.width + gapPaddingPx).toFloat()

        layout(width, fieldPlaceable.height + topOffset) {
            fieldPlaceable.place(0, topOffset)
            labelPlaceable.place(labelX, 0)
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

