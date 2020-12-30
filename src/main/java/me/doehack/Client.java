package me.doehack;

import cat.yoink.clientapi.APIBuilder;
import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.InitializationException;
import me.doehack.clickgui.ClickGUI;
import me.doehack.clickgui.HUDEditor;
import me.doehack.module.misc.DiscordRP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME, version = Client.VERSION)
public class Client {

    public static final String MOD_ID = "dh";
    public static final String MOD_NAME = "DoeHack";
    public static final String VERSION = "0.3";

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) throws InitializationException {
        DiscordRP.startRPC();
        ClientAPI api = new APIBuilder()
                .withName(MOD_NAME)
                .withModID(MOD_ID)
                .withVersion(VERSION)
                .withMasterPackage(Package.getPackage("me.doehack")) /* Or use Client.class.getPackage() */
                .withPrefix("-")
                .withLoggerPrefix("&7[&6DoeHack&7]")
                .withFolderName("DoeHack")
                .withClickGUI(new ClickGUI().withWidth(82).withHeight(16))
                .withHUDEditor(new HUDEditor())
                .build();

        api.initialize();
        api.loadConfig();
    }
}
