package com.habbokt.page

import com.habbokt.dao.site.SiteDAO

/**
 * @author Jordan Abraham
 */
open class PageTemplate constructor(
    val path: String,
    site: SiteDAO?
) : MutableMap<String, Any?> by mutableMapOf("site" to site)

data class Template<out T : PageTemplate>(
    val block: suspend () -> T
)