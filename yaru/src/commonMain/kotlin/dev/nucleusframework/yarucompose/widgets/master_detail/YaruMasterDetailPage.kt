package dev.nucleusframework.yarucompose.widgets.master_detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.YaruPageController
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale
import dev.nucleusframework.yarucompose.widgets.YaruFixedPaneDelegate
import dev.nucleusframework.yarucompose.widgets.YaruPaneSide
import dev.nucleusframework.yarucompose.widgets.YaruPanedView
import dev.nucleusframework.yarucompose.widgets.YaruPanedViewLayoutDelegate

/**
 * A responsive master / detail page that switches between landscape (paned)
 * and portrait (full-width list / stacked detail) layouts based on a
 * width [breakpoint].
 *
 * Mirrors `yaru.dart/lib/src/widgets/master_detail/yaru_master_detail_page.dart`.
 */
@Composable
fun YaruMasterDetailPage(
    length: Int,
    tileBuilder: @Composable (index: Int, selected: Boolean, onTap: () -> Unit) -> Unit,
    pageBuilder: @Composable (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    breakpoint: Dp = YaruConstants.MasterDetailBreakpoint,
    paneLayoutDelegate: YaruPanedViewLayoutDelegate = YaruFixedPaneDelegate(
        paneSize = 280.dp,
        paneSide = YaruPaneSide.Start,
    ),
    // Mirrors `yaru_master_detail_page.dart:190` —
    //   `YaruPageController(initialIndex: widget.initialIndex ?? -1)`.
    // `-1` means "no selection": portrait starts on the master list, landscape
    // coerces to `0` for the page area while leaving the controller unset so
    // callers can detect the no-selection state.
    initialIndex: Int = -1,
    controller: YaruPageController? = null,
    onSelected: ((Int) -> Unit)? = null,
    appBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    emptyContent: @Composable () -> Unit = {},
) {
    // Defensive: always call `remember` so slot positions stay stable when a caller swaps `controller` between null and non-null.
    val fallbackCtrl = remember(length) {
        YaruPageController(length = length, initialIndex = initialIndex)
    }
    val ctrl = controller ?: fallbackCtrl
    // Read the controller's index directly — `YaruPageController._index` is
    // backed by a mutableStateOf, so reading here keeps recomposition in sync
    // when an external caller writes `ctrl.index = …`.
    val selectedIndex = ctrl.index

    val select: (Int) -> Unit = {
        ctrl.index = it
        onSelected?.invoke(it)
    }

    val scheme = LocalYaruColorScheme.current
    // Mirrors `YaruMasterDetailThemeData.fallback.sideBarColor`:
    //   surface.scale(lightness: light ? -0.029 : 0.029) — slightly darker on
    //   light themes, slightly lighter on dark themes. This subtle tint is what
    //   visually separates the master pane from the detail page.
    val sideBarColor = remember(scheme) {
        scheme.surface.scale(lightness = if (scheme.isLight) -0.029f else 0.029f)
    }

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        // Dart short-circuits the entire tree to `emptyBuilder` when
        // `length == 0` (yaru_master_detail_page.dart:222-224).
        if (length == 0) {
            Box(modifier = Modifier.fillMaxSize().background(scheme.surface)) {
                emptyContent()
            }
            return@BoxWithConstraints
        }

        val landscape = maxWidth >= breakpoint

        if (landscape) {
            // Mirrors `yaru_landscape_layout.dart:50` —
            //   `_selectedIndex = max(widget.controller.index, 0)`.
            // Landscape always renders a page (and a highlighted tile) even
            // when the controller has no selection (`-1`). Upper bound is
            // clamped defensively so a stale `index >= length` (e.g. list
            // shrunk via data update) cannot pass an invalid index to the
            // caller's `pageBuilder` / `tileBuilder`.
            val landscapeIndex = selectedIndex.coerceIn(0, length - 1)
            YaruPanedView(
                layoutDelegate = paneLayoutDelegate,
                // Dart's `YaruPanedView(includeSeparator: theme.includeSeparator ?? true)`
                // — keep the hairline divider between sidebar and detail page.
                includeSeparator = true,
                pane = {
                    // Wrap the entire pane (incl. appBar / bottomBar) in the
                    // sidebar tint, matching Dart's
                    // `Container(color: theme.sideBarColor)` around the list
                    // and `Material(color: theme.sideBarColor)` around the
                    // bottomBar.
                    Column(modifier = Modifier.fillMaxSize().background(sideBarColor)) {
                        appBar?.invoke()
                        Box(modifier = Modifier.weight(1f)) {
                            YaruMasterListView(length = length) { index ->
                                tileBuilder(index, index == landscapeIndex) { select(index) }
                            }
                        }
                        bottomBar?.invoke()
                    }
                },
                page = {
                    // Detail surface; matches Dart's `Material(color: surface)`
                    // inside `YaruDetailPage` — caller supplies the page, we
                    // only animate between indices using the landscape's
                    // `verticalTransitions` from yaru.dart.
                    Box(modifier = Modifier.fillMaxSize().background(scheme.surface)) {
                        AnimatedContent(
                            targetState = landscapeIndex,
                            transitionSpec = {
                                // Mirrors `_YaruVerticalPageTransitions` (page_transitions.dart):
                                //   _tween         = Offset(0.0, 0.1)  -> Offset.zero  (fastOutSlowIn)
                                //   _secondaryTween = Offset.zero      -> Offset.zero  (no slide)
                                //   _opacity       = easeIn  (incoming)
                                //   _secondaryOpacity = easeOutExpo (outgoing fade)
                                // Compose lacks a built-in easeOutExpo for fade; the default
                                // tween() curve is sufficiently close while still respecting
                                // the 300ms MaterialPageRoute duration.
                                (
                                    slideInVertically(
                                        animationSpec = tween(easing = FastOutSlowInEasing),
                                    ) { it / 10 } + fadeIn(tween(easing = EaseIn))
                                ).togetherWith(fadeOut(tween()))
                            },
                            label = "YaruMasterDetailLandscape",
                        ) { idx ->
                            pageBuilder(idx)
                        }
                    }
                },
            )
        } else {
            // Portrait: master list shown until a tile is tapped, then the
            // detail page slides in horizontally over it.
            if (selectedIndex < 0 || selectedIndex >= length) {
                Column(modifier = Modifier.fillMaxSize().background(sideBarColor)) {
                    appBar?.invoke()
                    Box(modifier = Modifier.weight(1f)) {
                        YaruMasterListView(length = length) { index ->
                            tileBuilder(index, index == selectedIndex) { select(index) }
                        }
                    }
                    bottomBar?.invoke()
                }
            } else {
                Box(modifier = Modifier.fillMaxSize().background(scheme.surface)) {
                    AnimatedContent(
                        targetState = selectedIndex,
                        transitionSpec = {
                            // Mirrors `_YaruHorizontalPageTransitions` (page_transitions.dart):
                            //   _tween         = Offset(0.2, 0.0)  -> Offset.zero    (fastOutSlowIn)
                            //   _secondaryTween = Offset.zero       -> Offset(-0.2, 0.0) (fastOutSlowIn)
                            //   _opacity / _secondaryOpacity = easeIn (fade)
                            (
                                slideInHorizontally(
                                    animationSpec = tween(easing = FastOutSlowInEasing),
                                ) { it / 5 } + fadeIn(tween(easing = EaseIn))
                            ).togetherWith(
                                slideOutHorizontally(
                                    animationSpec = tween(easing = FastOutSlowInEasing),
                                ) { -it / 5 } + fadeOut(tween(easing = EaseIn)),
                            )
                        },
                        label = "YaruMasterDetailPortrait",
                    ) { idx ->
                        pageBuilder(idx)
                    }
                }
            }
        }
    }

    // Keep an externally supplied controller in sync with the initial index
    // when the page is first composed.
    LaunchedEffect(ctrl) {
        // Defensive: respect the controller's own `length` so an `initialIndex >= ctrl.length` write does not trip its require.
        if (ctrl.index < 0 && initialIndex >= 0 && (ctrl.length == 0 || initialIndex < ctrl.length)) {
            ctrl.index = initialIndex
        }
    }
}
