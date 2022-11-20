package com.habbokt.api.plugin

import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.PacketDisassemblerDeclaration
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.createApplicationPlugin
import io.ktor.util.AttributeKey

/**
 * @author Jordan Abraham
 */
val PacketDisassemblerPluginKey = AttributeKey<Map<Int, PacketDisassemblerDeclaration>>("PacketDisassemblerPluginKey")

val PacketDisassemblerPlugin: ApplicationPlugin<PacketDisassemblerConfig> = createApplicationPlugin("PacketDisassemblerPlugin", ::PacketDisassemblerConfig) {
    application.attributes.put(PacketDisassemblerPluginKey, pluginConfig.declarations)
}