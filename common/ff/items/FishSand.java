package ff.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FishSand extends ItemFood{
    
    public FishSand(int id, int hungerPts, float satDiv10, boolean isWolfMeat) {
        super(id, hungerPts, satDiv10, isWolfMeat);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabFood);
        setUnlocalizedName("fishSand");
       
       //public static Item fishCooked = (new ItemFood(94, 5, 0.6F, false)).setUnlocalizedName("fishCooked");
    }

    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ff:fishSand");
        
    }

}
