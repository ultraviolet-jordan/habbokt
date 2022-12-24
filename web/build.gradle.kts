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
    implementation(deps.guice)

    implementation(project(":db"))
    implementation(project(":page"))
    implementation(project(":session"))
}

application {
    mainClass.set("com.habbokt.web.ApplicationKt")
}