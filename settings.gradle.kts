rootProject.name = "habbokt"

dependencyResolutionManagement {
    repositories(RepositoryHandler::mavenCentral)

    versionCatalogs {
        create("deps") {
            version("kotlin", "1.7.20")
            version("ktor", "2.1.2")
            version("koin", "3.2.0")
            version("versions", "0.42.0")
            version("pebble", "3.1.5")

            library("ktor-server-core", "io.ktor", "ktor-server-core").versionRef("ktor")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty").versionRef("ktor")

            library("koin-core", "io.insert-koin", "koin-core").versionRef("koin")
            library("koin-ktor", "io.insert-koin", "koin-ktor").versionRef("koin")

            library("pebble", "io.pebbletemplates", "pebble").versionRef("pebble")

            bundle("ktor", listOf("ktor-server-core", "ktor-server-netty"))
            bundle("koin", listOf("koin-core", "koin-ktor"))

            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("versions", "com.github.ben-manes.versions").versionRef("versions")
        }
    }
}
