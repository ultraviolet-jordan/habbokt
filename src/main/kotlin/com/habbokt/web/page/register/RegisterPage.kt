package com.habbokt.web.page.register

import com.habbokt.web.model.Site
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import kotlin.random.Random

/**
 * @author Jordan Abraham
 */
class RegisterPage(
    private val site: Site
) : Page {
    override fun templateName(): String = "register.tpl"

    override fun context(parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to site,
        "randomNum" to Random.nextInt(0, 10000).toString()
    )
}
