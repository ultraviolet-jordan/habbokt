package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.habbokt.db.DatabaseConfiguration
import io.ktor.server.application.ApplicationEnvironment

/**
 * @author Jordan Abraham
 */
@Singleton
class DatabaseConfigurationProvider @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment
) : Provider<DatabaseConfiguration> {
    override fun get(): DatabaseConfiguration = DatabaseConfiguration(
        driverClassName = applicationEnvironment.config.property("storage.driverClassName").getString(),
        jdbcUrl = applicationEnvironment.config.property("storage.jdbcUrl").getString(),
        maximumPoolSize = 2,
        isAutoCommit = true,
        transactionIsolation = "TRANSACTION_REPEATABLE_READ",
        enableConsole = false
    )
}