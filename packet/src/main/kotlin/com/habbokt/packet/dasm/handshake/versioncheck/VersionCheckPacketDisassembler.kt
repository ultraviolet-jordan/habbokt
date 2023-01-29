package com.habbokt.packet.dasm.handshake.versioncheck

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo
import com.habbokt.packet.buf.getStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckPacketDisassembler : PacketDisassembler<VersionCheckPacket>(
    body = {
        VersionCheckPacket(
            clientVersionId = getIntHabbo(),
            clientUrl = getStringHabbo(),
            clientVarsUrl = getStringHabbo()
        )
    }
)