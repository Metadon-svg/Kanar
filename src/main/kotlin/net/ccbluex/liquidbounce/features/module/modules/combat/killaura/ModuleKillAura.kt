package net.ccbluex.liquidbounce.features.module.modules.combat.killaura

import net.minecraft.entity.LivingEntity

class ModuleKillAura {
    var target: LivingEntity? = null
    val targetTracker = KillAuraTargetTracker()
    val clicker = KillAuraClicker()

    fun onUpdate() {
        // Берем цель из трекера
        target = targetTracker.target
        
        // Передаем состояние в кликер
        clicker.enabled = target != null
        
        if (target != null) {
            // Здесь будет логика ротаций или удара
        }
    }
}
