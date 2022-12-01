package com.habbokt.swf

import com.flagstone.transform.image.DefineImage
import com.flagstone.transform.util.image.BufferedImageEncoder
import java.awt.image.BufferedImage

/**
 * @author Jordan Abraham
 */
@JvmInline
value class SwfImage(
    val defineImage: DefineImage
) {
    inline val bufferedImage: BufferedImage get() = BufferedImageEncoder().apply {
        setImage(defineImage)
    }.bufferedImage
}