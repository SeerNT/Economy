package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class rubyStairs extends BlockStairs {

	protected rubyStairs(Block p_i45428_1_, int p_i45428_2_) {
		super(p_i45428_1_, p_i45428_2_);
		this.setHardness(20f);
        this.setResistance(1.0f);
        this.setStepSound(p_i45428_1_.stepSound);
        this.setBlockName("rubyStairs");
        this.setBlockTextureName("money:RubyBlock");
		this.setCreativeTab(Test.tabTutorial);
        this.setLightOpacity(255);
	}
	 public boolean isOpaqueCube() {
         return false;
 }

 public boolean renderAsNormalBlock() {
         return false;
 }

 public int getRenderType() {
         return 10;
 }

}
