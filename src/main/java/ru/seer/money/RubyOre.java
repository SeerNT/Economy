package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class RubyOre extends Block {

	protected RubyOre() {
		super(Material.rock);
		this.setBlockName("Ruby Ore");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(15F);
		this.setResistance(50F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:RubyOre");
	}
	

}
