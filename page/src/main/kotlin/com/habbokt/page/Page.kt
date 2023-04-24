package com.habbokt.page

/**
 * @author Jordan Abraham
 *
 * @see PageRequest
 * @see PageRouting
 * @see PageService
 *
 * @property R The [PageRequest] that is used for the [template].
 * @property name The resources name of this page template file.
 * @property template The template builder for building the html of this page.
 */
abstract class Page<R : PageRequest>(
    val name: String,
    val template: suspend MutableMap<String, Any>.(R) -> Unit
)