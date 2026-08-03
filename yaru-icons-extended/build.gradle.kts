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
            // Reuses YaruConstants/YaruIcon so full-colour icons match the
            // rest of the design system's sizing conventions.
            api(project(":yaru"))
        }
    }
}

android {
    namespace = "dev.nucleusframework.yarucompose.iconsextended"
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
    coordinates("dev.nucleusframework.yarucompose", "yaru-icons-extended", version.toString())

    pom {
        name = "Yaru Compose UI Icons Extended"
        description = "Bundled Yaru full-colour icon theme as Compose ImageVector for Kotlin Multiplatform — no network access required."
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
