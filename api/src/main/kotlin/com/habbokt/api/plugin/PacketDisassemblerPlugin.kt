package com.habbokt.api.plugin

import com.habbokt.api.packet.disassembler.PacketDisassembler
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.createApplicationPlugin
import io.ktor.util.AttributeKey

/**
 * @author Jordan Abraham
 */
val PacketDisassemblerPluginKey = AttributeKey<Map<Int, PacketDisassembler>>("PacketDisassemblerPluginKey")

val PacketDisassemblerPlugin: ApplicationPlugin<PacketDisassemblerConfig> = createApplicationPlugin("PacketDisassemblerPlugin", ::PacketDisassemblerConfig) {
    application.attributes.put(PacketDisassemblerPluginKey, pluginConfig.disassemblers)
}