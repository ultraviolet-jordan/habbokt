package com.habbokt.packet.dasm.handshake.versioncheck

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckPacketHandler : PacketHandler<VersionCheckProxyPacket>(
    handler = {}
)