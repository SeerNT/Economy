package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SapphireOre extends Block {

	protected SapphireOre() {
		super(Material.rock);
		this.setBlockName("SapphireOre");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(12F);
		this.setResistance(50F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:sapphire_ore");
	}

}
