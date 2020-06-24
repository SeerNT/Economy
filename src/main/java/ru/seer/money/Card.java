package ru.seer.money;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import seer.money.data.ExtendedPlayer;
import seer.money.guihandlers.GuiShop;

public class Card extends Item {
	private String valueStr;
	public static double value;
	protected Card() {
		  super();
		  this.setCreativeTab(Test.others);
		  this.setTextureName("money:Card");
		  this.setMaxStackSize(1);
		}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	{
		ExtendedPlayer props = ExtendedPlayer.get(par2EntityPlayer);
		value = props.currentMoney;	
		valueStr = Double.toString(value);
		par2List.add("\u00a7a" + valueStr);
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			player.addStat(CommonProxy.achievementCard, 1);
		}
	}
	public void onUpdate(ItemStack item, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
		System.out.println(GuiShop.amount);
		ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) player);	
		value = props.currentMoney;
		valueStr = Double.toString(value);
	    if(props.currentMoney >= 10000) {
	    	((EntityPlayer) player).addStat(CommonProxy.achievementRich, 1);
	    }
	}
}
