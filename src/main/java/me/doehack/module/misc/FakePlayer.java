package me.doehack.module.misc;

import com.mojang.authlib.GameProfile;
import me.doehack.module.Category;
import me.doehack.module.Module;
import me.doehack.notification.Notification;
import me.doehack.notification.NotificationManager;
import me.doehack.notification.NotificationType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.world.GameType;

import java.util.UUID;

public class FakePlayer extends Module {
    public FakePlayer() {
        super("FakePlayer", "fakeplayer", Category.MISC);
    }
    private EntityOtherPlayerMP clonedPlayer;

    public void onEnable() {


        if (mc.player == null || mc.player.isDead){
            onDisable();
            return;
        }



        clonedPlayer = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString("fdee323e-7f0c-4c15-8d1c-0f277442342a"), "SubToPiggydoe"));
        clonedPlayer.copyLocationAndAnglesFrom(mc.player);
        clonedPlayer.rotationYawHead = mc.player.rotationYawHead;
        clonedPlayer.rotationYaw = mc.player.rotationYaw;
        clonedPlayer.rotationPitch = mc.player.rotationPitch;
        clonedPlayer.setGameType(GameType.SURVIVAL);
        clonedPlayer.setHealth(20);
        mc.world.addEntityToWorld(-1234, clonedPlayer);
        clonedPlayer.onLivingUpdate();
    }

    public void onDisable() {
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.world != null) {
            mc.world.removeEntityFromWorld(-1234);
        }
    }
}
