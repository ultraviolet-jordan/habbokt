package com.habbokt.page

import com.google.inject.Inject
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
abstract class PageService<P : Page<*>>(
    private val get: (suspend ApplicationCall.(String) -> Any?)? = null,
    private val post: (suspend ApplicationCall.(String) -> Any?)? = null
) {
    @Inject
    private lateinit var page: P

    @Inject
    private lateinit var compiler: Compiler

    suspend fun getRequest(call: ApplicationCall) {
        require(get != null)
        get.invoke(call, compileHtml(call))
    }

    suspend fun postRequest(call: ApplicationCall) {
        require(post != null)
        post.invoke(call, compileHtml(call))
    }

    private suspend fun compileHtml(call: ApplicationCall): String = page.template(call.sessions, call.request).let {
        if (it.path.isEmpty()) "" else compiler.compile(it.path, it.filterValues { x -> x != null })
    }
}