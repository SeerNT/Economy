package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AmethystOre extends Block {
	protected AmethystOre() {
		super(Material.rock);
		this.setBlockName("Amethyst Ore");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(15F);
		this.setResistance(50F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:AmethystOre");
	}
}
