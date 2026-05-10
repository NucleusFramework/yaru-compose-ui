package sample.app.pages

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruColorOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruOptionButton
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot

@Composable
fun OptionButtonPage() {
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
            item {
                Row {
                    // `YaruIcons.search` (option_button_page.dart:24).
                    YaruOptionButton(onPressed = {}) {
                        YaruIcon(YaruIcons.search)
                    }
                    Spacer(Modifier.width(10.dp))
                    // `YaruIcons.music_note` (option_button_page.dart:29).
                    YaruOptionButton(onPressed = {}) {
                        YaruIcon(YaruIcons.music_note)
                    }
                    Spacer(Modifier.width(10.dp))
                    // `YaruIcons.address_book` (option_button_page.dart:34).
                    YaruOptionButton(onPressed = {}) {
                        YaruIcon(YaruIcons.address_book)
                    }
                    Spacer(Modifier.width(10.dp))
                    YaruColorOptionButton(
                        color = LocalYaruColorScheme.current.primary,
                        onPressed = {},
                    )
                }
            }
        }
    }
}
