package ru.seer.money;

import net.minecraft.item.ItemSword;

public class SapphireSword extends ItemSword{
	protected SapphireSword() {
		super(Test.sapphireSword);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:SapphireSword");
	}
}
