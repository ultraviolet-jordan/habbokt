package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Set(
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(localName = "gender", isAttribute = true)
    val gender: String,
    @JacksonXmlProperty(localName = "club", isAttribute = true)
    val club: Int,
    @JacksonXmlProperty(localName = "colorable", isAttribute = true)
    val colorable: Int,
    @JacksonXmlProperty(localName = "selectable", isAttribute = true)
    val selectable: Int,
    @JacksonXmlProperty(localName = "part")
    val part: Part,
    @JacksonXmlProperty(localName = "hiddenlayers")
    val hiddenLayers: HiddenLayers?
)