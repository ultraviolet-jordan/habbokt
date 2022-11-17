package com.habbokt.api.packet.assembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
inline fun <reified P : Packet> PacketAssemblerConfig.packet(
    id: Int,
    noinline block: P.(ByteBuffer) -> Unit
) {
    val assembler = PacketAssembler(id, block)
    packet(assembler)
}

@PublishedApi
internal inline fun <reified P : Packet> PacketAssemblerConfig.packet(assembler: PacketAssembler<P>) {
    register(P::class, assembler)
}