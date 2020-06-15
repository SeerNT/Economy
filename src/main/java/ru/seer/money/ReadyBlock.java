package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ReadyBlock extends Block {

	protected ReadyBlock() {
		super(Material.iron);
		this.setBlockName("ReadyBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(10F);
		this.setResistance(2F);
		this.setHarvestLevel("pickaxe",1);
		this.setBlockTextureName("money:ready");
	}

}
