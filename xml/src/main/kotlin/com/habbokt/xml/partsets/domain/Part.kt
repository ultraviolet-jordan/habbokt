package com.habbokt.xml.partsets.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Part(
    @JacksonXmlProperty(localName = "set-type", isAttribute = true)
    val setType: String,
    @JacksonXmlProperty(localName = "swim", isAttribute = true)
    val swim: Int?,
    @JacksonXmlProperty(localName = "flipped-set-type", isAttribute = true)
    val flippedSetType: String?,
    @JacksonXmlProperty(localName = "remove-set-type", isAttribute = true)
    val removeSetType: String?
)