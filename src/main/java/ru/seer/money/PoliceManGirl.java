package ru.seer.money;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PoliceManGirl extends EntityMob {
	public PoliceManGirl(World p_i1738_1_) {
		super(p_i1738_1_);
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.setCurrentItemOrArmor(0, new ItemStack(Test.Bat));

	}
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
		this.dropItem(Test.Bat, 1);
    }
	private int angerLevel;
	 protected Entity findPlayerToAttack()
	    {
	        return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	    }
	 private void becomeAngryAt(Entity p_70835_1_)
	    {
	        this.entityToAttack = p_70835_1_;
	        this.angerLevel = 400 + this.rand.nextInt(400);
	    }
	 public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	    {
	        super.writeEntityToNBT(p_70014_1_);
	        p_70014_1_.setShort("Anger", (short)this.angerLevel);
	    }

	    /**
	     * (abstract) Protected helper method to read subclass entity data from NBT.
	     */
	    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	    {
	        super.readEntityFromNBT(p_70037_1_);
	        this.angerLevel = p_70037_1_.getShort("Anger");
	    }

	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
{
    if (this.isEntityInvulnerable())
    {
        return false;
    }
    else
    {
        Entity entity = p_70097_1_.getEntity();

        if (entity instanceof EntityPlayer)
        {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for (int i = 0; i < list.size(); ++i)
            {
                Entity entity1 = (Entity)list.get(i);

                if (entity1 instanceof EntityPigZombie)
                {
                	PoliceManGirl police = (PoliceManGirl)entity1;
                    police.becomeAngryAt(entity);
                }
            }

            this.becomeAngryAt(entity);
        }

        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }
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
		if (angerLevel > 0) {
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
        return false;
    }
	public boolean isAIEnabled()
	{
	   return true;
	}
}
