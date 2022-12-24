package com.habbokt.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
class DatabaseModule(
    private val configuration: DatabaseConfiguration
) : KotlinModule() {
    override fun configure() {
        bind<DatabaseConfiguration>().toInstance(configuration)
        bind<HikariConfig>().toProvider<HikariConfigProvider>()
        bind<HikariDataSource>().toProvider<HikariDataSourceProvider>()
    }
}