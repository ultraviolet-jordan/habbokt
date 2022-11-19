package com.habbokt.game.packet.assembler

import com.habbokt.api.packet.ClientHelloPacket
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installClientHelloPacket() {
    packet<ClientHelloPacket>(id = 0) {}
}