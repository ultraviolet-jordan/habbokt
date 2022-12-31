package com.habbokt.dao.site

import com.google.inject.Singleton
import com.habbokt.db.query
import com.habbokt.db.site.SiteTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

/**
 * @author Jordan Abraham
 */
@Singleton
class SiteServiceDelegate : SiteService {
    override suspend fun site(): SiteDAO? = query(
        SiteTable
            .select { SiteTable.id eq 1 }
            .map(::resultToSite)::singleOrNull)

    override suspend fun createSite(siteDAO: SiteDAO): SiteDAO? = query {
        SiteTable.insert {
            it[siteName] = siteDAO.siteName
            it[sitePath] = siteDAO.sitePath
            it[staticContentPath] = siteDAO.staticContentPath
            it[serverOnline] = siteDAO.serverOnline
            it[loaderGameIp] = siteDAO.loaderGameIp
            it[loaderGamePort] = siteDAO.loaderGamePort
            it[loaderDcr] = siteDAO.loaderDcr
            it[loaderVariables] = siteDAO.loaderVariables
            it[loaderTexts] = siteDAO.loaderTexts
            it[habboImagingPath] = siteDAO.habboImagingPath
        }.resultedValues?.singleOrNull()?.let(::resultToSite)
    }

    override suspend fun editSite(siteDAO: SiteDAO): Boolean = query {
        SiteTable.update({ SiteTable.id eq 1 }) {
            it[siteName] = siteDAO.siteName
            it[sitePath] = siteDAO.sitePath
            it[staticContentPath] = siteDAO.staticContentPath
            it[serverOnline] = siteDAO.serverOnline
            it[loaderGameIp] = siteDAO.loaderGameIp
            it[loaderGamePort] = siteDAO.loaderGamePort
            it[loaderDcr] = siteDAO.loaderDcr
            it[loaderVariables] = siteDAO.loaderVariables
            it[loaderTexts] = siteDAO.loaderTexts
            it[habboImagingPath] = siteDAO.habboImagingPath
        } > 0
    }

    private fun resultToSite(row: ResultRow) = SiteDAO(
        siteName = row[SiteTable.siteName],
        sitePath = row[SiteTable.sitePath],
        staticContentPath = row[SiteTable.staticContentPath],
        serverOnline = row[SiteTable.serverOnline],
        loaderGameIp = row[SiteTable.loaderGameIp],
        loaderGamePort = row[SiteTable.loaderGamePort],
        loaderDcr = row[SiteTable.loaderDcr],
        loaderVariables = row[SiteTable.loaderVariables],
        loaderTexts = row[SiteTable.loaderTexts],
        habboImagingPath = row[SiteTable.habboImagingPath]
    )
}