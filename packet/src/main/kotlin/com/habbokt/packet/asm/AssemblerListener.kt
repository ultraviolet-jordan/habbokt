package com.habbokt.packet.asm

import com.habbokt.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
abstract class AssemblerListener<P : Packet>(
    val declaration: PacketAssemblerDeclaration<P>
)

internal inline fun <reified P : Packet> asm(
    id: Int,
    noinline block: P.(ByteBuffer) -> Unit
): PacketAssemblerDeclaration<P> = PacketAssemblerDeclaration(P::class, Assembler(id, block))