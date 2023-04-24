@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(deps.plugins.jvm)
    alias(deps.plugins.dokka)
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(deps.bundles.ktor)
    implementation(deps.bundles.ktor.client)
    implementation(deps.guice)
    implementation(deps.simplecaptcha)
    implementation(deps.flagstone)

    implementation(project(":argon2"))
    implementation(project(":dao"))
    implementation(project(":session"))
    implementation(project(":swf"))
    implementation(project(":xml"))
}