package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.buffer.toInt
import com.habbokt.api.packet.InfoRetrieveResponsePacket
import com.habbokt.api.packet.assembler.*

/**
 * @author Jordan Abraham
 */
val InfoRetrieveResponsePacketAssembler = assembler<InfoRetrieveResponsePacket>(id = 257) {
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