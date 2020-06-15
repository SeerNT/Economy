package ru.seer.money;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Pistol extends Item {
	 public Pistol()
	    {
	        setMaxStackSize(1);
	        setMaxDamage(50);
	        this.setCreativeTab(Test.combat);
	        this.setUnlocalizedName("pistol");
			this.setTextureName("money:pistol");
	    }
	    @Override
	    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	    {
	        if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(Test.pistBullet))
	        {
	        	itemStack.damageItem(1, player);
	            player.swingItem();
	            //world.playSoundAtEntity(player, "money:pistol", 0.5F, 1.0F);
	            if (!world.isRemote)
	            {
	                world.spawnEntityInWorld(new EntityPistBullet(world, player));
	            }
	        }
	        return itemStack;
	    }
}
