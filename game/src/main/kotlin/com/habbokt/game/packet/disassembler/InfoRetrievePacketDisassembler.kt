package com.habbokt.game.packet.disassembler

import com.habbokt.api.packet.*
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val InfoRetrievePacketDisassembler = disassembler(id = 7) {
    InfoRetrievePacket()
}