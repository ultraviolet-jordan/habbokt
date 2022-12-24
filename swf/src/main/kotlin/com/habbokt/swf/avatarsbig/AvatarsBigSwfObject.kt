package com.habbokt.swf.avatarsbig

import com.habbokt.swf.SwfExport
import com.habbokt.swf.SwfImage
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
data class AvatarsBigSwfObject(
    val export: SwfExport,
    val image: SwfImage?,
    val image2: SwfImage2?,
    val shape: SwfShape,
    val clip: SwfMovieClip
)