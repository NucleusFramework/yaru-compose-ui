import dev.nucleusframework.desktop.application.dsl.CompressionLevel
import dev.nucleusframework.desktop.application.dsl.NativeImageOptimization
import dev.nucleusframework.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.nucleus)
}

// Release builds are tag-driven: the CI exports RELEASE_VERSION=<tag>.
val releaseVersion =
    System
        .getenv("RELEASE_VERSION")
        ?.removePrefix("v")
        ?.takeIf { it.isNotBlank() && it.first().isDigit() }
        ?: "1.0.0"

// Native installers only accept numeric versions: drop any pre-release suffix.
val nativePackageVersion = releaseVersion.substringBefore("-")

// Defensive: align JVM target with yaru/sharedUI (JVM_17) to avoid bytecode incompatibility when consuming KMP modules built for JVM_17
kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":sample:sharedUI"))
    // Direct: the window entry point lives here, and sharedUI depends on
    // :yaru privately. Brings :yaru along transitively.
    implementation(project(":yaru-decorated-window"))
    implementation(compose.desktop.currentOs)
    // L1 GraalVM metadata, font substitutions and the META-INF/services globs
    // the native image needs.
    implementation(libs.nucleus.graalvm.runtime)
}

nucleus.application {
    mainClass = "MainKt"
    nativeDistributions {
        targetFormats(TargetFormat.Dmg, TargetFormat.Nsis, TargetFormat.Deb)
        compressionLevel = CompressionLevel.Ultra
        packageName = "yaru-compose-gallery"
        cleanupNativeLibs = true
        packageVersion = nativePackageVersion
        linux {
            debMaintainer = "Nucleus"
            homepage = "https://nucleusframework.dev"
        }
    }

    graalvm {
        isEnabled = true
        javaLanguageVersion = 25
        imageName = "yaru-sample"
        optimization = NativeImageOptimization.SIZE
    }
}
