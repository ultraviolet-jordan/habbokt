package com.habbokt.swf.badgeeditor

import com.habbokt.swf.SwfImage
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
data class BadgeEditorSwfObject(
    val image: SwfImage?,
    val image2: SwfImage2?,
    val shape: SwfShape,
    val clip: SwfMovieClip
)