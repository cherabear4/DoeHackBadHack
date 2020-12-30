package me.doehack.module.render;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.ClientModule;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@ClientModule(name = "FullBright", category = Category.RENDER, description = "BRIGTH AHH", bind = Keyboard.KEY_NONE)
public class FullBright  extends Module {
    public FullBright() {
    }

    private float oldGamma = 1;

    @Override
    public void onEnable() {
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 420;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = oldGamma;
    }
}