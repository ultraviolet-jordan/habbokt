package com.habbokt.api.entity.player

import com.habbokt.api.client.Client

/**
 * @author Jordan Abraham
 */
abstract class Player(
    val id: Int,
    val client: Client
) {
    abstract fun login()
}