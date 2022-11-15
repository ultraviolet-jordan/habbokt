package com.habbokt.dao.players

import com.habbokt.dao.DatabaseFactory.query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

class PlayersDAODelegate : PlayersDAO {
    override suspend fun player(id: Int): Player? = query {
        PlayersTable
            .select { PlayersTable.id eq id }
            .map(::resultToPlayer)
            .singleOrNull()
    }

    override suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Player? = query {
        PlayersTable.insert {
            it[PlayersTable.username] = username
            it[PlayersTable.password] = password
            it[PlayersTable.email] = email
            it[PlayersTable.appearance] = appearance
            it[PlayersTable.gender] = gender
        }.resultedValues?.singleOrNull()?.let(::resultToPlayer)
    }

    override suspend fun editPlayer(
        id: Int,
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Boolean = query {
        PlayersTable.update({ PlayersTable.id eq id }) {
            it[PlayersTable.username] = username
            it[PlayersTable.password] = password
            it[PlayersTable.email] = email
            it[PlayersTable.appearance] = appearance
            it[PlayersTable.gender] = gender
        } > 0
    }

    override suspend fun deletePlayer(id: Int): Boolean = query {
        PlayersTable.deleteWhere { PlayersTable.id eq id } > 0
    }

    override suspend fun exists(username: String): Boolean = getId(username) != null
    override suspend fun getId(username: String): Int? = query {
        PlayersTable
            .select { PlayersTable.username eq username }
            .map(::resultToPlayer)
            .singleOrNull()
            ?.id
    }

    private fun resultToPlayer(row: ResultRow) = Player(
        id = row[PlayersTable.id],
        username = row[PlayersTable.username],
        password = row[PlayersTable.password],
        email = row[PlayersTable.email],
        appearance = row[PlayersTable.appearance],
        gender = row[PlayersTable.gender]
    )
}
