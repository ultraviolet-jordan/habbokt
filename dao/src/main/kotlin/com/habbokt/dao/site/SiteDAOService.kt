package com.habbokt.dao.site

import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
class SiteDAOService(
    private val delegate: SiteDAO,
    private val cache: Cache<Int, Site>
) : SiteDAO {
    override suspend fun site(): Site = cache[1] ?: delegate.site().also { cache.put(1, it) }

    override suspend fun createSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: String,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Site? = delegate.createSite(siteName, staticContentPath, serverOnline, loaderGameIp, loaderGamePort, loaderDcr, loaderVariables, loaderTexts)?.also { cache.put(1, it) }

    override suspend fun editSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: String,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Boolean {
        cache.put(1, Site(siteName, staticContentPath, serverOnline, loaderGameIp, loaderGamePort, loaderDcr, loaderVariables, loaderTexts))
        return delegate.editSite(siteName, staticContentPath, serverOnline, loaderGameIp, loaderGamePort, loaderDcr, loaderVariables, loaderTexts)
    }
}
