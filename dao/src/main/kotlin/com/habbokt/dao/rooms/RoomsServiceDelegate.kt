package com.habbokt.dao.rooms

import com.google.inject.Singleton
import com.habbokt.db.query
import com.habbokt.db.rooms.RoomsTable
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
class RoomsServiceDelegate : RoomsService {
    override suspend fun room(id: Int): RoomDAO? = query {
        RoomsTable
            .select { RoomsTable.id eq id }
            .map(::resultToRoom)
            .singleOrNull()
    }

    override suspend fun createRoom(
        categoryId: Int,
        name: String
    ): RoomDAO? = query {
        RoomsTable.insert {
            it[RoomsTable.categoryId] = categoryId
            it[RoomsTable.name] = name
        }.resultedValues?.singleOrNull()?.let(::resultToRoom)
    }

    override suspend fun editRoom(roomDAO: RoomDAO): Boolean = query {
        RoomsTable.update({ RoomsTable.id eq roomDAO.id }) {
            it[categoryId] = roomDAO.categoryId
            it[name] = roomDAO.name
        } > 0
    }

    override suspend fun deleteRoom(id: Int): Boolean = query {
        RoomsTable.deleteWhere { RoomsTable.id eq id } > 0
    }

    override suspend fun roomsByCategoryId(categoryId: Int): List<RoomDAO> = query {
        RoomsTable
            .select { RoomsTable.categoryId eq categoryId }
            .map(::resultToRoom)
    }

    private fun resultToRoom(row: ResultRow) = RoomDAO(
        id = row[RoomsTable.id],
        categoryId = row[RoomsTable.categoryId],
        name = row[RoomsTable.name]
    )
}