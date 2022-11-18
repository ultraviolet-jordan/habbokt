package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.buffer.toInt
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet
import com.habbokt.api.packet.InfoRetrieveResponsePacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installInfoRetrieveResponsePacket() {
    packet<InfoRetrieveResponsePacket>(id = 257) {
        it.putIntHabbo(sessionParameters.size)
        sessionParameters.forEach { param ->
            require(param.parameterValue is String || param.parameterValue is Boolean)

            it.putIntHabbo(param.parameterId.id)
            if (param.parameterValue is String) {
                it.putStringHabbo(param.parameterValue as String)
            } else {
                it.putIntHabbo((param.parameterValue as Boolean).toInt())
            }
        }
    }
}