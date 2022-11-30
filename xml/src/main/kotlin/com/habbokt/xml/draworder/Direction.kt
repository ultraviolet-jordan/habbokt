package com.habbokt.xml.draworder

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Direction(
    @JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @JacksonXmlProperty(localName = "partList")
    val partList: PartList
)
