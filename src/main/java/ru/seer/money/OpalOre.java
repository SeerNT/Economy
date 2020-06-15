package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OpalOre extends Block {
	protected OpalOre() {
		super(Material.rock);
		this.setBlockName("OpalOre");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(25F);
		this.setResistance(50F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:opal_ore");
	}
}
