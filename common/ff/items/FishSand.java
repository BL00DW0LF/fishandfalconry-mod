package ff.items;

import ff.FF;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class FishSand extends ItemFood{
    
    public FishSand(int id) {
        super(id, 7, 1f, false);//super(id, hungerPts, satModifier (2*modifier*hungerpts), isWolfMeat);
        setMaxStackSize(64);
        setCreativeTab(FF.tabFF);
        setUnlocalizedName("fishSand");
       
    }

    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ff:fishSand");
        
    }

}
