package me.doehack.module.render;

import me.doehack.module.Category;
import me.doehack.module.Module;
import me.doehack.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Watermark extends Module {

    public Watermark() {
        super("watermark", "doehack", Category.RENDER);
    }

    @SubscribeEvent
    public void onRender() {
        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

        GL11.glPushMatrix();
        GL11.glScalef(2f, 2f, 2f);
        fr.drawStringWithShadow("DoeHack.GG", 1, 1, ColorUtil.getRainbow().getRGB());
        GL11.glPopMatrix();
    }

}
