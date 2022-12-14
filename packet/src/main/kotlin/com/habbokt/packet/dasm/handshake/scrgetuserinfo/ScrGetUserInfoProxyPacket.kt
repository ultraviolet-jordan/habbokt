package com.habbokt.packet.dasm.handshake.scrgetuserinfo

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class ScrGetUserInfoProxyPacket(
    val productName: String
) : ProxyPacket