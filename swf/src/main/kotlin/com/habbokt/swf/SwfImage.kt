package com.habbokt.swf

import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.util.image.BufferedImageEncoder
import java.awt.image.BufferedImage

/**
 * @author Jordan Abraham
 */
@JvmInline
value class SwfImage2(
    val defineImage2: DefineImage2
) {
    inline val bufferedImage: BufferedImage get() = BufferedImageEncoder().apply {
        setImage(defineImage2)
    }.bufferedImage
}