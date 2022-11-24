@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(deps.plugins.jvm)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(deps.bundles.ktor)
    implementation(deps.guice)

    implementation(project(":dao"))
    implementation(project(":session"))
    implementation(project(":templating"))
}