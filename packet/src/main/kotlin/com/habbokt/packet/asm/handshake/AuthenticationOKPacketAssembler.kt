package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.AuthenticationOKPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class AuthenticationOKPacketAssembler : PacketAssembler<AuthenticationOKPacket>(Assembler(id = 3){})