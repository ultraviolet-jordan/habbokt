package com.habbokt.dao

import com.habbokt.dao.site.SiteService
import com.habbokt.dao.site.SiteServiceDelegate
import com.habbokt.dao.site.SiteServiceEhcache
import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
object DAOModule : KotlinModule() {
    override fun configure() {
        bind<SiteService>().annotatedWith<ServiceDelegate>().to<SiteServiceDelegate>()
        bind<SiteService>().to<SiteServiceEhcache>()
    }
}