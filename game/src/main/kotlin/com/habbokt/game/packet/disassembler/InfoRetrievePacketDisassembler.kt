package com.habbokt.game.packet.disassembler

import com.habbokt.api.packet.InfoRetrievePacket
import com.habbokt.api.packet.disassembler.disassembler

/**
 * @author Jordan Abraham
 */
val InfoRetrievePacketDisassembler = disassembler(id = 7) {
    InfoRetrievePacket()
}