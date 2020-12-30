package me.doehack.module.misc;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.ClientModule;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@ClientModule(name = "AutoDupe", category = Category.EXPLOIT, description = "DOOP", bind = Keyboard.KEY_NONE)
public class Dupe extends Module {
    @Override
    public void onEnable(){
        super.onEnable();
        mc.player.sendChatMessage("/kill");
        mc.player.sendChatMessage("I just duped all my shulkers with doehack's auto dupe!");
    }
}
