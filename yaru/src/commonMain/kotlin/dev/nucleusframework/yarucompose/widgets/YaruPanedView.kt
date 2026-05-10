package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitise

/** Side at which the pane sits in a [YaruPanedView]. */
enum class YaruPaneSide {
    Top, Bottom, Start, End;

    val isVertical: Boolean get() = this == Top || this == Bottom
    val isHorizontal: Boolean get() = this == Start || this == End
}

/** Layout strategy controlling pane size and resizing capability. */
@Immutable
sealed interface YaruPanedViewLayoutDelegate {
    val paneSide: YaruPaneSide
    val allowPaneResizing: Boolean
    fun calculatePaneSize(availableSpace: Dp, candidatePaneSize: Dp?): Dp
}

/** Fixed pane that does not resize. */
@Immutable
data class YaruFixedPaneDelegate(
    val paneSize: Dp,
    override val paneSide: YaruPaneSide = YaruPaneSide.Start,
) : YaruPanedViewLayoutDelegate {
    override val allowPaneResizing: Boolean = false
    override fun calculatePaneSize(availableSpace: Dp, candidatePaneSize: Dp?): Dp {
        // `paneSize` is caller-supplied: negatives / NaN / +-Infinity would
        // propagate into `Modifier.width`/`height` and crash. Route through
        // `Dp.sanitise()` so the canonical foundation helper handles both
        // negatives and non-finite Dp values uniformly.
        val safeAvailable = availableSpace.sanitise()
        val safePaneSize = if (paneSize.value.isFinite()) paneSize else 0.dp
        val resolved = if (safePaneSize > safeAvailable / 2) safeAvailable / 2 else safePaneSize
        return resolved.coerceIn(0.dp, safeAvailable)
    }
}

/** Resizable pane with min sizes for both sides. */
@Immutable
data class YaruResizablePaneDelegate(
    val initialPaneSize: Dp,
    val minPaneSize: Dp,
    val minPageSize: Dp,
    override val paneSide: YaruPaneSide = YaruPaneSide.Start,
) : YaruPanedViewLayoutDelegate {
    override val allowPaneResizing: Boolean = true
    override fun calculatePaneSize(availableSpace: Dp, candidatePaneSize: Dp?): Dp {
        // When the container is too small for `minPaneSize + minPageSize` the
        // raw `maxSize` goes below `minPaneSize` (or even negative), and the
        // ordering of the `when` branches would return a value that exceeds
        // `availableSpace` or is negative — both of which crash `Modifier.width`.
        // Route every caller-supplied Dp through `Dp.sanitise()` so the
        // canonical foundation helper handles negatives and non-finite values.
        val safeAvailable = availableSpace.sanitise()
        val safeMinPageSize = minPageSize.sanitise()
        val safeMinPaneSize = minPaneSize.sanitise()
        val safeInitial = initialPaneSize.sanitise()
        val safeCandidate = candidatePaneSize?.let { if (it.value.isFinite()) it else null }
        val maxSize = (safeAvailable - safeMinPageSize).coerceAtLeast(0.dp)
        val candidate = safeCandidate ?: safeInitial
        val resolved = when {
            candidate >= maxSize -> maxSize
            candidate < safeMinPaneSize -> safeMinPaneSize
            else -> candidate
        }
        return resolved.coerceIn(0.dp, safeAvailable)
    }
}

// `_kLeftPaneResizingRegionSize` from yaru_paned_view.dart:53.
private val ResizingRegionSize: Dp = 4.dp
// `_kLeftPaneResizingRegionAnimationDuration` from yaru_paned_view.dart:54.
private const val ResizingAnimationMillis: Int = 250

/**
 * Two-section view with a 1dp divider between [pane] and [page]. When the
 * layout delegate allows resizing, an invisible 4dp region overlaps the page
 * edge adjacent to the pane and reveals a hover/drag indicator that lets the
 * user resize the pane within the delegate's clamps.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_paned_view.dart` together with its
 * `layout_delegate` companion. Pane size persists across recompositions and is
 * re-clamped on layout-size changes, matching the Dart `_paneSize` field
 * behaviour driven by `LayoutBuilder` + `updatePaneSize`.
 */
@Composable
fun YaruPanedView(
    layoutDelegate: YaruPanedViewLayoutDelegate,
    pane: @Composable () -> Unit,
    page: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    includeSeparator: Boolean = true,
    onPaneSizeChange: ((Dp) -> Unit)? = null,
) {
    // Persisted across recomposition so window resizes only re-clamp the size,
    // they do not reset it. `null` until the first measure-driven calculation.
    var paneSize by remember { mutableStateOf<Dp?>(null) }
    // Drag accumulator mirroring Dart's `_oldPaneSize` + `_paneSizeMove`. Storing
    // the unclamped move lets the user drag back across a clamp boundary
    // without first having to retrace the swallowed delta. We accumulate the
    // raw pixel delta (not Dp) to mirror Dart's logical-pixel arithmetic and
    // avoid losing sub-dp precision on high-density screens.
    var dragOrigin by remember { mutableStateOf<Dp?>(null) }
    // Defensive: primitive float state avoids per-frame Float boxing as drag deltas accumulate on every pointer move during a resize gesture.
    var dragMovePx by remember { mutableFloatStateOf(0f) }

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val rawAvailable = if (layoutDelegate.paneSide.isVertical) maxHeight else maxWidth
        // Unbounded constraints surface as `Dp.Infinity`; `calculatePaneSize`
        // would propagate that into `Modifier.width`/`height`, which crashes.
        // Falling back to `0.dp` collapses the pane gracefully instead.
        val available = if (rawAvailable.value.isFinite() && rawAvailable.value >= 0f) rawAvailable else 0.dp
        val previous = paneSize
        // `YaruPanedViewLayoutDelegate` is a public sealed interface — external
        // implementations are free to return non-finite or negative values from
        // `calculatePaneSize`. The built-in delegates clamp internally, but
        // re-sanitise here so a misbehaving custom delegate cannot crash
        // `Modifier.width` / `Modifier.height` with NaN / Infinity / negatives.
        val rawResolved = layoutDelegate.calculatePaneSize(available, previous)
        val resolved = when {
            !rawResolved.value.isFinite() -> 0.dp
            rawResolved < 0.dp -> 0.dp
            rawResolved > available -> available
            else -> rawResolved
        }
        if (resolved != previous) {
            // Defensive: defer the snapshot write out of the composition phase via SideEffect; mutating `paneSize` directly during composition schedules an extra recomposition pass and risks divergence under fast successive layout passes.
            SideEffect { paneSize = resolved }
            // Match Dart `updatePaneSize`: notify on every change, including the
            // first calculation and re-clamps triggered by container resizes.
            if (onPaneSizeChange != null) {
                SideEffect { onPaneSizeChange(resolved) }
            }
        }
        val currentPaneSize = resolved

        val dividerColor = rememberYaruDividerColor()
        val layoutDirection = LocalLayoutDirection.current

        // For horizontal pane sides we negate the drag delta when the pane is
        // visually on the trailing edge so dragging "outward" always grows the
        // pane. RTL flips `Start`/`End`; absolute `Top`/`Bottom` ignore it.
        val invertHorizontalDelta = when (layoutDelegate.paneSide) {
            YaruPaneSide.Start -> layoutDirection == LayoutDirection.Rtl
            YaruPaneSide.End -> layoutDirection == LayoutDirection.Ltr
            else -> false
        }
        val invertVerticalDelta = layoutDelegate.paneSide == YaruPaneSide.Bottom

        val applyDragPx: (Float, Float, (Float) -> Dp) -> Unit = applyDrag@{ dxPx, dyPx, toDp ->
            val origin = dragOrigin ?: return@applyDrag
            val rawDelta = if (layoutDelegate.paneSide.isHorizontal) {
                if (invertHorizontalDelta) -dxPx else dxPx
            } else {
                if (invertVerticalDelta) -dyPx else dyPx
            }
            // Guard against NaN/Infinity from synthetic pointer events: a single
            // bad sample would otherwise poison `dragMovePx` for the entire drag
            // and feed NaN through `calculatePaneSize` into `Modifier.width`.
            if (!rawDelta.isFinite()) return@applyDrag
            dragMovePx += rawDelta
            if (!dragMovePx.isFinite()) {
                dragMovePx = 0f
                return@applyDrag
            }
            val candidate = origin + toDp(dragMovePx)
            val rawNewSize = layoutDelegate.calculatePaneSize(available, candidate)
            // Mirror the same defensive clamp applied to the initial measure
            // path: a custom delegate could return NaN/Infinity/negative.
            val newSize = when {
                !rawNewSize.value.isFinite() -> 0.dp
                rawNewSize < 0.dp -> 0.dp
                rawNewSize > available -> available
                else -> rawNewSize
            }
            if (newSize != paneSize) {
                paneSize = newSize
                onPaneSizeChange?.invoke(newSize)
            }
        }

        val onDragStart: () -> Unit = {
            dragOrigin = paneSize
            dragMovePx = 0f
        }
        val onDragStop: () -> Unit = {
            dragOrigin = null
            dragMovePx = 0f
        }

        when (layoutDelegate.paneSide) {
            YaruPaneSide.Start -> Row(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.width(currentPaneSize).fillMaxHeight()) { pane() }
                if (includeSeparator) YaruVerticalDivider(color = dividerColor)
                Box(modifier = Modifier.weight(1f).fillMaxHeight()) {
                    page()
                    if (layoutDelegate.allowPaneResizing) {
                        ResizeHandle(
                            isVertical = false,
                            // Visually on the edge facing the pane. In RTL the
                            // `Row` is mirrored, so the page's leading edge is
                            // on the right; `CenterStart` resolves correctly
                            // through `LocalLayoutDirection`.
                            alignment = Alignment.CenterStart,
                            dividerColor = dividerColor,
                            onDragStart = onDragStart,
                            onDragStop = onDragStop,
                            onDragDelta = applyDragPx,
                        )
                    }
                }
            }
            YaruPaneSide.End -> Row(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight()) {
                    page()
                    if (layoutDelegate.allowPaneResizing) {
                        ResizeHandle(
                            isVertical = false,
                            alignment = Alignment.CenterEnd,
                            dividerColor = dividerColor,
                            onDragStart = onDragStart,
                            onDragStop = onDragStop,
                            onDragDelta = applyDragPx,
                        )
                    }
                }
                if (includeSeparator) YaruVerticalDivider(color = dividerColor)
                Box(modifier = Modifier.width(currentPaneSize).fillMaxHeight()) { pane() }
            }
            YaruPaneSide.Top -> Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.height(currentPaneSize).fillMaxWidth()) { pane() }
                if (includeSeparator) YaruHorizontalDivider(color = dividerColor)
                Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                    page()
                    if (layoutDelegate.allowPaneResizing) {
                        ResizeHandle(
                            isVertical = true,
                            alignment = Alignment.TopCenter,
                            dividerColor = dividerColor,
                            onDragStart = onDragStart,
                            onDragStop = onDragStop,
                            onDragDelta = applyDragPx,
                        )
                    }
                }
            }
            YaruPaneSide.Bottom -> Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                    page()
                    if (layoutDelegate.allowPaneResizing) {
                        ResizeHandle(
                            isVertical = true,
                            alignment = Alignment.BottomCenter,
                            dividerColor = dividerColor,
                            onDragStart = onDragStart,
                            onDragStop = onDragStop,
                            onDragDelta = applyDragPx,
                        )
                    }
                }
                if (includeSeparator) YaruHorizontalDivider(color = dividerColor)
                Box(modifier = Modifier.height(currentPaneSize).fillMaxWidth()) { pane() }
            }
        }
    }
}

/**
 * Invisible-by-default 4dp region pinned to a page edge. Highlights with the
 * divider color when hovered or dragged, and exposes a pointer icon to signal
 * interactivity. Consumes vertical/horizontal drag deltas in dp.
 *
 * Cursor note: Dart uses `SystemMouseCursors.resizeColumn` / `resizeRow` based
 * on the pane axis. Compose Multiplatform's [PointerIcon] only ships the
 * `Default`, `Crosshair`, `Text` and `Hand` presets, so we fall back to
 * `PointerIcon.Hand` for both axes — the closest "interactive" affordance
 * available without dropping to a platform-specific icon.
 */
@Composable
private fun BoxScope.ResizeHandle(
    isVertical: Boolean,
    alignment: Alignment,
    dividerColor: Color,
    onDragStart: () -> Unit,
    onDragStop: () -> Unit,
    onDragDelta: (dxPx: Float, dyPx: Float, toDp: (Float) -> Dp) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovering by interactionSource.collectIsHoveredAsState()
    var isDragging by remember { mutableStateOf(false) }
    val active = isHovering || isDragging
    // Linear easing matches Flutter's `AnimatedContainer` default curve
    // (`Curves.linear`), which Dart's `_buildLeftPaneResizer` relies on.
    val color by animateColorAsState(
        targetValue = if (active) dividerColor else Color.Transparent,
        animationSpec = tween(durationMillis = ResizingAnimationMillis, easing = LinearEasing),
    )

    // `pointerInput` is keyed on `Unit`, so the gesture coroutine captures the
    // initial lambda references for the lifetime of the modifier. Wrap the
    // caller-provided callbacks in `rememberUpdatedState` so a parent
    // recomposition that supplies fresh lambdas (e.g. closures over updated
    // state) is observed by the in-flight `detectDragGestures` block instead
    // of going stale.
    val currentOnDragStart by rememberUpdatedState(onDragStart)
    val currentOnDragStop by rememberUpdatedState(onDragStop)
    val currentOnDragDelta by rememberUpdatedState(onDragDelta)

    Box(
        modifier = Modifier
            .align(alignment)
            .then(
                if (isVertical) Modifier.fillMaxWidth().height(ResizingRegionSize)
                else Modifier.fillMaxHeight().width(ResizingRegionSize),
            )
            .background(color)
            .pointerHoverIcon(PointerIcon.Hand)
            .hoverable(interactionSource)
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = {
                        isDragging = true
                        currentOnDragStart()
                    },
                    onDragEnd = {
                        isDragging = false
                        currentOnDragStop()
                    },
                    onDragCancel = {
                        isDragging = false
                        currentOnDragStop()
                    },
                ) { _, drag ->
                    // Pass raw pixel deltas plus a density-aware Dp converter so
                    // the caller can accumulate in pixels and only quantise to
                    // Dp at apply time, mirroring Dart's logical-pixel math.
                    currentOnDragDelta(drag.x, drag.y) { px -> px.toDp() }
                }
            },
    )
}
