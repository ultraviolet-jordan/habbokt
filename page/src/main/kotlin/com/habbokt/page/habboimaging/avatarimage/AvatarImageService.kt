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

        // ========================================================================

        val color1 = Color(
            id = 1,
            index = 0,
            club = 0,
            selectable = 1,
            hex = "FFCB98"
        )

        val color2 = Color(
            id = 2,
            index = 0,
            club = 0,
            selectable = 1,
            hex = "E3AE7D"
        )

        val palette1 = Palette(
            id = 1,
            listOf(color1, color2)
        )

        val colors = Colors(
            palettes = listOf(palette1)
        )

        // ========================================================================

        val part996 = Part(
            id = 996,
            type = "hr",
            colorable = 0,
            index = 0
        )

        val part458 = Part(
            id = 458,
            type = "hr",
            colorable = 0,
            index = 0
        )

        val set175 = Set(
            id = 175,
            gender = "M",
            club = 0,
            colorable = 0,
            selectable = 0,
            part = part996
        )

        val set177 = Set(
            id = 177,
            gender = "M",
            club = 0,
            colorable = 0,
            selectable = 0,
            part = part458
        )

        val setType = SetType(
            type = "hr",
            paletteId = 2,
            mandatory = 0,
            sets = listOf(set175, set177)
        )

        val sets = Sets(listOf(setType))

        val figureData = FigureData(colors, sets)

        XmlMapper().writeValue(File("figuredata.xml"), figureData)
    }
}

@JacksonXmlRootElement(localName = "figuredata")
data class FigureData(
    val colors: Colors,
    val sets: Sets
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

data class Sets(
    @field:JacksonXmlElementWrapper(useWrapping = false)
    @field:JacksonXmlProperty(localName = "settype")
    val setTypes: List<SetType>
)

data class SetType(
    @field:JacksonXmlProperty(isAttribute = true)
    val type: String,
    @field:JacksonXmlProperty(localName = "paletteid", isAttribute = true)
    val paletteId: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val mandatory: Int,
    @field:JacksonXmlElementWrapper(useWrapping = false)
    @field:JacksonXmlProperty(localName = "set")
    val sets: List<Set>
)

data class Set(
    @field:JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val gender: String,
    @field:JacksonXmlProperty(isAttribute = true)
    val club: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val colorable: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val selectable: Int,
    val part: Part
)

data class Part(
    @field:JacksonXmlProperty(isAttribute = true)
    val id: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val type: String,
    @field:JacksonXmlProperty(isAttribute = true)
    val colorable: Int,
    @field:JacksonXmlProperty(isAttribute = true)
    val index: Int
)