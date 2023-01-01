package com.habbokt.dao.players

import com.google.inject.Singleton
import com.habbokt.db.players.PlayersTable
import com.habbokt.db.query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

/**
 * @author Jordan Abraham
 */
@Singleton
class PlayersServiceDelegate : PlayersService {
    override suspend fun player(id: Int): PlayerDAO? = query {
        PlayersTable
            .select { PlayersTable.id eq id }
            .map(::resultToPlayer)
            .singleOrNull()
    }

    override suspend fun createPlayer(
        name: String,
        password: String,
        email: String,
        figure: String,
        sex: String,
        ssoTicket: String,
        motto: String
    ): PlayerDAO? = query {
        PlayersTable.insert {
            it[PlayersTable.name] = name
            it[PlayersTable.password] = password
            it[PlayersTable.email] = email
            it[PlayersTable.figure] = figure
            it[PlayersTable.sex] = sex
            it[PlayersTable.ssoTicket] = ssoTicket
            it[PlayersTable.motto] = motto
        }.resultedValues?.singleOrNull()?.let(::resultToPlayer)
    }

    override suspend fun editPlayer(
        playerDAO: PlayerDAO
    ): Boolean = query {
        PlayersTable.update({ PlayersTable.id eq playerDAO.id }) {
            it[name] = playerDAO.name
            it[password] = playerDAO.password
            it[email] = playerDAO.email
            it[figure] = playerDAO.figure
            it[sex] = playerDAO.sex
            it[ssoTicket] = playerDAO.ssoTicket
            it[motto] = playerDAO.motto
        } > 0
    }

    override suspend fun deletePlayer(id: Int): Boolean = query {
        PlayersTable.deleteWhere { PlayersTable.id eq id } > 0
    }

    override suspend fun exists(name: String): Boolean = getId(name) != null
    override suspend fun getId(name: String): Int? = query {
        PlayersTable
            .select { PlayersTable.name eq name }
            .map(::resultToPlayer)
            .singleOrNull()
            ?.id
    }

    override suspend fun ssoTicket(ssoTicket: String): PlayerDAO? = query {
        PlayersTable
            .select { PlayersTable.ssoTicket eq ssoTicket }
            .map(::resultToPlayer)
            .singleOrNull()
    }

    private fun resultToPlayer(row: ResultRow) = PlayerDAO(
        id = row[PlayersTable.id],
        name = row[PlayersTable.name],
        password = row[PlayersTable.password],
        email = row[PlayersTable.email],
        figure = row[PlayersTable.figure],
        sex = row[PlayersTable.sex],
        ssoTicket = row[PlayersTable.ssoTicket],
        motto = row[PlayersTable.motto]
    )
}