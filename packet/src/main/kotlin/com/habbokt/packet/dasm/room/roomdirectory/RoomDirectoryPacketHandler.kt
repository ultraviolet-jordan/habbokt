package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryPacketHandler : PacketHandler<RoomDirectoryProxyPacket>(Handler {})