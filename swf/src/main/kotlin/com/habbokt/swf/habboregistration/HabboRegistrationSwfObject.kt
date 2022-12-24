package com.habbokt.swf.habboregistration

import com.habbokt.swf.SwfExport
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
data class HabboRegistrationSwfObject(
    val export: SwfExport,
    val image: SwfImage2,
    val shape: SwfShape,
    val clip: SwfMovieClip
)