package com.habbokt.dao.site

import com.google.inject.Singleton

/**
 * @author Jordan Abraham
 */
@Singleton
class SiteServiceDelegate : SiteService {

    private val siteDAOTest = SiteDAO(
        siteName = "Habbo Hotel",
        sitePath = "http://localhost",
        staticContentPath = "http://localhost",
        serverOnline = true,
        loaderGameIp = "127.0.0.1",
        loaderGamePort = 43594,
        loaderDcr = "http://localhost/dcr/v31/habbo.dcr?",
        loaderVariables = "http://localhost/dcr/v31/gamedata/external_variables.txt?",
        loaderTexts = "http://localhost/dcr/v31/gamedata/external_texts.txt?"
    )

    override suspend fun site(): SiteDAO = siteDAOTest
    override suspend fun createSite(siteDAO: SiteDAO): SiteDAO = siteDAOTest
    override suspend fun editSite(siteDAO: SiteDAO): Boolean = true
}