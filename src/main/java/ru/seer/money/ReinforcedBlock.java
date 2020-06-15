package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ReinforcedBlock extends Block {

	protected ReinforcedBlock() {
		super(Material.rock);
		this.setBlockName("ReinforcedBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(40F);
		this.setResistance(24F);
		this.setBlockTextureName("money:ReinforcedBlock");
	}

}
