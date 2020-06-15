package ru.seer.money;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import seer.money.rendering.tileentities.safeTileEntity;

public class Shop extends BlockContainer {
	@SideOnly(Side.CLIENT)
    protected IIcon field_150164_N;
	public static IInventory iinventory;
	protected Shop() {
		super(Material.rock);
		this.setBlockName("Shop");
		this.setCreativeTab(Test.tools);
		this.setHardness(6F);
		this.setResistance(6F);
		this.setHarvestLevel("pickaxe",2);
	}

	public TileEntity createNewTileEntity(World world, int id) {
		// TODO Auto-generated method stub
		return new ShopTileEntity();
	}
	private static boolean func_149953_o(World p_149953_0_, int p_149953_1_, int p_149953_2_, int p_149953_3_)
    {
        Iterator iterator = p_149953_0_.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getBoundingBox((double)p_149953_1_, (double)(p_149953_2_ + 1), (double)p_149953_3_, (double)(p_149953_1_ + 1), (double)(p_149953_2_ + 2), (double)(p_149953_3_ + 1))).iterator();
        EntityOcelot entityocelot;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            Entity entity = (Entity)iterator.next();
            entityocelot = (EntityOcelot)entity;
        }
        while (!entityocelot.isSitting());

        return true;
    }
	public IInventory func_149951_m(World p_149951_1_, int p_149951_2_, int p_149951_3_, int p_149951_4_)
    {
        Object object = (ShopTileEntity)p_149951_1_.getTileEntity(p_149951_2_, p_149951_3_, p_149951_4_);

        if (object == null)
        {
            return null;
        }
        else if (p_149951_1_.isSideSolid(p_149951_2_, p_149951_3_ + 1, p_149951_4_, DOWN))
        {
            return null;
        }
        else if (func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_))
        {
            return null;
        }
        else if (p_149951_1_.getBlock(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.isSideSolid(p_149951_2_ - 1, p_149951_3_ + 1, p_149951_4_, DOWN) || func_149953_o(p_149951_1_, p_149951_2_ - 1, p_149951_3_, p_149951_4_)))
        {
            return null;
        }
        else if (p_149951_1_.getBlock(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.isSideSolid(p_149951_2_ + 1, p_149951_3_ + 1, p_149951_4_, DOWN) || func_149953_o(p_149951_1_, p_149951_2_ + 1, p_149951_3_, p_149951_4_)))
        {
            return null;
        }
        else if (p_149951_1_.getBlock(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this && (p_149951_1_.isSideSolid(p_149951_2_, p_149951_3_ + 1, p_149951_4_ - 1, DOWN) || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ - 1)))
        {
            return null;
        }
        else if (p_149951_1_.getBlock(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this && (p_149951_1_.isSideSolid(p_149951_2_, p_149951_3_ + 1, p_149951_4_ + 1, DOWN) || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ + 1)))
        {
            return null;
        }
        else
        {
            

            return (IInventory)object;
        }
    }
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		iinventory = this.func_149951_m(world, x, y, z);
		if (iinventory != null)
        {
			player.openGui(Test.instance, 1, world, x, y, z);
			
        }
		
		
		return true;
	}
	public static void updateBlockState( World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);



		world.setBlock(x, y, z, Test.Shop);



		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}
	@Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public int getRenderType(){
    	 return -1;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        Block block = p_149689_1_.getBlock(p_149689_2_, p_149689_3_, p_149689_4_ - 1);
        Block block1 = p_149689_1_.getBlock(p_149689_2_, p_149689_3_, p_149689_4_ + 1);
        Block block2 = p_149689_1_.getBlock(p_149689_2_ - 1, p_149689_3_, p_149689_4_);
        Block block3 = p_149689_1_.getBlock(p_149689_2_ + 1, p_149689_3_, p_149689_4_);
        byte b0 = 0;
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            b0 = 2;
        }

        if (l == 1)
        {
            b0 = 5;
        }

        if (l == 2)
        {
            b0 = 3;
        }

        if (l == 3)
        {
            b0 = 4;
        }

        if (block != this && block1 != this && block2 != this && block3 != this)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, b0, 3);
        }
        else
        {
            if ((block == this || block1 == this) && (b0 == 4 || b0 == 5))
            {
                if (block == this)
                {
                    p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_ - 1, b0, 3);
                }
                else
                {
                    p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_ + 1, b0, 3);
                }

                p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, b0, 3);
            }

            if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3))
            {
                if (block2 == this)
                {
                    p_149689_1_.setBlockMetadataWithNotify(p_149689_2_ - 1, p_149689_3_, p_149689_4_, b0, 3);
                }
                else
                {
                    p_149689_1_.setBlockMetadataWithNotify(p_149689_2_ + 1, p_149689_3_, p_149689_4_, b0, 3);
                }

                p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, b0, 3);
            }
        }
    }
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        if (p_149719_1_.getBlock(p_149719_2_, p_149719_3_, p_149719_4_ - 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (p_149719_1_.getBlock(p_149719_2_, p_149719_3_, p_149719_4_ + 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
        }
        else if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) == this)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
        }
        else
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
    }
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        Block block = p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_ - 1);
        Block block1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_ + 1);
        Block block2 = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_, p_149726_4_);
        Block block3 = p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_, p_149726_4_);

        if (block == this)
        {
            this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ - 1);
        }

        if (block1 == this)
        {
            this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ + 1);
        }

        if (block2 == this)
        {
            this.func_149954_e(p_149726_1_, p_149726_2_ - 1, p_149726_3_, p_149726_4_);
        }

        if (block3 == this)
        {
            this.func_149954_e(p_149726_1_, p_149726_2_ + 1, p_149726_3_, p_149726_4_);
        }
    }
    public void func_149954_e(World p_149954_1_, int p_149954_2_, int p_149954_3_, int p_149954_4_)
    {
        if (!p_149954_1_.isRemote)
        {
            Block block = p_149954_1_.getBlock(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
            Block block1 = p_149954_1_.getBlock(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
            Block block2 = p_149954_1_.getBlock(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
            Block block3 = p_149954_1_.getBlock(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
            boolean flag = true;
            int l;
            Block block4;
            int i1;
            Block block5;
            boolean flag1;
            byte b0;
            int j1;

            if (block != this && block1 != this)
            {
                if (block2 != this && block3 != this)
                {
                    b0 = 3;

                    if (block.func_149730_j() && !block1.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if (block1.func_149730_j() && !block.func_149730_j())
                    {
                        b0 = 2;
                    }

                    if (block2.func_149730_j() && !block3.func_149730_j())
                    {
                        b0 = 5;
                    }

                    if (block3.func_149730_j() && !block2.func_149730_j())
                    {
                        b0 = 4;
                    }
                }
                else
                {
                    l = block2 == this ? p_149954_2_ - 1 : p_149954_2_ + 1;
                    block4 = p_149954_1_.getBlock(l, p_149954_3_, p_149954_4_ - 1);
                    i1 = block2 == this ? p_149954_2_ - 1 : p_149954_2_ + 1;
                    block5 = p_149954_1_.getBlock(i1, p_149954_3_, p_149954_4_ + 1);
                    b0 = 3;
                    flag1 = true;

                    if (block2 == this)
                    {
                        j1 = p_149954_1_.getBlockMetadata(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
                    }
                    else
                    {
                        j1 = p_149954_1_.getBlockMetadata(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
                    }

                    if (j1 == 2)
                    {
                        b0 = 2;
                    }

                    if ((block.func_149730_j() || block4.func_149730_j()) && !block1.func_149730_j() && !block5.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if ((block1.func_149730_j() || block5.func_149730_j()) && !block.func_149730_j() && !block4.func_149730_j())
                    {
                        b0 = 2;
                    }
                }
            }
            else
            {
                l = block == this ? p_149954_4_ - 1 : p_149954_4_ + 1;
                block4 = p_149954_1_.getBlock(p_149954_2_ - 1, p_149954_3_, l);
                i1 = block == this ? p_149954_4_ - 1 : p_149954_4_ + 1;
                block5 = p_149954_1_.getBlock(p_149954_2_ + 1, p_149954_3_, i1);
                b0 = 5;
                flag1 = true;

                if (block == this)
                {
                    j1 = p_149954_1_.getBlockMetadata(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
                }
                else
                {
                    j1 = p_149954_1_.getBlockMetadata(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
                }

                if (j1 == 4)
                {
                    b0 = 4;
                }

                if ((block2.func_149730_j() || block4.func_149730_j()) && !block3.func_149730_j() && !block5.func_149730_j())
                {
                    b0 = 5;
                }

                if ((block3.func_149730_j() || block5.func_149730_j()) && !block2.func_149730_j() && !block4.func_149730_j())
                {
                    b0 = 4;
                }
            }

            p_149954_1_.setBlockMetadataWithNotify(p_149954_2_, p_149954_3_, p_149954_4_, b0, 3);
        }
    }
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        int j1 = p_149660_9_ & 3;
        byte b0 = 0;

        switch (p_149660_5_)
        {
            case 0:
            case 1:
                b0 = 0;
                
                break;
            case 2:
            case 3:
                b0 = 8;
                
                break;
            case 4:
            case 5:
                b0 = 4;
        }

        return j1 | b0;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        int k = p_149691_2_ & 12;
        int l = p_149691_2_ & 3;
        return k == 0 && (p_149691_1_ == 1 || p_149691_1_ == 0) ? this.getTopIcon(l) : (k == 4 && (p_149691_1_ == 5 || p_149691_1_ == 4) ? this.getTopIcon(l) : (k == 8 && (p_149691_1_ == 2 || p_149691_1_ == 3) ? this.getTopIcon(l) : this.getSideIcon(l)));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_ & 3;
    }


    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.field_150164_N;
    }
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_) {
    	return this.field_150164_N;
	}
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    	
        this.field_150164_N = p_149651_1_.registerIcon("money:Shope");
    }
	
}
