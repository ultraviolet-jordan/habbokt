package com.habbokt.db.players

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object PlayersTable : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    val password = text("password")
    val email = varchar("email", 255)
    val figure = varchar("figure", 255)
    val sex = char("sex", 1)
    val ssoTicket = text("sso_ticket")
    val motto = text("motto")

    override val primaryKey = PrimaryKey(id)
}