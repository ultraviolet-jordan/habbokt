package com.habbokt.api.packet.handler

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified P : Packet> PacketHandlerConfig.packet(noinline assembler: suspend PacketHandler<P>.() -> Unit) {
    register(P::class, assembler as suspend PacketHandler<Packet>.() -> Unit)
}