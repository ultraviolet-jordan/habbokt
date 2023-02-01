package com.habbokt.page.account.submit

import com.habbokt.page.PageRequest
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
data class AccountSubmitPageRequest(
    val session: CurrentSession,
    val username: String,
    val password: String,
    val rememberMe: Boolean
) : PageRequest