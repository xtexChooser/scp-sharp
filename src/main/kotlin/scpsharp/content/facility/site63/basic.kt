/*
 * Copyright (C) 2022  SCPSharp Team
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License. See LICENSE file for more.
 */
package scpsharp.content.facility.site63

import net.minecraft.util.registry.Registry
import scpsharp.content.facility.generator.ComponentFactory
import scpsharp.content.facility.generator.StructureComponentFactory
import scpsharp.util.id

object Site63 {

    val gateId = id("site63_gate")
    val gateFactory: StructureComponentFactory = StructureComponentFactory(id("site63_gate"))

    init {
        Site63Feature
        Registry.register(ComponentFactory.registry, gateId, gateFactory)
    }

}