package ru.seer.money;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class RubySword extends ItemSword{
	public static double achiVal = 0.0;
	public static Boolean check = false;
	protected RubySword() {
		super(Test.rubySword);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:RubySword");
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.RubySword) {
				player.addStat(CommonProxy.achievementFirstGoodTool, 1);
				if (check == false) {
					achiVal += 1.0;
				}
				check = true;
				if(RubySword.achiVal == 2.5) {
					player.addStat(CommonProxy.achievementCombatSet, 1);
				}
				
			}
		}
	}
}
