package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class PageTemplate constructor(
    val path: String,
) : MutableMap<String, Any?> by mutableMapOf() {
    abstract fun configure()

    protected fun bind(context: Pair<String, Any?>) = put(context.first, context.second)
    protected infix fun String.to(value: Any?): Pair<String, Any?> = Pair(this, value)
}

data class Template<T>(
    val block: suspend () -> T
)