package com.habbokt.xml.partsets.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class PartSet(
    @JacksonXmlProperty(localName = "part")
    val parts: List<Part>
)