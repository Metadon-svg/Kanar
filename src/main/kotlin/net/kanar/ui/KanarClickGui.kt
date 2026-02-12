package net.kanar.ui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.awt.Color

class KanarClickGui : Screen(Text.of("Minimalist UI")) {
    
    // Переменные для управления
    var killauraEnabled = false
    var range = 3.8f
    var aps = 12.0f

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        val x = 50
        val y = 50
        val width = 130
        
        // 1. ОСНОВНОЕ ТЕЛО (Матовый черный)
        // Рисуем подложку
        context.fill(x, y, x + width, y + 105, Color(15, 15, 15, 240).rgb)
        
        // 2. ЗАГОЛОВОК (Минимализм: просто текст без полосок)
        context.drawText(client!!.textRenderer, "Combat", x + 10, y + 10, Color(200, 200, 200).rgb, false)

        // 3. МОДУЛЬ KILL AURA
        val textColor = if (killauraEnabled) Color.WHITE.rgb else Color(100, 100, 100).rgb
        context.drawText(client!!.textRenderer, "KillAura", x + 15, y + 30, textColor, false)
        
        // Маленький минималистичный индикатор (точка)
        if (killauraEnabled) {
            context.fill(x + 10, y + 32, x + 12, y + 34, Color.WHITE.rgb)
        }

        // 4. НАСТРОЙКИ (Тонкие линии)
        drawMinimalSlider(context, x + 15, y + 50, width - 30, "Range", range, 6.0f)
        drawMinimalSlider(context, x + 15, y + 75, width - 30, "APS", aps, 20.0f)
        
        super.render(context, mouseX, mouseY, delta)
    }

    private fun drawMinimalSlider(context: DrawContext, x: Int, y: Int, w: Int, label: String, value: Float, max: Float) {
        // Текст настройки
        context.drawText(client!!.textRenderer, label, x, y, Color(120, 120, 120).rgb, false)
        context.drawText(client!!.textRenderer, String.format("%.1f", value), x + w - 15, y, Color(180, 180, 180).rgb, false)
        
        // Линия слайдера (очень тонкая)
        context.fill(x, y + 12, x + w, y + 13, Color(40, 40, 40).rgb)
        val progress = ((value / max) * w).toInt()
        context.fill(x, y + 12, x + progress, y + 13, Color.WHITE.rgb)
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        val x = 50; val y = 50; val width = 130
        
        // Клик по KillAura
        if (mouseX >= x && mouseX <= x + width && mouseY >= y + 25 && mouseY <= y + 40) {
            killauraEnabled = !killauraEnabled
            // Тут должна быть твоя логика: Модуль.setEnabled(killauraEnabled)
            return true
        }
        return super.mouseClicked(mouseX, mouseY, button)
    }

    override fun shouldPause(): Boolean = false
}
