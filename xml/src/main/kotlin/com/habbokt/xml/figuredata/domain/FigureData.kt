package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

/**
 * @author Jordan Abraham
 */
@JacksonXmlRootElement(localName = "figuredata")
data class FigureData(
    @JacksonXmlProperty(localName = "colors")
    val colors: Colors,
    @JacksonXmlProperty(localName = "sets")
    val sets: Sets
)