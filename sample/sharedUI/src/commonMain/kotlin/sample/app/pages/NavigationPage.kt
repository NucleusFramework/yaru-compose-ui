package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBackButton
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTitleBar
import dev.nucleusframework.yarucompose.widgets.master_detail.YaruDetailPage

/**
 * Mirrors `yaru.dart/example/lib/pages/navigation_page.dart`.
 *
 * Dart pushes a chain of three routes via `Navigator`:
 *  - Page 1: padded centered `OutlinedButton('next page')` → push Page 2.
 *  - Page 2: `YaruDetailPage` with title bar (`YaruBackButton`, title `'Page 2'`)
 *    and centered `OutlinedButton('next page')` → push Page 3.
 *  - Page 3: `YaruDetailPage` with title bar (`YaruBackButton`, title `'Page 3'`)
 *    and centered `Text('this is the last page')`.
 *
 * commonMain has no built-in navigator, so we drive the same flow with an
 * integer depth state (`0..2`), matching the Dart back/next push semantics.
 */
@Composable
fun NavigationPage() {
    var depth by remember { mutableIntStateOf(0) }

    when (depth) {
        0 -> Page1(onNext = { depth = 1 })
        1 -> Page2(onBack = { depth = 0 }, onNext = { depth = 2 })
        else -> Page3(onBack = { depth = 1 })
    }
}

@Composable
private fun Page1(onNext: () -> Unit) {
    // `Padding(EdgeInsets.all(kYaruPagePadding), child: Center(child: OutlinedButton(...)))`
    // (navigation_page.dart:9-19).
    Box(
        modifier = Modifier.fillMaxSize().padding(YaruConstants.PagePadding),
        contentAlignment = Alignment.Center,
    ) {
        YaruOutlinedButton(onClick = onNext) { YaruText("next page") }
    }
}

@Composable
private fun Page2(onBack: () -> Unit, onNext: () -> Unit) {
    // `YaruDetailPage(appBar: YaruWindowTitleBar(leading: YaruBackButton(), title: Text('Page 2')))`
    // (navigation_page.dart:26-30).
    YaruDetailPage(
        appBar = {
            YaruTitleBar(
                leading = { YaruBackButton(onPressed = onBack) },
                title = { YaruText("Page 2") },
            )
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(YaruConstants.PagePadding),
            contentAlignment = Alignment.Center,
        ) {
            YaruOutlinedButton(onClick = onNext) { YaruText("next page") }
        }
    }
}

@Composable
private fun Page3(onBack: () -> Unit) {
    // `YaruDetailPage(appBar: YaruWindowTitleBar(leading: YaruBackButton(), title: Text('Page 3')))`
    // body: centered `Text('this is the last page')` (navigation_page.dart:49-58).
    YaruDetailPage(
        appBar = {
            YaruTitleBar(
                leading = { YaruBackButton(onPressed = onBack) },
                title = { YaruText("Page 3") },
            )
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(YaruConstants.PagePadding),
            contentAlignment = Alignment.Center,
        ) {
            YaruText("this is the last page")
        }
    }
}
