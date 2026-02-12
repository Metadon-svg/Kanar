package net.kanar

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.kanar.ui.KanarClickGui
import org.lwjgl.glfw.GLFW

class KanarMod : ClientModInitializer {
    override fun onInitializeClient() {
        // Слушаем нажатие Right Shift
        ClientTickEvents.END_CLIENT_TICK.register { client ->
            if (client.window != null && GLFW.glfwGetKey(client.window.handle, GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS) {
                if (client.currentScreen == null) {
                    client.setScreen(KanarClickGui())
                }
            }
        }
    }
}
