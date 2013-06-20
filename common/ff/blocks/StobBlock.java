package ff.blocks;


import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ff.lib.ItemIds;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class StobBlock extends BlockContainer{
    
 
    
    public StobBlock(int id) {
        super(id, Material.plants);
        float f = 0.23f;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.5F, 0.5F + f);
        
        // TODO Auto-generated constructor stub
    }

    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        //Block block = Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
        int blockID= par1World.getBlockId(par2, par3 - 1, par4);
        Block block = Block.blocksList[blockID];
        
        return (block != null && (blockID==dirt.blockID || blockID==grass.blockID || blockID==tilledField.blockID || blockID==mycelium.blockID));
    }

    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        this.checkBlockCoordValid(par1World, par2, par3, par4);
    }

    /**
     * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
     */
    protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }
    
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ItemIds.STOB+256;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)//may not need this

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return ItemIds.STOB;
    }
    
    public int damageDropped(int par1)
    {
        System.out.println("damage dropped: "+par1);
        return par1+1;
    }
    


    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        
        
        /*if (verticalPos== 0) 
            verticalPos++;
        else if (verticalPos==1)
            verticalPos++;
        else{
            
        }*/
        if (!par1World.isRemote){
            StobBlockData vert = (StobBlockData) par1World.getBlockTileEntity(par2, par3, par4);
            
            
            if (vert.blockClicked(par1World)){
                
                System.out.println(""+this.getDamageValue(par1World, par2, par3, par4));//got worm
            }
                
            
            return true;
            
        }
        return false;
    }
    
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    
    
    public TileEntity createNewTileEntity(World par1World)
    {
        try
        {
            return new StobBlockData();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    
    public int getMetadata (int damageValue) {
        return damageValue;
    }
    
    public void updateIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("mcQuickBuild:MeasuringTape");
    }
    
    public void registerIcons(IconRegister iconRegister){
        blockIcon = iconRegister.registerIcon("ff:stobBlock");
    }
}
