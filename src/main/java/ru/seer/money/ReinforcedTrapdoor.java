package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;

public class ReinforcedTrapdoor extends BlockTrapDoor {

	protected ReinforcedTrapdoor() {
		super(Material.iron);
		this.setHardness(25F);
		this.setResistance(35F);
		this.setBlockName("ReinforcedTrapdoor");
		this.setCreativeTab(Test.others);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:ReinforcedTrapdoor");
	}

}
