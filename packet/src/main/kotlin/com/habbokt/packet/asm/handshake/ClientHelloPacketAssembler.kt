package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.ClientHelloPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientHelloPacketAssembler : PacketAssembler<ClientHelloPacket>(Assembler(id = 0){})