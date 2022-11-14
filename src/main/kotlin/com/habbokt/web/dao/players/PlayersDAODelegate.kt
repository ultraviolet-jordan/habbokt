package com.habbokt.web.dao.players

import com.habbokt.web.dao.DatabaseFactory.query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

class PlayersDAODelegate : PlayersDAO {
    override suspend fun player(username: String): Player? = query {
        Players
            .select { Players.username eq username }
            .map(::resultRowToPlayer)
            .singleOrNull()
    }

    override suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Player? = query {
        Players.insert {
            it[Players.username] = username
            it[Players.password] = password
            it[Players.email] = email
            it[Players.appearance] = appearance
            it[Players.gender] = gender
        }.resultedValues?.singleOrNull()?.let(::resultRowToPlayer)
    }

    override suspend fun editPlayer(
        id: Int,
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Boolean = query {
        Players.update({ Players.id eq id }) {
            it[Players.username] = username
            it[Players.password] = password
            it[Players.email] = email
            it[Players.appearance] = appearance
            it[Players.gender] = gender
        } > 0
    }

    override suspend fun deletePlayer(username: String): Boolean = query {
        Players.deleteWhere { Players.username eq username } > 0
    }

    override suspend fun exists(username: String): Boolean = getId(username) != null
    override suspend fun getId(username: String): Int? = query {
        Players
            .select { Players.username eq username }
            .map(::resultRowToPlayer)
            .singleOrNull()
            ?.id
    }

    private fun resultRowToPlayer(row: ResultRow) = Player(
        id = row[Players.id],
        username = row[Players.username],
        password = row[Players.password],
        email = row[Players.email],
        appearance = row[Players.appearance],
        gender = row[Players.gender]
    )
}
