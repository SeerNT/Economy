package ru.seer.money;

import net.minecraft.item.ItemSpade;

public class OpalShovel extends ItemSpade {
	protected OpalShovel() {
		super(Test.opalShovel);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:OpalShovel");
	}
}
