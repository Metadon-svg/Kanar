package net.ccbluex.liquidbounce.features.module.modules.combat.killaura

import net.minecraft.entity.LivingEntity

class KillAuraTargetTracker {
    // Оставляем только переменную, Kotlin сам сделает getTarget()
    var target: LivingEntity? = null
}
