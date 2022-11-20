package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putIntHabbo
import com.habbokt.api.common.putStringHabbo
import com.habbokt.api.common.toInt
import com.habbokt.api.packet.SessionParametersResponsePacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val SessionParametersResponsePacketAssembler = assembler<SessionParametersResponsePacket>(id = 257) {
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