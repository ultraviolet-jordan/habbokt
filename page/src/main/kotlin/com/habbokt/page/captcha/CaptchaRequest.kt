package com.habbokt.page.captcha

import com.habbokt.page.PageRequest
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
data class CaptchaRequest(
    val session: CurrentSession
) : PageRequest