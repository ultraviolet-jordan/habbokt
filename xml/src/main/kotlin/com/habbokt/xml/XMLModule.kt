package com.habbokt.xml

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.habbokt.xml.draworder.DrawOrder
import com.habbokt.xml.figuredata.FigureData
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
        bind<FigureData>().toInstance(figureData)

        val drawOrder = mapper.readValue<DrawOrder>(File(this::class.java.classLoader.getResource("www/dcr/v31/gamedata/draworder.txt")!!.toURI()))
        bind<DrawOrder>().toInstance(drawOrder)
    }
}