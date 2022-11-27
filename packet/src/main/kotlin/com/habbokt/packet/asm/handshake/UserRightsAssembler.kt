package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UserRightsPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.AssemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class UserRightsAssembler : AssemblerListener<UserRightsPacket>(Assembler(id = 2){})