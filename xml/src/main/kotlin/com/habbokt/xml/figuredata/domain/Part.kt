package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Part(
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    val type: String,
    @JacksonXmlProperty(localName = "colorable", isAttribute = true)
    val colorable: Int,
    @JacksonXmlProperty(localName = "index", isAttribute = true)
    val index: Int
)