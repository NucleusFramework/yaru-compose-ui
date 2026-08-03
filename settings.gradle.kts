rootProject.name = "YaruCompose"

pluginManagement {
    repositories {
        // Nucleus is consumed from a local publish while the window work is
        // unreleased (see `nucleus` in the version catalog).
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
include(":yaru-icons-extended")
include(":sample:galleryKsp")
include(":sample:sharedUI")
include(":sample:androidApp")
include(":sample:desktopApp")
include(":sample:webApp")

