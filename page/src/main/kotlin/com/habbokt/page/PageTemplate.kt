package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class PageTemplate constructor(
    val path: String,
    val configuration: PageTemplate.() -> Unit
) : MutableMap<String, Any?> by mutableMapOf()

fun PageTemplate.bind(context: Pair<String, Any?>): Any? = put(context.first, context.second)

data class Template<T>(
    val block: suspend () -> T
)