package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class OpalSword extends ItemSword{
	protected OpalSword() {
		super(Test.opalSword);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:OpalSword");
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.OpalSword) {
				
				((EntityPlayer) player).addStat(CommonProxy.achievementWorth, 1);
			}
		}
	}

}
