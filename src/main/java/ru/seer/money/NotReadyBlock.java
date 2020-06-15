package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NotReadyBlock extends Block {
	protected NotReadyBlock() {
		super(Material.iron);
		this.setBlockName("NotReadyBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(10F);
		this.setResistance(2F);
		this.setHarvestLevel("pickaxe",1);
		this.setBlockTextureName("money:not_ready");
	}
}
