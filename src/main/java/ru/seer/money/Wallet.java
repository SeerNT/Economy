package ru.seer.money;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.List;

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
	public static boolean open = false;
	public static boolean delete = false;
	public static boolean delete2 = false;
	public static boolean delete3 = false;
	public static boolean delete4 = false;
	public static boolean delete5 = false;
	public static boolean delete6 = false;
	public static boolean delete7 = false;
	public static boolean delete8 = false;
	public static boolean delete9 = false;
	public static boolean delete10 = false;
	public static boolean delete11 = false;
	public static boolean delete12 = false;
	public static boolean adelete = false;
	public static boolean adelete2 = false;
	public static boolean adelete3 = false;
	public static boolean adelete4 = false;
	public static boolean adelete5 = false;
	public static boolean adelete6 = false;
	public static boolean adelete7 = false;
	public static boolean adelete8 = false;
	public static boolean adelete9 = false;
	public static boolean adelete10 = false;
	public static boolean adelete11 = false;
	public static boolean adelete12 = false;
	public static boolean spdelete = false;
	public static boolean spdelete2 = false;
	public static boolean spdelete3 = false;
	public static boolean spdelete4 = false;
	public static boolean spdelete5 = false;
	public static boolean spdelete6 = false;
	public static boolean spdelete7 = false;
	public static boolean spdelete8 = false;
	public static boolean spdelete9 = false;
	public static boolean spdelete10 = false;
	public static boolean spdelete11 = false;
	public static boolean spdelete12 = false;
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
    	player.addStat(CommonProxy.achievementWallet, 1);
    		ExtendedPlayer props = ExtendedPlayer.get(player);
    		open  = true;
    		value = props.currentMoney;	
			iinventory = player.inventory;
			// If player not sneaking, open the inventory gui
			if (!player.isSneaking()) {
				player.openGui(Test.instance, 8, world, 0, 0, 0);
				counter = counter + 1;
				 
				if(counter == 2) {
					counter = 0;
					if(GuiCashMachine.opened == true) {
						if(delete == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(0, null);
							counter = 0;
							delete = false; 
							spdelete = false;
						}
						 if(delete2 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(1, null);
							counter = 0;
							delete2 = false; 
							spdelete2 = false;
						}
						 if(delete3 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(2, null);
							counter = 0;
							delete3 = false; 
							spdelete3 = false;
						}
						 if(delete4 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(3, null);
							counter = 0;
							delete4 = false; 
							spdelete4 = false;
						}
						 if(delete5 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(4, null);
							counter = 0;
							delete5 = false; 
							spdelete5 = false;
						}
						 if(delete6 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(5, null);
							counter = 0;
							delete6 = false; 
							spdelete6 = false;
						}
						 if(delete7 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(6, null);
							counter = 0;
							delete7 = false; 
							spdelete7 = false;
						}
						 if(delete8 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(7, null);
							counter = 0;
							delete8 = false; 
							spdelete8 = false;
						}
						 if(delete9 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(8, null);
							counter = 0;
							delete9 = false; 
							spdelete9 = false;
						}
						 if(delete10 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(9, null);
							counter = 0;
							delete10 = false;
							spdelete10 = false;
						}
						 if(delete11 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(10, null);
							counter = 0;
							delete11 = false; 
							spdelete11 = false;
						}
						 if(delete12 == true) {
							ContainerItem.slotWallet.inventory.setInventorySlotContents(11, null);
							counter = 0;
							delete12 = false; 
							spdelete12 = false;
						}else {
					 		counter = 0; 
					 	}
								
					counter = 0;
					}
				}
			}
			return itemstack;
    }
		
	

	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		EntityPlayer player = p_77663_2_.getClosestPlayerToEntity(p_77663_3_, 5);
		ExtendedPlayer props = ExtendedPlayer.get(player);
		props.currentMoney = GuiCashMachine.amount;
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		
	}
	
}
