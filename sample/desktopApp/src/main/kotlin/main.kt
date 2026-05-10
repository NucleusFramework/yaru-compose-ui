import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import sample.app.App
import java.awt.Dimension

// Mirrors Dart `MaterialApp(title: 'Yaru')` (example_home.dart:71) for the
// app's window-manager title, plus the Linux runner's
// `gtk_window_set_default_size(window, 700, 720)` / `min_width = 500,
// min_height = 720` (linux/my_application.cc:50-55) for default + minimum
// window dimensions.
fun main() = application {
    Window(
        title = "Yaru",
        state = rememberWindowState(width = 700.dp, height = 720.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(500, 720)
        App()
    }
}