package ff.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static void init(){
        GameRegistry.registerTileEntity(StobBlockData.class, "stobBlock");
        
    }
}
