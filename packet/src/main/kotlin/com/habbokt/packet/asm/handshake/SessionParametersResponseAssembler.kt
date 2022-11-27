package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.api.common.toInt
import com.habbokt.packet.SessionParametersResponsePacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersResponseAssembler : AssemblerListener<SessionParametersResponsePacket>(Assembler(id = 257) {
    it.putIntHabbo(sessionParameters.size)
    sessionParameters.forEach { param ->
        require(param.parameterValue is String || param.parameterValue is Int || param.parameterValue is Boolean)

        it.putIntHabbo(param.parameterId.id)
        when (param.parameterValue) {
            is String -> it.putStringHabbo(param.parameterValue as String)
            is Int -> it.putIntHabbo(param.parameterValue as Int)
            else -> it.putIntHabbo((param.parameterValue as Boolean).toInt())
        }
    }
})