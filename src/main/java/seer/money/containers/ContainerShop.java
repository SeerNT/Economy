package seer.money.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
import seer.money.guihandlers.GuiShopCustom;
import seer.money.rendering.tileentities.PrinterTileEntity;

public class ContainerShop extends Container {
	  private ShopTileEntity tile;
	  private Slot slot4;
	  private Slot slot5;
	  private Slot slot6;
	  private Slot slot7;
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
	  public static Boolean isCreated = false;
	  public static Boolean isClear = false;
	  
	  /**
	   * � ��������� ����������� ��������� ������ � TileEntity, ������� �� �������
	 * @param aplayer 
	   */
	    public ContainerShop(InventoryPlayer player, ShopTileEntity testTile, EntityPlayer aplayer) {
	    /* ��������� ��������� TileEntity �� ���, ������ ����������� ���������. ����� ��� �������,
	    ��� ������� TileEntity. */
	    	
	    	tile = testTile;
	        //����������, ���������� �� id �����, ��, ��� �� ������ ����������.
	    	i = 0;
	    /* �����, ���������� �� ���������� �����, ��� ������������ �������� ����� ������������:
	    IInventory (��� - ��������� TileEntity), id ����� (����� ������������ getStackInSlot, ��� ��� ��� ���),
	    ��� ����� �����, ������������ ��������������� �����. */
	    // ��������
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
	   * �����, ������� ����������� �� �������� ���������� � GUI, ������ ������������ ��� �������� ����������
	   * ����� ������� � TileEntity (� ������ ��������, ���� ��� ������� �������).
	   */
	    @Override
	    public boolean canInteractWith(EntityPlayer player) {
	        return ((IInventory) tile).isUseableByPlayer(player);
	    }
	    @Override
		public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
	    	return null;
		}
}  

	
