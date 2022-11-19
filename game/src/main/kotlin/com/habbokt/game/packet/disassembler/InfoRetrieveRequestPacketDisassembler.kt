package com.habbokt.game.packet.disassembler

import com.habbokt.api.packet.InfoRetrieveRequestPacket
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val InfoRetrieveRequestPacketDisassembler = disassembler(id = 1817) {
    InfoRetrieveRequestPacket()
}
