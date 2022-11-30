package com.habbokt.xml.figuredata

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class HiddenLayers(
    @JacksonXmlProperty(localName = "layer")
    val layers: List<Layer>
)