package net.kanar.ui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.awt.Color

class KanarClickGui : Screen(Text.of("Kanar")) {
    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        // Рендерим фон
        context.fill(0, 0, width, height, Color(0, 0, 0, 150).rgb)
        
        // Рисуем заголовок (без использования несуществующего 'state')
        context.drawCenteredTextWithShadow(textRenderer, "KANAR CLIENT GUI", width / 2, 20, 0x8A2BE2)
        
        super.render(context, mouseX, mouseY, delta)
    }
    
    override fun shouldPause(): Boolean = false
}
