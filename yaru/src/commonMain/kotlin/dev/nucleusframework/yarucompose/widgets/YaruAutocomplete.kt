package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * Yaru-styled autocomplete text field — foundation-only.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_autocomplete.dart`. Uses
 * [YaruTextField] for the input and a Foundation [Popup] containing a
 * [Column] of suggestions; no third-party dropdown container is involved.
 *
 *  - [optionsBuilder]      — recomputed for every query change.
 *  - [displayStringForOption] — converts an option to the visible string.
 *  - [optionsMaxHeight]    — caps the suggestion panel (default 200dp,
 *                            matches Dart `optionsMaxHeight = 200.0`).
 *  - [optionsWidth]        — fixed width for the suggestions panel; when null
 *                            it falls back to [TextField] width via [Popup]'s
 *                            anchoring (matches Dart's post-frame measurement).
 *
 * Keyboard parity with Dart `RawAutocomplete`
 * (`AutocompletePreviousOptionIntent` / `AutocompleteNextOptionIntent` /
 * dismiss-on-Esc / select-on-Enter — see flutter `autocomplete.dart`):
 *  - Down / Up   — move highlight, wrapping around the list.
 *  - Enter       — select the highlighted option (no-op when nothing is highlighted).
 *  - Escape      — close the popup without selecting.
 */
@Composable
fun <T : Any> YaruAutocomplete(
    optionsBuilder: (query: String) -> List<T>,
    onSelected: (T) -> Unit,
    modifier: Modifier = Modifier,
    initialValue: String = "",
    displayStringForOption: (T) -> String = { it.toString() },
    // from yaru_autocomplete.dart: `optionsMaxHeight = 200.0`
    optionsMaxHeight: Dp = 200.dp,
    optionsWidth: Dp? = null,
    placeholder: @Composable (() -> Unit)? = null,
) {
    var query by remember { mutableStateOf(initialValue) }
    // Mirrors `RawAutocomplete._onChangedFocus` / `_updateOverlay` (flutter
    // autocomplete.dart): the options view is shown whenever the field has
    // focus AND there are options. We track focus via the textfield's
    // interaction source rather than a manual flag so external focus changes
    // (e.g. clicking elsewhere) automatically collapse the popup. Escape
    // toggles `escapeDismissed` to keep the popup hidden until focus cycles.
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    var escapeDismissed by remember { mutableStateOf(false) }
    // Defensive: capture the textfield's measured width in raw pixels via `onSizeChanged` so the suggestions popup can match it exactly. The previous `IntrinsicSize.Max` sized the popup to the widest suggestion, which is not what callers expect — they expect the field's own width.
    var anchorWidthPx by remember { mutableIntStateOf(0) }
    // Key on `optionsBuilder` as well as `query` so a caller that closes over
    // mutable state in its lambda (and produces a fresh lambda per recomposition)
    // gets fresh results — without this, the captured lambda would be silently
    // stale until `query` itself changes.
    val options = remember(query, optionsBuilder) { optionsBuilder(query) }
    // Mirrors `RawAutocomplete._highlightedOptionIndex` — clamped to options
    // size, reset to 0 whenever the option list changes (matches
    // `_updateHighlight` in flutter's `autocomplete.dart`).
    var highlighted by remember { mutableStateOf(0) }

    LaunchedEffect(options) {
        highlighted = highlighted.coerceIn(0, (options.size - 1).coerceAtLeast(0))
    }
    // Reset the Escape-dismissed flag the moment focus leaves — once the user
    // refocuses the field, the popup should auto-open again (matches
    // RawAutocomplete which has no manual dismissal).
    LaunchedEffect(isFocused) {
        if (!isFocused) escapeDismissed = false
    }
    val expanded = isFocused && options.isNotEmpty() && !escapeDismissed

    fun selectAt(index: Int) {
        val option = options.getOrNull(index) ?: return
        query = displayStringForOption(option)
        // Drop focus on selection so the popup closes via the reactive `expanded` derivation. Mirrors RawAutocomplete which closes the overlay when its `_FieldFocusNode` loses focus after `onSelected`.
        escapeDismissed = true
        onSelected(option)
    }

    // `onPreviewKeyEvent` so we intercept Down/Up/Enter/Esc BEFORE the
    // BasicTextField inside YaruTextField consumes them. Without `preview`
    // the text field swallows the event and our handler never runs.
    val keyHandler = Modifier.onPreviewKeyEvent { event ->
        if (event.type != KeyEventType.KeyDown) return@onPreviewKeyEvent false
        when (event.key) {
            Key.DirectionDown -> {
                if (!expanded || options.isEmpty()) return@onPreviewKeyEvent false
                highlighted = (highlighted + 1) % options.size
                true
            }
            Key.DirectionUp -> {
                if (!expanded || options.isEmpty()) return@onPreviewKeyEvent false
                highlighted = (highlighted - 1 + options.size) % options.size
                true
            }
            Key.Enter, Key.NumPadEnter -> {
                if (!expanded || options.isEmpty()) return@onPreviewKeyEvent false
                selectAt(highlighted)
                true
            }
            Key.Escape -> {
                if (!expanded) return@onPreviewKeyEvent false
                escapeDismissed = true
                true
            }
            else -> false
        }
    }

    Box(modifier = modifier) {
        YaruTextField(
            value = query,
            onValueChange = {
                query = it
                // Reset Escape suppression on any keystroke so the popup
                // re-opens as soon as new options are produced.
                escapeDismissed = false
                // Reset highlight to the top whenever the user types.
                highlighted = 0
            },
            // Defensive: attach the keyHandler to the textfield itself (closer to the focused BasicTextField) instead of the wrapping Box — `onPreviewKeyEvent` on a distant ancestor was unreliable across Compose Multiplatform targets when the popup was a separate window. Co-locating it with the textfield ensures arrow/enter/escape always reach this handler before the BasicTextField's own consumers.
            modifier = Modifier
                .onSizeChanged { anchorWidthPx = it.width }
                .then(keyHandler),
            placeholder = placeholder,
            interactionSource = interactionSource,
        )
        // Defensive: gate popup on `anchorWidthPx > 0` so the first composition (where the textfield hasn't been measured yet) doesn't render a screen-wide popup. The next frame after `onSizeChanged` fires re-runs this with the measured anchor width and the popup snaps into position.
        if (expanded && (optionsWidth != null || anchorWidthPx > 0)) {
            AutocompletePopup(
                options = options,
                highlighted = highlighted,
                displayStringForOption = displayStringForOption,
                optionsMaxHeight = optionsMaxHeight,
                optionsWidth = optionsWidth,
                anchorWidthPx = anchorWidthPx,
                onHighlight = { highlighted = it },
                onSelected = { index -> selectAt(index) },
                onDismiss = { escapeDismissed = true },
            )
        }
    }
}

@Composable
private fun <T : Any> AutocompletePopup(
    options: List<T>,
    highlighted: Int,
    displayStringForOption: (T) -> String,
    optionsMaxHeight: Dp,
    optionsWidth: Dp?,
    anchorWidthPx: Int,
    onHighlight: (Int) -> Unit,
    onSelected: (Int) -> Unit,
    onDismiss: () -> Unit,
) {
    // Clamp caller-supplied dimensions via the canonical `Dp.sanitise()`
    // foundation helper — `Modifier.heightIn` / `Modifier.width` throw on
    // negatives, and a non-finite Dp (NaN / +-Infinity) blows up `roundToPx()`
    // downstream. The optional `optionsWidth` keeps its `null` semantics, so
    // we still need to reject non-finite values explicitly to preserve the
    // "no explicit width" branch.
    val safeMaxHeight = optionsMaxHeight.sanitise()
    val safeOptionsWidth = optionsWidth?.let {
        if (it.value.isFinite()) it.coerceAtLeast(0.dp) else null
    }
    val density = LocalDensity.current
    // Defensive: `Popup.offset` is `IntOffset` in *pixels*, not Dp — `ButtonHeight.value.toInt()` would hardcode 34 px regardless of density, overlapping the field on >1.0x screens. Convert via `LocalDensity.current.run { ButtonHeight.roundToPx() }`.
    val anchorYPx = with(density) { YaruConstants.ButtonHeight.roundToPx() }
    // Defensive: when the caller did not supply an explicit `optionsWidth`, fall back to the textfield's measured width so the popup hugs the input, not the widest suggestion.
    val resolvedWidth = safeOptionsWidth ?: with(density) { anchorWidthPx.toDp() }.takeIf { it > 0.dp }
    Popup(
        onDismissRequest = onDismiss,
        // from yaru_autocomplete.dart: `RawAutocomplete` defaults anchor the
        // panel at the field's bottom-left — kYaruButtonHeight = 34dp below
        // the top edge with no extra gap.
        offset = IntOffset(0, anchorYPx),
        // `focusable = false` keeps focus on the text field so typing keeps
        // working while the popup is open — matches Dart's RawAutocomplete
        // which never moves focus into the options view.
        properties = PopupProperties(focusable = false),
    ) {
        // `width(IntrinsicSize.Max)` sizes the popup to the widest row's
        // intrinsic width — without it, `fillMaxWidth` on each row would
        // expand to the entire Popup window (the screen). When no explicit
        // `optionsWidth` is supplied we still clamp the surface to a 160dp
        // minimum so an empty/very-short suggestion list cannot collapse to
        // a sliver — same minimum used by `YaruPopupMenuSurface`.
        //
        // Mirrors yaru_autocomplete.dart L139-143:
        //   YaruBorderContainer(
        //     clipBehavior: Clip.antiAlias,
        //     color: theme.menuTheme.style?.backgroundColor,
        //     constraints: BoxConstraints(maxHeight: maxOptionsHeight),
        //     ...
        //   )
        // `clipContent = true` ↔ `Clip.antiAlias`, which clips row hover/press
        // overlays and the highlighted-row tint to the outer 12dp rounded
        // shape (kYaruContainerRadius — yaru_border_container.dart L81).
        YaruBorderContainer(
            modifier = Modifier
                .let {
                    if (resolvedWidth != null) {
                        // Defensive: match the textfield's measured width (or caller override) instead of growing to the widest suggestion. Mirrors Dart `RawAutocomplete`'s `LayoutLink`-driven width matching.
                        it.width(resolvedWidth)
                    } else {
                        // Fallback only when the textfield hasn't been measured yet (zero-size first frame): keep a sane minimum so the surface isn't a sliver.
                        it.widthIn(min = 160.dp)
                    }
                }
                .heightIn(max = safeMaxHeight)
                // Dart `MenuAnchor` / `_createMenuStyle.elevation = 1`
                // (common_themes.dart L558). Yaru autocomplete renders inside
                // a `YaruBorderContainer` but the underlying menu still gets
                // the 1dp lift; mirror it so the panel reads as floating.
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(YaruConstants.ContainerRadius),
                ),
            // from yaru_autocomplete.dart L142:
            //   color: theme.menuTheme.style?.backgroundColor — that's
            //   `_createMenuStyle.backgroundColor` = `_createMenuBg`.
            color = rememberYaruMenuBackground(),
            clipContent = true,
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                options.forEachIndexed { index, option ->
                    AutocompleteRow(
                        text = displayStringForOption(option),
                        highlighted = index == highlighted,
                        onHover = { onHighlight(index) },
                        onClick = { onSelected(index) },
                    )
                }
            }
        }
    }
}

@Composable
private fun AutocompleteRow(
    text: String,
    highlighted: Boolean,
    onHover: () -> Unit,
    onClick: () -> Unit,
) {
    val scheme = LocalYaruColorScheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val pressed by interactionSource.collectIsPressedAsState()
    // Track hover transitions so keyboard navigation stays in sync with the
    // pointer — matches Dart `MenuItemButton(requestFocusOnHover: false)`'s
    // implicit hover-driven highlight via `_AutocompleteCallbackAction`.
    // `rememberUpdatedState` so a fresh `onHover` lambda (the caller passes a
    // new `{ onHighlight(index) }` per recomposition) is observed without
    // restarting the effect — otherwise the body would close over a stale
    // lambda from an earlier `hovered`-change recomposition and fire the
    // wrong row's highlight.
    val currentOnHover by rememberUpdatedState(onHover)
    LaunchedEffect(hovered) {
        // Defensive: caller-supplied onHover (e.g. a `{ onHighlight(index) }` lambda) that throws must not propagate to Compose's exception handler and tear down the popup.
        if (hovered) {
            try {
                currentOnHover()
            } catch (ce: kotlinx.coroutines.CancellationException) {
                throw ce
            } catch (_: Throwable) {
            }
        }
    }
    // Dart `_MenuButtonDefaultsM3.overlayColor`
    // (menu_anchor.dart L4148-4163): hover = onSurface @ 0.08,
    // pressed = onSurface @ 0.1, focused = onSurface @ 0.1. The keyboard-
    // highlighted row uses the same value as `Theme.of(context).focusColor`
    // — Yaru's `focusColor` resolves to `onSurface.withOpacity(0.1)` via the
    // default in `common_themes.dart`.
    val background = when {
        pressed -> scheme.onSurface.copy(alpha = 0.1f)
        hovered -> scheme.onSurface.copy(alpha = 0.08f)
        highlighted -> scheme.onSurface.copy(alpha = 0.1f)
        else -> Color.Transparent
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            // from common_themes.dart `_createMenuItemTheme`:
            // `minimumSize = Size(20, kYaruButtonHeight + 10) = (20, 44)`.
            .heightIn(min = YaruConstants.ButtonHeight + 10.dp)
            .hoverable(interactionSource)
            // Mirrors Flutter's `MenuItemButton.mouseCursor` default
            // (`WidgetStateMouseCursor.clickable` → `SystemMouseCursors.click`).
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            )
            // Background under the click target so the hover/press overlay
            // spans the full row width, not just the label.
            .background(background)
            // Dart `MenuItemButton` default horizontal padding (Yaru
            // does not override `_createMenuItemTheme.padding`).
            .padding(horizontal = 12.dp),
        // Defensive: `heightIn(min = 44.dp)` makes each row taller than its glyph; without an explicit centering alignment the YaruText defaults to TopStart, leaving the label visually pinned to the top of the row.
        contentAlignment = Alignment.CenterStart,
    ) {
        CompositionLocalProvider(
            LocalYaruContentColor provides scheme.onSurface,
            LocalYaruTextStyle provides LocalYaruTypography.current.bodyMedium,
        ) {
            YaruText(text)
        }
    }
}
