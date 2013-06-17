package ff;




import ff.blocks.ModBlocks;
import ff.items.ModItems;
import ff.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;





@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class FF {
    
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        //register blocks and items, load from config
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        //interact with other mods (now that they've been loaded)
    }
}
