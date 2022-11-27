package com.habbokt.packet

import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.asm.handshake.ClientHelloAssembler
import com.habbokt.packet.asm.handshake.InitDiffieHandshakeResponseAssembler
import com.habbokt.packet.dasm.DisassemblerListener
import com.habbokt.packet.dasm.handshake.InitDiffieHandshakeDisassembler
import com.habbokt.packet.handler.HandlerListener
import com.habbokt.packet.handler.handshake.InitDiffieHandshakeRequestHandler
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMultibinder

/**
 * @author Jordan Abraham
 */
object PacketModule : KotlinModule() {
    override fun configure() {
        // Assemblers
        val assemblers = KotlinMultibinder.newSetBinder<AssemblerListener<*>>(kotlinBinder)
        assemblers.addBinding().to<ClientHelloAssembler>()
        assemblers.addBinding().to<InitDiffieHandshakeResponseAssembler>()

        // Disassemblers
        val disassemblers = KotlinMultibinder.newSetBinder<DisassemblerListener>(kotlinBinder)
        disassemblers.addBinding().to<InitDiffieHandshakeDisassembler>()

        // Handlers
        val handlers = KotlinMultibinder.newSetBinder<HandlerListener<*>>(kotlinBinder)
        handlers.addBinding().to<InitDiffieHandshakeRequestHandler>()
    }
}