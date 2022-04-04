/*
 * Copyright (C) 2022  SCPSharp Team
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License. See LICENSE file for more.
 */
package scpsharp.content.subject.scp008

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.BlockItem
import net.minecraft.particle.ParticleTypes
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import scpsharp.content.subject.SCPSubjects
import scpsharp.util.id
import java.util.*

object SCP008ContainmentBlock : BlockWithEntity(FabricBlockSettings.of(Material.METAL)) {

    val identifier = id("scp008_containment")
    val item = BlockItem(
        this, FabricItemSettings()
            .group(SCPSubjects.itemGroup)
    )
    val entityType: BlockEntityType<SCP008ContainmentBlockEntity> =
        FabricBlockEntityTypeBuilder.create(::SCP008ContainmentBlockEntity, this).build()

    init {
        Registry.register(Registry.BLOCK, identifier, this)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, identifier, entityType)
        Registry.register(Registry.ITEM, identifier, item)
        defaultState = defaultState.with(Properties.OPEN, false)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(Properties.OPEN)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState) = SCP008ContainmentBlockEntity(pos, state)

    override fun getRenderType(state: BlockState) = BlockRenderType.MODEL

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        world.setBlockState(pos, state.with(Properties.OPEN, !state[Properties.OPEN]))
        return ActionResult.SUCCESS
    }

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        super.randomDisplayTick(state, world, pos, random)
        if (state[Properties.OPEN]) {
            for (i in 0..random.nextInt(10)) {
                world.addParticle(
                    ParticleTypes.CLOUD,
                    pos.x - 0.5 + random.nextFloat(2.0f),
                    pos.y + 0.7 + random.nextFloat(),
                    pos.z - 0.5 + random.nextFloat(2.0f),
                    0.0, 0.0, 0.0
                )
            }
        }
    }

}

class SCP008ContainmentBlockEntity(pos: BlockPos, state: BlockState) :
    BlockEntity(SCP008ContainmentBlock.entityType, pos, state)
