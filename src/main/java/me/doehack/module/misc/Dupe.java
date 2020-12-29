package me.doehack.module.misc;

import me.doehack.module.Category;
import me.doehack.module.Module;

public class Dupe extends Module {
    public Dupe() {
        super("Dupe", "Auto Dupes Shulkers For You", Category.MISC);
    }
    @Override
    public void onEnable(){
        super.onEnable();
        mc.player.sendChatMessage("/kill");
        mc.player.sendChatMessage("I just duped all my shulkers with doehack's auto dupe!");
        setToggled(false);
    }
}
