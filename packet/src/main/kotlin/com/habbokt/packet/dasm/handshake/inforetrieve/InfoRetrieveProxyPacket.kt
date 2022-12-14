package com.habbokt.packet.dasm.handshake.inforetrieve

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class InfoRetrieveProxyPacket(
    val id: String,
    val name: String,
    val figure: String,
    val sex: String,
    val motto: String
) : ProxyPacket