package com.habbokt.api.plugin

import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.assembler.*
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.createApplicationPlugin
import io.ktor.util.AttributeKey
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
val PacketAssemblerPluginKey = AttributeKey<Map<KClass<*>, PacketAssemblerDeclaration<Packet>>>("PacketAssemblerPluginKey")

val PacketAssemblerPlugin: ApplicationPlugin<PacketAssemblerConfig> = createApplicationPlugin("PacketAssemblerPlugin", ::PacketAssemblerConfig) {
    application.attributes.put(PacketAssemblerPluginKey, pluginConfig.declarations)
}