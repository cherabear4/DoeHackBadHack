package me.doehack.module;

import me.doehack.MainClass;
import me.doehack.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class Module {
	protected static Minecraft mc = Minecraft.getMinecraft();
	private String name;
	private String description;
	private int key;
	private Category category;
	private boolean toggled;
	public boolean visible = true;
	public List<Setting> settings;

	public Module(String name, String description, Category category) {
		this.settings = new ArrayList();
		this.name = name;
		this.description = description;
		this.key = 0;
		this.category = category;
		this.toggled = false;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
		if (MainClass.instance.saveLoad != null) {
			MainClass.instance.saveLoad.save();
		}

	}

	public boolean isToggled() {
		return this.toggled;
	}

	public void onUpdate() {
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
		if (this.toggled) {
			this.onEnable();
		} else {
			this.onDisable();
		}

		if (MainClass.instance.saveLoad != null) {
			MainClass.instance.saveLoad.save();
		}

	}

	public void toggle() {
		this.toggled = !this.toggled;
		if (this.toggled) {
			this.onEnable();
		} else {
			this.onDisable();
		}

		if (MainClass.instance.saveLoad != null) {
			MainClass.instance.saveLoad.save();
		}

	}

	public void onEnable() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onDisable() {
		MinecraftForge.EVENT_BUS.unregister(this);
	}

	public String getName() {
		return this.name;
	}

	public Category getCategory() {
		return this.category;
	}
}
