@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(deps.plugins.jvm)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(deps.guice)
    implementation(deps.pebble)
}