package me.doehack;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.doehack.autosave.SaveLoad;
import me.doehack.discord.RPC;
import me.doehack.module.Module;
import me.doehack.module.ModuleManager;
import me.doehack.module.render.FullBright;
import me.doehack.notification.Notification;
import me.doehack.settings.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.lwjgl.input.Keyboard;

public class MainClass  {
    public static MainClass instance;
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public SaveLoad saveLoad;
    public FullBright fullBright;
    public static Notification notification;


    public boolean destructed = false;

    public static String name = "DoeHack.GG ";

    public static String ver = "b2 ";

    public static String prefix = "<" + ChatFormatting.BLUE + "DoeHack.GG" + ChatFormatting.WHITE + "> ";

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);
        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        saveLoad = new SaveLoad();
        fullBright = new FullBright();
        saveLoad = new SaveLoad();
        notification = new Notification(null, null, null, 0);
        RPC.startRPC();
    }



    @SubscribeEvent
    public void key(KeyInputEvent e) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
            return;
        try {
            if (Keyboard.isCreated()) {
                if (Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if (keyCode <= 0)
                        return;
                    for (Module m : moduleManager.modules) {
                        if (m.getKey() == keyCode && keyCode > 0) {
                            m.toggle();
                        }
                    }
                }
            }
        } catch (Exception q) { q.printStackTrace(); }
    }

    public void onDestruct() {
        if (Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().player != null) {
            Minecraft.getMinecraft().player.closeScreen();
        }
        destructed = true;
        MinecraftForge.EVENT_BUS.unregister(this);
        for (int k = 0; k < this.moduleManager.modules.size(); k++) {
            Module m = this.moduleManager.modules.get(k);
            MinecraftForge.EVENT_BUS.unregister(m);
            this.moduleManager.getModuleList().remove(m);
        }
        this.moduleManager = null;
    }

}
