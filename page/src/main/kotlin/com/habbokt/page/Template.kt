package com.habbokt.page

import com.habbokt.dao.site.SiteDAO

/**
 * @author Jordan Abraham
 */
open class Template constructor(
    val path: String,
    siteDAO: SiteDAO
) : MutableMap<String, Any?> by mutableMapOf("site" to siteDAO)