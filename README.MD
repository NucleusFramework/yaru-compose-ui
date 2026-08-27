# Yaru Compose UI

A Compose Multiplatform port of [yaru.dart](https://github.com/ubuntu/yaru.dart), Ubuntu's design system.
It brings the GNOME/Yaru design language — widgets, accent variants, the Ubuntu font — to Android, iOS,
Desktop and Web through Compose Multiplatform.

[![Kotlin](https://img.shields.io/badge/Kotlin-2.4.10-7F52FF.svg?logo=kotlin)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose_Multiplatform-1.12.0-4285F4.svg?logo=jetpackcompose)](https://www.jetbrains.com/compose-multiplatform/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

[Documentation & Live Demo](https://nucleusframework.github.io/yaru-compose-ui/)

## Features

- **50+ widgets** — Buttons, switches, tiles, dialogs, navigation rail, master/detail, carousel, and more
- **29 accent variants** — The full Yaru palette (Orange, Bark, Sage, …) plus the Adwaita and Ubuntu flavour accents
- **Light, dark & high contrast** — Four ready-made themes, with system dark mode and system accent detection
- **RTL support** — Every widget is mirrored, including the window chrome
- **Compose Multiplatform** — Runs on Android, iOS, Desktop (JVM) and Web (JS/Wasm)
- **Decorated window** — GNOME-style client-side decorated desktop window and dialogs
- **No Material dependency** — Foundation-only: `compose.runtime`, `compose.ui`, `compose.foundation`
- **Faithful to `yaru.dart`** — Metrics, colors and behaviour are ported from the Dart source, widget by widget

## Supported Platforms

| Platform | Status |
|----------|--------|
| Android  | ✓      |
| iOS      | ✓      |
| Desktop (JVM) | ✓ |
| Web (JS) | ✓      |
| Web (Wasm) | ✓    |

## Artifacts

| Artifact | Targets | Contents |
|----------|---------|----------|
| `dev.nucleusframework.yarucompose:yaru` | Android, JVM, JS, Wasm, iOS | The design system: widgets, themes, foundation, core icons |
| `dev.nucleusframework.yarucompose:yaru-icons-extended` | Android, JVM, JS, Wasm, iOS | The full-colour Yaru icon theme as `ImageVector`s |
| `dev.nucleusframework.yarucompose:yaru-decorated-window` | JVM | Client-side decorated desktop window and dialog, backed by Nucleus |

`yaru` stays design-only: the widgets talk to a windowing layer through the optional `CompositionLocal`s
in `window/WindowIntegration.kt`, and behave normally when nothing provides them. `yaru-decorated-window`
is what fulfils those contracts — it is a separate artifact because it drags in Nucleus and its native
windowing binaries (~30 MB of per-platform natives), which an app drawing into a plain Compose `Window`
has no use for.

## Quick Start

### 1. Add the dependency

```kotlin
// build.gradle.kts
kotlin {
    sourceSets {
        commonMain.dependencies {
            // Design system only — no native windowing.
            implementation("dev.nucleusframework.yarucompose:yaru:<version>")
        }
    }
}
```

### 2. Wrap your app with YaruTheme

```kotlin
import dev.nucleusframework.yarucompose.themes.YaruTheme
import dev.nucleusframework.yarucompose.themes.YaruVariant

@Composable
fun App() {
    YaruTheme(
        isDark = false,
        highContrast = false,
        variant = YaruVariant.Orange,
    ) {
        // Your content here
        // Design tokens: LocalYaruColorScheme.current, LocalYaruTypography.current, …
    }
}
```

`YaruLightTheme`, `YaruDarkTheme`, `YaruHighContrastLightTheme` and `YaruHighContrastDarkTheme` are
shorthands for the four combinations. To follow the desktop, feed the theme from
`yaruSystemInDarkMode()` and `yaruSystemAccentVariant()` — on the JVM both read the real GNOME/Windows
setting through Nucleus and recompose when the user flips it.

### 3. Use widgets

```kotlin
import dev.nucleusframework.yarucompose.icons.YaruIcon
import dev.nucleusframework.yarucompose.icons.YaruIcons
import dev.nucleusframework.yarucompose.widgets.*

@Composable
fun MyApp() {
    var notifications by remember { mutableStateOf(true) }

    Column {
        YaruTitleBar(
            title = { YaruText("Settings") },
            actions = {
                YaruIconButton(onPressed = { /* ... */ }) { YaruIcon(YaruIcons.menu) }
            },
        )
        YaruSection(headline = { YaruText("General") }) {
            YaruSwitchListTile(
                value = notifications,
                onChanged = { notifications = it },
                title = { YaruText("Notifications") },
            )
        }
        YaruButton(
            onClick = { /* ... */ },
            variant = YaruButtonVariant.Elevated,
        ) { YaruText("Apply") }
    }
}
```

The [live gallery](https://nucleusframework.github.io/yaru-compose-ui/) shows every widget next to the
exact source that produced it.

## Desktop: the decorated window

On the desktop, GNOME chrome is not something Compose can draw on its own: the window controls, the
window corner radius and the window background are native surfaces. `YaruDecoratedWindow` wraps
[Nucleus](https://github.com/NucleusFramework)' `DecoratedWindow` (Tao backend — no AWT) and reproduces
a real GNOME client-side decorated window:

- The window has no system title bar: the app's `YaruTitleBar` *is* the chrome. It drags the window by
  its background and double-click toggles maximize.
- The window controls are drawn by Nucleus in the platform's own style (Adwaita / Breeze on Linux,
  Fluent on Windows, native traffic lights on macOS) and follow the desktop's `button-layout` for order
  and side, with the maximize/restore swap and close routed through `onCloseRequest`.
- The native window background follows `YaruTheme`, so resizing never flashes a white edge.
- `YaruDecoratedDialog` gives the same treatment to secondary windows.

### Gradle setup

The desktop entry point runs inside `nucleusApplication`, which needs the Nucleus Gradle plugin.

```kotlin
// build.gradle.kts
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("dev.nucleusframework") version "<nucleus-version>"
}

nucleus.application {
    mainClass = "com.example.app.MainKt"

    nativeDistributions {
        targetFormats(TargetFormat.Dmg, TargetFormat.Nsis, TargetFormat.Deb)
        packageName = "com.example.app"
        packageVersion = "1.0.0"
    }
}
```

`yaru-decorated-window` already exposes `nucleus.decorated-window-tao` and `nucleus.nucleus-application`
as `api` dependencies, so no extra runtime dependency is required:

```kotlin
// Brings `yaru` along transitively.
implementation("dev.nucleusframework.yarucompose:yaru-decorated-window:<version>")
```

### Entry point

```kotlin
import dev.nucleusframework.application.nucleusApplication
import dev.nucleusframework.yarucompose.window.YaruDecoratedWindow

fun main() = nucleusApplication {
    YaruDecoratedWindow(
        onCloseRequest = ::exitApplication,
        title = "My App",
    ) {
        App() // YaruTheme lives inside the window content
    }
}
```

`YaruTheme` must be inside the window content: the window sits above the theme and receives the resolved
color scheme and layout direction from it, which is what keeps the native surfaces in sync.

### Parameters

| Parameter | Default | Description |
|-----------|---------|-------------|
| `onCloseRequest` | — | Invoked when the user closes the window |
| `state` | `rememberWindowState()` | Position, size and maximized/minimized state |
| `visible` | `true` | Window visibility |
| `title` | `""` | Window title (shown in the Dock / taskbar) |
| `icon` | `null` | Window icon `Painter` |
| `resizable` | `true` | When `false`, the maximize button is dropped |
| `enabled` | `true` | Whether the window accepts input |
| `focusable` | `true` | Whether the window can take focus |
| `alwaysOnTop` | `false` | Keep the window above others |
| `hiddenFromDock` | `false` | Hide from the Dock/taskbar while staying visible and focusable (Linux: X11/XWayland only) |
| `nativePopupLayers` | `false` | Materialise Compose `Popup` layers as native windows so menus can escape the window bounds |
| `minimumSize` | `null` | Minimum `DpSize` |
| `onPreviewKeyEvent` / `onKeyEvent` | `{ false }` | Window-level key handling |
| `titleBarHeight` | `YaruConstants.TitleBarHeight` | Height of the native title bar band; match it to the `YaruTitleBar` you compose |

The `content` lambda is a `NucleusDecoratedWindowScope`, so it can reach the window state and the
Nucleus chrome APIs.

## Run the sample app

- Desktop (JVM): `./gradlew :sample:desktopApp:run`
- Android: open the project in Android Studio and run `sample/androidApp`
- iOS: open `sample/iosApp/iosApp.xcodeproj` in Xcode and run
- Web (JS): `./gradlew :sample:webApp:jsBrowserDevelopmentRun`
- Web (Wasm): `./gradlew :sample:webApp:wasmJsBrowserDevelopmentRun`

The Wasm sample is what gets deployed to the [live demo](https://nucleusframework.github.io/yaru-compose-ui/)
on every push to `main`.

## Contributing

Every gallery page shows a live preview next to the exact source that produced it. The snippet is not
written by hand: `:sample:galleryKsp` reads each `@GalleryExample` composable back from disk at compile
time and emits its body as `GallerySources.<functionName>`, so preview and code can never drift apart.

To add an example:

```kotlin
@GalleryExample("YaruSwitch", "States")
@Composable
private fun SwitchStatesExample() {
    var checked by remember { mutableStateOf(true) }
    YaruSwitch(checked = checked, onCheckedChange = { checked = it })
}

// …then render it from the page:
ExampleCard(
    title = "States",
    sourceCode = GallerySources.SwitchStatesExample,
) { SwitchStatesExample() }
```

Keep the example self-contained — its body is what the user copies. Function names must be unique across
the module; the processor fails the build on collisions.

## License

Yaru Compose UI is available under the [MIT License](LICENSE).

The bundled Yaru icon artwork and the Ubuntu font family keep their own licenses — see
[LICENSE](LICENSE) and [`yaru-icons-extended/NOTICE.md`](yaru-icons-extended/NOTICE.md).
