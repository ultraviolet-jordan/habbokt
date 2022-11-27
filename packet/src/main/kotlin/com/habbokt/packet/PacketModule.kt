package com.habbokt.packet

import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.asm.handshake.ClientHelloAssembler
import com.habbokt.packet.asm.handshake.CompleteDiffieHandshakeResponseAssembler
import com.habbokt.packet.asm.handshake.InitDiffieHandshakeResponseAssembler
import com.habbokt.packet.dasm.DisassemblerListener
import com.habbokt.packet.dasm.handshake.CompleteDiffieHandshakeRequestDisassembler
import com.habbokt.packet.dasm.handshake.InitDiffieHandshakeDisassembler
import com.habbokt.packet.dasm.handshake.VersionCheckDisassembler
import com.habbokt.packet.handler.HandlerListener
import com.habbokt.packet.handler.handshake.CompleteDiffieHandshakeRequestHandler
import com.habbokt.packet.handler.handshake.InitDiffieHandshakeRequestHandler
import com.habbokt.packet.handler.handshake.VersionCheckHandler
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
        assemblers.addBinding().to<CompleteDiffieHandshakeResponseAssembler>()

        // Disassemblers
        val disassemblers = KotlinMultibinder.newSetBinder<DisassemblerListener>(kotlinBinder)
        disassemblers.addBinding().to<InitDiffieHandshakeDisassembler>()
        disassemblers.addBinding().to<CompleteDiffieHandshakeRequestDisassembler>()
        disassemblers.addBinding().to<VersionCheckDisassembler>()

        // Handlers
        val handlers = KotlinMultibinder.newSetBinder<HandlerListener<*>>(kotlinBinder)
        handlers.addBinding().to<InitDiffieHandshakeRequestHandler>()
        handlers.addBinding().to<CompleteDiffieHandshakeRequestHandler>()
        handlers.addBinding().to<VersionCheckHandler>()
    }
}