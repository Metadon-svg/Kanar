package net.kanar.ui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.awt.Color
// Импортируем твои модули
import net.ccbluex.liquidbounce.features.module.modules.combat.killaura.ModuleKillAura
import net.ccbluex.liquidbounce.features.module.modules.combat.killaura.features.KillAuraRange
import net.ccbluex.liquidbounce.features.module.modules.combat.killaura.features.KillAuraAutoBlock

class KanarClickGui : Screen(Text.of("Kanar Menu")) {

    private val bgColor = Color(15, 15, 15, 230).rgb
    private val accentColor = Color(138, 43, 226).rgb // Фиолетовый Kanar Style

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        val centerX = width / 2
        val centerY = height / 2
        val startX = centerX - 150
        val startY = centerY - 100

        // 1. Фон (Glass Morphism imitation)
        context.fill(startX, startY, startX + 300, startY + 200, bgColor)
        context.fill(startX, startY, startX + 300, startY + 2, accentColor) // Top Line

        // 2. Заголовок
        context.drawText(textRenderer, "KANAR CLIENT", startX + 15, startY + 15, accentColor, true)
        
        // 3. Управление Killaura (Связь с ModuleKillAura)
        var yOffset = startY + 50
        
        // Кнопка включения
        val stateText = if (ModuleKillAura.enabled) "Killaura: [ON]" else "Killaura: [OFF]"
        val stateColor = if (ModuleKillAura.enabled) Color.GREEN.rgb else Color.RED.rgb
        context.drawText(textRenderer, stateText, startX + 20, yOffset, stateColor, true)
        
        // Ползунок Range (Визуализация из KillAuraRange)
        yOffset += 25
        val rangeVal = KillAuraRange.interactionRange
        context.drawText(textRenderer, "Range: ${String.format(\"%.1f\", rangeVal)}", startX + 20, yOffset, Color.WHITE.rgb, false)
        context.fill(startX + 20, yOffset + 12, startX + 120, yOffset + 14, Color.GRAY.rgb)
        context.fill(startX + 20, yOffset + 12, startX + 20 + (rangeVal * 10).toInt(), yOffset + 14, accentColor)

        // Индикатор AutoBlock
        yOffset += 25
        val blockText = "AutoBlock: " + if(KillAuraAutoBlock.enabled) "Active" else "Inactive"
        context.drawText(textRenderer, blockText, startX + 20, yOffset, Color.LIGHT_GRAY.rgb, false)

        super.render(context, mouseX, mouseY, delta)
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        val centerX = width / 2
        val centerY = height / 2
        val startX = centerX - 150
        val startY = centerY - 100
        
        // Логика клика по кнопке Killaura (координаты примерные)
        if (mouseY > startY + 45 && mouseY < startY + 65) {
             ModuleKillAura.toggle() // Метод переключения
             return true
        }
        return super.mouseClicked(mouseX, mouseY, button)
    }
    
    override fun shouldPause(): Boolean = false
}
