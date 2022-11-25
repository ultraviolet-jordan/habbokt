package com.habbokt.db.site

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object SiteTable : Table() {
    val id = integer("id").default(1)
    val siteName = varchar("siteName", 25)
    val sitePath = text("sitePath")
    val staticContentPath = text("staticContentPath")
    val serverOnline = bool("serverOnline")
    val loaderGameIp = varchar("loaderGameIp", 15)
    val loaderGamePort = integer("loaderGamePort")
    val loaderDcr = text("loaderDcr")
    val loaderVariables = text("loaderVariables")
    val loaderTexts = text("loaderTexts")

    override val primaryKey = PrimaryKey(id)
}