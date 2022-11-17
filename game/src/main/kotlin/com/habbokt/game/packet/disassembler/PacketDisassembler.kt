package com.habbokt.game.packet.disassembler

import com.habbokt.game.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class PacketDisassembler(
    val packet: (ByteBuffer) -> Packet
)