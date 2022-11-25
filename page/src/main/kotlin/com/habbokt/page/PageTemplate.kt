package com.habbokt.page

/**
 * @author Jordan Abraham
 */
open class PageTemplate constructor(
    val path: String
) : MutableMap<String, Any?> by mutableMapOf()

data class Template<out T : PageTemplate>(
    val block: suspend () -> T
)