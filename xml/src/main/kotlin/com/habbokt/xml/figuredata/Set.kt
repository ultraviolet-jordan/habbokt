package com.habbokt.xml.figuredata

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Set(
    @JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(isAttribute = true)
    val gender: String,
    @JacksonXmlProperty(isAttribute = true)
    val club: Int,
    @JacksonXmlProperty(isAttribute = true)
    val colorable: Int,
    @JacksonXmlProperty(isAttribute = true)
    val selectable: Int,
    val part: Part,
    @JacksonXmlProperty(localName = "hiddenlayers")
    val hiddenLayers: HiddenLayers?
)