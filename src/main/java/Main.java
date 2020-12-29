import me.doehack.MainClass;
import me.doehack.discord.RPC;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "doehack", version = "b2")
public class Main {

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	MainClass.instance = new MainClass();
        RPC.startRPC();
    	MainClass.instance.init();
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }
}
