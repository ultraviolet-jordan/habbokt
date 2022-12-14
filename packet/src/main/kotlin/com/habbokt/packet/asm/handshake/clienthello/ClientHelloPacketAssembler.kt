package com.habbokt.packet.asm.handshake.clienthello

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientHelloPacketAssembler : PacketAssembler<ClientHelloPacket>(Assembler(id = 0){})