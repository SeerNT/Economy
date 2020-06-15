package ru.seer.money;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class tools extends CreativeTabs {

	public tools(String lable) {
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(Test.MegaPrinter);
	}

}
