package ru.seer.money;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Dollars extends Item {
	static int counter = 0;
	protected Dollars() {
		  super();
		  this.setCreativeTab(Test.others);
		  this.setTextureName("money:Dollars");
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.Dollars) {
				player.addStat(CommonProxy.achievementFirstDollar, 1);
			}
		}
	}
}
