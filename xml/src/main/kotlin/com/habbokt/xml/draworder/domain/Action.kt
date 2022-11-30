package com.habbokt.xml.draworder.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Action(
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: String,
    @JacksonXmlProperty(localName = "direction")
    val directions: List<Direction>
)
