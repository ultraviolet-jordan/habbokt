package com.habbokt.api.packet

import com.habbokt.api.client.Client

/**
 * @author Jordan Abraham
 */
data class Handler<in P : ProxyPacket>(
    val block: P.(Client) -> Unit
)