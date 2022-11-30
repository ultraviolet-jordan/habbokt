package com.habbokt.api.entity.player

import com.habbokt.api.client.Client

/**
 * @author Jordan Abraham
 */
abstract class Player(
    val client: Client,
    val details: PlayerDetails
) {
    abstract fun login()
}