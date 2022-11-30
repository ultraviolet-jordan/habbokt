package com.habbokt.xml.partsets.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class ActivePartSet(
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    val id: String,
    @JacksonXmlProperty(localName = "activePart")
    val activeParts: List<ActivePart>
)