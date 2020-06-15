package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyShovel extends ItemSpade {
	protected RubyShovel() {
		super(Test.rubyShovel);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:RubyShovel");
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.RubyShovel) {
				player.addStat(CommonProxy.achievementFirstGoodTool, 1);
			}
		}
	}
}
