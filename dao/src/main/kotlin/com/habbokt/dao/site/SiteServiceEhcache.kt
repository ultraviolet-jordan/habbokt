package com.habbokt.dao.site

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.ServiceDelegate

/**
 * @author Jordan Abraham
 */
@Singleton
class SiteServiceEhcache @Inject constructor(
    @ServiceDelegate private val delegate: SiteService
) : SiteService {
    private val cache = mutableMapOf<Int, SiteDAO>()

    private val siteDAOTest = SiteDAO(
        siteName = "Habbo Hotel 2",
        sitePath = "http://localhost",
        staticContentPath = "http://localhost",
        serverOnline = true,
        loaderGameIp = "127.0.0.1",
        loaderGamePort = 43594,
        loaderDcr = "http://localhost/dcr/v31/habbo.dcr?",
        loaderVariables = "http://localhost/dcr/v31/gamedata/external_variables.txt?",
        loaderTexts = "http://localhost/dcr/v31/gamedata/external_texts.txt?"
    )

    init {
        cache[1] = siteDAOTest
    }

    override suspend fun site(): SiteDAO = cache[1] ?: delegate.site().also { cache.put(1, it) }

    override suspend fun createSite(siteDAO: SiteDAO): SiteDAO? = delegate.createSite(siteDAO)?.also { cache.put(1, it) }

    override suspend fun editSite(siteDAO: SiteDAO): Boolean {
        cache.put(1, siteDAO)
        return delegate.editSite(siteDAO)
    }
}