package com.habbokt.xml.partsets.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

/**
 * @author Jordan Abraham
 */
@JacksonXmlRootElement(localName = "partSets")
data class PartSets(
    @JacksonXmlProperty(localName = "partSet")
    val partSet: PartSet,
    @JacksonXmlProperty(localName = "activePartSet")
    val activePartSets: List<ActivePartSet>
)