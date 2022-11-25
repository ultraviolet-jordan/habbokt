package com.habbokt.page.client

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class ClientPageTemplate(
    site: SiteDAO?,
    forwardRoom: Boolean,
    ssoTicket: String?
) : PageTemplate("client.tpl") {
    init {
        this["site"] to site
        this["forwardRoom"] to forwardRoom
        this["ssoTicket"] to ssoTicket
    }
}