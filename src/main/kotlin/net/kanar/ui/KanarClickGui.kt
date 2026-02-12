package net.kanar.ui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.awt.Color

class KanarClickGui : Screen(Text.of("Kanar Premium")) {
    
    // Переменные KillAura
    var killauraEnabled = false
    var range = 3.8f
    var aps = 12.0f
    var expanded = true

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        val x = 70
        val y = 70
        val width = 150
        
        // 1. ВНЕШНЯЯ ТЕНЬ И СВЕЧЕНИЕ (Glow effect)
        renderRoundedRect(context, x - 1, y - 1, width + 2, (if(expanded) 112 else 32), 6, Color(0, 150, 255, 100).rgb)

        // 2. ОСНОВНОЙ ФОН (Deep Dark)
        renderRoundedRect(context, x, y, width, (if(expanded) 110 else 30), 6, Color(15, 15, 15, 255).rgb)
        
        // 3. ШАПКА ПАНЕЛИ (С градиентной полоской сверху)
        context.fill(x + 5, y + 22, x + width - 5, y + 23, Color(40, 40, 40, 255).rgb) // Разделитель
        context.drawText(client!!.textRenderer, "COMBAT", x + 10, y + 8, Color(0, 210, 255).rgb, true)
        
        // Значок "шестеренки" или точка статуса
        val statusColor = if (killauraEnabled) Color(0, 255, 120).rgb else Color(255, 50, 50).rgb
        context.fill(x + width - 15, y + 10, x + width - 10, y + 15, statusColor)

        // 4. КОНТЕНТ (KillAura)
        if (expanded) {
            // Кнопка включения модуля
            val kaText = if (killauraEnabled) "ON" else "OFF"
            context.drawText(client!!.textRenderer, "KillAura", x + 15, y + 35, Color.WHITE.rgb, false)
            context.drawText(client!!.textRenderer, kaText, x + width - 35, y + 35, statusColor, false)
            
            // Слайдеры настроек
            drawModernSlider(context, x + 15, y + 55, width - 30, "Range", range, 6.0f)
            drawModernSlider(context, x + 15, y + 82, width - 30, "APS", aps, 20.0f)
        }
        
        super.render(context, mouseX, mouseY, delta)
    }

    private fun drawModernSlider(context: DrawContext, x: Int, y: Int, w: Int, label: String, value: Float, max: Float) {
        val valStr = String.format("%.1f", value)
        context.drawText(client!!.textRenderer, "$label", x, y, Color(180, 180, 180).rgb, false)
        context.drawText(client!!.textRenderer, valStr, x + w - 20, y, Color.WHITE.rgb, false)
        
        // Полоска слайдера (фон)
        renderRoundedRect(context, x, y + 12, w, 4, 2, Color(40, 40, 40, 255).rgb)
        
        // Полоска слайдера (активная часть - Неоновый синий)
        val progress = ((value / max) * w).toInt()
        if (progress > 0) {
            renderRoundedRect(context, x, y + 12, progress, 4, 2, Color(0, 180, 255, 255).rgb)
        }
    }

    // Метод для рисования "закругленного" прямоугольника через наслоение
    private fun renderRoundedRect(context: DrawContext, x: Int, y: Int, w: Int, h: Int, r: Int, color: Int) {
        context.fill(x + 1, y, x + w - 1, y + h, color) // Основное тело
        context.fill(x, y + 1, x + 1, y + h - 1, color) // Левый край
        context.fill(x + w - 1, y + 1, x + w, y + h - 1, color) // Правый край
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        val x = 70; val y = 70; val width = 150
        
        // Клик по KillAura (включение/выключение)
        if (mouseX >= x && mouseX <= x + width && mouseY >= y + 30 && mouseY <= y + 50) {
            if (button == 0) killauraEnabled = !killauraEnabled
            return true
        }
        
        // Клик по заголовку (свернуть/развернуть)
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 30) {
            if (button == 1) expanded = !expanded
            return true
        }
        return super.mouseClicked(mouseX, mouseY, button)
    }

    override fun shouldPause(): Boolean = false
}
