import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    // JVM only: the whole point of the module is to keep the native windowing
    // layer off the other targets, which have no window to decorate.
    jvm {
        compilerOptions { jvmTarget = JvmTarget.JVM_17 }
    }

    sourceSets {
        jvmMain.dependencies {
            // `api`: the widgets, the theme and the window-integration
            // CompositionLocals this module provides all come from :yaru.
            api(project(":yaru"))
            // Windowing layer: the Yaru widgets stay design-only, the window
            // integration (drag, controls, theme sync) lives here.
            api(libs.nucleus.decorated.window.tao)
            api(libs.nucleus.application)
        }
    }
}

//Publishing your Kotlin Multiplatform library to Maven Central
//https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-publish-libraries.html
mavenPublishing {
    publishToMavenCentral()
    coordinates("dev.nucleusframework.yarucompose", "yaru-decorated-window", "1.0.0")

    pom {
        name = "YaruCompose Decorated Window"
        description = "Client-side decorated desktop window and dialog for YaruCompose, backed by Nucleus — " +
            "GNOME-style headerbar chrome, native window controls and theme sync."
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
