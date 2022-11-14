package com.habbokt.web.dao

import com.habbokt.web.dao.persistence.CachingAliases
import com.habbokt.web.dao.persistence.stringKeyedCacheResourcePool
import com.habbokt.web.dao.players.Player
import com.habbokt.web.dao.players.Players
import com.habbokt.web.dao.players.PlayersDAO
import com.habbokt.web.dao.players.PlayersDAODelegate
import com.habbokt.web.dao.players.PlayersDAOService
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.ApplicationConfig
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
    fun init(config: ApplicationConfig) {
        if (config.property("h2.console.enabled").getString().toBoolean()) {
            // Start the H2 web console.
            // http://localhost:8082
            Console.main("-tcp", "-web")
        }
        // Doesn't establish a real database connection until you call the transaction - it only creates a descriptor for future connections.
        val database = Database.connect(
            HikariDataSource(
                HikariConfig().apply {
                    driverClassName = config.property("storage.driverClassName").getString()
                    jdbcUrl = config.property("storage.jdbcURL").getString()
                    maximumPoolSize = 3 // specifies the maximum size the connection pool can reach.
                    isAutoCommit = true // set to sync with the default settings used by Exposed.
                    transactionIsolation = "TRANSACTION_REPEATABLE_READ" // set to sync with the default settings used by Exposed.
                    validate()
                }
            )
        )
        // Establishes connection here.
        transaction(database) {
            // Instruct the database to create tables if it doesn't yet exist.
            // H2 is in memory so this is unnecessary for now but will be needed.
            SchemaUtils.create(Players)
        }
    }

    fun createPlayersDAO(): PlayersDAO = PlayersDAOService(
        delegate = PlayersDAODelegate(),
        cache = stringKeyedCacheResourcePool(CachingAliases.PlayersTableCache, Player::class.java)
    )

    suspend fun <T> query(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
