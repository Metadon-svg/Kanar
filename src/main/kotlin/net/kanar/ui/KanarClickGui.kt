package net.kanar.ui
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.awt.Color
import net.ccbluex.liquidbounce.features.module.modules.combat.killaura.ModuleKillAura

class KanarClickGui : Screen(Text.of("Kanar")) {
    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        val x = width / 2 - 120
        val y = height / 2 - 80
        
        // Фон с закруглением (имитация)
        context.fill(x, y, x + 240, y + 160, Color(10, 10, 10, 230).rgb)
        context.fill(x, y, x + 240, y + 2, Color(138, 43, 226).rgb)
        
        context.drawText(textRenderer, "KANAR CLIENT", x + 10, y + 10, Color(138, 43, 226).rgb, true)
        
        // Кнопка KillAura
        val kaEnabled = ModuleKillAura.state // Условно берем состояние
        val btnColor = if (kaEnabled) Color.GREEN.rgb else Color.GRAY.rgb
        context.fill(x + 10, y + 40, x + 100, y + 55, Color(30, 30, 30).rgb)
        context.drawText(textRenderer, "KillAura", x + 15, y + 44, btnColor, false)

        super.render(context, mouseX, mouseY, delta)
    }
    override fun shouldPause() = false
}
