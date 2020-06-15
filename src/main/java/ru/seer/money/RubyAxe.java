package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyAxe extends ItemAxe {

	protected RubyAxe() {
		super(Test.rubyAxe);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:RubyAxe");
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.RubyAxe) {
				player.addStat(CommonProxy.achievementFirstGoodTool, 1);
			}
		}
	}

}