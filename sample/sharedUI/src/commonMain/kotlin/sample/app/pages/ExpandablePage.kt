package sample.app.pages

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import dev.nucleusframework.yarucompose.widgets.YaruText
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruExpandable
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot

// Mirrors `_lorem` from `yaru.dart/example/lib/pages/expandable_page.dart`:
// three concatenated copies of the standard Lorem block so the expanded /
// collapsed states have enough text to actually showcase the size animation
// and the maxLines-5 ellipsis on the collapsed child.
private val ExpandablePageLorem: String =
    (SampleLorem + " " + SampleLorem + " " + SampleLorem)

@Composable
fun ExpandablePage() {
    val scrollState = rememberLazyListState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
        ) {
            // Mirrors the first `YaruExpandable` from `expandable_page.dart`:
            // collapsed by default, `usePadding: true`, header in bold.
            item {
                YaruExpandable(
                    usePadding = true,
                    header = { YaruText("Lorem ipsum dolor sit amet", fontWeight = FontWeight.Bold) },
                ) { YaruText(ExpandablePageLorem) }
            }
            // Second example: pre-expanded with a 5-line ellipsised collapsed
            // preview. Dart uses `TextOverflow.fade` here; Compose's
            // `TextOverflow.Ellipsis` is the closest single-line overflow that
            // works with `maxLines` (Compose has no `Fade` overflow in
            // commonMain).
            item {
                YaruExpandable(
                    isExpanded = true,
                    usePadding = true,
                    header = { YaruText("Lorem ipsum dolor sit amet", fontWeight = FontWeight.Bold) },
                    collapsedContent = {
                        YaruText(ExpandablePageLorem, maxLines = 5, overflow = TextOverflow.Ellipsis)
                    },
                ) { YaruText(ExpandablePageLorem) }
            }
        }
    }
}
