package seer.money.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.seer.money.Cents;
import ru.seer.money.Dollars;
import ru.seer.money.PackOfDollars;
import ru.seer.money.Test;
import ru.seer.money.Wallet;

public class SlotItemInv extends Slot
{
	public SlotItemInv(IInventory inv, int index, int xPos, int yPos)
	{
		super(inv, index, xPos, yPos);
	}

	// This is the only method we need to override so that
	// we can't place our inventory-storing Item within
	// its own inventory (thus making it permanently inaccessible)
	// as well as preventing abuse of storing backpacks within backpacks
	/**
	 * Check if the stack is a valid item for this slot.
	 */
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		// Everything returns true except an instance of our Item
		//itemstack.getItem() instanceof Dollars) || (itemstack.getItem() instanceof Cents)
		return (!(itemstack.getItem() instanceof Wallet) && ((itemstack.getItem() instanceof Dollars) || (itemstack == new ItemStack(Test.PackOfDollars))));
	}
}