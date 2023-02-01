package com.habbokt.page.security

import com.habbokt.page.PageRequest

/**
 * @author Jordan Abraham
 */
data class SecurityCheckPageRequest(
    val redirectPath: String
) : PageRequest