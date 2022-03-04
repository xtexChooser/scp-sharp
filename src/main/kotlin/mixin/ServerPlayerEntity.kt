@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.xtex.scpsharp.mixin

import com.mojang.authlib.GameProfile
import com.mojang.datafixers.util.Either
import com.xtex.scpsharp.content.scp714.SCP714Item
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Unit
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(ServerPlayerEntity::class)
abstract class ServerPlayerEntityMixin(world: World?, pos: BlockPos?, yaw: Float, profile: GameProfile?)
    : PlayerEntity(world, pos, yaw, profile){

    @Inject(
        method = ["trySleep(Lnet/minecraft/util/math/BlockPos;)Lcom/mojang/datafixers/util/Either;"],
        at = [At("HEAD")],
        cancellable = true
    )
    fun trySleepIsDay(pos: BlockPos, info: CallbackInfoReturnable<Either<SleepFailureReason, Unit>>) {
        if (itemsHand.any { it.item is SCP714Item }) {
            info.returnValue = super.trySleep(pos)
        }
    }

}