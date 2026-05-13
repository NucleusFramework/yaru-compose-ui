package dev.nucleusframework.yarucompose.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.foundation.sanitiseStrokeWidth
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.YaruConstants

/**
 * A list of [YaruExpandable] sections wrapped inside a [YaruBorderContainer].
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_expansion_panel.dart`. Note: yaru's
 * `DividerThemeData(thickness: 0.0, space: 1.0)` means the separators in the
 * Flutter version are 1px gaps with no visible line. We reproduce that here
 * as a 3dp invisible spacer (matches `Padding(vertical: 1) + Divider()` ≈ 1+1+1).
 */
@Composable
fun YaruExpansionPanel(
    headers: List<@Composable () -> Unit>,
    contents: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier,
    isInitiallyExpanded: List<Boolean>? = null,
    shape: Shape = RoundedCornerShape(YaruConstants.ContainerRadius),
    border: BorderStroke = BorderStroke(1.dp, rememberYaruDividerColor()),
    // Mirrors Dart `width` / `height` (yaru_expansion_panel.dart:19-20). When
    // `null`, the container sizes itself to its parent / content.
    width: Dp? = null,
    height: Dp? = null,
    // Outer margin around the container — Dart `margin` (line 22).
    margin: PaddingValues? = null,
    // Inner padding around the LazyColumn — Dart `padding` (line 21).
    padding: PaddingValues? = null,
    // Background color override — Dart `color` (line 25). Forwarded to the
    // border container.
    color: Color? = null,
    placeDividers: Boolean = true,
    collapseOnExpand: Boolean = true,
    headerPadding: PaddingValues = PaddingValues(start = 20.dp),
    expandIconPadding: PaddingValues = PaddingValues(10.dp),
    expandIconBuilder: (@Composable (isExpanded: Boolean) -> Unit)? = null,
) {
    // Defensive: render the intersection rather than crashing if `headers` and
    // `contents` lengths drift during a transient recomposition. Callers are
    // still expected to keep them in sync.
    val itemCount = minOf(headers.size, contents.size)

    val expanded: SnapshotStateList<Boolean> = remember(itemCount) {
        // Defensive: when the caller-supplied `isInitiallyExpanded` length does
        // not match `headers.size` (e.g. lists rebuilt out-of-sync during a
        // recomposition), pad with `false` / truncate rather than crashing.
        val source = isInitiallyExpanded ?: emptyList()
        List(itemCount) { i -> source.getOrNull(i) ?: false }.toMutableStateList()
    }

    // Defensive clamps via the canonical `Dp.sanitise()` foundation helper:
    // `Modifier.width/height` throw `IllegalArgumentException` when given a
    // negative `Dp`, and callers may forward unvalidated values (e.g. computed
    // sizes that briefly go negative during layout).
    val safeWidth = width?.sanitise()
    val safeHeight = height?.sanitise()
    // Defensive: `Modifier.padding(PaddingValues)` throws if any edge resolves
    // to a negative `Dp`. Per-edge clamp before forwarding.
    val layoutDirection = LocalLayoutDirection.current
    val safeMargin = margin?.coerceNonNegative(layoutDirection)
    val safePadding = padding?.coerceNonNegative(layoutDirection)
    val safeHeaderPadding = headerPadding.coerceNonNegative(layoutDirection)
    val safeExpandIconPadding = expandIconPadding.coerceNonNegative(layoutDirection)
    // Defensive: `Modifier.background` rejects colors with non-finite channels
    // (e.g. `Color.Unspecified`). Fall back to a transparent paint so a
    // misuse upstream doesn't crash composition.
    val safeColor = color?.let(::sanitiseColor)
    // Defensive: `Modifier.border` (used by `YaruBorderContainer`) throws on
    // negative or non-finite stroke widths, and the brush's underlying color
    // can be `Color.Unspecified`. Rebuild the stroke with a sanitised width;
    // brush sanitisation is left to lower layers since `Brush` has no public
    // channel introspection.
    val safeBorder = border.sanitiseStrokeWidth()
    val outerModifier = modifier
        .let { if (safeMargin != null) it.padding(safeMargin) else it }
        .let { if (safeWidth != null) it.width(safeWidth) else it }
        .let { if (safeHeight != null) it.height(safeHeight) else it }
        .let { if (safeColor != null) it.background(color = safeColor, shape = shape) else it }
    YaruBorderContainer(
        modifier = outerModifier,
        shape = shape,
        border = safeBorder,
    ) {
        val innerModifier = if (safePadding != null) Modifier.padding(safePadding) else Modifier
        // Mirrors Flutter's `Scrollbar` wrapper around the inner `ListView`
        // (yaru_expansion_panel.dart). Yaru's `ScrollbarThemeData`
        // (common_themes.dart:783-793) is reproduced by `YaruScrollbar`.
        val listState = rememberLazyListState()
        YaruScrollbar(state = listState) {
            LazyColumn(state = listState, modifier = innerModifier) {
            items(count = itemCount) { index ->
                // Defensive: although `itemCount` is the snapshot intersection of
                // `headers.size` and `contents.size`, both lists may be mutated
                // between the snapshot read and the lambda invocation here (e.g.
                // a sibling state change shrinks one list mid-composition). Use
                // `getOrNull` with null-checks to skip stale slots rather than
                // crashing with `IndexOutOfBoundsException`. Same for the
                // `expanded` list — its size tracks `itemCount` via `remember`,
                // but defensively guard the read since item slots are invoked
                // lazily.
                val header = headers.getOrNull(index)
                val content = contents.getOrNull(index)
                val isItemExpanded = expanded.getOrNull(index) ?: false
                if (header == null || content == null) {
                    return@items
                }
                YaruExpandable(
                    header = {
                        Box(modifier = Modifier.padding(safeHeaderPadding)) {
                            header()
                        }
                    },
                    expandIconPadding = safeExpandIconPadding,
                    expandIcon = expandIconBuilder?.let { builder ->
                        { builder(isItemExpanded) }
                    } ?: {
                        // 20 dp glyph — IconButtonTheme override
                        // (`common_themes.dart:152`, `kYaruIconSize`). The 36 dp
                        // hit target is owned by `YaruExpandable` itself.
                        YaruIcon(YaruIcons.pan_end, size = YaruConstants.IconSize)
                    },
                    isExpanded = isItemExpanded,
                    onChange = { newValue ->
                        if (index in expanded.indices) {
                            expanded[index] = newValue
                            if (collapseOnExpand && newValue) {
                                for (i in expanded.indices) {
                                    if (i != index) expanded[i] = false
                                }
                            }
                        }
                    },
                ) {
                    content()
                }
                if (placeDividers && index != itemCount - 1) {
                    // Mirrors Dart `Padding(vertical: 1) + Divider()` from
                    // yaru_expansion_panel.dart:135-138. Although the Yaru
                    // theme sets `DividerThemeData.thickness: 0.0`, Skia
                    // interprets a 0-stroke paint as a 1-device-pixel hairline,
                    // so the line is visible. Render an explicit 1dp hairline
                    // in `dividerColor` between the 1dp top/bottom paddings.
                    Spacer(modifier = Modifier.height(1.dp))
                    YaruHorizontalDivider()
                    Spacer(modifier = Modifier.height(1.dp))
                }
            }
            }
        }
    }
}

