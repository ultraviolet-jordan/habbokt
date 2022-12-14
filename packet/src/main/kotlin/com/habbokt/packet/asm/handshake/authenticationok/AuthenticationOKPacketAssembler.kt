package com.habbokt.packet.asm.handshake.authenticationok

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class AuthenticationOKPacketAssembler : PacketAssembler<AuthenticationOKPacket>(Assembler(id = 3){})