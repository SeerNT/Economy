package ru.seer.money;

import net.minecraft.item.ItemSpade;

public class SapphireShovel extends ItemSpade {
	protected SapphireShovel() {
		super(Test.sapphireShovel);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:SapphireShovel");
	}
}