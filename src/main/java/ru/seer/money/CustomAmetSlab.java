package ru.seer.money;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CustomAmetSlab extends BlockSlab {
	public static final String[] field_150005_b = new String[] {"amet"};
    private static final String __OBFID = "CL_00000337";

    public CustomAmetSlab(boolean p_i45437_1_)
    {
        super(p_i45437_1_, Material.iron);
        this.setCreativeTab(Test.tabTutorial);
        this.setBlockName("amethystSlab");
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return Test.AmethystBlock.getIcon(p_149691_1_, p_149691_2_ & 7);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Test.amethystSlab);
    }
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(Test.amethystSlab);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(Item.getItemFromBlock(Test.amethystSlab), 2, p_149644_1_ & 7);
    }

    public String func_150002_b(int p_150002_1_)
    {
        if (p_150002_1_ < 0 || p_150002_1_ >= field_150005_b.length)
        {
            p_150002_1_ = 0;
        }

        return "amethystSlab";
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if (p_149666_1_ != Item.getItemFromBlock(Test.amethystSlab_double))
        {
            for (int i = 0; i < field_150005_b.length; ++i)
            {
                p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {}

		
}
