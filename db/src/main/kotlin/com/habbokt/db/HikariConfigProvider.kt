package com.habbokt.db

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.zaxxer.hikari.HikariConfig
import org.h2.tools.Console

/**
 * @author Jordan Abraham
 */
@Singleton
internal class HikariConfigProvider @Inject constructor(
    private val configuration: DatabaseConfiguration
) : Provider<HikariConfig> {
    override fun get(): HikariConfig {
        if (configuration.enableConsole) {
            // Start the H2 web console.
            // http://localhost:8082
            Console.main("-tcp", "-web")
        }
        return HikariConfig().apply {
            driverClassName = configuration.driverClassName
            jdbcUrl = configuration.jdbcUrl
            maximumPoolSize = configuration.maximumPoolSize
            isAutoCommit = configuration.isAutoCommit
            transactionIsolation = configuration.transactionIsolation
            validate()
        }
    }
}