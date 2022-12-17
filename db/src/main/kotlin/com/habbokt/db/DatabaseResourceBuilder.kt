package com.habbokt.db

import com.habbokt.db.players.PlayersTable
import com.habbokt.db.rooms.RoomsTable
import com.habbokt.db.rooms.categories.RoomsCategoriesTable
import com.habbokt.db.site.SiteTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.h2.tools.Console
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * @author Jordan Abraham
 */
object DatabaseResourceBuilder {
    fun connect(databaseConfiguration: DatabaseConfiguration.() -> Unit) {
        val configuration = DatabaseConfiguration().apply(databaseConfiguration)

        if (configuration.enableConsole == true) {
            // Start the H2 web console.
            // http://localhost:8082
            Console.main("-tcp", "-web")
        }

        val database = Database.connect(
            HikariDataSource(HikariConfig().apply {
                driverClassName = configuration.driverClassName
                jdbcUrl = configuration.jdbcUrl
                maximumPoolSize = configuration.maximumPoolSize ?: 1
                isAutoCommit = configuration.isAutoCommit ?: true
                transactionIsolation = configuration.transactionIsolation ?: "TRANSACTION_REPEATABLE_READ"
                validate()
            })
        )

        // Establishes connection here.
        transaction(database) {
            // Instruct the database to create tables if it doesn't yet exist.
            // H2 is in memory so this is unnecessary for now but will be needed.
            SchemaUtils.create(PlayersTable)
            SchemaUtils.create(SiteTable)
            SchemaUtils.create(RoomsTable)
            SchemaUtils.create(RoomsCategoriesTable)
        }
    }
}