package ff;




import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import ff.blocks.ModBlocks;
import ff.entity.EntityBaitedHook;
import ff.items.ModItems;
import ff.lib.ItemIds;
import ff.lib.Reference;
import ff.render.RenderBaitedHook;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
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
        EntityRegistry.registerModEntity(EntityBaitedHook.class, "Baited Bobber", ItemIds.BAITEDHOOK, this, 75, 1, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityBaitedHook.class, new RenderBaitedHook());//Should be somewhere else
        
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
