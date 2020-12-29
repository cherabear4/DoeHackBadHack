package me.doehack.module.render;

import me.doehack.module.Category;
import me.doehack.module.Module;
import org.lwjgl.input.Keyboard;

public class GUI extends Module {
    public GUI() {
        super("ClickGui", "ClickGui, my take at a custom gui XD", Category.RENDER);
        this.setKey(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
    super.onEnable();
    }

}