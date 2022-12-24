package com.habbokt.db

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.db.players.PlayersTable
import com.habbokt.db.rooms.RoomsTable
import com.habbokt.db.rooms.categories.RoomsCategoriesTable
import com.habbokt.db.site.SiteTable
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * @author Jordan Abraham
 */
@Singleton
class HikariDatabase @Inject constructor(
    private val hikariDataSource: HikariDataSource
) : DatabaseConnection {
    private lateinit var database: Database

    override fun connect() {
        database = Database.connect(hikariDataSource)
    }

    override fun createTables() {
        transaction(database) {
            // Instruct the database to create tables if it doesn't yet exist.
            // H2 is in memory so this is unnecessary for now but will be needed.
            SchemaUtils.create(PlayersTable)
            SchemaUtils.create(SiteTable)
            SchemaUtils.create(RoomsTable)
            SchemaUtils.create(RoomsCategoriesTable)
        }
    }

    override fun close() {
        if (!hikariDataSource.isClosed) {
            hikariDataSource.close()
        }
    }
}