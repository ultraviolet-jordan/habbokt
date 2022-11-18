package com.habbokt.game.packet.assembler

import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet
import com.habbokt.game.packet.UserRightsPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installUserRightsPacket() {
    packet<UserRightsPacket>(2) {
        UserRightsPacket()
    }
}