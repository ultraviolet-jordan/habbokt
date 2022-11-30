package com.habbokt.xml.figuredata

import com.google.inject.Singleton
import com.habbokt.xml.XMLDocument
import com.habbokt.xml.figuredata.domain.FigureData

/**
 * @author Jordan Abraham
 */
@Singleton
class FigureDataDocument(figureData: FigureData) : XMLDocument<FigureData>(figureData)