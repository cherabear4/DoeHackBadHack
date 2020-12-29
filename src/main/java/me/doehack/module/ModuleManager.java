package me.doehack.module;

import me.doehack.module.misc.Dupe;
import me.doehack.module.misc.FakePlayer;
import me.doehack.module.misc.Greeter;
import me.doehack.module.misc.SelfDestruct;
import me.doehack.module.movement.Sprint;
import me.doehack.module.player.FastUse;
import me.doehack.module.render.FullBright;
import me.doehack.module.render.HUD;
import me.doehack.module.render.Watermark;

import java.util.ArrayList;
import java.util.Iterator;

public class ModuleManager {

	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();

		//RENDER
		this.modules.add(new HUD());
		this.modules.add(new FullBright());
		this.modules.add(new Greeter());
		this.modules.add(new Watermark());


		//COMBAT

		//MOVEMENT
		this.modules.add(new Sprint());

		//PLAYER
		this.modules.add(new FastUse());

		//MISC
		this.modules.add(new Dupe());
		this.modules.add(new FakePlayer());
		this.modules.add(new SelfDestruct());



	}

	public Module getModule(String name) {
		Iterator var2 = this.modules.iterator();

		Module m;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			m = (Module)var2.next();
		} while(!m.getName().equalsIgnoreCase(name));

		return m;
	}

	public ArrayList<Module> getModuleList() {
		return this.modules;
	}

	public ArrayList<Module> getModulesInCategory(Category c) {
		ArrayList<Module> mods = new ArrayList();
		Iterator var3 = this.modules.iterator();

		while(var3.hasNext()) {
			Module m = (Module)var3.next();
			if (m.getCategory() == c) {
				mods.add(m);
			}
		}

		return mods;
	}
}
