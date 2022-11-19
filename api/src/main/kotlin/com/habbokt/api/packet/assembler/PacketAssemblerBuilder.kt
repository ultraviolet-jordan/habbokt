package com.habbokt.api.packet.assembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
inline fun <reified P : Packet> assembler(
    id: Int,
    noinline block: P.(ByteBuffer) -> Unit
): PacketAssemblerDeclaration<P> = PacketAssemblerDeclaration(P::class, PacketAssembler(id, block))

fun <T : PacketAssemblerDeclaration<*>> PacketAssemblerConfig.assemblers(vararg assemblers: T) {
    assemblers.forEach(::register)
}