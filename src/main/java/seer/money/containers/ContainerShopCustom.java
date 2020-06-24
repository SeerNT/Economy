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
	    public ContainerShopCustom(InventoryPlayer player, ShopTileEntity testTile) {
	    tile = testTile;
	    i = 0;
	    isCreated = true;
	    }

	    @Override
	    public boolean canInteractWith(EntityPlayer player) {
	        return ((IInventory) tile).isUseableByPlayer(player);
	    }
	    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
			
			return null;
		}
}  