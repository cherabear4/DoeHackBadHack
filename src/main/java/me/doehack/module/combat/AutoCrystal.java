package me.doehack.module.combat;

import me.doehack.MainClass;
import me.doehack.module.Category;
import me.doehack.module.Module;
import net.minecraft.util.text.TextComponentString;

public class AutoCrystal extends Module {
    public AutoCrystal() {
        super("AutoCrystal", "ez by aurora", Category.COMBAT);
    }

    @Override
    public void onEnable() {
        mc.player.sendChatMessage(String.valueOf(new TextComponentString(MainClass.prefix + "AutoCrystal Not Finished")));
    }
}
