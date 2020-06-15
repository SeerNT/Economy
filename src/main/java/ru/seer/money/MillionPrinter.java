package ru.seer.money;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import seer.money.rendering.tileentities.PrinterTileEntity;

public class MillionPrinter extends BlockContainer {
	private static boolean field_149934_M;
	 private final Random field_149933_a = new Random();
	private static boolean isBurning;
	private static final int[][] field_150150_a = new int[][] {{2, 6}, {3, 7}, {2, 3}, {6, 7}, {0, 4}, {1, 5}, {0, 1}, {4, 5}};
	private boolean field_150152_N;
	private int field_150153_O;
	private final Block field_150149_b;
	private final boolean isBurning2;
	private final Random random = new Random();
	protected MillionPrinter(boolean isActive,Block p_i45428_1_, int p_i45428_2_) {
		
		super(Material.rock);
		this.field_150149_b = p_i45428_1_;
		this.isBurning2 = isActive;
		this.setBlockName("Million Printer");
		this.setCreativeTab(Test.tools);
		this.setHardness(60F);
		this.setResistance(6F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:MillionPrinter");
	}
	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        if (!field_149934_M)
        {
            MillionTileEntity tileentityfurnace = (MillionTileEntity)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

            if (tileentityfurnace != null)
            {
                for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.field_149933_a.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + f), (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.field_149933_a.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.field_149933_a.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.field_149933_a.nextGaussian() * f3);
                            p_149749_1_.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
            }
        }

        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
    }
	 @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	    {
	        this.field_150149_b.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
	    }
	 public int tickRate(World p_149738_1_)
	    {
	        return this.field_150149_b.tickRate(p_149738_1_);
	    }
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        if (this.field_150152_N)
        {
            this.setBlockBounds(0.5F * (float)(this.field_150153_O % 2), 0.5F * (float)(this.field_150153_O / 2 % 2), 0.5F * (float)(this.field_150153_O / 4 % 2), 0.5F + 0.5F * (float)(this.field_150153_O % 2), 0.5F + 0.5F * (float)(this.field_150153_O / 2 % 2), 0.5F + 0.5F * (float)(this.field_150153_O / 4 % 2));
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }
	@Override
	public TileEntity createNewTileEntity(World world, int id) {
		return new MillionTileEntity();
	}
	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        this.onNeighborBlockChange(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, Blocks.air);
        this.field_150149_b.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(Test.instance, 6, world, x, y, z);
		return true;
	}
	public MovingObjectPosition collisionRayTrace(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_)
    {
        MovingObjectPosition[] amovingobjectposition = new MovingObjectPosition[8];
        int l = p_149731_1_.getBlockMetadata(p_149731_2_, p_149731_3_, p_149731_4_);
        int i1 = l & 3;
        boolean flag = (l & 4) == 4;
        int[] aint = field_150150_a[i1 + (flag?4:0)];
        this.field_150152_N = true;
        int k1;
        int l1;
        int i2;

        for (int j1 = 0; j1 < 8; ++j1)
        {
            this.field_150153_O = j1;
            int[] aint1 = aint;
            k1 = aint.length;

            for (l1 = 0; l1 < k1; ++l1)
            {
                i2 = aint1[l1];

                if (i2 == j1)
                {
                    ;
                }
            }

            amovingobjectposition[j1] = super.collisionRayTrace(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
        }

        int[] aint2 = aint;
        int k2 = aint.length;

        for (k1 = 0; k1 < k2; ++k1)
        {
            l1 = aint2[k1];
            amovingobjectposition[l1] = null;
        }

        MovingObjectPosition movingobjectposition1 = null;
        double d1 = 0.0D;
        MovingObjectPosition[] amovingobjectposition1 = amovingobjectposition;
        i2 = amovingobjectposition.length;

        for (int j2 = 0; j2 < i2; ++j2)
        {
            MovingObjectPosition movingobjectposition = amovingobjectposition1[j2];

            if (movingobjectposition != null)
            {
                double d0 = movingobjectposition.hitVec.squareDistanceTo(p_149731_6_);

                if (d0 > d1)
                {
                    movingobjectposition1 = movingobjectposition;
                    d1 = d0;
                }
            }
        }

        return movingobjectposition1;
    }
	private void direction(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block direction = world.getBlock(x, y, z - 1);
			Block direction1 = world.getBlock(x, y, z + 1);
			Block direction2 = world.getBlock(x - 1, y, z);
			Block direction3 = world.getBlock(x + 1, y, z);
			byte byte0 = 3;

			if (direction.func_149730_j() && direction.func_149730_j()) {
				byte0 = 3;
			}

			if (direction1.func_149730_j() && direction1.func_149730_j()) {
				byte0 = 2;
			}

			if (direction2.func_149730_j() && direction2.func_149730_j()) {
				byte0 = 5;
			}

			if (direction3.func_149730_j() && direction3.func_149730_j()) {
				byte0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
		}
	}

	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = p_149689_1_.getBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_) & 4;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2 | i1, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 1 | i1, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3 | i1, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 0 | i1, 2);
        }
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        return p_149660_5_ != 0 && (p_149660_5_ == 1 || (double)p_149660_7_ <= 0.5D) ? p_149660_9_ : p_149660_9_ | 4;
    }


	public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;

		if (burning) {
			world.setBlock(x, y, z, Test.MillionPrinter);
		} else {
			world.setBlock(x, y, z, Test.MillionPrinter);
		}

		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

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
    private boolean func_150146_f(IBlockAccess p_150146_1_, int p_150146_2_, int p_150146_3_, int p_150146_4_, int p_150146_5_)
    {
        Block block = p_150146_1_.getBlock(p_150146_2_, p_150146_3_, p_150146_4_);
        return func_150148_a(block) && p_150146_1_.getBlockMetadata(p_150146_2_, p_150146_3_, p_150146_4_) == p_150146_5_;
    }

    public boolean func_150145_f(IBlockAccess p_150145_1_, int p_150145_2_, int p_150145_3_, int p_150145_4_)
    {
        int l = p_150145_1_.getBlockMetadata(p_150145_2_, p_150145_3_, p_150145_4_);
        int i1 = l & 3;
        float f = 0.5F;
        float f1 = 1.0F;

        if ((l & 4) != 0)
        {
            f = 0.0F;
            f1 = 0.5F;
        }

        float f2 = 0.0F;
        float f3 = 1.0F;
        float f4 = 0.0F;
        float f5 = 0.5F;
        boolean flag = true;
        Block block;
        int j1;
        int k1;

        if (i1 == 0)
        {
            f2 = 0.5F;
            f5 = 1.0F;
            block = p_150145_1_.getBlock(p_150145_2_ + 1, p_150145_3_, p_150145_4_);
            j1 = p_150145_1_.getBlockMetadata(p_150145_2_ + 1, p_150145_3_, p_150145_4_);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                k1 = j1 & 3;

                if (k1 == 3 && !this.func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ + 1, l))
                {
                    f5 = 0.5F;
                    flag = false;
                }
                else if (k1 == 2 && !this.func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ - 1, l))
                {
                    f4 = 0.5F;
                    flag = false;
                }
            }
        }
        else if (i1 == 1)
        {
            f3 = 0.5F;
            f5 = 1.0F;
            block = p_150145_1_.getBlock(p_150145_2_ - 1, p_150145_3_, p_150145_4_);
            j1 = p_150145_1_.getBlockMetadata(p_150145_2_ - 1, p_150145_3_, p_150145_4_);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                k1 = j1 & 3;

                if (k1 == 3 && !this.func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ + 1, l))
                {
                    f5 = 0.5F;
                    flag = false;
                }
                else if (k1 == 2 && !this.func_150146_f(p_150145_1_, p_150145_2_, p_150145_3_, p_150145_4_ - 1, l))
                {
                    f4 = 0.5F;
                    flag = false;
                }
            }
        }
        else if (i1 == 2)
        {
            f4 = 0.5F;
            f5 = 1.0F;
            block = p_150145_1_.getBlock(p_150145_2_, p_150145_3_, p_150145_4_ + 1);
            j1 = p_150145_1_.getBlockMetadata(p_150145_2_, p_150145_3_, p_150145_4_ + 1);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                k1 = j1 & 3;

                if (k1 == 1 && !this.func_150146_f(p_150145_1_, p_150145_2_ + 1, p_150145_3_, p_150145_4_, l))
                {
                    f3 = 0.5F;
                    flag = false;
                }
                else if (k1 == 0 && !this.func_150146_f(p_150145_1_, p_150145_2_ - 1, p_150145_3_, p_150145_4_, l))
                {
                    f2 = 0.5F;
                    flag = false;
                }
            }
        }
        else if (i1 == 3)
        {
            block = p_150145_1_.getBlock(p_150145_2_, p_150145_3_, p_150145_4_ - 1);
            j1 = p_150145_1_.getBlockMetadata(p_150145_2_, p_150145_3_, p_150145_4_ - 1);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                k1 = j1 & 3;

                if (k1 == 1 && !this.func_150146_f(p_150145_1_, p_150145_2_ + 1, p_150145_3_, p_150145_4_, l))
                {
                    f3 = 0.5F;
                    flag = false;
                }
                else if (k1 == 0 && !this.func_150146_f(p_150145_1_, p_150145_2_ - 1, p_150145_3_, p_150145_4_, l))
                {
                    f2 = 0.5F;
                    flag = false;
                }
            }
        }

        this.setBlockBounds(f2, f, f4, f3, f1, f5);
        return flag;
    }

    public boolean func_150144_g(IBlockAccess p_150144_1_, int p_150144_2_, int p_150144_3_, int p_150144_4_)
    {
        int l = p_150144_1_.getBlockMetadata(p_150144_2_, p_150144_3_, p_150144_4_);
        int i1 = l & 3;
        float f = 0.5F;
        float f1 = 1.0F;

        if ((l & 4) != 0)
        {
            f = 0.0F;
            f1 = 0.5F;
        }

        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = 0.5F;
        float f5 = 1.0F;
        boolean flag = false;
        Block block;
        int j1;
        int k1;

        if (i1 == 0)
        {
            block = p_150144_1_.getBlock(p_150144_2_ - 1, p_150144_3_, p_150144_4_);
            j1 = p_150144_1_.getBlockMetadata(p_150144_2_ - 1, p_150144_3_, p_150144_4_);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                k1 = j1 & 3;

                if (k1 == 3 && !this.func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ - 1, l))
                {
                    f4 = 0.0F;
                    f5 = 0.5F;
                    flag = true;
                }
                else if (k1 == 2 && !this.func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ + 1, l))
                {
                    f4 = 0.5F;
                    f5 = 1.0F;
                    flag = true;
                }
            }
        }
        else if (i1 == 1)
        {
            block = p_150144_1_.getBlock(p_150144_2_ + 1, p_150144_3_, p_150144_4_);
            j1 = p_150144_1_.getBlockMetadata(p_150144_2_ + 1, p_150144_3_, p_150144_4_);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                f2 = 0.5F;
                f3 = 1.0F;
                k1 = j1 & 3;

                if (k1 == 3 && !this.func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ - 1, l))
                {
                    f4 = 0.0F;
                    f5 = 0.5F;
                    flag = true;
                }
                else if (k1 == 2 && !this.func_150146_f(p_150144_1_, p_150144_2_, p_150144_3_, p_150144_4_ + 1, l))
                {
                    f4 = 0.5F;
                    f5 = 1.0F;
                    flag = true;
                }
            }
        }
        else if (i1 == 2)
        {
            block = p_150144_1_.getBlock(p_150144_2_, p_150144_3_, p_150144_4_ - 1);
            j1 = p_150144_1_.getBlockMetadata(p_150144_2_, p_150144_3_, p_150144_4_ - 1);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                f4 = 0.0F;
                f5 = 0.5F;
                k1 = j1 & 3;

                if (k1 == 1 && !this.func_150146_f(p_150144_1_, p_150144_2_ - 1, p_150144_3_, p_150144_4_, l))
                {
                    flag = true;
                }
                else if (k1 == 0 && !this.func_150146_f(p_150144_1_, p_150144_2_ + 1, p_150144_3_, p_150144_4_, l))
                {
                    f2 = 0.5F;
                    f3 = 1.0F;
                    flag = true;
                }
            }
        }
        else if (i1 == 3)
        {
            block = p_150144_1_.getBlock(p_150144_2_, p_150144_3_, p_150144_4_ + 1);
            j1 = p_150144_1_.getBlockMetadata(p_150144_2_, p_150144_3_, p_150144_4_ + 1);

            if (func_150148_a(block) && (l & 4) == (j1 & 4))
            {
                k1 = j1 & 3;

                if (k1 == 1 && !this.func_150146_f(p_150144_1_, p_150144_2_ - 1, p_150144_3_, p_150144_4_, l))
                {
                    flag = true;
                }
                else if (k1 == 0 && !this.func_150146_f(p_150144_1_, p_150144_2_ + 1, p_150144_3_, p_150144_4_, l))
                {
                    f2 = 0.5F;
                    f3 = 1.0F;
                    flag = true;
                }
            }
        }

        if (flag)
        {
            this.setBlockBounds(f2, f, f4, f3, f1, f5);
        }

        return flag;
    }
    public static boolean func_150148_a(Block p_150148_0_)
    {
        return p_150148_0_ instanceof BlockStairs;
    }

}
