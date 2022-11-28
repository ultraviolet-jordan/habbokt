package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UserRightsPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.PacketAssembler

/**
 * @author Jordan Abraham
 */
@Singleton
class UserRightsPacketAssembler : PacketAssembler<UserRightsPacket>(Assembler(id = 2){})