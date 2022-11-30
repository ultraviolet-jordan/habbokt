package com.habbokt.xml.figuredata

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

/**
 * @author Jordan Abraham
 */
data class Color(
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(localName = "index", isAttribute = true)
    val index: Int,
    @JacksonXmlProperty(localName = "club", isAttribute = true)
    val club: Int,
    @JacksonXmlProperty(localName = "selectable", isAttribute = true)
    val selectable: Int,
    @JacksonXmlText
    @JsonProperty("text")
    val hex: String
)