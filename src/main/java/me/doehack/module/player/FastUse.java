package me.doehack.module.player;

import akka.event.BusLogging;
import me.doehack.module.Category;
import me.doehack.module.Module;
import me.doehack.settings.BooleanSetting;
import net.minecraft.init.Items;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;

public class FastUse extends Module {

    public FastUse() {
        super("FastUse", "Set Delay to 0", Category.PLAYER);

    }
    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void onUpdate() {
        BooleanSetting bow = new BooleanSetting("bow", true);
        if (bow.isEnabled() && mc.player.isHandActive() && mc.player.getItemInUseMaxCount() >= 3 && (mc.player.getHeldItemMainhand().getItem() == Items.BOW || mc.player.getHeldItemOffhand().getItem() == Items.BOW)) {
            mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, mc.player.getHorizontalFacing()));
            mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(mc.player.getActiveHand()));
            mc.player.stopActiveHand();
        }
    }

}
