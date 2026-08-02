import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import dev.nucleusframework.application.nucleusApplication
import dev.nucleusframework.yarucompose.window.YaruDecoratedWindow
import sample.app.App

// Title mirrors the Dart app title `'Yaru'` (example_home.dart:71). The window
// geometry does not: the Linux runner's `gtk_window_set_default_size(700, 720)`
// / `min_height = 720` (linux/my_application.cc:50-55) gave a narrow window
// pinned to its own height. A plain 1280x800 default over a 640x480 minimum
// leaves the master/detail gallery room to breathe and stays resizable.
//
// The window is client-side decorated by Nucleus: no system title bar, so the
// app's `YaruTitleBar` *is* the chrome — it drags the window, while Nucleus
// draws the control buttons over it in the platform's own style.
fun main() = nucleusApplication {
    YaruDecoratedWindow(
        title = "Yaru",
        state = rememberWindowState(
            size = DpSize(1280.dp, 800.dp),
            position = WindowPosition(Alignment.Center),
        ),
        minimumSize = DpSize(640.dp, 480.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}
