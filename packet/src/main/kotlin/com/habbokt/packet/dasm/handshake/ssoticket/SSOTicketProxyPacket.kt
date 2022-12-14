package com.habbokt.packet.dasm.handshake.ssoticket

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class SSOTicketProxyPacket(
    val userId: Int
) : ProxyPacket