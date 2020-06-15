package ru.seer.money;

import net.minecraft.item.ItemSpade;

public class AmethystShovel extends ItemSpade {
	protected AmethystShovel() {
		super(Test.amethystShovel);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:AmethystShovel");
	}
}
