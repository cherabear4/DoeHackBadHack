package me.doehack.module.render;

import me.doehack.MainClass;
import me.doehack.module.Category;
import me.doehack.module.Module;
import me.doehack.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class HUD extends Module {

	public HUD() {
		super("HUD", "Draws the module list on your screen", Category.RENDER);
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent egoe) {
		if (!egoe.getType().equals(egoe.getType().CROSSHAIRS)) {
			return;
		}
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int y = 2;
		for (Module mod : MainClass.instance.moduleManager.getModuleList()) {
			if (!mod.getName().equalsIgnoreCase("HUD") && mod.isToggled() && mod.visible) {
				FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
				fr.drawString(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 0, y, ColorUtil.getRainbow().getRGB());
				y += fr.FONT_HEIGHT;
			}
		}
	}
}

