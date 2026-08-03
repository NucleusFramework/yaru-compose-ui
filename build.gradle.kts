plugins {
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.android.kmp.library).apply(false)
    alias(libs.plugins.maven.publish).apply(false)
    alias(libs.plugins.compose.multiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.kotlin.jvm).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.ksp).apply(false)
}

// Publishing is tag-driven: the CI exports RELEASE_VERSION=<tag>. Local builds
// (and `publishToMavenLocal`) fall back to `libraryVersion` in gradle.properties.
val libraryVersion: String =
    System
        .getenv("RELEASE_VERSION")
        ?.removePrefix("v")
        ?.takeIf { it.isNotBlank() && it.first().isDigit() }
        ?: providers.gradleProperty("libraryVersion").get()

allprojects {
    version = libraryVersion
}
