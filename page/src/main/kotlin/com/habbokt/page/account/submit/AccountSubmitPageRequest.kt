package com.habbokt.page.account.logout

import com.habbokt.page.Request
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
data class AccountLogoutPageRequest(
    val session: CurrentSession,
    val username: String,
    val password: String,
    val rememberMe: Boolean
) : Request