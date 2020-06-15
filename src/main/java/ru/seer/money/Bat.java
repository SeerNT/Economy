package ru.seer.money;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Bat extends ItemSword{
	protected Bat() {
		super(Test.bat);
		this.setCreativeTab(Test.combat);
		this.setTextureName("money:bat");
	}
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));
        return false;
    }
}
