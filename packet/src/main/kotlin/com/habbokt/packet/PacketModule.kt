package com.habbokt.packet

import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.asm.handshake.ClientHelloAssembler
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMultibinder

/**
 * @author Jordan Abraham
 */
object PacketModule : KotlinModule() {
    override fun configure() {
        val assemblers = KotlinMultibinder.newSetBinder<AssemblerListener<*>>(binder())
        assemblers.addBinding().to<ClientHelloAssembler>()
    }
}