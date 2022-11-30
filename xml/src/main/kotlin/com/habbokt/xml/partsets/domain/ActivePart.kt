package com.habbokt.xml.partsets.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class ActivePart(
    @JacksonXmlProperty(localName = "set-type", isAttribute = true)
    val setType: String
)