package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class amethystStairs extends BlockStairs {

	protected amethystStairs(Block p_i45428_1_, int p_i45428_2_) {
		super(p_i45428_1_, p_i45428_2_);
		this.setHardness(20f);
        this.setResistance(1.0f);
        this.setStepSound(p_i45428_1_.stepSound);
        this.setBlockName("amethystStairs");
		this.setCreativeTab(Test.tabTutorial);
        this.setLightOpacity(255);
        this.setBlockTextureName("money:AmethystBlock");
	}

}
