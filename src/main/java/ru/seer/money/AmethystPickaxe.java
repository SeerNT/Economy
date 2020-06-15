package ru.seer.money;

import net.minecraft.item.ItemPickaxe;

public class AmethystPickaxe extends ItemPickaxe {

	protected AmethystPickaxe() {
		super(Test.amethyst);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:AmethystPickaxe");
	}

}
