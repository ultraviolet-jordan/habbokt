package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.*
import com.habbokt.api.packet.*
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val ScrGetUserInfoPacketDisassembler = disassembler(id = 26) {
    ScrGetUserInfoPacket(
        key = it.getStringHabbo()
    )
}