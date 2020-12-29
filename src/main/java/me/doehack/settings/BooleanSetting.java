package me.doehack.settings;

import me.doehack.MainClass;

public class BooleanSetting extends BasicSetting {
        public boolean enabled;

        public BooleanSetting(String name, boolean enabled) {
            this.name = name;
            this.enabled = enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;

            if(MainClass.instance.saveLoad != null) {
                MainClass.instance.saveLoad.save();
            }
        }

        public void toggle() {
            this.enabled = !this.enabled;

            if(MainClass.instance.saveLoad != null) {
                MainClass.instance.saveLoad.save();
            }
        }
    }
