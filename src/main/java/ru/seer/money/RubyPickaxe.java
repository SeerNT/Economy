package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyPickaxe extends ItemPickaxe {

	protected RubyPickaxe() {
		super(Test.ruby);
		this.setCreativeTab(Test.tools);
		this.setTextureName("money:RubyPickaxe");
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.RubyPickaxe) {
				player.addStat(CommonProxy.achievementFirstGoodTool, 1);
			}
		}
	}

}