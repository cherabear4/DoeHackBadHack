package me.doehack.clickgui;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.clickgui.ClickHandler;
import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.setting.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class ClickGUI extends ClickHandler
{
    private Category drag;
    private int dragX;
    private int dragY;

    @Override
    public void drawCategory(int x, int y, int w, int h, int mouseX, int mouseY, Category category)
    {
        if (category.equals(drag))
        {
            category.setX(dragX + mouseX);
            category.setY(dragY + mouseY);
        }

        Gui.drawRect(x, y, x+w, y+h, new Color(0x3543A0).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(category.getName(), x + 3, y + 3, Color.WHITE.getRGB());
    }

    @Override
    public void drawModule(int x, int y, int w, int h, int mouseX, int mouseY, Module module)
    {
        Color c;

        if (module.isEnabled()) c = new Color(0xFD4800FF, true);
        else c = new Color(0x741D1D1D, true);

        Gui.drawRect(x, y, x+w, y+h, c.getRGB());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(module.getName(), x + 3, y + 3, Color.WHITE.getRGB());
    }

    @Override
    public void drawSetting(int x, int y, int w, int h, int mouseX, int mouseY, Setting setting)
    {
        Gui.drawRect(x, y, x+w, y+h, new Color(0xFD4800FF, true).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(setting.getName(), x + 3, y + 3, Color.WHITE.getRGB());
    }

    @Override
    public void clickCategory(int mouseX, int mouseY, int mouseButton, Category category)
    {
        if (mouseButton == 0)
        {
            drag = category;
            dragX = category.getX() - mouseX;
            dragY = category.getY() - mouseY;
        }
        else if (mouseButton == 1) category.setOpen(!category.isOpen());
    }

    @Override
    public void clickModule(int mouseX, int mouseY, int mouseButton, Module module)
    {
        if (mouseButton == 0) module.toggle();
        else if (mouseButton == 1) module.setOpen(!module.isOpen());
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state)
    {
        drag = null;
    }

    @Override
    public void onClose()
    {
        ClientAPI.getModuleManager().getModule("ClickGUI").disable();
    }
}
