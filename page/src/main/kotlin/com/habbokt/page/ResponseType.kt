package com.habbokt.page

/**
 * @author Jordan Abraham
 */
interface ResponseType

class Html(
    val string: String
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