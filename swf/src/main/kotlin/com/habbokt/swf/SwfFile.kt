package com.habbokt.swf

/**
 * @author Jordan Abraham
 */
open class SwfFile<S : SwfObjectType>(
    val name: String,
    val data: List<S>
)