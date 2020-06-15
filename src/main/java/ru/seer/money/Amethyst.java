package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Amethyst extends Item {
	protected Amethyst() {
		  super();
		  this.setCreativeTab(Test.others);
		  this.setTextureName("money:AmethystItem");
	}

}
