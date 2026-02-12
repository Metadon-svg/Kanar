package net.ccbluex.liquidbounce.features.module.modules.combat.killaura

import net.minecraft.entity.LivingEntity

class ModuleKillAura {
    var target: LivingEntity? = null
    val targetTracker = KillAuraTargetTracker()

    fun onUpdate() {
        target = targetTracker.getTarget()
        if (target != null) {
            // Логика атаки
        }
    }
}
