package com.habbokt.game.packet.disassembler

import com.habbokt.api.common.getStringHabbo
import com.habbokt.api.packet.ScrGetUserInfoPacket
import com.habbokt.api.packet.disassembler.disassembler

/**
 * @author Jordan Abraham
 */
val ScrGetUserInfoPacketDisassembler = disassembler(id = 26) {
    ScrGetUserInfoPacket(
        productName = it.getStringHabbo()
    )
}