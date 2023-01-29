package com.habbokt.packet.dasm.handshake.ssoticket

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketPacketHandler : PacketHandler<SSOTicketProxyPacket>(
    handler = { authenticate(it.userId) }
)