package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBorderContainer
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSearchButton
import dev.nucleusframework.yarucompose.widgets.YaruSearchField
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.widgets.YaruTitleBar

/**
 * Mirrors `yaru.dart/example/lib/pages/search_field_page.dart`.
 *
 * Dart renders two `SimpleDialog`s stacked in a `ListView`:
 *  1. `YaruSearchTitleField` embedded inside a `YaruDialogTitleBar` — always
 *     shows the search input. Submitting updates `_titleText`; the body shows
 *     that text in a 300x450 area.
 *  2. `YaruDialogTitleBar` whose `title` toggles between a plain Text label
 *     and `YaruSearchField` based on `_fieldSearchActive`. The title bar
 *     `leading` is a `YaruSearchButton` that flips that flag.
 *
 * `SimpleDialog` has no commonMain equivalent, so we use `YaruBorderContainer`
 * as the shell and `YaruTitleBar` as the bar — visually equivalent for the
 * purpose of this sample.
 */
@Composable
fun SearchFieldPage() {
    // `String _titleText = 'The text you submitted';` (search_field_page.dart:15).
    var titleText by remember { mutableStateOf("The text you submitted") }
    // `String _fieldText = 'Or the things you changed';` (search_field_page.dart:16).
    var fieldText by remember { mutableStateOf("Or the things you changed") }
    var fieldSearchActive by remember { mutableStateOf(false) }

    val scrollState = rememberLazyListState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // First dialog — search title field always visible (search_field_page.dart:29-54).
            item {
                // `clipContent = true`: the inner `YaruTitleBar` paints a solid
                // surface rectangle that would otherwise overflow the rounded
                // corners (Dart's `SimpleDialog` clips via `Material(clip: antiAlias)`).
                YaruBorderContainer(clipContent = true) {
                    Column {
                        YaruTitleBar(
                            centerTitle = true,
                            titleSpacing = 0.dp,
                            title = {
                                YaruSearchField(
                                    value = titleText,
                                    onValueChange = { titleText = it },
                                    onSubmitted = { titleText = it },
                                    onClear = { titleText = "" },
                                    placeholder = "Any Widget Here",
                                    autoFocus = false,
                                )
                            },
                        )
                        // `SizedBox(height: 300, width: 450, child: Center(child: Text(_titleText)))`
                        // (search_field_page.dart:48-52).
                        Box(
                            modifier = Modifier.height(300.dp).width(450.dp),
                            contentAlignment = Alignment.Center,
                        ) { YaruText(titleText) }
                    }
                }
            }
            item { Spacer(Modifier.height(0.dp)) }
            // Second dialog — title flips between plain text and search field via leading button
            // (search_field_page.dart:55-83).
            item {
                // `clipContent = true` — same rationale as the first dialog above.
                YaruBorderContainer(clipContent = true) {
                    Column {
                        YaruTitleBar(
                            centerTitle = true,
                            titleSpacing = 0.dp,
                            leading = {
                                YaruSearchButton(
                                    onPressed = { fieldSearchActive = !fieldSearchActive },
                                    isSelected = fieldSearchActive,
                                )
                            },
                            title = {
                                if (fieldSearchActive) {
                                    YaruSearchField(
                                        value = fieldText,
                                        onValueChange = { fieldText = it },
                                        onClear = { /* Dart `onClear: () {}` — no-op */ },
                                        autoFocus = false,
                                    )
                                } else {
                                    YaruText("Title")
                                }
                            },
                        )
                        Box(
                            modifier = Modifier.height(300.dp).width(450.dp),
                            contentAlignment = Alignment.Center,
                        ) { YaruText(fieldText) }
                    }
                }
            }
        }
    }
}
