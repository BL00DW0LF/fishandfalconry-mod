package ff.items;


import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ff.lib.ItemIds;

public class ModItems {
    
    public static FishSand fishSand;
    
    public static void init() {
        //Fish Sandwich
        fishSand = new FishSand(ItemIds.FISHSAND, 7, 1.2f, false);
        LanguageRegistry.addName(fishSand, "Fish Sandwich");
        ItemStack breadStack=new ItemStack(ItemFood.bread);
        GameRegistry.addShapelessRecipe(new ItemStack(fishSand), breadStack,breadStack, new ItemStack(ItemFood.fishCooked));
    }
}
