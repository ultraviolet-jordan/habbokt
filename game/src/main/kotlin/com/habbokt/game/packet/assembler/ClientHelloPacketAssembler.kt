package com.habbokt.game.packet.assembler

import com.habbokt.api.packet.ClientHelloPacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val ClientHelloPacketAssembler = assembler<ClientHelloPacket>(id = 0) {}