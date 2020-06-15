package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class AmetItemSlab extends ItemSlab {

	 

	public AmetItemSlab (Block block) {

		super(block, (BlockSlab) Test.amethystSlab, (BlockSlab) Test.amethystSlab_double, false);
	
		this.setMaxDamage(0);

		this.setHasSubtypes(true);

	}

}