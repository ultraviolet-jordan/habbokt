package com.habbokt.page.index

import com.habbokt.page.PageRequest

/**
 * <b>Example</b>
 *
 * ```
 * IndexPageRequest(rememberMe = true, username = "jordan")
 * ```
 *
 * @author Jordan Abraham
 *
 * @see IndexPage
 * @see IndexPageRouting
 * @see IndexPageService
 *
 * @constructor Creates a new [PageRequest].
 *
 * @property rememberMe A [Boolean] whether if this page attempted login with the "Remember me" option checked.
 * @property username A [String] of the attempted login username on this page.
 */
data class IndexPageRequest(
    val rememberMe: Boolean,
    val username: String?
) : PageRequest