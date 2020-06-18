package ru.seer.money;

import net.minecraft.entity.Entity;
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
	public void onUpdate(ItemStack item, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
		ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) player);	
	    if(props.currentMoney >= 10000) {
	    	((EntityPlayer) player).addStat(CommonProxy.achievementRich, 1);
	    }
	}
}
