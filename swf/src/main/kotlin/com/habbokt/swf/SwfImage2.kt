package com.habbokt.swf

import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.util.image.BufferedImageEncoder
import java.awt.image.BufferedImage

/**
 * @author Jordan Abraham
 */
data class SwfImage2(
    val defineImage2: DefineImage2,
    val bufferedImage: BufferedImage = BufferedImageEncoder().apply { setImage(defineImage2) }.bufferedImage
)