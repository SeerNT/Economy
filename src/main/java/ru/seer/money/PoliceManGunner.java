package ru.seer.money;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PoliceManGunner extends EntityMob implements IRangedAttackMob{
    private int angerLevel;
    
	public PoliceManGunner(World p_i1738_1_) {
		super(p_i1738_1_);
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		
		this.setCurrentItemOrArmor(0, new ItemStack(Test.Pistol));

	}
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
	/**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
    }
	@Override
	protected void applyEntityAttributes()
	{
	  super.applyEntityAttributes();
	  this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(64.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	  this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
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
                    	PoliceManGunner police = (PoliceManGunner)entity1;
                        police.becomeAngryAt(entity);
                    }
                }

                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
        }
    }
	public boolean isAIEnabled()
	{
	   return true;
	}
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
		if(angerLevel > 0) {
			EntityPistBullet entityarrow = new EntityPistBullet(this.worldObj, this, p_82196_1_, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
	        this.worldObj.spawnEntityInWorld(entityarrow);
		}
	}

}
