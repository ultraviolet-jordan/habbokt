package com.habbokt.page.account.submit

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.BaseTemplate

/**
 * @author Jordan Abraham
 */
class AccountSubmitPageTemplate(
    site: SiteDAO?
) : BaseTemplate(path = "account/submit.tpl", site)