package com.habbokt.page.habblet.ajax.namecheck

import com.habbokt.page.PageRequest

/**
 * @author Jordan Abraham
 */
data class NameCheckAjaxRequest(
    val name: String?
) : PageRequest