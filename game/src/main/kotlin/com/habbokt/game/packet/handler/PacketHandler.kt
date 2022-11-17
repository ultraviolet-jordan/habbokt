package com.habbokt.game.packet.handler

import com.habbokt.game.client.Client
import com.habbokt.game.packet.Packet

/**
 * @author Jordan Abraham
 */
data class PacketHandler<out P : Packet>(
    val client: Client,
    val packet: P
)