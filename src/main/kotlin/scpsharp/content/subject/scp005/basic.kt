/*
 * Copyright (C) 2022  SCPSharp Team
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License. See LICENSE file for more.
 */
package scpsharp.content.subject.scp005

import scpsharp.util.id
import scpsharp.util.logger
import net.minecraft.block.Block
import net.minecraft.tag.TagKey
import net.minecraft.util.registry.Registry

object SCP005 {

    val logger = logger("SCP-005")

    val bypassTag: TagKey<Block> = TagKey.of(Registry.BLOCK_KEY, id("scp005_bypass"))

    val doorFilterTag: TagKey<Block> = TagKey.of(Registry.BLOCK_KEY, id("scp005_doors"))

    init {
        SCP005Item
    }

}
