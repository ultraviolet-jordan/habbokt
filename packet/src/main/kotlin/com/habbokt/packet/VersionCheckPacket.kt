package com.habbokt.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class VersionCheckPacket(
    val clientVersionId: Int,
    val clientUrl: String,
    val clientVarsUrl: String
) : Packet