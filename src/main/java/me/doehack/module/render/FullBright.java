package me.doehack.module.render;

import me.doehack.module.Category;
import me.doehack.module.Module;
import org.lwjgl.input.Keyboard;

public class FullBright  extends Module {
    public FullBright() {
        super("FullBright", "makes ur game look bright", Category.RENDER);
        this.setKey(Keyboard.KEY_NONE);
    }
    float oldGamma = 1;

    public void onEnable() {
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 420;
    }

    public void onDisable() {
        mc.gameSettings.gammaSetting = oldGamma;
    }
}