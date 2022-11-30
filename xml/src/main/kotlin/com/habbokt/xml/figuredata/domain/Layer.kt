package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Layer(
    @JacksonXmlProperty(localName = "parttype", isAttribute = true)
    val partType: String
)