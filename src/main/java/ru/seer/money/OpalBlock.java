package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OpalBlock extends Block {
	protected OpalBlock() {
		super(Material.iron);
		this.setBlockName("OpalBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(30F);
		this.setResistance(1F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:opal_block");
	}
}
