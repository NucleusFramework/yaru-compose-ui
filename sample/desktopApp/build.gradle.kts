import dev.nucleusframework.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.nucleus)
}

// Defensive: align JVM target with yaru/sharedUI (JVM_17) to avoid bytecode incompatibility when consuming KMP modules built for JVM_17
kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":sample:sharedUI"))
    // Direct: the window entry point lives in :yaru's jvmMain, and sharedUI
    // depends on it privately.
    implementation(project(":yaru"))
    implementation(compose.desktop.currentOs)
    // L1 GraalVM metadata, font substitutions and the META-INF/services globs
    // the native image needs.
    implementation(libs.nucleus.graalvm.runtime)
}

nucleus.application {
    mainClass = "MainKt"

    nativeDistributions {
        targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
        packageName = "sample"
        packageVersion = "1.0.0"
    }

    graalvm {
        isEnabled = true
        javaLanguageVersion = 25
        imageName = "yaru-sample"
    }
}
