# YaruCompose

Kotlin Multiplatform Library

### Modules

| Module | Targets | Purpose |
| --- | --- | --- |
| `yaru` | Android, JVM, JS, Wasm, iOS | The design system: widgets, themes, foundation. |
| `yaru-icons-extended` | Android, JVM, JS, Wasm, iOS | The full-colour Yaru icon theme as `ImageVector`s. |
| `yaru-decorated-window` | JVM | Client-side decorated desktop window and dialog, backed by Nucleus. |

`yaru` stays design-only: the widgets talk to a windowing layer through the
optional `CompositionLocal`s in `window/WindowIntegration.kt`, and behave
normally when nothing provides them. `yaru-decorated-window` is what fulfils
those contracts — it is a separate artifact because it drags in Nucleus and its
native windowing binaries (~30 MB of per-platform natives), which an app drawing
into a plain Compose `Window` has no use for.

```kotlin
// Design system only — no native windowing.
implementation("dev.nucleusframework.yarucompose:yaru:1.0.0")

// Desktop app that wants the GNOME-style client-side decorated window.
// Brings `yaru` along transitively.
implementation("dev.nucleusframework.yarucompose:yaru-decorated-window:1.0.0")
```

### Run Sample App

 - Desktop JVM: `./gradlew :sample:composeApp:run`
 - Android: `open project in Android Studio and run the sample app`
 - iOS: `open 'sample/iosApp/iosApp.xcodeproj' in Xcode and run the sample app`
 - JavaScript: `./gradlew :sample:composeApp:jsBrowserDevelopmentRun`
 - Wasm: `./gradlew :sample:composeApp:wasmJsBrowserDevelopmentRun`

### Sample gallery

Every page in the sample app shows a live preview next to the exact source that
produced it. The snippet is not written by hand: `:sample:galleryKsp` reads each
`@GalleryExample` composable back from disk at compile time and emits its body
as `GallerySources.<functionName>`, so preview and code can never drift apart.

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

Keep the example self-contained — its body is what the user copies. Function
names must be unique across the module; the processor fails the build on
collisions.

### Publish to MavenLocal

1) Run `./gradlew :yaru:publishToMavenLocal :yaru-decorated-window:publishToMavenLocal :yaru-icons-extended:publishToMavenLocal`
2) Open `~/.m2/repository/dev/nucleusframework/yarucompose/`

### Publish to MavenCentral

1) Create an account and a namespace on Sonatype:  
   https://central.sonatype.org/register/central-portal/#create-an-account
2) Add developer id, name, email and the project url to  
   `./yaru/build.gradle.kts`
3) Generate a GPG key:  
   https://getstream.io/blog/publishing-libraries-to-mavencentral-2021/#generating-a-gpg-key-pair
   ```
   gpg --full-gen-key
   gpg --keyserver keyserver.ubuntu.com --send-keys XXXXXXXX
   gpg --export-secret-key XXXXXXXX > XXXXXXXX.gpg
   ```
4) Add these lines to `gradle.properties`:
   ```
   signing.keyId=XXXXXXXX
   signing.password=[key password]
   signing.secretKeyRingFile=../XXXXXXXX.gpg
   mavenCentralUsername=[generated username]
   mavenCentralPassword=[generated password]
   ```
5) Run `./gradlew publishAndReleaseToMavenCentral --no-configuration-cache`

## License

YaruCompose is available under the [MIT License](LICENSE).

The bundled Yaru icon artwork and the Ubuntu font family keep their own
licenses — see [LICENSE](LICENSE) and
[`yaru-icons-extended/NOTICE.md`](yaru-icons-extended/NOTICE.md).
