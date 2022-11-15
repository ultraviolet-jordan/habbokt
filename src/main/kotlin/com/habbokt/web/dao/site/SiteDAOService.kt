package com.habbokt.web.dao.site

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
        serverOnline: Boolean
    ): Site? = delegate.createSite(siteName, staticContentPath, serverOnline)?.also { cache.put(1, it) }

    override suspend fun editSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean
    ): Boolean {
        cache.put(1, Site(siteName, staticContentPath, serverOnline))
        return delegate.editSite(siteName, staticContentPath, serverOnline)
    }
}
