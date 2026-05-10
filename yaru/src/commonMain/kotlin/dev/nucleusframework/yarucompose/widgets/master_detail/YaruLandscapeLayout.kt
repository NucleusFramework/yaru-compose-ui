package dev.nucleusframework.yarucompose.widgets.master_detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale
import dev.nucleusframework.yarucompose.widgets.YaruFixedPaneDelegate
import dev.nucleusframework.yarucompose.widgets.YaruPaneSide
import dev.nucleusframework.yarucompose.widgets.YaruPanedView
import dev.nucleusframework.yarucompose.widgets.YaruPanedViewLayoutDelegate

/**
 * Landscape master/detail layout — exposed for advanced users who want to
 * skip [YaruMasterDetailPage]'s breakpoint logic.
 *
 * Mirrors `yaru.dart/lib/src/widgets/master_detail/yaru_landscape_layout.dart`.
 */
@Composable
fun YaruLandscapeLayout(
    length: Int,
    selectedIndex: Int,
    tileBuilder: @Composable (index: Int, selected: Boolean, onTap: () -> Unit) -> Unit,
    pageBuilder: @Composable (index: Int) -> Unit,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    paneLayoutDelegate: YaruPanedViewLayoutDelegate = YaruFixedPaneDelegate(
        paneSize = 280.dp,
        paneSide = YaruPaneSide.Start,
    ),
    includeSeparator: Boolean = true,
    appBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    emptyContent: @Composable () -> Unit = {},
) {
    val scheme = LocalYaruColorScheme.current
    // `YaruMasterDetailThemeData.fallback.sideBarColor`.
    val sideBarColor = remember(scheme) {
        scheme.surface.scale(lightness = if (scheme.isLight) -0.029f else 0.029f)
    }

    YaruPanedView(
        layoutDelegate = paneLayoutDelegate,
        modifier = modifier.fillMaxSize(),
        includeSeparator = includeSeparator,
        pane = {
            // Sidebar tint applied to the entire pane, matching Dart's
            // `Container(color: theme.sideBarColor)`.
            Column(modifier = Modifier.fillMaxSize().background(sideBarColor)) {
                appBar?.invoke()
                Box(modifier = Modifier.weight(1f)) {
                    YaruMasterListView(length = length) { index ->
                        tileBuilder(index, index == selectedIndex) { onSelected(index) }
                    }
                }
                bottomBar?.invoke()
            }
        },
        page = {
            // Detail page background mirrors `Material(color: surface)` from
            // `YaruDetailPage`. Animate index changes with vertical slides per
            // `landscapeTransitions = vertical` in yaru.dart's theme fallback.
            Box(modifier = Modifier.fillMaxSize().background(scheme.surface)) {
                if (length <= 0) {
                    emptyContent()
                } else {
                    // Defensive: clamp to `[0, length - 1]` so a stale `selectedIndex` past the list end never reaches `pageBuilder`.
                    AnimatedContent(
                        targetState = selectedIndex.coerceIn(0, length - 1),
                        transitionSpec = {
                            // Mirrors `_YaruVerticalPageTransitions` — see page_transitions.dart.
                            //   incoming slide: Offset(0.0, 0.1) -> Offset.zero (fastOutSlowIn)
                            //   outgoing slide: none (Offset.zero -> Offset.zero)
                            (
                                slideInVertically(
                                    animationSpec = tween(easing = FastOutSlowInEasing),
                                ) { it / 10 } + fadeIn(tween(easing = EaseIn))
                            ).togetherWith(fadeOut(tween()))
                        },
                        label = "YaruLandscapeLayout",
                    ) { idx ->
                        pageBuilder(idx)
                    }
                }
            }
        },
    )
}
