import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        compilerOptions { jvmTarget = JvmTarget.JVM_17 }
    }

    jvm {
        compilerOptions { jvmTarget = JvmTarget.JVM_17 }
    }
    js { browser() }
    wasmJs { browser() }
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.ui)
            api(compose.foundation)
            implementation(compose.components.resources)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotlinx.coroutines.test)
        }

        androidMain.dependencies {
            implementation(libs.kotlinx.coroutines.android)
        }

        jvmMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            // No windowing layer here on purpose: the widgets stay design-only
            // and talk to a window through the CompositionLocals in
            // `window/WindowIntegration.kt`. The Nucleus-backed implementation
            // — and its native binaries — lives in :yaru-decorated-window, so
            // an app drawing into a plain Compose `Window` never pulls it.
            // System theme: OS dark mode and accent color, read natively.
            implementation(libs.nucleus.darkmode.detector)
            implementation(libs.nucleus.system.color)
        }

    }
}

android {
    namespace = "dev.nucleusframework.yarucompose.yaru"
    compileSdk = 37
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

//Publishing your Kotlin Multiplatform library to Maven Central
//https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-publish-libraries.html
mavenPublishing {
    publishToMavenCentral()
    coordinates("dev.nucleusframework.yarucompose", "yaru", version.toString())

    pom {
        name = "Yaru Compose UI"
        description = "A Compose Multiplatform port of Ubuntu's Yaru design system — 30+ widgets, " +
            "accent variants, light/dark, high contrast and RTL support."
        inceptionYear = "2025"
        url = "https://github.com/NucleusFramework/yaru-compose-ui"

        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }

        developers {
            developer {
                id = "nucleusframework"
                name = "Nucleus Framework"
                url = "https://github.com/NucleusFramework"
            }
        }

        scm {
            url = "https://github.com/NucleusFramework/yaru-compose-ui"
        }
    }
    // The CI signs with an in-memory key (ORG_GRADLE_PROJECT_signingInMemoryKey);
    // local publishes stay unsigned unless a GPG keyring is configured.
    if (project.hasProperty("signingInMemoryKey") || project.hasProperty("signing.keyId")) signAllPublications()
}

// Pin the generated `Res` package. Compose Resources derives it from the
// Gradle group, which defaults to `rootProject.name` — renaming the repository
// would otherwise move the class and break every import.
compose.resources {
    packageOfResClass = "dev.nucleusframework.yarucompose.generated.resources"
}
