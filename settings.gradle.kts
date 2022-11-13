rootProject.name = "habbokt"

dependencyResolutionManagement {
    repositories(RepositoryHandler::mavenCentral)

    versionCatalogs {
        create("deps") {
            // Dependency versions.
            version("kotlin", "1.7.21")
            version("ktor", "2.1.3")
            version("koin", "3.2.2")
            version("versions", "0.44.0")
            version("pebble", "3.1.6")
            version("ktlint", "11.0.0")
            version("slf4j", "2.0.3")
            version("simplecaptcha", "1.2.2")

            // Dependency libraries
            library("ktor-server-core", "io.ktor", "ktor-server-core").versionRef("ktor")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty").versionRef("ktor")
            library("ktor-server-status-pages", "io.ktor", "ktor-server-status-pages").versionRef("ktor")
            library("ktor-server-call-logging", "io.ktor", "ktor-server-call-logging").versionRef("ktor")
            library("ktor-server-sessions", "io.ktor", "ktor-server-sessions").versionRef("ktor")
            library("ktor-server-auth", "io.ktor", "ktor-server-auth").versionRef("ktor")
            library("koin-core", "io.insert-koin", "koin-core").versionRef("koin")
            library("koin-ktor", "io.insert-koin", "koin-ktor").versionRef("koin")
            library("pebble", "io.pebbletemplates", "pebble").versionRef("pebble")
            library("slf4j-simple", "org.slf4j", "slf4j-simple").versionRef("slf4j")
            library("simplecaptcha", "cn.apiclub.tool", "simplecaptcha").versionRef("simplecaptcha")

            // Dependency bundles
            bundle("ktor", listOf("ktor-server-core", "ktor-server-netty", "ktor-server-status-pages", "ktor-server-call-logging", "ktor-server-sessions", "ktor-server-auth"))
            bundle("koin", listOf("koin-core", "koin-ktor"))

            // Dependency plugins
            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("versions", "com.github.ben-manes.versions").versionRef("versions")
            plugin("ktlint", "org.jlleitschuh.gradle.ktlint").versionRef("ktlint")
        }
    }
}
