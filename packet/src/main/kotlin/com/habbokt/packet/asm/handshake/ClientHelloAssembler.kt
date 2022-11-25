package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.ClientHelloPacket
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.asm.asm

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientHelloAssembler : AssemblerListener<ClientHelloPacket>(asm(id = 0){})