package me.doehack.module.misc;


import me.doehack.MainClass;
import me.doehack.module.Category;
import me.doehack.module.Module;

public class SelfDestruct extends Module {

public SelfDestruct() {
super("SelfDestruct", "Destructs", Category.MISC);
}

@Override
public void onEnable() {
MainClass.instance.onDestruct();
    }
}
