package com.habbokt.dao

import com.habbokt.dao.players.PlayersTable
import com.habbokt.dao.site.SiteTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.h2.tools.Console
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * @author Jordan Abraham
 */
object DatabaseFactory {
    fun init(
        driverClassName: String,
        jdbcUrl: String,
        useConsole: Boolean
    ) {
        if (useConsole /*config.property("h2.console.enabled").getString().toBoolean()*/) {
            // Start the H2 web console.
            // http://localhost:8082
            Console.main("-tcp", "-web")
        }
        // Doesn't establish a real database connection until you call the transaction - it only creates a descriptor for future connections.
        val database = Database.connect(
            HikariDataSource(
                HikariConfig().apply {
                    this.driverClassName = driverClassName // config.property("storage.driverClassName").getString()
                    this.jdbcUrl = jdbcUrl // config.property("storage.jdbcURL").getString()
                    this.maximumPoolSize = 3 // specifies the maximum size the connection pool can reach.
                    this.isAutoCommit = true // set to sync with the default settings used by Exposed.
                    this.transactionIsolation = "TRANSACTION_REPEATABLE_READ" // set to sync with the default settings used by Exposed.
                    this.validate()
                }
            )
        )
        // Establishes connection here.
        transaction(database) {
            // Instruct the database to create tables if it doesn't yet exist.
            // H2 is in memory so this is unnecessary for now but will be needed.
            SchemaUtils.create(PlayersTable)
            SchemaUtils.create(SiteTable)
        }
    }

    suspend fun <T> query(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
