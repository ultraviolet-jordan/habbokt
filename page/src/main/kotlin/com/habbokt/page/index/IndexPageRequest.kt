package com.habbokt.page.index

import com.habbokt.page.PageRequest

/**
 * @author Jordan Abraham
 */
data class IndexPageRequest(
    val rememberMe: Boolean,
    val username: String?
) : PageRequest