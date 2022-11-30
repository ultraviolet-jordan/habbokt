package com.habbokt.xml.figuredata

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Part(
    @JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(isAttribute = true)
    val type: String,
    @JacksonXmlProperty(isAttribute = true)
    val colorable: Int,
    @JacksonXmlProperty(isAttribute = true)
    val index: Int
)