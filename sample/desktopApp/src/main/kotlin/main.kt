import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.rememberWindowState
import dev.nucleusframework.application.nucleusApplication
import dev.nucleusframework.yarucompose.window.YaruDecoratedWindow
import sample.app.App

// Mirrors the Dart app title `'Yaru'` (example_home.dart:71) for the
// app's window-manager title, plus the Linux runner's
// `gtk_window_set_default_size(window, 700, 720)` / `min_width = 500,
// min_height = 720` (linux/my_application.cc:50-55) for default + minimum
// window dimensions.
//
// The window is client-side decorated by Nucleus: no system title bar, so the
// app's `YaruTitleBar` *is* the chrome — it drags the window and hosts the
// control buttons, drawn in Yaru style but ordered by the desktop.
fun main() = nucleusApplication {
    YaruDecoratedWindow(
        title = "Yaru",
        state = rememberWindowState(width = 700.dp, height = 720.dp),
        minimumSize = DpSize(500.dp, 720.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}
