package com.habbokt.web.page.error

import com.habbokt.web.model.Site
import com.habbokt.web.page.Page
import io.ktor.http.Parameters

/**
 * @author Jordan Abraham
 */
class ErrorPage(
    private val site: Site
) : Page {
    override fun templateName(): String = "client_error.tpl"

    override fun context(parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to site,
        "error_id" to parameters["error_id"]
    )
}
