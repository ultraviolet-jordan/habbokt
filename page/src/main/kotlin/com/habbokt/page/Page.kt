package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class Page<T : PageTemplate, R : PageRequest>(
    private val template: suspend R.() -> T
) {
    suspend fun template(request: R): T = template.invoke(request).also { it.configuration.invoke(it) }
}