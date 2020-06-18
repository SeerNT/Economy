package ru.seer.money;

<<<<<<< HEAD
import net.minecraft.item.ItemSword;
=======
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
>>>>>>> Recovery,achievments and other fixes

public class OpalSword extends ItemSword{
	protected OpalSword() {
		super(Test.opalSword);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:OpalSword");
	}
<<<<<<< HEAD
=======
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			if(item.getItem() == Test.OpalSword) {
				
				((EntityPlayer) player).addStat(CommonProxy.achievementWorth, 1);
			}
		}
	}

>>>>>>> Recovery,achievments and other fixes
}
