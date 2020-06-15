package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import seer.money.data.ExtendedPlayer;

public class Card extends Item {
	protected Card() {
		  super();
		  this.setCreativeTab(Test.others);
		  this.setTextureName("money:Card");
		  this.setMaxStackSize(1);
		}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			player.addStat(CommonProxy.achievementCard, 1);
		}
	}
}
