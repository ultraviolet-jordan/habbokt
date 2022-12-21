package com.habbokt.api.map

/**
 * @author Jordan Abraham
 */
@JvmInline
value class HeightMap(
    val map: String
) {
    inline val sizeX: Int get() = map.split("|").maxOf { it.length }
    inline val sizeY: Int get() = map.split("|").size
    inline val rows: List<String> get() = map.replace("\n", "\r").split("|")
}