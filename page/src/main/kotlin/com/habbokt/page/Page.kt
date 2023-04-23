package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class Page<R : PageRequest>(
    val name: String,
    val template: suspend MutableMap<String, Any>.(R) -> Unit
)