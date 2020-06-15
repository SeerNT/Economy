package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UltraPackOfDollars extends Block {
	protected UltraPackOfDollars() {
		super(Material.cake);
		this.setBlockName("Ultra Pack Of Dollars");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(0.2F);
		this.setResistance(1F);
		this.setHarvestLevel("shovel",0);
		this.setBlockTextureName("money:UltraPackOfDollars");
	}
}
