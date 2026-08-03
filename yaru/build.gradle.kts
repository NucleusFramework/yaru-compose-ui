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
    compileSdk = 36
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
    coordinates("dev.nucleusframework.yarucompose", "yaru", "1.0.0")

    pom {
        name = "YaruCompose"
        description = "A Compose Multiplatform port of Ubuntu's Yaru design system — 30+ widgets, " +
            "accent variants, light/dark, high contrast and RTL support."
        inceptionYear = "2025"
        url = "https://github.com/kdroidFilter/YaruCompose"

        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }

        developers {
            developer {
                id = "kdroidfilter"
                name = "Elie Gambache"
                email = "elyahou.hadass@gmail.com"
            }
        }

        scm {
            url = "https://github.com/kdroidFilter/YaruCompose"
        }
    }
    if (project.hasProperty("signing.keyId")) signAllPublications()
}
