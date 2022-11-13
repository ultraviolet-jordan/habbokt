package com.habbokt.web.session

import io.ktor.server.auth.Principal

/**
 * @author Jordan Abraham
 */
data class CaptchaSession(
    val captcha: String
) : Principal
