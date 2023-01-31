package com.habbokt.page

import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
abstract class BlankPageService(
    get: (suspend ApplicationCall.(String) -> Any?)? = null,
    post: (suspend ApplicationCall.(String) -> Any?)? = null
) : PageService<BlankPage>(get, post)