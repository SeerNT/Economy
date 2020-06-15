package ru.seer.money;

import net.minecraft.item.ItemPickaxe;

public class OpalPickaxe extends ItemPickaxe {

	protected OpalPickaxe() {
		super(Test.opalPickAxe);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:OpalPickaxe");
	}

}