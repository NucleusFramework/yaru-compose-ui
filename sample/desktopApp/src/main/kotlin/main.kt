import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberDialogState
import androidx.compose.ui.window.rememberWindowState
import dev.nucleusframework.application.nucleusApplication
import dev.nucleusframework.yarucompose.widgets.YaruText
import dev.nucleusframework.yarucompose.window.YaruDecoratedDialog
import dev.nucleusframework.yarucompose.window.YaruDecoratedDialogTitleBar
import dev.nucleusframework.yarucompose.window.YaruDecoratedWindow
import sample.app.App
import sample.app.LocalNativeDialogHost
import sample.app.NativeDialogHost

// Title mirrors the Dart app title `'Yaru'` (example_home.dart:71). The window
// geometry does not: the Linux runner's `gtk_window_set_default_size(700, 720)`
// / `min_height = 720` (linux/my_application.cc:50-55) gave a narrow window
// pinned to its own height. A plain 1280x800 default over a 640x480 minimum
// leaves the master/detail gallery room to breathe and stays resizable.
//
// The window is client-side decorated by Nucleus: no system title bar, so the
// app's `YaruTitleBar` *is* the chrome, while Nucleus draws the control buttons
// over it in the platform's own style.
fun main() = nucleusApplication {
    // `YaruDecoratedDialog` is an extension on this application scope, which the
    // composition cannot reach — hand the shared UI a factory instead, so its
    // Settings dialog opens as a real native child window here (native close
    // button included) and degrades to a Compose `Dialog` on mobile and web.
    val nativeDialogHost = remember {
        object : NativeDialogHost {
            @Composable
            override fun Dialog(
                title: String,
                onCloseRequest: () -> Unit,
                content: @Composable () -> Unit,
            ) {
                YaruDecoratedDialog(
                    onCloseRequest = onCloseRequest,
                    state = rememberDialogState(size = DpSize(420.dp, 340.dp)),
                    title = title,
                ) {
                    YaruDecoratedDialogTitleBar { YaruText(title) }
                    content()
                }
            }
        }
    }

    YaruDecoratedWindow(
        title = "Yaru",
        state = rememberWindowState(
            size = DpSize(1280.dp, 800.dp),
            position = WindowPosition(Alignment.Center),
        ),
        minimumSize = DpSize(640.dp, 480.dp),
        onCloseRequest = ::exitApplication,
    ) {
        CompositionLocalProvider(LocalNativeDialogHost provides nativeDialogHost) {
            App()
        }
    }
}
