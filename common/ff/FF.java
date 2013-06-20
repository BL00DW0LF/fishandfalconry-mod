package ff;




import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ff.blocks.ModBlocks;
import ff.items.ModItems;
import ff.lib.ItemIds;
import ff.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;





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
