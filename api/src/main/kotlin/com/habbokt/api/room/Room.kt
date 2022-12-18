package com.habbokt.api.room

/**
 * @author Jordan Abraham
 */
data class Room(
    val id: Int,
    val port: Int,
    val name: String,
    var userCount: Int,
    var maxUsers: Int,
    val parentId: Int,
    val description: String,
    val door: Int,
    val swfCast: String,
    var usersInQueue: Int,
    var visible: Boolean,
    val owner: String
)