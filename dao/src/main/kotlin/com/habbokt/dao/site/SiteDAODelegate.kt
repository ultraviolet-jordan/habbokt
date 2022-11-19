package com.habbokt.dao.site

import com.habbokt.dao.DatabaseFactory.query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

/**
 * @author Jordan Abraham
 */
class SiteDAODelegate : SiteDAO {
    override suspend fun site(): Site = query {
        SiteTable
            .select { SiteTable.id eq 1 }
            .map(::resultToSite)
            .single()
    }

    override suspend fun createSite(site: Site): Site? = query {
        SiteTable.insert {
            it[siteName] = site.siteName
            it[sitePath] = site.sitePath
            it[staticContentPath] = site.staticContentPath
            it[serverOnline] = site.serverOnline
            it[loaderGameIp] = site.loaderGameIp
            it[loaderGamePort] = site.loaderGamePort
            it[loaderDcr] = site.loaderDcr
            it[loaderVariables] = site.loaderVariables
            it[loaderTexts] = site.loaderTexts
        }.resultedValues?.singleOrNull()?.let(::resultToSite)
    }

    override suspend fun editSite(site: Site): Boolean = query {
        SiteTable.update({ SiteTable.id eq 1 }) {
            it[siteName] = site.siteName
            it[sitePath] = site.sitePath
            it[staticContentPath] = site.staticContentPath
            it[serverOnline] = site.serverOnline
            it[loaderGameIp] = site.loaderGameIp
            it[loaderGamePort] = site.loaderGamePort
            it[loaderDcr] = site.loaderDcr
            it[loaderVariables] = site.loaderVariables
            it[loaderTexts] = site.loaderTexts
        } > 0
    }

    private fun resultToSite(row: ResultRow) = Site(
        siteName = row[SiteTable.siteName],
        sitePath = row[SiteTable.sitePath],
        staticContentPath = row[SiteTable.staticContentPath],
        serverOnline = row[SiteTable.serverOnline],
        loaderGameIp = row[SiteTable.loaderGameIp],
        loaderGamePort = row[SiteTable.loaderGamePort],
        loaderDcr = row[SiteTable.loaderDcr],
        loaderVariables = row[SiteTable.loaderVariables],
        loaderTexts = row[SiteTable.loaderTexts]
    )
}
