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
        sitePath: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: Int,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Site? = delegate.createSite(
        siteName,
        sitePath,
        staticContentPath,
        serverOnline,
        loaderGameIp,
        loaderGamePort,
        loaderDcr,
        loaderVariables,
        loaderTexts
    )?.also { cache.put(1, it) }

    override suspend fun editSite(
        siteName: String,
        sitePath: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: Int,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Boolean {
        cache.put(1, Site(
            siteName,
            sitePath,
            staticContentPath,
            serverOnline,
            loaderGameIp,
            loaderGamePort,
            loaderDcr,
            loaderVariables,
            loaderTexts
        ))
        return delegate.editSite(
            siteName,
            sitePath,
            staticContentPath,
            serverOnline,
            loaderGameIp,
            loaderGamePort,
            loaderDcr,
            loaderVariables,
            loaderTexts
        )
    }
}
