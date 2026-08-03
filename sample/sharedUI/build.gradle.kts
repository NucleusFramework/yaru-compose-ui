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
            implementation(project(":yaru-icons-extended"))
            implementation(libs.kotlinx.datetime)
            // Kotlin syntax colouring for the gallery `CodeBlock`.
            implementation(libs.highlights)
        }
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

// Same reason as :yaru — keep the generated `Res` package off `rootProject.name`.
compose.resources {
    packageOfResClass = "sample.app.generated.resources"
}
