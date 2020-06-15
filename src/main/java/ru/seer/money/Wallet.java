package ru.seer.money;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import seer.money.data.ExtendedPlayer;
import seer.money.guihandlers.GuiCashMachine;
import seer.money.inventory.ContainerItem;

public class Wallet extends Item{
	public static double value;
	public static double damage = 0.0;
	public static IInventory iinventory;
	private int counter = 0;
	public static boolean delete = false;
	public static Boolean[] isNull = new Boolean[13];
	protected Wallet() {
		  super();
		  
		  this.setCreativeTab(Test.others);
		  this.setTextureName("money:Wallet");
		  this.setMaxStackSize(1);
		  isNull[0] = true;
		  isNull[1] = true;
		  isNull[2] = true;
		  isNull[3] = true;
		  isNull[4] = true;
		  isNull[5] = true;
		  isNull[6] = true;
		  isNull[7] = true;
		  isNull[8] = true;
		  isNull[9] = true;
		  isNull[10] = true;
		  isNull[11] = true;
		  isNull[12] = true;
		  
		}

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; // return any value greater than zero
	}

	
    @Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
			iinventory = player.inventory;
			// If player not sneaking, open the inventory gui
			if (!player.isSneaking()) {
				player.openGui(Test.instance, 8, world, 0, 0, 0);
				counter = counter + 1;
				 
				if(counter == 2) {
					for (int i = 0; i < 12; ++i)
					 {
						 	 if(GuiCashMachine.opened == true) {
						 		ContainerItem.slotWallet.inventory.setInventorySlotContents(i, null);
						 		//гдеяэ опнакелю
						 		if(isNull[i] == true && delete == true) {
									 ContainerItem.slotWallet.inventory.setInventorySlotContents(i, null);
									 counter = 0;
									 isNull[i] = false;
								 }
						 	 }else {
						 		counter = 0; 
						 	 }
							 delete = false;
						 
					 }
					counter = 0;
				}
			}
			return itemstack;
    }
		
	
	/*
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		EntityPlayer player = p_77663_2_.getClosestPlayerToEntity(p_77663_3_, 5);
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		value = props.currentMana;
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(MoneyEventHandler.sh == true) {
			if(!player.worldObj.isRemote) {
				if(item.getItem() == Test.Wallet) {
					int size = item.stackSize;
					ExtendedPlayer props = ExtendedPlayer.get(player);		
					if(props.currentMana >= props.maxMana) {
						((EntityPlayerMP)player).mcServer.getConfigurationManager().sendChatMsg(new ChatComponentText("Full Wallet!"));
					}else {
						props.currentMana += size;
						damage = damage + props.currentMana;
					}
					player.addStat(CommonProxy.achievementWallet, 1);
				}
			}
		}else {
			if(!player.worldObj.isRemote) {
				if(item.getItem() == Test.Wallet) {
							ExtendedPlayer props = ExtendedPlayer.get(player);		
							if(props.currentMana >= props.maxMana) {
								((EntityPlayerMP)player).mcServer.getConfigurationManager().sendChatMsg(new ChatComponentText("Full Wallet!"));
							}else {
								props.currentMana += 1;
								damage = damage + props.currentMana;
							}
							player.addStat(CommonProxy.achievementWallet, 1);
				}
			}
		}
		item.setItemDamage((int) damage);
	}
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx, float hy, float hz) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		// Here we'll use the method we made to see if the player has enough mana to do something
		// We'll print something to the console for debugging, but I'm sure you'll find a much
		// better action to perform.
		value = props.currentMana;
		if (!world.isRemote) {
			((EntityPlayerMP)player).mcServer.getConfigurationManager().sendChatMsg(new ChatComponentText("In wallet: "+value + " dollars"));
            return true;
        }
        
        return false;
    }
    */
}
