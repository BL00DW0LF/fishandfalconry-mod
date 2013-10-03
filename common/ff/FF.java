package ff;




import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import ff.blocks.ModBlocks;
import ff.entity.EntityBaitedHook;
import ff.items.ModItems;
import ff.lib.ItemIds;
import ff.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;





@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class FF {
    // The instance of your mod that Forge uses.
    @Instance(value = "GenericModID")
    public static FF instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="ff.client.ClientProxy", serverSide="ff.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        //register blocks and items, load from config
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        
        ModBlocks.init();
        
        ModItems.init();
        EntityRegistry.registerModEntity(EntityBaitedHook.class, "Baited Bobber", ItemIds.BAITEDHOOK, this, 75, 1, true);//figure out how to change this to something else and put this in method
        
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFF", "en_US", "Fish & Falconry");
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        //interact with other mods (now that they've been loaded)
    }
    
    public static CreativeTabs tabFF = new CreativeTabs("tabFF") {
        public ItemStack getIconItemStack() {
                return new ItemStack(ItemIds.FISHSAND+256,1,0);
        }
};
}
