package ru.seer.money;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class ReinforcedGlass extends BlockBreakable {

	protected ReinforcedGlass () {
		super("money:ReinforcedGlass", Material.glass, false);
		this.setBlockName("ReinforcedGlass");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(20F);
		this.setResistance(12F);
		this.setBlockTextureName("money:ReinforcedGlass");
	}
	public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
	        return 1;
	}

	    /**
	     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	     */
	public boolean renderAsNormalBlock()
	{
	        return false;
    }	

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
