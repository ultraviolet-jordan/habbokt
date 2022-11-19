package com.habbokt.game.packet.assembler

import com.habbokt.api.packet.AuthenticationOKPacket
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installAuthenticationOKPacket() {
    packet<AuthenticationOKPacket>(id = 3) {}
}