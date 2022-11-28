package com.habbokt.dao.site

import com.google.inject.Inject
import com.google.inject.Singleton
import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
@Singleton
class SiteServiceEhcache @Inject constructor(
    private val delegate: SiteServiceDelegate,
    private val cache: Cache<Int, SiteDAO>
) : SiteService {
    override suspend fun site(): SiteDAO? = cache[1] ?: delegate.site()?.also { cache.put(1, it) }

    override suspend fun createSite(siteDAO: SiteDAO): SiteDAO? = delegate.createSite(siteDAO)?.also { cache.put(1, it) }

    override suspend fun editSite(siteDAO: SiteDAO): Boolean {
        cache.put(1, siteDAO)
        return delegate.editSite(siteDAO)
    }
}