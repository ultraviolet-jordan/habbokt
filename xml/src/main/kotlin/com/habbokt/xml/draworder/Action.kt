package com.habbokt.xml.draworder

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Action(
    @JacksonXmlProperty(isAttribute = true)
    val id: String,
    @JacksonXmlProperty(localName = "direction")
    val directions: List<Direction>
)
