@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(deps.plugins.jvm)
    alias(deps.plugins.dokka)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(deps.bundles.ktor)
    implementation(deps.slf4j.simple)
    implementation(deps.guice)

    implementation(project(":db"))
    implementation(project(":page"))
    implementation(project(":session"))
    implementation("io.ktor:ktor-server-core-jvm:2.3.0")
    implementation("io.ktor:ktor-server-pebble-jvm:2.3.0")
}

application {
    mainClass.set("com.habbokt.web.ApplicationKt")
}