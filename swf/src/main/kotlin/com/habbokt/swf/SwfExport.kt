package com.habbokt.swf

import com.flagstone.transform.Export

/**
 * @author Jordan Abraham
 */
@JvmInline
value class SwfExport(
    val export: Export
) {
    inline val name: String get() = export.objects.values.first()
}