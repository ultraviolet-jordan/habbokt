package com.habbokt.api.packet.handler

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
inline fun <reified P : Packet> handler(
    noinline handler: suspend PacketHandler<P>.() -> Unit
): PacketHandlerDeclaration<P> = PacketHandlerDeclaration(P::class, handler)

fun <T : PacketHandlerDeclaration<*>> PacketHandlerConfig.handlers(vararg handlers: T) {
    handlers.forEach(::register)
}