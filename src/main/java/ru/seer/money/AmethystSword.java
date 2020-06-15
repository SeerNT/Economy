package ru.seer.money;

import net.minecraft.item.ItemSword;

public class AmethystSword extends ItemSword{
	protected AmethystSword() {
		super(Test.amethystSword);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:AmethystSword");
	}
}
