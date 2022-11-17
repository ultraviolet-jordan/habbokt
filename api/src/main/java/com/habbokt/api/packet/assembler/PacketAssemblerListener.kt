package com.habbokt.api.packet.assembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
object PacketAssemblerListener : MutableMap<KClass<*>, PacketAssembler> by mutableMapOf() {
    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : Packet> assemblePacket(id: Int, noinline packet: T.(ByteBuffer) -> Unit) {
        this[T::class] = PacketAssembler(id, packet as Packet.(ByteBuffer) -> Unit)
    }
}