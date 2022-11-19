package com.habbokt.game.packet.assembler

import com.habbokt.api.packet.AuthenticationOKPacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val AuthenticationOKPacketAssembler = assembler<AuthenticationOKPacket>(id = 3) {}