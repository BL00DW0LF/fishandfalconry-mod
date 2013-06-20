package ff.blocks;

import java.util.Random;

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
    
    public boolean blockClicked(World world){
        clicks++;
        
        if (clicks>2){
            
            if (clicks >100)
                return false;//base case avoids making all the stuff below
            
            
            Random random=new Random();
            
            
            if ((random.nextFloat() * (clicks-2))<1f){
                EntityItem entityitem = new EntityItem(this.worldObj, (double)this.xCoord+.5d, (double)this.yCoord+.6d, (double)this.zCoord+.5d, new ItemStack(ItemIds.WORM+256,1,0));
                entityitem.delayBeforeCanPickup = 10;
                if (this.worldObj.spawnEntityInWorld(entityitem))
                    
                    return true;//got worm
                
            }
        }
        
        world.notifyBlockChange(xCoord, yCoord, zCoord, 2);
        return false;//didn't get worm
        
    }
}
