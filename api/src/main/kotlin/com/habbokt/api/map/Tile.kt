package com.habbokt.api.map

/**
 * @author Jordan Abraham
 */
@JvmInline
value class Tile(
    val bitPack: Int
) {
    inline val x: Int get() = bitPack shr 8
    inline val y: Int get() = bitPack and 0xff
}