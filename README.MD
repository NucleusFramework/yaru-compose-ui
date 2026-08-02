# YaruCompose

Kotlin Multiplatform Library

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

1) Run `./gradlew :yaru:publishToMavenLocal`
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
5) Run `./gradlew :yaru:publishAndReleaseToMavenCentral --no-configuration-cache`
