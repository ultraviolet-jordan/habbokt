package com.habbokt.xml.partsets

import com.google.inject.Singleton
import com.habbokt.xml.XMLDocument
import com.habbokt.xml.partsets.domain.PartSets

/**
 * @author Jordan Abraham
 */
@Singleton
class PartSetsDocument(partSets: PartSets) : XMLDocument<PartSets>(partSets)