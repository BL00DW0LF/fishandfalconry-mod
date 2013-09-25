package ff.items;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ff.FF;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BaitedPole extends Item
{
    @SideOnly(Side.CLIENT)
    private Icon theIcon;

    public BaitedPole(int id)
    {
        super(id);
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(FF.tabFF);
    }

   // @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    //public boolean isFull3D()
    //{
    //    return true;
    //}

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack poleItemStack, World currentWorld, EntityPlayer playerHoldingPole)
    {
        if (playerHoldingPole.fishEntity != null)
        {
            
            int i = playerHoldingPole.fishEntity.catchFish();
            poleItemStack.damageItem(i, playerHoldingPole);
            playerHoldingPole.swingItem();
        }
        else
        {
            
            currentWorld.playSoundAtEntity(playerHoldingPole, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!currentWorld.isRemote)
            {
                currentWorld.spawnEntityInWorld(new EntityFishHook(currentWorld, playerHoldingPole));
            }

            playerHoldingPole.swingItem();
        }

        return poleItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        super.registerIcons(par1IconRegister);
        this.theIcon = par1IconRegister.registerIcon("fishingRod_empty");
    }

    @SideOnly(Side.CLIENT)
    public Icon func_94597_g()
    {
        return this.theIcon;
    }
}
