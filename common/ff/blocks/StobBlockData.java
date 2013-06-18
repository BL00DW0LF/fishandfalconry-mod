package ff.blocks;

import ff.lib.ItemIds;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class StobBlockData extends TileEntity {
    
    private int clicks=0;
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.clicks = nbt.getInteger("num");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("pos", clicks);
    }
    
    public int blockClicked(World world){
        clicks++;
        
        if (clicks>3){
             
            EntityItem entityitem = new EntityItem(this.worldObj, (double)this.xCoord+.5d, (double)this.yCoord+.75d, (double)this.zCoord+.5d, new ItemStack(ItemIds.WORM+256,1,0));
            entityitem.delayBeforeCanPickup = 10;
            this.worldObj.spawnEntityInWorld(entityitem);
        }
        
        world.notifyBlockChange(xCoord, yCoord, zCoord, 2);
        return clicks;
        
    }
}
