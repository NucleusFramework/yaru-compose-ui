rootProject.name = "yaru-compose-ui"

pluginManagement {
    repositories {
        // Prefer a locally published Nucleus snapshot when present
        // (see `nucleus` in the version catalog). Released versions resolve
        // from Maven Central.
        mavenLocal { content { includeGroupByRegex("dev\\.nucleusframework.*") } }
        google {
            content { 
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal { content { includeGroupByRegex("dev\\.nucleusframework.*") } }
        google {
            content { 
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        mavenCentral()
    }
}
include(":yaru")
include(":yaru-decorated-window")
include(":yaru-icons-extended")
include(":sample:galleryKsp")
include(":sample:sharedUI")
include(":sample:androidApp")
include(":sample:desktopApp")
include(":sample:webApp")

