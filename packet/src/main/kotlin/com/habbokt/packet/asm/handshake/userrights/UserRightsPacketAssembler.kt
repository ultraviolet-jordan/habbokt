package com.habbokt.packet.asm.handshake.userrights

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class UserRightsPacketAssembler : PacketAssembler<UserRightsPacket>(Assembler(id = 2){})