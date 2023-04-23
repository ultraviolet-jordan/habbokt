package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class PageTemplate constructor(
    val path: String,
    val configuration: PageTemplate.() -> Unit
) : MutableMap<String, Any> by mutableMapOf()