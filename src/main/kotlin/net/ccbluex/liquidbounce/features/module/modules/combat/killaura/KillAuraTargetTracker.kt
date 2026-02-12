package net.ccbluex.liquidbounce.features.module.modules.combat.killaura

import net.minecraft.world.entity.LivingEntity

object KillAuraTargetTracker {
    var target: LivingEntity? = null
    private val ignoreShield = true

    fun update() {
        // Твоя логика поиска цели по дистанции
    }
}
