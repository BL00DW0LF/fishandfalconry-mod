package ff.items;

import ff.FF;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemReed;

public class Stob extends ItemReed {



    public Stob(int id, Block blockToSpawn) {
        super(id, blockToSpawn);
        setMaxStackSize(1);
        setUnlocalizedName("stob");
        //setMaxDamage(15);
        setCreativeTab(FF.tabFF);
    }

    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ff:stob");
    }
       
}
