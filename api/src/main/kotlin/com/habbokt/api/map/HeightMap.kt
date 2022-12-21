package com.habbokt.api.map

/**
 * @author Jordan Abraham
 */
data class HeightMap(
    val sizeX: Int,
    val sizeY: Int,
    val tiles: Map<Tile, String>
)