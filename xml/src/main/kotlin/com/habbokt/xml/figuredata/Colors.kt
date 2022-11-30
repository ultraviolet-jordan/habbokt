package com.habbokt.xml.figuredata

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Colors(
    @JacksonXmlProperty(localName = "palette")
    val palettes: List<Palette>
)