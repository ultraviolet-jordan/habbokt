package com.habbokt.xml.figuredata

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

/**
 * @author Jordan Abraham
 */
data class Color(
    @JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(isAttribute = true)
    val index: Int,
    @JacksonXmlProperty(isAttribute = true)
    val club: Int,
    @JacksonXmlProperty(isAttribute = true)
    val selectable: Int,
    @JacksonXmlText
    @JsonProperty("text")
    val hex: String
)