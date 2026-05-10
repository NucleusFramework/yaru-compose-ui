package sample.app.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.nucleusframework.yarucompose.themes.LocalYaruColorScheme
import dev.nucleusframework.yarucompose.themes.LocalYaruTypography
import dev.nucleusframework.yarucompose.themes.YaruConstants
import dev.nucleusframework.yarucompose.widgets.YaruBannerTile
import dev.nucleusframework.yarucompose.widgets.YaruCircularProgressIndicator
import dev.nucleusframework.yarucompose.widgets.YaruDialog
import dev.nucleusframework.yarucompose.widgets.YaruListTile
import dev.nucleusframework.yarucompose.widgets.YaruOutlinedButton
import dev.nucleusframework.yarucompose.widgets.YaruSwitch
import dev.nucleusframework.yarucompose.widgets.YaruText

/**
 * Mirrors `yaru.dart/example/lib/pages/dialog_page.dart`.
 *
 * Dart renders a 400-wide column with kYaruPagePadding holding two list tiles:
 *  - "YaruDialogTitleBar" — opens a `SimpleDialog`/`AlertDialog` whose title is a
 *    `YaruDialogTitleBar` with a 25-dp circular progress indicator (strokeWidth 3)
 *    as `leading`. The dialog body is a `SizedBox(height: 100, child: YaruBanner.tile)`
 *    with `surfaceTintColor: Colors.pink` and an icon emoji at fontSize 30.
 *  - "isCloseable" — a `YaruSwitch` that toggles `barrierDismissible` and the
 *    dialog's `isClosable`.
 */
@Composable
fun DialogPage() {
    var isCloseable by remember { mutableStateOf(true) }
    var dialogOpen by remember { mutableStateOf(false) }

    val scheme = LocalYaruColorScheme.current
    val typography = LocalYaruTypography.current

    Column(
        modifier = Modifier
            .width(400.dp)
            .padding(YaruConstants.PagePadding),
    ) {
        YaruListTile(
            title = { YaruText("YaruDialogTitleBar") },
            trailing = {
                YaruOutlinedButton(onClick = { dialogOpen = true }) { YaruText("Open dialog") }
            },
        )
        YaruListTile(
            title = { YaruText("isCloseable") },
            trailing = {
                YaruSwitch(checked = isCloseable, onCheckedChange = { isCloseable = it })
            },
        )
    }

    if (dialogOpen) {
        YaruDialog(
            onDismissRequest = { if (isCloseable) dialogOpen = false },
            isClosable = isCloseable,
            onClose = { dialogOpen = false },
            // `Center(child: SizedBox.square(dimension: 25, child: YaruCircularProgressIndicator(strokeWidth: 3)))`
            // (dialog_page.dart:43-50).
            titleLeading = {
                Box(
                    modifier = Modifier.size(25.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    YaruCircularProgressIndicator(strokeWidth = 3.dp)
                }
            },
            title = { YaruText("The Title") },
            actions = if (!isCloseable) {
                {
                    YaruOutlinedButton(onClick = { dialogOpen = false }) {
                        YaruText("Evil Force-Close", color = scheme.error)
                    }
                }
            } else {
                null
            },
        ) {
            // `SizedBox(height: 100, child: YaruBanner.tile(surfaceTintColor: Colors.pink, ...))`
            // (dialog_page.dart:54-69). `SizedBox` applies a tight 100-dp height
            // constraint to the child; in Compose we pass the same constraint
            // directly via `Modifier.fillMaxWidth().height(100.dp)` so the
            // banner's outer chrome actually fills the 100-dp slot rather than
            // wrapping its intrinsic content height.
            YaruBannerTile(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                title = {
                    YaruText(
                        if (isCloseable) "You can close me" else "You cannot close me",
                    )
                },
                subtitle = { YaruText(if (isCloseable) "Please" else "No way") },
                icon = {
                    // `Text(emoji, style: TextStyle(fontSize: 30))` ⇒ headlineSmall.
                    YaruText(
                        if (isCloseable) "🪟" else "💅",
                        style = typography.headlineSmall,
                    )
                },
                surfaceTintColor = Color(0xFFE91E63),
            )
        }
    }
}
