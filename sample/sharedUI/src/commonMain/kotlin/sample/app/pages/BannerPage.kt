package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBannerTile
import dev.nucleusframework.yarucompose.widgets.YaruDialog
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruWatermark
import kotlin.math.ceil
import kotlin.math.max

/**
 * Mirrors Flutter's `SliverGridDelegateWithMaxCrossAxisExtent`: pick the
 * smallest column count whose per-column extent is <= [maxCrossAxisExtent],
 * then divide the available width evenly. Algorithm copied from Flutter's
 * `SliverGridDelegateWithMaxCrossAxisExtent.getLayout` (sliver_grid.dart):
 *
 *   crossAxisCount = ceil(crossAxisExtent / (maxCrossAxisExtent + crossAxisSpacing))
 *   usable = max(0, crossAxisExtent - crossAxisSpacing * (crossAxisCount - 1))
 *   childCrossAxisExtent = usable / crossAxisCount
 *
 * Used by banner_page.dart L19-24 (`maxCrossAxisExtent: 550`,
 * `crossAxisSpacing: 15`).
 */
private class MaxCrossAxisExtentCells(
    private val maxCrossAxisExtent: androidx.compose.ui.unit.Dp,
    private val crossAxisSpacing: androidx.compose.ui.unit.Dp,
) : GridCells {
    override fun Density.calculateCrossAxisCellSizes(
        availableSize: Int,
        spacing: Int,
    ): List<Int> {
        val maxExtentPx = maxCrossAxisExtent.toPx()
        val spacingPx = crossAxisSpacing.toPx()
        val count = max(
            1,
            ceil(availableSize.toFloat() / (maxExtentPx + spacingPx)).toInt(),
        )
        val usable = max(0f, availableSize - spacingPx * (count - 1))
        val cell = (usable / count).toInt()
        return List(count) { cell }
    }
}

@Composable
fun BannerPage() {
    val scrollState = rememberLazyGridState()
    // Dart `YaruScrollViewUndershoot.builder(endUndershoot: false, ...)` from
    // banner_page.dart L12-13 — only the top edge fades.
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
        showEnd = false,
    ) {
        LazyVerticalGrid(
            state = scrollState,
            // SliverGridDelegateWithMaxCrossAxisExtent(maxCrossAxisExtent: 550)
            // from banner_page.dart L23. Also crossAxisSpacing: 15 (L22).
            columns = MaxCrossAxisExtentCells(
                maxCrossAxisExtent = 550.dp,
                crossAxisSpacing = 15.dp,
            ),
            // EdgeInsets.all(kYaruPagePadding) from banner_page.dart L17 (= 20).
            contentPadding = PaddingValues(YaruConstants.PagePadding),
            // crossAxisSpacing: 15 from banner_page.dart L22.
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            // mainAxisSpacing: 15 from banner_page.dart L21.
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            // Defensive: pass a key so each cell's hover/dialog state stays bound to its index across reorders.
            items((0 until 20).toList(), key = { it }) { index ->
                // mainAxisExtent: 200 from banner_page.dart L20 — enforced per-cell.
                // The 200dp height is propagated to YaruWatermark + YaruBanner via
                // `fillMaxSize` so the banner inside the cell stretches to match
                // Flutter's `Container(height: double.infinity)` (yaru_banner.dart L118).
                Box(modifier = Modifier.height(200.dp)) {
                    YaruWatermark(
                        modifier = Modifier.fillMaxSize(),
                        // Icon(YaruIcons.cloud, size: 100) from banner_page.dart L28.
                        watermark = { YaruIcon(YaruIcons.cloud, size = 100.dp) },
                    ) {
                        BannerEntry(index = index)
                    }
                }
            }
        }
    }
}

@Composable
private fun BannerEntry(index: Int) {
    var hovered by remember { mutableStateOf(false) }
    var dialogOpen by remember { mutableStateOf(false) }
    val title = "YaruBanner $index"
    val scheme = LocalYaruColorScheme.current

    val description: @Composable () -> Unit = if (hovered) {
        // SizedBox(width: 200, height: 100, child: Text(_lorem)) from banner_page.dart L54.
        { Box(modifier = Modifier.size(width = 200.dp, height = 100.dp)) { YaruText(SampleLorem) } }
    } else {
        // Text('Description', overflow: TextOverflow.ellipsis) from banner_page.dart L55.
        { YaruText("Description", maxLines = 1, overflow = TextOverflow.Ellipsis) }
    }

    YaruBannerTile(
        // Fill the 200dp grid cell — opt-in for the parent's bounded height,
        // mirroring Dart `Container(height: double.infinity)` in yaru_banner.dart L118.
        modifier = Modifier.fillMaxSize(),
        title = { YaruText(title) },
        icon = if (!hovered) {
            {
                YaruIcon(
                    glyph = YaruIcons.sun,
                    // Icon(YaruIcons.sun, size: 80) from banner_page.dart L59.
                    size = 80.dp,
                    tint = scheme.primary,
                )
            }
        } else {
            null
        },
        subtitle = {
            Column {
                description()
                if (!hovered) YaruText("Third line")
            }
        },
        onTap = { dialogOpen = true },
        onHover = { hovered = it },
        // i.isEven ? Colors.pink : null from banner_page.dart L80. The Flutter
        // constant `Colors.pink` resolves to this exact ARGB (#FFE91E63).
        surfaceTintColor = if (index % 2 == 0) Color(0xFFE91E63) else null,
    )

    if (dialogOpen) {
        // Mirrors Dart's `SimpleDialog(titlePadding: zero, contentPadding: 10,
        // title: YaruDialogTitleBar(title))` (banner_page.dart L70-78).
        // Reuses YaruDialog so the inline banner dialog inherits the same
        // 200ms fade + scale-1.3 transition as every other Yaru dialog
        // (matches Flutter's default dialog transition builder).
        YaruDialog(
            onDismissRequest = { dialogOpen = false },
            title = { YaruText(title) },
            // contentPadding: EdgeInsets.all(10) from banner_page.dart L73.
            contentPadding = PaddingValues(10.dp),
        ) {
            // Padding(EdgeInsets.all(8.0)) from banner_page.dart L76.
            Box(modifier = Modifier.padding(8.dp)) { description() }
        }
    }
}
