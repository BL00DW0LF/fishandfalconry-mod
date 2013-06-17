package ff.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FishSand extends ItemFood{
    
    public FishSand(int id) {
        super(id, 7, 1f, false);//super(id, hungerPts, satModifier???, isWolfMeat);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabFood);
        setUnlocalizedName("fishSand");
       
    }

    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ff:fishSand");
        
    }

}
