package seer.money.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import ru.seer.money.ShopTileEntity;
import seer.money.rendering.tileentities.Cash_MachineTileEntity;
import seer.money.rendering.tileentities.PrinterTileEntity;
import seer.money.rendering.tiles.TutFurnaceRecipes;

public class ContainerCashMachine extends Container {
	  private Cash_MachineTileEntity tile;
	  public static ItemStack item1;
	  public static ItemStack item2;
	  public static ItemStack item3;
	  public static ItemStack item4;
	  public static ItemStack item5;
	  public static ItemStack item6;
	  public static Boolean isSlotNull1 = true;
	  public static Boolean isSlotNull2 = true;
	  public static Boolean isSlotNull3 = true;
	  public static Boolean isSlotNull4 = true;
	  public static Boolean isSlotNull5 = true;
	  public static Boolean isSlotNull6 = true;
	  public static int i = 0;
	  public static Slot slot3;
	  public static Slot slot4;
	  public static Slot slot5;
	  public static Boolean isCreated = false;
	  public static Boolean isClear = false;
	  
	  /**
	   * ¬ аргументы указываетс€ инвентарь игрока и TileEntity, который мы открыли
	 * @param aplayer 
	   */
	    public ContainerCashMachine(InventoryPlayer player, Cash_MachineTileEntity testTile, EntityPlayer aplayer) {
	    /* Ќазначаем локальный TileEntity на тот, откуда открываетс€ контейнер. Ќужно дл€ методов,
	    что требуют TileEntity. */
	    	
	    	tile = testTile;
	        //ѕеременна€, отвечающа€ за id слота, да, они не должны повтор€тс€.
	    	i = 0;
	    	slot4 = new Slot(testTile,i++,70,44);
	    	this.addSlotToContainer(slot4);
	    	slot5 = new Slot(testTile,i++,88,44);
	    	this.addSlotToContainer(slot5);
	    /* ћетод, отвечающий за добавление слота, дл€ конструктора обычного слота используетс€:
	    IInventory (“ут - инвентарь TileEntity), id слота (будет использовать getStackInSlot, или как его там),
	    два целых числа, обозначающие местонахождение слота. */
	    // „етвЄртый
	    	int j;
	    	// Player Inventory, Slot 9-35, Slot IDs 9-35
	        for (int y = 0; y < 3; ++y) {
	            for (int x = 0; x < 9; ++x) {
	                this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
	            }
	        }

	        // Player Inventory, Slot 0-8, Slot IDs 36-44
	        for (int x = 0; x < 9; ++x) {
	            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
	        }
	        /*
	    	for(j=0;j<= 5;j++) {
	    		slot3 = new Slot(testTile,i++,63 + (18 * j),11);
	    		slot3.inventory.setInventorySlotContents(i - 1, null);
	    		addSlotToContainer(slot3);
	    	}
	    	if (GuiShopCustom.item1IsNull == false) {
  			if (isSlotNull1 == true) {
  				item1 = GuiShopCustom.item1;
  				slot3.inventory.setInventorySlotContents(0, GuiShopCustom.item1);
  				isSlotNull1 = false;
  			}else {
  				if (isSlotNull2 == true) {
	    				slot3.inventory.setInventorySlotContents(1, GuiShopCustom.item1);
	    				item1 = GuiShopCustom.item1;
	    				isSlotNull2 = false;
	    			}else {
	    				if (isSlotNull3 == true) {
		    				slot3.inventory.setInventorySlotContents(2, GuiShopCustom.item1);
		    				item1 = GuiShopCustom.item1;
		    				isSlotNull3 = false;
		    			}else {
		    				if (isSlotNull4 == true) {
			    				slot3.inventory.setInventorySlotContents(3, GuiShopCustom.item1);
			    				item1 = GuiShopCustom.item1;
			    				isSlotNull4 = false;
			    			}else {
			    				if (isSlotNull5 == true) {
				    				slot3.inventory.setInventorySlotContents(4, GuiShopCustom.item1);
				    				item1 = GuiShopCustom.item1;
				    				isSlotNull5 = false;
				    			}else {
				    				if (isSlotNull6 == true) {
					    				slot3.inventory.setInventorySlotContents(5, GuiShopCustom.item1);
					    				item1 = GuiShopCustom.item1;
					    				isSlotNull6 = false;
				    				}
				    			}
			    			}
		    			}
	    			}
  			}
	    	}
	    	if (GuiShopCustom.item2IsNull == false) {
  			if (isSlotNull1 == true) {
  				slot3.inventory.setInventorySlotContents(0, GuiShopCustom.item2);
  				item2 = GuiShopCustom.item2;
  				isSlotNull1 = false;
  			}else {
  				if (isSlotNull2 == true) {
	    				slot3.inventory.setInventorySlotContents(1, GuiShopCustom.item2);
	    				item2 = GuiShopCustom.item2;
	    				isSlotNull2 = false;
	    			}else {
	    				if (isSlotNull3 == true) {
		    				slot3.inventory.setInventorySlotContents(2, GuiShopCustom.item2);
		    				item2 = GuiShopCustom.item2;
		    				isSlotNull3 = false;
		    			}else {
		    				if (isSlotNull4 == true) {
			    				slot3.inventory.setInventorySlotContents(3, GuiShopCustom.item2);
			    				item2 = GuiShopCustom.item2;
			    				isSlotNull4 = false;
			    			}else {
			    				if (isSlotNull5 == true) {
				    				slot3.inventory.setInventorySlotContents(4, GuiShopCustom.item2);
				    				item2 = GuiShopCustom.item2;
				    				isSlotNull5 = false;
				    			}else {
				    				if (isSlotNull6 == true) {
					    				slot3.inventory.setInventorySlotContents(5, GuiShopCustom.item2);
					    				item2 = GuiShopCustom.item2;
					    				isSlotNull6 = false;
				    				}
				    			}
			    			}
		    			}
	    			}
  			}
	    	}
	    	if (GuiShopCustom.item3IsNull == false) {
  			if (isSlotNull1 == true) {
  				slot3.inventory.setInventorySlotContents(0, GuiShopCustom.item3);
  				item3 = GuiShopCustom.item3;
  				isSlotNull1 = false;
  			}else {
  				if (isSlotNull2 == true) {
	    				slot3.inventory.setInventorySlotContents(1, GuiShopCustom.item3);
	    				item3 = GuiShopCustom.item3;
	    				isSlotNull2 = false;
	    			}else {
	    				if (isSlotNull3 == true) {
		    				slot3.inventory.setInventorySlotContents(2, GuiShopCustom.item3);
		    				item3 = GuiShopCustom.item3;
		    				isSlotNull3 = false;
		    			}else {
		    				if (isSlotNull4 == true) {
			    				slot3.inventory.setInventorySlotContents(3, GuiShopCustom.item3);
			    				item3 = GuiShopCustom.item3;
			    				isSlotNull4 = false;
			    			}else {
			    				if (isSlotNull5 == true) {
				    				slot3.inventory.setInventorySlotContents(4, GuiShopCustom.item3);
				    				item3 = GuiShopCustom.item3;
				    				isSlotNull5 = false;
				    			}else {
				    				if (isSlotNull6 == true) {
					    				slot3.inventory.setInventorySlotContents(5, GuiShopCustom.item3);
					    				item3 = GuiShopCustom.item3;
					    				isSlotNull6 = false;
				    				}
				    			}
			    			}
		    			}
	    			}
  			}
	    	}
	    	if (GuiShopCustom.item4IsNull == false) {
  			if (isSlotNull1 == true) {
  				slot3.inventory.setInventorySlotContents(0, GuiShopCustom.item4);
  				item4 = GuiShopCustom.item4;
  				isSlotNull1 = false;
  			}else {
  				if (isSlotNull2 == true) {
	    				slot3.inventory.setInventorySlotContents(1, GuiShopCustom.item4);
	    				item4 = GuiShopCustom.item4;
	    				isSlotNull2 = false;
	    			}else {
	    				if (isSlotNull3 == true) {
		    				slot3.inventory.setInventorySlotContents(2, GuiShopCustom.item4);
		    				item4 = GuiShopCustom.item4;
		    				isSlotNull3 = false;
		    			}else {
		    				if (isSlotNull4 == true) {
			    				slot3.inventory.setInventorySlotContents(3, GuiShopCustom.item4);
			    				item4 = GuiShopCustom.item4;
			    				isSlotNull4 = false;
			    			}else {
			    				if (isSlotNull5 == true) {
				    				slot3.inventory.setInventorySlotContents(4, GuiShopCustom.item4);
				    				item4 = GuiShopCustom.item4;
				    				isSlotNull5 = false;
				    			}else {
				    				if (isSlotNull6 == true) {
					    				slot3.inventory.setInventorySlotContents(5, GuiShopCustom.item4);
					    				item4 = GuiShopCustom.item4;
					    				isSlotNull6 = false;
				    				}
				    			}
			    			}
		    			}
	    			}
  			}
	    	}
	    	if (GuiShopCustom.item5IsNull == false) {
  			if (isSlotNull1 == true) {
  				slot3.inventory.setInventorySlotContents(0, GuiShopCustom.item5);
  				item5 = GuiShopCustom.item5;
  				isSlotNull1 = false;
  			}else {
  				if (isSlotNull2 == true) {
	    				slot3.inventory.setInventorySlotContents(1, GuiShopCustom.item5);
	    				item5 = GuiShopCustom.item5;
	    				isSlotNull2 = false;
	    			}else {
	    				if (isSlotNull3 == true) {
		    				slot3.inventory.setInventorySlotContents(2, GuiShopCustom.item5);
		    				item5 = GuiShopCustom.item5;
		    				isSlotNull3 = false;
		    			}else {
		    				if (isSlotNull4 == true) {
			    				slot3.inventory.setInventorySlotContents(3, GuiShopCustom.item5);
			    				item5 = GuiShopCustom.item5;
			    				isSlotNull4 = false;
			    			}else {
			    				if (isSlotNull5 == true) {
				    				slot3.inventory.setInventorySlotContents(4, GuiShopCustom.item5);
				    				item5 = GuiShopCustom.item5;
				    				isSlotNull5 = false;
				    			}else {
				    				if (isSlotNull6 == true) {
					    				slot3.inventory.setInventorySlotContents(5, GuiShopCustom.item5);
					    				item5 = GuiShopCustom.item5;
					    				isSlotNull6 = false;
				    				}
				    			}
			    			}
		    			}
	    			}
  			}
	    	}
	    	if (GuiShopCustom.item6IsNull == false) {
  			if (isSlotNull1 == true) {
  				slot3.inventory.setInventorySlotContents(0, GuiShopCustom.item6);
  				item6 = GuiShopCustom.item6;
  				isSlotNull1 = false;
  			}else {
  				if (isSlotNull2 == true) {
	    				slot3.inventory.setInventorySlotContents(1, GuiShopCustom.item6);
	    				item6 = GuiShopCustom.item6;
	    				isSlotNull2 = false;
	    			}else {
	    				if (isSlotNull3 == true) {
		    				slot3.inventory.setInventorySlotContents(2, GuiShopCustom.item6);
		    				item6 = GuiShopCustom.item6;
		    				isSlotNull3 = false;
		    			}else {
		    				if (isSlotNull4 == true) {
			    				slot3.inventory.setInventorySlotContents(3, GuiShopCustom.item6);
			    				item6 = GuiShopCustom.item6;
			    				isSlotNull4 = false;
			    			}else {
			    				if (isSlotNull5 == true) {
				    				slot3.inventory.setInventorySlotContents(4, GuiShopCustom.item6);
				    				item6 = GuiShopCustom.item6;
				    				isSlotNull5 = false;
				    			}else {
				    				if (isSlotNull6 == true) {
					    				slot3.inventory.setInventorySlotContents(5, GuiShopCustom.item6);
					    				item6 = GuiShopCustom.item6;
					    				isSlotNull6 = false;
				    				}
				    			}
			    			}
		    			}
	    			}
  			}
	    	}
		    */
		    		
		    	
		   
		    	ContainerShopCustom.chosen = false;
	    	}
	    
	    
	    
	  /**
	   * ћетод, который выполн€етс€ до открыти€ контейнера и GUI, обычно используетс€ дл€ проверки рассто€ни€
	   * между игроком и TileEntity (и отмены открыти€, если оно слишком большое).
	   */
	    @Override
	    public boolean canInteractWith(EntityPlayer player) {
	        return ((IInventory) tile).isUseableByPlayer(player);
	    }
	    public ItemStack transferStackInSlot(EntityPlayer player, int par2){
			ItemStack itemstack = null;
			Slot slot = (Slot) this.inventorySlots.get(par2);
			
			if(slot != null && slot.getHasStack()){
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				
				if(par2 == 2){
					if(!this.mergeItemStack(itemstack1, 3, 39, true)){
						return null;
					}
					slot.onSlotChange(itemstack1, itemstack);
				}else if(par2 != 1 && par2 != 0){
					if(par2 >=3 && par2 < 30){
						if(!this.mergeItemStack(itemstack1, 30, 39, false)){
							return null;
						}
					}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
						return null;
					}
				}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
					return null;
				}
				if(itemstack1.stackSize == 0){
					slot.putStack((ItemStack)null);
				}else{
					slot.onSlotChanged();
				}
				if(itemstack1.stackSize == itemstack.stackSize){
					return null;
				}
				slot.onPickupFromSlot(player, itemstack1);
			}
			return itemstack;
		}
}  

	
