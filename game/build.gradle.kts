@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(deps.plugins.jvm)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":api"))
    implementation(project(":dao"))
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}