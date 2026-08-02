import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
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
    // Defensive: iOS targets must be declared so iosMain compiles and the framework binary is produced for iosApp; must mirror yaru's iOS targets
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            // Defensive: use compose plugin DSL instead of libs.compose.* to align with yaru module and avoid version drift via plugin-managed BOM
            api(compose.runtime)
            api(compose.ui)
            api(compose.foundation)
            implementation(compose.components.resources)
            implementation(project(":yaru"))
            implementation(libs.kotlinx.datetime)
            // Coil 3 + Ktor 3 — used by FullColorIconsPage to fetch the
            // Yaru icon PNG previews from raw.githubusercontent.com, mirroring
            // Flutter's `Image.network(...)` in `full_color_icons_page.dart`.
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.ktor.client.core)
            // Kotlin syntax colouring for the gallery `CodeBlock`.
            implementation(libs.highlights)
        }
        // Per-target Ktor engine (Coil's ktor3 fetcher is engine-agnostic, the
        // host module must wire one in). CIO covers JVM + Android; Darwin
        // covers iOS; the JS engine covers browser/Wasm targets.
        jvmMain.dependencies { implementation(libs.ktor.client.cio) }
        androidMain.dependencies { implementation(libs.ktor.client.cio) }
        iosMain.dependencies { implementation(libs.ktor.client.darwin) }
        named("jsMain").dependencies { implementation(libs.ktor.client.js) }
        named("wasmJsMain").dependencies { implementation(libs.ktor.client.js) }
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>().configureEach {
        binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    // `GallerySources` is generated once from commonMain and shared by every target.
    sourceSets.commonMain {
        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
    }
}

dependencies {
    add("kspCommonMainMetadata", project(":sample:galleryKsp"))
}

// The generated sources live in commonMain, so every compilation — including the
// per-target ones KSP does not run for — must wait for the metadata pass.
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}
android {
    namespace = "dev.nucleusframework.yarucompose.sharedUI"
    compileSdk = 36
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
