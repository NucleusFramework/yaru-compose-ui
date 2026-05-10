package dev.nucleusframework.yarucompose.widgets.master_detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale

/**
 * Portrait master/detail layout — exposed for advanced users who want to
 * skip [YaruMasterDetailPage]'s breakpoint logic.
 *
 * Mirrors `yaru.dart/lib/src/widgets/master_detail/yaru_portrait_layout.dart`.
 *
 * Pass `selectedIndex < 0` to show the master list; otherwise the detail page
 * for [selectedIndex] is rendered full-width.
 */
@Composable
fun YaruPortraitLayout(
    length: Int,
    selectedIndex: Int,
    tileBuilder: @Composable (index: Int, selected: Boolean, onTap: () -> Unit) -> Unit,
    pageBuilder: @Composable (index: Int) -> Unit,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    appBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
) {
    val scheme = LocalYaruColorScheme.current
    val sideBarColor = remember(scheme) {
        scheme.surface.scale(lightness = if (scheme.isLight) -0.029f else 0.029f)
    }

    if (selectedIndex < 0 || selectedIndex >= length) {
        // Master list — Dart wraps this in `Scaffold(backgroundColor: theme.sideBarColor)`.
        Column(modifier = modifier.fillMaxSize().background(sideBarColor)) {
            appBar?.invoke()
            Box(modifier = Modifier.weight(1f)) {
                YaruMasterListView(length = length) { index ->
                    tileBuilder(index, index == selectedIndex) { onSelected(index) }
                }
            }
            bottomBar?.invoke()
        }
    } else {
        // Detail — `portraitTransitions = horizontal` slide.
        Box(modifier = modifier.fillMaxSize().background(scheme.surface)) {
            AnimatedContent(
                targetState = selectedIndex,
                transitionSpec = {
                    // Mirrors `_YaruHorizontalPageTransitions` — page_transitions.dart:
                    //   incoming: Offset(0.2, 0.0) -> Offset.zero (fastOutSlowIn), opacity easeIn
                    //   outgoing: Offset.zero -> Offset(-0.2, 0.0) (fastOutSlowIn), opacity easeIn
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
                label = "YaruPortraitLayout",
            ) { idx ->
                pageBuilder(idx)
            }
        }
    }
}
