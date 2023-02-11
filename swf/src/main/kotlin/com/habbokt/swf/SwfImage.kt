package com.habbokt.swf

import com.flagstone.transform.image.DefineImage
import com.flagstone.transform.util.image.BufferedImageEncoder
import java.awt.image.BufferedImage

/**
 * @author Jordan Abraham
 */
data class SwfImage(
    val defineImage: DefineImage,
    val bufferedImage: BufferedImage = BufferedImageEncoder().apply { setImage(defineImage) }.bufferedImage
)