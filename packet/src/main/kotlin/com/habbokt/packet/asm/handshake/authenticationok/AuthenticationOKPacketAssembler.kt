package com.habbokt.packet.asm.handshake.authenticationok

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class AuthenticationOKPacketAssembler : PacketAssembler<AuthenticationOKPacket>(
    id = 3,
    body = {}
)