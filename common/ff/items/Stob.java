package ff.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemReed;

public class Stob extends ItemReed {

    public Stob(int id, Block blockToSpawn) {
        super(id, blockToSpawn);
        setMaxStackSize(16);
        setUnlocalizedName("stob");
        // TODO Auto-generated constructor stub
    }
    
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ff:stob");
    }
}
