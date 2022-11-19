package com.habbokt.api.plugin

import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.handler.*
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.createApplicationPlugin
import io.ktor.util.AttributeKey
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
val PacketHandlerPluginKey = AttributeKey<Map<KClass<*>, PacketHandlerDeclaration<Packet>>>("PacketHandlerPluginKey")

val PacketHandlerPlugin: ApplicationPlugin<PacketHandlerConfig> = createApplicationPlugin("PacketHandlerPlugin", ::PacketHandlerConfig) {
    application.attributes.put(PacketHandlerPluginKey, pluginConfig.declarations)
}