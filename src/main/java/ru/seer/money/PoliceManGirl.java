package ru.seer.money;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PoliceManGirl extends EntityMob {
	public PoliceManGirl(World p_i1738_1_) {
		super(p_i1738_1_);
		this.tasks.addTask(1, new  EntityAISwimming(this));
		this.tasks.addTask(1, new  EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 20.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		
		this.setCurrentItemOrArmor(0, new ItemStack(Test.Bat));

	}
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
		this.dropItem(Test.Bat, 1);
    }
	@Override
	protected void applyEntityAttributes()
	{
	  super.applyEntityAttributes();
	  this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
	  this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	}
	public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        if (super.attackEntityAsMob(p_70652_1_))
        {
            if (p_70652_1_ instanceof EntityLivingBase)
            {
                
            	((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));
                
            }

            return true;
        }
        else
        {
            return false;
        }
    }
	public boolean isAIEnabled()
	{
	   return true;
	}
}
