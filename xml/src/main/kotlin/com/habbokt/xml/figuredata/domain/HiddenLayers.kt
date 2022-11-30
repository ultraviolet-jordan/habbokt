package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class HiddenLayers(
    @JacksonXmlProperty(localName = "layer")
    val layers: List<Layer>
)