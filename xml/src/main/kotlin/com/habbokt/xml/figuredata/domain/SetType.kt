package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class SetType(
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    val type: String,
    @JacksonXmlProperty(localName = "paletteid", isAttribute = true)
    val paletteId: Int,
    @JacksonXmlProperty(localName = "mandatory", isAttribute = true)
    val mandatory: Int,
    @JacksonXmlProperty(localName = "set")
    val sets: List<Set>
)