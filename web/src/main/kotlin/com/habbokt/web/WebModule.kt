package com.habbokt.web

import com.habbokt.db.DatabaseConfiguration
import com.habbokt.db.DatabaseModule
import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
class WebModule(
    private val databaseConfiguration: DatabaseConfiguration
) : KotlinModule() {
    override fun configure() {
        install(DatabaseModule(databaseConfiguration))
    }
}