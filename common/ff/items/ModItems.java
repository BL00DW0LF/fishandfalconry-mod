package ff.items;


import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ff.blocks.StobBlock;
import ff.blocks.StobBlockData;
import ff.lib.ItemIds;

public class ModItems {
    
    public static FishSand fishSand;
    public static Worm worm;
    public static Stob stob;
    public static StobBlock stobBlock;
    public static BaitedPole baitedPole;
    
    public static void init() {
        //Fish Sandwich
        fishSand = new FishSand(ItemIds.FISHSAND);
        LanguageRegistry.addName(fishSand, "Fish Sandwich");
        ItemStack breadStack=new ItemStack(ItemFood.bread);
        GameRegistry.addShapelessRecipe(new ItemStack(fishSand), breadStack,breadStack, new ItemStack(ItemFood.fishCooked));
        
        //worms
        worm = new Worm(ItemIds.WORM);
        LanguageRegistry.addName(worm, "Worm");
        
        //stob
        stobBlock= new StobBlock(ItemIds.STOBBLOCK);
        stob = new Stob(ItemIds.STOB, stobBlock);
        GameRegistry.registerTileEntity(StobBlockData.class, "stobBlock");
        LanguageRegistry.addName(stob, "Stob");
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stob), true, new Object[]{"ili", " p ", " s ",'l', "logWood", 'i', new ItemStack(Item.ingotIron),'p', "plankWood", 's', "stickWood"}));
        
        //baited pole
        baitedPole=new BaitedPole(ItemIds.BAITEDPOLE);
        LanguageRegistry.addName(baitedPole, "Baited Fishing Pole");
    }
}
