package com.habbokt.web.page.index

import com.habbokt.web.model.Site
import com.habbokt.web.page.Page
import io.ktor.http.Parameters

/**
 * @author Jordan Abraham
 */
class IndexPage(
    private val site: Site,
) : Page {
    override fun templateName(): String = "index.tpl"

    override fun context(parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to site,
        "rememberMe" to parameters["rememberme"].toBoolean(),
        "username" to parameters["username"]
    )
}
