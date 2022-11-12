@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(deps.plugins.jvm)
    alias(deps.plugins.versions)
    alias(deps.plugins.ktlint)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(deps.bundles.ktor)
    implementation(deps.bundles.koin)
    implementation(deps.pebble)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
