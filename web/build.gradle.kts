@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(deps.plugins.jvm)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(deps.bundles.ktor)
    implementation(deps.bundles.koin)
    implementation(deps.pebble)
    implementation(deps.slf4j.simple)
    implementation(deps.simplecaptcha)
    implementation(deps.argon2)

    implementation(project(":dao"))
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}