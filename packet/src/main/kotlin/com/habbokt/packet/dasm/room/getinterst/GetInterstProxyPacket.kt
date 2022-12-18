package com.habbokt.packet.dasm.room.getinterst

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class GetInterstProxyPacket(
    val parameter: String
) : ProxyPacket