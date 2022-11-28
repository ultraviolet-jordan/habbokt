package com.habbokt.page.client

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class ClientPageTemplate(
    private val site: SiteDAO?,
    private val forwardRoom: Boolean,
    private val ssoTicket: String?
) : PageTemplate(path = "client.tpl") {
    override fun configure() {
        bind("site" to site)
        bind("forwardRoom" to forwardRoom)
        bind("ssoTicket" to ssoTicket)
    }
}