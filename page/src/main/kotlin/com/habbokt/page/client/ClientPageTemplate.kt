package com.habbokt.page.client

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class ClientPageTemplate(
    site: SiteDAO?,
    forwardRoom: Boolean,
    ssoTicket: String?
) : PageTemplate(
    path = "client.tpl",
    configuration = {
        bind("site" to site)
        bind("forwardRoom" to forwardRoom)
        bind("ssoTicket" to ssoTicket)
    }
)