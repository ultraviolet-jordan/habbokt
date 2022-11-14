package com.habbokt.web.dao.players

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object PlayersTable : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 50)
    val password = text("password")
    val email = varchar("email", 255)
    val appearance = varchar("appearance", 255)
    val gender = char("gender", 1)

    override val primaryKey = PrimaryKey(id)
}