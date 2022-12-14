package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Palette(
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(localName = "color")
    val colors: List<Color>
)