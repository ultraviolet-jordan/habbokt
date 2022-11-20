package com.habbokt.game.packet.disassembler

import com.habbokt.api.packet.SessionParametersRequestPacket
import com.habbokt.api.packet.disassembler.disassembler

/**
 * @author Jordan Abraham
 */
val SessionParametersRequestPacketDisassembler = disassembler(id = 1817) {
    SessionParametersRequestPacket()
}
