package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RubyBlock extends Block {
	protected RubyBlock() {
		super(Material.iron);
		this.setBlockName("RubyBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(20F);
		this.setResistance(1F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:RubyBlock");
	}
}
