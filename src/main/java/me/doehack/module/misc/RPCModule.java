package me.doehack.module.misc;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.ClientModule;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@ClientModule(name = "DiscordRPC", category = Category.MISC, bind = Keyboard.KEY_O)
public class RPCModule extends Module
{

    @Override
    public void onEnable()
    {
        DiscordRP.startRPC();
    }

    @Override
    public void onDisable()
    {
        DiscordRP.stopRPC();
    }
}
