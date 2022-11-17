package com.habbokt.api.plugin

import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.assembler.PacketAssembler
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.createApplicationPlugin
import io.ktor.util.AttributeKey
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
val PacketAssemblerPluginKey = AttributeKey<Map<KClass<*>, PacketAssembler<Packet>>>("PacketAssemblerPluginKey")

@Suppress("UNCHECKED_CAST")
val PacketAssemblerPlugin: ApplicationPlugin<PacketAssemblerConfig> = createApplicationPlugin("PacketAssemblerPlugin", ::PacketAssemblerConfig) {
    application.attributes.put(PacketAssemblerPluginKey, pluginConfig.assemblers as Map<KClass<*>, PacketAssembler<Packet>>)
}