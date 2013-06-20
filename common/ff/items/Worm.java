package ff.items;

import ff.FF;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.item.ItemFood;


public class Worm extends ItemFood{
    
    public Worm(int id) {
        super(id, 2, .25f, false);//super(id, hungerPts, satModifier???, isWolfMeat);
        setMaxStackSize(16);
        setCreativeTab(FF.tabFF);
        setUnlocalizedName("worm");
        setPotionEffect(17, 30, 1, 1f);//setPotionEffect(int potionID, int potionDuration, int potionAmplifier, float potionEffectProbability);
        setAlwaysEdible();
    }

    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("ff:worm");
    }

}
