package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class RubyItemSlab extends ItemSlab {

	 

	public RubyItemSlab (Block block) {

		super(block, (BlockSlab) Test.rubySlab, (BlockSlab) Test.rubySlab_double, false);
	
		this.setMaxDamage(0);

		this.setHasSubtypes(true);

	}

}