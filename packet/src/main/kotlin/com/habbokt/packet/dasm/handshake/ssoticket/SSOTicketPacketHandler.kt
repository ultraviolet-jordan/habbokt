package com.habbokt.packet.dasm.handshake.ssoticket

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketPacketHandler : PacketHandler<SSOTicketProxyPacket>(Handler {
    it.authenticate(userId)
})