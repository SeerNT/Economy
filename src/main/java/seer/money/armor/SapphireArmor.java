package seer.money.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.seer.money.CommonProxy;
import ru.seer.money.RubySword;
import ru.seer.money.Test;

public class SapphireArmor extends ItemArmor {
	public static Boolean rc = false;
	public static Boolean rp = false;
	public static Boolean rb = false;
	public static Boolean rh = false;
	public SapphireArmor(int renderIndex, int armorType) {
	  super(Test.sapphireMat, renderIndex, armorType);
	  this.setCreativeTab(Test.combat);
	  this.setMaxStackSize(1);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if (this.armorType == 2) {
			return "money:textures/models/armor/sapphire_layer_2.png";
		}
		return "money:textures/models/armor/sapphire_layer_1.png";
	  
	}
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		/*
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.RubyChestplate) {
				if (RubySword.achiVal < 2.5 && rc == false) {
					RubySword.achiVal += 0.5;
					rc = true;
				}
				if(RubySword.achiVal == 2.5 && rc == false) {
					player.addStat(CommonProxy.achievementCombatSet, 1);
				}
				
			}
			if(item.getItem() == Test.RubyHelmet) {
				if (RubySword.achiVal < 2.5 && rh == false) {
					RubySword.achiVal += 0.5;
					rh = true;
				}
				if(RubySword.achiVal == 2.5 && rh == false) {
					player.addStat(CommonProxy.achievementCombatSet, 1);
				}
				
			}
			if(item.getItem() == Test.RubyPants) {
				if (RubySword.achiVal < 2.5 && rp == false) {
					RubySword.achiVal += 0.5;
					rp = true;
				}
				if(RubySword.achiVal == 2.5 && rp == false) {
					player.addStat(CommonProxy.achievementCombatSet, 1);
				}
				
			}
			if(item.getItem() == Test.RubyBoots) {
				if (RubySword.achiVal < 2.5 && rb == false) {
					RubySword.achiVal += 0.5;
					rb = true;
				}
				if(RubySword.achiVal == 2.5 && rb == false) {
					player.addStat(CommonProxy.achievementCombatSet, 1);
				}
				
			}
		}
	*/
	}
}
