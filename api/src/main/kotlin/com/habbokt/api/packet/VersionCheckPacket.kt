package com.habbokt.api.packet

/**
 * @author Jordan Abraham
 */
data class VersionCheckPacket(
    val clientVersionId: Int,
    val clientUrl: String,
    val clientVarsUrl: String
) : Packet