package com.habbokt.page

import io.ktor.server.pebble.PebbleContent

/**
 * @author Jordan Abraham
 */
interface ResponseType

class Html(
    val content: PebbleContent
) : ResponseType

class Png(
    val bytes: ByteArray
) : ResponseType

class Ajax(
    val json: String
) : ResponseType

class Redirect(
    val path: String
) : ResponseType

object None : ResponseType