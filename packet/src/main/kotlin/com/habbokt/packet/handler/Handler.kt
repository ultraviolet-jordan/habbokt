package com.habbokt.packet.handler

import com.habbokt.api.client.Client
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class Handler<in P : Packet>(
    val block: suspend P.(Client) -> Unit
)