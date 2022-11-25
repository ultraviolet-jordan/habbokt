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
) : PageTemplate(path = "client.tpl", site) {
    init {
        this["forwardRoom"] to forwardRoom
        this["ssoTicket"] to ssoTicket
    }
}