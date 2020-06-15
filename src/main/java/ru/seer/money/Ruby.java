package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Ruby extends Item {
	protected Ruby() {
		  super();
		  this.setCreativeTab(Test.others);
		  this.setTextureName("money:RubyItem");
	}
}
