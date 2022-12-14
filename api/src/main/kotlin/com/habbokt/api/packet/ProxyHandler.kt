package com.habbokt.api.packet

import com.habbokt.api.client.Client

/**
 * @author Jordan Abraham
 */
data class ProxyHandler<in P : Packet>(
    val block: suspend P.(Client) -> ProxyPacket?
)