package com.habbokt.xml

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.habbokt.xml.draworder.DrawOrderDocument
import com.habbokt.xml.draworder.domain.DrawOrder
import com.habbokt.xml.figuredata.FigureDataDocument
import com.habbokt.xml.figuredata.domain.FigureData
import com.habbokt.xml.partsets.PartSetsDocument
import com.habbokt.xml.partsets.domain.PartSets
import dev.misfitlabs.kotlinguice4.KotlinModule
import java.io.File

/**
 * @author Jordan Abraham
 */
object XMLModule : KotlinModule() {
    override fun configure() {
        val mapper = XmlMapper(JacksonXmlModule().apply {
            setDefaultUseWrapper(false) // Remove xml wrapper.
            setXMLTextElementName("text") // Use this for raw text values in the xml.
        }).registerKotlinModule()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL) // Ignore null values for serialization.

        val figureData = mapper.readValue<FigureData>(File(this::class.java.classLoader.getResource("www/dcr/v31/gamedata/figuredata.txt")!!.toURI()))
        bind<XMLDocument<FigureData>>().toInstance(FigureDataDocument(figureData))

        val drawOrder = mapper.readValue<DrawOrder>(File(this::class.java.classLoader.getResource("www/dcr/v31/gamedata/draworder.txt")!!.toURI()))
        bind<XMLDocument<DrawOrder>>().toInstance(DrawOrderDocument(drawOrder))

        val partSets = mapper.readValue<PartSets>(File(this::class.java.classLoader.getResource("www/dcr/v31/gamedata/partsets.txt")!!.toURI()))
        bind<XMLDocument<PartSets>>().toInstance(PartSetsDocument(partSets))
    }
}