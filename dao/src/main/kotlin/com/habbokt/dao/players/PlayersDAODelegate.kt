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
        gender: String,
        ssoTicket: String
    ): Player? = query {
        PlayersTable.insert {
            it[PlayersTable.username] = username
            it[PlayersTable.password] = password
            it[PlayersTable.email] = email
            it[PlayersTable.appearance] = appearance
            it[PlayersTable.gender] = gender
            it[PlayersTable.ssoTicket] = ssoTicket
        }.resultedValues?.singleOrNull()?.let(::resultToPlayer)
    }

    override suspend fun editPlayer(
        player: Player
    ): Boolean = query {
        PlayersTable.update({ PlayersTable.id eq player.id }) {
            it[username] = player.username
            it[password] = player.password
            it[email] = player.email
            it[appearance] = player.appearance
            it[gender] = player.gender
            it[ssoTicket] = player.ssoTicket
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
        gender = row[PlayersTable.gender],
        ssoTicket = row[PlayersTable.ssoTicket]
    )
}
