/*
 * Copyright (C) 2022  SCPSharp Team
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License. See LICENSE file for more.
 */
package scpsharp.content.facility.generator

import net.minecraft.block.Block
import net.minecraft.tag.TagKey
import net.minecraft.util.registry.Registry
import scpsharp.util.id

object ComponentTags {

    val structureExposedInAir: TagKey<ComponentFactory<*>> = TagKey.of(ComponentFactory.registryKey, id("structure_exposed_in_air"))
    val facilityReplaceable: TagKey<Block> = TagKey.of(Registry.BLOCK_KEY, id("facility_replaceable"))

}
