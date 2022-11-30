package com.habbokt.xml.figuredata

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

/**
 * @author Jordan Abraham
 */
@JacksonXmlRootElement(localName = "figuredata")
data class FigureData(
    val colors: Colors,
    val sets: Sets
)