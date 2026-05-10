package dev.nucleusframework.yarucompose.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruEasing
import dev.nucleusframework.yarucompose.foundation.coerceNonNegative
import dev.nucleusframework.yarucompose.foundation.sanitise
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruContentColor
import dev.nucleusframework.yarucompose.themes.LocalYaruTextStyle
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants

// `kTabScrollDuration` from Flutter's `material/tabs.dart` (300 ms) — drives
// the indicator slide animation in Material `TabBar`, which yaru_tab_bar.dart
// builds on top of without overriding.
private const val TAB_SCROLL_DURATION_MILLIS: Int = 300

// `EdgeInsets.all(5)` outer padding around the inner `TabBar` from
// yaru_tab_bar.dart line 27. The 10dp height bonus on `kYaruTitleBarItemHeight`
// (line 28) is exactly twice this padding, so the inner TabBar lays out at
// `TitleBarItemHeight` while the outer container is `+10`.
private val TabBarOuterPadding: Dp = 5.dp
private val TabBarHeightBonus: Dp = TabBarOuterPadding * 2

// `theme.colorScheme.onSurface.withValues(alpha: 0.1)` — selected-tab pill
// background from yaru_tab_bar.dart line 38.
private const val INDICATOR_BACKGROUND_ALPHA: Float = 0.1f

// `_createTabBarTheme.overlayColor` (common_themes.dart:452-454) is
// `WidgetStatePropertyAll(onSurface @ 0.05)` — i.e. a FLAT 0.05 alpha for
// every interaction state. This OVERRIDES the global `YaruIndication`
// (which uses `onSurfaceVariant @ 0.08/0.08/0.12`). To honor the Dart spec
// we paint the overlay manually here instead of consuming `LocalIndication`.
private const val TAB_OVERLAY_ALPHA: Float = 0.05f

/**
 * Yaru-styled tab bar — foundation only, no Material3 dependency.
 *
 * Mirrors `yaru.dart/lib/src/widgets/yaru_tab_bar.dart`:
 *  - outer container: 5dp padding all around, height = `kYaruTitleBarItemHeight + 10` (44dp)
 *  - tabs share the available width equally (Material `TabBar` is non-scrollable here)
 *  - selected pill: `onSurface @ 0.10`, radius = `kYaruButtonRadius` (8dp), `TabBarIndicatorSize.tab`
 *  - selected label: `colorScheme.onSurface`
 *  - unselected label: `colorScheme.onSurfaceVariant` (Material 3 `_TabsDefaultsM3` default)
 *  - hover / focus / press overlays come from [LocalIndication] (Yaru flat overlay), clipped to the pill
 *  - the pill slides smoothly between tabs (`kTabScrollDuration` 300ms / `Curves.ease`)
 *    like Flutter `TabBar`'s indicator animation (TabController.animateTo default
 *    curve, lerped through `TabIndicatorAnimation.linear` for `indicatorSize: tab`)
 *
 * No per-tab focus ring: Dart `yaru_tab_bar.dart` has no `YaruFocusBorder`
 * wrapping (`grep -nE "YaruFocusBorder|focusBorders" yaru_tab_bar.dart` is
 * empty). Material `_createTabBarTheme` in common_themes.dart only customises
 * `overlayColor`, leaving focus to the standard state-layer overlay.
 */
@Composable
fun YaruTabBar(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    tabs: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier,
    height: Dp = YaruConstants.TitleBarItemHeight + TabBarHeightBonus,
    contentPadding: PaddingValues = PaddingValues(TabBarOuterPadding),
    labelColor: Color? = null,
    unselectedLabelColor: Color? = null,
) {
    if (tabs.isEmpty()) return
    val scheme = LocalYaruColorScheme.current
    val pillShape = RoundedCornerShape(YaruConstants.ButtonRadius)
    // Defensive: caller-supplied label colors propagate to LocalYaruContentColor and may reach draw calls; coerce non-finite channels.
    val resolvedLabelColor = sanitiseColor(labelColor ?: scheme.onSurface)
    val resolvedUnselectedColor = sanitiseColor(unselectedLabelColor ?: scheme.onSurfaceVariant)
    // Material `_TabsDefaultsM3.labelStyle` — `textTheme.titleSmall` (W500),
    // applied unchanged by yaru_tab_bar.dart since `_createTabBarTheme` only
    // overrides colors / overlay (see common_themes.dart line 442).
    val labelStyle = LocalYaruTypography.current.titleSmall

    // Defensive clamp: callers may pass an out-of-bounds `selectedTabIndex`
    // (e.g. `-1` for "none", or a stale index after the tab list shrinks).
    // Feeding such a value to `animateFloatAsState` would slide the pill off
    // the bar (or beyond it) — clamp into `[0, tabs.size - 1]` so the
    // indicator stays inside the layout.
    val clampedSelectedIndex = selectedTabIndex.coerceIn(0, tabs.size - 1)
    // The pill slide tracks Material `TabController.animateTo` (tab_controller.dart
    // line 265: `curve: Curves.ease`, duration `kTabScrollDuration` = 300ms from
    // material/constants.dart line 51). Because `TabBarIndicatorSize.tab` selects
    // `TabIndicatorAnimation.linear` (tabs.dart line 1705), `_IndicatorPainter`
    // simply lerps the indicator rect against the controller animation value
    // (tabs.dart line 666), so the visible curve IS `Curves.ease`. This is NOT
    // `Curves.fastOutSlowIn` — that curve only applies to `TabPageSelector`
    // (tabs.dart line 2676), not to the `TabBar` indicator.
    val indicatorIndex by animateFloatAsState(
        targetValue = clampedSelectedIndex.toFloat(),
        animationSpec = tween(
            durationMillis = TAB_SCROLL_DURATION_MILLIS,
            easing = YaruEasing.Ease,
        ),
    )

    // Defensive clamp: `Modifier.height(-1.dp)` throws
    // `IllegalArgumentException`, and a non-finite Dp (NaN / ±Infinity) blows
    // up `roundToPx()`. Callers passing computed sizes (e.g. derived from a
    // parent constraint or animation) may briefly hand us a negative or
    // non-finite value, so route through the canonical foundation helpers.
    val safeHeight = height.sanitise()
    val layoutDirection = LocalLayoutDirection.current
    val safeContentPadding = contentPadding.coerceNonNegative(layoutDirection)
    Box(
        modifier = modifier
            .height(safeHeight)
            .fillMaxWidth()
            .padding(safeContentPadding),
    ) {
        // Sliding pill drawn behind the tab row.
        SlidingTabIndicator(
            tabCount = tabs.size,
            position = indicatorIndex,
            color = scheme.onSurface.copy(alpha = INDICATOR_BACKGROUND_ALPHA),
            shape = pillShape,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        )

        // Tab row: equally-sized cells, no inter-tab spacing (mirrors Material `TabBar`).
        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CompositionLocalProvider(LocalYaruTextStyle provides labelStyle) {
                tabs.forEachIndexed { index, content ->
                    // Use the clamped index so the selected-color tint stays
                    // consistent with the indicator pill when callers pass an
                    // out-of-bounds `selectedTabIndex` (e.g. -1 or stale).
                    val selected = index == clampedSelectedIndex
                    val tint = if (selected) resolvedLabelColor else resolvedUnselectedColor
                    // Defensive: anchor the per-tab `remember { MutableInteractionSource }` to its index so adding/removing tabs doesn't reuse a previous tab's hover/press state for whichever lambda now sits at that source position.
                    TabCell(
                        key = index,
                        tint = tint,
                        selected = selected,
                        pillShape = pillShape,
                        scheme = scheme,
                        onClick = { onTabSelected(index) },
                        content = content,
                    )
                }
            }
        }
    }
}

@Composable
private fun RowScope.TabCell(
    key: Int,
    tint: Color,
    selected: Boolean,
    pillShape: androidx.compose.ui.graphics.Shape,
    scheme: YaruColorScheme,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    key(key) {
        val interactionSource = remember { MutableInteractionSource() }
        val hovered by interactionSource.collectIsHoveredAsState()
        val pressed by interactionSource.collectIsPressedAsState()
        // Defensive: also paint the overlay on focus — `_createTabBarTheme.overlayColor` (common_themes.dart:452-454) returns a FLAT `0.05` for every state including `focused`.
        val focused by rememberKeyboardFocusedState(interactionSource)
        // Flat `onSurface @ 0.05` overlay for any active state —
        // mirrors `_createTabBarTheme.overlayColor` (common_themes.dart:452).
        val overlayAlpha = if (hovered || pressed || focused) TAB_OVERLAY_ALPHA else 0f

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clip(pillShape)
                .background(
                    color = if (overlayAlpha > 0f) {
                        scheme.onSurface.copy(alpha = overlayAlpha)
                    } else {
                        Color.Transparent
                    },
                )
                // Mirrors Material `Tab`/`InkWell.mouseCursor`
                // default (`WidgetStateMouseCursor.clickable` →
                // `SystemMouseCursors.click`). Yaru's
                // `_createTabBarTheme` doesn't override it.
                .pointerHoverIcon(PointerIcon.Hand)
                .clickable(
                    interactionSource = interactionSource,
                    // Indication painted manually via background() above.
                    indication = null,
                    role = Role.Tab,
                    onClick = onClick,
                )
                // Defensive: announce which tab is currently selected so screen readers describe the active tab alongside its role.
                .semantics { this.selected = selected },
            contentAlignment = Alignment.Center,
        ) {
            CompositionLocalProvider(LocalYaruContentColor provides tint) {
                content()
            }
        }
    }
}

/**
 * Lays out a single pill positioned at `position` (a fractional tab index) and
 * sized to one tab's width — mirrors Flutter's animated `TabBarIndicator`.
 */
@Composable
private fun SlidingTabIndicator(
    tabCount: Int,
    position: Float,
    color: Color,
    shape: androidx.compose.ui.graphics.Shape,
    modifier: Modifier = Modifier,
) {
    Layout(
        modifier = modifier,
        content = {
            Box(modifier = Modifier.fillMaxHeight().background(color = color, shape = shape))
        },
    ) { measurables, constraints ->
        // Defensive: unbounded width surfaces as `Constraints.Infinity` (Int.MAX_VALUE); fall back to minWidth so we never feed Infinity to layout().
        val total = if (constraints.hasBoundedWidth) constraints.maxWidth else constraints.minWidth
        // Defensive: `measurables.first()` would throw on an empty content slot; bail out with the layout's reported size.
        val firstMeasurable = measurables.firstOrNull()
        val tabWidth = if (tabCount > 0) total / tabCount else total
        // Defensive: clamp non-negative only. Do NOT clamp against `constraints.minWidth` — when the Box parent uses `fillMaxWidth()`, minWidth equals the full bar width and would force the pill to span all tabs instead of just one.
        val safeTabWidth = tabWidth.coerceAtLeast(0)
        val pill = firstMeasurable?.measure(
            constraints.copy(minWidth = safeTabWidth, maxWidth = safeTabWidth),
        )
        // Defensive: `layout()` with `Constraints.Infinity` would propagate Int.MAX_VALUE downstream; coerce both axes to a finite non-negative size.
        val outWidth = (if (constraints.hasBoundedWidth) constraints.maxWidth else constraints.minWidth).coerceAtLeast(0)
        val outHeight = (if (constraints.hasBoundedHeight) constraints.maxHeight else constraints.minHeight).coerceAtLeast(0)
        layout(outWidth, outHeight) {
            if (pill != null) {
                val x = (position * safeTabWidth).toInt()
                // `placeRelative` mirrors `x` in RTL so the indicator pill tracks
                // the visually-mirrored Row above it (yaru.dart inherits this from
                // Material `TabBar`, which lerps `_indicatorPainter._currentRect`
                // through its text-direction-aware `_paint`).
                pill.placeRelative(x = x, y = (outHeight - pill.height) / 2)
            }
        }
    }
}

// `EdgeInsets.only(right: 10)` — gap between leading icon and label, see
// yaru_tab_bar.dart line 64.
private val TabIconLabelGap: Dp = 10.dp

/**
 * A pre-styled tab content with optional leading [icon] and [label].
 *
 * Mirrors the `YaruTab` widget from `yaru.dart` — a `Row` of optional icon
 * (with 10dp trailing padding) and an ellipsised label.
 */
@Composable
fun YaruTab(
    label: String,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    // Mirrors Dart `YaruTab.padding` (yaru_tab_bar.dart:48). Inner padding
    // around the tab content. Defaults to `null`, matching Material `Tab`'s
    // default of no extra padding.
    padding: PaddingValues? = null,
) {
    // Defensive clamp via the canonical foundation helper:
    // `Modifier.padding` throws on negative `Dp`, and a non-finite Dp
    // (NaN / ±Infinity) blows up `roundToPx()`.
    val layoutDirection = LocalLayoutDirection.current
    val safePadding = padding?.coerceNonNegative(layoutDirection)
    Row(
        modifier = modifier.let { if (safePadding != null) it.padding(safePadding) else it },
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Defensive: drop the 10dp icon-to-label gap when `label` is empty so an icon-only tab is not rendered with a stray trailing whitespace block.
        // Defensive: also treat whitespace-only labels as absent — they would still consume the gap and render an invisible YaruText that reserves layout space.
        val hasLabel = label.isNotBlank()
        if (icon != null) {
            Box(modifier = if (hasLabel) Modifier.padding(end = TabIconLabelGap) else Modifier) { icon() }
        }
        if (hasLabel) {
            YaruText(label, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}
