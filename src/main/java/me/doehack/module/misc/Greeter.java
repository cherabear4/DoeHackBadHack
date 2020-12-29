package me.doehack.module.misc;

import me.doehack.module.Category;
import me.doehack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Greeter extends Module {
    public Greeter() {
        super("Greeter", "Greets u", Category.RENDER);
    }
    @SubscribeEvent
    public void onRender() {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
        GL11.glPushMatrix();
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        fr.drawString("DoeHack on Top, Welcome " + mc.player.getName(), 230, 6, 0x7c9fff);
        GL11.glPopMatrix();
}
}
