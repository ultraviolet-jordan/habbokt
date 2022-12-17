package com.habbokt.api.room

/**
 * @author Jordan Abraham
 */
data class Room(
    val port: Int,
    val type: Int,
    val name: String,
    var userCount: Int,
    var maxUsers: Int,
    val parentId: Int,
    val description: String,
    val door: Int,
    val swfCast: String,
    var usersInQueue: Int,
    var visible: Boolean
)