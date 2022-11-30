package com.habbokt.xml.draworder.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Part(
    @JacksonXmlProperty(localName = "set-type", isAttribute = true)
    val setType: String
)