package com.habbokt.page.habboimaging.avatarimage

import com.habbokt.page.PageRequest

/**
 * @author Jordan Abraham
 */
data class AvatarImageRequest(
    val figure: String,
    val size: String,
    val direction: String,
    val headDirection: String,
    val crr: String,
    val gesture: String,
    val frame: String
) : PageRequest