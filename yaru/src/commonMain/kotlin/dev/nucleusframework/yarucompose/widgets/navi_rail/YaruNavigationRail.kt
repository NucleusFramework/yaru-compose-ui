package dev.nucleusframework.yarucompose.widgets.navi_rail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.foundation.sanitiseColor
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme

/**
 * Vertical rail of navigation tiles, optional [leading] / [trailing] sections.
 *
 * Mirrors `yaru.dart/lib/src/widgets/navi_rail/yaru_navigation_rail.dart`.
 *
 * Visual contract:
 *  - Leading is wrapped in a 1-px bottom outline, with a 1-px gap below.
 *  - Trailing is wrapped in a 1-px top outline, with a 1-px gap above.
 *  - Background defaults to the parent navigation page's `sideBarColor`.
 */
@Composable
fun YaruNavigationRail(
    length: Int,
    selectedIndex: Int?,
    onDestinationSelected: (Int) -> Unit,
    itemBuilder: @Composable (index: Int, selected: Boolean, onTap: () -> Unit) -> Unit,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    sideBarColor: Color? = null,
) {
    // Defensive: tolerate transient empty / out-of-range states (e.g. data
    // loading, list shrinking). Dart's contract requires `length >= 2` and an
    // in-range selection, but in Compose those values are often data-driven
    // and would otherwise crash recomposition. We render nothing when
    // `length <= 0` and clamp `selectedIndex` to the valid range.
    if (length <= 0) return
    val safeSelectedIndex = selectedIndex?.takeIf { it in 0 until length }

    val scheme = LocalYaruColorScheme.current
    val outline = scheme.outline
    // Defensive: a caller-supplied `sideBarColor` with non-finite channels
    // (e.g. `Color.Unspecified`) would crash `Modifier.background` downstream.
    val background = sanitiseColor(sideBarColor ?: Color.Transparent)

    Column(
        modifier = modifier
            .fillMaxHeight()
            // Defensive: clamp the rail's width to its intrinsic content width — without this, `fillMaxWidth()` on the leading/trailing/divider boxes propagates the parent Row's full maxWidth, making the rail consume the entire row and leaving 0 width for the weighted page Box (compact-mode page rendered nothing).
            .width(IntrinsicSize.Min)
            .background(background)
            .padding(0.dp),
    ) {
        if (leading != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 1.dp),
            ) { leading() }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(outline),
            )
        }
        Box(
            modifier = Modifier.weight(1f).verticalScroll(rememberScrollState()),
        ) {
            Column {
                for (i in 0 until length) {
                    itemBuilder(i, i == safeSelectedIndex) { onDestinationSelected(i) }
                }
            }
        }
        if (trailing != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(outline),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp),
            ) { trailing() }
        }
    }
}
