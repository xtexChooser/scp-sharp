/*
 * Copyright (C) 2023  SCPSharp Team
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License. See LICENSE file for more.
 */
package scpsharp.subject

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import scpsharp.subject.scp005.SCP005
import scpsharp.subject.scp008.SCP008
import scpsharp.subject.scp008.SCP008Client
import scpsharp.subject.scp173.SCP173
import scpsharp.subject.scp173.SCP173Client
import scpsharp.subject.scp427.SCP427
import scpsharp.subject.scp500.SCP500
import scpsharp.subject.scp714.SCP714
import scpsharp.subject.scp914.SCP914
import scpsharp.subject.scp914.SCP914ControllerBlock
import scpsharp.util.id

object SCPSubjects {

    val ITEM_GROUP: ItemGroup = FabricItemGroup.builder(id("scp_subjects"))
        .icon { ItemStack(SCP914ControllerBlock.ITEM) }
        .build()

    init {
        SCP005
        SCP008
        SCP173
        SCP427
        SCP500
        SCP714
        SCP914
    }

}

object SCPSubjectsClient {

    init {
        SCP008Client
        SCP173Client
    }

}