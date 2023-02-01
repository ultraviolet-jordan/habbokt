package com.habbokt.page.account.logout

import com.habbokt.page.PageRequest
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
data class AccountLogoutPageRequest(
    val session: CurrentSession
) : PageRequest