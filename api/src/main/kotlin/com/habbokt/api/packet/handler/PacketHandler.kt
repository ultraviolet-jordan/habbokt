package com.habbokt.api.packet.handler

import com.habbokt.api.client.Client
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class PacketHandler<out P : Packet>(
    val client: Client,
    val packet: P
)