package seer.money.containers;



import java.util.List;



import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
import seer.money.guihandlers.GuiShop;
import seer.money.guihandlers.GuiShopCustom;

public class ContainerShopCustom extends Container {
	  private static ShopTileEntity tile;
	  public static int i = 0;
	  public static Boolean check = false;
	  public static Boolean chosen = false;
	  public static Boolean isCreated = false;
	  public static Slot slot1;
	  public static Slot slot2;
	  public static Slot slot3;
	  public static Slot slot4;
	  public static Slot slot5;
	  public static Slot slot6;
	  /**
	   * ¬ аргументы указываетс€ инвентарь игрока и TileEntity, который мы открыли
	   */
	    public ContainerShopCustom(InventoryPlayer player, ShopTileEntity testTile) {
	    /* Ќазначаем локальный TileEntity на тот, откуда открываетс€ контейнер. Ќужно дл€ методов,
	    что требуют TileEntity. 
	     */
	    tile = testTile;
	   
	        //ѕеременна€, отвечающа€ за id слота, да, они не должны повтор€тс€.
	    i = 0;
	    
	    
	    // —лоты предметов которые выбрали
	    slot1 = new Slot(testTile, i++, 26, 151);
	    slot2 = new Slot(testTile, i++, 44, 151);
	    slot3 = new Slot(testTile, i++, 62, 151);
	    slot4 = new Slot(testTile, i++, 80, 151);
	    slot5 = new Slot(testTile, i++, 98, 151);
	    slot6 = new Slot(testTile, i++, 116, 151);
	    addSlotToContainer(slot1);
	    addSlotToContainer(slot2);
	    addSlotToContainer(slot3);
	    addSlotToContainer(slot4);
	    addSlotToContainer(slot5);
	    addSlotToContainer(slot6);
	    
	    // —лоты дл€ выбора
	    int j;
	    if (GuiShopCustom.amethystIs == true) {
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,8,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,26,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,44,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,62,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,80,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,98,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,116,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,134,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
    	for (j = 0;j <= 6;j++) {
    		Slot slot8 = new Slot(testTile,i++,152,25 + (18 * j));
    		if (j == 0) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Amethyst, 64));
    		}
    		if (j == 1) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystHelmet));
    		}
    		if (j == 2) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystChestplate));
    		}
    		if (j == 3) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystPants));
    		}
    		if (j == 4) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBoots));
    		}
    		if (j == 5) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystSword));
    		}
    		if (j == 6) {
    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBow));
    		}
    		addSlotToContainer(slot8);
    	}
	    }
	    if (GuiShopCustom.rubyIs == true) {
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,8,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,26,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,44,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,62,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,80,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,98,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,116,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,134,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,152,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
		    }
	    if (GuiShopCustom.decorIs == true) {
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,8,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.bed));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBlock));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.diamond_block));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.gold_block));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,26,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,44,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,62,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,80,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,98,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,116,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,134,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,152,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
		    }
	    if (GuiShopCustom.mobsIs == true) {
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,8,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Items.spawn_egg, 1, 39));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Items.spawn_egg, 1, 39));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.diamond_block));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.gold_block));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,26,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,44,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,62,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,80,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,98,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,116,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,134,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,152,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
		    }
	    if (GuiShopCustom.uniqueIs == true) {
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,8,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBlock));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBlock));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.diamond_block));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.gold_block));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,26,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,44,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,62,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,80,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,98,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,116,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,134,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,152,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
		    }
	    if (GuiShopCustom.blocksIs == true) {
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,8,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBlock));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.AmethystBlock));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.diamond_block));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Blocks.gold_block));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,26,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,44,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,62,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,80,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,98,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,116,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,134,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
	    	for (j = 0;j <= 6;j++) {
	    		Slot slot8 = new Slot(testTile,i++,152,25 + (18 * j));
	    		if (j == 0) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.Ruby));
	    		}
	    		if (j == 1) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyHelmet));
	    		}
	    		if (j == 2) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyChestplate));
	    		}
	    		if (j == 3) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyPants));
	    		}
	    		if (j == 4) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBoots));
	    		}
	    		if (j == 5) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubySword));
	    		}
	    		if (j == 6) {
	    			slot8.inventory.setInventorySlotContents(i - 1, new ItemStack(Test.RubyBow));
	    		}
	    		addSlotToContainer(slot8);
	    	}
		    }
	    
		
	    isCreated = true;
	    }

	  /**
	   * ћетод, который выполн€етс€ до открыти€ контейнера и GUI, обычно используетс€ дл€ проверки рассто€ни€
	   * между игроком и TileEntity (и отмены открыти€, если оно слишком большое).
	   */
	    @Override
	    public boolean canInteractWith(EntityPlayer player) {
	        return ((IInventory) tile).isUseableByPlayer(player);
	    }
	    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
			
			return null;
		}
}  