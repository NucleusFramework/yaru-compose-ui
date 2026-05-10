package sample.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import dev.nucleusframework.yarucompose.widgets.YaruDialogSurface
import dev.nucleusframework.yarucompose.widgets.YaruDialogTitleBar
import dev.nucleusframework.yarucompose.widgets.YaruScrollViewUndershoot
import dev.nucleusframework.yarucompose.widgets.YaruSearchButton
import dev.nucleusframework.yarucompose.widgets.YaruSearchField
import dev.nucleusframework.yarucompose.widgets.YaruSearchTitleField
import dev.nucleusframework.yarucompose.widgets.YaruText

/**
 * Mirrors `yaru.dart/example/lib/pages/search_field_page.dart`.
 *
 * Two `SimpleDialog`s rendered inline in a scroll list:
 *  1. `YaruDialogTitleBar(titleSpacing: 0, centerTitle: true)` whose title is
 *     a [YaruSearchTitleField] — search button stacked over a 'Any Widget Here'
 *     label or an inline search field. Body shows the submitted text.
 *  2. Same chrome, but the title flips between a plain `Text('Title')` and a
 *     bare [YaruSearchField], driven by a leading [YaruSearchButton].
 *
 * Both cards use [YaruDialogSurface] to match Flutter's `SimpleDialog` chrome
 * (`_createDialogTheme` in common_themes.dart:318-330: `_createMenuBg`
 * background, 14 dp window radius, dark/HC border, Material 3 elevation 6).
 * `SimpleDialog`'s default body padding `EdgeInsets.fromLTRB(0, 12, 0, 16)`
 * applies around the 300×450 content box.
 */
@Composable
fun SearchFieldPage() {
    var titleSearchActive by remember { mutableStateOf(false) }
    var fieldSearchActive by remember { mutableStateOf(false) }
    var titleText by remember { mutableStateOf("The text you submitted") }
    var fieldText by remember { mutableStateOf("Or the things you changed") }

    val scrollState = rememberLazyListState()
    YaruScrollViewUndershoot(
        scrollableState = scrollState,
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(YaruConstants.PagePadding),
            // Each Flutter `SimpleDialog` wraps itself in `Dialog` which adds
            // `insetPadding: EdgeInsets.symmetric(horizontal: 40, vertical: 24)`
            // by default (material/dialog.dart `_defaultInsetPadding`). Two
            // stacked dialogs therefore show 24+24 = 48 dp of breathing room.
            verticalArrangement = Arrangement.spacedBy(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // search_field_page.dart:29-54 — first SimpleDialog with embedded
            // YaruSearchTitleField in its title bar.
            item {
                YaruDialogSurface(maxWidth = null) {
                    // `titlePadding: EdgeInsets.zero` — the title bar is
                    // edge-to-edge at the top of the dialog.
                    YaruDialogTitleBar(
                        centerTitle = true,
                        titleSpacing = 0.dp,
                        // `YaruDialogTitleBar` defaults `isClosable: true`
                        // (yaru_title_bar.dart:671). The Dart screenshot shows
                        // the X on the right of both cards.
                        isClosable = true,
                        onClose = {},
                        title = {
                            YaruSearchTitleField(
                                searchActive = titleSearchActive,
                                onSearchActive = { titleSearchActive = !titleSearchActive },
                                text = titleText,
                                onValueChange = { titleText = it },
                                onSubmitted = { titleText = it },
                                onClear = { titleText = "" },
                                title = { YaruText("Any Widget Here") },
                            )
                        },
                    )
                    // `SizedBox(height: 300, width: 450, child: Center(child: Text(_titleText)))`
                    // wrapped by `SimpleDialog`'s default contentPadding (0,12,0,16).
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 16.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Box(
                            modifier = Modifier.height(300.dp).width(450.dp),
                            contentAlignment = Alignment.Center,
                        ) { YaruText(titleText) }
                    }
                }
            }
            // search_field_page.dart:55-83 — second SimpleDialog with leading
            // YaruSearchButton flipping the title between Text and YaruSearchField.
            item {
                YaruDialogSurface(maxWidth = null) {
                    YaruDialogTitleBar(
                        centerTitle = true,
                        titleSpacing = 0.dp,
                        isClosable = true,
                        onClose = {},
                        leading = {
                            YaruSearchButton(
                                onPressed = { fieldSearchActive = !fieldSearchActive },
                                isSelected = fieldSearchActive,
                            )
                        },
                        title = {
                            if (fieldSearchActive) {
                                // No explicit width — Dart's `TextField` fills
                                // the centerTitle slot by intrinsic; let
                                // [YaruSearchField] do the same so the field
                                // matches the Dart visual.
                                YaruSearchField(
                                    value = fieldText,
                                    onValueChange = { fieldText = it },
                                    onClear = { /* Dart `onClear: () {}` */ },
                                )
                            } else {
                                YaruText("Title")
                            }
                        },
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 16.dp),
                        contentAlignment = Alignment.Center,
                    ) {
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
