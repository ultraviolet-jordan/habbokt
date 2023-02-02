package com.habbokt.page.help

import com.habbokt.page.PageRequest

/**
 * @author Jordan Abraham
 */
data class FaqPageRequest(
    val helpId: Int?,
    val userId: Int?
) : PageRequest