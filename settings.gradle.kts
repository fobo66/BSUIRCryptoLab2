rootProject.name = "lab2"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            version("kotlin", "2.0.20")
            library("cli", "org.jetbrains.kotlinx:kotlinx-cli:0.3.6")
        }
    }
}
