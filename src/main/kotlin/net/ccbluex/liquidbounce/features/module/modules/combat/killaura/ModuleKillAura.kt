package net.ccbluex.liquidbounce.features.module.modules.combat.killaura

import net.minecraft.entity.LivingEntity

class ModuleKillAura {
    var target: LivingEntity? = null
    val clicker = KillAuraClicker()
    val targetTracker = KillAuraTargetTracker()

    fun onUpdate() {
        target = targetTracker.target
        clicker.enabled = target != null
        
        if (target != null) {
            // Логика атаки
        }
    }
}
