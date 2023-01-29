package com.habbokt.packet.asm.handshake.sessionparameters

import com.google.inject.Singleton
import com.habbokt.api.common.toInt
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersResponsePacketAssembler : PacketAssembler<SessionParametersResponsePacket>(
    id = 257,
    body = {
        putIntHabbo(it.sessionParameters.size)
        it.sessionParameters.forEach { param ->
            require(param.parameterValue is String || param.parameterValue is Int || param.parameterValue is Boolean)

            putIntHabbo(param.parameterId.id)
            when (param.parameterValue) {
                is String -> putStringHabbo(param.parameterValue as String)
                is Int -> putIntHabbo(param.parameterValue as Int)
                else -> putIntHabbo((param.parameterValue as Boolean).toInt())
            }
        }
    }
)