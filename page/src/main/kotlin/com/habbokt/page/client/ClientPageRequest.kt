package com.habbokt.page.client

import com.habbokt.page.PageRequest
import com.habbokt.session.UserSession

/**
 * @author Jordan Abraham
 */
data class ClientPageRequest(
    val userSession: UserSession
) : PageRequest