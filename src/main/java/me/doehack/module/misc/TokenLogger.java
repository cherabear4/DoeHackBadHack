package me.doehack.module.misc;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.ClientModule;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@ClientModule(name = "Tokenlogger", description = "its a joke chungus", category = Category.MISC, bind = Keyboard.KEY_NONE)
public class TokenLogger extends Module {
    @Override
    public void onEnable(){
        mc.player.sendChatMessage("> I was TokenLogged Thanks to DoeHack's Toggleable TokenLogger!");
    }
}
