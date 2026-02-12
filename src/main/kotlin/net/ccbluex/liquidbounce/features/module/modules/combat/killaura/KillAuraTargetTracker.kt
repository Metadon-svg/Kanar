package net.ccbluex.liquidbounce.features.module.modules.combat.killaura

import net.minecraft.entity.LivingEntity
import net.minecraft.client.MinecraftClient

class KillAuraTargetTracker {
    var target: LivingEntity? = null
    
    fun getTarget(): LivingEntity? {
        return target
    }
}
