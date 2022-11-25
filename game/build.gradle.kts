@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(deps.plugins.jvm)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(deps.bundles.ktor)
    implementation(deps.slf4j.simple)

    implementation(project(":api"))
    implementation(project(":db"))
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}