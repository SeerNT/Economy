package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SapphireBlock extends Block {
	protected SapphireBlock() {
		super(Material.iron);
		this.setBlockName("SapphireBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(14F);
		this.setResistance(1F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:sapphire_block");
	}
}
