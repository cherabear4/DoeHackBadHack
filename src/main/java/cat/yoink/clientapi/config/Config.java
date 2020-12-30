package cat.yoink.clientapi.config;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.friend.Friend;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.setting.Setting;
import cat.yoink.clientapi.util.FileUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Config extends Thread
{
    private final File clientFolder = new File(Minecraft.getMinecraft().mcDataDir + File.separator + ClientAPI.getFolderName());
    private static final String ENABLED_MODULES = "EnabledModules.txt";
    private static final String SETTINGS = "Settings.txt";
    private static final String PREFIX = "Prefix.txt";
    private static final String FRIENDS = "Friends.txt";

    @Override
    public void run()
    {
        if (!clientFolder.exists() && !clientFolder.mkdirs()) System.err.println("Failed to create folder");

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), ENABLED_MODULES), ClientAPI.getModuleManager().getEnabledModules().stream().map(Module::getName).collect(Collectors.toCollection(ArrayList::new))); }
        catch (IOException e) { e.printStackTrace(); }

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), SETTINGS), getSettings()); }
        catch (IOException e) { e.printStackTrace(); }

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), PREFIX), new ArrayList<>(Collections.singletonList(ClientAPI.getPrefix()))); }
        catch (IOException e) { e.printStackTrace(); }

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), FRIENDS), ClientAPI.getFriendManager().getFriends().stream().map(Friend::getName).collect(Collectors.toCollection(ArrayList::new))); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void loadConfig() throws IOException
    {
        if (!clientFolder.exists()) return;

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), ENABLED_MODULES)))
        {
            try { ClientAPI.getModuleManager().getModule(s).enable(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), SETTINGS)))
        {
            try
            {
                String[] split = s.split(":");
                saveSetting(ClientAPI.getSettingManager().getSetting(split[1], split[0]), split[2]);
            }
            catch (Exception e) { e.printStackTrace(); }
        }

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), PREFIX)))
        {
            try { ClientAPI.setPrefix(s); }
            catch (Exception e) { e.printStackTrace(); }
        }

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), FRIENDS)))
        {
            try { ClientAPI.getFriendManager().addFriend(s); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public ArrayList<String> getSettings()
    {
        ArrayList<String> content = new ArrayList<>();

        for (Setting setting : ClientAPI.getSettingManager().getSettings())
        {
            switch (setting.getType())
            {
                case BOOLEAN:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getBooleanValue()));
                    break;
                case INTEGER:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getIntegerValue()));
                    break;
                case FLOAT:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getFloatValue()));
                    break;
                case ENUM:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getEnumValue()));
                    break;
                case COLOR:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getColor().getRGB()));
                    break;
                default:
                    break;
            }
        }

        return content;
    }
    
    public void saveSetting(Setting setting, String value)
    {
        switch (setting.getType())
        {
            case BOOLEAN:
                setting.setBooleanValue(Boolean.parseBoolean(value));
                break;
            case INTEGER:
                setting.setIntegerValue(Integer.parseInt(value));
                break;
            case FLOAT:
                setting.setFloatValue(Float.parseFloat(value));
                break;
            case ENUM:
                setting.setEnumValue(value);
                break;
            case COLOR:
                setting.setColor(new Color(Integer.parseInt(value)));
                break;
            default:
                break;
        }
    }
}
