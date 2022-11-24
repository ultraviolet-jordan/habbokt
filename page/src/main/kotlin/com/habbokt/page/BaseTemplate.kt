package com.habbokt.page

import com.habbokt.dao.site.SiteDAO

/**
 * @author Jordan Abraham
 */
open class BaseTemplate constructor(
    val path: String,
    site: SiteDAO
) : MutableMap<String, Any?> by mutableMapOf("site" to site)