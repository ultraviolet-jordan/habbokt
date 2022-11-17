package com.habbokt.game.packet.assembler

import com.habbokt.game.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class PacketAssembler(
    val id: Int,
    val packet: Packet.(ByteBuffer) -> Unit
)