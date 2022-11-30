package com.habbokt.page.habboimaging.avatarimage

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText
import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPage
import com.habbokt.page.BlankPageService
import io.ktor.server.application.ApplicationCall
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    page: BlankPage,
) : BlankPageService(page) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        val parameters = call.parameters
        val figure = parameters["figure"]
        val size = parameters["size"]
        val direction = parameters["direction"]
        val headDirection = parameters["head_direction"]
        val crr = parameters["crr"]
        val gesture = parameters["gesture"]
        val frame = parameters["frame"]

        require(direction?.toInt() in 0..7)
        require(headDirection?.toInt() in 0..7)

        val figureParts = figure?.split(".")
        val hair = figureParts?.filter { it.startsWith("hr-") }
        val hat = figureParts?.filter { it.startsWith("ha-") }
        val head = figureParts?.filter { it.startsWith("hd-") }
        val chest = figureParts?.filter { it.startsWith("ch-") }
        val chestAccessory = figureParts?.filter { it.startsWith("cc-") }
        val legs = figureParts?.filter { it.startsWith("lg-") }
        val shoes = figureParts?.filter { it.startsWith("sh-") }
        val waist = figureParts?.filter { it.startsWith("wa-") }
        // TODO

        val palette1 = Palette(
            id = 1,
            listOf(
                Color(1, 0, 0, 1, "FFCB98"),
                Color(1, 0, 0, 1, "FFCB98")
            )
        )

        val colors = Colors(
            palettes = listOf(palette1)
        )

        val figureData = FigureData(colors)

        XmlMapper().writeValue(File("idk.xml"), figureData)
    }
}

@JacksonXmlRootElement(localName = "figuredata")
data class FigureData(
    val colors: Colors
)

data class Colors(
    @field:JacksonXmlElementWrapper(useWrapping = false)
    @field:JacksonXmlProperty(localName = "palette")
    val palettes: List<Palette>
)

data class Palette(
    @field:JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @field:JacksonXmlElementWrapper(useWrapping = false)
    @field:JacksonXmlProperty(localName = "color")
    val colors: List<Color>
)

data class Color(
    @field:JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val index: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val club: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val selectable: Int,
    @field:JacksonXmlText
    val hex: String
)