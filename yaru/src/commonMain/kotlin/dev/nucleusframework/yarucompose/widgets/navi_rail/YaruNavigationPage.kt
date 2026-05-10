package dev.nucleusframework.yarucompose.widgets.navi_rail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.nucleusframework.yarucompose.foundation.YaruPageController
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.isLight
import dev.nucleusframework.yarucompose.themes.scale
import dev.nucleusframework.yarucompose.widgets.YaruVerticalDivider

/**
 * A page layout with a [YaruNavigationRail] on the left and a content pane on
 * the right. Mirrors
 * `yaru.dart/lib/src/widgets/navi_rail/yaru_navigation_page.dart`.
 *
 * The sidebar color follows `YaruNavigationPageThemeData.fallback`:
 *  - light: `surface.scale(lightness: -0.029)`
 *  - dark: `surface` (unchanged)
 */
@Composable
fun YaruNavigationPage(
    length: Int,
    itemBuilder: @Composable (index: Int, selected: Boolean, onTap: () -> Unit) -> Unit,
    pageBuilder: @Composable (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    initialIndex: Int = 0,
    controller: YaruPageController? = null,
    onSelected: ((Int) -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    includeSeparator: Boolean = true,
    sideBarColor: Color? = null,
    emptyContent: @Composable () -> Unit = {},
) {
    // Defensive: always call `remember` so slot positions stay stable when a caller swaps `controller` between null and non-null.
    val fallbackCtrl = remember(length) {
        YaruPageController(length = length, initialIndex = initialIndex)
    }
    val ctrl = controller ?: fallbackCtrl
    // Read the controller's index directly — `YaruPageController._index` is
    // backed by a mutableStateOf, so reading here keeps recomposition in sync
    // when an external caller writes `ctrl.index = …`. Defensive clamp into
    // [0, length) so `pageBuilder(selectedIndex)` can never receive an
    // out-of-range index when a caller-supplied controller has a different
    // `length` (or its `index` exceeds our `length`).
    val selectedIndex = if (length == 0) 0 else ctrl.index.coerceIn(0, length - 1)
    val select: (Int) -> Unit = {
        if (length > 0 && it in 0 until length) {
            // Only forward to the controller if its own length permits it,
            // otherwise its setter would throw.
            if (ctrl.length == 0 || it < ctrl.length) ctrl.index = it
            onSelected?.invoke(it)
        }
    }

    val scheme = LocalYaruColorScheme.current
    // Defensive: always call `remember` from a stable slot, then choose the value, so toggling `sideBarColor` between null/non-null never reshuffles the slot table.
    val fallbackSideBarColor = remember(scheme) {
        if (scheme.isLight) scheme.surface.scale(lightness = -0.029f) else scheme.surface
    }
    // Mirrors `YaruNavigationPageThemeData.fallback.sideBarColor`.
    // Defensive: a caller-supplied `sideBarColor` with non-finite channels
    // (e.g. `Color.Unspecified`) would crash `Modifier.background` downstream.
    val resolvedSideBarColor = sanitiseColor(sideBarColor ?: fallbackSideBarColor)

    Row(
        modifier = modifier
            .fillMaxSize()
            .background(resolvedSideBarColor),
    ) {
        if (length == 0) {
            Box(modifier = Modifier.fillMaxSize()) { emptyContent() }
        } else {
            YaruNavigationRail(
                length = length,
                selectedIndex = selectedIndex,
                onDestinationSelected = select,
                itemBuilder = { index, selected, onTap ->
                    itemBuilder(index, selected, onTap)
                },
                leading = leading,
                trailing = trailing,
                sideBarColor = resolvedSideBarColor,
            )
            if (includeSeparator) YaruVerticalDivider()
            Box(modifier = Modifier.weight(1f).fillMaxSize()) {
                pageBuilder(selectedIndex)
            }
        }
    }

    // Keep an externally supplied controller in sync with the initial index
    // when the page is first composed (mirrors `YaruMasterDetailPage`).
    LaunchedEffect(ctrl) {
        if (ctrl.index < 0 && initialIndex >= 0 && (ctrl.length == 0 || initialIndex < ctrl.length)) {
            ctrl.index = initialIndex
        }
    }
}
