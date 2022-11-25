rootProject.name = "habbokt"

dependencyResolutionManagement {
    repositories(RepositoryHandler::mavenCentral)

    versionCatalogs {
        create("deps") {
            // Dependency versions.
            version("kotlin", "1.7.21")
            version("ktor", "2.1.3")
            version("versions", "0.44.0")
            version("pebble", "3.2.0")
            version("ktlint", "11.0.0")
            version("slf4j", "2.0.4")
            version("simplecaptcha", "1.2.2")
            version("argon2", "2.11")
            version("exposed", "0.41.1")
            version("h2database", "2.1.214")
            version("hikaricp", "5.0.1")
            version("ehcache", "3.10.8")
            version("guice", "1.6.0")

            // Dependency libraries
            // Ktor Dependencies
            library("ktor-server-core", "io.ktor", "ktor-server-core").versionRef("ktor")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty").versionRef("ktor")
            library("ktor-server-status-pages", "io.ktor", "ktor-server-status-pages").versionRef("ktor")
            library("ktor-server-call-logging", "io.ktor", "ktor-server-call-logging").versionRef("ktor")
            library("ktor-server-sessions", "io.ktor", "ktor-server-sessions").versionRef("ktor")
            library("ktor-server-auth", "io.ktor", "ktor-server-auth").versionRef("ktor")

            // Database Dependencies
            library("exposed-core", "org.jetbrains.exposed", "exposed-core").versionRef("exposed")
            library("exposed-dao", "org.jetbrains.exposed", "exposed-dao").versionRef("exposed")
            library("exposed-jdbc", "org.jetbrains.exposed", "exposed-jdbc").versionRef("exposed")
            library("h2database", "com.h2database", "h2").versionRef("h2database")
            library("hikaricp", "com.zaxxer", "HikariCP").versionRef("hikaricp")
            library("ehcache", "org.ehcache", "ehcache").versionRef("ehcache")

            // Guice
            library("guice", "dev.misfitlabs.kotlinguice4", "kotlin-guice").versionRef("guice")

            // Misc Dependencies
            library("pebble", "io.pebbletemplates", "pebble").versionRef("pebble")
            library("slf4j-simple", "org.slf4j", "slf4j-simple").versionRef("slf4j")
            library("simplecaptcha", "cn.apiclub.tool", "simplecaptcha").versionRef("simplecaptcha")
            library("argon2", "de.mkammerer", "argon2-jvm").versionRef("argon2")

            // Dependency bundles
            bundle("ktor", listOf("ktor-server-core", "ktor-server-netty", "ktor-server-status-pages", "ktor-server-call-logging", "ktor-server-sessions", "ktor-server-auth"))
            bundle("database", listOf("exposed-core", "exposed-dao", "exposed-jdbc", "h2database", "hikaricp", "ehcache"))

            // Dependency plugins
            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("versions", "com.github.ben-manes.versions").versionRef("versions")
            plugin("ktlint", "org.jlleitschuh.gradle.ktlint").versionRef("ktlint")
        }
    }
}

include(listOf("api", "argon2", "dao", "db", "game", "packet", "page", "session", "templating", "web"))
