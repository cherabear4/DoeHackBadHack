package me.doehack.module.movement;

import me.doehack.module.Category;
import me.doehack.module.Module;

public class Sprint extends Module {


	public Sprint() {
		super("Sprint", "sprint automatically", Category.MOVEMENT);
	}

	/*@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent e) {
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
		if ( mc.player.isInWater() ){
			NotificationManager.show(new Notification(NotificationType.INFO, "Water", "Blue like water", 1));
		}
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
	}*/
}
