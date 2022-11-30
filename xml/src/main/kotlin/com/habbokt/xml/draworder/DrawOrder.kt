package com.habbokt.xml.draworder

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

/**
 * @author Jordan Abraham
 */
@JacksonXmlRootElement(localName = "actionSet")
data class DrawOrder(
    @JacksonXmlProperty(localName = "action")
    val actions: List<Action>
)