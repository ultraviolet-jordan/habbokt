package com.habbokt.api.player

/**
 * @author Jordan Abraham
 */
interface Player {
    fun id(): Int
    fun username(): String
    fun password(): String
    fun email(): String
    fun appearance(): String
    fun gender(): String
}