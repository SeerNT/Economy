package ru.seer.money;

import net.minecraft.item.ItemSword;

public class OpalSword extends ItemSword{
	protected OpalSword() {
		super(Test.opalSword);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:OpalSword");
	}
}
