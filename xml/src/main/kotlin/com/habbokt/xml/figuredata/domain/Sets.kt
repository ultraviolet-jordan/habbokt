package com.habbokt.xml.figuredata.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

/**
 * @author Jordan Abraham
 */
data class Sets(
    @JacksonXmlProperty(localName = "settype")
    val setTypes: List<SetType>
)