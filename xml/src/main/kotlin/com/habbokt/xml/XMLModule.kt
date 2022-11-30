package com.habbokt.xml

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.habbokt.xml.figuredata.FigureData
import dev.misfitlabs.kotlinguice4.KotlinModule
import java.io.File

/**
 * @author Jordan Abraham
 */
object XMLModule : KotlinModule() {
    override fun configure() {
        val mapper = XmlMapper(JacksonXmlModule().apply {
            setDefaultUseWrapper(false)
            setXMLTextElementName("text")
        }).registerKotlinModule()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

        val figureData = mapper.readValue<FigureData>(File(this::class.java.classLoader.getResource("www/dcr/v31/gamedata/figuredata.txt")!!.toURI()))
        bind<FigureData>().toInstance(figureData)
    }
}