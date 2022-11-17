package com.habbokt.game.packet

import com.habbokt.game.packet.assembler.PacketAssemblerListener
import com.habbokt.game.packet.assembler.completeDiffieHandshakePacket
import com.habbokt.game.packet.assembler.disconnectReasonPacket
import com.habbokt.game.packet.assembler.initDiffieHandshakePacket
import com.habbokt.game.packet.assembler.uniqueMachineIDPacket
import com.habbokt.game.packet.disassembler.PacketDisassemblerListener
import com.habbokt.game.packet.disassembler.completeDiffieHandshakePacket
import com.habbokt.game.packet.disassembler.initDiffieHandshakePacket
import com.habbokt.game.packet.disassembler.uniqueMachineIDPacket
import com.habbokt.game.packet.disassembler.versionCheckPacket
import com.habbokt.game.packet.handler.PacketHandlerListener
import com.habbokt.game.packet.handler.completeDiffieHandshakePacket
import com.habbokt.game.packet.handler.initDiffieHandshakePacket
import com.habbokt.game.packet.handler.uniqueMachineIDPacket
import com.habbokt.game.packet.handler.versionCheckPacket

/**
 * @author Jordan Abraham
 */
object PacketFactory {
    fun init() {
        PacketAssemblerListener.apply {
            initDiffieHandshakePacket()
            completeDiffieHandshakePacket()
            disconnectReasonPacket()
            uniqueMachineIDPacket()
        }

        PacketDisassemblerListener.apply {
            initDiffieHandshakePacket()
            completeDiffieHandshakePacket()
            versionCheckPacket()
            uniqueMachineIDPacket()
        }

        PacketHandlerListener.apply {
            initDiffieHandshakePacket()
            completeDiffieHandshakePacket()
            versionCheckPacket()
            uniqueMachineIDPacket()
        }
    }
}