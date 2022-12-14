package com.habbokt.xml.draworder.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class PartList(
    @JacksonXmlProperty(localName = "part")
    val parts: List<Part>
)
